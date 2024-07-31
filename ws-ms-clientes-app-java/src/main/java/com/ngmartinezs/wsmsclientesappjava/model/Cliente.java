package com.ngmartinezs.wsmsclientesappjava.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Cliente {

    private int clienteId;
    private String numeroIdentificacion;
    private String tipoIdentificacion;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
    private String fechaCreacion;
}
