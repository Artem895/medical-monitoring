package liga.medical.medicalmonitoring.core.solid;

import liga.medical.medicalmonitoring.dto.rabbitmqdto.Message;
import liga.medical.medicalmonitoring.dto.rabbitmqdto.MessageType;

import javax.xml.crypto.NoSuchMechanismException;

public class AntiL extends AntiO{
    @Override
    public void sendMessagesToQueue(Message message) {
        super.sendMessagesToQueue(message);
    }

    @Override
    public void getMessagesFromQueue(MessageType messageType) {
        System.out.println("Нельзя получать сообщения из очереди ");
        throw new NoSuchMechanismException();
    }
}
