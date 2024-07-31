package com.ngmartinezs.wsmscuentaappjava.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngmartinezs.wsmscuentaappjava.dto.ResponseDTO;
import com.ngmartinezs.wsmscuentaappjava.model.Cuenta;
import com.ngmartinezs.wsmscuentaappjava.services.CuentaServices;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/cuentas")
public class WsMsCuentasController {

    @Autowired
    CuentaServices clienteServices;

    @GetMapping("/listar")
    @Operation(summary = "Listar cuentas", 
               description = "Listar todas las cuentas de clientes",
               tags = {"cuentas"},
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
        List<Cuenta> clientes = clienteServices.listarCuentas();
        ResponseDTO response = new ResponseDTO();
        response.setMensaje("Listando Cuentas");
        response.setCodigoRespuesta("00");
        response.setData(clientes);

        responseEntity = ResponseEntity.ok(response);

        return responseEntity;
    }

}
