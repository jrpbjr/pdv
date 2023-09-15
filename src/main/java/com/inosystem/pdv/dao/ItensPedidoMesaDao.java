/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.ItensPedidoMesa;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class ItensPedidoMesaDao extends ConexaoMySql {
    
/**
     * grava ItensPedidoMesa
     *
     * @param pItensPedidoMesa return int
     */
    public int salvarItensPedidoMesaDAO(ItensPedidoMesa pItensPedidoMesa) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO itens_pedido_mesa ("
                    + "codigo,"
                    + "codigo_mesa,"
                    + "codigo_produto,"
                    + "status_pedido,"
                    + "observacao,"
                    + "quantidade "
                    + ") VALUES ("
                    + "'" + pItensPedidoMesa.getCodigo() + "',"
                    + "'" + pItensPedidoMesa.getCodigoMesa() + "',"
                    + "'" + pItensPedidoMesa.getCodigoProduto() + "',"
                    + "'" + pItensPedidoMesa.getStatusPedido() + "',"
                    + "'" + pItensPedidoMesa.getObservacao() + "',"
                    + "'" + pItensPedidoMesa.getQuantidade() + "'"
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
     * recupera ItensPedidoMesa
     *
     * @param pCodigo return ItensPedidoMesa
     */
    public ItensPedidoMesa getItensPedidoMesaDAO(int pCodigo) {
        ItensPedidoMesa modelItensPedidoMesa = new ItensPedidoMesa();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "codigo_mesa,"
                    + "codigo_produto,"
                    + "status_pedido,"
                    + "observacao,"
                    + "quantidade"
                    + " FROM"
                    + " itens_pedido_mesa"
                    + " WHERE"
                    + " codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelItensPedidoMesa.setCodigo(this.getResultSet().getInt(1));
                modelItensPedidoMesa.setCodigoMesa(this.getResultSet().getInt(2));
                modelItensPedidoMesa.setCodigoProduto(this.getResultSet().getInt(3));
                modelItensPedidoMesa.setStatusPedido(this.getResultSet().getString(4));
                modelItensPedidoMesa.setObservacao(this.getResultSet().getString(5));
                modelItensPedidoMesa.setQuantidade(this.getResultSet().getFloat(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelItensPedidoMesa;
    }

    /**
     * recupera uma lista de ItensPedidoMesa return ArrayList
     */
    public ArrayList<ItensPedidoMesa> getListaItensPedidoMesaDAO() {
        ArrayList<ItensPedidoMesa> listamodelItensPedidoMesa = new ArrayList();
        ItensPedidoMesa modelItensPedidoMesa = new ItensPedidoMesa();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "codigo_mesa,"
                    + "codigo_produto,"
                    + "status_pedido,"
                    + "observacao,"
                    + "quantidade "
                    + " FROM"
                    + " itens_pedido_mesa"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelItensPedidoMesa = new ItensPedidoMesa();
                modelItensPedidoMesa.setCodigo(this.getResultSet().getInt(1));
                modelItensPedidoMesa.setCodigoMesa(this.getResultSet().getInt(2));
                modelItensPedidoMesa.setCodigoProduto(this.getResultSet().getInt(3));
                modelItensPedidoMesa.setStatusPedido(this.getResultSet().getString(4));
                modelItensPedidoMesa.setObservacao(this.getResultSet().getString(5));
                modelItensPedidoMesa.setQuantidade(this.getResultSet().getFloat(6));
                listamodelItensPedidoMesa.add(modelItensPedidoMesa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelItensPedidoMesa;
    }

    /**
     * retorna uma lista de mesas ocupadas sem repetir
     */
    public ArrayList<Integer> getListaMesasOcupadasDAO() {
        ArrayList<Integer> listaNumeroMesas = new ArrayList<>();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT DISTINCT "
                    + "codigo_mesa "
                    + " FROM"
                    + " itens_pedido_mesa"
                    + ";"
            );

            while (this.getResultSet().next()) {
                listaNumeroMesas.add(this.getResultSet().getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaNumeroMesas;
    }

    /**
     * recupera uma lista de ItensPedidoMesa return ArrayList
     */
    public ArrayList<ItensPedidoMesa> getListaItensPedidoMesaCozinhaDAO() {
        ArrayList<ItensPedidoMesa> listamodelItensPedidoMesa = new ArrayList();
        ItensPedidoMesa modelItensPedidoMesa = new ItensPedidoMesa();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "codigo_mesa,"
                    + "codigo_produto,"
                    + "status_pedido,"
                    + "observacao,"
                    + "quantidade "
                    + " FROM"
                    + " itens_pedido_mesa "
                    + "WHERE status_pedido != 'Entregue'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelItensPedidoMesa = new ItensPedidoMesa();
                modelItensPedidoMesa.setCodigo(this.getResultSet().getInt(1));
                modelItensPedidoMesa.setCodigoMesa(this.getResultSet().getInt(2));
                modelItensPedidoMesa.setCodigoProduto(this.getResultSet().getInt(3));
                modelItensPedidoMesa.setStatusPedido(this.getResultSet().getString(4));
                modelItensPedidoMesa.setObservacao(this.getResultSet().getString(5));
                modelItensPedidoMesa.setQuantidade(this.getResultSet().getFloat(6));
                listamodelItensPedidoMesa.add(modelItensPedidoMesa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelItensPedidoMesa;
    }

    /**
     * recupera uma lista de ItensPedidoMesa return ArrayList
     */
    public ArrayList<ItensPedidoMesa> getListaItensPedidoMesaDAO(int pCodigo) {
        ArrayList<ItensPedidoMesa> listamodelItensPedidoMesa = new ArrayList();
        ItensPedidoMesa modelItensPedidoMesa = new ItensPedidoMesa();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT itens_pedido_mesa.codigo, "
                    + "codigo_mesa, "
                    + "codigo_produto, "
                    + "status_pedido, "
                    + "observacao, "
                    + "quantidade "
                    + "FROM itens_pedido_mesa "
                    + "where codigo_mesa = '" + pCodigo + "'"
            );

            while (this.getResultSet().next()) {
                modelItensPedidoMesa = new ItensPedidoMesa();
                modelItensPedidoMesa.setCodigo(this.getResultSet().getInt(1));
                modelItensPedidoMesa.setCodigoMesa(this.getResultSet().getInt(2));
                modelItensPedidoMesa.setCodigoProduto(this.getResultSet().getInt(3));
                modelItensPedidoMesa.setStatusPedido(this.getResultSet().getString(4));
                modelItensPedidoMesa.setObservacao(this.getResultSet().getString(5));
                modelItensPedidoMesa.setQuantidade(this.getResultSet().getFloat(6));
                listamodelItensPedidoMesa.add(modelItensPedidoMesa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelItensPedidoMesa;
    }

    /**
     * atualiza ItensPedidoMesa
     *
     * @param pItensPedidoMesa return boolean
     */
    public boolean atualizarItensPedidoMesaDAO(ItensPedidoMesa pItensPedidoMesa) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE itens_pedido_mesa SET "
                    + "codigo = '" + pItensPedidoMesa.getCodigo() + "',"
                    + "codigo_mesa = '" + pItensPedidoMesa.getCodigoMesa() + "',"
                    + "codigo_produto = '" + pItensPedidoMesa.getCodigoProduto() + "',"
                    + "status_pedido = '" + pItensPedidoMesa.getStatusPedido() + "',"
                    + "observacao = '" + pItensPedidoMesa.getObservacao() + "',"
                    + "quantidade = '" + pItensPedidoMesa.getQuantidade() + "'"
                    + " WHERE "
                    + "codigo = '" + pItensPedidoMesa.getCodigo() + "'"
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
     * atualiza status itens
     *
     * @param pItensPedidoMesa return boolean
     */
    public boolean atualizarStatusItemDAO(ItensPedidoMesa pItensPedidoMesa) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE itens_pedido_mesa SET "
                    + "status_pedido = '" + pItensPedidoMesa.getStatusPedido() + "'"
                    + " WHERE "
                    + "codigo = '" + pItensPedidoMesa.getCodigo() + "'"
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
     * exclui ItensPedidoMesa
     *
     * @param pCodigo return boolean
     */
    public boolean excluirItensPedidoMesaDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM itens_pedido_mesa "
                    + " WHERE "
                    + "codigo_mesa = '" + pCodigo + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean salvarItensPedidoMesaDAO(ArrayList<ItensPedidoMesa> pListaItensPedidoMesas) {
        try {
            this.conectar();
            int sizeLista = pListaItensPedidoMesas.size();
            for (int i = 0; i < sizeLista; i++) {
                this.insertSQL(
                        "INSERT INTO itens_pedido_mesa ("
                        + "codigo_mesa,"
                        + "codigo_produto,"
                        + "quantidade, "
                        + "observacao, "
                        + "horario, "
                        + "codigo_garcom, "
                        + "status_pedido "
                        + ") VALUES ("
                        + "'" + pListaItensPedidoMesas.get(i).getCodigoMesa() + "',"
                        + "'" + pListaItensPedidoMesas.get(i).getCodigoProduto() + "',"
                        + "'" + pListaItensPedidoMesas.get(i).getQuantidade() + "',"
                        + "'" + pListaItensPedidoMesas.get(i).getObservacao() + "',"
                        + "'" + pListaItensPedidoMesas.get(i).getHora() + "',"
                        + "'" + pListaItensPedidoMesas.get(i).getCodigoGarcom() + "',"
                        + "'" + pListaItensPedidoMesas.get(i).getStatusPedido()+ "'"
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
}

