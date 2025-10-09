package Facade;

import Course.*;

public class StudentPortalFacade{
    EnrollInCourse enrollInCourse = new EnrollInCourse();
    StartLearning startLearning = new StartLearning();
    CompleteCourse completeCourse = new CompleteCourse();

    public void enrollInCourse(Course course) {
        enrollInCourse.enrollInCourse();
    }

    public void startLearning(Course course) {
        startLearning.startLearning();
    }

    public void completeCourse(Course course) {
        completeCourse.completeCourse();
    }
}
