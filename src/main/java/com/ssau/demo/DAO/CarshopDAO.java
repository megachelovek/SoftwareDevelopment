package com.ssau.demo.DAO;


import com.ssau.demo.Entity.CarpartEntity;
import com.ssau.demo.Entity.CarshopEntity;

import java.util.List;

public interface CarshopDAO {
  public List<CarshopEntity> getAll();
  public CarshopEntity findById(Integer id);
  public void remove(CarshopEntity entity);
  public void create(CarshopEntity entity);
  public void edit(CarshopEntity entity);
}
