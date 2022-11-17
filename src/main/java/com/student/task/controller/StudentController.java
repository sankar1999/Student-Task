package com.student.task.controller;

import com.student.task.entity.Student;
import com.student.task.responseModel.ResponseModel;
import com.student.task.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    // UpdateListOfStudents
//    @PostMapping("/updateListOfStudents")
//    public void updateListOfStudents(@RequestBody List<Student> studentList) {
//        studentService.updateListOfStudents(studentList);
//    }

    // SaveListOfStudents
    @PostMapping("/saveListOfStudent")
    public ResponseModel saveListofStudents(@RequestBody List<Student> students) {
        return studentService.saveListOfStudent(students);
    }

    // UpdateListOfStudents
    @PostMapping("/updateListOfStudents")
    public ResponseModel updateListOfStudents(@RequestBody List<Student> students) {
       return  studentService.updateListOfStudents(students);
    }

    // Delete All
    @GetMapping("/deleteAll")
    public ResponseModel deleteAll() {
        return studentService.deleteAll();
    }

    // Bulk Delete
    @PostMapping("/bulkDelete")
    public ResponseModel bulkDelete(@RequestBody List<Student> students) {
        return studentService.bulkDelete(students);
    }


}
