package Builder;

public class Weather {
    String city;
    String country;
    String date;
    String weather;
    String temperature;
    String humidity;
    String windSpeed;

    public void printWeather(){
        System.out.println("City: " + city);
        System.out.println("Country: " + country);
        System.out.println("Date: " + date);
        System.out.println("Weather: " + weather);
        System.out.println("Temperature: " + temperature);
        System.out.println("Humidity: " + humidity);
        System.out.println("Wind Speed: " + windSpeed);
    }
}
