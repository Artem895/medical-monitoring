package liga.medical.medicalmonitoring.core.solid;

public interface AntiI  {
     void sendMessageToAlertQueue();
     void sendMessageToDailyQueue();
     void sendMessageToErrorQueue();
     void getMessageFromErrorQueue();
     void getMessageFromDailyQueue();
     void getMessageFromAlertQueue();

}
