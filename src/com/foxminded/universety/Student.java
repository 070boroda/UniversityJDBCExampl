package com.foxminded.universety;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {

    private int id;
    @NonNull
    private String firstName;
    @NonNull
    private String secondName;

    @Override
    public String toString() {
        return firstName + secondName;
    }
}
