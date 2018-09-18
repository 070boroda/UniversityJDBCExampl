package com.foxminded.universety;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Schedule {

    private Map<DayOfWeek, Map<NUMBER_LESSON, Field>> schedule = new TreeMap<>();

    protected void createSchedule(DayOfWeek day, ArrayList<Field> filds) {
        Map<NUMBER_LESSON, Field> temp = new TreeMap<>();
        int i = 0;
        for (NUMBER_LESSON number : NUMBER_LESSON.values()) {
            if ((i < filds.size()))
                temp.put(number, filds.get(i));
            i++;
        }

        schedule.put(day, temp);
    }

    protected Map<DayOfWeek, Map<NUMBER_LESSON, Field>> getSchedule() {
        return schedule;
    }
}
