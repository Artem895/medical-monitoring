package liga.medical.medicalmonitoring.core.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.medicalmonitoring.core.config.RabbitConfig;
import liga.medical.medicalmonitoring.core.rabbitmqdto.Message;
import liga.medical.medicalmonitoring.core.view.Views;
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

        Message messagenew = objectMapper.readValue(message, Message.class);
        objectMapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
        String resultString=objectMapper.writerWithView(Views.Public.class).writeValueAsString(messagenew);
        switch (messagenew.getMessageType()) {
            case DAILY:
                amqpTemplate.convertAndSend(RabbitConfig.DAILY_QUEUE, resultString);
                break;
            case ALERT:
                amqpTemplate.convertAndSend(RabbitConfig.ALERT_QUEUE, resultString);
                break;
            case ERROR:
                amqpTemplate.convertAndSend(RabbitConfig.ERROR_QUEUE, resultString);
                break;
            default:
                System.out.println("Нет таких сообщений");
        }
    }
}
