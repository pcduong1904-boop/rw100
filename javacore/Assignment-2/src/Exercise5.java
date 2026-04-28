import java.time.LocalDate;
import java.util.*;

public class Exercise5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //  Question 1
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        //  Question 2
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();

        scanner.nextLine(); // fix lỗi

        //  Question 3
        String fullName = scanner.nextLine();

        // Question 4
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        //  Question 5
        String username = scanner.nextLine();
        int pos = scanner.nextInt();
        scanner.nextLine();

        String position;
        switch (pos) {
            case 1: position = "Dev"; break;
            case 2: position = "Test"; break;
            case 3: position = "ScrumMaster"; break;
            case 4: position = "PM"; break;
            default: position = "Unknown";
        }

        System.out.println(username + " - " + position);

        //  Question 6
        String department = scanner.nextLine();
        System.out.println(department);

        // Question 7
        int n;
        do {
            n = scanner.nextInt();
        } while (n % 2 != 0);

        scanner.nextLine();

        //  Data
        List<String> usernames = new ArrayList<>();
        usernames.add(username);

        List<String> groups = Arrays.asList("Java", "SQL", "Test");
        Map<String, List<String>> userGroups = new HashMap<>();
        userGroups.put(username, new ArrayList<>());

        //  Question 8
        while (true) {

            System.out.println("1.Account 2.Department 3.AddGroup 4.RandomGroup");
            int choice = scanner.nextInt();
            scanner.nextLine();

            //  Question 9
            if (choice == 3) {
                for (String u : usernames) System.out.println(u);
                String user = scanner.nextLine();

                for (String g : groups) System.out.println(g);
                String group = scanner.nextLine();

                userGroups.get(user).add(group);
            }

            // Question 11
            else if (choice == 4) {
                for (String u : usernames) System.out.println(u);
                String user = scanner.nextLine();

                Random random = new Random();
                String randomGroup = groups.get(random.nextInt(groups.size()));

                userGroups.get(user).add(randomGroup);
            }

            // Question 10
            System.out.println("Tiep tuc? (y/n)");
            String ans = scanner.nextLine();
            if (ans.equalsIgnoreCase("n")) {
                return;
            }
        }
    }
}