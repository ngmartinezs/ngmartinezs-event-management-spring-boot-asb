package com.ngmartinezs.wsregsolicitudclientejava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngmartinezs.wsregsolicitudclientejava.dto.RequestDTO;
import com.ngmartinezs.wsregsolicitudclientejava.dto.ResponseDTO;
import com.ngmartinezs.wsregsolicitudclientejava.model.Solicitud;
import com.ngmartinezs.wsregsolicitudclientejava.services.RegistroSolicitudServices;
import java.util.List; // Add this import
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/solicitudes")
public class WsRegistroSolicitudTopicsController {

    @Autowired
    private RegistroSolicitudServices registroSolicitudInfoClienteServices;

    @PostMapping("/registrar")
    @Operation(summary = "Registrar solicitud de cliente", 
               description = "Servicio para registrar solicitud de cliente", 
                requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                   description = "Datos de la solicitud de cliente a registrar",
                   required = true,
                   content = @Content(
                       mediaType = "application/json",
                       schema = @Schema(implementation = RequestDTO.class)
                   )
               ),
               responses = {
                   @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Solicitud de registro de cliente exitosa", content =@Content(schema = @Schema(implementation = ResponseDTO.class)) ),
                   @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Solicitud de registro de cliente fallida", content =@Content(schema = @Schema(implementation = ResponseDTO.class))) },
               tags = {
            "Solicitud de cliente" })
    public ResponseEntity<ResponseDTO> registrarSolicitudCliente(
            @RequestHeader("X-Correlation-ID") String correlationID,
            @RequestHeader("X-Request-ID") String requestID,
            @RequestHeader("X-Channel") String channel,
            @RequestHeader("X-Service-Name") String serviceName,
            @RequestHeader("X-Forwarded-For") String forwardedFor,
            @RequestBody RequestDTO requestDTO)  throws Exception{
    
            ResponseDTO responseDTO = new ResponseDTO();
            Solicitud datosSolicitudTO = new Solicitud();                 
        try {
            
            datosSolicitudTO.setNombre(requestDTO.getSolicitud().getNombre());
            datosSolicitudTO.setTipoIdentificacion(requestDTO.getSolicitud().getTipoIdentificacion());
            datosSolicitudTO.setApellido(requestDTO.getSolicitud().getApellido());
            datosSolicitudTO.setDireccion(requestDTO.getSolicitud().getDireccion());
            datosSolicitudTO.setEmail(requestDTO.getSolicitud().getEmail());
            datosSolicitudTO.setNumeroIdentificacion(requestDTO.getSolicitud().getNumeroIdentificacion());
            datosSolicitudTO.setTelefono(requestDTO.getSolicitud().getTelefono());
            datosSolicitudTO.setTipoSolicitud(requestDTO.getSolicitud().getTipoSolicitud());
    
            Solicitud datosSolicitudTOCreada = registroSolicitudInfoClienteServices.registrarSolicitud(datosSolicitudTO);
    
            if (datosSolicitudTOCreada != null) {
                responseDTO.setMensaje("Solicitud de registro exisitoso => " + datosSolicitudTOCreada.getIdCliente());
                responseDTO.setCodigoRespuesta("00");
                responseDTO.setMensajeRespuesta("Solicitud de registro de cliente exitosa");
    
                return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
            } else {
                responseDTO.setMensaje("Error registro de solictud ");
                responseDTO.setCodigoRespuesta("01");
                responseDTO.setMensajeRespuesta("Solicitud de registro de cliente fallida");
                return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
            }
    
         } catch (Exception e) {
            /*responseDTO.setMensaje("Error registro de solictud ");
            responseDTO.setCodigoRespuesta("03");
            responseDTO.setMensajeRespuesta("Solicitud de registro de cliente fallida");
            return ResponseEntity.status(HttpStatus.).body(responseDTO);*/
            e.printStackTrace();
            throw e;
        }
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar solicitudes registradas",
               description = "Servicio para listar las solicitudes registradas",
               responses = {
                   @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Listado de solicitudes registrado exitosamente", content =@Content(schema = @Schema(implementation = List.class))),
                   @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Error al listar las solicitudes registradas")
               },
               tags = {
                   "Solicitud de cliente"
               })
    public ResponseEntity<List<Solicitud>> listarSolicitudes() {
        List<Solicitud> solicitudes = registroSolicitudInfoClienteServices.listarSolicitudes();
        
        if (solicitudes != null) {
            return ResponseEntity.ok(solicitudes);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    /*
     * public ResponseEntity<ResponseDTO>
     * registrarSolicitudCliente(@RequestParam("tipoIdCliente") String
     * tipoIdCliente, @RequestParam("numeroIdCliente") String numeroIdCliente) {
     * 
     * ResponseDTO responseDTO = new ResponseDTO();
     * DatosClienteValue datosClienteValue = new DatosClienteValue();
     * DatosClienteValue datosClienteValueRetorno;
     * 
     * datosClienteValue.setTipoIdentificacion(tipoIdCliente);
     * datosClienteValue.setNumeroIdentificacion(numeroIdCliente);
     * 
     * System.out.println("Solicitud de registro de cliente => " +
     * datosClienteValue.toString() + " <= recibida");
     * 
     * datosClienteValueRetorno =
     * registroSolicitudInfoClienteServices.registrarSolicitud(datosClienteValue);
     * 
     * responseDTO.setMensaje("Solicitud de registro de cliente => " +
     * datosClienteValueRetorno.toString() + " <= exitosa");
     * responseDTO.setCodigoRespuesta("00");
     * responseDTO.setMensajeRespuesta("Solicitud de registro de cliente exitosa");
     * 
     * return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
     * }
     */

}
