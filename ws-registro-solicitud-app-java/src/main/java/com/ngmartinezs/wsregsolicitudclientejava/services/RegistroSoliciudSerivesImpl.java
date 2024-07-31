package com.ngmartinezs.wsregsolicitudclientejava.services;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.List; // Add this import
import java.util.ArrayList; // Add this import

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ngmartinezs.wsregsolicitudclientejava.dto.message.MessageCreaSolicitudDTO;
import com.ngmartinezs.wsregsolicitudclientejava.mapper.SolicitudMapper;
import com.ngmartinezs.wsregsolicitudclientejava.messaging.MessageService;
import com.ngmartinezs.wsregsolicitudclientejava.model.Solicitud;
import com.ngmartinezs.wsregsolicitudclientejava.repositories.SolicitudRepository;
import com.ngmartinezs.wsregsolicitudclientejava.repositories.SolictudEntity;


@Service
public class RegistroSoliciudSerivesImpl implements RegistroSolicitudServices{
    
      
        @Autowired
        private SolicitudRepository solicitudRepository;

        @Autowired
        @Qualifier("azureServiceBusMessageServiceCreaSolicitud")
        private MessageService azureServiceBusMSCreaSolicitud;




        @Override
        @Transactional
        public Solicitud registrarSolicitud(Solicitud datosClienteValue)throws Exception{
            try {

                datosClienteValue.setIdCliente(String.valueOf(new Random().nextInt(9000) + 1000));
                datosClienteValue.setFechaSolicitud(Date.valueOf(LocalDateTime.now().toLocalDate()));
                datosClienteValue.setFechaCreacion(LocalDateTime.now());
                System.out.println("Solicitud de registro de cliente => " + datosClienteValue.toString() + " <= recibida");
                
                //1. adicionar registro en base de datos
                SolictudEntity solicitudEntity = SolicitudMapper.toEntity(datosClienteValue);
                solicitudRepository.save(solicitudEntity);

                //2. enviar mensaje a topic de mensajes
                //2.1   Crear mensaje MessageDTO
                MessageCreaSolicitudDTO messageDTO = new MessageCreaSolicitudDTO();
                messageDTO.getHeader().setMessageId(String.valueOf(new Random().nextInt(9000) + 1000));
                messageDTO.getHeader().setTimestamp(LocalDateTime.now().toString());
                messageDTO.getHeader().setCorrelationId(String.valueOf(new Random().nextInt(9000) + 1000));
                messageDTO.getHeader().setType("SolicitudRegistroCliente");
                messageDTO.getHeader().setSource("WsRegSolicitud");
                messageDTO.getHeader().setContentType("application/json");
                messageDTO.getHeader().setPriority("1");
                messageDTO.getHeader().setExpiration("180");
                messageDTO.getHeader().setTraceId(String.valueOf(new Random().nextInt(9000) + 1000));
                
                messageDTO.getBody().setTopic("CREA_SOLICITUD");
                messageDTO.getBody().setIdCliente(datosClienteValue.getIdCliente());
                messageDTO.getBody().setTipoIdentificacion(datosClienteValue.getTipoIdentificacion());
                messageDTO.getBody().setNumeroIdentificacion(datosClienteValue.getNumeroIdentificacion());
                messageDTO.getBody().setNombre(datosClienteValue.getNombre());
                messageDTO.getBody().setApellido(datosClienteValue.getApellido());
                messageDTO.getBody().setDireccion(datosClienteValue.getDireccion());
                messageDTO.getBody().setTelefono(datosClienteValue.getTelefono());
                messageDTO.getBody().setEmail(datosClienteValue.getEmail());
                messageDTO.getBody().setTipoSolicitud(datosClienteValue.getTipoSolicitud());
                messageDTO.getBody().setFechaSolicitud(datosClienteValue.getFechaSolicitud().toString());
                messageDTO.getBody().setFechaCreacion(datosClienteValue.getFechaCreacion().toString());

                //2.2   Enviar mensaje a topic de mensajes
                azureServiceBusMSCreaSolicitud.sendMessage(messageDTO);

                
            } 
            catch (Exception e) {
                e.printStackTrace();
                throw e;
            }

            return datosClienteValue.clone();
        }

        @Override
        public List<Solicitud> listarSolicitudes() {
            List<SolictudEntity> solicitudesEntity = solicitudRepository.findAll();
            List<Solicitud> solicitudesTO = new ArrayList<>();
        
            solicitudesEntity.forEach(solicitudEntity -> {
                solicitudesTO.add(SolicitudMapper.toTransferObject(solicitudEntity));
            });
            return solicitudesTO;
        }
}
