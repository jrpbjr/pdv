/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

/**
 *
 * @author jrpbj
 */
public class TransportadoraCidEst {

    private Cidade cidade;
    private Estado estado;
    private Transportadora transportadora;

    /**
     * Construtor
     */
    public TransportadoraCidEst() {
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

    /**
     * seta o valor de transportadora
     *
     * @param pTransportadora
     */
    public void setTransportadora(Transportadora pTransportadora) {
        this.transportadora = pTransportadora;
    }

    /**
     * return transportadora
     */
    public Transportadora getTransportadora() {
        return this.transportadora;
    }

    @Override
    public String toString() {
        return "TransportadoraCidEst {" + "::cidade = " + this.cidade + "::estado = " + this.estado + "::transportadora = " + this.transportadora + "}";
    }
}
