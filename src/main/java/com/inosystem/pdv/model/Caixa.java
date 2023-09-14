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
public class Caixa {
    private Integer codigo;
    private Double dinheiro;
    private Double cheque;
    private Double cartao;
    private Double convenio;
    private Integer caixaNumero;
    private Integer codigoUsuario;
    private Integer status;
    private Date dataAbertura;
    private Date dataFechamento;
    
  
    /**
    * Construtor
    */
    public Caixa(){}

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
    * seta o valor de dinheiro
    * @param pDinheiro
    */
    public void setDinheiro(Double pDinheiro){
        this.dinheiro = pDinheiro;
    }
    /**
    * return dinheiro
    */
    public Double getDinheiro(){
        return this.dinheiro;
    }

    /**
    * seta o valor de cheque
    * @param pCheque
    */
    public void setCheque(Double pCheque){
        this.cheque = pCheque;
    }
    /**
    * return cheque
    */
    public Double getCheque(){
        return this.cheque;
    }

    /**
    * seta o valor de cartao
    * @param pCartao
    */
    public void setCartao(Double pCartao){
        this.cartao = pCartao;
    }
    /**
    * return cartao
    */
    public Double getCartao(){
        return this.cartao;
    }

    /**
    * seta o valor de convenio
    * @param pVale
    */
    public void setConvenio(Double pVale){
        this.convenio = pVale;
    }
    /**
    * return convenio
    */
    public Double getConvenio(){
        return this.convenio;
    }

    @Override
    public String toString(){
        return "ModelCaixa {" + "::codigo = " + this.codigo + "::dinheiro = " + this.dinheiro + "::cheque = " + this.cheque + "::cartao = " + this.cartao + "::vale = " + this.convenio +  "}";
    }

    /**
     * @return the caixaNumero
     */
    public Integer getCaixaNumero() {
        return caixaNumero;
    }

    /**
     * @param caixaNumero the caixaNumero to set
     */
    public void setCaixaNumero(Integer caixaNumero) {
        this.caixaNumero = caixaNumero;
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
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the dataAbertura
     */
    public Date getDataAbertura() {
        return dataAbertura;
    }

    /**
     * @param dataAbertura the dataAbertura to set
     */
    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    /**
     * @return the dataFechamento
     */
    public Date getDataFechamento() {
        return dataFechamento;
    }

    /**
     * @param dataFechamento the dataFechamento to set
     */
    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }
}