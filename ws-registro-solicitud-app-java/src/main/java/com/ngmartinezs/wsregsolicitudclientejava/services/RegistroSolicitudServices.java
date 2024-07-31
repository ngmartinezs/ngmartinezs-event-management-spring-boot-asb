package com.ngmartinezs.wsregsolicitudclientejava.services;


import org.springframework.stereotype.Service;

import com.ngmartinezs.wsregsolicitudclientejava.model.Solicitud;

import java.util.List; // Add this import

@Service
public interface RegistroSolicitudServices {

    public Solicitud registrarSolicitud(Solicitud datosClienteValue)throws Exception;

    public List<Solicitud> listarSolicitudes();
    
}
