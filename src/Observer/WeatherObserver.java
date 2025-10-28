package Observer;

import Builder.Weather;

public class WeatherObserver implements Observer{
    private NotifierStrategy notifierStrategy;
    private String name;

    public WeatherObserver(String name,NotifierStrategy notifierStrategy) {
        this.name = name;
        this.notifierStrategy = notifierStrategy;
    }

    public void setNotifierStrategy(NotifierStrategy notifierStrategy) {
        this.notifierStrategy = notifierStrategy;
    }

    @Override
    public void update(Weather weather) {
        String message = "";
        notifierStrategy.sendNotification(message);

    }
}
