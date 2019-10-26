package com.ssau.demo.Controller;

import com.ssau.demo.DAO.CarDAO;
import com.ssau.demo.Entity.CarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.util.MimeTypeUtils.APPLICATION_XML_VALUE;

@CrossOrigin
@RestController
@RequestMapping("/car")
public class CarController  {

  @Autowired
  private CarDAO carDAO;

  @GetMapping(produces = { APPLICATION_JSON_VALUE,
          APPLICATION_XML_VALUE})
  public Object getAll()  {
    return  new CarXSL(carDAO.getAll());
  }

  @GetMapping(value = "{id}", produces = { APPLICATION_JSON_VALUE,
          APPLICATION_XML_VALUE})
  public Object findById(@PathVariable int id) {
    return  carDAO.findById(id);
  }

  @DeleteMapping("{id}")
  public void remove(@PathVariable int id) {
    carDAO.remove(carDAO.findById(id));
  }

  @PostMapping
  public void create(@RequestBody CarEntity entity) {
    carDAO.create(entity);
  }

  @PutMapping
  public void edit(@RequestBody CarEntity entity) {
    carDAO.edit(entity);
  }

}
