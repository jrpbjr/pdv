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
    * @param pCidade
    */
    public void setCidade(Cidade pCidade){
        this.cidade = pCidade;
    }
    /**
    * return modelCidade
    */
    public Cidade getCidade(){
        return this.cidade;
    }

    /**
    * seta o valor de modelEstado
    * @param pEstado
    */
    public void setEstado(Estado pEstado){
        this.estado = pEstado;
    }
    /**
    * return modelEstado
    */
    public Estado getEstado(){
        return this.estado;
    }

    @Override
    public String toString(){
        return "CidadeEstado {" + "::modelCidade = " + this.cidade + "::modelEstado = " + this.estado +  "}";
    }

    /**
     * @return the modelCliente
     */
    public  Fornecedor getFornecedor() {
        return fornecedor;
    }

    /**
     * @param modelFornecedor the modelCliente to set
     */
    public void setFornecedor(Fornecedor modelFornecedor) {
        this.fornecedor = modelFornecedor;
    }
}