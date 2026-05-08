package entity;

public class KySu extends CanBo {
    private String nganh;

    public KySu(String name, int age, String gender, String address, String nganh) {
        super(name, age, gender, address);
        this.nganh = nganh;
    }

    public KySu(){

    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }
}