package com.ngmartinezs.wsregsolicitudclientejava.dto.message;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageCreaSolicitudDTO extends MessageDTO{

    private Body body;

    public MessageCreaSolicitudDTO() {
        this.setHeader(new Header());
        body = new Body();
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static  class Body {
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
