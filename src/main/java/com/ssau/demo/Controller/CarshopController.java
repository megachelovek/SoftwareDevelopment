package com.ssau.demo.Controller;

import com.ssau.demo.DAO.CarshopDAO;
import com.ssau.demo.Entity.CarshopEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

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

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void remove(@PathVariable int id) {
    carshopDAO.remove(carshopDAO.findById(id));
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST,consumes = APPLICATION_JSON_UTF8_VALUE)
  public void create(@RequestBody CarshopEntity entity) {
    carshopDAO.create(entity);
  }

  @RequestMapping(value = "/edit", method = RequestMethod.PUT,consumes = APPLICATION_JSON_UTF8_VALUE)
  public void edit(@RequestBody CarshopEntity entity) {
    carshopDAO.edit(entity);
  }

}
