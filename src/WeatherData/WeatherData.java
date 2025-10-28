package WeatherData;
import Observer.Observer;

public interface WeatherData {
    public default void getType(){
        System.out.println("Weather Data: Type");
    }

}
