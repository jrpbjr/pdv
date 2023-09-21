/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

/**
 *
 * @author jrpbj
 */
public class Cidade {
private Integer codigo;
    private String nome;
    private Integer fk_cod_estado;
    private Integer codigoIBGE;

    /**
    * Construtor
    */
    public Cidade(){}

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
    * seta o valor de nome
    * @param pNome
    */
    public void setNome(String pNome){
        this.nome = pNome;
    }
    /**
    * return nome
    */
    public String getNome(){
        return this.nome;
    }

    /**
    * seta o valor de fk_cod_estado
    * @param pFk_cod_estado
    */
    public void setFk_cod_estado(Integer pFk_cod_estado){
        this.fk_cod_estado = pFk_cod_estado;
    }
    /**
    * return fk_cod_estado
    */
    public Integer getFk_cod_estado(){
        return this.fk_cod_estado;
    }

    @Override
    public String toString(){
        return "Cidade {" + "::codigo = " + this.codigo + "::nome = " + this.nome + "::fk_cod_estado = " + this.fk_cod_estado +  "}";
    }

    /**
     * @return the codigoIBGE
     */
    public Integer getCodigoIBGE() {
        return codigoIBGE;
    }

    /**
     * @param codigoIBGE the codigoIBGE to set
     */
    public void setCodigoIBGE(Integer codigoIBGE) {
        this.codigoIBGE = codigoIBGE;
    }
}