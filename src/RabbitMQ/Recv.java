package RabbitMQ;
//javac -cp "amqp-client-5.16.0.jar;slf4j-api-2.0.7.jar;slf4j-simple-2.0.7.jar" src\RabbitMQ\Send.java src\RabbitMQ\Recv.java
//java -cp "src;amqp-client-5.16.0.jar;slf4j-api-2.0.7.jar;slf4j-simple-2.0.7.jar" RabbitMQ.Recv

import com.rabbitmq.client.*;
import Observer.WeatherSubject;
import Builder.Weather;
import Builder.WeatherImpl;
import java.nio.charset.StandardCharsets;

public class Recv {

    private final static String QUEUE_NAME = "weatherdata";
    private static WeatherSubject weatherSubject;

    public static void setWeatherSubject(WeatherSubject subject) {
        weatherSubject = subject;
    }

    public static void startListening() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            DeliverCallback deliverCallback = (tag, delivery) -> {
                String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println("Received weather data: " + message);

                try {
                    String city = parseValue(message, "\"city\":\"", "\"");
                    String country = parseValue(message, "\"country\":\"", "\"");
                    String date = parseValue(message, "\"date\":\"", "\"");
                    String weather = parseValue(message, "\"weather\":\"", "\"");
                    String temperature = parseValue(message, "\"temperature\":\"", "\"");
                    String humidity = parseValue(message, "\"humidity\":\"", "\"");
                    String windSpeed = parseValue(message, "\"windSpeed\":\"", "\"");

                    WeatherImpl builder = new WeatherImpl();
                    Weather weatherObj = builder
                        .setCity(city)
                        .setCountry(country)
                        .setDate(date)
                        .setWeather(weather)
                        .setTemperature(temperature)
                        .setHumidity(humidity)
                        .setWindSpeed(windSpeed)
                        .build();

                    if (weatherSubject != null) {
                        weatherSubject.notifyObservers(weatherObj);
                    }
                } catch (Exception e) {
                    System.err.println("Error parsing weather data: " + e.getMessage());
                }
            };

            channel.basicConsume(QUEUE_NAME, true, deliverCallback, tag -> { });

            Thread.currentThread().join();
        }
    }

    private static String parseValue(String message, String startPattern, String endPattern) {
        try {
            int startIndex = message.indexOf(startPattern);
            if (startIndex == -1) return "Unknown";
            startIndex += startPattern.length();
            int endIndex = message.indexOf(endPattern, startIndex);
            if (endIndex == -1) return "Unknown";
            return message.substring(startIndex, endIndex);
        } catch (Exception e) {
            return "Unknown";
        }
    }

    public static void main(String[] argv) throws Exception {
        startListening();
    }
}
