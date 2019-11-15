package com.ssau.demo.Controller;

import com.ssau.demo.DAO.CarDAO;
import com.ssau.demo.DAO.CarpartDAO;
import com.ssau.demo.Entity.CarEntity;
import com.ssau.demo.Entity.CarpartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.util.MimeTypeUtils.APPLICATION_XML_VALUE;

@CrossOrigin
@RestController
@RequestMapping("/carpart")
public class CarpartController {

  @Autowired
  private CarpartDAO carpartDAO;

  @GetMapping(value = "/getcarpart")
  public List<CarpartEntity> getAll()  {
    return carpartDAO.getAll();
  }

  @GetMapping(value = "{id}", produces = { APPLICATION_JSON_VALUE,
          APPLICATION_XML_VALUE})
  public Object findById(@PathVariable int id) {
    return  carpartDAO.findById(id);
  }

  @DeleteMapping("{id}")
  public void remove(@PathVariable int id) {
    carpartDAO.remove(carpartDAO.findById(id));
  }

  @PostMapping
  public void create(@RequestBody CarpartEntity entity) {
    carpartDAO.create(entity);
  }

  @PutMapping
  public void edit(@RequestBody CarpartEntity entity) {
    carpartDAO.edit(entity);
  }

}
