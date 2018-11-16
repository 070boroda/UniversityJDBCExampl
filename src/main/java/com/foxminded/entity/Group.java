package com.foxminded.entity;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Group {

    private String name;
    private List<Student> students = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    protected void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return name;
    }
}
