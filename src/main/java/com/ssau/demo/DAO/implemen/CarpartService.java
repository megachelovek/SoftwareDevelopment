package com.ssau.demo.DAO.implemen;

import com.google.common.collect.Lists;
import com.ssau.demo.DAO.CarpartDAO;
import com.ssau.demo.Entity.CarpartEntity;
import com.ssau.demo.Repository.CarpartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarpartService implements CarpartDAO {

  @Autowired
  private CarpartRepository СarpartRepository;

  @Override
  public List<CarpartEntity> getAll() {
    return Lists.newArrayList(СarpartRepository.findAll());
  }

  @Override
  public CarpartEntity findById(Integer id) {
    return СarpartRepository.findById(id);
  }

  @Override
  public void remove(CarpartEntity entity) {
      СarpartRepository.delete(entity);
  }

  @Override
  public void create(CarpartEntity entity) {
      СarpartRepository.save(entity);
  }

  @Override
  public void edit(CarpartEntity entity) {
      СarpartRepository.save(entity);
  }
}
