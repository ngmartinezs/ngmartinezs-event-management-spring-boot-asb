package com.ngmartinezs.wsmscuentaappjava.dto.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@ToString
public class MessageSolicitudDTO extends MessageDTO{

    private Body body;

    public MessageSolicitudDTO() {
        this.setHeader(new Header());
        this.body = new Body();
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Body {
        private String topic;
        private String idCliente;
        private String tipoIdentificacion;
        private String numeroIdentificacion;
        private String nombre;
        private String apellido;
        private String direccion;
        private String telefono;
        private String email;
        private String tipoSolicitud;
        private String fechaSolicitud;
        private String fechaCreacion;
    }
}
