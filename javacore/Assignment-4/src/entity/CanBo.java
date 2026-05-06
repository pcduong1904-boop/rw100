package entity;

public class CanBo {
    private String name;
    private int age;
    private String gender;
    private String address;

    public CanBo(String name, int age, String gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void printInfo() {
        System.out.println("Ten: " + name + ", Tuoi: " + age +
                ", Gioi tinh: " + gender + ", Dia chi: " + address);
    }
}