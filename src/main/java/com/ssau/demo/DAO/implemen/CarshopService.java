package com.ssau.demo.DAO.implemen;

import com.google.common.collect.Lists;
import com.ssau.demo.DAO.CarpartDAO;
import com.ssau.demo.DAO.CarshopDAO;
import com.ssau.demo.Entity.CarpartEntity;
import com.ssau.demo.Entity.CarshopEntity;
import com.ssau.demo.Repository.CarpartRepository;
import com.ssau.demo.Repository.CarshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarshopService implements CarshopDAO {

  @Autowired
  private CarshopRepository CarshopRepository;

  @Override
  public List<CarshopEntity> getAll() {
    return Lists.newArrayList(CarshopRepository.findAll());
  }

  @Override
  public CarshopEntity findById(Integer id) {
    return CarshopRepository.findById(id);
  }

  @Override
  public void remove(CarshopEntity entity) {
      CarshopRepository.delete(entity);
  }

  @Override
  public void create(CarshopEntity entity) {
      CarshopRepository.save(entity);
  }

  @Override
  public void edit(CarshopEntity entity) {
      CarshopRepository.save(entity);
  }
}
