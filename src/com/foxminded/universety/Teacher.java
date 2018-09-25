package com.foxminded.universety;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString(includeFieldNames = false)
public class Teacher {
    private String firstName;
    private String secondName;

}
