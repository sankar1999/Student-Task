package com.student.task.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@DynamicInsert
@DynamicUpdate
public class Student {

    @Id
    private Long id;
    private String name;
    private Integer age;
    private String department;
    private String emailAddress;

    public Student() {
    }

    public Student(Long id, String name, Integer age, String department, String emailAddress) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.emailAddress = emailAddress;
    }

    public Student(Student student) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
