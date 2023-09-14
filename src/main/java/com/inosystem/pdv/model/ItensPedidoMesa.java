/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

/**
 *
 * @author jrpbj
 */
public class ItensPedidoMesa {

    private Integer codigo;
    private Integer codigoMesa;
    private Integer codigoProduto;
    private String statusPedido;
    private String observacao;
    private Float quantidade;
    private String hora;
    private Integer codigoGarcom;

    /**
     * Construtor
     */
    public ItensPedidoMesa() {
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
     * return pk_codigo
     */
    public Integer getCodigo() {
        return this.codigo;
    }

    /**
     * seta o valor de codigoMesa
     *
     * @param pCodigoMesa
     */
    public void setCodigoMesa(Integer pCodigoMesa) {
        this.codigoMesa = pCodigoMesa;
    }

    /**
     * return fk_codigoMesa
     */
    public Integer getCodigoMesa() {
        return this.codigoMesa;
    }

    /**
     * seta o valor de codigoProduto
     *
     * @param pCodigoProduto
     */
    public void setCodigoProduto(Integer pCodigoProduto) {
        this.codigoProduto = pCodigoProduto;
    }

    /**
     * return fk_codigoProduto
     */
    public Integer getCodigoProduto() {
        return this.codigoProduto;
    }

    /**
     * seta o valor de statusPedido
     *
     * @param pStatusPedido
     */
    public void setStatusPedido(String pStatusPedido) {
        this.statusPedido = pStatusPedido;
    }

    /**
     * return statusPedido
     */
    public String getStatusPedido() {
        return this.statusPedido;
    }

    /**
     * seta o valor de observacao
     *
     * @param pObservacao
     */
    public void setObservacao(String pObservacao) {
        this.observacao = pObservacao;
    }

    /**
     * return observacao
     */
    public String getObservacao() {
        return this.observacao;
    }

    @Override
    public String toString() {
        return "ModelItensPedidoMesa {" + "::codigo = " + this.codigo + "::codigoMesa = " + this.codigoMesa + "::codigoProduto = " + this.codigoProduto + "::statusPedido = " + this.statusPedido + "::observacao = " + this.observacao + "}";
    }

    /**
     * @return the quantidade
     */
    public Float getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the codigoGarcom
     */
    public Integer getCodigoGarcom() {
        return codigoGarcom;
    }

    /**
     * @param codigoGarcom the codigoGarcom to set
     */
    public void setCodigoGarcom(Integer codigoGarcom) {
        this.codigoGarcom = codigoGarcom;
    }
}
