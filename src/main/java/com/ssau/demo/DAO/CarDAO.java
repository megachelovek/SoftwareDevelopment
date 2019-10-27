package com.ssau.demo.DAO;


import com.ssau.demo.Entity.CarEntity;

import java.util.List;

public interface CarDAO {
  public List<CarEntity> getAll();
  public CarEntity findById(Integer id);
  public void remove(CarEntity entity);
  public void create(CarEntity entity);
  public void edit(CarEntity entity);
}
