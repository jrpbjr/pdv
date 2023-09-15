/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.Garcom;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class GarcomDao extends ConexaoMySql {
    
/**
     * grava Garcom
     *
     * @param pGarcom return int
     */
    public int salvarGarcomDAO(Garcom pGarcom) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO garcon ("
                    + "codigo,"
                    + "nome,"
                    + "endereco,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cep,"
                    + "telefone,"
                    + "comissao,"
                    + "senha"
                    + ") VALUES ("
                    + "'" + pGarcom.getCodigo() + "',"
                    + "'" + pGarcom.getNome() + "',"
                    + "'" + pGarcom.getEndereco() + "',"
                    + "'" + pGarcom.getBairro() + "',"
                    + "'" + pGarcom.getCodCidade() + "',"
                    + "'" + pGarcom.getCep() + "',"
                    + "'" + pGarcom.getTelefone() + "',"
                    + "'" + pGarcom.getComissao() + "',"
                    + "'" + pGarcom.getSenha() + "'"
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
     * recupera Garcom
     *
     * @param pCodigo return Garcom
     */
    public Garcom getGarcomDAO(int pCodigo) {
        Garcom modelGarcom = new Garcom();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "garcon.codigo,"
                    + "garcon.nome,"
                    + "garcon.endereco,"
                    + "garcon.bairro,"
                    + "garcon.cod_cidade,"
                    + "cidade.fk_cod_estado,"
                    + "garcon.cep,"
                    + "garcon.telefone,"
                    + "garcon.comissao,"
                    + "garcon.senha"
                    + " FROM"
                    + " cidade inner join estado on estado.codigo = cidade.fk_cod_estado "
                    + " inner join garcon on cidade.codigo = garcon.cod_cidade"
                    + " WHERE"
                    + " garcon.codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelGarcom.setCodigo(this.getResultSet().getInt(1));
                modelGarcom.setNome(this.getResultSet().getString(2));
                modelGarcom.setEndereco(this.getResultSet().getString(3));
                modelGarcom.setBairro(this.getResultSet().getString(4));
                modelGarcom.setCodCidade(this.getResultSet().getInt(5));
                modelGarcom.setCodEstado(this.getResultSet().getInt(6));
                modelGarcom.setCep(this.getResultSet().getString(7));
                modelGarcom.setTelefone(this.getResultSet().getString(8));
                modelGarcom.setComissao(this.getResultSet().getBigDecimal(9));
                modelGarcom.setSenha(this.getResultSet().getString(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelGarcom;
    }
    /**
     * recupera Garcom
     *
     * @param pCodigo return Garcom
     */
    public Garcom getGarcomDAO(String pNome) {
        Garcom modelGarcom = new Garcom();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "garcon.codigo,"
                    + "garcon.nome,"
                    + "garcon.endereco,"
                    + "garcon.bairro,"
                    + "garcon.cod_cidade,"
                    + "cidade.fk_cod_estado,"
                    + "garcon.cep,"
                    + "garcon.telefone,"
                    + "garcon.comissao,"
                    + "garcon.senha"
                    + " FROM"
                    + " cidade inner join estado on estado.codigo = cidade.fk_cod_estado "
                    + " inner join garcon on cidade.codigo = garcon.cod_cidade"
                    + " WHERE"
                    + " garcon.nome = '" + pNome + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelGarcom.setCodigo(this.getResultSet().getInt(1));
                modelGarcom.setNome(this.getResultSet().getString(2));
                modelGarcom.setEndereco(this.getResultSet().getString(3));
                modelGarcom.setBairro(this.getResultSet().getString(4));
                modelGarcom.setCodCidade(this.getResultSet().getInt(5));
                modelGarcom.setCodEstado(this.getResultSet().getInt(6));
                modelGarcom.setCep(this.getResultSet().getString(7));
                modelGarcom.setTelefone(this.getResultSet().getString(8));
                modelGarcom.setComissao(this.getResultSet().getBigDecimal(9));
                modelGarcom.setSenha(this.getResultSet().getString(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelGarcom;
    }

    /**
     * recupera uma lista de Garcom return ArrayList
     */
    public ArrayList<Garcom> getListaGarcomDAO() {
        ArrayList<Garcom> listamodelGarcom = new ArrayList();
        Garcom modelGarcom = new Garcom();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "garcon.codigo,"
                    + "garcon.nome,"
                    + "garcon.endereco,"
                    + "garcon.bairro,"
                    + "garcon.cod_cidade,"
                    + "cidade.fk_cod_estado,"
                    + "garcon.cep,"
                    + "garcon.telefone,"
                    + "garcon.comissao,"
                    + "garcon.senha"
                    + " FROM"
                    + " cidade inner join estado on estado.codigo = cidade.fk_cod_estado "
                    + " inner join garcon on cidade.codigo = garcon.cod_cidade"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelGarcom = new Garcom();
                modelGarcom.setCodigo(this.getResultSet().getInt(1));
                modelGarcom.setNome(this.getResultSet().getString(2));
                modelGarcom.setEndereco(this.getResultSet().getString(3));
                modelGarcom.setBairro(this.getResultSet().getString(4));
                modelGarcom.setCodCidade(this.getResultSet().getInt(5));
                modelGarcom.setCodEstado(this.getResultSet().getInt(6));
                modelGarcom.setCep(this.getResultSet().getString(7));
                modelGarcom.setTelefone(this.getResultSet().getString(8));
                modelGarcom.setComissao(this.getResultSet().getBigDecimal(9));
                modelGarcom.setSenha(this.getResultSet().getString(10));
                listamodelGarcom.add(modelGarcom);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelGarcom;
    }

    /**
     * atualiza Garcom
     *
     * @param pGarcom return boolean
     */
    public boolean atualizarGarcomDAO(Garcom pGarcom) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE garcon SET "
                    + "codigo = '" + pGarcom.getCodigo() + "',"
                    + "nome = '" + pGarcom.getNome() + "',"
                    + "endereco = '" + pGarcom.getEndereco() + "',"
                    + "bairro = '" + pGarcom.getBairro() + "',"
                    + "cod_cidade = '" + pGarcom.getCodCidade() + "',"
                    + "cep = '" + pGarcom.getCep() + "',"
                    + "telefone = '" + pGarcom.getTelefone() + "',"
                    + "comissao = '" + pGarcom.getComissao() + "',"
                    + "senha = '" + pGarcom.getSenha() + "'"
                    + " WHERE "
                    + "codigo = '" + pGarcom.getCodigo() + "'"
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
     * exclui Garcom
     *
     * @param pCodigo return boolean
     */
    public boolean excluirGarcomDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM garcon "
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

