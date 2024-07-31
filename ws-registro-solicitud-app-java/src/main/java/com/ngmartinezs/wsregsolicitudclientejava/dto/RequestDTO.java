package com.ngmartinezs.wsregsolicitudclientejava.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RequestDTO {

    
    private Solicitud solicitud;


    @Getter
    @Setter
    @ToString
    public static class Solicitud
    {
        private String tipoIdentificacion;
        private String numeroIdentificacion;
        private String nombre;
        private String apellido;
        private String direccion;
        private String telefono;
        private String email;
        private String tipoSolicitud;

        public Solicitud() {
        }
        
    }

}
