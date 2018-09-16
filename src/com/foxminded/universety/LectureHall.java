package com.foxminded.universety;

public class LectureHall {
    private int number;

    public LectureHall(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "" + number + "";
    }

}
