package telran.chat.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Message implements Serializable {

    private static final long serialVersionUID = -5644600155081980844L;
    LocalDateTime sendTime;
    String text;
    String userName;

    public LocalDateTime getSendTime() {        return sendTime;
    }

    public String getText() {
        return text;
    }

    public String getUserName() {
        return userName;
    }

    public Message(LocalDateTime sendTime, String text, String userName) {
        this.sendTime = sendTime;
        this.text = text;
        this.userName = userName;
    }
}
