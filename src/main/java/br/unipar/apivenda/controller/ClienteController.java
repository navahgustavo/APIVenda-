package br.unipar.apivenda.controller;

import br.unipar.apivenda.model.Cliente;
import br.unipar.apivenda.service.ClienteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cliente")
public class ClienteController {

    @Inject
    private ClienteService clienteService;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response listarClientes() {
        return Response.ok(clienteService.listar()).build();
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response listarClientesPorID(@PathParam("id") Integer id) {
        Cliente cliente = clienteService.buscarPorId(id);
        if (cliente == null){
            return Response.status(404).entity("Cliente não encontrado").build();
        }
        return Response.ok(cliente).build();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarCliente(Cliente cliente) {
        try {
            clienteService.cadastrar(cliente);
            return Response.status(201).entity("Cliente cadastrado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Path("/id")
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response editarCliente(Cliente cliente) {
        try {
            clienteService.editar(cliente);
            return Response.status(201).entity("Cliente editado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response excluirCliente(@PathParam("id") Integer id) {
        try {
            Cliente cliente = clienteService.buscarPorId(id);
            if (cliente == null) {
                return Response.status(404).entity("cliente não encontrado").build();
            }
            clienteService.excluir(cliente);
            return Response.status(200).entity("Cliente excluído com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }
}
