package RabbitMQ;
//javac -cp "amqp-client-5.16.0.jar;slf4j-api-2.0.7.jar;slf4j-simple-2.0.7.jar" src\RabbitMQ\Send.java src\RabbitMQ\Recv.java
import com.rabbitmq.client.*;
//java -cp "src;amqp-client-5.16.0.jar;slf4j-api-2.0.7.jar;slf4j-simple-2.0.7.jar" RabbitMQ.Recv
public class Recv {

    private final static String QUEUE_NAME = "weatherdata";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }
}
