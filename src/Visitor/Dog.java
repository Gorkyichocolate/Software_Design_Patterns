package Visitor;

public class Dog implements Animal {
    @Override
    public void doJob(Visitor visitor) {
        visitor.doDog();
    }
}
