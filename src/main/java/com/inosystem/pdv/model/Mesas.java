/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

/**
 *
 * @author jrpbj
 */
public class Mesas {

    private Integer codigo;
    private Integer numeroMesa;
    private String situacaoMesa;

    /**
     * Construtor
     */
    public Mesas() {
    }

    /**
     * seta o valor de codigo
     *
     * @param pCodigo
     */
    public void setCodigo(Integer pCodigo) {
        this.codigo = pCodigo;
    }

    /**
     * return pk_codigo
     */
    public Integer getCodigo() {
        return this.codigo;
    }

    /**
     * seta o valor de numeroMesa
     *
     * @param pNumeroMesa
     */
    public void setNumeroMesa(Integer pNumeroMesa) {
        this.numeroMesa = pNumeroMesa;
    }

    /**
     * return numeroMesa
     */
    public Integer getNumeroMesa() {
        return this.numeroMesa;
    }

    /**
     * seta o valor de situacaoMesa
     *
     * @param pSituacaoMesa
     */
    public void setSituacaoMesa(String pSituacaoMesa) {
        this.situacaoMesa = pSituacaoMesa;
    }

    /**
     * return situacaoMesa
     */
    public String getSituacaoMesa() {
        return this.situacaoMesa;
    }

    @Override
    public String toString() {
        return "mesas {" + "::codigo = " + this.codigo + "::numeroMesa = " + this.numeroMesa + "::situacaoMesa = " + this.situacaoMesa + "}";
    }

}
