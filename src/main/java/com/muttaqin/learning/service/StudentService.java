package com.muttaqin.learning.service;

import com.muttaqin.learning.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudents();
    Student findById(Long id);
    Student saveOrUpdateStudent(Student student);
    void deleteStudent(Long id);
}
