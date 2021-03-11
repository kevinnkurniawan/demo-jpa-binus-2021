package com.binus.blibli.demo.demojpa.controller;

import com.binus.blibli.demo.demojpa.entity.Mahasiswa;
import com.binus.blibli.demo.demojpa.request.MahasiswaRequest;
import com.binus.blibli.demo.demojpa.response.BaseResponse;
import com.binus.blibli.demo.demojpa.response.MahasiswaResponse;
import com.binus.blibli.demo.demojpa.service.MahasiswaService;
import com.binus.blibli.demo.demojpa.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MahasiswaController {

  @Autowired
  private MahasiswaService mahasiswaService;

  @GetMapping("/api/mahasiswa/findByNim")
  public MahasiswaResponse findByNim(@RequestParam String nim) {
    Mahasiswa mahasiswa = this.mahasiswaService.findByNim(nim);
    return Converter.convertMahasiswaToMahasiswaResponse(mahasiswa);
  }

  @GetMapping("/api/mahasiswa/findByNimIfNotNull")
  public List<MahasiswaResponse> findByNimIfNotNull(@RequestParam String nim) {
    List<Mahasiswa> mahasiswa = this.mahasiswaService.findByNimIfNotNull(nim);
    return Converter.convertMahasiswasToMahasiswaResponses(mahasiswa);
  }

  @PostMapping("/api/mahasiswa/insert")
  public BaseResponse insert(@RequestBody MahasiswaRequest request) {
    Mahasiswa mahasiswa = Converter.convertMahasiswaRequestToMahasiswa(request);
    this.mahasiswaService.insert(mahasiswa);
    return BaseResponse.builder()
        .success(Boolean.TRUE)
        .errorMessage(null)
        .build();
  }

}
