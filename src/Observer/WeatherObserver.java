package Observer;

import Builder.Weather;
import Builder.WeatherBuilder;
import Builder.WeatherImpl;
import StrategyWeather.Strategy;
import java.util.Timer;
import java.util.TimerTask;

public class WeatherObserver implements Observer{
    private NotifierStrategy notifierStrategy;
    private String name;
    private Strategy intervalStrategy;
    private Timer timer;
    private Weather lastWeather;
    private WeatherBuilder weatherBuilder;

    public WeatherObserver(String name, NotifierStrategy notifierStrategy, Strategy intervalStrategy) {
        this.name = name;
        this.notifierStrategy = notifierStrategy;
        this.intervalStrategy = intervalStrategy;
        this.weatherBuilder = new WeatherImpl();
    }

    public void setNotifierStrategy(NotifierStrategy notifierStrategy) {
        this.notifierStrategy = notifierStrategy;
    }

    public void setIntervalStrategy(Strategy intervalStrategy) {
        this.intervalStrategy = intervalStrategy;
        restartTimer();
    }

    @Override
    public void update(Weather weather) {
        this.lastWeather = weather;

        if (timer == null) {
            startTimer();
        }
    }

    private void startTimer() {
        if (intervalStrategy != null) {
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (lastWeather != null) {
                        sendWeatherNotification();
                    }
                }
            }, 0, intervalStrategy.getIntervalMillis());
        }
    }

    private void restartTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (lastWeather != null) {
            startTimer();
        }
    }

    private void sendWeatherNotification() {
        StringBuilder message = new StringBuilder();
        message.append("🌤 Weather Update (").append(intervalStrategy.getIntervalName()).append(")\n\n");

        if (lastWeather.city != null) message.append("City: ").append(lastWeather.city).append("\n");
        if (lastWeather.country != null) message.append("Country: ").append(lastWeather.country).append("\n");
        if (lastWeather.date != null) message.append("Date: ").append(lastWeather.date).append("\n");
        if (lastWeather.weather != null) message.append("Weather: ").append(lastWeather.weather).append("\n");
        if (lastWeather.temperature != null) message.append("Temperature: ").append(lastWeather.temperature).append("\n");
        if (lastWeather.humidity != null) message.append("Humidity: ").append(lastWeather.humidity).append("\n");
        if (lastWeather.windSpeed != null) message.append("Wind Speed: ").append(lastWeather.windSpeed).append("\n");

        notifierStrategy.sendNotification(message.toString());
    }

    public void stopNotifications() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}
