/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.Cidade;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class CidadeDao extends ConexaoMySql{
    
/**
     * grava Cidade
     *
     * @param pCidade return int
     */
    public int salvarCidadeDAO(Cidade pCidade) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO cidade ("
                    + "codigo_ibge,"
                    + "nome,"
                    + "fk_cod_estado"
                    + ") VALUES ("
                    + "'" + pCidade.getCodigoIBGE() + "',"
                    + "'" + pCidade.getNome() + "',"
                    + "'" + pCidade.getFk_cod_estado() + "'"
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
     * recupera Cidade
     *
     * @param pCodigo return Cidade
     */
    public Cidade getCidadeDAO(int pCodigo) {
        Cidade modelCidade = new Cidade();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "fk_cod_estado,"
                    + "codigo_ibge"
                    + " FROM"
                    + " cidade"
                    + " WHERE"
                    + " codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setNome(this.getResultSet().getString(2));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(3));
                modelCidade.setCodigoIBGE(this.getResultSet().getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCidade;
    }

    /**
     * recupera Cidade
     *
     * @param pNome return Cidade
     */
    public Cidade getCidadeDAO(String pNome) {
        Cidade modelCidade = new Cidade();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "codigo_ibge,"
                    + "nome,"
                    + "fk_cod_estado"
                    + " FROM"
                    + " cidade"
                    + " WHERE"
                    + " nome = '" + pNome + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setCodigoIBGE(this.getResultSet().getInt(2));
                modelCidade.setNome(this.getResultSet().getString(3));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCidade;
    }

    /**
     * recupera uma lista de Cidade return ArrayList
     */
    public ArrayList<Cidade> getListaCidadeDAO() {
        ArrayList<Cidade> listamodelCidade = new ArrayList();
        Cidade modelCidade = new Cidade();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "codigo_ibge,"
                    + "nome,"
                    + "fk_cod_estado"
                    + " FROM"
                    + " cidade"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCidade = new Cidade();
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setCodigoIBGE(this.getResultSet().getInt(2));
                modelCidade.setNome(this.getResultSet().getString(3));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(4));
                listamodelCidade.add(modelCidade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelCidade;
    }

    /**
     * recupera uma lista de Cidade return ArrayList
     */
    public ArrayList<Cidade> getListaCidadePorEstadoDAO(int pCodigoEstado) {
        ArrayList<Cidade> listamodelCidade = new ArrayList();
        Cidade modelCidade = new Cidade();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "codigo_ibge,"
                    + "nome,"
                    + "fk_cod_estado"
                    + " FROM"
                    + " cidade"
                    + " where fk_cod_estado = '" + pCodigoEstado + "' ORDER BY nome;"
            );

            while (this.getResultSet().next()) {
                modelCidade = new Cidade();
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setCodigoIBGE(this.getResultSet().getInt(2));
                modelCidade.setNome(this.getResultSet().getString(3));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(4));
                listamodelCidade.add(modelCidade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelCidade;
    }

    /**
     * atualiza Cidade
     *
     * @param pCidade return boolean
     */
    public boolean atualizarCidadeDAO(Cidade pCidade) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE cidade SET "
                    + "codigo_ibge = '" + pCidade.getCodigoIBGE() + "',"
                    + "nome = '" + pCidade.getNome() + "',"
                    + "fk_cod_estado = '" + pCidade.getFk_cod_estado() + "'"
                    + " WHERE "
                    + "codigo = '" + pCidade.getCodigo() + "'"
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
     * exclui Cidade
     *
     * @param pCodigo return boolean
     */
    public boolean excluirCidadeDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM cidade "
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
}

