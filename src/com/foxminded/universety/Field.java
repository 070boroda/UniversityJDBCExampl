package com.foxminded.universety;

import java.awt.List;

public class Field {

    private Subject subject;
    private String startHour;
    private String startMinut;
    private Group groupNumber;
    private Teacher teacher;
    private LectureHall lectureHall;

    public Field(Subject subject, String startHour, String startMinut, Group groupNumber, Teacher teacher,
            LectureHall lectureHall) {
        this.startMinut = startMinut;
        this.subject = subject;
        this.startHour = startHour;
        this.groupNumber = groupNumber;
        this.teacher = teacher;
        this.lectureHall = lectureHall;
    }

    public Subject getSubject() {
        return subject;
    }

    public String getStartHour() {
        return startHour;
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

    public void setStartTime(String startTime) {
        this.startHour = startTime;
    }

    public String getStartMinut() {
        return startMinut;
    }

}
