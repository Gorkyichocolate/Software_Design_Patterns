package Decorators;

import Course.Course;
import Course.Course;

public class MentorSupport extends Decorator {
    public MentorSupport(Course course){
        super(course);
    }

    @Override
    public void deliverContent() {
        super.deliverContent();
        System.out.println("adds personal mentor support.");
    }
}