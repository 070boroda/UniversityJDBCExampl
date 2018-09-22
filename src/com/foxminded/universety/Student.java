package com.foxminded.universety;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private String firstName;
    private String secondName;

    @Override
    public String toString() {
        return firstName + secondName;
    }
}
