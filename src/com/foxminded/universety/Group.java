package com.foxminded.universety;

import java.util.ArrayList;

public class Group {

    private int number;
    private ArrayList<Student> group;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArrayList<Student> getGroup() {
        return group;
    }

    public Group(int number) {
        this.number = number;
        this.group = new ArrayList<>();
    }

    public void addStudent(Student student) {
        group.add(student);
    }
    
    
}
