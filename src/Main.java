import Course.*;
import Decorators.Certificate;
import Decorators.Gamification;
import Decorators.MentorSupport;
import Facade.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("Variant 3: Learning Management System (LMS)");
        MathCourse mathCourse = new MathCourse();
        ProgrammingCourse programmingCourse = new ProgrammingCourse();

        Course student1 = new Certificate(new MentorSupport(mathCourse));
        Course student2 = new Gamification(programmingCourse);
        StudentPortalFacade facade = new StudentPortalFacade();
        System.out.println("Demo");

        System.out.println("Student enrolls in MathCourse with MentorSupport + Certificate");

        facade.enrollInCourse(student1);
        student1.deliverContent();
        facade.startLearning(student1);
        facade.completeCourse(student1);

        System.out.println("-----------------------------------------");


        System.out.println("Student enrolls in ProgrammingCourse with Gamification");
        facade.enrollInCourse(student2);
        student2.deliverContent();
        facade.startLearning(student2);
        facade.completeCourse(student2);
    }
}





