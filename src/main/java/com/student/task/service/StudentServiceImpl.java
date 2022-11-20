package com.student.task.service;

import com.student.task.entity.Student;
import com.student.task.repository.StudentRepository;
import com.student.task.responseModel.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

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
        return null;
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

    @Override
    public ResponseModel saveListOfStudent(List<Student> students) {
        repository.saveAll(students);
        return new ResponseModel("102", "Success");
    }


    @Override
    public ResponseModel updateListOfStudents(List<Student> studentList) {

        List<Student> getDataFromDB = repository.findAll();

        List<Long> getDBIdList = getDataFromDB.stream()
                .map(s -> s.getId()).collect(Collectors.toList());
        System.out.println(getDBIdList);
        List<Long> getIdFromRequest = studentList.stream()
                .map(s -> s.getId()).collect(Collectors.toList());
        System.out.println(getIdFromRequest);

        List<Long> idToDeleteFromDB = getDBIdList.stream()
                .filter(not (one -> getIdFromRequest.stream()
                        .anyMatch(two -> two.equals(one))))
                .collect(Collectors.toList());

        // Delete unavailable ids
        repository.deleteAllById(idToDeleteFromDB);

        // Save new records
        repository.saveAll(studentList);


        return new ResponseModel("103", "Success");
    }

    @Override
    public ResponseModel deleteAll() {
        repository.deleteAll();
        return new ResponseModel("104", "Success");
    }


    @Override
    public ResponseModel bulkDelete(List<Student> students) {

        List<Long> getIdsFromRequest = students.stream().map(student -> student.getId())
                .collect(Collectors.toList());
        deleteAll();
        repository.saveAll(students);
        return new ResponseModel("101", "Success");
    }



}

