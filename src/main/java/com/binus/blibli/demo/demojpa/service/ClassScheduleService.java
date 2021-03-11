package com.binus.blibli.demo.demojpa.service;

import com.binus.blibli.demo.demojpa.entity.ClassSchedule;

import java.util.List;

public interface ClassScheduleService {

  ClassSchedule findByCode(String code);

  List<ClassSchedule> findByMahasiswaNim(String nim);

  void insert(ClassSchedule classSchedule, String nim);

  void update(ClassSchedule classSchedule, String nim);

  void delete(String code);
}
