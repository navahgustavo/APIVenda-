package br.unipar.apivenda.controller;

import br.unipar.apivenda.model.Produto;
import br.unipar.apivenda.service.ProdutoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/produto")
public class ProdutoController {

    @Inject
    private ProdutoService produtoService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarProduto() {
        return Response.ok(produtoService.listar()).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarProduto(Produto produto) {
        try {
            produtoService.cadastrar(produto);
            return Response.status(201).entity("Produto cadastrado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response editarCliente(Produto produto) {
        try {
            produtoService.editar(produto);
            return Response.status(201).entity("Produto editado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response excluirProduto(Produto produto) {
        try {
            produtoService.excluir(produto);
            return Response.status(201).entity("Produto excluído com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
}
