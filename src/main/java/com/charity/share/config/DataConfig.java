package com.charity.share.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

@Configuration
@PropertySource("application.properties")
public class DataConfig {

  public DataConfig(){}

  @Autowired
  private Environment environment;

  @Bean
  public LocalSessionFactoryBean sessionFactory(){
      Resource config = new ClassPathResource("hibernate.cfg.xml");
      LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
      factoryBean.setConfigLocation(config);
      factoryBean.setPackagesToScan("com.charity.share.model");
      factoryBean.setDataSource(dataSource());
      return factoryBean;
  }

 @Bean
  public DataSource dataSource(){
   BasicDataSource dataSource = new BasicDataSource();
   dataSource.setDriverClassName(environment.getProperty("share.db.driver"));
   dataSource.setUrl(environment.getProperty("share.db.jdbc-url"));
   dataSource.setUsername(environment.getProperty("share.db.username"));
   dataSource.setPassword(environment.getProperty("share.db.password"));
   return dataSource;
 }
}
