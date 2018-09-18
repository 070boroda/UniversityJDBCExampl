package com.foxminded.universety;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Schedule {

    private Map<DayOfWeek, Map<NumberLesson, Field>> schedule = new TreeMap<>();

    protected void createSchedule(DayOfWeek day, ArrayList<Field> filds) {
        Map<NumberLesson, Field> temp = new TreeMap<>();
        int i = 0;
        for (NumberLesson number : NumberLesson.values()) {
            if ((i < filds.size()))
                temp.put(number, filds.get(i));
            i++;
        }
        schedule.put(day, temp);
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
