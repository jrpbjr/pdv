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
     * @param pModelCidade
     */
    public void setModelCidade(Cidade pModelCidade) {
        this.cidade = pModelCidade;
    }

    /**
     * return cidade
     */
    public Cidade getModelCidade() {
        return this.cidade;
    }

    /**
     * seta o valor de estado
     *
     * @param pModelEstado
     */
    public void setModelEstado(Estado pModelEstado) {
        this.estado = pModelEstado;
    }

    /**
     * return estado
     */
    public Estado getModelEstado() {
        return this.estado;
    }

    /**
     * seta o valor de transportadora
     *
     * @param pModelTransportadora
     */
    public void setModelTransportadora(Transportadora pModelTransportadora) {
        this.transportadora = pModelTransportadora;
    }

    /**
     * return transportadora
     */
    public Transportadora getModelTransportadora() {
        return this.transportadora;
    }

    @Override
    public String toString() {
        return "ModelTransportadoraCidEst {" + "::cidade = " + this.cidade + "::estado = " + this.estado + "::transportadora = " + this.transportadora + "}";
    }
}
