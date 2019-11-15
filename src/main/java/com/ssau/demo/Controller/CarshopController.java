package com.ssau.demo.Controller;

import com.ssau.demo.DAO.CarDAO;
import com.ssau.demo.DAO.CarshopDAO;
import com.ssau.demo.Entity.CarEntity;
import com.ssau.demo.Entity.CarshopEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.util.MimeTypeUtils.APPLICATION_XML_VALUE;

@CrossOrigin
@RestController
@RequestMapping("/carshop")
public class CarshopController {

  @Autowired
  private CarshopDAO carshopDAO;

  @GetMapping(value = "/getshop")
  public List<CarshopEntity> getAll()  {
    return carshopDAO.getAll();
  }

  @GetMapping(value = "{id}", produces = { APPLICATION_JSON_VALUE,
          APPLICATION_XML_VALUE})
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
