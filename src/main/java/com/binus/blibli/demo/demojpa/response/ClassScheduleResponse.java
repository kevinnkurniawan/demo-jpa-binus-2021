package com.binus.blibli.demo.demojpa.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassScheduleResponse {

  private String code;
  private String name;
  private Date date;
}
