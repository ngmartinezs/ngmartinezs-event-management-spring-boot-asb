package com.ngmartinezs.wsregsolicitudclientejava.mapper;

import com.ngmartinezs.wsregsolicitudclientejava.model.Solicitud;
import com.ngmartinezs.wsregsolicitudclientejava.repositories.SolictudEntity;

public class SolicitudMapper {

    public static SolictudEntity toEntity(Solicitud solicitudTO) {
        SolictudEntity solicitudEntity = new SolictudEntity();
        // Realiza el mapeo de atributos aquí
        solicitudEntity.setTipoIdentificacion(solicitudTO.getTipoIdentificacion());
        solicitudEntity.setNumeroIdentificacion(solicitudTO.getNumeroIdentificacion());
        solicitudEntity.setNombre(solicitudTO.getNombre());
        solicitudEntity.setApellido(solicitudTO.getApellido());
        solicitudEntity.setDireccion(solicitudTO.getDireccion());
        solicitudEntity.setTelefono(solicitudTO.getTelefono());
        solicitudEntity.setEmail(solicitudTO.getEmail());
        solicitudEntity.setTipoSolicitud(solicitudTO.getTipoSolicitud());
        // Asumiendo que SolictudEntity tiene un campo para fecha de creación
        solicitudEntity.setFechaCreacion(solicitudTO.getFechaCreacion());
        return solicitudEntity;
    }

    public static Solicitud toTransferObject(SolictudEntity solicitudEntity) {
        Solicitud solicitudTO = new Solicitud();
        // Realiza el mapeo de atributos aquí
        solicitudTO.setTipoIdentificacion(solicitudEntity.getTipoIdentificacion());
        solicitudTO.setNumeroIdentificacion(solicitudEntity.getNumeroIdentificacion());
        solicitudTO.setNombre(solicitudEntity.getNombre());
        solicitudTO.setApellido(solicitudEntity.getApellido());
        solicitudTO.setDireccion(solicitudEntity.getDireccion());
        solicitudTO.setTelefono(solicitudEntity.getTelefono());
        solicitudTO.setEmail(solicitudEntity.getEmail());
        solicitudTO.setTipoSolicitud(solicitudEntity.getTipoSolicitud());
        // Asumiendo que SolicitudTO tiene un campo para fecha de creación
        solicitudTO.setFechaCreacion(solicitudEntity.getFechaCreacion());
        return solicitudTO;
    }
}