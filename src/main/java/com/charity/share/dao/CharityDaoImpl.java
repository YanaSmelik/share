package com.charity.share.dao;

import com.charity.share.model.Charity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@Repository
public class CharityDaoImpl implements CharityDao{

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public List<Charity> findAll() {
    Session session = sessionFactory.openSession();
    CriteriaBuilder builder = session.getCriteriaBuilder();
    CriteriaQuery<Charity> criteria = builder.createQuery(Charity.class);
    criteria.from(Charity.class);
    List<Charity> charities = session.createQuery(criteria).getResultList();
    session.close();
    return charities;
  }

  @Override
  public Charity findById(Integer id) {
    Session session = sessionFactory.openSession();
    Charity charity = session.get(Charity.class, id);
    session.close();
    return charity;
  }

  @Override
  public void save(Charity charity) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.saveOrUpdate(charity);
    session.getTransaction().commit();
    session.close();
  }

  @Override
  public void delete(Charity charity) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.delete(charity);
    session.getTransaction().commit();
    session.close();
  }

  @Override
  public void update(Charity charity) {
    Session session = sessionFactory.openSession();
    session.getTransaction();
    session.update(charity);
    session.getTransaction().commit();
    session.close();
  }
}
