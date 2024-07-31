package com.ngmartinezs.wsmsclientesappjava.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngmartinezs.wsmsclientesappjava.dto.ResponseDTO;
import com.ngmartinezs.wsmsclientesappjava.model.Cliente;
import com.ngmartinezs.wsmsclientesappjava.services.ClienteServices;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/clientes")
public class WsMsClientesController {

    @Autowired
    ClienteServices clienteServices;

    @GetMapping("/listar")
    @Operation(summary = "Listar clientes", 
               description = "Listar todos los clientes",
               tags = {"clientes"},
               responses = {
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Listado de clientes"),
                    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Error interno del servidor")
               })
    public ResponseEntity<ResponseDTO> listar(   @RequestHeader("X-Correlation-ID") String correlationID,
            @RequestHeader("X-Request-ID") String requestID,
            @RequestHeader("X-Channel") String channel,
            @RequestHeader("X-Service-Name") String serviceName,
            @RequestHeader("X-Forwarded-For") String forwardedFor) {

        ResponseEntity<ResponseDTO> responseEntity = null;
        List<Cliente> clientes = clienteServices.listarClientes();
        ResponseDTO response = new ResponseDTO();
        response.setMensaje("Listando clientes");
        response.setCodigoRespuesta("00");
        response.setData(clientes);

        responseEntity = ResponseEntity.ok(response);

        return responseEntity;
    }

}
