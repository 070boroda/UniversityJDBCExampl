package com.foxminded.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString(includeFieldNames = false)
public class Teacher {
    private int id;
    @NonNull
    private String firstName;
    @NonNull
    private String secondName;

}
