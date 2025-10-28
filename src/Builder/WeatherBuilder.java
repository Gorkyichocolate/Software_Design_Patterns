package Builder;

public interface WeatherBuilder {
    WeatherBuilder setCity(String city);
     WeatherBuilder setCountry(String country);
     WeatherBuilder setDate(String date);
     WeatherBuilder setWeather(String weather);
     WeatherBuilder setTemperature(String temperature);
     WeatherBuilder setHumidity(String humidity);
     WeatherBuilder setWindSpeed(String windSpeed);
     Weather build();
}
