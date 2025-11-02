package RabbitMQ;

// javac -cp "amqp-client-5.16.0.jar;slf4j-api-2.0.7.jar;slf4j-simple-2.0.7.jar" src\RabbitMQ\Send.java src\RabbitMQ\Recv.java

//java -cp "src;amqp-client-5.16.0.jar;slf4j-api-2.0.7.jar;slf4j-simple-2.0.7.jar" RabbitMQ.Send

import com.rabbitmq.client.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Send {
    private final static String REQUEST_QUEUE = "weather_request";
    private static Connection connection;
    private static Channel channel;

    public static void initialize() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");

        connection = factory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(REQUEST_QUEUE, false, false, false, null);
    }

    public static void sendCityRequest(String city) throws Exception {
        if (channel == null) {
            initialize();
        }
        channel.basicPublish("", REQUEST_QUEUE, null, city.getBytes(StandardCharsets.UTF_8));
        System.out.println("Sent weather request for city: " + city);
    }

    public static void close() throws Exception {
        if (channel != null) channel.close();
        if (connection != null) connection.close();
    }

    public static void main(String[] args) throws Exception {
        initialize();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите город: ");
        String city = scanner.nextLine();

        sendCityRequest(city);
        close();
    }
}
