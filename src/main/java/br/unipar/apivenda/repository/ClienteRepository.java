package br.unipar.apivenda.repository;

import br.unipar.apivenda.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;

import java.util.List;

@Stateless
public class ClienteRepository {

    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;

    public List<Cliente> listarTodos() {
        String jpql = "SELECT c FROM Cliente c";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }

    public Cliente buscaPorID(Integer id) {
        return em.find(Cliente.class, id);
    }

    public void cadastrar(Cliente cliente) throws Exception {
        try {
            em.persist(cliente);
        } catch (Exception ex) {
            throw new Exception("Cliente não pôde ser cadastrado");
        }
    }

}
