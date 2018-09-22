package com.foxminded.universety;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Group {

    private String number;
    private List<Student> students;

    public Group(String number) {
        this.number = number;
        this.students = new ArrayList<>();
    }

    protected void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return number;
    }
}
