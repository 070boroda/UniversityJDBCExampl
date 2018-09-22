package com.foxminded.universety;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString(includeFieldNames = false)
@EqualsAndHashCode
@Builder
public class Teacher {
    private String firstName;
    private String secondName;

}
