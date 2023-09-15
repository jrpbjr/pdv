/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.CompraProduto;
import com.inosystem.pdv.model.Produto;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class ProdutoDao extends ConexaoMySql {
    
/**
     * grava Produtos
     *
     * @param pProduto return int
     */
    public int salvarProdutosDAO(Produto pProduto) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO produtos ("
                    + "fornecedores_codigo,"
                    + "nome,"
                    + "descricao_produto,"
                    + "valor,"
                    + "valor_custo,"
                    + "codigo_barras_ean,"
                    + "estoque,"
                    + "imagem_produto,"
                    + "ativo,"
                    + "marca,"
                    + "dias_garantia,"
                    + "unidade_medida,"
                    + "origem,"
                    + "peso,"
                    + "ncm,"
                    + "tipo_ncm,"
                    + "trib_st_perc,"
                    + "icms_cst,"
                    + "icms,"
                    + "icms_red,"
                    + "ipi_cst,"
                    + "ipi,"
                    + "pis_cst,"
                    + "pis,"
                    + "cofins_cst,"
                    + "cofins"
                    + ") VALUES ("
                    + "'" + pProduto.getFornecedoresCodigo() + "',"
                    + "'" + pProduto.getNome() + "',"
                    + "'" + pProduto.getDescricaoProduto() + "',"
                    + "'" + pProduto.getValor() + "',"
                    + "'" + pProduto.getValorCusto() + "',"
                    + "'" + pProduto.getCodigoBarrasEan() + "',"
                    + "'" + pProduto.getEstoque() + "',"
                    + "'" + pProduto.getImagemProduto() + "',"
                    + "'" + pProduto.getAtivo() + "',"
                    + "'" + pProduto.getMarca() + "',"
                    + "'" + pProduto.getDiasGarantia() + "',"
                    + "'" + pProduto.getUnidadeMedida() + "',"
                    + "'" + pProduto.getOrigem() + "',"
                    + "'" + pProduto.getPeso() + "',"
                    + "'" + pProduto.getNcm() + "',"
                    + "'" + pProduto.getTipoNcm() + "',"
                    + "'" + pProduto.getSubTribut() + "',"
                    + "'" + pProduto.getIcmsCst() + "',"
                    + "'" + pProduto.getIcms() + "',"
                    + "'" + pProduto.getIcmsRed() + "',"
                    + "'" + pProduto.getIpiCst() + "',"
                    + "'" + pProduto.getIpi() + "',"
                    + "'" + pProduto.getPisCst() + "',"
                    + "'" + pProduto.getPis() + "',"
                    + "'" + pProduto.getPisCst() + "',"
                    + "'" + pProduto.getCofins() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera Produtos
     *
     * @param pCodigo return Produto
     */
    public Produto getProdutosDAO(int pCodigo) {
        Produto modelProdutos = new Produto();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "fornecedores_codigo,"
                    + "nome,"
                    + "descricao_produto,"
                    + "valor,"
                    + "valor_custo,"
                    + "codigo_barras_ean,"
                    + "estoque,"
                    + "imagem_produto,"
                    + "ativo,"
                    + "marca,"
                    + "dias_garantia,"
                    + "unidade_medida,"
                    + "origem,"
                    + "peso,"
                    + "ncm,"
                    + "tipo_ncm,"
                    + "trib_st_perc,"
                    + "icms_cst,"
                    + "icms,"
                    + "icms_red,"
                    + "ipi_cst,"
                    + "ipi,"
                    + "pis_cst,"
                    + "pis,"
                    + "cofins_cst,"
                    + "cofins"
                    + " FROM"
                    + " produtos"
                    + " WHERE"
                    + " codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProdutos.setCodigo(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setDescricaoProduto(this.getResultSet().getString(4));
                modelProdutos.setValor(this.getResultSet().getDouble(5));
                modelProdutos.setValorCusto(this.getResultSet().getDouble(6));
                modelProdutos.setCodigoBarrasEan(this.getResultSet().getString(7));
                modelProdutos.setEstoque(this.getResultSet().getFloat(8));
                modelProdutos.setImagemProduto(this.getResultSet().getString(9));
                modelProdutos.setAtivo(this.getResultSet().getInt(10));
                modelProdutos.setMarca(this.getResultSet().getString(11));
                modelProdutos.setDiasGarantia(this.getResultSet().getInt(12));
                modelProdutos.setUnidadeMedida(this.getResultSet().getInt(13));
                modelProdutos.setOrigem(this.getResultSet().getInt(14));
                modelProdutos.setPeso(this.getResultSet().getBigDecimal(15));
                modelProdutos.setNcm(this.getResultSet().getString(16));
                modelProdutos.setTipoNcm(this.getResultSet().getString(17));
                modelProdutos.setSubTribut(this.getResultSet().getBigDecimal(18));
                modelProdutos.setIcmsCst(this.getResultSet().getBigDecimal(19));
                modelProdutos.setIcms(this.getResultSet().getBigDecimal(20));
                modelProdutos.setIcmsRed(this.getResultSet().getBigDecimal(21));
                modelProdutos.setIpiCst(this.getResultSet().getString(22));
                modelProdutos.setIpi(this.getResultSet().getBigDecimal(23));
                modelProdutos.setPisCst(this.getResultSet().getString(24));
                modelProdutos.setPis(this.getResultSet().getBigDecimal(25));
                modelProdutos.setCofinsCst(this.getResultSet().getString(26));
                modelProdutos.setCofins(this.getResultSet().getBigDecimal(27));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }

    /**
     * recupera Produtos
     *
     * @param pNome return Produto
     */
    public Produto getProdutosDAO(String pNome) {
        Produto modelProdutos = new Produto();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "fornecedores_codigo,"
                    + "nome,"
                    + "descricao_produto,"
                    + "valor,"
                    + "valor_custo,"
                    + "codigo_barras_ean,"
                    + "estoque,"
                    + "imagem_produto,"
                    + "ativo,"
                    + "marca,"
                    + "dias_garantia,"
                    + "unidade_medida,"
                    + "origem,"
                    + "peso,"
                    + "ncm,"
                    + "tipo_ncm,"
                    + "trib_st_perc,"
                    + "icms_cst,"
                    + "icms,"
                    + "icms_red,"
                    + "ipi_cst,"
                    + "ipi,"
                    + "pis_cst,"
                    + "pis,"
                    + "cofins_cst,"
                    + "cofins"
                    + " FROM"
                    + " produtos"
                    + " WHERE"
                    + " nome = '" + pNome + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProdutos.setCodigo(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setDescricaoProduto(this.getResultSet().getString(4));
                modelProdutos.setValor(this.getResultSet().getDouble(5));
                modelProdutos.setValorCusto(this.getResultSet().getDouble(6));
                modelProdutos.setCodigoBarrasEan(this.getResultSet().getString(7));
                modelProdutos.setEstoque(this.getResultSet().getFloat(8));
                modelProdutos.setImagemProduto(this.getResultSet().getString(9));
                modelProdutos.setAtivo(this.getResultSet().getInt(10));
                modelProdutos.setMarca(this.getResultSet().getString(11));
                modelProdutos.setDiasGarantia(this.getResultSet().getInt(12));
                modelProdutos.setUnidadeMedida(this.getResultSet().getInt(13));
                modelProdutos.setOrigem(this.getResultSet().getInt(14));
                modelProdutos.setPeso(this.getResultSet().getBigDecimal(15));
                modelProdutos.setNcm(this.getResultSet().getString(16));
                modelProdutos.setTipoNcm(this.getResultSet().getString(17));
                modelProdutos.setSubTribut(this.getResultSet().getBigDecimal(18));
                modelProdutos.setIcmsCst(this.getResultSet().getBigDecimal(19));
                modelProdutos.setIcms(this.getResultSet().getBigDecimal(20));
                modelProdutos.setIcmsRed(this.getResultSet().getBigDecimal(21));
                modelProdutos.setIpiCst(this.getResultSet().getString(22));
                modelProdutos.setIpi(this.getResultSet().getBigDecimal(23));
                modelProdutos.setPisCst(this.getResultSet().getString(24));
                modelProdutos.setPis(this.getResultSet().getBigDecimal(25));
                modelProdutos.setCofinsCst(this.getResultSet().getString(26));
                modelProdutos.setCofins(this.getResultSet().getBigDecimal(27));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }

    /**
     * recupera uma lista de Produtos return ArrayList
     */
    public ArrayList<Produto> getListaProdutosDAO() {
        ArrayList<Produto> listamodelProdutos = new ArrayList();
        Produto modelProdutos = new Produto();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "fornecedores_codigo,"
                    + "nome,"
                    + "descricao_produto,"
                    + "valor,"
                    + "valor_custo,"
                    + "codigo_barras_ean,"
                    + "estoque,"
                    + "imagem_produto,"
                    + "ativo,"
                    + "marca,"
                    + "dias_garantia,"
                    + "unidade_medida,"
                    + "origem,"
                    + "peso,"
                    + "ncm,"
                    + "tipo_ncm,"
                    + "trib_st_perc,"
                    + "icms_cst,"
                    + "icms,"
                    + "icms_red,"
                    + "ipi_cst,"
                    + "ipi,"
                    + "pis_cst,"
                    + "pis,"
                    + "cofins_cst,"
                    + "cofins"
                    + " FROM"
                    + " produtos"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProdutos = new Produto();
                modelProdutos.setCodigo(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setDescricaoProduto(this.getResultSet().getString(4));
                modelProdutos.setValor(this.getResultSet().getDouble(5));
                modelProdutos.setValorCusto(this.getResultSet().getDouble(6));
                modelProdutos.setCodigoBarrasEan(this.getResultSet().getString(7));
                modelProdutos.setEstoque(this.getResultSet().getFloat(8));
                modelProdutos.setImagemProduto(this.getResultSet().getString(9));
                modelProdutos.setAtivo(this.getResultSet().getInt(10));
                modelProdutos.setMarca(this.getResultSet().getString(11));
                modelProdutos.setDiasGarantia(this.getResultSet().getInt(12));
                modelProdutos.setUnidadeMedida(this.getResultSet().getInt(13));
                modelProdutos.setOrigem(this.getResultSet().getInt(14));
                modelProdutos.setPeso(this.getResultSet().getBigDecimal(15));
                modelProdutos.setNcm(this.getResultSet().getString(16));
                modelProdutos.setTipoNcm(this.getResultSet().getString(17));
                modelProdutos.setSubTribut(this.getResultSet().getBigDecimal(18));
                modelProdutos.setIcmsCst(this.getResultSet().getBigDecimal(19));
                modelProdutos.setIcms(this.getResultSet().getBigDecimal(20));
                modelProdutos.setIcmsRed(this.getResultSet().getBigDecimal(21));
                modelProdutos.setIpiCst(this.getResultSet().getString(22));
                modelProdutos.setIpi(this.getResultSet().getBigDecimal(23));
                modelProdutos.setPisCst(this.getResultSet().getString(24));
                modelProdutos.setPis(this.getResultSet().getBigDecimal(25));
                modelProdutos.setCofinsCst(this.getResultSet().getString(26));
                modelProdutos.setCofins(this.getResultSet().getBigDecimal(27));
                listamodelProdutos.add(modelProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelProdutos;
    }

    /**
     * recupera uma lista de Produtos return ArrayList
     */
    public ArrayList<Produto> getListaProdutosAtivosDAO() {
        ArrayList<Produto> listamodelProdutos = new ArrayList();
        Produto modelProdutos = new Produto();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "fornecedores_codigo,"
                    + "nome,"
                    + "descricao_produto,"
                    + "valor,"
                    + "valor_custo,"
                    + "codigo_barras_ean,"
                    + "estoque,"
                    + "imagem_produto,"
                    + "ativo,"
                    + "marca,"
                    + "dias_garantia,"
                    + "unidade_medida,"
                    + "origem,"
                    + "peso,"
                    + "ncm,"
                    + "tipo_ncm,"
                    + "trib_st_perc,"
                    + "icms_cst,"
                    + "icms,"
                    + "icms_red,"
                    + "ipi_cst,"
                    + "ipi,"
                    + "pis_cst,"
                    + "pis,"
                    + "cofins_cst,"
                    + "cofins"
                    + " FROM"
                    + " produtos "
                    + "WHERE ativo = 1;"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProdutos = new Produto();
                modelProdutos.setCodigo(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setDescricaoProduto(this.getResultSet().getString(4));
                modelProdutos.setValor(this.getResultSet().getDouble(5));
                modelProdutos.setValorCusto(this.getResultSet().getDouble(6));
                modelProdutos.setCodigoBarrasEan(this.getResultSet().getString(7));
                modelProdutos.setEstoque(this.getResultSet().getFloat(8));
                modelProdutos.setImagemProduto(this.getResultSet().getString(9));
                modelProdutos.setAtivo(this.getResultSet().getInt(10));
                modelProdutos.setMarca(this.getResultSet().getString(11));
                modelProdutos.setDiasGarantia(this.getResultSet().getInt(12));
                modelProdutos.setUnidadeMedida(this.getResultSet().getInt(13));
                modelProdutos.setOrigem(this.getResultSet().getInt(14));
                modelProdutos.setPeso(this.getResultSet().getBigDecimal(15));
                modelProdutos.setNcm(this.getResultSet().getString(16));
                modelProdutos.setTipoNcm(this.getResultSet().getString(17));
                modelProdutos.setSubTribut(this.getResultSet().getBigDecimal(18));
                modelProdutos.setIcmsCst(this.getResultSet().getBigDecimal(19));
                modelProdutos.setIcms(this.getResultSet().getBigDecimal(20));
                modelProdutos.setIcmsRed(this.getResultSet().getBigDecimal(21));
                modelProdutos.setIpiCst(this.getResultSet().getString(22));
                modelProdutos.setIpi(this.getResultSet().getBigDecimal(23));
                modelProdutos.setPisCst(this.getResultSet().getString(24));
                modelProdutos.setPis(this.getResultSet().getBigDecimal(25));
                modelProdutos.setCofinsCst(this.getResultSet().getString(26));
                modelProdutos.setCofins(this.getResultSet().getBigDecimal(27));
                listamodelProdutos.add(modelProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelProdutos;
    }

    /**
     * atualiza Produtos
     *
     * @param pProduto return boolean
     */
    public boolean atualizarProdutosDAO(Produto pProduto) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE produtos SET "
                    + "fornecedores_codigo = '" + pProduto.getFornecedoresCodigo() + "',"
                    + "nome = '" + pProduto.getNome() + "',"
                    + "descricao_produto = '" + pProduto.getDescricaoProduto()+ "',"
                    + "codigo_barras_ean = '" + pProduto.getCodigoBarrasEan() + "',"
                    + "unidade_medida = '" + pProduto.getUnidadeMedida() + "',"
                    + "ativo = '" + pProduto.getAtivo() + "',"
                    + "dias_garantia = '" + pProduto.getDiasGarantia() + "',"
                    + "origem = '" + pProduto.getOrigem() + "',"
                    + "peso = '" + pProduto.getPeso() + "',"
                    + "imagem_produto = '" + pProduto.getImagemProduto() + "'"
                    + " WHERE "
                    + "codigo = '" + pProduto.getCodigo() + "'"
                    + ";"
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui Produtos
     *
     * @param pCodigo return boolean
     */
    public boolean excluirProdutosDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM produtos "
                    + " WHERE "
                    + "codigo = '" + pCodigo + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Tentativa de violar uma chave");
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * atualiza Produtos
     *
     * @param pProduto return boolean
     */
    public boolean atualizarProdutosQuantidadeDAO(Produto pProduto) {
        try {
            this.conectar();
            int sizeLista = pProduto.getListaProdutoes().size();
            for (int i = 0; i < sizeLista; i++) {
                this.executarUpdateDeleteSQL(
                        "UPDATE produtos SET "
                        + "estoque = '" + pProduto.getListaProdutoes().get(i).getEstoque() + "'"
                        + " WHERE "
                        + "codigo = '" + pProduto.getListaProdutoes().get(i).getCodigo() + "'"
                        + ";"
                );
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * atualiza Produtos
     *
     * @param pProduto return boolean
     */
    public boolean atualizarProdutosQuantidadeValorDAO(ArrayList<CompraProduto> pListaComprasProdutos) {
        try {
            this.conectar();
            int sizeLista = pListaComprasProdutos.size();
            for (int i = 0; i < sizeLista; i++) {
                this.executarUpdateDeleteSQL(
                        "UPDATE produtos SET "
                        + "estoque = '" + pListaComprasProdutos.get(i).getProduto().getAddEstoque() + "',"
                        + "valor_custo = '" + pListaComprasProdutos.get(i).getProduto().getValorCusto() + "',"
                        + "valor = '" + pListaComprasProdutos.get(i).getProduto().getValor() + "',"
                        + "ncm = '" + pListaComprasProdutos.get(i).getProduto().getNcm() + "',"
                        + "tipo_ncm = '" + pListaComprasProdutos.get(i).getProduto().getTipoNcm() + "',"
                        + "trib_st_perc = '" + pListaComprasProdutos.get(i).getProduto().getSubTribut() + "',"
                        + "icms_cst = '" + pListaComprasProdutos.get(i).getProduto().getIcmsCst() + "',"
                        + "icms = '" + pListaComprasProdutos.get(i).getProduto().getIcms() + "',"
                        + "icms_red = '" + pListaComprasProdutos.get(i).getProduto().getIcmsRed() + "',"
                        + "ipi_cst = '" + pListaComprasProdutos.get(i).getProduto().getIpiCst() + "',"
                        + "ipi = '" + pListaComprasProdutos.get(i).getProduto().getIpi() + "',"
                        + "pis_cst = '" + pListaComprasProdutos.get(i).getProduto().getPisCst() + "',"
                        + "pis = '" + pListaComprasProdutos.get(i).getProduto().getPis() + "',"
                        + "cofins_cst = '" + pListaComprasProdutos.get(i).getProduto().getCofinsCst() + "',"
                        + "cofins = '" + pListaComprasProdutos.get(i).getProduto().getCofins() + "'"
                        + " WHERE "
                        + "codigo = '" + pListaComprasProdutos.get(i).getProduto().getCodigo() + "'"
                        + ";"
                );
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * atualiza Produtos
     *
     * @param pProduto return boolean
     */
    public boolean atualizarPrecoEstoqueProdutosDAO(Produto pProduto) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE produtos SET "
                    + "estoque = '" + pProduto.getEstoque() + "',"
                    + "valor_custo = '" + pProduto.getValorCusto() + "',"
                    + "valor = '" + pProduto.getValor() + "',"
                    + "ncm = '" + pProduto.getNcm() + "',"
                    + "tipo_ncm = '" + pProduto.getTipoNcm() + "',"
                    + "trib_st_perc = '" + pProduto.getSubTribut() + "',"
                    + "icms_cst = '" + pProduto.getIcmsCst() + "',"
                    + "icms = '" + pProduto.getIcms() + "',"
                    + "icms_red = '" + pProduto.getIcmsRed() + "',"
                    + "ipi_cst = '" + pProduto.getIpiCst() + "',"
                    + "ipi = '" + pProduto.getIpi() + "',"
                    + "pis_cst = '" + pProduto.getPisCst() + "',"
                    + "pis = '" + pProduto.getPis() + "',"
                    + "cofins_cst = '" + pProduto.getCofinsCst() + "',"
                    + "cofins = '" + pProduto.getCofins() + "'"
                    + " WHERE "
                    + "codigo = '" + pProduto.getCodigo() + "'"
                    + ";"
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * atualiza Produtos
     *
     * @param pProduto return boolean
     */
    public boolean atualizarProdutosEstoqueDAO(Produto pProduto) {
        try {
            this.conectar();
            int sizeLista = pProduto.getListaProdutoes().size();
            for (int i = 0; i < sizeLista; i++) {
                this.executarUpdateDeleteSQL(
                        "UPDATE produtos SET "
                        + "estoque = '" + pProduto.getListaProdutoes().get(i).getEstoque() + "'"
                        + " WHERE "
                        + "codigo = '" + pProduto.getListaProdutoes().get(i).getCodigo() + "'"
                        + ";"
                );
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * atualiza Produtos
     *
     * @param pProduto return boolean
     */
    public boolean atualizarProdutosQuantidadeUmDAO(int pCodigo, float pQuantidade) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE produtos SET "
                    + "estoque = '" + pQuantidade + "'"
                    + " WHERE "
                    + "codigo = '" + pCodigo + "'"
                    + ";"
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public Produto getProdutosCodigoBarrasDAO(String pCodigoBarras) {
        Produto modelProdutos = new Produto();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "fornecedores_codigo,"
                    + "nome,"
                    + "descricao_produto,"
                    + "valor,"
                    + "valor_custo,"
                    + "codigo_barras_ean,"
                    + "estoque,"
                    + "imagem_produto,"
                    + "ativo,"
                    + "marca,"
                    + "dias_garantia,"
                    + "unidade_medida,"
                    + "origem,"
                    + "peso,"
                    + "ncm,"
                    + "tipo_ncm,"
                    + "trib_st_perc,"
                    + "icms_cst,"
                    + "icms,"
                    + "icms_red,"
                    + "ipi_cst,"
                    + "ipi,"
                    + "pis_cst,"
                    + "pis,"
                    + "cofins_cst,"
                    + "cofins"
                    + " FROM"
                    + " produtos"
                    + " WHERE"
                    + " codigo_barras_ean = '" + pCodigoBarras + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProdutos.setCodigo(this.getResultSet().getInt(1));
                modelProdutos.setFornecedoresCodigo(this.getResultSet().getInt(2));
                modelProdutos.setNome(this.getResultSet().getString(3));
                modelProdutos.setDescricaoProduto(this.getResultSet().getString(4));
                modelProdutos.setValor(this.getResultSet().getDouble(5));
                modelProdutos.setValorCusto(this.getResultSet().getDouble(6));
                modelProdutos.setCodigoBarrasEan(this.getResultSet().getString(7));
                modelProdutos.setEstoque(this.getResultSet().getFloat(8));
                modelProdutos.setImagemProduto(this.getResultSet().getString(9));
                modelProdutos.setAtivo(this.getResultSet().getInt(10));
                modelProdutos.setMarca(this.getResultSet().getString(11));
                modelProdutos.setDiasGarantia(this.getResultSet().getInt(12));
                modelProdutos.setUnidadeMedida(this.getResultSet().getInt(13));
                modelProdutos.setOrigem(this.getResultSet().getInt(14));
                modelProdutos.setPeso(this.getResultSet().getBigDecimal(15));
                modelProdutos.setNcm(this.getResultSet().getString(16));
                modelProdutos.setTipoNcm(this.getResultSet().getString(17));
                modelProdutos.setSubTribut(this.getResultSet().getBigDecimal(18));
                modelProdutos.setIcmsCst(this.getResultSet().getBigDecimal(19));
                modelProdutos.setIcms(this.getResultSet().getBigDecimal(20));
                modelProdutos.setIcmsRed(this.getResultSet().getBigDecimal(21));
                modelProdutos.setIpiCst(this.getResultSet().getString(22));
                modelProdutos.setIpi(this.getResultSet().getBigDecimal(23));
                modelProdutos.setPisCst(this.getResultSet().getString(24));
                modelProdutos.setPis(this.getResultSet().getBigDecimal(25));
                modelProdutos.setCofinsCst(this.getResultSet().getString(26));
                modelProdutos.setCofins(this.getResultSet().getBigDecimal(27));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }
}

