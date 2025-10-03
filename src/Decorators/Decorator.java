package Decorators;

import Course.Course;

public abstract class Decorator implements Course {
    public Course course;

    public Decorator(Course course) {
        this.course = course;
    }

    @Override
    public void deliverContent() {
        course.deliverContent();
    }


}