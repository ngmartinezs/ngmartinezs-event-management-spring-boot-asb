package com.ngmartinezs.wsmsclientesappjava.messaging.azure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusClientBuilder.ServiceBusProcessorClientBuilder;
import com.azure.messaging.servicebus.ServiceBusProcessorClient;
import com.azure.messaging.servicebus.ServiceBusReceivedMessageContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ngmartinezs.wsmsclientesappjava.dto.message.MessageDTO;
import com.ngmartinezs.wsmsclientesappjava.dto.message.MessageSolicitudDTO;
import com.ngmartinezs.wsmsclientesappjava.messaging.MessageService;
import com.ngmartinezs.wsmsclientesappjava.model.Cliente;
import com.ngmartinezs.wsmsclientesappjava.services.ClienteServices;

@Component
@Qualifier("MessageServiceBusCreaCliente")
public class MessageServiceBusCreaCliente implements MessageService{

    @Value("${azure.servicebus.connection.string}")
    private String connectionString;
    @Value("${azure.servicebus.topic.name}")
    private String topic;
    @Value("${azure.servicebus.subscription.name}")
    private String subscription;
    
    @Autowired
    private ClienteServices clienteServices;

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
            Cliente cliente = new Cliente();
            cliente.setTipoIdentificacion(messageDto.getBody().getTipoIdentificacion().toString());
            cliente.setNumeroIdentificacion(messageDto.getBody().getNumeroIdentificacion().toString());
            cliente.setNombre(messageDto.getBody().getNombre());
            cliente.setApellido(messageDto.getBody().getApellido());
            cliente.setDireccion(messageDto.getBody().getDireccion());
            cliente.setTelefono(messageDto.getBody().getTelefono());
            cliente.setEmail(messageDto.getBody().getEmail());
            cliente.setFechaCreacion(messageDto.getBody().getFechaCreacion());

            System.out.println("Message received: " + messageDto.toString());
            clienteServices.crearCliente(cliente);
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
