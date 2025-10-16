package Builder;

public interface StudentBuilder{
    StudentBuilder setName(String name);
    StudentBuilder setCourseName(String courseName);
    StudentBuilder setMentor(boolean mentor);
    StudentBuilder setGamification(boolean gamification);
    Student build();
}

