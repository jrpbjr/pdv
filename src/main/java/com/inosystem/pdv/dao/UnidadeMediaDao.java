/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.UnidadeMedida;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class UnidadeMediaDao extends ConexaoMySql {
    
/**
    * grava UnidadeMedida
    * @param pUnidadeMedia
    * return int
    */
    public int salvarUnidadeMediaDAO(UnidadeMedida pUnidadeMedia){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO unidade_medida ("
                    + "abreviacao,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pUnidadeMedia.getAbreviacao() + "',"
                    + "'" + pUnidadeMedia.getDescricao() + "'"
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
    * recupera UnidadeMedida
    * @param pCodigo
    * return UnidadeMedida
    */
    public UnidadeMedida getUnidadeMediaDAO(int pCodigo){
        UnidadeMedida modelUnidadeMedia = new UnidadeMedida();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "abreviacao,"
                    + "descricao"
                 + " FROM"
                     + " unidade_medida"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUnidadeMedia.setCodigo(this.getResultSet().getInt(1));
                modelUnidadeMedia.setAbreviacao(this.getResultSet().getString(2));
                modelUnidadeMedia.setDescricao(this.getResultSet().getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelUnidadeMedia;
    }
    
    /**
    * recupera UnidadeMedida
    * @param pCodigo
    * return UnidadeMedida
    */
    public UnidadeMedida getUnidadeMediaDAO(String pNome){
        UnidadeMedida modelUnidadeMedia = new UnidadeMedida();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "abreviacao,"
                    + "descricao"
                 + " FROM"
                     + " unidade_medida"
                 + " WHERE"
                     + " abreviacao = '" + pNome + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUnidadeMedia.setCodigo(this.getResultSet().getInt(1));
                modelUnidadeMedia.setAbreviacao(this.getResultSet().getString(2));
                modelUnidadeMedia.setDescricao(this.getResultSet().getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelUnidadeMedia;
    }

    /**
    * recupera uma lista de UnidadeMedida
 return ArrayList
    */
    public ArrayList<UnidadeMedida> getListaUnidadeMediaDAO(){
        ArrayList<UnidadeMedida> listamodelUnidadeMedia = new ArrayList();
        UnidadeMedida modelUnidadeMedia = new UnidadeMedida();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "abreviacao,"
                    + "descricao"
                 + " FROM"
                     + " unidade_medida"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUnidadeMedia = new UnidadeMedida();
                modelUnidadeMedia.setCodigo(this.getResultSet().getInt(1));
                modelUnidadeMedia.setAbreviacao(this.getResultSet().getString(2));
                modelUnidadeMedia.setDescricao(this.getResultSet().getString(3));
                listamodelUnidadeMedia.add(modelUnidadeMedia);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelUnidadeMedia;
    }

    /**
    * atualiza UnidadeMedida
    * @param pUnidadeMedia
    * return boolean
    */
    public boolean atualizarUnidadeMediaDAO(UnidadeMedida pUnidadeMedia){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE unidade_medida SET "
                    + "codigo = '" + pUnidadeMedia.getCodigo() + "',"
                    + "abreviacao = '" + pUnidadeMedia.getAbreviacao() + "',"
                    + "descricao = '" + pUnidadeMedia.getDescricao() + "'"
                + " WHERE "
                    + "codigo = '" + pUnidadeMedia.getCodigo() + "'"
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
    * exclui UnidadeMedida
    * @param pCodigo
    * return boolean
    */
    public boolean excluirUnidadeMediaDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM unidade_medida "
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
