package entity;

public class VietnamesePhone extends Phone {

    @Override
    public void insertContact(String name, String phone) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println("Da ton tai!");
                return;
            }
        }
        contacts.add(new Contact(name, phone));
    }

    @Override
    public void removeContact(String name) {
        contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));
    }

    @Override
    public void updateContact(String name, String newPhone) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                c.setPhone(newPhone);
                return;
            }
        }
    }

    @Override
    public void searchContact(String name) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println(c.getName() + " - " + c.getPhone());
            }
        }
    }

    public void showAll() {
        for (Contact c : contacts) {
            System.out.println(c.getName() + " - " + c.getPhone());
        }
    }
}