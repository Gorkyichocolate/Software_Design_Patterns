package Course;

import Decorators.Decorator;

public class ProgrammingCourse extends Decorator {
    public ProgrammingCourse(Course course){
        super(course);
    }
    @Override
    public void deliverContent() {
        super.deliverContent();
        System.out.println("ProgrammingCourse");
    }
}