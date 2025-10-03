package Decorators;

import Course.Course;

public class Certificate extends Decorator {
    public Certificate(Course course){
        super(course);
    }
    @Override
    public void deliverContent() {
        super.deliverContent();
        System.out.println("grants certificate after completion.");
    }
}