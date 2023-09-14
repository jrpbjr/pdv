/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

/**
 *
 * @author jrpbj
 */
public class FornecedorCidadeEstado {

    private Cidade cidade;
    private Estado estado;
    private Fornecedor fornecedor;

    /**
     * Construtor
     */
    public FornecedorCidadeEstado() {
    }

    /**
    * seta o valor de modelCidade
    * @param pModelCidade
    */
    public void setModelCidade(Cidade pModelCidade){
        this.cidade = pModelCidade;
    }
    /**
    * return modelCidade
    */
    public Cidade getModelCidade(){
        return this.cidade;
    }

    /**
    * seta o valor de modelEstado
    * @param pModelEstado
    */
    public void setModelEstado(Estado pModelEstado){
        this.estado = pModelEstado;
    }
    /**
    * return modelEstado
    */
    public Estado getModelEstado(){
        return this.estado;
    }

    @Override
    public String toString(){
        return "ModelCidadeEstado {" + "::modelCidade = " + this.cidade + "::modelEstado = " + this.estado +  "}";
    }

    /**
     * @return the modelCliente
     */
    public  Fornecedor getModelFornecedor() {
        return fornecedor;
    }

    /**
     * @param modelFornecedor the modelCliente to set
     */
    public void setModelFornecedor(Fornecedor modelFornecedor) {
        this.fornecedor = modelFornecedor;
    }
}