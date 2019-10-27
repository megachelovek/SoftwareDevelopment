package com.ssau.demo.Repository;

import com.ssau.demo.Entity.CarEntity;
import com.ssau.demo.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<CarEntity, Long> {
  UserEntity findById(String id);
}