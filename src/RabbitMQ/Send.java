package RabbitMQ;
// javac -cp "amqp-client-5.16.0.jar;slf4j-api-2.0.7.jar;slf4j-simple-2.0.7.jar" src\RabbitMQ\Send.java src\RabbitMQ\Recv.java
import com.rabbitmq.client.*;
//java -cp "src;amqp-client-5.16.0.jar;slf4j-api-2.0.7.jar;slf4j-simple-2.0.7.jar" RabbitMQ.Send

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Send {
    private final static String REQUEST_QUEUE = "weather_request";
    private final static String RESPONSE_QUEUE = "weather_response";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.queueDeclare(REQUEST_QUEUE, false, false, false, null);
            channel.queueDeclare(RESPONSE_QUEUE, false, false, false, null);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите город: ");
            String city = scanner.nextLine();

            channel.basicPublish("", REQUEST_QUEUE, null, city.getBytes(StandardCharsets.UTF_8));
            System.out.println("[x] Sent request for city: " + city);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println("[x] Received weather data: " + message);
            };

            channel.basicConsume(RESPONSE_QUEUE, true, deliverCallback, consumerTag -> {});
            System.out.println("Waiting for response...");
            Thread.sleep(10000); // ждём 10 секунд
        }
    }
}
