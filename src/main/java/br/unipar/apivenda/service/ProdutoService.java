package br.unipar.apivenda.service;

import br.unipar.apivenda.model.Produto;
import br.unipar.apivenda.repository.ProdutoRepository;
import jakarta.inject.Inject;

import java.util.List;

public class ProdutoService {

    @Inject
    private ProdutoRepository produtoRepository;

    public List<Produto> listar() {
        return produtoRepository.listar();
    }

    public Produto buscarPorId(Produto produto) {
        return produtoRepository.buscaPorID(produto.getId());
    }

    public void cadastrar(Produto produto) throws Exception {
        produtoRepository.cadastrar(produto);
    }

    public void editar(Produto produto) throws Exception {
        produtoRepository.editar(produto);
    }

    public void excluir(Produto produto) throws Exception {
        produtoRepository.excluir(produto);
    }

}
