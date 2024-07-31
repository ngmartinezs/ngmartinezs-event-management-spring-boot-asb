package com.ngmartinezs.wsmsclientesappjava.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngmartinezs.wsmsclientesappjava.mapper.ClienteMapper;
import com.ngmartinezs.wsmsclientesappjava.model.Cliente;
import com.ngmartinezs.wsmsclientesappjava.repositories.ClienteEntity;
import com.ngmartinezs.wsmsclientesappjava.repositories.ClienteRepository;

import jakarta.transaction.Transactional;


@Service
public class ClienteServicesImplement implements ClienteServices{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarClientes() {
        
        List<ClienteEntity> clientesEntity = clienteRepository.findAll();

        List<Cliente> clientes = new ArrayList<Cliente>();

        clientesEntity.forEach(clienteEntity -> {
            clientes.add(ClienteMapper.toCliente(clienteEntity));
        });
        

        return clientes;

    }

    @Override
    @Transactional
    public Cliente crearCliente(Cliente cliente) {
        
        ClienteEntity clienteEntity = ClienteMapper.toClienteEntity(cliente);

        clienteRepository.save(clienteEntity);

        return cliente;

    }
}
