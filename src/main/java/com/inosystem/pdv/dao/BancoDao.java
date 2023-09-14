/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.model.Banco;
import java.util.ArrayList;
import com.inosystem.pdv.model.SessaoUsuario;
import com.inosystem.pdv.conexoes.ConexaoMySql; 

/**
 *
 * @author jrpbj
 */
public class BancoDao extends ConexaoMySql {
    

    public boolean criarBancoDAO() {
        try {
            this.conectarSemBanco();
            
            this.executarUpdateDeleteSQL("CREATE DATABASE " + SessaoUsuario.nomeDoBanco);
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
        return true;
    }
    
/**
    * grava Banco
    * @param pBanco
    * return int
    */
    public int salvarBancoDAO(Banco pBanco){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO banco ("
                    + "banco,"
                    + "descricao,"
                    + "nome_reduzido,"
                    + "emite_boleto"
                + ") VALUES ("
                    + "'" + pBanco.getBanco() + "',"
                    + "'" + pBanco.getDescricao() + "',"
                    + "'" + pBanco.getNomeReduzido() + "',"
                    + "'" + pBanco.getEmiteBoleto() + "'"
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
    * recupera Banco
    * @param pCodigo
    * @return Banco
    */
    public Banco getBancoDAO(int pCodigo){
        Banco modelBanco = new Banco();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "banco,"
                    + "descricao,"
                    + "nome_reduzido,"
                    + "emite_boleto"
                 + " FROM"
                     + " banco"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelBanco.setCodigo(this.getResultSet().getInt(1));
                modelBanco.setBanco(this.getResultSet().getString(2));
                modelBanco.setDescricao(this.getResultSet().getString(3));
                modelBanco.setNomeReduzido(this.getResultSet().getString(4));
                modelBanco.setEmiteBoleto(this.getResultSet().getString(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelBanco;
    }
    /**
    * recupera Banco
    * @param pNome
    * @return Banco
    */
    public Banco getBancoDAO(String pNome){
        Banco modelBanco = new Banco();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "banco,"
                    + "descricao,"
                    + "nome_reduzido,"
                    + "emite_boleto"
                 + " FROM"
                     + " banco"
                 + " WHERE"
                     + " nome_reduzido = '" + pNome + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelBanco.setCodigo(this.getResultSet().getInt(1));
                modelBanco.setBanco(this.getResultSet().getString(2));
                modelBanco.setDescricao(this.getResultSet().getString(3));
                modelBanco.setNomeReduzido(this.getResultSet().getString(4));
                modelBanco.setEmiteBoleto(this.getResultSet().getString(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelBanco;
    }

    /**
    * recupera uma lista de Banco
        * return ArrayList
    */
    public ArrayList<Banco> getListaBancoDAO(){
        ArrayList<Banco> listamodelBanco = new ArrayList();
        Banco modelBanco = new Banco();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "banco,"
                    + "descricao,"
                    + "nome_reduzido,"
                    + "emite_boleto"
                 + " FROM"
                     + " banco"
                + ";"
            );

            while(this.getResultSet().next()){
                modelBanco = new Banco();
                modelBanco.setCodigo(this.getResultSet().getInt(1));
                modelBanco.setBanco(this.getResultSet().getString(2));
                modelBanco.setDescricao(this.getResultSet().getString(3));
                modelBanco.setNomeReduzido(this.getResultSet().getString(4));
                modelBanco.setEmiteBoleto(this.getResultSet().getString(5));
                listamodelBanco.add(modelBanco);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelBanco;
    }

    /**
    * atualiza Banco
    * @param pBanco
    * return boolean
    */
    public boolean atualizarBancoDAO(Banco pBanco){
        try {
            this.conectar();
            String sql = 
                "UPDATE banco SET "
                    + "codigo = '" + pBanco.getCodigo() + "',"
                    + "banco = '" + pBanco.getBanco() + "',"
                    + "descricao = '" + pBanco.getDescricao() + "',"
                    + "nome_reduzido = '" + pBanco.getNomeReduzido() + "',"
                    + "emite_boleto = '" + pBanco.getEmiteBoleto() + "'"
                + " WHERE "
                    + "codigo = '" + pBanco.getCodigo() + "'"
                + ";";
            return this.executarUpdateDeleteSQL(sql);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui Banco
    * @param pCodigo
    * return boolean
    */
    public boolean excluirBancoDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM banco "
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

