package com.ssau.demo.Controller;

import com.ssau.demo.DAO.CarshopDAO;
import com.ssau.demo.Entity.CarshopEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/carshop")
public class CarshopController {

  @Autowired
  private CarshopDAO carshopDAO;

  @GetMapping(value = "/getAll")
  public List<CarshopEntity> getAll()  {
    return carshopDAO.getAll();
  }

  @GetMapping(value = "{id}")
  public Object findById(@PathVariable int id) {
    return  carshopDAO.findById(id);
  }

  @DeleteMapping("{id}")
  public void remove(@PathVariable int id) {
    carshopDAO.remove(carshopDAO.findById(id));
  }

  @PostMapping
  public void create(@RequestBody CarshopEntity entity) {
    carshopDAO.create(entity);
  }

  @PutMapping
  public void edit(@RequestBody CarshopEntity entity) {
    carshopDAO.edit(entity);
  }

}
