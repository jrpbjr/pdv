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
     * @param pModelCidade
     */
    public void setModelCidade(Cidade pModelCidade) {
        this.modelCidade = pModelCidade;
    }

    /**
     * return modelCidade
     */
    public Cidade getModelCidade() {
        return this.modelCidade;
    }

    /**
     * seta o valor de modelEstado
     *
     * @param pModelEstado
     */
    public void setModelEstado(Estado pModelEstado) {
        this.modelEstado = pModelEstado;
    }

    /**
     * return modelEstado
     */
    public Estado getModelEstado() {
        return this.modelEstado;
    }

    @Override
    public String toString() {
        return "ModelCidadeEstado {" + "::modelCidade = " + this.modelCidade + "::modelEstado = " + this.modelEstado + "}";
    }

    /**
     * @return the listaCidadeEstados
     */
    public ArrayList<CidadeEstado> getListaModelCidadeEstados() {
        return listaCidadeEstados;
    }

    /**
     * @param listaCidadeEstados the listaCidadeEstados to set
     */
    public void setListaModelCidadeEstados(ArrayList<CidadeEstado> listaCidadeEstados) {
        this.listaCidadeEstados = listaCidadeEstados;
    }
}
