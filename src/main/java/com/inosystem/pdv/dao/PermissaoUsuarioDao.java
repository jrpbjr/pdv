/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.PermissaoUsuario;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class PermissaoUsuarioDao extends ConexaoMySql {
    
/**
     * grava Permissaousuario
     *
     * @param pPermissaoUsuario return int
     */
    public int salvarPermissaousuarioDAO(PermissaoUsuario pPermissaoUsuario) {
        try {
            this.conectar();
            int sizeLista = pPermissaoUsuario.getListaPermissaoUsuarios().size();
            for (int i = 0; i < sizeLista; i++) {
                this.insertSQL(
                        "INSERT INTO usuario_permissao ("
                        + "fk_codigo_usuario, "
                        + " permissao "
                        + ") VALUES ("
                        + "'" + pPermissaoUsuario.getListaPermissaoUsuarios().get(i).getCodigo_usuario() + "',"
                        + "'" + pPermissaoUsuario.getListaPermissaoUsuarios().get(i).getPermissao() + "'"
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
     * recupera Permissaousuario
     *
     * @param pCodigo return PermissaoUsuario
     */
    public PermissaoUsuario getPermissaousuarioDAO(int pCodigo) {
        PermissaoUsuario modelPermissaousuario = new PermissaoUsuario();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_usuario,"
                    + "permissao"
                    + " FROM"
                    + " usuario_permissao"
                    + " WHERE"
                    + " pk_codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelPermissaousuario.setCodigo(this.getResultSet().getInt(1));
                modelPermissaousuario.setCodigo_usuario(this.getResultSet().getInt(2));
                modelPermissaousuario.setPermissao(this.getResultSet().getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelPermissaousuario;
    }

    /**
     * verifica permissão de compras
     *
     * @param pCodigoUsuario return PermissaoUsuario
     */
    public PermissaoUsuario getPermissaousuarioCodUsuDAO(int pCodigoUsuario) {
        PermissaoUsuario modelPermissaousuario = new PermissaoUsuario();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_usuario,"
                    + "permissao"
                    + " FROM"
                    + " usuario_permissao"
                    + " WHERE"
                    + " fk_codigo_usuario = '" + pCodigoUsuario + "' and permissao = 'compras'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelPermissaousuario.setCodigo(this.getResultSet().getInt(1));
                modelPermissaousuario.setCodigo_usuario(this.getResultSet().getInt(2));
                modelPermissaousuario.setPermissao(this.getResultSet().getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelPermissaousuario;
    }
    /**
     * verifica permissão de compras
     *
     * @param pCodigoUsuario return PermissaoUsuario
     */
    public PermissaoUsuario getVerificaPermissaoNFeDAO(int pCodigoUsuario) {
        PermissaoUsuario modelPermissaousuario = new PermissaoUsuario();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_usuario,"
                    + "permissao"
                    + " FROM"
                    + " usuario_permissao"
                    + " WHERE"
                    + " fk_codigo_usuario = '" + pCodigoUsuario + "' and permissao = 'nfe'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelPermissaousuario.setCodigo(this.getResultSet().getInt(1));
                modelPermissaousuario.setCodigo_usuario(this.getResultSet().getInt(2));
                modelPermissaousuario.setPermissao(this.getResultSet().getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelPermissaousuario;
    }

    /**
     * recupera uma lista de Permissaousuario return ArrayList
     */
    public ArrayList<PermissaoUsuario> getListaPermissaousuarioDAO() {
        ArrayList<PermissaoUsuario> listamodelPermissaousuario = new ArrayList();
        PermissaoUsuario modelPermissaousuario = new PermissaoUsuario();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_usuario,"
                    + "permissao"
                    + " FROM"
                    + " usuario_permissao"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelPermissaousuario = new PermissaoUsuario();
                modelPermissaousuario.setCodigo(this.getResultSet().getInt(1));
                modelPermissaousuario.setCodigo_usuario(this.getResultSet().getInt(2));
                modelPermissaousuario.setPermissao(this.getResultSet().getString(3));
                listamodelPermissaousuario.add(modelPermissaousuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelPermissaousuario;
    }

    /**
     * atualiza Permissaousuario
     *
     * @param pPermissaoUsuario return boolean
     */
    public boolean atualizarPermissaousuarioDAO(PermissaoUsuario pPermissaoUsuario) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE usuario_permissao SET "
                    + "pk_codigo = '" + pPermissaoUsuario.getCodigo() + "',"
                    + "fk_codigo_usuario = '" + pPermissaoUsuario.getCodigo_usuario() + "',"
                    + "permissao = '" + pPermissaoUsuario.getPermissao() + "'"
                    + " WHERE "
                    + "pk_codigo = '" + pPermissaoUsuario.getCodigo() + "'"
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
     * exclui Permissaousuario
     *
     * @param pCodigo return boolean
     */
    public boolean excluirPermissaousuarioDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM usuario_permissao "
                    + " WHERE "
                    + "fk_codigo_usuario = '" + pCodigo + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public ArrayList<PermissaoUsuario> getListaPermissaousuarioDAO(int pCodigo) {
        ArrayList<PermissaoUsuario> listamodelPermissaousuario = new ArrayList();
        PermissaoUsuario modelPermissaousuario = new PermissaoUsuario();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_usuario,"
                    + "permissao"
                    + " FROM"
                    + " usuario_permissao WHERE fk_codigo_usuario = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelPermissaousuario = new PermissaoUsuario();
                modelPermissaousuario.setCodigo(this.getResultSet().getInt(1));
                modelPermissaousuario.setCodigo_usuario(this.getResultSet().getInt(2));
                modelPermissaousuario.setPermissao(this.getResultSet().getString(3));
                listamodelPermissaousuario.add(modelPermissaousuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelPermissaousuario;
    }
}

