import Visitor.*;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();


        animal.doJob(new ConcreteVisitor());
    }
}