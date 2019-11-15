package com.ssau.demo.DAO.implemen;

import com.google.common.collect.Lists;
import com.ssau.demo.DAO.CarpartDAO;
import com.ssau.demo.DAO.CompanyDAO;
import com.ssau.demo.Entity.CarpartEntity;
import com.ssau.demo.Entity.CompanyEntity;
import com.ssau.demo.Repository.CarpartRepository;
import com.ssau.demo.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyService implements CompanyDAO {

  @Autowired
  private CompanyRepository CompanyRepository;

  @Override
  public List<CompanyEntity> getAll() {
    return Lists.newArrayList(CompanyRepository.findAll());
  }

  @Override
  public CompanyEntity findById(Integer id) {
    return CompanyRepository.findById(id);
  }

  @Override
  public void remove(CompanyEntity entity) {
    CompanyRepository.delete(entity);
  }

  @Override
  public void create(CompanyEntity entity) {
    CompanyRepository.save(entity);
  }

  @Override
  public void edit(CompanyEntity entity) {
    CompanyRepository.save(entity);
  }
}
