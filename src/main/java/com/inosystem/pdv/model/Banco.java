/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

/**
 *
 * @author jrpbj
 */
public class Banco {
   private Integer codigo;
    private String banco;
    private String descricao;
    private String nomeReduzido;
    private String emiteBoleto;

    /**
    * Construtor
    */
    public Banco(){}

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
    * seta o valor de banco
    * @param pBanco
    */
    public void setBanco(String pBanco){
        this.banco = pBanco;
    }
    /**
    * return banco
    */
    public String getBanco(){
        return this.banco;
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
    * seta o valor de nomeReduzido
    * @param pNomeReduzido
    */
    public void setNomeReduzido(String pNomeReduzido){
        this.nomeReduzido = pNomeReduzido;
    }
    /**
    * return nomeReduzido
    */
    public String getNomeReduzido(){
        return this.nomeReduzido;
    }

    /**
    * seta o valor de emiteBoleto
    * @param pEmiteBoleto
    */
    public void setEmiteBoleto(String pEmiteBoleto){
        this.emiteBoleto = pEmiteBoleto;
    }
    /**
    * return emiteBoleto
    */
    public String getEmiteBoleto(){
        return this.emiteBoleto;
    }

    @Override
    public String toString(){
        return "Banco {" + "::codigo = " + this.codigo + "::banco = " + this.banco + "::descricao = " + this.descricao + "::nomeReduzido = " + this.nomeReduzido + "::emiteBoleto = " + this.emiteBoleto +  "}";
    }
}