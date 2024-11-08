package com.globalvia.genovias.api.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v0/auth")
public class AuthController {
  
  @PostMapping("/login")
  public String postMethodName(@RequestBody String entity) {
      
      return entity;
  }
  

}
