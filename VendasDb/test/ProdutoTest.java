/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import dao.IProdutoDAO;
import dao.ProdutoDAO;
import vendasdb.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
/**
 *
 * @author Vitoria
 */
public class ProdutoTest {

    private IProdutoDAO produtoDAO;

    @Test
    public void deveCadastrarBDTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Teclado Mecânico");
        produto.setPreco(299.90);
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("01");
        Assert.assertNotNull(produtoBD);
        assertEquals("Devem ter o mesmo código", produto.getCodigo(), produtoBD.getCodigo());
        assertEquals("Devem ter o mesmo nome", produto.getNome(), produtoBD.getNome());
        assertEquals("Devem ter o mesmo preço", produto.getPreco(), produtoBD.getPreco());

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void deveBuscarProdutoTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Teclado Mecânico");
        produto.setPreco(299.90);
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("01");
        Assert.assertNotNull(produtoBD);
        assertEquals("Devem ter o mesmo código", produto.getCodigo(), produtoBD.getCodigo());
        assertEquals("Devem ter o mesmo nome", produto.getNome(), produtoBD.getNome());
        assertEquals("Devem ter o mesmo preço", produto.getPreco(), produtoBD.getPreco());

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void deveExcluirProdutoTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Teclado Mecânico");
        produto.setPreco(299.90);
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("01");
        Assert.assertNotNull(produtoBD);
        assertEquals("Devem ter o mesmo código", produto.getCodigo(), produtoBD.getCodigo());
        assertEquals("Devem ter o mesmo nome", produto.getNome(), produtoBD.getNome());

        Integer countDel = produtoDAO.excluir(produtoBD);
        assertTrue(countDel == 1);
    }

    @Test
    public void deveRetornarTodosTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Teclado Mecânico");
        produto.setPreco(299.90);
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produto2 = new Produto();
        produto2.setCodigo("02");
        produto2.setNome("Mouse Gamer");
        produto2.setPreco(149.90);
        Integer countCad2 = produtoDAO.cadastrar(produto2);
        assertTrue(countCad2 == 1);

        List<Produto> lista = produtoDAO.buscarTodos();
        Assert.assertNotNull(lista);
        assertEquals(2, lista.size());

        int countDel = 0;
        for (Produto prod : lista) {
            produtoDAO.excluir(prod);
            countDel++;
        }
        assertEquals(lista.size(), countDel);

        lista = produtoDAO.buscarTodos();
        assertEquals(0, lista.size());
    }

    @Test
    public void deveAtualizarProdutoTest() throws Exception {
        produtoDAO = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setNome("Teclado Mecânico");
        produto.setPreco(299.90);
        Integer countCad = produtoDAO.cadastrar(produto);
        assertTrue(countCad == 1);

        Produto produtoBD = produtoDAO.buscar("01");
        Assert.assertNotNull(produtoBD);
        assertEquals("Devem ter o mesmo código", produto.getCodigo(), produtoBD.getCodigo());
        assertEquals("Devem ter o mesmo nome", produto.getNome(), produtoBD.getNome());
        assertEquals("Devem ter o mesmo preço", produto.getPreco(), produtoBD.getPreco());

        produtoBD.setCodigo("02");
        produtoBD.setNome("Mouse Gamer");
        produtoBD.setPreco(149.90);

        Integer countAtt = produtoDAO.atualizar(produtoBD);
        assertTrue(countAtt == 1);

        Produto produtoBD2 = produtoDAO.buscar("01");
        Assert.assertNull("Deve retornar nulo: código foi atualizado", produtoBD2);

        produtoBD2 = produtoDAO.buscar("02");
        Assert.assertNotNull(produtoBD2);
        assertEquals("Devem ter o mesmo código", produtoBD.getCodigo(), produtoBD2.getCodigo());
        assertEquals("Devem ter o mesmo nome", produtoBD.getNome(), produtoBD2.getNome());
        assertEquals("Devem ter o mesmo preço", produtoBD.getPreco(), produtoBD2.getPreco());
        assertEquals("Devem ter o mesmo id", produtoBD.getId(), produtoBD2.getId());

        List<Produto> produtos = produtoDAO.buscarTodos();
        for (Produto prod : produtos) {
            produtoDAO.excluir(prod);
        }
    }
}