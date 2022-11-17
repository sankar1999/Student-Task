package com.student.task.service;

import com.student.task.entity.Student;
import com.student.task.responseModel.ResponseModel;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    String updateExistingStudent(Student student);

    String insertMultipleStudents(List<Student> students);

    ResponseModel updateListOfStudents(List<Student> studentList);

    ResponseModel saveListOfStudent(List<Student> students);

    ResponseModel bulkDelete(List<Student> students);

    ResponseModel deleteAll();
}
