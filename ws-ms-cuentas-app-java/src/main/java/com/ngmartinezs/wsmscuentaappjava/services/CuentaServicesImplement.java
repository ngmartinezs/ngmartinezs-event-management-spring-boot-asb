package com.ngmartinezs.wsmscuentaappjava.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngmartinezs.wsmscuentaappjava.mapper.CuentaMapper;
import com.ngmartinezs.wsmscuentaappjava.model.Cuenta;
import com.ngmartinezs.wsmscuentaappjava.repositories.CuentaEntity;
import com.ngmartinezs.wsmscuentaappjava.repositories.CuentaRepository;

import jakarta.transaction.Transactional;


@Service
public class CuentaServicesImplement implements CuentaServices{

    @Autowired
    private CuentaRepository clienteRepository;

    @Override
    public List<Cuenta> listarCuentas() {
        
        List<CuentaEntity> clientesEntity = clienteRepository.findAll();

        List<Cuenta> clientes = new ArrayList<Cuenta>();

        clientesEntity.forEach(clienteEntity -> {
            clientes.add(CuentaMapper.toCliente(clienteEntity));
        });
        

        return clientes;

    }

    @Override
    @Transactional
    public Cuenta crearCuenta(Cuenta cliente) {
        
        CuentaEntity clienteEntity = CuentaMapper.toClienteEntity(cliente);

        clienteRepository.save(clienteEntity);

        return cliente;

    }
}
