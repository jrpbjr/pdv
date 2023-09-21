/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

/**
 *
 * @author jrpbj
 */
public class Cliente {
    
private Integer codigo;
    private String nome;
    private String endereco;
    private String bairro;
    private Integer codCidade;
    private Integer codEstado;
    private String cep;
    private String telefone;
    private String cpfCNPJ;
    private String observacao;
    private Integer ativo;
    private String tipoPessoa;
    private String nomeFantasia;

    /**
    * Construtor
    */
    public Cliente(){}

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
    * seta o valor de nome
    * @param pNome
    */
    public void setNome(String pNome){
        this.nome = pNome;
    }
    /**
    * return nome
    */
    public String getNome(){
        return this.nome;
    }

    /**
    * seta o valor de endereco
    * @param pEndereco
    */
    public void setEndereco(String pEndereco){
        this.endereco = pEndereco;
    }
    /**
    * return endereco
    */
    public String getEndereco(){
        return this.endereco;
    }

    /**
    * seta o valor de bairro
    * @param pBairro
    */
    public void setBairro(String pBairro){
        this.bairro = pBairro;
    }
    /**
    * return bairro
    */
    public String getBairro(){
        return this.bairro;
    }

    /**
    * seta o valor de codCidade
    * @param pCidade
    */
    public void setCodCidade(Integer pCidade){
        this.codCidade = pCidade;
    }
    /**
    * return codCidade
    */
    public Integer getCodCidade(){
        return this.codCidade;
    }

    /**
    * seta o valor de codEstado
    * @param pUf
    */
    public void setCodEstado(Integer pUf){
        this.codEstado = pUf;
    }
    /**
    * return codEstado
    */
    public Integer getCodEstado(){
        return this.codEstado;
    }

    /**
    * seta o valor de cep
    * @param pCep
    */
    public void setCep(String pCep){
        this.cep = pCep;
    }
    /**
    * return cep
    */
    public String getCep(){
        return this.cep;
    }

    /**
    * seta o valor de telefone
    * @param pTelefone
    */
    public void setTelefone(String pTelefone){
        this.telefone = pTelefone;
    }
    /**
    * return telefone
    */
    public String getTelefone(){
        return this.telefone;
    }


    @Override
    public String toString(){
        return "Cliente {" + "::codigo = " + this.codigo + "::nome = " + this.nome + "::endereco = " + this.endereco + "::bairro = " + this.bairro + "::cidade = " + this.codCidade + "::uf = " + this.codEstado + "::cep = " + this.cep + "::telefone = " + this.telefone +"}";
    }

    /**
     * @return the cpfCNPJ
     */
    public String getCpfCNPJ() {
        return cpfCNPJ;
    }

    /**
     * @param cpfCNPJ the cpfCNPJ to set
     */
    public void setCpfCNPJ(String cpfCNPJ) {
        this.cpfCNPJ = cpfCNPJ;
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
     * @return the ativo
     */
    public Integer getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the tipoPessoa
     */
    public String getTipoPessoa() {
        return tipoPessoa;
    }

    /**
     * @param tipoPessoa the tipoPessoa to set
     */
    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    /**
     * @return the nomeFantasia
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    /**
     * @param nomeFantasia the nomeFantasia to set
     */
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
}
