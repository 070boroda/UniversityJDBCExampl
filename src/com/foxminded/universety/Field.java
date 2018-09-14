package com.foxminded.universety;

import java.awt.List;

public class Field {

    private Subject subject;
    private int startHour;
    private Group groupNumber;
    private Teacher teacher;
    private LectureHall lectureHall;
    
    public Field(Subject subject, int startHour, Group groupNumber, Teacher teacher, LectureHall lectureHall){
    	this.subject = subject;
        this.startHour = startHour;
        this.groupNumber = groupNumber;
        this.teacher = teacher;
        this.lectureHall = lectureHall; 
        }
 
    public Subject getSubject() {
        return subject;
    }

    public float getStartTime() {
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

	public void setStartTime(int startTime) {
		this.startHour = startTime;
	}
    
}
