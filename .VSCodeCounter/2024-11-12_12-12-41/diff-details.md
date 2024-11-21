# Diff Details

Date : 2024-11-12 12:12:41

Directory c:\\Users\\PC REPORTES\\Desktop\\Spring\\api

Total : 82 files,  1418 codes, 50 comments, 429 blanks, all 1897 lines

[Summary](results.md) / [Details](details.md) / [Diff Summary](diff.md) / Diff Details

## Files
| filename | language | code | comment | blank | total |
| :--- | :--- | ---: | ---: | ---: | ---: |
| [pom.xml](/pom.xml) | XML | 9 | -4 | 2 | 7 |
| [src/main/java/com/globalvia/genovias/api/ApiApplication.java](/src/main/java/com/globalvia/genovias/api/ApiApplication.java) | Java | 0 | 0 | -1 | -1 |
| [src/main/java/com/globalvia/genovias/api/auth/config/filters/JwtTokenValidator.java](/src/main/java/com/globalvia/genovias/api/auth/config/filters/JwtTokenValidator.java) | Java | 42 | 0 | 14 | 56 |
| [src/main/java/com/globalvia/genovias/api/auth/config/security/SecurityConfig.java](/src/main/java/com/globalvia/genovias/api/auth/config/security/SecurityConfig.java) | Java | 55 | 0 | 11 | 66 |
| [src/main/java/com/globalvia/genovias/api/auth/controller/AuthController.java](/src/main/java/com/globalvia/genovias/api/auth/controller/AuthController.java) | Java | 27 | 0 | 12 | 39 |
| [src/main/java/com/globalvia/genovias/api/auth/dto/AuthCreateRoleRequest.java](/src/main/java/com/globalvia/genovias/api/auth/dto/AuthCreateRoleRequest.java) | Java | 8 | 0 | 3 | 11 |
| [src/main/java/com/globalvia/genovias/api/auth/dto/AuthCreateUserRequest.java](/src/main/java/com/globalvia/genovias/api/auth/dto/AuthCreateUserRequest.java) | Java | 9 | 0 | 2 | 11 |
| [src/main/java/com/globalvia/genovias/api/auth/dto/AuthLoginRequest.java](/src/main/java/com/globalvia/genovias/api/auth/dto/AuthLoginRequest.java) | Java | 5 | 0 | 2 | 7 |
| [src/main/java/com/globalvia/genovias/api/auth/dto/AuthResponse.java](/src/main/java/com/globalvia/genovias/api/auth/dto/AuthResponse.java) | Java | 9 | 0 | 2 | 11 |
| [src/main/java/com/globalvia/genovias/api/auth/model/RoleEntity.java](/src/main/java/com/globalvia/genovias/api/auth/model/RoleEntity.java) | Java | 26 | 0 | 5 | 31 |
| [src/main/java/com/globalvia/genovias/api/auth/model/UserEntity.java](/src/main/java/com/globalvia/genovias/api/auth/model/UserEntity.java) | Java | 32 | 0 | 11 | 43 |
| [src/main/java/com/globalvia/genovias/api/auth/repository/RoleRepository.java](/src/main/java/com/globalvia/genovias/api/auth/repository/RoleRepository.java) | Java | 7 | 0 | 5 | 12 |
| [src/main/java/com/globalvia/genovias/api/auth/repository/UserRepository.java](/src/main/java/com/globalvia/genovias/api/auth/repository/UserRepository.java) | Java | 9 | 0 | 7 | 16 |
| [src/main/java/com/globalvia/genovias/api/auth/service/UserDetailServiceImpl.java](/src/main/java/com/globalvia/genovias/api/auth/service/UserDetailServiceImpl.java) | Java | 89 | 1 | 35 | 125 |
| [src/main/java/com/globalvia/genovias/api/auth/util/JwtUtils.java](/src/main/java/com/globalvia/genovias/api/auth/util/JwtUtils.java) | Java | 61 | 0 | 15 | 76 |
| [src/main/java/com/globalvia/genovias/api/config/BaseServiceConfig.java](/src/main/java/com/globalvia/genovias/api/config/BaseServiceConfig.java) | Java | 68 | 2 | 9 | 79 |
| [src/main/java/com/globalvia/genovias/api/config/EntityFactoryConfig.java](/src/main/java/com/globalvia/genovias/api/config/EntityFactoryConfig.java) | Java | 54 | 0 | 8 | 62 |
| [src/main/java/com/globalvia/genovias/api/config/ReporteValidatorConfig.java](/src/main/java/com/globalvia/genovias/api/config/ReporteValidatorConfig.java) | Java | 37 | 0 | 8 | 45 |
| [src/main/java/com/globalvia/genovias/api/config/ValidatorConfig.java](/src/main/java/com/globalvia/genovias/api/config/ValidatorConfig.java) | Java | 11 | 0 | 6 | 17 |
| [src/main/java/com/globalvia/genovias/api/controller/BaseController.java](/src/main/java/com/globalvia/genovias/api/controller/BaseController.java) | Java | 12 | 0 | 2 | 14 |
| [src/main/java/com/globalvia/genovias/api/controller/ReporteAuxilioVialController.java](/src/main/java/com/globalvia/genovias/api/controller/ReporteAuxilioVialController.java) | Java | 13 | 0 | 6 | 19 |
| [src/main/java/com/globalvia/genovias/api/controller/ReporteDiarioController.java](/src/main/java/com/globalvia/genovias/api/controller/ReporteDiarioController.java) | Java | 14 | 0 | 6 | 20 |
| [src/main/java/com/globalvia/genovias/api/controller/ReporteServicioGruaController.java](/src/main/java/com/globalvia/genovias/api/controller/ReporteServicioGruaController.java) | Java | 13 | 0 | 6 | 19 |
| [src/main/java/com/globalvia/genovias/api/handler/GlobalExceptionHandler.java](/src/main/java/com/globalvia/genovias/api/handler/GlobalExceptionHandler.java) | Java | 42 | 1 | 11 | 54 |
| [src/main/java/com/globalvia/genovias/api/models/base/Copyable.java](/src/main/java/com/globalvia/genovias/api/models/base/Copyable.java) | Java | 1 | 20 | 2 | 23 |
| [src/main/java/com/globalvia/genovias/api/models/base/Dateable.java](/src/main/java/com/globalvia/genovias/api/models/base/Dateable.java) | Java | 5 | 0 | 3 | 8 |
| [src/main/java/com/globalvia/genovias/api/models/base/Identificable.java](/src/main/java/com/globalvia/genovias/api/models/base/Identificable.java) | Java | 0 | 16 | -1 | 15 |
| [src/main/java/com/globalvia/genovias/api/models/dto/CamionetaDTO.java](/src/main/java/com/globalvia/genovias/api/models/dto/CamionetaDTO.java) | Java | 18 | 0 | 8 | 26 |
| [src/main/java/com/globalvia/genovias/api/models/dto/DireccionDTO.java](/src/main/java/com/globalvia/genovias/api/models/dto/DireccionDTO.java) | Java | 16 | 0 | 8 | 24 |
| [src/main/java/com/globalvia/genovias/api/models/dto/ReporteAccidenteDTO.java](/src/main/java/com/globalvia/genovias/api/models/dto/ReporteAccidenteDTO.java) | Java | 5 | 0 | 2 | 7 |
| [src/main/java/com/globalvia/genovias/api/models/dto/ReporteAuxilioVialDTO.java](/src/main/java/com/globalvia/genovias/api/models/dto/ReporteAuxilioVialDTO.java) | Java | 29 | 0 | 12 | 41 |
| [src/main/java/com/globalvia/genovias/api/models/dto/ReporteDiarioDTO.java](/src/main/java/com/globalvia/genovias/api/models/dto/ReporteDiarioDTO.java) | Java | 36 | 0 | 15 | 51 |
| [src/main/java/com/globalvia/genovias/api/models/dto/ReporteServicioAmbulanciaDTO.java](/src/main/java/com/globalvia/genovias/api/models/dto/ReporteServicioAmbulanciaDTO.java) | Java | 22 | 0 | 10 | 32 |
| [src/main/java/com/globalvia/genovias/api/models/dto/ReporteServicioGruaDTO.java](/src/main/java/com/globalvia/genovias/api/models/dto/ReporteServicioGruaDTO.java) | Java | 24 | 0 | 10 | 34 |
| [src/main/java/com/globalvia/genovias/api/models/dto/ResponsableDTO.java](/src/main/java/com/globalvia/genovias/api/models/dto/ResponsableDTO.java) | Java | 15 | 0 | 7 | 22 |
| [src/main/java/com/globalvia/genovias/api/models/dto/TipoAccidenteDTO.java](/src/main/java/com/globalvia/genovias/api/models/dto/TipoAccidenteDTO.java) | Java | 14 | 0 | 6 | 20 |
| [src/main/java/com/globalvia/genovias/api/models/dto/UsuarioConductorDTO.java](/src/main/java/com/globalvia/genovias/api/models/dto/UsuarioConductorDTO.java) | Java | 1 | 0 | 1 | 2 |
| [src/main/java/com/globalvia/genovias/api/models/entities/Camioneta.java](/src/main/java/com/globalvia/genovias/api/models/entities/Camioneta.java) | Java | 39 | 0 | 10 | 49 |
| [src/main/java/com/globalvia/genovias/api/models/entities/Categoria.java](/src/main/java/com/globalvia/genovias/api/models/entities/Categoria.java) | Java | 4 | 0 | 2 | 6 |
| [src/main/java/com/globalvia/genovias/api/models/entities/Direccion.java](/src/main/java/com/globalvia/genovias/api/models/entities/Direccion.java) | Java | 14 | 0 | 2 | 16 |
| [src/main/java/com/globalvia/genovias/api/models/entities/PuntoReferencia.java](/src/main/java/com/globalvia/genovias/api/models/entities/PuntoReferencia.java) | Java | 12 | 0 | 2 | 14 |
| [src/main/java/com/globalvia/genovias/api/models/entities/ReporteAccidente.java](/src/main/java/com/globalvia/genovias/api/models/entities/ReporteAccidente.java) | Java | 12 | 0 | 3 | 15 |
| [src/main/java/com/globalvia/genovias/api/models/entities/ReporteAuxilioVial.java](/src/main/java/com/globalvia/genovias/api/models/entities/ReporteAuxilioVial.java) | Java | 53 | 0 | 13 | 66 |
| [src/main/java/com/globalvia/genovias/api/models/entities/ReporteDiario.java](/src/main/java/com/globalvia/genovias/api/models/entities/ReporteDiario.java) | Java | 62 | 0 | 16 | 78 |
| [src/main/java/com/globalvia/genovias/api/models/entities/ReporteServicioAmbulancia.java](/src/main/java/com/globalvia/genovias/api/models/entities/ReporteServicioAmbulancia.java) | Java | 45 | 0 | 10 | 55 |
| [src/main/java/com/globalvia/genovias/api/models/entities/ReporteServicioGrua.java](/src/main/java/com/globalvia/genovias/api/models/entities/ReporteServicioGrua.java) | Java | 45 | 0 | 11 | 56 |
| [src/main/java/com/globalvia/genovias/api/models/entities/Responsable.java](/src/main/java/com/globalvia/genovias/api/models/entities/Responsable.java) | Java | 40 | 0 | 10 | 50 |
| [src/main/java/com/globalvia/genovias/api/models/entities/TipoAccidente.java](/src/main/java/com/globalvia/genovias/api/models/entities/TipoAccidente.java) | Java | 37 | 0 | 9 | 46 |
| [src/main/java/com/globalvia/genovias/api/models/entities/UsuarioConductor.java](/src/main/java/com/globalvia/genovias/api/models/entities/UsuarioConductor.java) | Java | 4 | 0 | 1 | 5 |
| [src/main/java/com/globalvia/genovias/api/models/entities/Vehiculo.java](/src/main/java/com/globalvia/genovias/api/models/entities/Vehiculo.java) | Java | 9 | 0 | 2 | 11 |
| [src/main/java/com/globalvia/genovias/api/repositories/CamionetaRepository.java](/src/main/java/com/globalvia/genovias/api/repositories/CamionetaRepository.java) | Java | 5 | 0 | 5 | 10 |
| [src/main/java/com/globalvia/genovias/api/repositories/DireccionRepository.java](/src/main/java/com/globalvia/genovias/api/repositories/DireccionRepository.java) | Java | 5 | 0 | 5 | 10 |
| [src/main/java/com/globalvia/genovias/api/repositories/ReporteAccidenteRepository.java](/src/main/java/com/globalvia/genovias/api/repositories/ReporteAccidenteRepository.java) | Java | -3 | 0 | -1 | -4 |
| [src/main/java/com/globalvia/genovias/api/repositories/ReporteAuxilioVialRepository.java](/src/main/java/com/globalvia/genovias/api/repositories/ReporteAuxilioVialRepository.java) | Java | 4 | 0 | 4 | 8 |
| [src/main/java/com/globalvia/genovias/api/repositories/ReporteDiarioRepository.java](/src/main/java/com/globalvia/genovias/api/repositories/ReporteDiarioRepository.java) | Java | 4 | 0 | 4 | 8 |
| [src/main/java/com/globalvia/genovias/api/repositories/ReporteRepository.java](/src/main/java/com/globalvia/genovias/api/repositories/ReporteRepository.java) | Java | 8 | 0 | 4 | 12 |
| [src/main/java/com/globalvia/genovias/api/repositories/ReporteServicioAmbulanciaRepository.java](/src/main/java/com/globalvia/genovias/api/repositories/ReporteServicioAmbulanciaRepository.java) | Java | 4 | 0 | 4 | 8 |
| [src/main/java/com/globalvia/genovias/api/repositories/ReporteServicioGruaRepository.java](/src/main/java/com/globalvia/genovias/api/repositories/ReporteServicioGruaRepository.java) | Java | 4 | 0 | 4 | 8 |
| [src/main/java/com/globalvia/genovias/api/repositories/ResponsableRepository.java](/src/main/java/com/globalvia/genovias/api/repositories/ResponsableRepository.java) | Java | 5 | 0 | 5 | 10 |
| [src/main/java/com/globalvia/genovias/api/repositories/TipoAccidenteRepository.java](/src/main/java/com/globalvia/genovias/api/repositories/TipoAccidenteRepository.java) | Java | 5 | 0 | 5 | 10 |
| [src/main/java/com/globalvia/genovias/api/services/BaseService.java](/src/main/java/com/globalvia/genovias/api/services/BaseService.java) | Java | -59 | 0 | -28 | -87 |
| [src/main/java/com/globalvia/genovias/api/services/ReporteDiarioService.java](/src/main/java/com/globalvia/genovias/api/services/ReporteDiarioService.java) | Java | 15 | 0 | 6 | 21 |
| [src/main/java/com/globalvia/genovias/api/services/UsuarioConductorService.java](/src/main/java/com/globalvia/genovias/api/services/UsuarioConductorService.java) | Java | -16 | 0 | -11 | -27 |
| [src/main/java/com/globalvia/genovias/api/services/VehiculoService.java](/src/main/java/com/globalvia/genovias/api/services/VehiculoService.java) | Java | -18 | 0 | -9 | -27 |
| [src/main/java/com/globalvia/genovias/api/services/base/BaseCrudService.java](/src/main/java/com/globalvia/genovias/api/services/base/BaseCrudService.java) | Java | 102 | 12 | 29 | 143 |
| [src/main/java/com/globalvia/genovias/api/services/base/ReporteBaseCrudService.java](/src/main/java/com/globalvia/genovias/api/services/base/ReporteBaseCrudService.java) | Java | 26 | 0 | 9 | 35 |
| [src/main/java/com/globalvia/genovias/api/services/base/interfaces/BaseService.java](/src/main/java/com/globalvia/genovias/api/services/base/interfaces/BaseService.java) | Java | 22 | 0 | 11 | 33 |
| [src/main/java/com/globalvia/genovias/api/services/dto/DTOProcessService.java](/src/main/java/com/globalvia/genovias/api/services/dto/DTOProcessService.java) | Java | 1 | 0 | -1 | 0 |
| [src/main/java/com/globalvia/genovias/api/services/dto/ReportServicioGruaDTOProcess.java](/src/main/java/com/globalvia/genovias/api/services/dto/ReportServicioGruaDTOProcess.java) | Java | 21 | 0 | 8 | 29 |
| [src/main/java/com/globalvia/genovias/api/services/dto/ReporteAccidenteDTOProcess.java](/src/main/java/com/globalvia/genovias/api/services/dto/ReporteAccidenteDTOProcess.java) | Java | 16 | 0 | -1 | 15 |
| [src/main/java/com/globalvia/genovias/api/services/dto/ReporteAuxilioVialDTOService.java](/src/main/java/com/globalvia/genovias/api/services/dto/ReporteAuxilioVialDTOService.java) | Java | 28 | 0 | 13 | 41 |
| [src/main/java/com/globalvia/genovias/api/services/dto/ReporteDiarioDTOProcess.java](/src/main/java/com/globalvia/genovias/api/services/dto/ReporteDiarioDTOProcess.java) | Java | 29 | 0 | 14 | 43 |
| [src/main/java/com/globalvia/genovias/api/services/dto/ReporteServicioAmbulanciaDTOProcess.java](/src/main/java/com/globalvia/genovias/api/services/dto/ReporteServicioAmbulanciaDTOProcess.java) | Java | 21 | 0 | 9 | 30 |
| [src/main/java/com/globalvia/genovias/api/services/dto/VehiculoDTOProcess.java](/src/main/java/com/globalvia/genovias/api/services/dto/VehiculoDTOProcess.java) | Java | 1 | 0 | 0 | 1 |
| [src/main/java/com/globalvia/genovias/api/validator/ReporteAccidenteValidator.java](/src/main/java/com/globalvia/genovias/api/validator/ReporteAccidenteValidator.java) | Java | -22 | 0 | -11 | -33 |
| [src/main/java/com/globalvia/genovias/api/validator/UsuarioConductorValidator.java](/src/main/java/com/globalvia/genovias/api/validator/UsuarioConductorValidator.java) | Java | -10 | 0 | -6 | -16 |
| [src/main/java/com/globalvia/genovias/api/validator/Validator.java](/src/main/java/com/globalvia/genovias/api/validator/Validator.java) | Java | -26 | 0 | -19 | -45 |
| [src/main/java/com/globalvia/genovias/api/validator/VehiculoValidator.java](/src/main/java/com/globalvia/genovias/api/validator/VehiculoValidator.java) | Java | -10 | 0 | -6 | -16 |
| [src/main/java/com/globalvia/genovias/api/validator/base/ReporteValidator.java](/src/main/java/com/globalvia/genovias/api/validator/base/ReporteValidator.java) | Java | 19 | 1 | 9 | 29 |
| [src/main/java/com/globalvia/genovias/api/validator/base/Validator.java](/src/main/java/com/globalvia/genovias/api/validator/base/Validator.java) | Java | 16 | 1 | 8 | 25 |
| [src/main/java/com/globalvia/genovias/api/validator/base/VoidCallback.java](/src/main/java/com/globalvia/genovias/api/validator/base/VoidCallback.java) | Java | 5 | 0 | 4 | 9 |
| [src/main/resources/application.properties](/src/main/resources/application.properties) | Java Properties | 2 | 0 | 1 | 3 |

[Summary](results.md) / [Details](details.md) / [Diff Summary](diff.md) / Diff Details