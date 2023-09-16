/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.ProdutoDao;
import com.inosystem.pdv.dao.RelatorioDao;
import com.inosystem.pdv.model.CompraProduto;
import com.inosystem.pdv.model.Produto;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class ProdutoController {

    private ProdutoDao daoProdutos = new ProdutoDao();
    private RelatorioDao dAORelatorios = new RelatorioDao();

    /**
     * grava Produtos
     *
     * @param pProduto return int
     */
    public int salvarProdutosController(Produto pProduto) {
        return this.daoProdutos.salvarProdutosDAO(pProduto);
    }

    /**
     * recupera Produtos
     *
     * @param pCodigo return Produto
     */
    public Produto getProdutosController(int pCodigo) {
        return this.daoProdutos.getProdutosDAO(pCodigo);
    }

    /**
     * recupera Produtos
     *
     * @param pNome return Produto
     */
    public Produto getProdutosController(String pNome) {
        return this.daoProdutos.getProdutosDAO(pNome);
    }

    /**
     * recupera uma lista deProdutos
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<Produto> getListaProdutosController() {
        return this.daoProdutos.getListaProdutosDAO();
    }

    /**
     * atualiza Produtos
     *
     * @param pProduto return boolean
     */
    public boolean atualizarProdutosController(Produto pProduto) {
        return this.daoProdutos.atualizarProdutosDAO(pProduto);
    }

    /**
     * exclui Produtos
     *
     * @param pCodigo return boolean
     */
    public boolean excluirProdutosController(int pCodigo) {
        return this.daoProdutos.excluirProdutosDAO(pCodigo);
    }

    /**
     * atualiza Produtos
     *
     * @param pProduto return boolean
     */
    public boolean atualizarProdutosQuantidadeController(Produto pProduto) {
        return this.daoProdutos.atualizarProdutosQuantidadeDAO(pProduto);
    }

    /**
     * atualiza Produtos
     *
     * @param pProduto return boolean
     */
    public boolean atualizarProdutosQuantidadeValorController(ArrayList<CompraProduto> pListaComprasProdutos) {
        return this.daoProdutos.atualizarProdutosQuantidadeValorDAO(pListaComprasProdutos);
    }

    /**
     * atualiza Produtos
     *
     * @param pProduto return boolean
     */
    public boolean atualizarProdutosEstoqueController(Produto pProduto) {
        return this.daoProdutos.atualizarProdutosEstoqueDAO(pProduto);
    }

    /**
     * atualiza Produtos
     *
     * @param pProduto return boolean
     */
    public boolean atualizarProdutosQuantidadeUmController(int pcodigo, float pQuantidade) {
        return this.daoProdutos.atualizarProdutosQuantidadeUmDAO(pcodigo, pQuantidade);
    }

    public boolean gerarRelatorioProdutos() {
        return this.dAORelatorios.gerarRelatorioProdutos();
    }

    public Produto getProdutosCodigoBarrasController(String pCodigoBarras) {
        return this.daoProdutos.getProdutosCodigoBarrasDAO(pCodigoBarras);
    }

    public ArrayList<Produto> getListaProdutosAtivosController() {
        return this.daoProdutos.getListaProdutosAtivosDAO();
    }

    /**
     * Alterar preço e estoque produtos
     *
     * @param pProduto
     * @return
     */
    public boolean atualizarPrecoEstoqueProdutosController(Produto pProduto) {
        return this.daoProdutos.atualizarPrecoEstoqueProdutosDAO(pProduto);
    }

}
