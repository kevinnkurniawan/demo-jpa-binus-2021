package com.binus.blibli.demo.demojpa.repository;

import com.binus.blibli.demo.demojpa.entity.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, String>,
    JpaSpecificationExecutor<Mahasiswa>, CustomMahasiswaRepository {

//  @Query("select m from Mahasiswa where m.nim = ?1 and m.id = ?2")
  Mahasiswa findByNimAndId(String nim, Long id);

  Mahasiswa findByNim(String nim);
}
