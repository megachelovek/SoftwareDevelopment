package com.ssau.demo.Repository;

import com.ssau.demo.Entity.CarpartEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarpartRepository extends CrudRepository<CarpartEntity, Long> {
  CarpartEntity findById(Integer id);
}