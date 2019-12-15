package com.ssau.demo.Repository;


import com.ssau.demo.Entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity,Integer> {
  Optional<UserRoleEntity> findByName(UserRoleEntity.UserRoleType roleName);
}