package com.ngmartinezs.wsmscuentaappjava.dto;

import java.util.List;

import com.ngmartinezs.wsmscuentaappjava.model.Cuenta;

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
    private List<Cuenta> data;

}
