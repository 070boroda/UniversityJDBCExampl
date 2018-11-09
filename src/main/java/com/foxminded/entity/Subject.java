package main.java.com.foxminded.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Subject {
    private int id;
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
