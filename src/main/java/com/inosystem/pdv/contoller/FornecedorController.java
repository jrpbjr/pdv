/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.FornecedorDao;
import com.inosystem.pdv.dao.RelatorioDao;
import com.inosystem.pdv.model.Fornecedor;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class FornecedorController {

    private FornecedorDao daoFornecedor = new FornecedorDao();
    private RelatorioDao dAORelatorios = new RelatorioDao();

    /**
     * grava Fornecedor
     *
     * @param pFornecedor return int
     */
    public int salvarFornecedorController(Fornecedor pFornecedor) {
        return this.daoFornecedor.salvarFornecedorDAO(pFornecedor);
    }

    /**
     * recupera Fornecedor
     *
     * @param pCodigo return Fornecedor
     */
    public Fornecedor getFornecedorController(int pCodigo) {
        return this.daoFornecedor.getFornecedorDAO(pCodigo);
    }

    /**
     * recupera Fornecedor
     *
     * @param pNome return Fornecedor
     */
    public Fornecedor getFornecedorController(String pNome) {
        return this.daoFornecedor.getFornecedorDAO(pNome);
    }

    /**
     * recupera Fornecedor
     *
     * @param pNome return Fornecedor
     */
    public Fornecedor getFornecedorProdutoController(int pCodigoProduto) {
        return this.daoFornecedor.getFornecedorProdutoDAO(pCodigoProduto);
    }

    /**
     * recupera uma lista deFornecedor
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<Fornecedor> getListaFornecedorController() {
        return this.daoFornecedor.getListaFornecedorDAO();
    }

    /**
     * atualiza Fornecedor
     *
     * @param pFornecedor return boolean
     */
    public boolean atualizarFornecedorController(Fornecedor pFornecedor) {
        return this.daoFornecedor.atualizarFornecedorDAO(pFornecedor);
    }

    /**
     * exclui Fornecedor
     *
     * @param pCodigo return boolean
     */
    public boolean excluirFornecedorController(int pCodigo) {
        return this.daoFornecedor.excluirFornecedorDAO(pCodigo);
    }

    public boolean gerarRelatorioFornecedor() {
        return this.dAORelatorios.gerarRelatorioFornecedores();
    }
}
