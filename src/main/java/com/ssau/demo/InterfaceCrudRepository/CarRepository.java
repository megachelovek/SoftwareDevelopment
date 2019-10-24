package com.ssau.demo.InterfaceCrudRepository;

import com.ssau.demo.Model.CarEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<CarEntity, Integer> {
  @Query("FROM car WHERE UPPER(car.name) LIKE UPPER(concat('%', :name, '%'))")
  List<CarEntity> search(@Param("car_id") String search, Sort sort);
}