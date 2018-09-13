package com.foxminded.universety;

public class Runnable {

    public void run() {
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
        Subject subject5 = new Subject("Geografi");

        LectureHall lectureHall1 = new LectureHall(201);
        LectureHall lectureHall2 = new LectureHall(202);
        LectureHall lectureHall3 = new LectureHall(203);
        LectureHall lectureHall4 = new LectureHall(204);

        Schedule oneMonday = new Schedule(subject1, "nine oclock", group1, teacher1, lectureHall1);
        Schedule twoMonday = new Schedule(subject3, "nine forty five", group1, teacher3, lectureHall3);

        Day monday = new Day("monday");
        monday.addSchedule(oneMonday);
        monday.addSchedule(twoMonday);

        System.out.println(monday.getDay().get(0).getSubject() + " " + monday.getDay().get(0).getStartTime());
    }
}
