package frontend;

import backend.Exercise1;
import backend.Exercise4;
import backend.Exercise6;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Exercise1 ex1 = new Exercise1();

        ex1.question1();
        ex1.question2();
        ex1.question3();

        Exercise4 ex4 = new Exercise4();
        ex4.question1();

        Exercise6 ex6 = new Exercise6();
        ex6.question1();
    }
}