/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class ClienteController {

    private ClienteDao daoCliente = new ClienteDao();
    private DAORelatorios dAORelatorios = new DAORelatorios();

    /**
     * grava Cliente
     *
     * @param pModelCliente return int
     */
    public int salvarClienteController(ModelCliente pModelCliente) {
        return this.daoCliente.salvarClienteDAO(pModelCliente);
    }

    /**
     * recupera Cliente
     *
     * @param pCodigo return ModelCliente
     */
    public ModelCliente getClienteController(int pCodigo) {
        return this.daoCliente.getClienteDAO(pCodigo);
    }

    /**
     * recupera Cliente
     *
     * @param pNome return ModelCliente
     */
    public ModelCliente getClienteController(String pNome) {
        return this.daoCliente.getClienteDAO(pNome);
    }

    /**
     * recupera uma lista deCliente
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<ModelCliente> getListaClienteController() {
        return this.daoCliente.getListaClienteDAO();
    }

    /**
     * recupera uma lista deCliente
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<ModelCliente> getListaClienteAtivoController() {
        return this.daoCliente.getListaClienteAtivoDAO();
    }

    /**
     * atualiza Cliente
     *
     * @param pModelCliente return boolean
     */
    public boolean atualizarClienteController(ModelCliente pModelCliente) {
        return this.daoCliente.atualizarClienteDAO(pModelCliente);
    }

    /**
     * exclui Cliente
     *
     * @param pCodigo return boolean
     */
    public boolean excluirClienteController(int pCodigo) {
        return this.daoCliente.excluirClienteDAO(pCodigo);
    }

    public boolean gerarRelatorioCliente() {
        return this.dAORelatorios.gerarRelatorioCliente();
    }

    public boolean gerarRelatorioClienteIndividual(int pCodigoCliente) {
        return this.dAORelatorios.gerarRelatorioClienteIndividual(pCodigoCliente);
    }

    public boolean atualizarEnderecoClienteController(ModelCliente pModelCliente) {
        return this.daoCliente.atualizarEnderecoClienteDAO(pModelCliente);
    }
}
