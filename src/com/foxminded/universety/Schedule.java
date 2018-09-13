package com.foxminded.universety;

import java.awt.List;

public class Schedule {

    private Subject subject;
    private String startTime;
    private Group groupNumber;
    private Teacher teacher;
    private LectureHall lectureHall;

    public Schedule(Subject subject, String startTime, Group groupNumber, Teacher teacher, LectureHall lectureHall) {
        super();
        this.subject = subject;
        this.startTime = startTime;
        this.groupNumber = groupNumber;
        this.teacher = teacher;
        this.lectureHall = lectureHall;
    }

    public Subject getSubject() {
        return subject;
    }

    public String getStartTime() {
        return startTime;
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

}
