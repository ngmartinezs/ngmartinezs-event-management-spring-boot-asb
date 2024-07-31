package com.ngmartinezs.wsmscuentaappjava.services;

import java.util.List;

import com.ngmartinezs.wsmscuentaappjava.model.Cuenta;

public interface CuentaServices {

    public List<Cuenta> listarCuentas();

    public Cuenta crearCuenta(Cuenta cliente);
}
