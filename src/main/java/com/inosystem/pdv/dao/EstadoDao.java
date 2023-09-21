/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.Estado;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class EstadoDao extends ConexaoMySql {
    
/**
    * grava Estado
    * @param pEstado
    * return int
    */
    public int salvarEstadoDAO(Estado pEstado){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO estado ("
                    + "codigo,"
                    + "uf,"
                    + "nome"
                + ") VALUES ("
                    + "'" + pEstado.getCodigo() + "',"
                    + "'" + pEstado.getUf() + "',"
                    + "'" + pEstado.getNome() + "'"
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
    * recupera Estado
    * @param pCodigo
    * return Estado
    */
    public Estado getEstadoDAO(int pCodigo){
        Estado modelEstado = new Estado();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "uf,"
                    + "nome"
                 + " FROM"
                     + " estado"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelEstado.setCodigo(this.getResultSet().getInt(1));
                modelEstado.setUf(this.getResultSet().getString(2));
                modelEstado.setNome(this.getResultSet().getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelEstado;
    }
    /**
    * recupera Estado
    * @param pNome
    * return Estado
    */
    public Estado getEstadoDAO(String pNome){
        Estado modelEstado = new Estado();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "uf,"
                    + "nome"
                 + " FROM"
                     + " estado"
                 + " WHERE"
                     + " nome = '" + pNome + "';"
            );
            while(this.getResultSet().next()){
                modelEstado.setCodigo(this.getResultSet().getInt(1));
                modelEstado.setUf(this.getResultSet().getString(2));
                modelEstado.setNome(this.getResultSet().getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelEstado;
    }
    /**
    * recupera Estado
    * @param pNome
    * return Estado
    */
    public Estado getEstadoUFDAO(String pNome){
        Estado modelEstado = new Estado();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "uf,"
                    + "nome"
                 + " FROM"
                     + " estado"
                 + " WHERE"
                     + " uf = '" + pNome + "';"
            );
            while(this.getResultSet().next()){
                modelEstado.setCodigo(this.getResultSet().getInt(1));
                modelEstado.setUf(this.getResultSet().getString(2));
                modelEstado.setNome(this.getResultSet().getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelEstado;
    }

    /**
    * recupera uma lista de Estado
        * return ArrayList
    */
    public ArrayList<Estado> getListaEstadoDAO(){
        ArrayList<Estado> listamodelEstado = new ArrayList();
        Estado modelEstado = new Estado();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "uf,"
                    + "nome"
                 + " FROM"
                     + " estado ORDER BY uf"
                + ";"
            );

            while(this.getResultSet().next()){
                modelEstado = new Estado();
                modelEstado.setCodigo(this.getResultSet().getInt(1));
                modelEstado.setUf(this.getResultSet().getString(2));
                modelEstado.setNome(this.getResultSet().getString(3));
                listamodelEstado.add(modelEstado);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelEstado;
    }

    /**
    * atualiza Estado
    * @param pEstado
    * return boolean
    */
    public boolean atualizarEstadoDAO(Estado pEstado){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE estado SET "
                    + "codigo = '" + pEstado.getCodigo() + "',"
                    + "uf = '" + pEstado.getUf() + "',"
                    + "nome = '" + pEstado.getNome() + "'"
                + " WHERE "
                    + "codigo = '" + pEstado.getCodigo() + "'"
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
    * exclui Estado
    * @param pCodigo
    * return boolean
    */
    public boolean excluirEstadoDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM estado "
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
