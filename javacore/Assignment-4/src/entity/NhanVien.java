package entity;

public class NhanVien extends CanBo {
    private String congViec;

    public NhanVien(String name, int age, String gender, String address, String congViec) {
        super(name, age, gender, address);
        this.congViec = congViec;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Cong viec: " + congViec);
    }
}