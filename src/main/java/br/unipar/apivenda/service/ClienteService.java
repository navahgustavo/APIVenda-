package br.unipar.apivenda.service;

import br.unipar.apivenda.model.Cliente;
import br.unipar.apivenda.repository.ClienteRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class ClienteService {

    @Inject
    private ClienteRepository clienteRepository;

    public List<Cliente> listar() {
        return clienteRepository.listarTodos();
    }

    public void cadastrar(Cliente cliente) throws Exception {
        clienteRepository.cadastrar(cliente);
    }

}
