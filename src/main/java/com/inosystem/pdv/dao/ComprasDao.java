/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.Compras;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class ComprasDao extends ConexaoMySql {
    
 /**
    * grava Comprass
    * @param pCompras
    * return int
    */
    public int salvarComprassDAO(Compras pCompras){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO compras ("
                    + "valor_total,"
                        + "data "
                + ") VALUES ("
                    + "'" + pCompras.getValorTotal() + "',"
                    + "'" + pCompras.getData()+ "'"
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
    * recupera Comprass
    * @param pCodigo
    * return Compras
    */
    public Compras getComprassDAO(int pCodigo){
        Compras modelCompras = new Compras();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "valor_total"
                 + " FROM"
                     + " compras"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCompras.setCodigo(this.getResultSet().getInt(1));
                modelCompras.setValorTotal(this.getResultSet().getDouble(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCompras;
    }

    /**
    * recupera uma lista de Comprass
        * return ArrayList
    */
    public ArrayList<Compras> getListaComprassDAO(){
        ArrayList<Compras> listamodelCompras = new ArrayList();
        Compras modelCompras = new Compras();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "valor_total,"
                    + "data"
                 + " FROM"
                     + " compras"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCompras = new Compras();
                modelCompras.setCodigo(this.getResultSet().getInt(1));
                modelCompras.setValorTotal(this.getResultSet().getDouble(2));
                modelCompras.setData(this.getResultSet().getDate(3));
                listamodelCompras.add(modelCompras);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelCompras;
    }

    /**
    * atualiza Comprass
    * @param pCompras
    * return boolean
    */
    public boolean atualizarComprassDAO(Compras pCompras){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE compras SET "
                    + "codigo = '" + pCompras.getCodigo() + "',"
                    + "valor_total = '" + pCompras.getValorTotal() + "'"
                + " WHERE "
                    + "codigo = '" + pCompras.getCodigo() + "'"
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
    * exclui Comprass
    * @param pCodigo
    * return boolean
    */
    public boolean excluirComprassDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM compras "
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
