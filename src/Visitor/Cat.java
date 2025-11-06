package Visitor;

public class Cat implements  Animal{
    @Override
    public void doJob(Visitor visitor) {
        visitor.doCat();
    }
}
