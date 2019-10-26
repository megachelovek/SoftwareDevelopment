package com.ssau.demo.Repository;

import com.ssau.demo.Entity.CarEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<CarEntity, Long> {
  CarEntity findById(Integer id);
}