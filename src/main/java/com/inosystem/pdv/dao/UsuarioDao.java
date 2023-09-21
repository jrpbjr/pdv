/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class UsuarioDao extends ConexaoMySql {
    
/**
    * grava Usuario
    * @param pUsuario
    * return int
    */
    public int salvarUsuarioDAO(Usuario pUsuario){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO usuarios ("
                    + "nome,"
                    + "login,"
                    + "senha"
                + ") VALUES ("
                    + "'" + pUsuario.getNome() + "',"
                    + "'" + pUsuario.getLogin() + "',"
                    + "'" + pUsuario.getSenha() + "'"
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
    * recupera Usuario
    * @param pCodigo
    * return Usuario
    */
    public Usuario getUsuarioDAO(int pCodigo){
        Usuario modelUsuario = new Usuario();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_codigo,"
                    + "nome,"
                    + "login,"
                    + "senha"
                 + " FROM"
                     + " usuarios"
                 + " WHERE"
                     + " pk_codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUsuario.setCodigo(this.getResultSet().getInt(1));
                modelUsuario.setNome(this.getResultSet().getString(2));
                modelUsuario.setLogin(this.getResultSet().getString(3));
                modelUsuario.setSenha(this.getResultSet().getString(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelUsuario;
    }

    /**
    * recupera Usuario
    * @param pLogin
    * return Usuario
    */
    public Usuario getUsuarioDAO(String pLogin){
        Usuario modelUsuario = new Usuario();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_codigo,"
                    + "nome,"
                    + "login,"
                    + "senha"
                 + " FROM"
                     + " usuarios"
                 + " WHERE"
                     + " login = '" + pLogin + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUsuario.setCodigo(this.getResultSet().getInt(1));
                modelUsuario.setNome(this.getResultSet().getString(2));
                modelUsuario.setLogin(this.getResultSet().getString(3));
                modelUsuario.setSenha(this.getResultSet().getString(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelUsuario;
    }
    
    /**
    * recupera Usuario
    * @param pCodigo
    * return Usuario
    */
    public boolean getUsuarioDAO(Usuario pUsuario){       
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "nome,"
                    + "login,"
                    + "senha"
                    + " FROM"
                    + " usuarios"
                    + " WHERE"
                    + " login = '" + pUsuario.getLogin()+ "' AND senha = '" + pUsuario.getSenha() + "' "
                    + ";"
            );

            if (getResultSet().next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            this.fecharConexao();
        }      
    }
    
    /**
    * recupera uma lista de Usuario
        * return ArrayList
    */
    public ArrayList<Usuario> getListaUsuarioDAO(){
        ArrayList<Usuario> listamodelUsuario = new ArrayList();
        Usuario modelUsuario = new Usuario();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_codigo,"
                    + "nome,"
                    + "login,"
                    + "senha"
                 + " FROM"
                     + " usuarios"
                + ";"
            );

            while(this.getResultSet().next()){
                modelUsuario = new Usuario();
                modelUsuario.setCodigo(this.getResultSet().getInt(1));
                modelUsuario.setNome(this.getResultSet().getString(2));
                modelUsuario.setLogin(this.getResultSet().getString(3));
                modelUsuario.setSenha(this.getResultSet().getString(4));
                listamodelUsuario.add(modelUsuario);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelUsuario;
    }

    /**
    * atualiza Usuario
    * @param pUsuario
    * return boolean
    */
    public boolean atualizarUsuarioDAO(Usuario pUsuario){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE usuarios SET "
                    + "pk_codigo = '" + pUsuario.getCodigo() + "',"
                    + "nome = '" + pUsuario.getNome() + "',"
                    + "login = '" + pUsuario.getLogin() + "',"
                    + "senha = '" + pUsuario.getSenha() + "'"
                + " WHERE "
                    + "pk_codigo = '" + pUsuario.getCodigo() + "'"
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
    * exclui Usuario
    * @param pCodigo
    * return boolean
    */
    public boolean excluirUsuarioDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM usuarios "
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