package Builder;

public class Weather {
    public String city;
    public String country;
    public String date;
    public String weather;
    public String temperature;
    public String humidity;
    public String windSpeed;

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
