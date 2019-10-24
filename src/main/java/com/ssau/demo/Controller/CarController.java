package com.ssau.demo.Controller;

import com.ssau.demo.InterfaceCrudRepository.CarRepository;
import com.ssau.demo.Model.CarEntity;
import com.ssau.demo.Rest.Request;
import com.ssau.demo.Rest.Response;
import com.ssau.demo.Rest.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/car")
public class CarController implements Controller<CarEntity> {
  public static final String SORT_PROPERTY = "name";
  private CarRepository repository;

  @Autowired
  public CarController(CarRepository repository) {
    this.repository = repository;
  }

  public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
    return null;
  }

  @Override
  public Response<List<CarEntity>> getAll(String sort, String search) {
    return null;
  }

  @Override
  public Response<CarEntity> get(Long id) {
    return null;
  }

  @Override
  public SimpleResponse add(Request<CarEntity> request) {
    return null;
  }

  @Override
  public SimpleResponse remove(Long id) {
    return null;
  }

  @Override
  public SimpleResponse update(Request<CarEntity> request) {
    return null;
  }
}
