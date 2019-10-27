package com.ssau.demo.DAO.implemen;

import com.ssau.demo.DAO.CarDAO;
import com.ssau.demo.Entity.CarEntity;
import com.ssau.demo.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.collect.Lists;

import java.util.List;

@Service
@Transactional
public class CarService implements CarDAO {

  @Autowired
  private CarRepository СarRepository;

  @Override
  public List<CarEntity> getAll() {
    return Lists.newArrayList(СarRepository.findAll());
  }

  @Override
  public CarEntity findById(Integer id) {
    return СarRepository.findById(id);
  }

  @Override
  public void remove(CarEntity entity) {
    СarRepository.delete(entity);
  }

  @Override
  public void create(CarEntity entity) {
    СarRepository.save(entity);
  }

  @Override
  public void edit(CarEntity entity) {
    СarRepository.save(entity);
  }
}
