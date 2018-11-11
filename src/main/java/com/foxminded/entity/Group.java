package com.foxminded.entity;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Group {

    private String number;
    private List<Student> students = new ArrayList<>();

    public Group(String number) {
        this.number = number;
    }

    protected void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return number;
    }
}
