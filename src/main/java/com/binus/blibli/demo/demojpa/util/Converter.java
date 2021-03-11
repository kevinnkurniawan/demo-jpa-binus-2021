package com.binus.blibli.demo.demojpa.util;

import com.binus.blibli.demo.demojpa.entity.ClassSchedule;
import com.binus.blibli.demo.demojpa.entity.Mahasiswa;
import com.binus.blibli.demo.demojpa.request.MahasiswaRequest;
import com.binus.blibli.demo.demojpa.response.ClassScheduleResponse;
import com.binus.blibli.demo.demojpa.response.MahasiswaResponse;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Converter {

  public static List<MahasiswaResponse> convertMahasiswasToMahasiswaResponses(List<Mahasiswa> mahasiswa) {
    return mahasiswa.stream()
        .map(Converter::convertMahasiswaToMahasiswaResponse)
        .collect(Collectors.toList());
  }

  public static MahasiswaResponse convertMahasiswaToMahasiswaResponse(Mahasiswa mahasiswa) {
    MahasiswaResponse response = new MahasiswaResponse();
    mahasiswa = Optional.ofNullable(mahasiswa)
        .orElse(new Mahasiswa());
    BeanUtils.copyProperties(mahasiswa, response);

//
//    String nim = Optional.ofNullable(mahasiswa)
//        .map(Mahasiswa::getNim)
//        .orElse("");


//    MahasiswaResponse response1 = MahasiswaResponse.builder()
//        .name(mahasiswa.getName())
//        .nim(mahasiswa.getNim())
//        .build();

    response.setClassScheduleResponses(
        Converter.convertClassSchedulesToClassScheduleResponses(mahasiswa.getClassSchedules()));

    return response;
  }

  public static Mahasiswa convertMahasiswaRequestToMahasiswa(MahasiswaRequest request) {
    Mahasiswa mahasiswa = new Mahasiswa();
    BeanUtils.copyProperties(request, mahasiswa);
    return mahasiswa;
  }

  public static List<ClassScheduleResponse> convertClassSchedulesToClassScheduleResponses(
      List<ClassSchedule> classSchedules) {

//    List<ClassScheduleResponse> classScheduleResponses = new ArrayList<>();
//
//    for(ClassSchedule classSchedule : classSchedules) {
//      classScheduleResponses.add(Converter.convertClassScheduleToClassScheduleResponse(classSchedule));
//    }
//
//    return classScheduleResponses;
    return classSchedules.stream()
        .map(Converter::convertClassScheduleToClassScheduleResponse)
        .collect(Collectors.toList());
  }

  public static ClassScheduleResponse convertClassScheduleToClassScheduleResponse(ClassSchedule classSchedule) {
    ClassScheduleResponse response = new ClassScheduleResponse();

    classSchedule = Optional.ofNullable(classSchedule)
        .orElse(new ClassSchedule());
    BeanUtils.copyProperties(classSchedule, response);

    return response;
  }
}
