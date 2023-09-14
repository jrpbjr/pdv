/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

/**
 *
 * @author jrpbj
 */
public class UnidadeMedia {

    private Integer codigo;
    private String abreviacao;
    private String descricao;

    /**
     * Construtor
     */
    public UnidadeMedia() {
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
     * seta o valor de abreviacao
     *
     * @param pAbreviacao
     */
    public void setAbreviacao(String pAbreviacao) {
        this.abreviacao = pAbreviacao;
    }

    /**
     * return abreviacao
     */
    public String getAbreviacao() {
        return this.abreviacao;
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

    @Override
    public String toString() {
        return "ModelUnidadeMedia {" + "::codigo = " + this.codigo + "::abreviacao = " + this.abreviacao + "::descricao = " + this.descricao + "}";
    }
}
