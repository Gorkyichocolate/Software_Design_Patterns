package StrategyNotifications;

public class ConcreteStrategyTelegram implements Strategy{
    @Override
    public void messenger() {
        System.out.println("Sending telegram");
    }
}
