package backend;

import entity.VietnamesePhone;

public class Exercise6 {

    public void question1() {
        VietnamesePhone phone = new VietnamesePhone();

        phone.insertContact("an", "0123");
        phone.insertContact("binh", "0456");

        System.out.println("Danh sach");
        phone.showAll();

        System.out.println(" tim an ");
        phone.searchContact("an");

        System.out.println("update an");
        phone.updateContact("an", "0999");
        phone.showAll();

        System.out.println("xoa binh");
        phone.removeContact("binh");
        phone.showAll();
    }
}