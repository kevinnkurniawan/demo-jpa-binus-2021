package com.binus.blibli.demo.demojpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;

@Entity
@Table(name = "class_schedule", uniqueConstraints ={
    @UniqueConstraint(columnNames = {"code"})
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassSchedule {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "code")
  private String code;

  @Column(name = "date")
  private Date date;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "mahasiswa_fk", nullable = false)
  @JsonBackReference
  private Mahasiswa mahasiswa;

}
