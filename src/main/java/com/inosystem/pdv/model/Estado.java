/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

/**
 *
 * @author jrpbj
 */
public class Estado {

    private Integer codigo;
    private String uf;
    private String nome;

    /**
     * Construtor
     */
    public Estado() {
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
     * seta o valor de uf
     *
     * @param pUf
     */
    public void setUf(String pUf) {
        this.uf = pUf;
    }

    /**
     * return uf
     */
    public String getUf() {
        return this.uf;
    }

    /**
     * seta o valor de nome
     *
     * @param pNome
     */
    public void setNome(String pNome) {
        this.nome = pNome;
    }

    /**
     * return nome
     */
    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return "ModelEstado {" + "::codigo = " + this.codigo + "::uf = " + this.uf + "::nome = " + this.nome + "}";
    }
}
