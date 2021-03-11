package com.binus.blibli.demo.demojpa.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MahasiswaResponse {

//  private Long id;

  private String nim;

  private String name;

  private List<ClassScheduleResponse> classScheduleResponses = new ArrayList<>();
}
