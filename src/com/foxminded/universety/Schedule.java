package com.foxminded.universety;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Schedule {

    private Map<DayOfWeek, Map<NumberLesson, Field>> schedule = new TreeMap<>();

    protected void createSchedule(DayOfWeek day, List<Field> filds) {
        Map<NumberLesson, Field> temp = new TreeMap<>();
        int i = 0;
        for (NumberLesson number : NumberLesson.values()) {
            if ((i < filds.size()))
                temp.put(number, filds.get(i));
            i++;
        }
        schedule.put(day, temp);
    }

    protected List<Field> getFieldTeacher(Teacher teacher, DayOfWeek day) {
        List<Field> result = new ArrayList<>();
        for (NumberLesson number : NumberLesson.values()) {
            if (schedule.get(day).containsKey(number) && teacher.equals(schedule.get(day).get(number).getTeacher())) {
                result.add(schedule.get(day).get(number));
            }
        }
        return result;
    }

    protected Map<DayOfWeek, Map<NumberLesson, Field>> getSchedule() {
        return schedule;
    }

    protected static void printDay(DayOfWeek day, Schedule schedule) {
        System.out.printf("Classes of %S \n", day);

        for (Map.Entry<NumberLesson, Field> item : schedule.getSchedule().get(day).entrySet()) {
            System.out.printf("[ %s ] - %s  \n", item.getKey().getDescription(), item.getValue());
        }
    }

}