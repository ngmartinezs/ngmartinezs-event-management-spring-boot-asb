package com.ngmartinezs.wsmscuentaappjava.repositories;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cuentaId;
    private String numeroIdentificacion;
    private String tipoIdentificacion;
    private String estadoCuenta;
    private String saldoTotal;
    private String fechaCreacion;

}
