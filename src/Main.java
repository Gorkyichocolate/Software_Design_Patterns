import Course.*;
import Decorators.Certificate;
import Decorators.Gamification;
import Decorators.MentorSupport;
import Facade.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("Variant 3: Learning Management System (LMS)");
        Course course = new NoCourse();
        Course course1 = new NoCourse();

        Course student1 = new Certificate(new MentorSupport(new MathCourse(course)));
        Course student2 = new Gamification(new ProgrammingCourse(course1));

        System.out.println("Demo");

        System.out.println("Student enrolls in MathCourse with MentorSupport + Certificate");

        StudentPortalFacade facade = new StudentPortalFacade();
        facade.enrollInCourse(student1);
        student1.deliverContent();
        facade.startLearning(student1);
        facade.completeCourse(student1);

        System.out.println("-----------------------------------------");


        System.out.println("Student enrolls in ProgrammingCourse with Gamification");
        facade.enrollInCourse(student2);
        student2.deliverContent();
        facade.completeCourse(student2);
    }
}





