package com.ngmartinezs.wsmsclientesappjava.repositories;


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
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clienteId;

    private String tipoIdentificacion;

    private String numeroIdentificacion;

    private String nombre;

    private String apellido;

    private String email;

    private String telefono;

    private String direccion;

    private String fechaCreacion;

}
