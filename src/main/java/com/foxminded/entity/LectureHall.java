package main.java.com.foxminded.entity;

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
