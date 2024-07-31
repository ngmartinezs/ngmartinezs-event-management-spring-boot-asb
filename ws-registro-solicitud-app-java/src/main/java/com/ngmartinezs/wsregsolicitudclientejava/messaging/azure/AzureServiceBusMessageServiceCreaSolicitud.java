package com.ngmartinezs.wsregsolicitudclientejava.messaging.azure;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import com.ngmartinezs.wsregsolicitudclientejava.dto.message.MessageDTO;
import com.ngmartinezs.wsregsolicitudclientejava.messaging.MessageService;

import jakarta.annotation.PreDestroy;

@Service("azureServiceBusMessageServiceCreaSolicitud")
public class AzureServiceBusMessageServiceCreaSolicitud implements MessageService{

   
    @Value("${azure.servicebus.connection.string}")
    public String connectionString;
    @Value("${azure.servicebus.topic.name}")
    public String topicName;
    
    private ServiceBusSenderClient serviceBusSenderClient;

    @Override
    public void sendMessage(MessageDTO messageDTO) throws Exception {
        // TODO Auto-generated method stub
        
        try {
            if (serviceBusSenderClient == null) {
                serviceBusSenderClient = new ServiceBusClientBuilder()
                    .connectionString(connectionString)
                    .sender()
                    .topicName(topicName)
                    .buildClient();
            }
        
            ObjectMapper objectMapper = new ObjectMapper();
            String message = objectMapper.writeValueAsString(messageDTO);

            serviceBusSenderClient.sendMessage(new ServiceBusMessage(message));
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void startMesssageListener() {
        // TODO Auto-generated method stub
    }

    @Override
    public void stopMessageListener() {
        // TODO Auto-generated method stub
    }

    @PreDestroy
    public void clean()
    {
        if (serviceBusSenderClient != null) {
            serviceBusSenderClient.close();
        }
    }
}
