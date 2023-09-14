/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

/**
 *
 * @author jrpbj
 */
public class ClienteCidadeEstado {

    private Cidade cidade;
    private Estado estado;
    private Cliente cliente;

    /**
     * Construtor
     */
    public ClienteCidadeEstado() {
    }

    /**
     * seta o valor de cidade
     *
     * @param pCidade
     */
    public void setCidade(Cidade pCidade) {
        this.cidade = pCidade;
    }

    /**
     * return cidade
     */
    public Cidade getCidade() {
        return this.cidade;
    }

    /**
     * seta o valor de estado
     *
     * @param pEstado
     */
    public void setEstado(Estado pEstado) {
        this.estado = pEstado;
    }

    /**
     * return estado
     */
    public Estado getEstado() {
        return this.estado;
    }

    @Override
    public String toString() {
        return "ClienteCidadeEstado{" + "cidade=" + cidade + ", estado=" + estado + ", cliente=" + cliente + '}';
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
