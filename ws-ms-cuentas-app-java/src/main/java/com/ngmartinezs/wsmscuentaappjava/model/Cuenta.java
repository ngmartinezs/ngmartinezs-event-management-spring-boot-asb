package com.ngmartinezs.wsmscuentaappjava.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Cuenta {

    private int cuentaId;
    private String numeroIdentificacion;
    private String tipoIdentificacion;
    private String estadoCuenta;
    private String saldoTotal;
    private String fechaCreacion;
}
