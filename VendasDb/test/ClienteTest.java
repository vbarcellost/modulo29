

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import dao.ClienteDAO;
import dao.IClienteDAO;
import vendasdb.Cliente;


import java.util.List;
import junit.framework.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
/**
 *
 * @author Vitoria
 */
public class ClienteTest {

    private IClienteDAO clienteDAO;

    @Test
    public void deveCadastrarBDTest() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Vitoria");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDAO.buscar("01");
        Assert.assertNotNull(clienteBD);
        assertEquals("Devem ter o mesmo código", cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals("Devem ter o mesmo nome", cliente.getNome(), clienteBD.getNome());

        Integer countDel = clienteDAO.excluir(clienteBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void deveBuscarClienteTest() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Vitoria");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDAO.buscar("01");
        Assert.assertNotNull(clienteBD);
        assertEquals("Devem ter o mesmo código", cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals("Devem ter o mesmo nome", cliente.getNome(), clienteBD.getNome());

        Integer countDel = clienteDAO.excluir(clienteBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void deveExcluirClienteTest() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Vitoria");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDAO.buscar("01");
        Assert.assertNotNull(clienteBD);
        assertEquals("Devem ter o mesmo código", cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals("Devem ter o mesmo nome", cliente.getNome(), clienteBD.getNome());

        Integer countDel = clienteDAO.excluir(clienteBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void deveRetornarTodosTest() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Vitoria");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente cliente2 = new Cliente();
        cliente2.setCodigo("02");
        cliente2.setNome("João Pessoa");
        Integer countCad2 = clienteDAO.cadastrar(cliente2);
        assertTrue(countCad2 == 1);

        List<Cliente> lista = clienteDAO.buscarTodos();
        Assert.assertNotNull(lista);
        assertEquals(2, lista.size());

        int countDel = 0;
        for (Cliente cli : lista) {
            clienteDAO.excluir(cli);
            countDel++;
        }
        assertEquals(lista.size(), countDel);

        lista = clienteDAO.buscarTodos();
        assertEquals(0, lista.size());
    }

    @Test
    public void deveAtualizarClienteTest() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Vitoria");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertTrue(countCad == 1);

        Cliente clienteBD = clienteDAO.buscar("01");
        Assert.assertNotNull(clienteBD);
        assertEquals("Devem ter o mesmo código", cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals("Devem ter o mesmo nome", cliente.getNome(), clienteBD.getNome());

        clienteBD.setCodigo("02");
        clienteBD.setNome("Pedro Cabral");

        Integer countAtt = clienteDAO.atualizar(clienteBD);
        assertTrue(countAtt == 1);

        Cliente clienteBD2 = clienteDAO.buscar("01");
        Assert.assertNull("Deve retornar nulo: código foi atualizado", clienteBD2);

        clienteBD2 = clienteDAO.buscar("02");
        Assert.assertNotNull(clienteBD2);
        assertEquals("Devem ter o mesmo código", clienteBD.getCodigo(), clienteBD2.getCodigo());
        assertEquals("Devem ter o mesmo nome", clienteBD.getNome(), clienteBD2.getNome());
        assertEquals("Devem ter o mesmo id", clienteBD.getId(), clienteBD2.getId());

        List<Cliente> clientes = clienteDAO.buscarTodos();
        for (Cliente cli : clientes) {
            clienteDAO.excluir(cli);
        }
    }
}