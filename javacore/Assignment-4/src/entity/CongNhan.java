package entity;

public class CongNhan extends CanBo {
    private int bac;

    public CongNhan(String name, int age, String gender, String address, int bac) {
        super(name, age, gender, address);
        this.bac = bac;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Bac: " + bac);
    }
}