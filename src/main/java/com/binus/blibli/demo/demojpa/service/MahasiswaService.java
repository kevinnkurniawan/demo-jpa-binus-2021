package com.binus.blibli.demo.demojpa.service;

import com.binus.blibli.demo.demojpa.entity.Mahasiswa;

import java.util.List;

public interface MahasiswaService {

  Mahasiswa findByNim(String nim);

  void insert(Mahasiswa mahasiswa);

  void update(Mahasiswa mahasiswa);

  void delete(String nim);

  List<Mahasiswa> findByNimIfNotNull(String nim);
}
