package br.unipar.apivenda.controller;

import br.unipar.apivenda.model.Cliente;
import br.unipar.apivenda.model.Venda;
import br.unipar.apivenda.service.VendaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/venda")
public class VendaController {

    @Inject
    private VendaService vendaService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarVenda() {
        return Response.ok(vendaService.listar()).build();
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response listarVendasPorID(@PathParam("id") Integer id) {
        Venda venda = vendaService.buscarPorId(id);
        if (venda == null){
            return Response.status(404).entity("Venda não encontrada").build();
        }
        return Response.ok(venda).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarVenda(Venda venda) {
        try {
            vendaService.cadastrar(venda);
            return Response.status(201).entity("Venda cadastrada com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Path("/id")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response editarVenda(Venda venda) {
        try {
            vendaService.editar(venda);
            return Response.status(201).entity("Venda editada com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response excluirVenda(@PathParam("id") Integer id) {
        try {
            Venda venda = vendaService.buscarPorId(id);
            if (venda == null) {
                return Response.status(404).entity("Venda não encontrada").build();
            }
            vendaService.excluir(venda);
            return Response.status(200).entity("Cliente excluído com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
}
