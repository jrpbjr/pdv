/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.Venda;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class VendaDao extends ConexaoMySql {
    
 /**
     * grava Vendas
     *
     * @param pVenda return int
     */
    public int salvarVendasDAO(Venda pVenda) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO vendas ("
                    + "clientes_codigo,"
                    + "data_venda,"
                    + "valor_total,"
                    + "desconto, "
                    + "tipo_pagamento, "
                    + "tipo, "
                    + "observacao, "
                    + "codigo_usuario, "
                    + "taxa_entrega "
                    + ") VALUES ("
                    + "'" + pVenda.getClientesCodigo() + "',"
                    + "'" + pVenda.getDataVenda() + "',"
                    + "'" + pVenda.getValorTotal() + "',"
                    + "'" + pVenda.getDesconto() + "',"
                    + "'" + pVenda.getTipoPagamento() + "',"
                    + "'" + pVenda.getTipo() + "',"
                    + "'" + pVenda.getObservacao() + "',"
                    + "'" + pVenda.getCodigoUsuario() + "',"
                    + "'" + pVenda.getTaxaEntrega() + "'"
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
     * grava Vendas
     *
     * @param pVenda return int
     */
    public boolean salvarProdutosVendasDAO(Venda pVenda) {
        try {
            this.conectar();
            int sizeLista = pVenda.getListamModelVendases().size();
            for (int i = 0; i < sizeLista; i++) {
                this.insertSQL(
                        "insert into VENDAS_PRODUTO( "
                        + "CODIGO_PRODUTO,"
                        + "CODIGO_VENDA,"
                        + "QUANTIDADE, "
                        + "VALOR_UNITARIO) "
                        + " VALUES ("
                        + "'" + pVenda.getListamModelVendases().get(i).getProdutosCodigo() + "',"
                        + "'" + pVenda.getCodigo() + "',"
                        + "'" + pVenda.getListamModelVendases().get(i).getQuantidade() + "',"
                        + "'" + pVenda.getListamModelVendases().get(i).getValor() + "'"
                        + ");"
                );
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera Vendas
     *
     * @param pCodigo return Venda
     */
    public Venda getVendasDAO(int pCodigo) {
        Venda modelVendas = new Venda();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "valor_total,"
                    + "clientes_codigo,"
                    + "data_venda,"
                    + "desconto, "
                    + "tipo_pagamento, "
                    + "tipo, "
                    + "observacao, "
                    + "codigo_usuario, "
                    + "taxa_entrega "
                    + " FROM"
                    + " vendas"
                    + " WHERE"
                    + " codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendas.setCodigo(this.getResultSet().getInt(1));
                modelVendas.setValorTotal(this.getResultSet().getBigDecimal(2));
                modelVendas.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas.setDataVenda(this.getResultSet().getDate(4));
                modelVendas.setDesconto(this.getResultSet().getBigDecimal(5));
                modelVendas.setTipoPagamento(this.getResultSet().getInt(6));
                modelVendas.setTipo(this.getResultSet().getInt(7));
                modelVendas.setObservacao(this.getResultSet().getString(8));
                modelVendas.setCodigoUsuario(this.getResultSet().getInt(9));
                modelVendas.setTaxaEntrega(this.getResultSet().getBigDecimal(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelVendas;
    }

    /**
     * recupera uma lista de pedidos return ArrayList
     */
    public ArrayList<Venda> getListaPedidosDAO() {
        ArrayList<Venda> listamodelVendas = new ArrayList();
        Venda modelVendas = new Venda();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "valor_total,"
                    + "clientes_codigo,"
                    + "data_venda,"
                    + "desconto, "
                    + "tipo_pagamento, "
                    + "tipo, "
                    + "observacao, "
                    + "codigo_usuario, "
                    + "taxa_entrega "
                    + " FROM"
                    + " vendas "
                    + "WHERE tipo = 1"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendas = new Venda();
                modelVendas.setCodigo(this.getResultSet().getInt(1));
                modelVendas.setValorTotal(this.getResultSet().getBigDecimal(2));
                modelVendas.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas.setDataVenda(this.getResultSet().getDate(4));
                modelVendas.setDesconto(this.getResultSet().getBigDecimal(5));
                modelVendas.setTipoPagamento(this.getResultSet().getInt(6));
                modelVendas.setTipo(this.getResultSet().getInt(7));
                modelVendas.setObservacao(this.getResultSet().getString(8));
                modelVendas.setCodigoUsuario(this.getResultSet().getInt(9));
                modelVendas.setTaxaEntrega(this.getResultSet().getBigDecimal(10));
                listamodelVendas.add(modelVendas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /**
     * recupera uma lista de orcamentos return ArrayList
     */
    public ArrayList<Venda> getListaOrcamentoDAO() {
        ArrayList<Venda> listamodelVendas = new ArrayList();
        Venda modelVendas = new Venda();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "valor_total,"
                    + "clientes_codigo,"
                    + "data_venda,"
                    + "desconto, "
                    + "tipo_pagamento, "
                    + "tipo, "
                    + "observacao,"
                    + "codigo_usuario, "
                    + "taxa_entrega "
                    + " FROM"
                    + " vendas "
                    + "WHERE tipo = 0"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendas = new Venda();
                modelVendas.setCodigo(this.getResultSet().getInt(1));
                modelVendas.setValorTotal(this.getResultSet().getBigDecimal(2));
                modelVendas.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas.setDataVenda(this.getResultSet().getDate(4));
                modelVendas.setDesconto(this.getResultSet().getBigDecimal(5));
                modelVendas.setTipoPagamento(this.getResultSet().getInt(6));
                modelVendas.setTipo(this.getResultSet().getInt(7));
                modelVendas.setObservacao(this.getResultSet().getString(8));
                modelVendas.setCodigoUsuario(this.getResultSet().getInt(9));
                modelVendas.setTaxaEntrega(this.getResultSet().getBigDecimal(10));
                listamodelVendas.add(modelVendas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /**
     * recupera uma lista de Vendas return ArrayList
     */
    public ArrayList<Venda> getListaVendasDAO(int pCodigo) {
        ArrayList<Venda> listamodelVendas = new ArrayList();
        Venda modelVendas = new Venda();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo_produto,"
                    + "codigo_venda,"
                    + "quantidade, "
                    + "valor_unitario "
                    + " FROM "
                    + " vendas_produto WHERE codigo_venda = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendas = new Venda();
                modelVendas.setProdutosCodigo(this.getResultSet().getInt(1));
                modelVendas.setCodigo(this.getResultSet().getInt(2));
                modelVendas.setQuantidade(this.getResultSet().getBigDecimal(3));
                modelVendas.setValor(this.getResultSet().getBigDecimal(4));
                listamodelVendas.add(modelVendas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /**
     * recupera uma lista de Vendas return ArrayList
     */
    public ArrayList<Venda> getListaPedidosDAO(Venda pVenda) {
        ArrayList<Venda> listamodelVendas = new ArrayList();
        Venda modelVendas = new Venda();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "valor_total,"
                    + "clientes_codigo,"
                    + "data_venda,"
                    + "desconto, "
                    + "tipo_pagamento,"
                    + "tipo,"
                    + "observacao, "
                    + "codigo_usuario, "
                    + "taxa_entrega "
                    + " FROM "
                    + " vendas "
                    + "WHERE "
                    + "(data_venda BETWEEN  '" + pVenda.getDataVenda() + "' AND '" + pVenda.getDataPagamento() + "') "
                    + "AND tipo = '1';"
            );

            while (this.getResultSet().next()) {
                modelVendas = new Venda();
                modelVendas.setCodigo(this.getResultSet().getInt(1));
                modelVendas.setValorTotal(this.getResultSet().getBigDecimal(2));
                modelVendas.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas.setDataVenda(this.getResultSet().getDate(4));
                modelVendas.setDesconto(this.getResultSet().getBigDecimal(5));
                modelVendas.setTipoPagamento(this.getResultSet().getInt(6));
                modelVendas.setTipo(this.getResultSet().getInt(7));
                modelVendas.setObservacao(this.getResultSet().getString(8));
                modelVendas.setCodigoUsuario(this.getResultSet().getInt(9));
                modelVendas.setTaxaEntrega(this.getResultSet().getBigDecimal(10));
                listamodelVendas.add(modelVendas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /**
     * recupera uma lista de Vendas return ArrayList
     */
    public ArrayList<Venda> getListaOrcamentoDAO(Venda pVenda) {
        ArrayList<Venda> listamodelVendas = new ArrayList();
        Venda modelVendas = new Venda();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "valor_total,"
                    + "clientes_codigo,"
                    + "data_venda,"
                    + "desconto, "
                    + "tipo_pagamento,"
                    + "tipo,"
                    + "observacao, "
                    + "codigo_usuario, "
                    + "taxa_entrega "        
                    + " FROM"
                    + " vendas"
                    + " WHERE"
                    + " data_venda = '" + pVenda.getDataVenda() + "' AND tipo = 0"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendas = new Venda();
                modelVendas.setCodigo(this.getResultSet().getInt(1));
                modelVendas.setValorTotal(this.getResultSet().getBigDecimal(2));
                modelVendas.setClientesCodigo(this.getResultSet().getInt(3));
                modelVendas.setDataVenda(this.getResultSet().getDate(4));
                modelVendas.setDesconto(this.getResultSet().getBigDecimal(5));
                modelVendas.setTipoPagamento(this.getResultSet().getInt(6));
                modelVendas.setTipo(this.getResultSet().getInt(7));
                modelVendas.setObservacao(this.getResultSet().getString(8));
                modelVendas.setCodigoUsuario(this.getResultSet().getInt(9));
                modelVendas.setTaxaEntrega(this.getResultSet().getBigDecimal(10));
                listamodelVendas.add(modelVendas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /**
     * atualiza Vendas
     *
     * @param pVenda return boolean
     */
    public boolean atualizarVendasDAO(Venda pVenda) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE vendas SET "
                    + "codigo = '" + pVenda.getCodigo() + "',"
                    + "valor_total = '" + pVenda.getValorTotal() + "',"
                    + "clientes_codigo = '" + pVenda.getClientesCodigo() + "',"
                    + "data_venda = '" + pVenda.getDataVenda() + "',"
                    + "desconto = '" + pVenda.getDesconto() + "',"
                    + "tipo_pagamento = '" + pVenda.getTipoPagamento() + "',"
                    + "tipo = '" + pVenda.getTipo() + "',"
                    + "observacao = '" + pVenda.getObservacao() + "',"
                    + "codigo_usuario = '" + pVenda.getCodigoUsuario() + "',"
                    + "taxa_entrega = '" + pVenda.getTaxaEntrega()+ "'"
                    + " WHERE "
                    + "codigo = '" + pVenda.getCodigo() + "'"
                    + ";"
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * desaprovar Vendas
     *
     * @param pCodigo return boolean
     */
    public boolean desaprovarPedidoDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE vendas SET "
                    + "tipo = 0 "
                    + " WHERE "
                    + "codigo = '" + pCodigo + "'"
                    + ";"
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui Vendas
     *
     * @param pCodigo return boolean
     */
    public boolean excluirVendasDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM vendas "
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

    public boolean excluirProdutoVendasDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "DELETE FROM vendas_produto WHERE "
                    + "codigo_venda = '" + pCodigo + "'"
                    + ";"
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera uma lista de Vendas return ArrayList
     */
    public ArrayList<Venda> getListaVendasProdutosDAO(int pCodigo) {
        ArrayList<Venda> listamodelVendas = new ArrayList();
        Venda modelVendas = new Venda();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo_produto,"
                    + "codigo_venda,"
                    + "quantidade "
                    + " FROM "
                    + " vendas_produto WHERE codigo_venda = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendas = new Venda();
                modelVendas.setProdutosCodigo(this.getResultSet().getInt(1));
                modelVendas.setCodigo(this.getResultSet().getInt(2));
                modelVendas.setQuantidade(this.getResultSet().getBigDecimal(3));
                listamodelVendas.add(modelVendas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelVendas;
    }

}

