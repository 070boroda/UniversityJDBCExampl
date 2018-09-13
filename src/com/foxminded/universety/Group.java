package com.foxminded.universety;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private List<Student> groupNumber;

    public Group() {
        this.groupNumber = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.groupNumber.add(student);
    }
}
