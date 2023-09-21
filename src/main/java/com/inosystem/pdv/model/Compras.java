/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

import java.util.Date;

/**
 *
 * @author jrpbj
 */
public class Compras {
private Integer codigo;
    private Double valorTotal;
    private Date data;

    /**
    * Construtor
    */
    public Compras(){}

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
    * seta o valor de valorTotal
    * @param pValorTotal
    */
    public void setValorTotal(Double pValorTotal){
        this.valorTotal = pValorTotal;
    }
    /**
    * return valorTotal
    */
    public Double getValorTotal(){
        return this.valorTotal;
    }

    @Override
    public String toString(){
        return "Compras {" + "::codigo = " + this.codigo + "::valorTotal = " + this.valorTotal +  "}";
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }
}
