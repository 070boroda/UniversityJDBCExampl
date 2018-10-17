package com.foxminded.universety;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = false)
@AllArgsConstructor
public class LectureHall {
    private int id;
    private int number;
}
