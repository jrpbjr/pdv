/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

/**
 *
 * @author jrpbj
 */
public class Transportadora {
    
private Integer codigo;
    private String nome;
    private String endereco;
    private String bairro;
    private String cep;
    private String telefone;
    private Integer codCidade;
    private String nomeFantasia;
    private String cnpj;
    private String inscEstad;

    /**
     * Construtor
     */
    public Transportadora() {
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
     * seta o valor de nome
     *
     * @param pNome
     */
    public void setNome(String pNome) {
        this.nome = pNome;
    }

    /**
     * return nome
     */
    public String getNome() {
        return this.nome;
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
     * seta o valor de cnpj
     *
     * @param pCnpj
     */
    public void setCnpj(String pCnpj) {
        this.cnpj = pCnpj;
    }

    /**
     * return cnpj
     */
    public String getCnpj() {
        return this.cnpj;
    }

    /**
     * seta o valor de inscEstad
     *
     * @param pInscEstad
     */
    public void setInscEstad(String pInscEstad) {
        this.inscEstad = pInscEstad;
    }

    /**
     * return inscEstad
     */
    public String getInscEstad() {
        return this.inscEstad;
    }

    @Override
    public String toString() {
        return "Transportadora {" + "::codigo = " + this.codigo + "::nome = " + this.nome + "::endereco = " + this.endereco + "::bairro = " + this.bairro + "::cep = " + this.cep + "::telefone = " + this.telefone + "::cod_cidade = " + this.codCidade + "::nome_fantasia = " + this.nomeFantasia + "::cnpj = " + this.cnpj + "::insc_estad = " + this.inscEstad + "}";
    }
}

