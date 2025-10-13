package Menu;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        int choice;
        do {
            System.out.println("\n=== Главное Меню ===");
            System.out.println("1. Регистрация студента");
            System.out.println("2. Исключение студента");
            System.out.println("3. Админ Панель");
            System.out.println("0. Закрыть меню");
            System.out.print("Выберите пункт: ");

            choice = getChoice();

            switch (choice) {
                case 1 -> registrationMenu();
                case 2 -> exclusionMenu();
                case 3 -> adminPanelMenu();
                case 0 -> System.out.println("Программа завершена.");
                default -> System.out.println("Ошибка выбора!");
            }
        } while (choice != 0);

        scanner.close();
    }

    private void registrationMenu() {
        System.out.println("\n=== Регистрация студента ===");

        System.out.print("Введите имя студента: ");
        String studentName = scanner.next();

        System.out.print("Введите курс: ");
        String courseName = scanner.next();

        System.out.println("\nВыберите дополнения:");
        System.out.println("1. Геймификация");
        System.out.println("2. Добавление Ментора");
        System.out.println("0. Без дополнений");
        System.out.print("Ваш выбор: ");
        int extra = getChoice();

        switch (extra) {
            case 1 -> System.out.println("Студент " + studentName + " зарегистрирован на курс " + courseName + " с геймификацией.");
            case 2 -> System.out.println("Студент " + studentName + " зарегистрирован на курс " + courseName + " с ментором.");
            case 0 -> System.out.println("Студент " + studentName + " зарегистрирован без дополнений.");
            default -> System.out.println("Ошибка выбора!");
        }
    }


    private void exclusionMenu() {
        System.out.println("\n=== Исключение студента ===");
        System.out.print("Введите имя студента: ");
        String studentName = scanner.next();

        System.out.print("Введите группу студента: ");
        String groupName = scanner.next();

        System.out.println("Студент " + studentName + " из группы " + groupName + " исключён из системы.");
    }


    private void adminPanelMenu() {
        int choice;
        do {
            System.out.println("\n=== Админ Панель ===");
            System.out.println("1. Добавление Преподавателей");
            System.out.println("2. Добавление Группы");
            System.out.println("3. Добавление Курса");
            System.out.println("4. Удаление Группы");
            System.out.println("5. Увольнение Преподавателя");
            System.out.println("0. Назад");
            System.out.print("Выберите действие: ");

            choice = getChoice();

            switch (choice) {
                case 1 -> addTeacher();
                case 2 -> addGroup();
                case 3 -> addCourse();
                case 4 -> removeGroup();
                case 5 -> fireTeacher();
                case 0 -> System.out.println("Возврат в главное меню...");
                default -> System.out.println("Ошибка выбора!");
            }
        } while (choice != 0);
    }

    private void addTeacher() {
        System.out.println("\n=== Добавление Преподавателя ===");
        System.out.print("Введите имя преподавателя: ");
        String teacherName = scanner.next();

        System.out.print("Введите направление преподавателя: ");
        String subject = scanner.next();

        System.out.println("Преподаватель " + teacherName + " добавлен по направлению " + subject + ".");
    }

    private void addGroup() {
        System.out.println("\n=== Добавление Группы ===");
        System.out.print("Введите направление группы: ");
        String groupDirection = scanner.next();

        System.out.print("Введите имя преподавателя: ");
        String teacherName = scanner.next();

        System.out.println("Группа по направлению " + groupDirection + " добавлена. Преподаватель: " + teacherName + ".");
    }

    private void addCourse() {
        System.out.println("\n=== Добавление Курса ===");
        System.out.print("Введите название курса: ");
        String courseName = scanner.next();

        System.out.println("Курс '" + courseName + "' успешно добавлен.");
    }

    private void removeGroup() {
        System.out.println("\n=== Удаление Группы ===");
        System.out.print("Введите номер группы: ");
        int groupNumber = getChoice();

        System.out.println("Группа №" + groupNumber + " успешно удалена.");
    }

    private void fireTeacher() {
        System.out.println("\n=== Увольнение Преподавателя ===");
        System.out.print("Введите имя преподавателя: ");
        String teacherName = scanner.next();

        System.out.println("Преподаватель " + teacherName + " уволен из системы.");
    }

    private int getChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Ошибка! Введите число: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        new Menu().start();
    }
}
