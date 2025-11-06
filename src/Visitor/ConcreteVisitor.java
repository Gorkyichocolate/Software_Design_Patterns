package Visitor;

public class ConcreteVisitor implements Visitor {
    @Override
    public void doDog(){
        System.out.println("Haw");
    }

    @Override
    public void doCat(){
        System.out.println("Meow");
    }

}
