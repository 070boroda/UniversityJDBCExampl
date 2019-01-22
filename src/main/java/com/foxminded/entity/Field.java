package com.foxminded.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Field {

    public Field(int id) {
        super();
        this.id = id;
    }

    private int id;
    private String dayLesson;
    private int numberLesson;
    private int subjectId;
    private int groupId;

    public Field(int numberLesson, String dayLesson, int subjectId, int groupId) {
        super();
        this.dayLesson = dayLesson;
        this.numberLesson = numberLesson;
        this.subjectId = subjectId;
        this.groupId = groupId;
    }

    public Field(int id, int numberLesson, String dayLesson, int subjectId, int groupId) {
        super();
        this.id = id;
        this.dayLesson = dayLesson;
        this.numberLesson = numberLesson;
        this.subjectId = subjectId;
        this.groupId = groupId;
    }
}
