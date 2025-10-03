package Patterns;

public class PCDecorater {
    public static void main(String[] args){
        PersonalComputer pc = new PC();
        PersonalComputer fullpc = new Keyboard(new Monitor(new Mouse(new WebCamera(pc))));

        fullpc.work();
    }
}

interface PersonalComputer{
    void work();
}

class PC implements PersonalComputer{
    @Override
    public void work() {
        System.out.println("Patterns.PC is working");
    }
}

abstract class PCDecorator implements PersonalComputer{
    protected PersonalComputer pc;

    public PCDecorator(PersonalComputer pc){
        this.pc = pc;
    }

    @Override
    public void work() {
        pc.work();
    }
}

class WebCamera extends PCDecorator{
    public WebCamera(PersonalComputer pc){
        super(pc);
    }

    @Override
    public void work() {
        super.work();
        System.out.println("Patterns.WebCamera is working");
    }
}

class Monitor extends PCDecorator{
    public Monitor(PersonalComputer pc){
        super(pc);
    }
    @Override
    public void work() {
        super.work();
        System.out.println("Patterns.Monitor is working");
    }
}

class Keyboard extends PCDecorator{
    public Keyboard(PersonalComputer pc){
        super(pc);
    }
    @Override
    public void work() {
        super.work();
        System.out.println("Patterns.Keyboard is working");

    }
}

class Mouse extends PCDecorator{
    public Mouse(PersonalComputer pc){
        super(pc);
    }
    @Override
    public void work() {
        super.work();
        System.out.println("Patterns.Mouse is working");

    }
}

