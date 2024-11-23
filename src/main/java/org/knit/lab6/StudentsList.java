package org.knit.lab6;

import java.util.Iterator;
import java.util.TreeSet;

public class StudentsList {
    private final TreeSet<String> students = new TreeSet<>();

    public void AddNewStudent(String name) {
        System.out.println();
        if (students.contains(name)){
            System.out.println("Этот студент уже в списке!");
        }
        else {
            students.add(name);
            System.out.println("Студент добавлен!");
        }
    }

    public void RemoveStudent(String name) {
        System.out.println();
        if (students.isEmpty()) {
            System.out.println("Список и так пуст!");
        } else if (!students.contains(name)) {
            System.out.println("Студента и так нет в списке!");
        }
        else {
            students.remove(name);
        }
    }

    public void ShowAllStudents() {
        System.out.println();
        if (students.isEmpty()) {
            System.out.println("Список пуст!");
        }
        else {
            for (String student : students) {
                System.out.println(student);
            }
        }
    }

    public void FindStudent(String name) {
        System.out.println();
        if (students.contains(name)) {
            System.out.println("Студент найден!");
        }
        else {
            System.out.println("Студент не найден!");
        }
    }
}
