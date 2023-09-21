/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.ContaReceberDao;
import com.inosystem.pdv.dao.RelatorioDao;
import com.inosystem.pdv.model.ContaReceber;
import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class ContaReceberController {

    private ContaReceberDao daoContaReceber = new ContaReceberDao();
    private RelatorioDao daoRelatorios = new RelatorioDao();

    /**
     * grava ContaPagar
     *
     * @param pModelContaCorrente return int
     */
    public int salvarContaReceberController(ContaReceber pModelContaCorrente) {
        return this.daoContaReceber.salvarContaReceberDAO(pModelContaCorrente);
    }

    /**
     * recupera ContaPagar
     *
     * @param pCodigo return ModelConta
     */
    public ContaReceber getContaPagarController(int pCodigo) {
        return this.daoContaReceber.getContaPagarDAO(pCodigo);
    }

    /**
     * recupera uma lista deContaPagar
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<ContaReceber> getListaContaPagarController() {
        return this.daoContaReceber.getListaContaPagarDAO();
    }

    /**
     * recupera uma lista deContaPagar
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<ContaReceber> getListaContaPagarController(int pStatus) {
        return this.daoContaReceber.getListaContaPagarDAO(pStatus);
    }

    /**
     * recupera uma lista deContaReceber
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<ContaReceber> getListaContaReceberController(int pStatus) {
        return this.daoContaReceber.getListaContaReceberDAO(pStatus);
    }

    /**
     * recupera uma lista de todas as Contas
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<ContaReceber> getListaContasController(int pStatus) {
        return this.daoContaReceber.getListaContasDAO(pStatus);
    }

    /**
     * atualiza ContaPagar
     *
     * @param pContaReceber return boolean
     */
    public boolean atualizarContaReceberController(ContaReceber pContaReceber) {
        return this.daoContaReceber.atualizarContaReceberDAO(pContaReceber);
    }

    /**
     * exclui ContaPagar
     *
     * @param pCodigo return boolean
     */
    public boolean excluirContaReceberController(int pCodigo) {
        return this.daoContaReceber.excluirContaReceberDAO(pCodigo);
    }

    /**
     * atualiza ContaReceber
     *
     * @param pModelConta return boolean
     */
    public boolean receberContaReceberController(ContaReceber pModelConta) {
        return this.daoContaReceber.receberContaReceberDAO(pModelConta);
    }

    public boolean gerarRelatorioContaReceber(int pCodigo) {
        return this.daoRelatorios.gerarRelatorioContaReceber(pCodigo);
    }

    public ArrayList<ContaReceber> getListaContasController(ContaReceber pModelConta) {
        return this.daoContaReceber.getListaContasDAO(pModelConta);
    }

    public boolean gerarRelatorioContaVenda(int pCodigo) {
        return this.daoRelatorios.gerarRelatorioContaVenda(pCodigo);
    }

    /**
     * Gerar relatorio contas a pagar e a receber
     *
     * @param modelConta
     * @return
     */
    public boolean gerarRelatorioContasReceberCliente(int pCodigoCliente, int pStatus, Date pDataInicial, Date pDataFinal) {
        return this.daoRelatorios.gerarRelatorioContasReceberCliente(pCodigoCliente, pStatus, pDataInicial, pDataFinal);
    }

    public boolean gerarRelatorioContasReceberTODAS(int pStatus, Date pDataInicial, Date pDataFinal) {
        return this.daoRelatorios.gerarRelatorioContasReceberTODAS(pStatus, pDataInicial, pDataFinal);
    }

}
