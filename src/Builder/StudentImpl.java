package Builder;


public class StudentImpl implements StudentBuilder {
    Student student = new Student();

    @Override
    public StudentBuilder setName(String name) {
        student.name = name;
        return this;
    }

    @Override
    public StudentBuilder setCourseName(String courseName) {
        student.courseName = courseName;
        return this;
    }

    @Override
    public StudentBuilder setMentor(boolean mentor) {
        student.mentor = mentor;
        return this;
    }

    @Override
    public StudentBuilder setGamification(boolean gamification){
        student.gamification = gamification;
        return this;
    }

    @Override
    public Student build() {
        return student;
    }
}
