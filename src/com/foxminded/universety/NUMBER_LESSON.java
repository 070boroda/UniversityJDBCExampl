package com.foxminded.universety;

public enum NUMBER_LESSON {
    ONE("9.00"), TWO("10.00"), THREE("10.55"), FOUR("11.00"), FIVE("11.50"), SIX("12.00"), SEVEN("13.00"),
    EIGHT("14.00"), NINE("15.00");

    private String description;

    private NUMBER_LESSON(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
