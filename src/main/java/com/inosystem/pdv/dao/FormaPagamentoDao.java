/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.FormaPagamento;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class FormaPagamentoDao extends ConexaoMySql {
    
/**
     * grava FormaPagamento
     *
     * @param pFormaPagamento return int
     */
    public int salvarFormaPagamentoDAO(FormaPagamento pFormaPagamento) {
        try {
            this.conectar();
            int situacao = 0;
            if (pFormaPagamento.isSituacao()) {
                situacao = 1;
            } else {
                situacao = 0;
            }
            return this.insertSQL(
                    "INSERT INTO forma_pagamento ("
                    + "descricao,"
                    + "desconto,"
                    + "quantidade_parcelas,"
                    + "observacao,"
                    + "situacao"
                    + ") VALUES ("
                    + "'" + pFormaPagamento.getDescricao() + "',"
                    + "'" + pFormaPagamento.getDesconto() + "',"
                    + "'" + pFormaPagamento.getQuantidadeParcelas() + "',"
                    + "'" + pFormaPagamento.getObservacao() + "',"
                    + "'" + situacao + "'"
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
    * recupera FormaPagamento
    * @param pCodigo
    * return FormaPagamento
    */
    public FormaPagamento getFormaPagamentoDAO(int pCodigo){
        FormaPagamento modelFormaPagamento = new FormaPagamento();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "descricao,"
                    + "desconto,"
                    + "quantidade_parcelas,"
                    + "observacao,"
                    + "situacao"
                 + " FROM"
                     + " forma_pagamento"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFormaPagamento.setCodigo(this.getResultSet().getInt(1));
                modelFormaPagamento.setDescricao(this.getResultSet().getString(2));
                modelFormaPagamento.setDesconto(this.getResultSet().getFloat(3));
                modelFormaPagamento.setQuantidadeParcelas(this.getResultSet().getInt(4));
                modelFormaPagamento.setObservacao(this.getResultSet().getString(5));
                modelFormaPagamento.setSituacao(this.getResultSet().getBoolean(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelFormaPagamento;
    }
    
    /**
    * recupera FormaPagamento
    * @param pDescricao
    * return FormaPagamento
    */
    public FormaPagamento getFormaPagamentoDAO(String pDescricao){
        FormaPagamento modelFormaPagamento = new FormaPagamento();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "descricao,"
                    + "desconto,"
                    + "quantidade_parcelas,"
                    + "observacao,"
                    + "situacao"
                 + " FROM"
                     + " forma_pagamento"
                 + " WHERE"
                     + " descricao = '" + pDescricao + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFormaPagamento.setCodigo(this.getResultSet().getInt(1));
                modelFormaPagamento.setDescricao(this.getResultSet().getString(2));
                modelFormaPagamento.setDesconto(this.getResultSet().getFloat(3));
                modelFormaPagamento.setQuantidadeParcelas(this.getResultSet().getInt(4));
                modelFormaPagamento.setObservacao(this.getResultSet().getString(5));
                modelFormaPagamento.setSituacao(this.getResultSet().getBoolean(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelFormaPagamento;
    }

    /**
    * recupera uma lista de FormaPagamento
        * return ArrayList
    */
    public ArrayList<FormaPagamento> getListaFormaPagamentoDAO(){
        ArrayList<FormaPagamento> listamodelFormaPagamento = new ArrayList();
        FormaPagamento modelFormaPagamento = new FormaPagamento();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "descricao,"
                    + "desconto,"
                    + "quantidade_parcelas,"
                    + "observacao,"
                    + "situacao"
                 + " FROM"
                     + " forma_pagamento"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFormaPagamento = new FormaPagamento();
                modelFormaPagamento.setCodigo(this.getResultSet().getInt(1));
                modelFormaPagamento.setDescricao(this.getResultSet().getString(2));
                modelFormaPagamento.setDesconto(this.getResultSet().getFloat(3));
                modelFormaPagamento.setQuantidadeParcelas(this.getResultSet().getInt(4));
                modelFormaPagamento.setObservacao(this.getResultSet().getString(5));
                modelFormaPagamento.setSituacao(this.getResultSet().getBoolean(6));
                listamodelFormaPagamento.add(modelFormaPagamento);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelFormaPagamento;
    }

    /**
    * atualiza FormaPagamento
    * @param pFormaPagamento
    * return boolean
    */
    public boolean atualizarFormaPagamentoDAO(FormaPagamento pFormaPagamento){
        try {
            this.conectar();
            int situacao = 0;
            if (pFormaPagamento.isSituacao()) {
                situacao = 1;
            } else {
                situacao = 0;
            }
            return this.executarUpdateDeleteSQL(
                "UPDATE forma_pagamento SET "
                    + "codigo = '" + pFormaPagamento.getCodigo() + "',"
                    + "descricao = '" + pFormaPagamento.getDescricao() + "',"
                    + "desconto = '" + pFormaPagamento.getDesconto() + "',"
                    + "quantidade_parcelas = '" + pFormaPagamento.getQuantidadeParcelas() + "',"
                    + "observacao = '" + pFormaPagamento.getObservacao() + "',"
                    + "situacao = '" + situacao + "'"
                + " WHERE "
                    + "codigo = '" + pFormaPagamento.getCodigo() + "'"
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
    * exclui FormaPagamento
    * @param pCodigo
    * return boolean
    */
    public boolean excluirFormaPagamentoDAO(int pCodigo){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM forma_pagamento "
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
