/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.CompraProduto;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class CompraProdutoDao extends ConexaoMySql {
    
    /**
     * grava compras_produtos
     *
     * @param pModelcompras_produtos return int
     */
    public int salvarcompras_produtosDAO(CompraProduto pModelcompras_produtos) {
        try {
            this.conectar();
            int sizeLista = pModelcompras_produtos.getListaCompraProduto().size();
            for (int i = 0; i < sizeLista; i++) {
                this.insertSQL(
                        "INSERT INTO compras_produtos ("
                        + "cod_compras,"
                        + "cod_produto,"
                        + "valor_custo,"
                        + "valor_venda,"
                        + "quantidade"
                        + ") VALUES ("
                        + "'" + pModelcompras_produtos.getCodCompras() + "',"
                        + "'" + pModelcompras_produtos.getListaCompraProduto().get(i).getProduto().getCodigo()+ "',"
                        + "'" + pModelcompras_produtos.getListaCompraProduto().get(i).getProduto().getValorCusto()+ "',"
                        + "'" + pModelcompras_produtos.getListaCompraProduto().get(i).getProduto().getValor()+ "',"
                        + "'" + pModelcompras_produtos.getListaCompraProduto().get(i).getProduto().getEstoque()+ "'"
                        + ");"
                );
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }
    
 /**
     * recupera compras_produtos
     *
     * @param pCodigo return Modelcompras_produtos
     */
    public CompraProduto getcompras_produtosDAO(int pCodigo) {
        CompraProduto modelcompras_produtos = new CompraProduto();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "cod_compras,"
                    + "cod_produto,"
                    + "valor_custo,"
                    + "valor_venda,"
                    + "quantidade"
                    + " FROM"
                    + " compras_produtos"
                    + " WHERE"
                    + " codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelcompras_produtos.setCodigo(this.getResultSet().getInt(1));
                modelcompras_produtos.setCodCompras(this.getResultSet().getInt(2));
                modelcompras_produtos.setCodProduto(this.getResultSet().getInt(3));
                modelcompras_produtos.setValorCusto(this.getResultSet().getDouble(4));
                modelcompras_produtos.setValorVenda(this.getResultSet().getDouble(5));
                modelcompras_produtos.setQuantidade(this.getResultSet().getInt(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelcompras_produtos;
    }

    /**
     * recupera uma lista de compras_produtos return ArrayList
     */
    public ArrayList<CompraProduto> getListacompras_produtosDAO() {
        ArrayList<CompraProduto> listamodelcompras_produtos = new ArrayList();
        //CompraProduto modelcompras_produtos = new CompraProduto();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "cod_compras,"
                    + "cod_produto,"
                    + "valor_custo,"
                    + "valor_venda,"
                    + "quantidade"
                    + " FROM"
                    + " compras_produtos"
                    + ";"
            );

            while (this.getResultSet().next()) {
                
               CompraProduto modelcompras_produtos = new CompraProduto();
                
                modelcompras_produtos.setCodigo(this.getResultSet().getInt(1));
                modelcompras_produtos.setCodCompras(this.getResultSet().getInt(2));
                modelcompras_produtos.setCodProduto(this.getResultSet().getInt(3));
                modelcompras_produtos.setValorCusto(this.getResultSet().getDouble(4));
                modelcompras_produtos.setValorVenda(this.getResultSet().getDouble(5));
                modelcompras_produtos.setQuantidade(this.getResultSet().getInt(6));
                listamodelcompras_produtos.add(modelcompras_produtos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelcompras_produtos;
    }

    /**
     * recupera uma lista de compras_produtos return ArrayList
     */
    public ArrayList<CompraProduto> getListacompras_produtosDAO(int pCodigo) {
        ArrayList<CompraProduto> listamodelcompras_produtos = new ArrayList();
        
        //CompraProduto modelcompras_produtos = new CompraProduto();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "cod_compras,"
                    + "cod_produto,"
                    + "valor_custo,"
                    + "valor_venda,"
                    + "quantidade"
                    + " FROM"
                    + " compras_produtos where cod_compras = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
              CompraProduto  modelcompras_produtos = new CompraProduto();
              
                modelcompras_produtos.setCodigo(this.getResultSet().getInt(1));
                modelcompras_produtos.setCodCompras(this.getResultSet().getInt(2));
                modelcompras_produtos.setCodProduto(this.getResultSet().getInt(3));
                modelcompras_produtos.setValorCusto(this.getResultSet().getDouble(4));
                modelcompras_produtos.setValorVenda(this.getResultSet().getDouble(5));
                modelcompras_produtos.setQuantidade(this.getResultSet().getInt(6));
                listamodelcompras_produtos.add(modelcompras_produtos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelcompras_produtos;
    }

    /**
     * atualiza compras_produtos
     *
     * @param pModelcompras_produtos return boolean
     */
    public boolean atualizarcompras_produtosDAO(CompraProduto pModelcompras_produtos) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE compras_produtos SET "
                    + "codigo = '" + pModelcompras_produtos.getCodigo() + "',"
                    + "cod_compras = '" + pModelcompras_produtos.getCodCompras() + "',"
                    + "cod_produto = '" + pModelcompras_produtos.getCodProduto() + "',"
                    + "valor_custo = '" + pModelcompras_produtos.getValorCusto() + "',"
                    + "valor_venda = '" + pModelcompras_produtos.getValorVenda() + "',"
                    + "quantidade = '" + pModelcompras_produtos.getQuantidade() + "'"
                    + " WHERE "
                    + "codigo = '" + pModelcompras_produtos.getCodigo() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui compras_produtos
     *
     * @param pCodigo return boolean
     */
    public boolean excluircompras_produtosDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM compras_produtos "
                    + " WHERE "
                    + "cod_compras = '" + pCodigo + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}

