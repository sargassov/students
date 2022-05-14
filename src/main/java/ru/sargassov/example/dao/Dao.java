package ru.sargassov.example.dao;


import ru.sargassov.example.entities.Student;

import java.util.List;

public interface Dao {
    void save(Student o);
    void delete(Student s);
    List<Student> getAll();
    Student getById(Long id);
    Student update(Student o);
    void deleteById(Long id);
}
