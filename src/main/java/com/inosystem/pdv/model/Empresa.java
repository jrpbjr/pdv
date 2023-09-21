/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

/**
 *
 * @author jrpbj
 */
public class Empresa {

    private Integer codigo;
    private String razaoSocial;
    private String nomeFantasia;
    private String endereco;
    private String enderecoNumero;
    private String enderecoComplemento;
    private String bairro;
    private Integer codCidade;
    private Integer codEstado;
    private Integer codPais;
    private String cep;
    private String telefone;
    private String cnpj;
    private String inscEstad;
    private String crt;

    /**
     * Construtor
     */
    public Empresa() {
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
     * seta o valor de razaoSocial
     *
     * @param pRazaoSocial
     */
    public void setRazaoSocial(String pRazaoSocial) {
        this.razaoSocial = pRazaoSocial;
    }

    /**
     * return razaoSocial
     */
    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    /**
     * seta o valor de nomeFantasia
     *
     * @param pNomeFantasia
     */
    public void setNomeFantasia(String pNomeFantasia) {
        this.nomeFantasia = pNomeFantasia;
    }

    /**
     * return nomeFantasia
     */
    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    /**
     * seta o valor de endereco
     *
     * @param pEndereco
     */
    public void setEndereco(String pEndereco) {
        this.endereco = pEndereco;
    }

    /**
     * return endereco
     */
    public String getEndereco() {
        return this.endereco;
    }

    /**
     * seta o valor de bairro
     *
     * @param pBairro
     */
    public void setBairro(String pBairro) {
        this.bairro = pBairro;
    }

    /**
     * return bairro
     */
    public String getBairro() {
        return this.bairro;
    }

    /**
     * seta o valor de codCidade
     *
     * @param pCodCidade
     */
    public void setCodCidade(Integer pCodCidade) {
        this.codCidade = pCodCidade;
    }

    /**
     * return codCidade
     */
    public Integer getCodCidade() {
        return this.codCidade;
    }

    /**
     * seta o valor de codEstado
     *
     * @param pCodEstado
     */
    public void setCodEstado(Integer pCodEstado) {
        this.codEstado = pCodEstado;
    }

    /**
     * return codEstado
     */
    public Integer getCodEstado() {
        return this.codEstado;
    }

    /**
     * seta o valor de cep
     *
     * @param pCep
     */
    public void setCep(String pCep) {
        this.cep = pCep;
    }

    /**
     * return cep
     */
    public String getCep() {
        return this.cep;
    }

    /**
     * seta o valor de telefone
     *
     * @param pTelefone
     */
    public void setTelefone(String pTelefone) {
        this.telefone = pTelefone;
    }

    /**
     * return telefone
     */
    public String getTelefone() {
        return this.telefone;
    }

    @Override
    public String toString() {
        return "Empresa {" + "::codigo = " + this.codigo + "::razaoSocial = " + this.razaoSocial + "::nomeFantasia = " + this.nomeFantasia + "::endereco = " + this.endereco + "::bairro = " + this.bairro + "::codCidade = " + this.codCidade + "::codEstado = " + this.codEstado + "::cep = " + this.cep + "::telefone = " + this.telefone + "}";
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the enderecoNumero
     */
    public String getEnderecoNumero() {
        return enderecoNumero;
    }

    /**
     * @param enderecoNumero the enderecoNumero to set
     */
    public void setEnderecoNumero(String enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    /**
     * @return the enderecoComplemento
     */
    public String getEnderecoComplemento() {
        return enderecoComplemento;
    }

    /**
     * @param enderecoComplemento the enderecoComplemento to set
     */
    public void setEnderecoComplemento(String enderecoComplemento) {
        this.enderecoComplemento = enderecoComplemento;
    }

    /**
     * @return the codPais
     */
    public Integer getCodPais() {
        return codPais;
    }

    /**
     * @param codPais the codPais to set
     */
    public void setCodPais(Integer codPais) {
        this.codPais = codPais;
    }

    /**
     * @return the inscEstad
     */
    public String getInscEstad() {
        return inscEstad;
    }

    /**
     * @param inscEstad the inscEstad to set
     */
    public void setInscEstad(String inscEstad) {
        this.inscEstad = inscEstad;
    }

    /**
     * @return the crt
     */
    public String getCrt() {
        return crt;
    }

    /**
     * @param crt the crt to set
     */
    public void setCrt(String crt) {
        this.crt = crt;
    }
}
