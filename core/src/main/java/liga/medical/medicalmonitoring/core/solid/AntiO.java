package liga.medical.medicalmonitoring.core.solid;

import liga.medical.medicalmonitoring.dto.rabbitmqdto.Message;
import liga.medical.medicalmonitoring.dto.rabbitmqdto.MessageType;

public class AntiO {
    public void sendMessagesToQueue(Message message){
        if (message.getMessageType()== MessageType.DAILY){
            System.out.println(message.getMessageType());
        }else if (message.getMessageType()==MessageType.ALERT){
            System.out.println(message.getMessageType());
        }
        else if (message.getMessageType()==MessageType.ERROR){
            System.out.println(message.getMessageType());
        }

    }
    public void getMessagesFromQueue(MessageType messageType){
        if (messageType== MessageType.DAILY){
            System.out.println(messageType);
        }else if (messageType==MessageType.ALERT){
            System.out.println(messageType);
        }
        else if (messageType==MessageType.ERROR){
            System.out.println(messageType);
        }
    }
}
