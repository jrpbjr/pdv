/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class CidadeEstado {

    private Cidade modelCidade;
    private Estado modelEstado;
    private ArrayList<CidadeEstado> listaCidadeEstados;

    /**
     * Construtor
     */
    public CidadeEstado() {
    }

    /**
     * seta o valor de modelCidade
     *
     * @param pCidade
     */
    public void setCidade(Cidade pCidade) {
        this.modelCidade = pCidade;
    }

    /**
     * return modelCidade
     */
    public Cidade getCidade() {
        return this.modelCidade;
    }

    /**
     * seta o valor de modelEstado
     *
     * @param pEstado
     */
    public void setEstado(Estado pEstado) {
        this.modelEstado = pEstado;
    }

    /**
     * return modelEstado
     */
    public Estado getEstado() {
        return this.modelEstado;
    }

    @Override
    public String toString() {
        return "CidadeEstado {" + "::modelCidade = " + this.modelCidade + "::modelEstado = " + this.modelEstado + "}";
    }

    /**
     * @return the listaCidadeEstados
     */
    public ArrayList<CidadeEstado> getListaCidadeEstados() {
        return listaCidadeEstados;
    }

    /**
     * @param listaCidadeEstados the listaCidadeEstados to set
     */
    public void setListaCidadeEstados(ArrayList<CidadeEstado> listaCidadeEstados) {
        this.listaCidadeEstados = listaCidadeEstados;
    }
}
