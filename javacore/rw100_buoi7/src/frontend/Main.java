package frontend;
import backend.QLAccount;
import backend.QLDepartment;
import backend.QLPosition;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        QLDepartment.showDepartment("sale", 2);

        QLDepartment.showDepartmentHave2Employee();

        QLPosition.showAllPosition();
        QLPosition.findByPositionName("Dev");

        QLAccount.showAllAccount();
        QLAccount.findByFullname("Nguyen");
        QLAccount.findByFullnameAndUsername("Nguyen", "admin");
    }
}
