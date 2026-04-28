import java.time.LocalDate;

public class Exercise1 {
    public static void main(String[] args) {
        // 1.Department
        Department dep1 = new Department();
        dep1.id = 1;
        dep1.name = "Sale";

        Department dep2 = new Department();
        dep2.id = 2;
        dep2.name = "Marketing";

        Department dep3 = new Department();
        dep3.id = 3;
        dep3.name = "IT";

        // 2.Position
        Position pos1 = new Position();
        pos1.id = 1;
        pos1.name = Position.PositionName.DEV;

        Position pos2 = new Position();
        pos2.id = 2;
        pos2.name = Position.PositionName.TEST;

        Position pos3 = new Position();
        pos3.id = 3;
        pos3.name = Position.PositionName.PM;

        // 3. Account
        Account acc1 = new Account();
        acc1.id = 1;
        acc1.username = "vana";
        acc1.email = "vana@gmail.com";
        acc1.fullName = "Nguyen Van A";
        acc1.department = dep3;
        acc1.position = pos1;
        acc1.createDate = LocalDate.now();

        Account acc2 = new Account();
        acc2.id = 2;
        acc2.username = "vanb";
        acc2.email = "vanb@gmail.com";
        acc2.fullName = "Tran Van B";
        acc2.department = dep1;
        acc2.position = pos2;
        acc2.createDate = LocalDate.of(2021, 3, 15);

        Account acc3 = new Account();
        acc3.id = 3;
        acc3.username = "thic";
        acc3.email = "thic@gmail.com";
        acc3.fullName = "Le Thi C";
        acc3.department = dep2;
        acc3.position = pos3;
        acc3.createDate = LocalDate.of(2022, 5, 20);

        // 4. Group
        Group group1 = new Group();
        group1.id = 1;
        group1.name = "A";
        group1.creator = acc1;
        group1.createDate = LocalDate.now();

        Group group2 = new Group();
        group2.id = 2;
        group2.name = "B";
        group2.creator = acc1;
        group2.createDate = LocalDate.now();

        Group group3 = new Group();
        group3.id = 3;
        group3.name = "C";
        group3.creator = acc3;
        group3.createDate = LocalDate.now();

        // 5. Group Account
        GroupAccount ga1 = new GroupAccount();
        ga1.group = group1;
        ga1.account = acc3;
        ga1.joinDate = LocalDate.now();

        GroupAccount ga2 = new GroupAccount();
        ga2.group = group1;
        ga2.account = acc3;
        ga2.joinDate = LocalDate.now();

        GroupAccount ga3 = new GroupAccount();
        ga3.group = group2;
        ga3.account = acc3;
        ga3.joinDate = LocalDate.now();

        // 6. Type Question
        TypeQuestion type1 = new TypeQuestion();
        type1.id = 1;
        type1.name = TypeQuestion.TypeQuestionName.ESSAY;

        TypeQuestion type2 = new TypeQuestion();
        type2.id = 2;
        type2.name = TypeQuestion.TypeQuestionName.MULTIPLE_CHOICE;

        // 7. CategoryQuestion
        CategoryQuestion cat1 = new CategoryQuestion();
        cat1.id = 1;
        cat1.name = "Java";

        CategoryQuestion cat2 = new CategoryQuestion();
        cat2.id = 2;
        cat2.name = "SQL";

        CategoryQuestion cat3 = new CategoryQuestion();
        cat3.id = 3;
        cat3.name = "Ruby";

        // 8. Question
        Question q1 = new Question();
        q1.id = 1;
        q1.content = "Java là gì?";
        q1.category = cat1;
        q1.type = type1;
        q1.creator = acc1;
        q1.createDate = LocalDate.now();

        Question q2 = new Question();
        q2.id = 2;
        q2.content = "SQL là gì?";
        q2.category = cat2;
        q2.type = type2;
        q2.creator = acc2;
        q2.createDate = LocalDate.now();

        Question q3 = new Question();
        q3.id = 3;
        q3.content = "Ruby là gì?";
        q3.category = cat3;
        q3.type = type1;
        q3.creator = acc3;
        q3.createDate = LocalDate.now();

        // 9.Answer
        Answer ans1 = new Answer();
        ans1.id = 1;
        ans1.content = "A";
        ans1.question = q1;
        ans1.isCorrect = true;

        Answer ans2 = new Answer();
        ans2.id = 2;
        ans2.content = "B";
        ans2.question = q2;
        ans2.isCorrect = true;

        Answer ans3 = new Answer();
        ans3.id = 3;
        ans3.content = "C";
        ans3.question = q3;
        ans3.isCorrect = false;

        // 10. Exam
        Exam ex1 = new Exam();
        ex1.id = 1;
        ex1.code = "A1B2C";
        ex1.title = "Java";
        ex1.category = cat1;
        ex1.duration = 60;
        ex1.creator = acc1;
        ex1.createDate = LocalDate.now();

        Exam ex2 = new Exam();
        ex2.id = 2;
        ex2.code = "XYZ99";
        ex2.title = "SQL";
        ex2.category = cat2;
        ex2.duration = 45;
        ex2.creator = acc2;
        ex2.createDate = LocalDate.now();

        Exam ex3 = new Exam();
        ex3.id = 3;
        ex3.code = "R4B7K1";
        ex3.title = "Ruby";
        ex3.category = cat3;
        ex3.duration = 90;
        ex3.creator = acc3;
        ex3.createDate = LocalDate.now();

        // 11. Exam Question
        ExamQuestion eq1 = new ExamQuestion();
        eq1.exam = ex1;
        eq1.question = q1;

        ExamQuestion eq2 = new ExamQuestion();
        eq2.exam = ex2;
        eq2.question = q2;

        ExamQuestion eq3 = new ExamQuestion();
        eq3.exam = ex3;
        eq3.question = q3;

        Department[] departments = {dep1, dep2, dep3};
        Position[] positions = {pos1, pos2, pos3};
        Account[] accounts = {acc1, acc2, acc3};
        GroupAccount[] groupAccounts = {ga1, ga2, ga3};
        Group[] groups = {group1, group2, group3};
        TypeQuestion[] typeQuestions = {type1, type2};
        CategoryQuestion[] categoryQuestions = {cat1, cat2, cat3};
        Question[] questions = {q1, q2, q3};
        Answer[] answers = {ans1, ans2, ans3};
        Exam[] exams = {ex1, ex2, ex3};
        ExamQuestion[] examQuestions = {eq1, eq2, eq3};

        //  QUESTION 1
        if (accounts[1].department == null) {
            System.out.println("Nhân viên này chưa có phòng ban");
        } else {
            System.out.println("Phòng ban của nhân viên này là " + accounts[1].department.name);
        }

        //  QUESTION 2
        int count = 0;
        for (GroupAccount ga : groupAccounts) {
            if (ga.account == accounts[1]) count++;
        }

        if (count == 0)
            System.out.println("Nhân viên này chưa có group");
        else if (count <= 2)
            System.out.println("Group: Java Fresher, C# Fresher");
        else if (count == 3)
            System.out.println("Người quan trọng");
        else
            System.out.println("Hóng chuyện");

        // QUESTION 3
        String q3_2 = (accounts[1].department == null)
                ? "Nhân viên này chưa có phòng ban"
                : "Phòng ban của nhân viên này là " + accounts[1].department.name;
        System.out.println(q3_2);

        // =QUESTION 4
        String q4 = (accounts[0].position.name == Position.PositionName.DEV)
                ? "Đây là Developer"
                : "Không phải Dev";
        System.out.println(q4);

        //  QUESTION 5
        int countGroup1 = 0;
        for (GroupAccount ga : groupAccounts) {
            if (ga.group == groups[0]) countGroup1++;
        }

        switch (countGroup1) {
            case 1: System.out.println("Nhóm có một thành viên"); break;
            case 2: System.out.println("Nhóm có hai thành viên"); break;
            case 3: System.out.println("Nhóm có ba thành viên"); break;
            default: System.out.println("Nhóm có nhiều thành viên");
        }

        // QUESTION 6
        switch (count) {
            case 0: System.out.println("Chưa có group"); break;
            case 1:
            case 2: System.out.println("Có 1-2 group"); break;
            case 3: System.out.println("Quan trọng"); break;
            default: System.out.println("Hóng chuyện");
        }

        // QUESTION 7
        switch (accounts[0].position.name) {
            case DEV: System.out.println("Dev"); break;
            default: System.out.println("Không phải Dev");
        }

        //  QUESTION 8
        for (Account acc : accounts) {
            System.out.println(acc.email + " - " + acc.fullName + " - " + acc.department.name);
        }

        // QUESTION 9
        for (Department d : departments) {
            System.out.println(d.id + " - " + d.name);
        }

        // QUESTION 10
        for (int i = 0; i < accounts.length; i++) {
            System.out.println("Account " + (i + 1));
            System.out.println(accounts[i].email);
        }

        //  QUESTION 11
        for (int i = 0; i < departments.length; i++) {
            System.out.println(departments[i].id + " - " + departments[i].name);
        }

        // QUESTION 12
        for (int i = 0; i < 2; i++) {
            System.out.println(departments[i].name);
        }

        //  QUESTION 13
        for (int i = 0; i < accounts.length; i++) {
            if (i == 1) continue;
            System.out.println(accounts[i].fullName);
        }

        //  QUESTION 14
        for (Account acc : accounts) {
            if (acc.id < 4) System.out.println(acc.fullName);
        }

        // UESTION 15
        for (int i = 0; i <= 20; i++) {
            if (i % 2 == 0) System.out.println(i);
        }

        // QUESTION 16
        int i = 0;
        while (i <= 20) {
            if (i % 2 != 0) {
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        }

        // QUESTION 17
        int j = 0;
        do {
            if (j % 2 == 0) System.out.println(j);
            j++;
        } while (j <= 20);

        }

    }

