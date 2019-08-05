package it.sella.messageservice.messageservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by gbs04034 on 10-01-2019.
 */
@Component
@ConfigurationProperties("message-service")
public class Configuration {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
