package backend;

import entity.Student;

public class Exercise4 {

    // Question 1
    public void question1() {
        Student st1 = new Student(1, "Duong", "Ha Noi");

        st1.setScore(5.5f);
        st1.addScore(1.5f);

        st1.printInfo();
    }
}