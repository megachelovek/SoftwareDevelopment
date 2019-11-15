package com.ssau.demo.Repository;

import com.ssau.demo.Entity.CarEntity;
import com.ssau.demo.Entity.CarpartEntity;
import com.ssau.demo.Entity.CarshopEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarshopRepository extends CrudRepository<CarshopEntity, Long> {
  CarshopEntity findById(Integer id);
}