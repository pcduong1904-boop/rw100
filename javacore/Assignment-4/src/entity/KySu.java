package entity;

public class KySu extends CanBo {
    private String nganh;

    public KySu(String name, int age, String gender, String address, String nganh) {
        super(name, age, gender, address);
        this.nganh = nganh;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Nganh: " + nganh);
    }
}