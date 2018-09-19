package com.foxminded.universety;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String number;
    private List<Student> students;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Student> getGroup() {
        return students;
    }

    public Group(String number) {
        this.number = number;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return number;
    }
}
