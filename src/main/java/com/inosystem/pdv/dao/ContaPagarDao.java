/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.ContaPagar;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class ContaPagarDao extends ConexaoMySql {
/**
     * grava ContaPagar
     *
     * @param pContaPagar return int
     */
    public int salvarContaPagarDAO(ContaPagar pContaPagar) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO contas_pagar ("
                    + "fk_codigo_pessoa,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor "
                    + ") VALUES ("
                    + "'" + pContaPagar.getCodigoPessoa() + "',"
                    + "'" + pContaPagar.getDescricao() + "',"
                    + "'" + pContaPagar.getData() + "',"
                    + "'" + pContaPagar.getVencimento() + "',"
                    + "'" + pContaPagar.getPagamento() + "',"
                    + "'" + pContaPagar.getTipoPagamento() + "',"
                    + "'" + pContaPagar.getObservacao() + "',"
                    + "'" + pContaPagar.isSituacao() + "',"
                    + "'" + pContaPagar.getValor() + "'"
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
     * recupera ContaPagar
     *
     * @param pCodigo return ModelConta
     */
    public ContaPagar getContaPagarDAO(int pCodigo) {
        ContaPagar modelContaPagar = new ContaPagar();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_pessoa,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor"
                    + " FROM"
                    + " contas_pagar"
                    + " WHERE"
                    + " pk_codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelContaPagar.setCodigo(this.getResultSet().getInt(1));
                modelContaPagar.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaPagar.setDescricao(this.getResultSet().getString(3));
                modelContaPagar.setData(this.getResultSet().getDate(4));
                modelContaPagar.setVencimento(this.getResultSet().getDate(5));
                modelContaPagar.setPagamento(this.getResultSet().getDate(6));
                modelContaPagar.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaPagar.setObservacao(this.getResultSet().getString(8));
                modelContaPagar.setSituacao(this.getResultSet().getInt(9));
                modelContaPagar.setValor(this.getResultSet().getBigDecimal(10) );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelContaPagar;
    }

    /**
     * recupera uma lista de ContaPagar return ArrayList
     */
    public ArrayList<ContaPagar> getListaContaPagarDAO() {
        ArrayList<ContaPagar> listamodelConta = new ArrayList();
        
        //ContaPagar modelContaPagar = new ContaPagar();
        
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_pessoa,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor"
                    + " FROM"
                    + " contas_pagar"
                    + ";"
            );

            while (this.getResultSet().next()) {
                ContaPagar modelContaPagar = new ContaPagar();
                
                modelContaPagar.setCodigo(this.getResultSet().getInt(1));
                modelContaPagar.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaPagar.setDescricao(this.getResultSet().getString(3));
                modelContaPagar.setData(this.getResultSet().getDate(4));
                modelContaPagar.setVencimento(this.getResultSet().getDate(5));
                modelContaPagar.setPagamento(this.getResultSet().getDate(6));
                modelContaPagar.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaPagar.setObservacao(this.getResultSet().getString(8));
                modelContaPagar.setSituacao(this.getResultSet().getInt(9));
                modelContaPagar.setValor(this.getResultSet().getBigDecimal(10));
                listamodelConta.add(modelContaPagar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelConta;
    }

    /**
     * recupera uma lista de ContaPagar return ArrayList
     */
    public ArrayList<ContaPagar> getListaContaPagarDAO(int pStatus) {
        ArrayList<ContaPagar> listamodelContaPagar = new ArrayList();
        ContaPagar modelContaPagar = new ContaPagar();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_pessoa,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor "
                    + " FROM"
                    + " contas_pagar where situacao = '" + pStatus + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelContaPagar = new ContaPagar();
                modelContaPagar.setCodigo(this.getResultSet().getInt(1));
                modelContaPagar.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaPagar.setDescricao(this.getResultSet().getString(3));
                modelContaPagar.setData(this.getResultSet().getDate(4));
                modelContaPagar.setVencimento(this.getResultSet().getDate(5));
                modelContaPagar.setPagamento(this.getResultSet().getDate(6));
                modelContaPagar.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaPagar.setObservacao(this.getResultSet().getString(8));
                modelContaPagar.setSituacao(this.getResultSet().getInt(9));
                modelContaPagar.setValor(this.getResultSet().getBigDecimal(10));
                listamodelContaPagar.add(modelContaPagar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelContaPagar;
    }

    /**
     * recupera uma lista de ContaPagar return ArrayList
     */
    public ArrayList<ContaPagar> getListaContasDAO(int pStatus) {
        ArrayList<ContaPagar> listamodelContaPagar = new ArrayList();
        ContaPagar modelContaPagar = new ContaPagar();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_pessoa,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor "
                    + " FROM"
                    + " contas_pagar where situacao = '" + pStatus + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelContaPagar = new ContaPagar();
                modelContaPagar.setCodigo(this.getResultSet().getInt(1));
                modelContaPagar.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaPagar.setDescricao(this.getResultSet().getString(3));
                modelContaPagar.setData(this.getResultSet().getDate(4));
                modelContaPagar.setVencimento(this.getResultSet().getDate(5));
                modelContaPagar.setPagamento(this.getResultSet().getDate(6));
                modelContaPagar.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaPagar.setObservacao(this.getResultSet().getString(8));
                modelContaPagar.setSituacao(this.getResultSet().getInt(9));
                modelContaPagar.setValor(this.getResultSet().getBigDecimal(10));
                listamodelContaPagar.add(modelContaPagar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelContaPagar;
    }

    /**
     * recupera uma lista de ContaPagar por data return ArrayList
     */
    public ArrayList<ContaPagar> getListaContasDAO(ContaPagar pModelConta) {
        ArrayList<ContaPagar> listamodelContaPagar = new ArrayList();
        ContaPagar modelContaPagar = new ContaPagar();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "fk_codigo_pessoa,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor "
                    + " FROM"
                    + " contas_pagar "
                    + "WHERE "
                    + "(pagamento BETWEEN  '" + pModelConta.getData() + "' AND '" + pModelConta.getPagamento() + "') "
                    + "AND (situacao = '" + pModelConta.isSituacao() + "');"
            );

            while (this.getResultSet().next()) {
                modelContaPagar = new ContaPagar();
                modelContaPagar.setCodigo(this.getResultSet().getInt(1));
                modelContaPagar.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaPagar.setDescricao(this.getResultSet().getString(3));
                modelContaPagar.setData(this.getResultSet().getDate(4));
                modelContaPagar.setVencimento(this.getResultSet().getDate(5));
                modelContaPagar.setPagamento(this.getResultSet().getDate(6));
                modelContaPagar.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaPagar.setObservacao(this.getResultSet().getString(8));
                modelContaPagar.setSituacao(this.getResultSet().getInt(9));
                modelContaPagar.setValor(this.getResultSet().getBigDecimal(10));
                listamodelContaPagar.add(modelContaPagar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelContaPagar;
    }

    /**
     * atualiza ContaPagar
     *
     * @param pContaPagar return boolean
     */
    public boolean atualizarContaPagarDAO(ContaPagar pContaPagar) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE contas_pagar SET "
                    + "pk_codigo = '" + pContaPagar.getCodigo() + "',"
                    + "fk_codigo_pessoa = '" + pContaPagar.getCodigoPessoa() + "',"
                    + "descricao = '" + pContaPagar.getDescricao() + "',"
                    + "data = '" + pContaPagar.getData() + "',"
                    + "vencimento = '" + pContaPagar.getVencimento() + "',"
                    + "pagamento = '" + pContaPagar.getPagamento() + "',"
                    + "fk_tipo_pagamento = '" + pContaPagar.getTipoPagamento() + "',"
                    + "observacao = '" + pContaPagar.getObservacao() + "',"
                    + "situacao = '" + pContaPagar.isSituacao() + "',"
                    + "valor = '" + pContaPagar.getValor() + "'"
                    + " WHERE "
                    + "pk_codigo = '" + pContaPagar.getCodigo() + "'"
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
     * exclui ContaPagar
     *
     * @param pCodigo return boolean
     */
    public boolean excluirContaPagarDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM contas_pagar "
                    + " WHERE "
                    + "pk_codigo = '" + pCodigo + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean pagarContaPagarDAO(ContaPagar pContaPagar) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE contas_pagar SET "
                    + "pagamento = '" + pContaPagar.getPagamento() + "',"
                    + "situacao = '" + pContaPagar.isSituacao() + "'"
                    + " WHERE "
                    + "pk_codigo = '" + pContaPagar.getCodigo() + "'"
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
