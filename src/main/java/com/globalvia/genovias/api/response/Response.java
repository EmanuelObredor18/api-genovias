package com.globalvia.genovias.api.response;

import org.springframework.http.HttpStatus;

import com.globalvia.genovias.api.response.enums.Estado;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class Response {
  
  protected HttpStatus codeStatus;
  
  protected Estado status;
  
  protected String mensaje;
  
}
