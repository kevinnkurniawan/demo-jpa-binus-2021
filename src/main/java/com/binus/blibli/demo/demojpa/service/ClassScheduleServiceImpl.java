package com.binus.blibli.demo.demojpa.service;

import com.binus.blibli.demo.demojpa.entity.ClassSchedule;
import com.binus.blibli.demo.demojpa.entity.Mahasiswa;
import com.binus.blibli.demo.demojpa.repository.ClassScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassScheduleServiceImpl implements ClassScheduleService {

  @Autowired
  private ClassScheduleRepository classScheduleRepository;

  @Autowired
  private MahasiswaService mahasiswaService;

  @Override
  public ClassSchedule findByCode(String code) {
    return this.classScheduleRepository.findByCode(code);
  }

  @Override
  public List<ClassSchedule> findByMahasiswaNim(String nim) {
    return this.classScheduleRepository.findByMahasiswa_Nim(nim);
  }

  @Override
  public void insert(ClassSchedule classSchedule, String nim) {
    Mahasiswa mahasiswa = this.mahasiswaService.findByNim(nim);
    if(mahasiswa == null) {
      return;
    }
    classSchedule.setMahasiswa(mahasiswa);

    this.classScheduleRepository.save(classSchedule);
  }

  @Override
  public void update(ClassSchedule classSchedule, String nim) {
    ClassSchedule existing = this.findByCode(classSchedule.getCode());
    Mahasiswa mahasiswa = this.mahasiswaService.findByNim(nim);
    if (existing == null || mahasiswa == null) {
      return;
    }
    existing.setDate(classSchedule.getDate());
    existing.setName(classSchedule.getName());

    existing.setMahasiswa(mahasiswa);

    this.classScheduleRepository.save(existing);
  }

  @Override
  public void delete(String code) {
    ClassSchedule existing = this.findByCode(code);
    if(existing == null) {
      return;
    }
    this.classScheduleRepository.delete(existing);
  }
}
