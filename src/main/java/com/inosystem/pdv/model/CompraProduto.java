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
public class CompraProduto {
    
private int codigo;
    private int codCompras;
    private int codProduto;
    private double valorCusto;
    private double valorVenda;
    private int quantidade;
    private Produto produto;
    private ArrayList<CompraProduto> listaComprasProdutos;

    /**
    * Construtor
    */
    public CompraProduto(){}

    /**
    * seta o valor de codigo
    * @param pCodigo
    */
    public void setCodigo(int pCodigo){
        this.codigo = pCodigo;
    }
    /**
    * return codigo
    */
    public int getCodigo(){
        return this.codigo;
    }

    /**
    * seta o valor de codCompras
    * @param pCodCompras
    */
    public void setCodCompras(int pCodCompras){
        this.codCompras = pCodCompras;
    }
    /**
    * return codCompras
    */
    public int getCodCompras(){
        return this.codCompras;
    }

    /**
    * seta o valor de codProduto
    * @param pCodProduto
    */
    public void setCodProduto(int pCodProduto){
        this.codProduto = pCodProduto;
    }
    /**
    * return codProduto
    */
    public int getCodProduto(){
        return this.codProduto;
    }

    /**
    * seta o valor de valorCusto
    * @param pValorCusto
    */
    public void setValorCusto(double pValorCusto){
        this.valorCusto = pValorCusto;
    }
    /**
    * return valorCusto
    */
    public double getValorCusto(){
        return this.valorCusto;
    }

    /**
    * seta o valor de valorVenda
    * @param pValorVenda
    */
    public void setValorVenda(double pValorVenda){
        this.valorVenda = pValorVenda;
    }
    /**
    * return valorVenda
    */
    public double getValorVenda(){
        return this.valorVenda;
    }

    /**
    * seta o valor de quantidade
    * @param pQuantidade
    */
    public void setQuantidade(int pQuantidade){
        this.quantidade = pQuantidade;
    }
    /**
    * return quantidade
    */
    public int getQuantidade(){
        return this.quantidade;
    }

    @Override
    public String toString(){
        return "Modelcompras_produtos {" + "::codigo = " + this.codigo + "::codCompras = " + this.codCompras + "::codProduto = " + this.codProduto + "::valorCusto = " + this.valorCusto + "::valorVenda = " + this.valorVenda + "::quantidade = " + this.quantidade +  "}";
    }
    /**
     * @return the listaComprasProdutos
     */
    public ArrayList<CompraProduto> getListaCompraProduto() {
        return listaComprasProdutos;
    }

    /**
     * @param listaComprasProdutos the listaComprasProdutos to set
     */
    public void setListaCompraProduto(ArrayList<CompraProduto> listaComprasProdutos) {
        this.listaComprasProdutos = listaComprasProdutos;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
