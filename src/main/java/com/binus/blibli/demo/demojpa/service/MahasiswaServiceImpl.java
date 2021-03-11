package com.binus.blibli.demo.demojpa.service;

import com.binus.blibli.demo.demojpa.entity.Mahasiswa;
import com.binus.blibli.demo.demojpa.repository.MahasiswaRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MahasiswaServiceImpl implements MahasiswaService {

  @Autowired
  private MahasiswaRepository mahasiswaRepository;

  @Override
  public Mahasiswa findByNim(String nim) {
    Mahasiswa mahasiswa = this.mahasiswaRepository.findByNim(nim);
    if(Objects.nonNull(mahasiswa)) {
      Hibernate.initialize(mahasiswa.getClassSchedules());
    }
    Hibernate.initialize(mahasiswa.getClassSchedules());
    return mahasiswa;
  }

  @Override
  public void insert(Mahasiswa mahasiswa) {
    this.mahasiswaRepository.save(mahasiswa);
//    List<Mahasiswa> mahasiswas = new ArrayList<>();
//
//    this.mahasiswaRepository.saveAll(mahasiswas);
  }

  @Override
  public void update(Mahasiswa mahasiswa) {
    Mahasiswa existing = this.findByNim(mahasiswa.getNim());
    if (existing == null) {
      return;
    }
    existing.setName(mahasiswa.getName());
    existing.setNim(mahasiswa.getNim());

    this.mahasiswaRepository.save(existing);
  }

  @Override
  public void delete(String nim) {
    Mahasiswa existing = this.findByNim(nim);
    if (existing == null) {
      return;
    }
    this.mahasiswaRepository.delete(existing);
  }

  @Override
  public List<Mahasiswa> findByNimIfNotNull(String nim) {
    return this.mahasiswaRepository.findByNimIfNotNull(nim);
  }
}
