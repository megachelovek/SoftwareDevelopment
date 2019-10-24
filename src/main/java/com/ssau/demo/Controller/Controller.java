package com.ssau.demo.Controller;

import com.ssau.demo.Rest.Request;
import com.ssau.demo.Rest.Response;
import com.ssau.demo.Rest.SimpleResponse;

import java.util.List;

public interface Controller<T> {
  Response<List<T>> getAll(String sort, String search);
  Response<T> get(Long id);
  SimpleResponse add(Request<T> request);
  SimpleResponse remove(Long id);
  SimpleResponse update(Request<T> request);
}
