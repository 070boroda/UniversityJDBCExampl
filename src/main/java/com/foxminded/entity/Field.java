package com.foxminded.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Field {

    public Field(int id) {
        super();
        this.id = id;
    }

    private int id;
    @NonNull
    private String dayLesson;
    @NonNull
    private int numberLesson;
    @NonNull
    private int subjectId;
    @NonNull
    private int groupId;
}
