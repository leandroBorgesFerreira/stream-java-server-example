package org.example.java_backend;

import io.getstream.chat.java.exceptions.StreamException;
import io.getstream.chat.java.models.App;
import io.getstream.chat.java.models.Message;
import io.getstream.chat.java.services.framework.Client;
import io.getstream.chat.java.services.framework.DefaultClient;

import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        try {
            var properties = new Properties();
            properties.put(DefaultClient.API_KEY_PROP_NAME, "[your-key-here!]");
            properties.put(DefaultClient.API_SECRET_PROP_NAME, "[your-secret-here!]");
            var client = new DefaultClient(properties);
            DefaultClient.setInstance(client);

            Message message = Message.send("messaging", "367e0f8e-e25f-48b8-ae43-5ce0979f843b")
                    .message(Message.MessageRequestObject.builder().text("Sample message").userId("marton").build())
                    .request()
                    .getMessage();
            
            System.out.println(message);


        } catch (StreamException e) {
            System.out.println(e);
        }
    }

}
