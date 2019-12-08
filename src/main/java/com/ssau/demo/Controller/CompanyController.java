package com.ssau.demo.Controller;

import com.ssau.demo.DAO.CompanyDAO;
import com.ssau.demo.Entity.CompanyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/company")
public class CompanyController {

  @Autowired
  private CompanyDAO companyDAO;

  @GetMapping(value = "/getAll")
  public List<CompanyEntity> getAll()  {
    return companyDAO.getAll();
  }

  @GetMapping(value = "{id}")
  public Object findById(@PathVariable int id) {
    return  companyDAO.findById(id);
  }

  @DeleteMapping("{id}")
  public void remove(@PathVariable int id) {
    companyDAO.remove(companyDAO.findById(id));
  }

  @PostMapping
  public void create(@RequestBody CompanyEntity entity) {
    companyDAO.create(entity);
  }

  @PutMapping
  public void edit(@RequestBody CompanyEntity entity) {
    companyDAO.edit(entity);
  }

}
