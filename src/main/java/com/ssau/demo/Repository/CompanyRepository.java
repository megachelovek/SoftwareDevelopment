package com.ssau.demo.Repository;

import com.ssau.demo.Entity.CompanyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<CompanyEntity, Long> {
  CompanyEntity findById(Integer id);
}