package liga.medical.medicalmonitoring.core.rabbitmqdto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import liga.medical.medicalmonitoring.core.view.Views;
import lombok.Data;

@Data
public class Message {

    @JsonProperty("MessageType")
    private MessageType messageType;

    @JsonView(Views.Public.class)
    @JsonProperty("Message")
    private String message;

    @JsonView(Views.Public.class)
    private int patient;

    @JsonView(Views.Public.class)
    private String helthstatus;

}
