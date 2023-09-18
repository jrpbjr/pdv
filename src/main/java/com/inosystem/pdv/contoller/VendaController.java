/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.RelatorioDao;
import com.inosystem.pdv.dao.VendaDao;
import com.inosystem.pdv.model.Venda;
import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class VendaController {

    private VendaDao daoVendas = new VendaDao();
    private RelatorioDao dAORelatorios = new RelatorioDao();

    /**
     * grava Vendas
     *
     * @param pVenda return int
     */
    public int salvarVendasController(Venda pVenda) {
        return this.daoVendas.salvarVendasDAO(pVenda);
    }

    /**
     * recupera Vendas
     *
     * @param pCodigo return Venda
     */
    public Venda getVendasController(int pCodigo) {
        return this.daoVendas.getVendasDAO(pCodigo);
    }

    /**
     * recupera uma lista deVendas
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<Venda> getListaPedidosController() {
        return this.daoVendas.getListaPedidosDAO();
    }

    /**
     * recupera uma lista de orçamentos
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<Venda> getListaOrcamentoController() {
        return this.daoVendas.getListaOrcamentoDAO();
    }

    /* recupera uma lista deVendas
    * @param pCodigo
    * return ArrayList
     */
    public ArrayList<Venda> getListaVendasController(int pCodigo) {
        return this.daoVendas.getListaVendasDAO(pCodigo);
    }

    /**
     * atualiza Vendas
     *
     * @param pVenda return boolean
     */
    public boolean atualizarVendasController(Venda pVenda) {
        return this.daoVendas.atualizarVendasDAO(pVenda);
    }

    /**
     * exclui Vendas
     *
     * @param pCodigo return boolean
     */
    public boolean excluirVendasController(int pCodigo) {
        return this.daoVendas.excluirVendasDAO(pCodigo);
    }

    public boolean salvarVendasProdutosController(Venda modelVendas) {
        return this.daoVendas.salvarProdutosVendasDAO(modelVendas);
    }

    public boolean gerarRelatorioVenda(int pCodigo) {
        return this.dAORelatorios.gerarRelatorioVenda(pCodigo);
    }

    public boolean gerarRelatorioOrcamento(int pCodigo) {
        return this.dAORelatorios.gerarRelatorioOrcamento(pCodigo);
    }

    public boolean gerarRelatorioPDV(int pCodigo) {
        return this.dAORelatorios.gerarRelatorioPDV(pCodigo);
    }

    public boolean gerarRelatorioVendasCliente(Date pDataInicial, Date dataFinal, int codigoCliente) {
        return this.dAORelatorios.gerarRelatorioVendasCliente(pDataInicial, dataFinal, codigoCliente);
    }

    public boolean gerarRelatorioVendaTodosCliente(Date dataInicial, Date dataFinal) {
        return this.dAORelatorios.gerarRelatorioVendaTodosCliente(dataInicial, dataFinal);
    }

    /**
     * Excluir os produtos de uma venda
     *
     * @param pCodigo
     * @return
     */
    public boolean excluirProdutoVendasController(int pCodigo) {
        return this.daoVendas.excluirProdutoVendasDAO(pCodigo);
    }

    public ArrayList<Venda> getListaPedidosController(Venda pMdelVendas) {
        return this.daoVendas.getListaPedidosDAO(pMdelVendas);
    }

    /**
     * desaprovar Vendas
     *
     * @param pCodigo return boolean
     */
    public boolean desaprovarPedidoController(int pCodigo) {
        return this.daoVendas.desaprovarPedidoDAO(pCodigo);
    }

    public boolean vizualizarPedidoDaMesa(int pCodigo) {
        return this.dAORelatorios.vizualizarPedidoDaMesa(pCodigo);
    }

    public boolean gerarRelatorioPedidoCozinha(int pCodigo) {
        return this.dAORelatorios.gerarRelatorioPedidoCozinha(pCodigo);
    }

    public boolean vizualizarMesaController(int pCodigo) {
        return this.dAORelatorios.vizualizarMesaDAO(pCodigo);
    }

}
