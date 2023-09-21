/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.Transportadora;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class TransportadoraDao extends ConexaoMySql {
    
 /**
    * grava Transportadora
    * @param pTransportadora
    * return int
    */
    public int salvarTransportadoraDAO(Transportadora pTransportadora){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO  transportadora ("
                    + "codigo,"
                    + "nome,"
                    + "endereco,"
                    + "bairro,"
                    + "cep,"
                    + "telefone,"
                    + "cod_cidade,"
                    + "nome_fantasia,"
                    + "cnpj,"
                    + "insc_estad"
                + ") VALUES ("
                    + "'" + pTransportadora.getCodigo() + "',"
                    + "'" + pTransportadora.getNome() + "',"
                    + "'" + pTransportadora.getEndereco() + "',"
                    + "'" + pTransportadora.getBairro() + "',"
                    + "'" + pTransportadora.getCep() + "',"
                    + "'" + pTransportadora.getTelefone() + "',"
                    + "'" + pTransportadora.getCodCidade() + "',"
                    + "'" + pTransportadora.getNomeFantasia() + "',"
                    + "'" + pTransportadora.getCnpj() + "',"
                    + "'" + pTransportadora.getInscEstad() + "'"
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
    * recupera Transportadora
    * @param pCodigo
    * return Transportadora
    */
    public Transportadora getTransportadoraDAO(int pCodigo){
        Transportadora modelTransportadora = new Transportadora();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "endereco,"
                    + "bairro,"
                    + "cep,"
                    + "telefone,"
                    + "cod_cidade,"
                    + "nome_fantasia,"
                    + "cnpj,"
                    + "insc_estad"
                 + " FROM"
                     + "  transportadora"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelTransportadora.setCodigo(this.getResultSet().getInt(1));
                modelTransportadora.setNome(this.getResultSet().getString(2));
                modelTransportadora.setEndereco(this.getResultSet().getString(3));
                modelTransportadora.setBairro(this.getResultSet().getString(4));
                modelTransportadora.setCep(this.getResultSet().getString(5));
                modelTransportadora.setTelefone(this.getResultSet().getString(6));
                modelTransportadora.setCodCidade(this.getResultSet().getInt(7));
                modelTransportadora.setNomeFantasia(this.getResultSet().getString(8));
                modelTransportadora.setCnpj(this.getResultSet().getString(9));
                modelTransportadora.setInscEstad(this.getResultSet().getString(10));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelTransportadora;
    }

    /**
    * recupera uma lista de Transportadora
        * return ArrayList
    */
    public ArrayList<Transportadora> getListaTransportadoraDAO(){
        ArrayList<Transportadora> listamodelTransportadora = new ArrayList();
        Transportadora modelTransportadora = new Transportadora();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "endereco,"
                    + "bairro,"
                    + "cep,"
                    + "telefone,"
                    + "cod_cidade,"
                    + "nome_fantasia,"
                    + "cnpj,"
                    + "insc_estad"
                 + " FROM"
                     + "  transportadora"
                + ";"
            );

            while(this.getResultSet().next()){
                modelTransportadora = new Transportadora();
                modelTransportadora.setCodigo(this.getResultSet().getInt(1));
                modelTransportadora.setNome(this.getResultSet().getString(2));
                modelTransportadora.setEndereco(this.getResultSet().getString(3));
                modelTransportadora.setBairro(this.getResultSet().getString(4));
                modelTransportadora.setCep(this.getResultSet().getString(5));
                modelTransportadora.setTelefone(this.getResultSet().getString(6));
                modelTransportadora.setCodCidade(this.getResultSet().getInt(7));
                modelTransportadora.setNomeFantasia(this.getResultSet().getString(8));
                modelTransportadora.setCnpj(this.getResultSet().getString(9));
                modelTransportadora.setInscEstad(this.getResultSet().getString(10));
                listamodelTransportadora.add(modelTransportadora);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelTransportadora;
    }

    /**
    * atualiza Transportadora
    * @param pTransportadora
    * return boolean
    */
    public boolean atualizarTransportadoraDAO(Transportadora pTransportadora){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE  transportadora SET "
                    + "codigo = '" + pTransportadora.getCodigo() + "',"
                    + "nome = '" + pTransportadora.getNome() + "',"
                    + "endereco = '" + pTransportadora.getEndereco() + "',"
                    + "bairro = '" + pTransportadora.getBairro() + "',"
                    + "cep = '" + pTransportadora.getCep() + "',"
                    + "telefone = '" + pTransportadora.getTelefone() + "',"
                    + "cod_cidade = '" + pTransportadora.getCodCidade() + "',"
                    + "nome_fantasia = '" + pTransportadora.getNomeFantasia() + "',"
                    + "cnpj = '" + pTransportadora.getCnpj() + "',"
                    + "insc_estad = '" + pTransportadora.getInscEstad() + "'"
                + " WHERE "
                    + "codigo = '" + pTransportadora.getCodigo() + "'"
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
    * exclui Transportadora
    * @param pCodigo
    * return boolean
    */
    public boolean excluirTransportadoraDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM  transportadora "
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
