/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.ClienteDao;
import com.inosystem.pdv.dao.RelatorioDao;
import com.inosystem.pdv.model.Cliente;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class ClienteController {

    private ClienteDao daoCliente = new ClienteDao();
    private RelatorioDao dAORelatorios = new RelatorioDao();

    /**
     * grava Cliente
     *
     * @param pCliente return int
     */
    public int salvarClienteController(Cliente pCliente) {
        return this.daoCliente.salvarClienteDAO(pCliente);
    }

    /**
     * recupera Cliente
     *
     * @param pCodigo return Cliente
     */
    public Cliente getClienteController(int pCodigo) {
        return this.daoCliente.getClienteDAO(pCodigo);
    }

    /**
     * recupera Cliente
     *
     * @param pNome return Cliente
     */
    public Cliente getClienteController(String pNome) {
        return this.daoCliente.getClienteDAO(pNome);
    }

    /**
     * recupera uma lista deCliente
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<Cliente> getListaClienteController() {
        return this.daoCliente.getListaClienteDAO();
    }

    /**
     * recupera uma lista deCliente
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<Cliente> getListaClienteAtivoController() {
        return this.daoCliente.getListaClienteAtivoDAO();
    }

    /**
     * atualiza Cliente
     *
     * @param pCliente return boolean
     */
    public boolean atualizarClienteController(Cliente pCliente) {
        return this.daoCliente.atualizarClienteDAO(pCliente);
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

    public boolean atualizarEnderecoClienteController(Cliente pCliente) {
        return this.daoCliente.atualizarEnderecoClienteDAO(pCliente);
    }
}
