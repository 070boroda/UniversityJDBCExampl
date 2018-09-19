package com.foxminded.universety;

import java.util.ArrayList;
import java.util.List;

public class Field {

    private Subject subject;
    private Group groupNumber;
    private Teacher teacher;
    private LectureHall lectureHall;
    private List<Field> fields = new ArrayList<>();

    public Field() {
    }

    public Field(Subject subject, Group groupNumber, Teacher teacher, LectureHall lectureHall) {
        this.subject = subject;
        this.groupNumber = groupNumber;
        this.teacher = teacher;
        this.lectureHall = lectureHall;
    }

    protected Subject getSubject() {
        return subject;
    }

    protected void setSubject(Subject subject) {
        this.subject = subject;
    }

    protected Group getGroupNumber() {
        return groupNumber;
    }

    protected void setGroupNumber(Group groupNumber) {
        this.groupNumber = groupNumber;
    }

    protected Teacher getTeacher() {
        return teacher;
    }

    protected void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    protected LectureHall getLectureHall() {
        return lectureHall;
    }

    protected void setLectureHall(LectureHall lectureHall) {
        this.lectureHall = lectureHall;
    }

    protected void addFields(Field field) {
        this.fields.add(field);
    }

    protected List getFields() {
        return fields;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fields == null) ? 0 : fields.hashCode());
        result = prime * result + ((groupNumber == null) ? 0 : groupNumber.hashCode());
        result = prime * result + ((lectureHall == null) ? 0 : lectureHall.hashCode());
        result = prime * result + ((subject == null) ? 0 : subject.hashCode());
        result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Field other = (Field) obj;
        if (fields == null) {
            if (other.fields != null)
                return false;
        } else if (!fields.equals(other.fields))
            return false;
        if (groupNumber == null) {
            if (other.groupNumber != null)
                return false;
        } else if (!groupNumber.equals(other.groupNumber))
            return false;
        if (lectureHall == null) {
            if (other.lectureHall != null)
                return false;
        } else if (!lectureHall.equals(other.lectureHall))
            return false;
        if (subject == null) {
            if (other.subject != null)
                return false;
        } else if (!subject.equals(other.subject))
            return false;
        if (teacher == null) {
            if (other.teacher != null)
                return false;
        } else if (!teacher.equals(other.teacher))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return " " + subject + " group: " + groupNumber + " teacher: " + teacher + " in " + lectureHall + "";
    }
}
