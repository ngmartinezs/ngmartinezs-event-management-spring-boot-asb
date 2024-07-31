package com.ngmartinezs.wsmscuentaappjava.mapper;

import com.ngmartinezs.wsmscuentaappjava.model.Cuenta;
import com.ngmartinezs.wsmscuentaappjava.repositories.CuentaEntity;

public class CuentaMapper {

    public static CuentaEntity toClienteEntity(Cuenta cuenta) {
        CuentaEntity cuentaEntity = new CuentaEntity();
        cuentaEntity.setNumeroIdentificacion(cuenta.getNumeroIdentificacion());
        cuentaEntity.setTipoIdentificacion(cuenta.getTipoIdentificacion());
        cuentaEntity.setEstadoCuenta(cuenta.getEstadoCuenta());
        cuentaEntity.setSaldoTotal(cuenta.getSaldoTotal());
        cuentaEntity.setFechaCreacion(cuenta.getFechaCreacion());
     
        return cuentaEntity;
    }

    public static Cuenta toCliente(CuentaEntity clienteEntity) {
        Cuenta cuenta = new Cuenta();
        cuenta.setCuentaId(clienteEntity.getCuentaId());
        cuenta.setNumeroIdentificacion(clienteEntity.getNumeroIdentificacion());
        cuenta.setTipoIdentificacion(clienteEntity.getTipoIdentificacion());
        cuenta.setEstadoCuenta(clienteEntity.getEstadoCuenta());
        cuenta.setSaldoTotal(clienteEntity.getSaldoTotal());
        cuenta.setFechaCreacion(clienteEntity.getFechaCreacion());
        return cuenta;
    }

}
