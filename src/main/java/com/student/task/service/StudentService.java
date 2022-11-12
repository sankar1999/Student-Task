package com.student.task.service;

import com.student.task.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    String updateExistingStudent(Student student);

}
