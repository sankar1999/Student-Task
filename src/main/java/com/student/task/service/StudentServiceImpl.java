package com.student.task.service;

import com.student.task.entity.Student;
import com.student.task.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = repository.findAll();
        return students;
    }

    @Override
    public Student getStudentById(Long id) {
        Student student = repository.findById(id).get();
        return student;
    }

    @Override
    public String updateExistingStudent(Student student) {
        String finalResponse = "";
        Student tempStudentObj = (Student) repository.findById(student.getId()).get();
        finalResponse = "Requested Data is already exist...";

        Boolean checkBothObjects = student.toString().equals(tempStudentObj.toString());

        if(checkBothObjects.equals(false)) {
            repository.save(student);
            finalResponse = "Updated...";
        }
        return finalResponse;
    }

    @Override
    public String insertMultipleStudents(List<Student> students) {
        String finalResponse = "";
        Boolean toCheckSavedOrNot = false;

        if (!(students.isEmpty())) {
            toCheckSavedOrNot = true;
            students.stream()
                    .forEach(student -> repository.save(student));
        }

        if (toCheckSavedOrNot.equals(true)) {
            finalResponse = "Saved...";
        } else {
            finalResponse = "Reauest is empty...";
        }
        return finalResponse;
    }
}
