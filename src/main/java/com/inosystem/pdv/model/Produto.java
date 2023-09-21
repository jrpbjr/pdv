/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class Produto {

    private Integer codigo;
    private Integer fornecedoresCodigo;
    private String nome;
    private String descricaoProduto;
    private Double valor;
    private Double valorCusto;
    private String codigoBarrasEan;
    private Float estoque;
    private Float addEstoque;
    private ArrayList<Produto> listaProdutoes;
    private String imagemProduto;
    private Integer ativo;
    private String marca;
    private Integer diasGarantia;
    private Integer unidadeMedida;
    private Integer origem;
    private BigDecimal peso;
    private String ncm;
    private String tipoNcm;
    private BigDecimal subTribut;
    private BigDecimal icmsCst;
    private BigDecimal icms;
    private BigDecimal icmsRed;
    private String ipiCst;
    private BigDecimal ipi;
    private String pisCst;
    private BigDecimal pis;
    private String cofinsCst;
    private BigDecimal cofins;
    private Produto modelProdutos;

    /**
     * Construtor
     */
    public Produto() {
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
     * seta o valor de fornecedoresCodigo
     *
     * @param pFornecedores_codigo
     */
    public void setFornecedoresCodigo(Integer pFornecedores_codigo) {
        this.fornecedoresCodigo = pFornecedores_codigo;
    }

    /**
     * return fornecedoresCodigo
     */
    public Integer getFornecedoresCodigo() {
        return this.fornecedoresCodigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the valorCusto
     */
    public Double getValorCusto() {
        return valorCusto;
    }

    /**
     * @param valorCusto the valorCusto to set
     */
    public void setValorCusto(Double valorCusto) {
        this.valorCusto = valorCusto;
    }

    /**
     * @return the codigoBarrasEan
     */
    public String getCodigoBarrasEan() {
        return codigoBarrasEan;
    }

    /**
     * @param codigoBarrasEan the codigoBarrasEan to set
     */
    public void setCodigoBarrasEan(String codigoBarrasEan) {
        this.codigoBarrasEan = codigoBarrasEan;
    }

    /**
     * @return the estoque
     */
    public Float getEstoque() {
        return estoque;
    }

    /**
     * @param estoque the estoque to set
     */
    public void setEstoque(Float estoque) {
        this.estoque = estoque;
    }

    /**
     * @return the addEstoque
     */
    public Float getAddEstoque() {
        return addEstoque;
    }

    /**
     * @param addEstoque the addEstoque to set
     */
    public void setAddEstoque(Float addEstoque) {
        this.addEstoque = addEstoque;
    }

    /**
     * @return the listaProdutoes
     */
    public ArrayList<Produto> getListaProdutoes() {
        return listaProdutoes;
    }

    /**
     * @param listaProdutoes the listaProdutoes to set
     */
    public void setListaProdutoes(ArrayList<Produto> listaProdutoes) {
        this.listaProdutoes = listaProdutoes;
    }

    /**
     * @return the imagemProduto
     */
    public String getImagemProduto() {
        return imagemProduto;
    }

    /**
     * @param imagemProduto the imagemProduto to set
     */
    public void setImagemProduto(String imagemProduto) {
        this.imagemProduto = imagemProduto;
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
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the diasGarantia
     */
    public Integer getDiasGarantia() {
        return diasGarantia;
    }

    /**
     * @param diasGarantia the diasGarantia to set
     */
    public void setDiasGarantia(Integer diasGarantia) {
        this.diasGarantia = diasGarantia;
    }

    /**
     * @return the unidadeMedida
     */
    public Integer getUnidadeMedida() {
        return unidadeMedida;
    }

    /**
     * @param unidadeMedida the unidadeMedida to set
     */
    public void setUnidadeMedida(Integer unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    /**
     * @return the origem
     */
    public Integer getOrigem() {
        return origem;
    }

    /**
     * @param origem the origem to set
     */
    public void setOrigem(Integer origem) {
        this.origem = origem;
    }

    /**
     * @return the peso
     */
    public BigDecimal getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    /**
     * @return the ncm
     */
    public String getNcm() {
        return ncm;
    }

    /**
     * @param ncm the ncm to set
     */
    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    /**
     * @return the tipoNcm
     */
    public String getTipoNcm() {
        return tipoNcm;
    }

    /**
     * @param tipoNcm the tipoNcm to set
     */
    public void setTipoNcm(String tipoNcm) {
        this.tipoNcm = tipoNcm;
    }

    /**
     * @return the subTribut
     */
    public BigDecimal getSubTribut() {
        return subTribut;
    }

    /**
     * @param subTribut the subTribut to set
     */
    public void setSubTribut(BigDecimal subTribut) {
        this.subTribut = subTribut;
    }

    /**
     * @return the icmsCst
     */
    public BigDecimal getIcmsCst() {
        return icmsCst;
    }

    /**
     * @param icmsCst the icmsCst to set
     */
    public void setIcmsCst(BigDecimal icmsCst) {
        this.icmsCst = icmsCst;
    }

    /**
     * @return the icms
     */
    public BigDecimal getIcms() {
        return icms;
    }

    /**
     * @param icms the icms to set
     */
    public void setIcms(BigDecimal icms) {
        this.icms = icms;
    }

    /**
     * @return the icmsRed
     */
    public BigDecimal getIcmsRed() {
        return icmsRed;
    }

    /**
     * @param icmsRed the icmsRed to set
     */
    public void setIcmsRed(BigDecimal icmsRed) {
        this.icmsRed = icmsRed;
    }

    /**
     * @return the ipiCst
     */
    public String getIpiCst() {
        return ipiCst;
    }

    /**
     * @param ipiCst the ipiCst to set
     */
    public void setIpiCst(String ipiCst) {
        this.ipiCst = ipiCst;
    }

    /**
     * @return the ipi
     */
    public BigDecimal getIpi() {
        return ipi;
    }

    /**
     * @param ipi the ipi to set
     */
    public void setIpi(BigDecimal ipi) {
        this.ipi = ipi;
    }

    /**
     * @return the pisCst
     */
    public String getPisCst() {
        return pisCst;
    }

    /**
     * @param pisCst the pisCst to set
     */
    public void setPisCst(String pisCst) {
        this.pisCst = pisCst;
    }

    /**
     * @return the pis
     */
    public BigDecimal getPis() {
        return pis;
    }

    /**
     * @param pis the pis to set
     */
    public void setPis(BigDecimal pis) {
        this.pis = pis;
    }

    /**
     * @return the cofinsCst
     */
    public String getCofinsCst() {
        return cofinsCst;
    }

    /**
     * @param cofinsCst the cofinsCst to set
     */
    public void setCofinsCst(String cofinsCst) {
        this.cofinsCst = cofinsCst;
    }

    /**
     * @return the cofins
     */
    public BigDecimal getCofins() {
        return cofins;
    }

    /**
     * @param cofins the cofins to set
     */
    public void setCofins(BigDecimal cofins) {
        this.cofins = cofins;
    }

    /**
     * @return the modelProdutos
     */
    public Produto getProduto() {
        return modelProdutos;
    }

    /**
     * @param modelProdutos the modelProdutos to set
     */
    public void setProduto(Produto modelProdutos) {
        this.modelProdutos = modelProdutos;
    }

    /**
     * @return the descricaoProduto
     */
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    /**
     * @param descricaoProduto the descricaoProduto to set
     */
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    @Override
    public String toString() {
        return codigo + " - " + nome;
    }

}
