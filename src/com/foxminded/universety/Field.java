package com.foxminded.universety;

import java.util.ArrayList;

public class Field {

    private Subject subject;
    private Group groupNumber;
    private Teacher teacher;
    private LectureHall lectureHall;
    private ArrayList<Field> fields = new ArrayList<>();

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

    protected ArrayList getFields() {
        return fields;
    }

    public Subject getSubject() {
        return subject;
    }

    public Group getGroupNumber() {
        return groupNumber;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public LectureHall getLectureHall() {
        return lectureHall;

    }

    @Override
    public String toString() {
        return " " + subject + " " + groupNumber + " " + teacher + " " + lectureHall + "";
    }

}
