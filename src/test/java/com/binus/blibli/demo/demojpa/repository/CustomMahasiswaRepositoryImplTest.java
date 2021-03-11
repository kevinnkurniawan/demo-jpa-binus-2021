package com.binus.blibli.demo.demojpa.repository;


import com.binus.blibli.demo.demojpa.config.TestConfig;
import com.binus.blibli.demo.demojpa.entity.Mahasiswa;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@TestExecutionListeners(listeners = {
    DependencyInjectionTestExecutionListener.class,
    DirtiesContextBeforeModesTestExecutionListener.class,
    TransactionalTestExecutionListener.class
})
public class CustomMahasiswaRepositoryImplTest {

  @Autowired
  private MahasiswaRepository mahasiswaRepository;

  @Before
  public void setup() {
    Mahasiswa mahasiswa = new Mahasiswa();
    mahasiswa.setId(1L);
    mahasiswa.setNim("123456789");
    mahasiswa.setName("Kevin");

    this.mahasiswaRepository.save(mahasiswa);
  }

  @Test
  public void findByNimIfNotNullTest() {
    List<Mahasiswa> mahasiswa = this.mahasiswaRepository.findByNimIfNotNull("123456789");

    Assert.assertEquals(1, mahasiswa.size());
  }

  @After
  public void teardown() {
    this.mahasiswaRepository.deleteAll();
  }

}
