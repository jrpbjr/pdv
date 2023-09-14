/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.Cfop;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class CfopDao extends ConexaoMySql {
    
/**
    * grava CFOP
    * @param pCfop
    * return int
    */
    public int salvarCFOPDAO(Cfop pCfop){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO cfop ("
                    + "cfop,"
                    + "descricao,"
                    + "observacao,"
                    + "faturamento,"
                    + "financeiro,"
                    + "seque_cfop,"
                    + "operacao"
                + ") VALUES ("
                    + "'" + pCfop.getCfop() + "',"
                    + "'" + pCfop.getDescricao() + "',"
                    + "'" + pCfop.getObservacao() + "',"
                    + "'" + pCfop.getFaturamento() + "',"
                    + "'" + pCfop.getFinanceiro() + "',"
                    + "'" + pCfop.getSequeCfop() + "',"
                    + "'" + pCfop.getOperacao() + "'"
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
    * recupera CFOP
    * @param pCodigo
    * return Cfop
    */
    public Cfop getCFOPDAO(int pCodigo){
        Cfop modelCFOP = new Cfop();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "cfop,"
                    + "descricao,"
                    + "observacao,"
                    + "faturamento,"
                    + "financeiro,"
                    + "seque_cfop,"
                    + "operacao"
                 + " FROM"
                     + " cfop"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCFOP.setCodigo(this.getResultSet().getInt(1));
                modelCFOP.setCfop(this.getResultSet().getInt(2));
                modelCFOP.setDescricao(this.getResultSet().getString(3));
                modelCFOP.setObservacao(this.getResultSet().getString(4));
                modelCFOP.setFaturamento(this.getResultSet().getInt(5));
                modelCFOP.setFinanceiro(this.getResultSet().getInt(6));
                modelCFOP.setSequeCfop(this.getResultSet().getInt(7));
                modelCFOP.setOperacao(this.getResultSet().getString(8));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCFOP;
    }

    /**
    * recupera uma lista de CFOP
        * return ArrayList
    */
    public ArrayList<Cfop> getListaCFOPDAO(){
        ArrayList<Cfop> listamodelCFOP = new ArrayList();
        Cfop modelCFOP = new Cfop();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "cfop,"
                    + "descricao,"
                    + "observacao,"
                    + "faturamento,"
                    + "financeiro,"
                    + "seque_cfop,"
                    + "operacao"
                 + " FROM"
                     + " cfop"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCFOP = new Cfop();
                modelCFOP.setCodigo(this.getResultSet().getInt(1));
                modelCFOP.setCfop(this.getResultSet().getInt(2));
                modelCFOP.setDescricao(this.getResultSet().getString(3));
                modelCFOP.setObservacao(this.getResultSet().getString(4));
                modelCFOP.setFaturamento(this.getResultSet().getInt(5));
                modelCFOP.setFinanceiro(this.getResultSet().getInt(6));
                modelCFOP.setSequeCfop(this.getResultSet().getInt(7));
                modelCFOP.setOperacao(this.getResultSet().getString(8));
                listamodelCFOP.add(modelCFOP);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelCFOP;
    }

    /**
    * atualiza CFOP
    * @param pCfop
    * return boolean
    */
    public boolean atualizarCFOPDAO(Cfop pCfop){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE cfop SET "
                    + "codigo = '" + pCfop.getCodigo() + "',"
                    + "cfop = '" + pCfop.getCfop() + "',"
                    + "descricao = '" + pCfop.getDescricao() + "',"
                    + "observacao = '" + pCfop.getObservacao() + "',"
                    + "faturamento = '" + pCfop.getFaturamento() + "',"
                    + "financeiro = '" + pCfop.getFinanceiro() + "',"
                    + "seque_cfop = '" + pCfop.getSequeCfop() + "',"
                    + "operacao = '" + pCfop.getOperacao() + "'"
                + " WHERE "
                    + "codigo = '" + pCfop.getCodigo() + "'"
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
    * exclui CFOP
    * @param pCodigo
    * return boolean
    */
    public boolean excluirCFOPDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM cfop "
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
}
