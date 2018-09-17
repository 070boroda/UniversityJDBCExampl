package com.foxminded.universety;

import java.util.Map;

public class Universety {

    public void createUniverseti() {
        Group group1 = new Group("0001");
        Group group2 = new Group("0002");

        group1.addStudent(new Student("Vladimir", "Putin"));
        group1.addStudent(new Student("Sashka", "Lukash"));
        group2.addStudent(new Student("Dimka", "Medvedev"));
        group2.addStudent(new Student("Angelka", "Merkel"));
        group2.addStudent(new Student("Donald", "Tramp"));

        Teacher teacherAmerica = new Teacher("Capitan", "America");
        Teacher teacherSpider = new Teacher("Spider", "Man");
        Teacher teacherIron = new Teacher("Iron", "Man");
        Teacher teacherHaw = new Teacher("Haw", "Key");
        Teacher teacherAqua = new Teacher("Aqua", "Man");

        Subject subjectMathematic = new Subject("Mathematic");
        Subject subjectEnglish = new Subject("English");
        Subject subjectProgramming = new Subject("Programming");
        Subject subjectGeometrik = new Subject("Geometric");
        Subject subjectGeografic = new Subject("Geografic");

        LectureHall lectureHall201 = new LectureHall(201);
        LectureHall lectureHall202 = new LectureHall(202);
        LectureHall lectureHall203 = new LectureHall(203);
        LectureHall lectureHall204 = new LectureHall(204);

        Field mondayFild = new Field();
        mondayFild.addFields(new Field(subjectEnglish, group1, teacherAmerica, lectureHall201));
        mondayFild.addFields(new Field(subjectGeografic, group1, teacherAqua, lectureHall202));
        mondayFild.addFields(new Field(subjectEnglish, group1, teacherSpider, lectureHall203));
        mondayFild.addFields(new Field(subjectMathematic, group1, teacherSpider, lectureHall204));

        Field tuesdayFild = new Field();
        tuesdayFild.addFields(new Field(subjectProgramming, group1, teacherHaw, lectureHall204));
        tuesdayFild.addFields(new Field(subjectGeometrik, group1, teacherHaw, lectureHall202));
        tuesdayFild.addFields(new Field(subjectMathematic, group1, teacherIron, lectureHall201));

        Schedule mondayShcedule = new Schedule();
        mondayShcedule.createSchedule(DayOfWeek.MONDAY, mondayFild.getFields());
        // mondayShcedule.createSchedule(DayOfWeek.WEDNESDAY, tuesdayFild.getFields());

        System.out.println(mondayShcedule.getSchedule().keySet().toString());

        for (Map.Entry<NUMBER_LESSON, Field> item : mondayShcedule.getSchedule().get(DayOfWeek.MONDAY).entrySet()) {
            System.out.printf("[ %s ] - %s  \n", item.getKey(), item.getValue());

        }
    }
}
