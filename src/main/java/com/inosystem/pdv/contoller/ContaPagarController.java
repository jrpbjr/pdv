/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.ContaPagarDao;
import com.inosystem.pdv.dao.RelatorioDao;
import com.inosystem.pdv.model.ContaPagar;
import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class ContaPagarController {

    private ContaPagarDao daoContaPagar = new ContaPagarDao();
    private RelatorioDao daoRelatorios = new RelatorioDao();

    /**
     * grava ContaPagar
     *
     * @param pContaPagar return int
     */
    public int salvarContaPagarController(ContaPagar pContaPagar) {
        return this.daoContaPagar.salvarContaPagarDAO(pContaPagar);
    }

    /**
     * recupera ContaPagar
     *
     * @param pCodigo return ModelConta
     */
    public ContaPagar getContaPagarController(int pCodigo) {
        return this.daoContaPagar.getContaPagarDAO(pCodigo);
    }

    /**
     * recupera uma lista deContaPagar
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<ContaPagar> getListaContaPagarController() {
        return this.daoContaPagar.getListaContaPagarDAO();
    }

    /**
     * recupera uma lista deContaPagar
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<ContaPagar> getListaContaPagarController(int pStatus) {
        return this.daoContaPagar.getListaContaPagarDAO(pStatus);
    }

    /**
     * recupera uma lista de todas as Contas
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<ContaPagar> getListaContasController(int pStatus) {
        return this.daoContaPagar.getListaContasDAO(pStatus);
    }

    /**
     * atualiza ContaPagar
     *
     * @param pContaPagar return boolean
     */
    public boolean atualizarContaPagarController(ContaPagar pContaPagar) {
        return this.daoContaPagar.atualizarContaPagarDAO(pContaPagar);
    }

    /**
     * atualiza ContaPagar
     *
     * @param pModelConta return boolean
     */
    public boolean pagarContaPagarController(ContaPagar pModelConta) {
        return this.daoContaPagar.pagarContaPagarDAO(pModelConta);
    }

    /**
     * exclui ContaPagar
     *
     * @param pCodigo return boolean
     */
    public boolean excluirContaPagarController(int pCodigo) {
        return this.daoContaPagar.excluirContaPagarDAO(pCodigo);
    }

    public boolean gerarRelatorioContaPagar(int pCodigo) {
        return this.daoRelatorios.gerarRelatorioContaPagar(pCodigo);
    }

    public ArrayList<ContaPagar> getListaContasController(ContaPagar pContaPagar) {
        return this.daoContaPagar.getListaContasDAO(pContaPagar);
    }

    public boolean gerarRelatorioContaVenda(int pCodigo) {
        return this.daoRelatorios.gerarRelatorioContaVenda(pCodigo);
    }

    public boolean gerarRelatorioContasPagarFornecedor(int pCodigoFornecedor, int pStatus, Date pDataInicial, Date pDataFinal) {
        return this.daoRelatorios.gerarRelatorioContasPagarFornecedor(pCodigoFornecedor, pStatus, pDataInicial, pDataFinal);        
        
    }

    public boolean gerarRelatorioContasPagarTODAS(int pStatus, Date pDataInicial, Date pDataFinal) {
        return this.daoRelatorios.gerarRelatorioContasPagarTODAS(pStatus, pDataInicial, pDataFinal);
    }

}
