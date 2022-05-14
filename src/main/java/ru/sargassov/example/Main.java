package ru.sargassov.example;

import ru.sargassov.example.dao.StudentDao;
import ru.sargassov.example.entities.Student;
import ru.sargassov.example.factory.Factory;

import java.util.List;
import java.util.Random;

public class Main {
    private static Factory factory;

    public static void main(String[] args) {
        factory = new Factory();
        StudentDao studentDao = new StudentDao(factory);

        System.out.println("Создали базу данных т подключились к ней через Hibernate");
        for (int i = 0; i < 1000; i++) {
            Student student = new Student("student " + i, new Random().nextInt(3) + 3);
            studentDao.save(student);
        }
        System.out.println("Добавили 1000 записей");
        List<Student> studentList = studentDao.getAll();
        System.out.println("Проверяем наличие студентов. Student.size = " + studentList.size());

        Student student = studentDao.getById(4545L);
        System.out.println("Достаем студента 4545. Его зовут " + student.getName());

        student.setName(student.getName() + " Жора");
        studentDao.update(student);
        student = studentDao.getById(4545L);

        System.out.println("Переименовываем. Сохраняем и еще раз достаем. Теперь он " + student.getName());
        studentDao.delete(student);

        studentList = studentDao.getAll();
        System.out.println("Удаляем и теперь считаем студентов. Students.size = " + studentList.size());

        for (int i = 0; i < studentList.size(); i++) {
            studentDao.delete(studentList.get(i));
        }
        System.out.println("Чистим всех остальных студентов");


        factory.shutdown();
    }
}
