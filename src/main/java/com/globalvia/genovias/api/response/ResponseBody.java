package com.globalvia.genovias.api.response;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ResponseBody {
  
  private final ResponseStatus status;
  private final int codeStatus;
  private final String details; 

}
