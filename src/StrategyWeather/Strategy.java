package StrategyWeather;

public interface Strategy {
    long getIntervalMillis();
    String getIntervalName();

    void getType();
}
