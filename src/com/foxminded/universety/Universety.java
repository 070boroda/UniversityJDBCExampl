package com.foxminded.universety;

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

        Schedule schedule = new Schedule();
        schedule.createSchedule(DayOfWeek.MONDAY, NumberLesson.ONE,
                new Field(subjectEnglish, group1, teacherAmerica, lectureHall201));
        schedule.createSchedule(DayOfWeek.MONDAY, NumberLesson.TWO,
                new Field(subjectGeografic, group1, teacherAqua, lectureHall202));
        schedule.createSchedule(DayOfWeek.MONDAY, NumberLesson.THREE,
                new Field(subjectGeometrik, group2, teacherAqua, lectureHall204));
        schedule.createSchedule(DayOfWeek.MONDAY, NumberLesson.ONE,
                new Field(subjectMathematic, group2, teacherAqua, lectureHall203));
        schedule.createSchedule(DayOfWeek.TUESDAY, NumberLesson.FOUR,
                new Field(subjectProgramming, group2, teacherAmerica, lectureHall204));

        schedule.getFieldTeacher(teacherAqua, DayOfWeek.MONDAY);
        schedule.getFieldTeacher(teacherAmerica, DayOfWeek.MONDAY);
        schedule.getFieldTeacher(teacherAmerica, DayOfWeek.TUESDAY);

    }
}
