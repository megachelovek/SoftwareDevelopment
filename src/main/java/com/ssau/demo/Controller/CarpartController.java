package com.ssau.demo.Controller;

import com.ssau.demo.DAO.CarpartDAO;
import com.ssau.demo.Entity.CarpartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@CrossOrigin
@RestController
@RequestMapping("/carpart")
public class CarpartController {

  @Autowired
  private CarpartDAO carpartDAO;

  @GetMapping(value = "/getAll")
  public List<CarpartEntity> getAll()  {
    return carpartDAO.getAll();
  }

  @GetMapping(value = "{id}")
  public Object findById(@PathVariable int id) {
    return  carpartDAO.findById(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void remove(@PathVariable int id) {
    carpartDAO.remove(carpartDAO.findById(id));
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST,consumes = APPLICATION_JSON_UTF8_VALUE)
  public void create(@RequestBody CarpartEntity entity) {
    carpartDAO.create(entity);
  }

  @RequestMapping(value = "/edit", method = RequestMethod.PUT,consumes = APPLICATION_JSON_UTF8_VALUE)
  public void edit(@RequestBody CarpartEntity entity) {
    carpartDAO.edit(entity);
  }

}
