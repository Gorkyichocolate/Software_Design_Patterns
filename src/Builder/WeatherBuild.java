package Builder;

public class WeatherBuild {
    public static void main(String[] args) {
        Weather showWeather = new WeatherImpl().setWeather("Cloud").build();
        showWeather.printWeather();
    }
}
