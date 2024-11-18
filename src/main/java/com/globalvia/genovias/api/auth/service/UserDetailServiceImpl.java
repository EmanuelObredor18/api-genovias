package com.globalvia.genovias.api.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.globalvia.genovias.api.auth.dto.AuthCreateUserRequest;
import com.globalvia.genovias.api.auth.dto.AuthLoginRequest;
import com.globalvia.genovias.api.auth.dto.AuthResponse;
import com.globalvia.genovias.api.auth.model.RoleEntity;
import com.globalvia.genovias.api.auth.model.UserEntity;
import com.globalvia.genovias.api.auth.repository.RoleRepository;
import com.globalvia.genovias.api.auth.repository.UserRepository;
import com.globalvia.genovias.api.auth.util.JwtUtils;
import com.globalvia.genovias.api.models.dto.ResponsableDTO;
import com.globalvia.genovias.api.models.entities.Responsable;
import com.globalvia.genovias.api.services.base.interfaces.BaseService;

import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BaseService<Responsable, ResponsableDTO, Short> responsableService;

    @Override
    public UserDetails loadUserByUsername(String username) {

        UserEntity userEntity = userRepository.findUserEntityByUsername(username).orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe."));

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        userEntity.getRoles().forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleName()))));

        return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.isEnabled(), userEntity.isAccountNoExpired(), userEntity.isCredentialNoExpired(), userEntity.isAccountNoLocked(), authorityList);
    }

    @Transactional
    public AuthResponse createUser(AuthCreateUserRequest createRoleRequest) {

        String username = createRoleRequest.username();
        String password = createRoleRequest.password();
        List<String> rolesRequest = createRoleRequest.roleRequest().roleListName();
    
        // Obtener roles desde la base de datos
        Set<RoleEntity> roleEntityList = roleRepository.findAllByRoleNameIn(rolesRequest).stream().collect(Collectors.toSet());
    
        if (roleEntityList.isEmpty()) {
            throw new IllegalArgumentException("The roles specified do not exist.");
        }
    
        // Crear la entidad UserEntity
        UserEntity userEntity = UserEntity.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .roles(roleEntityList)
                .isEnabled(true)
                .accountNoLocked(true)
                .accountNoExpired(true)
                .credentialNoExpired(true)
                .build();
    
        // Guardar el usuario en la base de datos
        UserEntity userSaved = userRepository.save(userEntity);
    
        // Crear las autoridades (roles)
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        userSaved.getRoles().forEach(role -> 
            authorities.add(new SimpleGrantedAuthority("ROLE_".concat(role.getRoleName())))
        );
    
        // Crear un Responsable si el usuario no tiene el rol "ADMIN"
        if (userSaved.getRoles().stream().noneMatch(role -> role.getRoleName().equals("ADMIN"))) {
            responsableService.postEntity(
                ResponsableDTO.builder()
                    .nombre(createRoleRequest.nombre())
                    .apellido(createRoleRequest.apellido())
                    .userEntityId(userSaved.getId())
                    .build()
            );
        }
    
        // Crear UserDetails para el usuario autenticado
        UserDetails userDetails = new User(
                userSaved.getUsername(),
                userSaved.getPassword(),
                userSaved.isEnabled(),
                userSaved.isAccountNoExpired(),
                userSaved.isCredentialNoExpired(),
                userSaved.isAccountNoLocked(),
                authorities
        );
    
        // Crear Authentication con UserDetails
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
    
        // Generar el token
        String accessToken = jwtUtils.createToken(authentication);
    
        // Crear y retornar la respuesta
        return new AuthResponse(username, "User created successfully", accessToken, true);
    }

    public AuthResponse loginUser(AuthLoginRequest authLoginRequest) {

        String username = authLoginRequest.username();
        String password = authLoginRequest.password();

        Authentication authentication = this.authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtils.createToken(authentication);
        AuthResponse authResponse = new AuthResponse(username, "User loged succesfully", accessToken, true);
        return authResponse;
    }

    public Authentication authenticate(String username, String password) {
        UserDetails userDetails = this.loadUserByUsername(username);

        if (userDetails == null) {
            throw new BadCredentialsException(String.format("Invalid username or password"));
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Incorrect Password");
        }

        return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
    }
}