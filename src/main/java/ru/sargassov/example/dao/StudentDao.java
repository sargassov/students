package ru.sargassov.example.dao;

import org.hibernate.Session;
import ru.sargassov.example.entities.Student;
import ru.sargassov.example.factory.Factory;

import java.util.ArrayList;
import java.util.List;

public class StudentDao implements Dao{
    private Factory factory;

    public StudentDao(Factory factory) {
        this.factory = factory;
    }

    public void save(Student student) {
        Session session = factory.getSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
    }

    public void delete(Student s) {
        Session session = factory.getSession();
        session.beginTransaction();
        session.delete(s);
        session.getTransaction().commit();

    }

    public List<Student> getAll() {
        Session session = factory.getSession();
        session.beginTransaction();
        List<Student> students = new ArrayList<Student>();
        students = session.createQuery("select s from Student s").getResultList();
        session.getTransaction().commit();
        return students;
    }

    public Student getById(Long id) {
        Session session = factory.getSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.getTransaction().commit();
        return student;
    }

    public Student update(Student student) {
        Session session = factory.getSession();
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();
        return student;
    }

    @Override
    public void deleteById(Long id) {
        Session session = factory.getSession();
        session.beginTransaction();
        session.createQuery("delete from Student s where s.id = ?1").getResultList();
        session.getTransaction().commit();
    }
}
