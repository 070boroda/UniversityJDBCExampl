package com.foxminded.universety;

import java.awt.List;

public class Field {

    private Subject subject;
    private float startTime;
    private Group groupNumber;
    private Teacher teacher;
    private LectureHall lectureHall;
    
    public Field(Subject subject, float startTime, Group groupNumber, Teacher teacher, LectureHall lectureHall){
    	this.subject = subject;
        this.startTime = startTime;
        this.groupNumber = groupNumber;
        this.teacher = teacher;
        this.lectureHall = lectureHall; 
        }
 
    public Subject getSubject() {
        return subject;
    }

    public float getStartTime() {
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
