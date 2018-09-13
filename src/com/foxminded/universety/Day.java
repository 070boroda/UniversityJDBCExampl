package com.foxminded.universety;

import java.util.ArrayList;
import java.util.List;

public class Day {

    private List<Schedule> day;
    private String dayName;

    public Day(String dayName) {
        this.dayName = dayName;
        this.day = new ArrayList<>();
    }

    public List<Schedule> getDay() {
        return day;
    }

    public String getDayName() {
        return dayName;
    }

    public void addSchedule(Schedule schedule) {
        day.add(schedule);
    }
}
