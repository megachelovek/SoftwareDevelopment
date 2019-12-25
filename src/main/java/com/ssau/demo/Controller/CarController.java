package com.ssau.demo.Controller;

import com.ssau.demo.DAO.CarDAO;
import com.ssau.demo.Entity.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@CrossOrigin
@RestController
@RequestMapping("/car")
public class CarController  {

  @Autowired
  private CarDAO CarDAO;

  @GetMapping(value = "/getAll")
  public List<CarEntity> getAll()  {
    return CarDAO.getAll();
  }

  @GetMapping(value = "{id}")
  public Object findById(@PathVariable int id) {
    return  CarDAO.findById(id);
  }

  @DeleteMapping("{id}")
  public void remove(@PathVariable int id) {
    CarDAO.remove(CarDAO.findById(id));
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST,consumes = APPLICATION_JSON_UTF8_VALUE)
  public void create(@RequestBody CarEntity entity) {
    CarDAO.create(entity);
  }

  @RequestMapping(value = "/edit", method = RequestMethod.PUT,consumes = APPLICATION_JSON_UTF8_VALUE)
  public void edit(@RequestBody CarEntity entity) {
    CarDAO.edit(entity);
  }

}
