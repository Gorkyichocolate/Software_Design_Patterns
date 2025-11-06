package Visitor;

public class ConcreteVisitor implements Visitor {
    @Override
    public void doSDP(){
        System.out.println("Patterns will make your life easier");
    }

    @Override
    public void doDAA(){
        System.out.println("Algorithms will make your life harder");
    }

    @Override
    public void doWT() {
        System.out.println("Frontend will make you unemployed");
    }

}
