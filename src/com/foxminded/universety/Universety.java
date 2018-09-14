package com.foxminded.universety;

public class Universety {

    public void createUniverseti() {
        Group group1 = new Group(0001);
        Group group2 = new Group(0002);

        group1.addStudent(new Student("Vladimir", "Putin"));
        group1.addStudent(new Student("Sashka", "Lukash"));
        group2.addStudent(new Student("Dimka", "Medvedev"));
        group2.addStudent(new Student("Angelka", "Merkel"));
        group2.addStudent(new Student("Donald", "Tramp"));

        Teacher teacher1 = new Teacher("Capitan", "America");
        Teacher teacher2 = new Teacher("Spider", "Man");
        Teacher teacher3 = new Teacher("Iron", "Man");
        Teacher teacher4 = new Teacher("Haw", "Key");
        Teacher teacher5 = new Teacher("Aqua", "Man");

        Subject subject1 = new Subject("Mathematic");
        Subject subject2 = new Subject("English");
        Subject subject3 = new Subject("Programming");
        Subject subject4 = new Subject("Geometric");
        Subject subject5 = new Subject("Geografic");

        LectureHall lectureHall1 = new LectureHall(201);
        LectureHall lectureHall2 = new LectureHall(202);
        LectureHall lectureHall3 = new LectureHall(203);
        LectureHall lectureHall4 = new LectureHall(204);

        Field oneMonday = new Field(subject1, (float) 9.00 , group1, teacher1, lectureHall1);
        Field twoMonday = new Field(subject3, (float) 10.00, group1, teacher3, lectureHall3);

        Schedule monday = new Schedule("monday");
        Schedule tuesday = new Schedule("tuesday");
        monday.addSchedule(oneMonday);
        monday.addSchedule(twoMonday);
        tuesday.addSchedule(twoMonday);
        tuesday.addSchedule(oneMonday);
        
        Schedule june = new Schedule("June");
        
        june.addScheduleMonth(monday);
        june.addScheduleMonth(tuesday);
        
        Schedule.printSchedule(monday);
    }
}
