package com.foxminded.universety;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class LectureHall {
    @Getter
    @Setter(value = AccessLevel.PROTECTED)
    private int number;
}
