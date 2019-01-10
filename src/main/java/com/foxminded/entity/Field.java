package com.foxminded.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Field {

    public Field(int id) {
        super();
        this.id = id;
    }

    private int id;
    @NonNull
    private String dayLesson;
    @NonNull
    private String numberLesson;
    @NonNull
    private Subject subject;
    @NonNull
    private Group group;
}
