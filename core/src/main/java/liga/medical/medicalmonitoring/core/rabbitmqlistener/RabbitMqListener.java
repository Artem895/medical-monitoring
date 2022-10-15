package liga.medical.medicalmonitoring.core.rabbitmqlistener;

import com.fasterxml.jackson.core.JsonProcessingException;
import liga.medical.medicalmonitoring.core.services.RebbitSenderService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@EnableRabbit
@Component
public class RabbitMqListener {

    private final RebbitSenderService rebbitSenderService;

    @Autowired
    public RabbitMqListener(RebbitSenderService rebbitSenderService) {
        this.rebbitSenderService = rebbitSenderService;
    }

    @RabbitListener(queues = "common_monitoring")
    public void listencommonqueue(String message)  {
        try {
            rebbitSenderService.sendmessages(message);
        }
        catch (JsonProcessingException e){
            e.printStackTrace();
        }
    }
}
