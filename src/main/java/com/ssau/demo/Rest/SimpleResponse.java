package com.ssau.demo.Rest;

public class SimpleResponse extends Response<Object> {

  public SimpleResponse(int code) {
    super(code, null, "");
  }

  public SimpleResponse(int code, String message) {
    super(code, null, message);
  }
}