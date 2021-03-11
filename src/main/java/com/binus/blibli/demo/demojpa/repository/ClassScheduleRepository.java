package com.binus.blibli.demo.demojpa.repository;

import com.binus.blibli.demo.demojpa.entity.ClassSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassScheduleRepository extends JpaRepository<ClassSchedule, String> {

  ClassSchedule findById(Long id);

  ClassSchedule findByCode(String code);

  List<ClassSchedule> findByMahasiswa_Nim(String nim);
}
