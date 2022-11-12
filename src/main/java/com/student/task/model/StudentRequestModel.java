package com.student.task.model;

import com.student.task.entity.Student;

import java.util.List;


public class StudentRequestModel {

    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "StudentRequestModel{" +
                "students=" + students +
                '}';
    }
}
