package Observer;

import Builder.Weather;
import java.util.ArrayList;
import java.util.List;

public class WeatherSubject {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Weather weather) {
        for (Observer observer : observers) {
            observer.update(weather);
        }
    }
}
