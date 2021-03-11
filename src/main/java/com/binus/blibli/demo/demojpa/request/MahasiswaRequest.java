package com.binus.blibli.demo.demojpa.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MahasiswaRequest {

  private String nim;
  private String name;
}
