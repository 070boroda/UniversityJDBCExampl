package com.foxminded.universety;

import java.util.Map;
import java.util.TreeMap;

public class Schedule {

    Map<DayOfWeek, Map<NUMBER_LESSON, List<Field>>> schedule = new TreeMap<>();

    /*public void addSchedule(Field field) {

        String subject = String.format("%S", field.getSubject());
        schedule.append("Subject " + subject);
        String timeStart = String.format("%S", field.getStartHour() + "." + field.getStartMinut());
        schedule.append(" begin at: " + timeStart);
        String lectureHall = String.format("%S", field.getLectureHall());
        schedule.append(" lecture hall is: " + lectureHall);
        String teacher = String.format("%S", field.getTeacher());
        schedule.append(" teacher: " + teacher + "\n");*/

        /*
         * System.out.println("Schedule " + day.getDayName() + " for group number " +
         * day.getDay().get(0).getGroupNumber().getNumber());
         * 
         * for (int i = 0; i < day.getDay().size(); i++) {
         * System.out.println("Subject: " + day.getDay().get(i).getSubject() +
         * " begin at: " + day.getDay().get(i).getStartHour() + "." +
         * day.getDay().get(i).getStartMinut() + " Lecture Hall is " +
         * day.getDay().get(i).getLectureHall().getNumber() + " with teacher " +
         * day.getDay().get(i).getTeacher().getFirstName() + " " +
         * day.getDay().get(i).getTeacher().getSecondName()); }
         */

    }

}
