package liga.medical.medicalmonitoring.core.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String ALERT_QUEUE = "alert queue";
    public static final String DAILY_QUEUE = "daily queue";
    public static final String ERROR_QUEUE = "error queue";
    private static final String HOST = "rabbit";

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory(HOST);
    }

    @Bean
    public AmqpAdmin ampqAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTamplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean("dailyQueue")
    public Queue dailyqueue() {
        return new Queue(DAILY_QUEUE);
    }

    @Bean("alertQueue")
    public Queue alertqueue() {
        return new Queue(ALERT_QUEUE);
    }

    @Bean("errorQueue")
    public Queue errorqueue() {
        return new Queue(ERROR_QUEUE);
    }

}
