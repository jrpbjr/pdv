/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.ContaReceber;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class ContaReceberDao extends ConexaoMySql {
    
 /**
     * grava ContaPagar
     *
     * @param pModelContaRecber return int
     */
    public int salvarContaReceberDAO(ContaReceber pModelContaRecber) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO contas_receber ("
                    + "clientes_codigo,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor "
                    + ") VALUES ("
                    + "'" + pModelContaRecber.getCodigoPessoa() + "',"
                    + "'" + pModelContaRecber.getDescricao() + "',"
                    + "'" + pModelContaRecber.getData() + "',"
                    + "'" + pModelContaRecber.getVencimento() + "',"
                    + "'" + pModelContaRecber.getPagamento() + "',"
                    + "'" + pModelContaRecber.getTipoPagamento() + "',"
                    + "'" + pModelContaRecber.getObservacao() + "',"
                    + "'" + pModelContaRecber.isSituacao() + "',"
                    + "'" + pModelContaRecber.getValor() + "'"
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
    public ContaReceber getContaPagarDAO(int pCodigo) {
        ContaReceber modelConta = new ContaReceber();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "clientes_codigo,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor"
                    + " FROM"
                    + " contas_receber"
                    + " WHERE"
                    + " pk_codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelConta.setCodigo(this.getResultSet().getInt(1));
                modelConta.setCodigoPessoa(this.getResultSet().getInt(2));
                modelConta.setDescricao(this.getResultSet().getString(3));
                modelConta.setData(this.getResultSet().getDate(4));
                modelConta.setVencimento(this.getResultSet().getDate(5));
                modelConta.setPagamento(this.getResultSet().getDate(6));
                modelConta.setTipoPagamento(this.getResultSet().getInt(7));
                modelConta.setObservacao(this.getResultSet().getString(8));
                modelConta.setSituacao(this.getResultSet().getInt(9));
                modelConta.setValor(this.getResultSet().getBigDecimal(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelConta;
    }

    /**
     * recupera uma lista de ContaPagar return ArrayList
     */
    public ArrayList<ContaReceber> getListaContaPagarDAO() {
        ArrayList<ContaReceber> listamodelConta = new ArrayList();
        ContaReceber modelContaReceber = new ContaReceber();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "clientes_codigo,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor"
                    + " FROM"
                    + " contas_receber"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelContaReceber = new ContaReceber();
                modelContaReceber.setCodigo(this.getResultSet().getInt(1));
                modelContaReceber.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaReceber.setDescricao(this.getResultSet().getString(3));
                modelContaReceber.setData(this.getResultSet().getDate(4));
                modelContaReceber.setVencimento(this.getResultSet().getDate(5));
                modelContaReceber.setPagamento(this.getResultSet().getDate(6));
                modelContaReceber.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaReceber.setObservacao(this.getResultSet().getString(8));
                modelContaReceber.setSituacao(this.getResultSet().getInt(9));
                modelContaReceber.setValor(this.getResultSet().getBigDecimal(10));
                listamodelConta.add(modelContaReceber);
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
    public ArrayList<ContaReceber> getListaContaPagarDAO(int pStatus) {
        ArrayList<ContaReceber> listamodelContaPagar = new ArrayList();
        ContaReceber modelContaReceber = new ContaReceber();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "clientes_codigo,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor "
                    + " FROM"
                    + " contas_receber where situacao = '" + pStatus + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelContaReceber = new ContaReceber();
                modelContaReceber.setCodigo(this.getResultSet().getInt(1));
                modelContaReceber.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaReceber.setDescricao(this.getResultSet().getString(3));
                modelContaReceber.setData(this.getResultSet().getDate(4));
                modelContaReceber.setVencimento(this.getResultSet().getDate(5));
                modelContaReceber.setPagamento(this.getResultSet().getDate(6));
                modelContaReceber.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaReceber.setObservacao(this.getResultSet().getString(8));
                modelContaReceber.setSituacao(this.getResultSet().getInt(9));
                modelContaReceber.setValor(this.getResultSet().getBigDecimal(10));
                listamodelContaPagar.add(modelContaReceber);
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
    public ArrayList<ContaReceber> getListaContaReceberDAO(int pStatus) {
        ArrayList<ContaReceber> listamodelContaReceber = new ArrayList();
        ContaReceber modelContaReceber = new ContaReceber();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "clientes_codigo,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor "
                    + " FROM"
                    + " contas_receber where situacao = '" + pStatus + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelContaReceber = new ContaReceber();
                modelContaReceber.setCodigo(this.getResultSet().getInt(1));
                modelContaReceber.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaReceber.setDescricao(this.getResultSet().getString(3));
                modelContaReceber.setData(this.getResultSet().getDate(4));
                modelContaReceber.setVencimento(this.getResultSet().getDate(5));
                modelContaReceber.setPagamento(this.getResultSet().getDate(6));
                modelContaReceber.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaReceber.setObservacao(this.getResultSet().getString(8));
                modelContaReceber.setSituacao(this.getResultSet().getInt(9));
                modelContaReceber.setValor(this.getResultSet().getBigDecimal(10));
                listamodelContaReceber.add(modelContaReceber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelContaReceber;
    }

    /**
     * recupera uma lista de ContaPagar return ArrayList
     */
    public ArrayList<ContaReceber> getListaContasDAO(int pStatus) {
        ArrayList<ContaReceber> listamodelContaReceber = new ArrayList();
        ContaReceber modelContaReceber = new ContaReceber();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "clientes_codigo,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor "
                    + " FROM"
                    + " contas_receber where situacao = '" + pStatus + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelContaReceber = new ContaReceber();
                modelContaReceber.setCodigo(this.getResultSet().getInt(1));
                modelContaReceber.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaReceber.setDescricao(this.getResultSet().getString(3));
                modelContaReceber.setData(this.getResultSet().getDate(4));
                modelContaReceber.setVencimento(this.getResultSet().getDate(5));
                modelContaReceber.setPagamento(this.getResultSet().getDate(6));
                modelContaReceber.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaReceber.setObservacao(this.getResultSet().getString(8));
                modelContaReceber.setSituacao(this.getResultSet().getInt(9));
                modelContaReceber.setValor(this.getResultSet().getBigDecimal(10));
                listamodelContaReceber.add(modelContaReceber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelContaReceber;
    }

    /**
     * recupera uma lista de ContaPagar por data return ArrayList
     */
    public ArrayList<ContaReceber> getListaContasDAO(ContaReceber pModelConta) {
        ArrayList<ContaReceber> listamodelContaPagar = new ArrayList();
        ContaReceber modelContaReceber = new ContaReceber();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "pk_codigo,"
                    + "clientes_codigo,"
                    + "descricao,"
                    + "data,"
                    + "vencimento,"
                    + "pagamento,"
                    + "fk_tipo_pagamento,"
                    + "observacao,"
                    + "situacao,"
                    + "valor "
                    + " FROM"
                    + " contas_receber "
                    + "WHERE "
                    + "(pagamento BETWEEN  '" + pModelConta.getData() + "' AND '" + pModelConta.getPagamento() + "') "
                    + "AND (situacao = '" + pModelConta.isSituacao() + "');"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelContaReceber = new ContaReceber();
                modelContaReceber.setCodigo(this.getResultSet().getInt(1));
                modelContaReceber.setCodigoPessoa(this.getResultSet().getInt(2));
                modelContaReceber.setDescricao(this.getResultSet().getString(3));
                modelContaReceber.setData(this.getResultSet().getDate(4));
                modelContaReceber.setVencimento(this.getResultSet().getDate(5));
                modelContaReceber.setPagamento(this.getResultSet().getDate(6));
                modelContaReceber.setTipoPagamento(this.getResultSet().getInt(7));
                modelContaReceber.setObservacao(this.getResultSet().getString(8));
                modelContaReceber.setSituacao(this.getResultSet().getInt(9));
                modelContaReceber.setValor(this.getResultSet().getBigDecimal(10));
                listamodelContaPagar.add(modelContaReceber);
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
     * @param pContaReceber return boolean
     */
    public boolean atualizarContaReceberDAO(ContaReceber pContaReceber) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE contas_receber SET "
                    + "pk_codigo = '" + pContaReceber.getCodigo() + "',"
                    + "clientes_codigo = '" + pContaReceber.getCodigoPessoa() + "',"
                    + "descricao = '" + pContaReceber.getDescricao() + "',"
                    + "data = '" + pContaReceber.getData() + "',"
                    + "vencimento = '" + pContaReceber.getVencimento() + "',"
                    + "pagamento = '" + pContaReceber.getPagamento() + "',"
                    + "fk_tipo_pagamento = '" + pContaReceber.getTipoPagamento() + "',"
                    + "observacao = '" + pContaReceber.getObservacao() + "',"
                    + "situacao = '" + pContaReceber.isSituacao() + "',"
                    + "valor = '" + pContaReceber.getValor() + "'"
                    + " WHERE "
                    + "pk_codigo = '" + pContaReceber.getCodigo() + "'"
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
    public boolean excluirContaReceberDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM contas_receber "
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

    public boolean receberContaReceberDAO(ContaReceber pContaReceber) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE contas_receber SET "
                    + "pagamento = '" + pContaReceber.getPagamento() + "',"
                    + "situacao = '" + pContaReceber.isSituacao() + "'"
                    + " WHERE "
                    + "pk_codigo = '" + pContaReceber.getCodigo() + "'"
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

