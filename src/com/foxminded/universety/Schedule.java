package com.foxminded.universety;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private List<Field> day;
    private String dayName;

    public Schedule(String dayName) {
        this.dayName = dayName;
        this.day = new ArrayList<>();
    }

    public List<Field> getDay() {
        return day;
    }

    public String getDayName() {
        return dayName;
    }

    public void addSchedule(Field schedule) {
        day.add(schedule);
    }
    
    public static void printSchedule(Schedule day){
    	System.out.println("Schedule " + day.getDayName() + " for group number " + day.getDay().get(0).getGroupNumber().getNumber());
    	for(int i = 0;i < day.getDay().size(); i++){
            System.out.println("Subject: " + day.getDay().get(i).getSubject() + " begin at: "
                    + day.getDay().get(i).getStartTime() + " Lecture Hall is " + day.getDay().get(i).getLectureHall().getNumber()
                    + " with teacher " + day.getDay().get(i).getTeacher().getFirstName() 
                    + " " + day.getDay().get(i).getTeacher().getSecondName());
       }
    }
}
