package entity;

public class Student {
    private int id;
    private String name;
    private String hometown;
    private float score;

    // Constructor
    public Student(int id, String name, String hometown) {
        this.id = id;
        this.name = name;
        this.hometown = hometown;
        this.score = 0;
    }

    // set điểm
    public void setScore(float score) {
        this.score = score;
    }

    // cộng thêm điểm
    public void addScore(float bonus) {
        this.score += bonus;
    }

    // xếp loại
    public String getRank() {
        if (score < 4) return "Yeu";
        else if (score < 6) return "Trung binh";
        else if (score < 8) return "Kha";
        else return "Gioi";
    }

    // in thông tin
    public void printInfo() {
        System.out.println("ID: " + id);
        System.out.println("Ten: " + name);
        System.out.println("Que quan: " + hometown);
        System.out.println("Diem: " + score);
        System.out.println("Xep loai: " + getRank());
    }
}