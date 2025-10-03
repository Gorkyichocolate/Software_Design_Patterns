package Decorators;

import Course.Course;
import Course.Course;

public class Gamification extends Decorator {
    public Gamification(Course course){
        super(course);
    }

    @Override
    public void deliverContent(){
        super.deliverContent();
        System.out.println("adds points & leaderboard.");
    }
}