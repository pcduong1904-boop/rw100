
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Exercise3 {
    public static void main(String[] args) {

        //
        Exam ex1 = new Exam();
        ex1.id = 1;
        ex1.title = "Java";
        ex1.createDate = LocalDate.now();

        //  QUESTION 1
        DateTimeFormatter vnFormat =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        System.out.println("Exam 1:");
        System.out.println("Title: " + ex1.title);
        System.out.println("Create Date (VN): " + ex1.createDate.format(vnFormat));

        // QUESTION 2
        DateTimeFormatter fullFormat =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println("Exam đã tạo ngày: " + ex1.createDate.format(fullFormat));

        //  QUESTION 3
        DateTimeFormatter yearFormat =
                DateTimeFormatter.ofPattern("yyyy");

        System.out.println("Năm tạo: " + ex1.createDate.format(yearFormat));

        //  QUESTION 4
        DateTimeFormatter monthYearFormat =
                DateTimeFormatter.ofPattern("MM/yyyy");

        System.out.println("Tháng/Năm: " + ex1.createDate.format(monthYearFormat));

        //QUESTION 5
        DateTimeFormatter mmddFormat =
                DateTimeFormatter.ofPattern("MM-dd");

        System.out.println("MM-DD: " + ex1.createDate.format(mmddFormat));
    }
}