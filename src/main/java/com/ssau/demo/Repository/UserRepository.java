package com.ssau.demo.Repository;

import com.ssau.demo.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
  Optional<UserEntity> findByUsername(String username);
  Boolean existsByUsername(String username);
}