package com.foxminded.universety;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Field {

    private Subject subject;
    private Group groupNumber;
    private Teacher teacher;
    private LectureHall lectureHall;
    private List<Field> fields = new ArrayList<>();

    public Field() {
    }

    public Field(Subject subject, Group groupNumber, Teacher teacher, LectureHall lectureHall) {
        this.subject = subject;
        this.groupNumber = groupNumber;
        this.teacher = teacher;
        this.lectureHall = lectureHall;
    }

    protected void addFields(Field field) {
        this.fields.add(field);
    }

    protected List getFields() {
        return fields;
    }

    @Override
    public String toString() {
        return " " + subject + " group: " + groupNumber + " teacher: " + teacher + " in " + lectureHall + "";
    }
}
