package com.ssau.demo.Controller;

import com.ssau.demo.DAO.CarDAO;
import com.ssau.demo.Entity.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @PostMapping
  public void create(@RequestBody CarEntity entity) {
    CarDAO.create(entity);
  }

  @PutMapping
  public void edit(@RequestBody CarEntity entity) {
    CarDAO.edit(entity);
  }

}
