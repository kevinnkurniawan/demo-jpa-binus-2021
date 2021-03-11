package com.binus.blibli.demo.demojpa.repository;

import com.binus.blibli.demo.demojpa.entity.Mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CustomMahasiswaRepositoryImpl implements CustomMahasiswaRepository {

  private static final String DEFAULT_NIM = "123456789";

  @Autowired
  private EntityManager entityManager;

  @Override
  public List<Mahasiswa> findByNimIfNotNull(String nim) {

    String query = "SELECT m FROM Mahasiswa m where m.nim = ?1";

    if(nim.equals("")) {
      nim = DEFAULT_NIM;
    }

    Query queryHibernate = entityManager.createQuery(query);
    queryHibernate.setParameter(1, nim);

    return queryHibernate.getResultList();
  }
}
