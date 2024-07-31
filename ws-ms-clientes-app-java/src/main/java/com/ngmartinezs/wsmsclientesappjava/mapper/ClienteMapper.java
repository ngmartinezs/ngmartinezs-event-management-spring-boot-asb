package com.ngmartinezs.wsmsclientesappjava.mapper;

import com.ngmartinezs.wsmsclientesappjava.model.Cliente;
import com.ngmartinezs.wsmsclientesappjava.repositories.ClienteEntity;

public class ClienteMapper {

    public static ClienteEntity toClienteEntity(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setClienteId(cliente.getClienteId());
        clienteEntity.setNumeroIdentificacion(cliente.getNumeroIdentificacion());
        clienteEntity.setTipoIdentificacion(cliente.getTipoIdentificacion());
        clienteEntity.setNombre(cliente.getNombre());
        clienteEntity.setApellido(cliente.getApellido());
        clienteEntity.setEmail(cliente.getEmail());
        clienteEntity.setTelefono(cliente.getTelefono());
        clienteEntity.setDireccion(cliente.getDireccion());
        clienteEntity.setFechaCreacion(cliente.getFechaCreacion());
        return clienteEntity;
    }

    public static Cliente toCliente(ClienteEntity clienteEntity) {
        Cliente cliente = new Cliente();
        cliente.setClienteId(clienteEntity.getClienteId());
        cliente.setNumeroIdentificacion(clienteEntity.getNumeroIdentificacion());
        cliente.setTipoIdentificacion(clienteEntity.getTipoIdentificacion());
        cliente.setNombre(clienteEntity.getNombre());
        cliente.setApellido(clienteEntity.getApellido());
        cliente.setEmail(clienteEntity.getEmail());
        cliente.setTelefono(clienteEntity.getTelefono());
        cliente.setDireccion(clienteEntity.getDireccion());
        cliente.setFechaCreacion(clienteEntity.getFechaCreacion());
        return cliente;
    }

}
