package com.binus.blibli.demo.demojpa.repository;

import com.binus.blibli.demo.demojpa.entity.Mahasiswa;

import java.util.List;

public interface CustomMahasiswaRepository {

  List<Mahasiswa> findByNimIfNotNull(String nim);
}
