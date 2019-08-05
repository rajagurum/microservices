package it.sella.messageservice.messageservice;

import it.sella.messageservice.messageservice.bean.MessageConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gbs04034 on 10-01-2019.
 */
@RestController
@RefreshScope
public class MessageConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/message")
    public MessageConfiguration message() {
        MessageConfiguration messageConfiguration = new MessageConfiguration(configuration.getMessage());
        return messageConfiguration;
    }
}
