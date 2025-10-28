package StrategyNotifications;

public class ConcreteStrategyEmail implements Strategy{
    @Override
    public void messenger() {
        System.out.println("Sending email");
    }
}
