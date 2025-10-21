package Menu;

import java.sql.SQLException;

public class Menu {
    Registration registration = new Registration();
    StartLearning startLearning = new StartLearning();
    CompleteCourse completeCourse = new CompleteCourse();
    RemoveStudents removeStudents = new RemoveStudents();
    ShowAllStudents showAllStudents = new ShowAllStudents();
    ShowLeaderboard showLeaderboard = new ShowLeaderboard();

    public Menu() throws SQLException {}

    public void start() throws SQLException {
        int choice;
        do {
            System.out.println("===== Learning Management System =====");
            System.out.println("1. registration (enroll in course)");
            System.out.println("2. start learning (enter grades)");
            System.out.println("3. complete course (certificate)");
            System.out.println("4. remove student");
            System.out.println("5. show all students");
            System.out.println("6. show leaderboard");
            System.out.println("0. end");
            System.out.print("choose: ");
            choice = GetChoice.getChoice();

            switch (choice) {
                case 1 -> registration.registration();
                case 2 -> startLearning.startLearning();
                case 3 -> completeCourse.completeCourse();
                case 4 -> removeStudents.removeStudent();
                case 5 -> showAllStudents.showAllStudents();
                case 6 -> showLeaderboard.showLeaderboard();
                case 0 -> System.out.println("end");
                default -> System.out.println("error");
            }
        } while (choice != 0);
    }
}
