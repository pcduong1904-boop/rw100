import java.util.Arrays;

public class Exercise5 {

    static class Department implements Comparable<Department> {
        int id;
        String name;

        Department(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "id=" + id + ", name=" + name;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Department)) return false;
            Department other = (Department) obj;
            return this.name.equals(other.name);
        }

        @Override
        public int compareTo(Department other) {
            return this.name.compareTo(other.name);
        }
    }

    static Department[] departments = {
            new Department(1, "Sale"),
            new Department(2, "Marketing"),
            new Department(3, "Accounting"),
            new Department(4, "Boss of director"),
            new Department(5, "Waiting room")
    };

    public static void main(String[] args) {
        question1();
        question2();
        question3();
        question4();
        question5();
        question6();
        question7();
    }
    //question1
    public static void question1() {
        System.out.println(departments[0]);
    }
    //question2
    public static void question2() {
        for (Department d : departments) {
            System.out.println(d);
        }
    }
    //question3
    public static void question3() {
        System.out.println(departments[0].name);
    }
    //question4
    public static void question4() {
        System.out.println(departments[0].name.equals("Phong A"));
    }
    //question5
    public static void question5() {
        System.out.println(departments[0].equals(departments[1]));
    }
    //question6
    public static void question6() {
        Department[] sorted = departments.clone();
        Arrays.sort(sorted);
        for (Department d : sorted) {
            System.out.println(d.name);
        }
    }
    //question7
    public static void question7() {
        Department[] sorted = departments.clone();
        Arrays.sort(sorted);
        String result = "";
        for (int i = 0; i < sorted.length; i++) {
            result += sorted[i].name;
            if (i < sorted.length - 1) result += " ";
        }
        System.out.println(result);
    }
}