package com.charity.share.service;

import com.charity.share.dao.CharityDao;
import com.charity.share.model.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CharityServiceImpl implements CharityService {

  @Autowired
  private  CharityDao charityDao;


  @Override
  public void save(Charity charity){
    charityDao.save(charity);
  }

  @Override
  public List<Charity> findAll() {
    return charityDao.findAll();
  }

  @Override
  public Charity findById(Integer id) {
    return charityDao.findById(id);
  }

  @Override
  public void delete(Charity charity) {
    charityDao.delete(charity);
  }

  @Override
  public void update(Charity charity) {
    charityDao.update(charity);
  }
}
