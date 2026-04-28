import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Exercise4 {
    public static void main(String[] args) {

        // question 1
        Random random = new Random();

        int number = random.nextInt(100); // random mọi số int
        System.out.println("so nguyen : " + number);


        // question 2
        double number1 = random.nextDouble();
        System.out.println("so thuc : " + number1);


        // question 3
        String[] name = {"An", "Bình", "Cường", "Dũng", "Hà"};
        int index = random.nextInt(name.length);
        System.out.println(name[index]);


        // question 4
        LocalDate start = LocalDate.of(1995, 7, 24);
        LocalDate end = LocalDate.of(1995, 12, 20);
        long days = ChronoUnit.DAYS.between(start, end);
        long randomDays = random.nextInt((int) days + 1);
        LocalDate randomDate = start.plusDays(randomDays);
        System.out.println(randomDate);


        // question 5
        LocalDate nowQ5 = LocalDate.now();
        LocalDate oneYearAgoQ5 = nowQ5.minusYears(1);
        long daysQ5 = ChronoUnit.DAYS.between(oneYearAgoQ5, nowQ5);
        long randomDaysQ5 = random.nextInt((int) daysQ5 + 1);
        LocalDate resultDateQ5 = oneYearAgoQ5.plusDays(randomDaysQ5);
        System.out.println(resultDateQ5);

        // question 6
        LocalDate nowQ6 = LocalDate.now();
        int randomDaysQ6 = random.nextInt(10000);
        LocalDate resultDateQ6 = nowQ6.minusDays(randomDaysQ6);
        System.out.println(resultDateQ6);

        // question 7
        int threeDigitNumberQ7 = random.nextInt(900) + 100;
        System.out.println(threeDigitNumberQ7);
    }
}
