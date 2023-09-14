/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

/**
 *
 * @author jrpbj
 */
public class TotalMesa {

    private Integer codigo;
    private Integer quantidade;

    /**
     * Construtor
     */
    public TotalMesa() {
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
     * seta o valor de quantidade
     *
     * @param pQuantidade
     */
    public void setQuantidade(Integer pQuantidade) {
        this.quantidade = pQuantidade;
    }

    /**
     * return quantidade
     */
    public Integer getQuantidade() {
        return this.quantidade;
    }

    @Override
    public String toString() {
        return "ModelTotalMesas {" + "::codigo = " + this.codigo + "::quantidade = " + this.quantidade + "}";
    }
}
