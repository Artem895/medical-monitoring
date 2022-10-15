package liga.medical.medicalmonitoring.core.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.medicalmonitoring.core.config.RabbitConfig;
import liga.medical.medicalmonitoring.dto.rabbitmqdto.Message;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RebbitSenderService {

    private final ObjectMapper objectMapper;
    private final AmqpTemplate amqpTemplate;

    @Autowired
    public RebbitSenderService(ObjectMapper objectMapper, AmqpTemplate amqpTemplate) {
        this.objectMapper = objectMapper;
        this.amqpTemplate = amqpTemplate;
    }

    public void sendmessages(String message) throws JsonProcessingException {

        Message message_new=objectMapper.readValue(message,Message.class);

        switch (message_new.getMessageType()){
            case DAILY:
                amqpTemplate.convertAndSend(RabbitConfig.DAILY_QUEUE,message);
                break;
            case ALERT:
                amqpTemplate.convertAndSend(RabbitConfig.ALERT_QUEUE,message);
                break;
            case ERROR:
                amqpTemplate.convertAndSend(RabbitConfig.ERROR_QUEUE,message);
                break;
            default:
                System.out.println("Нет таких сообщений");
        }
    }
}
