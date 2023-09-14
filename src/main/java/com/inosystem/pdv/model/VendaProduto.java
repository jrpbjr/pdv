/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

import java.math.BigDecimal;

/**
 *
 * @author jrpbj
 */
public class VendaProduto {
    
private Integer codigo;
    private Integer codigoProduto;
    private Integer codigoVenda;
    private Float quantidade;
    private BigDecimal valorUnitario;

    /**
    * Construtor
    */
    public VendaProduto(){}

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
    * seta o valor de codigoProduto
    * @param pCodigoProduto
    */
    public void setCodigo_produto(Integer pCodigoProduto){
        this.codigoProduto = pCodigoProduto;
    }
    /**
    * return codigoProduto
    */
    public Integer getCodigo_produto(){
        return this.codigoProduto;
    }

    /**
    * seta o valor de codigoVenda
    * @param pCodigoVenda
    */
    public void setCodigo_venda(Integer pCodigoVenda){
        this.codigoVenda = pCodigoVenda;
    }
    /**
    * return codigoVenda
    */
    public Integer getCodigo_venda(){
        return this.codigoVenda;
    }

    /**
    * seta o valor de quantidade
    * @param pQuantidade
    */
    public void setQuantidade(Float pQuantidade){
        this.quantidade = pQuantidade;
    }
    /**
    * return quantidade
    */
    public Float getQuantidade(){
        return this.quantidade;
    }

    @Override
    public String toString(){
        return "ModelVendasProdutos {" + "::codigo = " + this.codigo + "::codigo_produto = " + this.codigoProduto + "::codigo_venda = " + this.codigoVenda + "::quantidade = " + this.quantidade +  "}";
    }

    /**
     * @return the valorUnitario
     */
    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}
