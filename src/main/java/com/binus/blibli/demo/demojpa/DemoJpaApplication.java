package com.binus.blibli.demo.demojpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.binus.blibli"})
@EnableJpaRepositories(basePackages = {"com.binus.blibli"})
public class DemoJpaApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoJpaApplication.class, args);
  }

}
