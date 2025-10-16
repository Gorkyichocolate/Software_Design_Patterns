package Builder;

public class Student {
    String name;
    String courseName;
    boolean mentor;
    boolean gamification;

    public void printStudent(){
        System.out.println("Student Name: " + name);
        System.out.println("Student Course: " + courseName);
        System.out.println("With Mentor: " + mentor);
        System.out.println("With Gamification: " + gamification);
    }
}

