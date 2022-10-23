package liga.medical.medicalmonitoring.core.solid;

import liga.medical.medicalmonitoring.dto.rabbitmqdto.Message;
import liga.medical.medicalmonitoring.dto.rabbitmqdto.MessageType;

public class AntiD {
    private AntiL antiL;

    public AntiD(AntiL antiL) {
        this.antiL = antiL;
    }
    public void doit(){
        antiL.sendMessagesToQueue(new Message());
    }
}
