package Builder;

public class WeatherImpl implements WeatherBuilder{
    Weather weather1 = new Weather();

    @Override
    public WeatherBuilder setCity(String city) {
        weather1.city = city;
        return this;
    }

    @Override
    public WeatherBuilder setCountry(String country) {
        weather1.country = country;
        return this;
    }

    @Override
    public WeatherBuilder setDate(String date) {
        weather1.date = date;
        return this;
    }

    @Override
    public WeatherBuilder setWeather(String weather) {
       weather1.weather = weather;
        return this;
    }

    @Override
    public WeatherBuilder setTemperature(String temperature) {
        weather1.temperature = temperature;
        return this;
    }

    @Override
    public WeatherBuilder setHumidity(String humidity) {
        weather1.humidity = humidity;
        return this;
    }

    @Override
    public WeatherBuilder setWindSpeed(String windSpeed) {
        weather1.windSpeed = windSpeed;
        return this;
    }

    @Override
    public Weather build() {
        return weather1;
    }
}
