package com.ngmartinezs.wsregsolicitudclientejava.dto;

public class ResponseDTO {
    
    private String mensaje;
    private String codigoRespuesta;
    private String mensajeRespuesta;
    
    public ResponseDTO() {
        
    }
    
    public ResponseDTO(String mensaje, String codigoRespuesta, String mensajeRespuesta) {
        this.mensaje = mensaje;
        this.codigoRespuesta = codigoRespuesta;
        this.mensajeRespuesta = mensajeRespuesta;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String getCodigoRespuesta() {
        return codigoRespuesta;
    }
    
    public void setCodigoRespuesta(String codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }
    
    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }
    
    public void setMensajeRespuesta(String mensajeRespuesta) {
        this.mensajeRespuesta = mensajeRespuesta;
    }
    
    @Override
    public String toString() {
        return "ResponseDTO [mensaje=" + mensaje + ", codigoRespuesta=" + codigoRespuesta + ", mensajeRespuesta="
                + mensajeRespuesta + "]";
    }
}
