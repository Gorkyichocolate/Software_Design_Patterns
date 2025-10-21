package Menu;

import Course.*;

public class SelectCourse {
    public Course selectCourse() {
        while (true) {
            System.out.println("select course:");
            System.out.println("1. Programming");
            System.out.println("2. Math");
            System.out.println("3. Language");
            System.out.println("0. return to main menu");
            System.out.print("choose: ");
            int choice = GetChoice.getChoice();
            GetChoice.getScanner().nextLine();

            switch (choice) {
                case 1 -> { return new ProgrammingCourse(); }
                case 2 -> { return new MathCourse(); }
                case 3 -> { return new LanguageCourse(); }
                case 0 -> { return null; }
                default -> System.out.println("invalid option, try again.");
            }
        }
    }
}
