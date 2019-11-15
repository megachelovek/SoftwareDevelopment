package com.ssau.demo.DAO;


import com.ssau.demo.Entity.CarEntity;
import com.ssau.demo.Entity.CarpartEntity;

import java.util.List;

public interface CarpartDAO {
  public List<CarpartEntity> getAll();
  public CarpartEntity findById(Integer id);
  public void remove(CarpartEntity entity);
  public void create(CarpartEntity entity);
  public void edit(CarpartEntity entity);
}
