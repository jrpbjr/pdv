/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

/**
 *
 * @author jrpbj
 */
public class Config {
    
/**
     * @return the caminhoMySQL
     */
    public String getCaminhoMySQL() {
        return caminhoMySQL;
    }

    /**
     * @param caminhoMySQL the caminhoMySQL to set
     */
    public void setCaminhoMySQL(String caminhoMySQL) {
        this.caminhoMySQL = caminhoMySQL;
    }
    
    private String nomeBanco;
    private String usuario;
    private String senha;
    private String ip;
    private String caminhoMySQL;
    private Integer quantidadeMesas;
    private Integer ambiente;
    private Integer onOfLine;
    private String impressoraPDV;
    private String impressoraCozinha;
    private String impressoraDelivery;

    public Config() {
    }
    
    

    /**
     * @return the nomeBanco
     */
    public String getNomeBanco() {
        return nomeBanco;
    }

    /**
     * @param nomeBanco the nomeBanco to set
     */
    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the quantidadeMesas
     */
    public Integer getQuantidadeMesas() {
        return quantidadeMesas;
    }

    /**
     * @param quantidadeMesas the quantidadeMesas to set
     */
    public void setQuantidadeMesas(Integer quantidadeMesas) {
        this.quantidadeMesas = quantidadeMesas;
    }

    /**
     * @return the ambiente
     */
    public Integer getAmbiente() {
        return ambiente;
    }

    /**
     * @param ambiente the ambiente to set
     */
    public void setAmbiente(Integer ambiente) {
        this.ambiente = ambiente;
    }

    /**
     * @return the onOfLine
     */
    public Integer getOnOfLine() {
        return onOfLine;
    }

    /**
     * @param onOfLine the onOfLine to set
     */
    public void setOnOfLine(Integer onOfLine) {
        this.onOfLine = onOfLine;
    }

    /**
     * @return the impressoraPDV
     */
    public String getImpressoraPDV() {
        return impressoraPDV;
    }

    /**
     * @param impressoraPDV the impressoraPDV to set
     */
    public void setImpressoraPDV(String impressoraPDV) {
        this.impressoraPDV = impressoraPDV;
    }

    /**
     * @return the impressoraCozinha
     */
    public String getImpressoraCozinha() {
        return impressoraCozinha;
    }

    /**
     * @param impressoraCozinha the impressoraCozinha to set
     */
    public void setImpressoraCozinha(String impressoraCozinha) {
        this.impressoraCozinha = impressoraCozinha;
    }

    /**
     * @return the impressoraDelivery
     */
    public String getImpressoraDelivery() {
        return impressoraDelivery;
    }

    /**
     * @param impressoraDelivery the impressoraDelivery to set
     */
    public void setImpressoraDelivery(String impressoraDelivery) {
        this.impressoraDelivery = impressoraDelivery;
    }
    
    
}

