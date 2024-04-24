package br.unipar.apivenda.service;

import br.unipar.apivenda.model.Venda;
import br.unipar.apivenda.repository.VendaRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class VendaService {

    @Inject
    private VendaRepository vendaRepository ;

    public List<Venda> listar() {
        return vendaRepository.listar();
    }

    public Venda buscarPorId(Venda venda) {
        return vendaRepository.buscaPorID(venda.getId());
    }

    public void cadastrar(Venda venda) throws Exception {
        vendaRepository.cadastrar(venda);
    }

    public void editar(Venda venda) throws Exception {
        vendaRepository.editar(venda);
    }

    public void excluir(Venda venda) throws Exception {
        vendaRepository.excluir(venda);
    }
}
