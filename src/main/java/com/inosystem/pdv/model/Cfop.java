/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

/**
 *
 * @author jrpbj
 */
public class Cfop {
    
    private Integer codigo;
    private Integer cfop;
    private String descricao;
    private String observacao;
    private Integer faturamento;
    private Integer financeiro;
    private Integer sequeCfop;
    private String operacao;

    /**
    * Construtor
    */
    public Cfop(){}

    /**
    * seta o valor de codigo
    * @param pCodigo
    */
    public void setCodigo(Integer pCodigo){
        this.codigo = pCodigo;
    }
    /**
    * return codigo
    */
    public Integer getCodigo(){
        return this.codigo;
    }

    /**
    * seta o valor de cfop
    * @param pCfop
    */
    public void setCfop(Integer pCfop){
        this.cfop = pCfop;
    }
    /**
    * return cfop
    */
    public Integer getCfop(){
        return this.cfop;
    }

    /**
    * seta o valor de descricao
    * @param pDescricao
    */
    public void setDescricao(String pDescricao){
        this.descricao = pDescricao;
    }
    /**
    * return descricao
    */
    public String getDescricao(){
        return this.descricao;
    }

    /**
    * seta o valor de observacao
    * @param pObservacao
    */
    public void setObservacao(String pObservacao){
        this.observacao = pObservacao;
    }
    /**
    * return observacao
    */
    public String getObservacao(){
        return this.observacao;
    }

    /**
    * seta o valor de faturamento
    * @param pFaturamento
    */
    public void setFaturamento(Integer pFaturamento){
        this.faturamento = pFaturamento;
    }
    /**
    * return faturamento
    */
    public Integer getFaturamento(){
        return this.faturamento;
    }

    /**
    * seta o valor de financeiro
    * @param pFinanceiro
    */
    public void setFinanceiro(Integer pFinanceiro){
        this.financeiro = pFinanceiro;
    }
    /**
    * return financeiro
    */
    public Integer getFinanceiro(){
        return this.financeiro;
    }

    /**
    * seta o valor de sequeCfop
    * @param pSequeCfop
    */
    public void setSequeCfop(Integer pSequeCfop){
        this.sequeCfop = pSequeCfop;
    }
    /**
    * return sequeCfop
    */
    public Integer getSequeCfop(){
        return this.sequeCfop;
    }

    /**
    * seta o valor de operacao
    * @param pOperacao
    */
    public void setOperacao(String pOperacao){
        this.operacao = pOperacao;
    }
    /**
    * return operacao
    */
    public String getOperacao(){
        return this.operacao;
    }

    @Override
    public String toString(){
        return "ModelCFOP {" + "::codigo = " + this.codigo + "::cfop = " + this.cfop + "::descricao = " + this.descricao + "::observacao = " + this.observacao + "::faturamento = " + this.faturamento + "::financeiro = " + this.financeiro + "::sequeCfop = " + this.sequeCfop + "::operacao = " + this.operacao +  "}";
    }
}
