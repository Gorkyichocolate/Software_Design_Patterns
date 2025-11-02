package StrategyWeather;

public class ConcreteStrategyMinute implements Strategy {

    @Override
    public long getIntervalMillis() {
        return 60 * 1000;
    }

    @Override
    public String getIntervalName() {
        return "Every Minute";
    }

    @Override
    public void getType() {

    }
}
