package com.ngmartinezs.wsmsclientesappjava.services;

import java.util.List;

import com.ngmartinezs.wsmsclientesappjava.model.Cliente;

public interface ClienteServices {

    public List<Cliente> listarClientes();

    public Cliente crearCliente(Cliente cliente);
}
