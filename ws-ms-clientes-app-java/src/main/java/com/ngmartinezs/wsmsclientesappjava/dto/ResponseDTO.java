package com.ngmartinezs.wsmsclientesappjava.dto;

import java.util.List;

import com.ngmartinezs.wsmsclientesappjava.model.Cliente;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ResponseDTO {

    private String mensaje;
    private String codigoRespuesta;
    private List<Cliente> data;

}
