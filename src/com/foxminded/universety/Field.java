package com.foxminded.universety;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Field {
    @NonNull
    private Subject subject;
    @NonNull
    private Group groupNumber;
    @NonNull
    private Teacher teacher;
    @NonNull
    private LectureHall lectureHall;

    @Override
    public String toString() {
        return " " + subject + " group: " + groupNumber + " teacher:  " + teacher + " in  " + lectureHall + " ";
    }
}
