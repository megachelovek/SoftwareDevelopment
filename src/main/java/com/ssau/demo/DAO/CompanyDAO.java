package com.ssau.demo.DAO;


import com.ssau.demo.Entity.CompanyEntity;

import java.util.List;

public interface CompanyDAO {
  public List<CompanyEntity> getAll();
  public CompanyEntity findById(Integer id);
  public void remove(CompanyEntity entity);
  public void create(CompanyEntity entity);
  public void edit(CompanyEntity entity);
}
