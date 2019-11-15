package com.ssau.demo.Controller;

import com.ssau.demo.DAO.CarshopDAO;
import com.ssau.demo.DAO.CompanyDAO;
import com.ssau.demo.Entity.CarshopEntity;
import com.ssau.demo.Entity.CompanyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.util.MimeTypeUtils.APPLICATION_XML_VALUE;

@CrossOrigin
@RestController
@RequestMapping("/company")
public class CompanyController {

  @Autowired
  private CompanyDAO companyDAO;

  @GetMapping(value = "/getcompany")
  public List<CompanyEntity> getAll()  {
    return companyDAO.getAll();
  }

  @GetMapping(value = "{id}", produces = { APPLICATION_JSON_VALUE,
          APPLICATION_XML_VALUE})
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
