package Course;


import Decorators.Decorator;

public class MathCourse extends Decorator {
    public MathCourse(Course course){
        super(course);
    }
    @Override
    public void deliverContent() {
        super.deliverContent();
        System.out.println("MathCourse");
    }
}