package com.example.bt2.service;

import com.example.bt2.model.Student;

import java.util.Optional;

public interface IStudentService {
    Iterable<Student> findAll();

    Optional<Student> findById(Long id);

    void save(Student student);

    void remove(Long id);
}
