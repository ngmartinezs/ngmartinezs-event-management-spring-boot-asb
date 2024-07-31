package com.ngmartinezs.wsmscuentaappjava.messaging.azure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusClientBuilder.ServiceBusProcessorClientBuilder;
import com.azure.messaging.servicebus.ServiceBusProcessorClient;
import com.azure.messaging.servicebus.ServiceBusReceivedMessageContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ngmartinezs.wsmscuentaappjava.dto.message.MessageDTO;
import com.ngmartinezs.wsmscuentaappjava.dto.message.MessageSolicitudDTO;
import com.ngmartinezs.wsmscuentaappjava.messaging.MessageService;
import com.ngmartinezs.wsmscuentaappjava.model.Cuenta;
import com.ngmartinezs.wsmscuentaappjava.services.CuentaServices;

@Component
@Qualifier("MessageServiceBusCreaCliente")
public class MessageServiceBusCreaCuenta implements MessageService{

    @Value("${azure.servicebus.connection.string}")
    private String connectionString;
    @Value("${azure.servicebus.topic.name}")
    private String topic;
    @Value("${azure.servicebus.subscription.name}")
    private String subscription;
    
    @Autowired
    private CuentaServices cuentaServices;

    private ServiceBusProcessorClient processorClient;

    @Override
    public void sendMessage(MessageDTO messageDto) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void startMessageListener() {
        // TODO Auto-generated method stub
        System.out.println("Start message listener");

        if( processorClient == null){
            ServiceBusProcessorClientBuilder builder = new ServiceBusClientBuilder()
            .connectionString(connectionString)
            .processor()
            .topicName(topic)
            .subscriptionName(subscription)
            .processMessage(this::processMessage)
            .processError(context -> {
                System.out.println("Error: " + context.getException().getMessage());
            })
            .maxConcurrentCalls(1);

            processorClient = builder.buildProcessorClient();
            processorClient.start();
        }
    }

    private void processMessage(ServiceBusReceivedMessageContext context){
        System.out.println("Message received: " + context.toString());
        String body = context.getMessage().getBody().toString();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            MessageSolicitudDTO messageDto = objectMapper.readValue(body, MessageSolicitudDTO.class);

            //Crear Cliente
            Cuenta cuenta = new Cuenta();
            cuenta.setTipoIdentificacion(messageDto.getBody().getTipoIdentificacion().toString());
            cuenta.setNumeroIdentificacion(messageDto.getBody().getNumeroIdentificacion().toString());
            cuenta.setEstadoCuenta("ACTIVA");
            cuenta.setSaldoTotal("0.0");
            cuenta.setFechaCreacion(messageDto.getBody().getFechaCreacion());

            System.out.println("Message received: " + messageDto.toString());
            cuentaServices.crearCuenta(cuenta);
            context.complete();
            System.out.println("Cliente Creado ");

            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void stopMessageListener() {
        // TODO Auto-generated method stub
        System.out.println("Stop message listener");
        if(processorClient != null){
            processorClient.close();
            processorClient = null;
        }
    }
}
