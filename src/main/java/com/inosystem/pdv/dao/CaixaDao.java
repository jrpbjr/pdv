/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.Caixa;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class CaixaDao extends ConexaoMySql {
    
/**
     * grava Caixa
     *
     * @param pCaixa return int
     */
    public int salvarCaixaDAO(Caixa pCaixa) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO caixa ("
                    + "caixa_numero,"
                    + "dinheiro,"
                    + "cheque,"
                    + "cartao,"
                    + "vale,"
                    + "codigo_usuario,"
                    + "status,"
                    + "data_abertura"
                    + ") VALUES ("
                    + "'" + pCaixa.getCaixaNumero() + "',"
                    + "'" + pCaixa.getDinheiro() + "',"
                    + "'" + pCaixa.getCheque() + "',"
                    + "'" + pCaixa.getCartao() + "',"
                    + "'" + pCaixa.getConvenio() + "',"
                    + "'" + pCaixa.getCodigoUsuario() + "',"
                    + "'" + pCaixa.getStatus() + "',"
                    + "'" + pCaixa.getDataAbertura() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera Caixa
     *
     * @param pCodigo return Caixa
     */
    public Caixa getCaixaDAO(int pCodigo) {
        Caixa modelCaixa = new Caixa();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "caixa_numero,"
                    + "dinheiro,"
                    + "cheque,"
                    + "cartao,"
                    + "vale,"
                    + "codigo_usuario,"
                    + "status,"
                    + "data_abertura,"
                    + "data_fechamento "
                    + "FROM caixa "
                    + " WHERE"
                    + " caixa_numero = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCaixa.setCodigo(this.getResultSet().getInt(1));
                modelCaixa.setCaixaNumero(this.getResultSet().getInt(2));
                modelCaixa.setDinheiro(this.getResultSet().getDouble(3));
                modelCaixa.setCheque(this.getResultSet().getDouble(4));
                modelCaixa.setCartao(this.getResultSet().getDouble(5));
                modelCaixa.setConvenio(this.getResultSet().getDouble(6));
                modelCaixa.setCodigoUsuario(this.getResultSet().getInt(7));
                modelCaixa.setStatus(this.getResultSet().getInt(8));
                modelCaixa.setDataAbertura(this.getResultSet().getDate(9));
                modelCaixa.setDataFechamento(this.getResultSet().getDate(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCaixa;
    }

    /**
     * recupera uma lista de Caixa return ArrayList
     */
    public ArrayList<Caixa> getListaCaixaDAO() {
        ArrayList<Caixa> listamodelCaixa = new ArrayList();
        Caixa modelCaixa = new Caixa();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "caixa_numero,"
                    + "dinheiro,"
                    + "cheque,"
                    + "cartao,"
                    + "vale,"
                    + "codigo_usuario,"
                    + "status,"
                    + "data_abertura,"
                    + "data_fechamento "
                    + " FROM"
                    + " caixa"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCaixa = new Caixa();
                modelCaixa.setCodigo(this.getResultSet().getInt(1));
                modelCaixa.setCaixaNumero(this.getResultSet().getInt(2));
                modelCaixa.setDinheiro(this.getResultSet().getDouble(3));
                modelCaixa.setCheque(this.getResultSet().getDouble(4));
                modelCaixa.setCartao(this.getResultSet().getDouble(5));
                modelCaixa.setConvenio(this.getResultSet().getDouble(6));
                modelCaixa.setCodigoUsuario(this.getResultSet().getInt(7));
                modelCaixa.setStatus(this.getResultSet().getInt(8));
                modelCaixa.setDataAbertura(this.getResultSet().getDate(9));
                modelCaixa.setDataFechamento(this.getResultSet().getDate(10));
                listamodelCaixa.add(modelCaixa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelCaixa;
    }

    /**
     * atualiza Caixa
     *
     * @param pCaixa return boolean
     */
    public boolean atualizarCaixaDAO(Caixa pCaixa) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE caixa SET "
                    + "caixa_numero = '" + pCaixa.getCaixaNumero() + "',"
                    + "dinheiro = '" + pCaixa.getDinheiro() + "',"
                    + "cheque = '" + pCaixa.getCheque() + "',"
                    + "cartao = '" + pCaixa.getCartao() + "',"
                    + "vale = '" + pCaixa.getConvenio() + "',"
                    + "status = '" + pCaixa.getStatus() + "',"
                    + "data_abertura = '" + pCaixa.getDataAbertura() + "',"
                    + "data_fechamento = '" + pCaixa.getDataFechamento() + "'"
                    + " WHERE "
                    + "codigo = '" + pCaixa.getCodigo() + "'"
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
     * atualiza Caixa
     *
     * @param pCaixa return boolean
     */
    public boolean atualizarCaixaPDVDAO(Caixa pCaixa) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE caixa SET "
                    + "dinheiro = '" + pCaixa.getDinheiro() + "',"
                    + "cheque = '" + pCaixa.getCheque() + "',"
                    + "cartao = '" + pCaixa.getCartao() + "',"
                    + "vale = '" + pCaixa.getConvenio() + "'"
                    + " WHERE "
                    + "codigo = '" + pCaixa.getCodigo() + "'"
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
     * exclui Caixa
     *
     * @param pCodigo return boolean
     */
    public boolean excluirCaixaDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM caixa "
                    + " WHERE "
                    + "codigo = '" + pCodigo + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public Caixa verificarRetorarCaixaDAO(int numeroCaixa) {
        Caixa modelCaixa = new Caixa();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "caixa_numero,"
                    + "dinheiro,"
                    + "cheque,"
                    + "cartao,"
                    + "vale,"
                    + "codigo_usuario,"
                    + "status,"
                    + "data_abertura,"
                    + "data_fechamento "
                    + "FROM caixa "
                    + " WHERE"
                    + " caixa_numero = '" + numeroCaixa + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCaixa.setCodigo(this.getResultSet().getInt(1));
                modelCaixa.setCaixaNumero(this.getResultSet().getInt(2));
                modelCaixa.setDinheiro(this.getResultSet().getDouble(3));
                modelCaixa.setCheque(this.getResultSet().getDouble(4));
                modelCaixa.setCartao(this.getResultSet().getDouble(5));
                modelCaixa.setConvenio(this.getResultSet().getDouble(6));
                modelCaixa.setCodigoUsuario(this.getResultSet().getInt(7));
                modelCaixa.setStatus(this.getResultSet().getInt(8));
                modelCaixa.setDataAbertura(this.getResultSet().getDate(9));
                modelCaixa.setDataFechamento(this.getResultSet().getDate(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCaixa;
    }

    public Caixa retorarCaixaDAO(int numeroCaixa) {
        Caixa modelCaixa = new Caixa();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "caixa_numero,"
                    + "dinheiro,"
                    + "cheque,"
                    + "cartao,"
                    + "vale,"
                    + "codigo_usuario,"
                    + "status,"
                    + "data_abertura,"
                    + "data_fechamento "
                    + "FROM caixa "
                    + " WHERE"
                    + " caixa_numero = '" + numeroCaixa + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCaixa.setCodigo(this.getResultSet().getInt(1));
                modelCaixa.setCaixaNumero(this.getResultSet().getInt(2));
                modelCaixa.setDinheiro(this.getResultSet().getDouble(3));
                modelCaixa.setCheque(this.getResultSet().getDouble(4));
                modelCaixa.setCartao(this.getResultSet().getDouble(5));
                modelCaixa.setConvenio(this.getResultSet().getDouble(6));
                modelCaixa.setCodigoUsuario(this.getResultSet().getInt(7));
                modelCaixa.setStatus(this.getResultSet().getInt(8));
                modelCaixa.setDataAbertura(this.getResultSet().getDate(9));
                modelCaixa.setDataFechamento(this.getResultSet().getDate(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCaixa;
    }
}

