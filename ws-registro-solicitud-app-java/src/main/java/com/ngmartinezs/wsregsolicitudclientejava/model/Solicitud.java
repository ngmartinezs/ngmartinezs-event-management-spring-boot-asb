package com.ngmartinezs.wsregsolicitudclientejava.model;

import java.util.Date;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {

    private String idCliente;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    private String tipoSolicitud;
    private Date fechaSolicitud;
    private LocalDateTime fechaCreacion;

    @Override
    public Solicitud clone() {
        Solicitud solicitudTO = new Solicitud();
        solicitudTO.setIdCliente(this.idCliente);
        solicitudTO.setTipoIdentificacion(this.tipoIdentificacion);
        solicitudTO.setNumeroIdentificacion(this.numeroIdentificacion);
        solicitudTO.setNombre(this.nombre);
        solicitudTO.setApellido(this.apellido);
        solicitudTO.setDireccion(this.direccion);
        solicitudTO.setTelefono(this.telefono);
        solicitudTO.setEmail(this.email);
        solicitudTO.setTipoSolicitud(this.tipoSolicitud);
        solicitudTO.setFechaSolicitud(this.fechaSolicitud);
        solicitudTO.setFechaCreacion(this.fechaCreacion);
        return solicitudTO;
    }
}
