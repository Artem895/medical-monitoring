package liga.medical.medicalmonitoring.dto.rabbitmqdto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Message {

    @JsonProperty("MessageType")
    private MessageType messageType;

    @JsonProperty("Message")
    private String message;
}
