/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class Venda {

    private Integer codigo;
    private Integer produtosCodigo;
    private Integer clientesCodigo;
    private Date dataVenda;
    private Date dataPagamento;
    private BigDecimal quantidade;
    private BigDecimal valor;
    private BigDecimal valorTotal;
    private BigDecimal desconto;
    private Integer tipoPagamento;
    private ArrayList<Venda> listaVenda;
    private Integer tipo;
    private String observacao;
    private Integer codigoUsuario;
    private BigDecimal taxaEntrega;

    /**
     * Construtor
     */
    public Venda() {
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
     * seta o valor de produtosCodigo
     *
     * @param pProdutosCodigo
     */
    public void setProdutosCodigo(Integer pProdutosCodigo) {
        this.produtosCodigo = pProdutosCodigo;
    }

    /**
     * return produtosCodigo
     */
    public Integer getProdutosCodigo() {
        return this.produtosCodigo;
    }

    /**
     * seta o valor de clientesCodigo
     *
     * @param pClientesCodigo
     */
    public void setClientesCodigo(Integer pClientesCodigo) {
        this.clientesCodigo = pClientesCodigo;
    }

    /**
     * return clientesCodigo
     */
    public Integer getClientesCodigo() {
        return this.clientesCodigo;
    }

    /**
     * seta o valor de dataVenda
     *
     * @param pDataVenda
     */
    public void setDataVenda(Date pDataVenda) {
        this.dataVenda = pDataVenda;
    }

    /**
     * return dataVenda
     */
    public Date getDataVenda() {
        return this.dataVenda;
    }

    /**
     * seta o valor de quantidade
     *
     * @param pQuantidade
     */
    public void setQuantidade(BigDecimal pQuantidade) {
        this.quantidade = pQuantidade;
    }

    /**
     * return quantidade
     */
    public BigDecimal getQuantidade() {
        return this.quantidade;
    }

    @Override
    public String toString() {
        return "ModelVendas {" + "::codigo = " + this.codigo + "::produtosCodigo = " + this.produtosCodigo + "::clientesCodigo = " + this.clientesCodigo + "::dataVenda = " + this.dataVenda + "::quantidade = " + this.quantidade + "}";
    }

    /**
     * @return the valor
     */
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    /**
     * @return the listaVenda
     */
    public ArrayList<Venda> getListamModelVendases() {
        return listaVenda;
    }

    /**
     * @param listaVenda the listaVenda to set
     */
    public void setListamModelVendases(ArrayList<Venda> listaVenda) {
        this.listaVenda = listaVenda;
    }

    /**
     * @return the valorTotal
     */
    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the desconto
     */
    public BigDecimal getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the tipoPagamento
     */
    public Integer getTipoPagamento() {
        return tipoPagamento;
    }

    /**
     * @param tipoPagamento the tipoPagamento to set
     */
    public void setTipoPagamento(Integer tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    /**
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * @return the tipo
     */
    public Integer getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the dataPagamento
     */
    public Date getDataPagamento() {
        return dataPagamento;
    }

    /**
     * @param dataPagamento the dataPagamento to set
     */
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    /**
     * @return the codigoUsuario
     */
    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    /**
     * @param codigoUsuario the codigoUsuario to set
     */
    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    /**
     * @return the taxaEntrega
     */
    public BigDecimal getTaxaEntrega() {
        return taxaEntrega;
    }

    /**
     * @param taxaEntrega the taxaEntrega to set
     */
    public void setTaxaEntrega(BigDecimal taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }

}
