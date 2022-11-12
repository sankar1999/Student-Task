package com.student.task.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    private Long id;
    private String name;
    private Integer age;
    private String department;
    private String emailAddress;

}
