/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.TotalMesa;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class TotalMesasDao extends ConexaoMySql {
    
/**
    * grava TotalMesas
    * @param pTotalMesa
    * return int
    */
    public int salvarTotalMesasDAO(TotalMesa pTotalMesa){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO total_mesas ("
                    + "pk_codigo,"
                    + "quantidade"
                + ") VALUES ("
                    + "'" + pTotalMesa.getCodigo() + "',"
                    + "'" + pTotalMesa.getQuantidade() + "'"
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
    * recupera TotalMesas
    * @param pCodigo
    * return TotalMesa
    */
    public TotalMesa getTotalMesasDAO(int pCodigo){
        TotalMesa modelTotalMesas = new TotalMesa();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_codigo,"
                    + "quantidade"
                 + " FROM"
                     + " total_mesas"
                 + " WHERE"
                     + " pk_codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelTotalMesas.setCodigo(this.getResultSet().getInt(1));
                modelTotalMesas.setQuantidade(this.getResultSet().getInt(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelTotalMesas;
    }

    /**
    * recupera uma lista de TotalMesas
        * return ArrayList
    */
    public ArrayList<TotalMesa> getListaTotalMesasDAO(){
        ArrayList<TotalMesa> listamodelTotalMesas = new ArrayList();
        TotalMesa modelTotalMesas = new TotalMesa();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_codigo,"
                    + "quantidade"
                 + " FROM"
                     + " total_mesas"
                + ";"
            );

            while(this.getResultSet().next()){
                modelTotalMesas = new TotalMesa();
                modelTotalMesas.setCodigo(this.getResultSet().getInt(1));
                modelTotalMesas.setQuantidade(this.getResultSet().getInt(2));
                listamodelTotalMesas.add(modelTotalMesas);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelTotalMesas;
    }

    /**
    * atualiza TotalMesas
    * @param pTotalMesa
    * return boolean
    */
    public boolean atualizarTotalMesasDAO(TotalMesa pTotalMesa){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE total_mesas SET "
                    + "pk_codigo = '" + pTotalMesa.getCodigo() + "',"
                    + "quantidade = '" + pTotalMesa.getQuantidade() + "'"
                + " WHERE "
                    + "pk_codigo = '" + pTotalMesa.getCodigo() + "'"
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
    * exclui TotalMesas
    * @param pCodigo
    * return boolean
    */
    public boolean excluirTotalMesasDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM total_mesas "
                + " WHERE "
                    + "pk_codigo = '" + pCodigo + "'"
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
