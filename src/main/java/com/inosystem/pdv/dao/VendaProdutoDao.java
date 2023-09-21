/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.VendaProduto;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class VendaProdutoDao extends ConexaoMySql {
    
/**
    * grava VendasProdutos
    * @param pVendaProduto
    * return int
    */
    public int salvarVendasProdutosDAO(VendaProduto pVendaProduto){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO vendas_produto ("
                    + "codigo,"
                    + "codigo_produto,"
                    + "codigo_venda,"
                    + "quantidade, "
                    + "valor_unitario "
                + ") VALUES ("
                    + "'" + pVendaProduto.getCodigo() + "',"
                    + "'" + pVendaProduto.getCodigo_produto() + "',"
                    + "'" + pVendaProduto.getCodigo_venda() + "',"
                    + "'" + pVendaProduto.getQuantidade() + "',"
                    + "'" + pVendaProduto.getValorUnitario()+ "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera VendasProdutos
    * @param pCodigo
    * return VendaProduto
    */
    public VendaProduto getVendasProdutosDAO(int pCodigo){
        VendaProduto modelVendasProdutos = new VendaProduto();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "codigo_produto,"
                    + "codigo_venda,"
                    + "quantidade, "
                    + "valor_unitario "
                 + " FROM"
                     + " vendas_produto"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendasProdutos.setCodigo(this.getResultSet().getInt(1));
                modelVendasProdutos.setCodigo_produto(this.getResultSet().getInt(2));
                modelVendasProdutos.setCodigo_venda(this.getResultSet().getInt(3));
                modelVendasProdutos.setQuantidade(this.getResultSet().getFloat(4));
                modelVendasProdutos.setValorUnitario(this.getResultSet().getBigDecimal(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelVendasProdutos;
    }

    /**
    * recupera uma lista de VendasProdutos
        * return ArrayList
    */
    public ArrayList<VendaProduto> getListaVendasProdutosDAO(){
        ArrayList<VendaProduto> listamodelVendasProdutos = new ArrayList();
        VendaProduto modelVendasProdutos = new VendaProduto();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "codigo_produto,"
                    + "codigo_venda,"
                    + "quantidade, "
                    + "valor_unitario "
                 + " FROM"
                     + " vendas_produto"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendasProdutos = new VendaProduto();
                modelVendasProdutos.setCodigo(this.getResultSet().getInt(1));
                modelVendasProdutos.setCodigo_produto(this.getResultSet().getInt(2));
                modelVendasProdutos.setCodigo_venda(this.getResultSet().getInt(3));
                modelVendasProdutos.setQuantidade(this.getResultSet().getFloat(4));
                modelVendasProdutos.setValorUnitario(this.getResultSet().getBigDecimal(5));
                listamodelVendasProdutos.add(modelVendasProdutos);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelVendasProdutos;
    }

    /**
    * atualiza VendasProdutos
    * @param pVendaProduto
    * return boolean
    */
    public boolean atualizarVendasProdutosDAO(VendaProduto pVendaProduto){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE vendas_produto SET "
                    + "codigo = '" + pVendaProduto.getCodigo() + "',"
                    + "codigo_produto = '" + pVendaProduto.getCodigo_produto() + "',"
                    + "codigo_venda = '" + pVendaProduto.getCodigo_venda() + "',"
                    + "quantidade = '" + pVendaProduto.getQuantidade() + "',"
                    + "valor_unitario = '" + pVendaProduto.getValorUnitario()+ "'"
                + " WHERE "
                    + "codigo = '" + pVendaProduto.getCodigo() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui VendasProdutos
    * @param pCodigo
    * return boolean
    */
    public boolean excluirVendasProdutosDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM vendas_produto "
                + " WHERE "
                    + "codigo = '" + pCodigo + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    public ArrayList<VendaProduto> getListaVendasProdutosDAO(int pCodigoVenda) {
        ArrayList<VendaProduto> listamodelVendasProdutos = new ArrayList();
        VendaProduto modelVendasProdutos = new VendaProduto();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "codigo_produto,"
                    + "codigo_venda,"
                    + "quantidade, "
                    + "valor_unitario "
                 + " FROM"
                     + " vendas_produto WHERE codigo_venda = '"+pCodigoVenda+"'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendasProdutos = new VendaProduto();
                modelVendasProdutos.setCodigo(this.getResultSet().getInt(1));
                modelVendasProdutos.setCodigo_produto(this.getResultSet().getInt(2));
                modelVendasProdutos.setCodigo_venda(this.getResultSet().getInt(3));
                modelVendasProdutos.setQuantidade(this.getResultSet().getFloat(4));
                modelVendasProdutos.setValorUnitario(this.getResultSet().getBigDecimal(5));
                listamodelVendasProdutos.add(modelVendasProdutos);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelVendasProdutos;
    }
}
