/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

/**
 *
 * @author jrpbj
 */
public class FormaPagamento {

    private Integer codigo;
    private String descricao;
    private Float desconto;
    private Integer quantidadeParcelas;
    private String observacao;
    private boolean situacao;

    /**
     * Construtor
     */
    public FormaPagamento() {
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
     * return codigo
     */
    public Integer getCodigo() {
        return this.codigo;
    }

    /**
     * seta o valor de descricao
     *
     * @param pDescricao
     */
    public void setDescricao(String pDescricao) {
        this.descricao = pDescricao;
    }

    /**
     * return descricao
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * seta o valor de desconto
     *
     * @param pDesconto
     */
    public void setDesconto(Float pDesconto) {
        this.desconto = pDesconto;
    }

    /**
     * return desconto
     */
    public Float getDesconto() {
        return this.desconto;
    }

    /**
     * seta o valor de quantidadeParcelas
     *
     * @param pQuantidadeParcelas
     */
    public void setQuantidadeParcelas(Integer pQuantidadeParcelas) {
        this.quantidadeParcelas = pQuantidadeParcelas;
    }

    /**
     * return quantidadeParcelas
     */
    public Integer getQuantidadeParcelas() {
        return this.quantidadeParcelas;
    }

    /**
     * seta o valor de observacao
     *
     * @param pObservacao
     */
    public void setObservacao(String pObservacao) {
        this.observacao = pObservacao;
    }

    /**
     * return observacao
     */
    public String getObservacao() {
        return this.observacao;
    }

    /**
     * seta o valor de situacao
     *
     * @param pSituacao
     */
    public void setSituacao(boolean pSituacao) {
        this.situacao = pSituacao;
    }

    /**
     * return situacao
     */
    public boolean isSituacao() {
        return this.situacao;
    }

    @Override
    public String toString() {
        return "FormaPagamento {" + "::codigo = " + this.codigo + "::descricao = " + this.descricao + "::desconto = " + this.desconto + "::quantidadeParcelas = " + this.quantidadeParcelas + "::observacao = " + this.observacao + "::situacao = " + this.situacao + "}";
    }
}
