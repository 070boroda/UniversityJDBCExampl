package main.java.com.foxminded.entity;

public class University {

    public void createUniversity() {
        Group group1 = new Group("0001");
        Group group2 = new Group("0002");

        group1.addStudent(new Student("Vladimir", "Putin"));
        group1.addStudent(new Student("Sashka", "Lukash"));
        group2.addStudent(new Student("Dimka", "Medvedev"));
        group2.addStudent(new Student("Angelka", "Merkel"));
        group2.addStudent(new Student("Donald", "Tramp"));

        Teacher teacherAmerica = new Teacher(1, "Capitan", "America");
        Teacher teacherSpider = new Teacher(2, "Spider", "Man");
        Teacher teacherIron = new Teacher(3, "Iron", "Man");
        Teacher teacherHawk = new Teacher(4, "Hawk", "Key");
        Teacher teacherAqua = new Teacher(5, "Aqua", "Man");

        Subject subjectMathematic = new Subject(1, "Mathematic");
        Subject subjectEnglish = new Subject(2, "English");
        Subject subjectProgramming = new Subject(3, "Programming");
        Subject subjectGeometrik = new Subject(4, "Geometric");
        Subject subjectGeografic = new Subject(5, "Geografic");

        LectureHall lectureHall201 = new LectureHall(1, 201);
        LectureHall lectureHall202 = new LectureHall(1, 202);
        LectureHall lectureHall203 = new LectureHall(1, 203);
        LectureHall lectureHall204 = new LectureHall(1, 204);

        Schedule schedule = new Schedule();
        schedule.createSchedule(DayOfWeek.MONDAY, NumberLesson.ONE,
                new Field(subjectEnglish, group1, teacherAmerica, lectureHall201));
        schedule.createSchedule(DayOfWeek.MONDAY, NumberLesson.TWO,
                new Field(subjectGeografic, group1, teacherAqua, lectureHall202));
        schedule.createSchedule(DayOfWeek.MONDAY, NumberLesson.THREE,
                new Field(subjectGeometrik, group2, teacherAqua, lectureHall204));
        schedule.createSchedule(DayOfWeek.MONDAY, NumberLesson.ONE,
                new Field(subjectMathematic, group2, teacherAqua, lectureHall203));
        schedule.createSchedule(DayOfWeek.MONDAY, NumberLesson.THREE,
                new Field(subjectMathematic, group1, teacherHawk, lectureHall204));
        schedule.createSchedule(DayOfWeek.MONDAY, NumberLesson.FIVE,
                new Field(subjectProgramming, group2, teacherIron, lectureHall202));

        schedule.createSchedule(DayOfWeek.TUESDAY, NumberLesson.FOUR,
                new Field(subjectProgramming, group2, teacherAmerica, lectureHall204));
        schedule.createSchedule(DayOfWeek.TUESDAY, NumberLesson.THREE,
                new Field(subjectEnglish, group2, teacherSpider, lectureHall204));

        schedule.getFieldTeacher(teacherAqua, DayOfWeek.MONDAY);
        schedule.getFieldTeacher(teacherAmerica, DayOfWeek.MONDAY);
        schedule.getFieldTeacher(teacherAmerica, DayOfWeek.TUESDAY);

    }
}
