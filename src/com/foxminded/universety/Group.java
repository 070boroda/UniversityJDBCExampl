package com.foxminded.universety;

import java.util.ArrayList;

public class Group {

    private String number;
    private ArrayList<Student> group;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ArrayList<Student> getGroup() {
        return group;
    }

    public Group(String number) {
        this.number = number;
        this.group = new ArrayList<>();
    }

    public void addStudent(Student student) {
        group.add(student);
    }

    @Override
    public String toString() {
        return number;
    }
}
