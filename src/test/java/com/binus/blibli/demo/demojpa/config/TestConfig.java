package com.binus.blibli.demo.demojpa.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = {"com.binus.blibli"})
@EnableJpaAuditing
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.binus.blibli"})
public class TestConfig {

  @Bean
  public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
        .addScript("classpath:db-script.sql")
        .build();

//    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//    dataSource.setDriverClassName("org.h2.Driver");
//    dataSource.setUrl("jdbc:h2:mem:binus;DB_CLOSE_DELAY=-1");
////    dataSource.setUsername("username");
////    dataSource.setPassword("password");
//
//    return dataSource;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    containerEntityManagerFactoryBean.setDataSource(this.dataSource());
    containerEntityManagerFactoryBean.setJpaDialect(this.jpaDialect());
    containerEntityManagerFactoryBean.setPackagesToScan(new String[]{"com.binus.blibli"});
    containerEntityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
    return containerEntityManagerFactoryBean;
  }

  @Bean
  public HibernateJpaDialect jpaDialect() {
    return new HibernateJpaDialect();
  }

  @Bean
  public HibernateJpaVendorAdapter jpaVendorAdapter() {
    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    adapter.setDatabase(Database.H2);
    adapter.setGenerateDdl(true);
    adapter.setShowSql(true);

    return adapter;
  }

  @Bean
  public JpaTransactionManager transactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setDataSource(this.dataSource());
    transactionManager.setJpaDialect(this.jpaDialect());
    return transactionManager;
  }

}
