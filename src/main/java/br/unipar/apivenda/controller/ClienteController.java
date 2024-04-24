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

    @POST
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

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response excluirCliente(Cliente cliente) {
        try {
            clienteService.excluir(cliente);
            return Response.status(201).entity("Cliente excluído com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

}
