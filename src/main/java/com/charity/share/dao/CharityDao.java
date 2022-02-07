package com.charity.share.dao;

import com.charity.share.model.Charity;

import java.util.List;

public interface CharityDao {

  List<Charity> findAll();
  Charity findById(Integer id);
  void save(Charity charity);
  void delete(Charity charity);
  void update(Charity charity);
}
