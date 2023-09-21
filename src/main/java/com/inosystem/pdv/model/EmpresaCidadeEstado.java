/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

/**
 *
 * @author jrpbj
 */
public class EmpresaCidadeEstado {

    private Cidade cidade;
    private Estado estado;
    private Empresa empresa;

    /**
     * Construtor
     */
    public EmpresaCidadeEstado() {
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
     * seta o valor de empresa
     *
     * @param pestado
     */
    public void setEstado(Estado pestado) {
        this.estado = pestado;
    }

    /**
     * return empresa
     */
    public Estado getEstado() {
        return this.estado;
    }

    /**
     * seta o valor de empresa
     *
     * @param pEmpresa
     */
    public void setEmpresa(Empresa pEmpresa) {
        this.empresa = pEmpresa;
    }

    /**
     * return empresa
     */
    public Empresa getEmpresa() {
        return this.empresa;
    }

    @Override
    public String toString() {
        return "EmpresaCidadeestado {" + "::cidade = " + this.cidade + "::empresa = " + this.empresa + "::empresa = " + this.empresa + "}";
    }
}
