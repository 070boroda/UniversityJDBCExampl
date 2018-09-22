package com.foxminded.universety;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lombok.AccessLevel;
import lombok.Getter;

@Getter(value = AccessLevel.PROTECTED)
public class Schedule {

    private Map<DayOfWeek, Map<NumberLesson, List<Field>>> schedule = new TreeMap<>();

    protected void createSchedule(DayOfWeek day, NumberLesson number, Field field) {
        if (!schedule.containsKey(day)) {
            schedule.put(day, new TreeMap<NumberLesson, List<Field>>());
            List<Field> temp = new ArrayList<>();
            temp.add(field);
            schedule.get(day).put(number, temp);
        } else {
            if (!schedule.get(day).containsKey(number)) {
                List<Field> temp = new ArrayList<>();
                temp.add(field);
                schedule.get(day).put(number, temp);
            } else {
                schedule.get(day).get(number).add(field);
            }
        }
    }

    protected void getFieldTeacher(Teacher teacher, DayOfWeek day) {
        System.out.printf("Classes of %S \n", day);
        for (NumberLesson number : NumberLesson.values()) {
            if (schedule.get(day).containsKey(number))
                for (Field field : schedule.get(day).get(number)) {
                    if (teacher.equals(field.getTeacher())) {
                        System.out.printf("%s", number.getDescription());
                        System.out.printf("%S \n", field);
                    }
                }
        }
    }

    protected void getFieldStudents(Student student, DayOfWeek day) {
        System.out.printf("Classes of %S \n", day);
        for (NumberLesson number : NumberLesson.values()) {
            if (schedule.get(day).containsKey(number))
                for (Field field : schedule.get(day).get(number)) {
                    for (Student stud : field.getGroupNumber().getStudents()) {
                        if (student.equals(stud))
                            System.out.printf("%s", number.getDescription());
                        System.out.printf("%S \n", field);
                    }
                }
        }
    }
}
