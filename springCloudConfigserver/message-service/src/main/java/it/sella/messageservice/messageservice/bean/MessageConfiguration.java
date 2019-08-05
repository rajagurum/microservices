package it.sella.messageservice.messageservice.bean;

/**
 * Created by gbs04034 on 10-01-2019.
 */
public class MessageConfiguration {

    private String message;

    public MessageConfiguration(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
