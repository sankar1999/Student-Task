package com.student.task.controller;

import com.student.task.entity.Student;
import com.student.task.model.StudentRequestModel;
import com.student.task.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Save a single record of student
    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // Get All Students
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get Student by ID
    @GetMapping("/getStudentById")
    public Student getStudentById(@RequestParam("id") Long id) {
        return studentService.getStudentById(id);
    }

    // Update existing student
    @PostMapping("/updateExistingStudent")
    public String updateExistingStudent(@RequestBody Student student) {
        return studentService.updateExistingStudent(student);
    }

    // Insert Multiple Students
    @PostMapping("/insertMultipleStudents")
    public String insertMultipleStudents(@RequestBody StudentRequestModel studentsList) {

        studentsList.getStudents().stream()
                .forEach(student -> System.out.println(student.getName()));

//    studentsList.getStudents().forEach(Student -> {
//        Student student = new Student();
//        student.setId(student.getId());
//        student.setName(student.getName());
//        student.setAge(student.getAge());
//        student.setEmailAddress(student.getEmailAddress());
//        student.setDepartment(student.getDepartment());
//        saveStudents.add(student);
//    });

        return "Test...";
//        return studentService.insertMultipleStudents(students);
    }
}
