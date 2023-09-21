/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.Cliente;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class ClienteDao extends ConexaoMySql {
    
/**
     * grava Cliente
     *
     * @param pCliente return int
     */
    public int salvarClienteDAO(Cliente pCliente) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO clientes ("
                    + "nome,"
                    + "nome_fantasia,"
                    + "endereco,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cep,"
                    + "telefone,"
                    + "cpf_cnpj,"
                    + "observacao, "
                    + "ativo, "
                    + "tipo_pessoa "
                    + ") VALUES ("
                    + "'" + pCliente.getNome() + "',"
                    + "'" + pCliente.getNomeFantasia() + "',"
                    + "'" + pCliente.getEndereco() + "',"
                    + "'" + pCliente.getBairro() + "',"
                    + "'" + pCliente.getCodCidade() + "',"
                    + "'" + pCliente.getCep() + "',"
                    + "'" + pCliente.getTelefone() + "',"
                    + "'" + pCliente.getCpfCNPJ() + "',"
                    + "'" + pCliente.getObservacao() + "',"
                    + "'" + pCliente.getAtivo() + "',"
                    + "'" + pCliente.getTipoPessoa() + "'"
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
     * recupera Cliente
     *
     * @param pCodigo return Cliente
     */
    public Cliente getClienteDAO(int pCodigo) {
        Cliente modelCliente = new Cliente();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "nome_fantasia,"
                    + "endereco,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cep,"
                    + "telefone,"
                    + "cpf_cnpj,"
                    + "observacao, "
                    + "ativo, "
                    + "tipo_pessoa "
                    + " FROM"
                    + " clientes"
                    + " WHERE"
                    + " codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCliente.setCodigo(this.getResultSet().getInt(1));
                modelCliente.setNome(this.getResultSet().getString(2));
                modelCliente.setNomeFantasia(this.getResultSet().getString(3));
                modelCliente.setEndereco(this.getResultSet().getString(4));
                modelCliente.setBairro(this.getResultSet().getString(5));
                modelCliente.setCodCidade(this.getResultSet().getInt(6));
                modelCliente.setCep(this.getResultSet().getString(7));
                modelCliente.setTelefone(this.getResultSet().getString(8));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(9));
                modelCliente.setObservacao(this.getResultSet().getString(10));
                modelCliente.setAtivo(this.getResultSet().getInt(11));
                modelCliente.setTipoPessoa(this.getResultSet().getString(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCliente;
    }

    /**
     * recupera Cliente
     *
     * @param pNome return Cliente
     */
    public Cliente getClienteDAO(String pNome) {
        Cliente modelCliente = new Cliente();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "nome_fantasia,"
                    + "endereco,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cep,"
                    + "telefone,"
                    + "cpf_cnpj,"
                    + "observacao, "
                    + "ativo, "
                    + "tipo_pessoa "
                    + " FROM"
                    + " clientes"
                    + " WHERE"
                    + " nome = '" + pNome + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCliente.setCodigo(this.getResultSet().getInt(1));
                modelCliente.setNome(this.getResultSet().getString(2));
                modelCliente.setNomeFantasia(this.getResultSet().getString(3));
                modelCliente.setEndereco(this.getResultSet().getString(4));
                modelCliente.setBairro(this.getResultSet().getString(5));
                modelCliente.setCodCidade(this.getResultSet().getInt(6));
                modelCliente.setCep(this.getResultSet().getString(7));
                modelCliente.setTelefone(this.getResultSet().getString(8));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(9));
                modelCliente.setObservacao(this.getResultSet().getString(10));
                modelCliente.setAtivo(this.getResultSet().getInt(11));
                modelCliente.setTipoPessoa(this.getResultSet().getString(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelCliente;
    }

    /**
     * recupera uma lista de Cliente return ArrayList
     */
    public ArrayList<Cliente> getListaClienteDAO() {
        ArrayList<Cliente> listamodelCliente = new ArrayList();
        Cliente modelCliente = new Cliente();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "nome_fantasia,"
                    + "endereco,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cep,"
                    + "telefone,"
                    + "cpf_cnpj,"
                    + "observacao, "
                    + "ativo, "
                    + "tipo_pessoa "
                    + " FROM"
                    + " clientes"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCliente = new Cliente();
                modelCliente.setCodigo(this.getResultSet().getInt(1));
                modelCliente.setNome(this.getResultSet().getString(2));
                modelCliente.setNomeFantasia(this.getResultSet().getString(3));
                modelCliente.setEndereco(this.getResultSet().getString(4));
                modelCliente.setBairro(this.getResultSet().getString(5));
                modelCliente.setCodCidade(this.getResultSet().getInt(6));
                modelCliente.setCep(this.getResultSet().getString(7));
                modelCliente.setTelefone(this.getResultSet().getString(8));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(9));
                modelCliente.setObservacao(this.getResultSet().getString(10));
                modelCliente.setAtivo(this.getResultSet().getInt(11));
                modelCliente.setTipoPessoa(this.getResultSet().getString(12));
                listamodelCliente.add(modelCliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelCliente;
    }

    /**
     * recupera uma lista de Cliente return ArrayList
     */
    public ArrayList<Cliente> getListaClienteAtivoDAO() {
        ArrayList<Cliente> listamodelCliente = new ArrayList();
        Cliente modelCliente = new Cliente();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "nome_fantasia,"
                    + "endereco,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cep,"
                    + "telefone,"
                    + "cpf_cnpj,"
                    + "observacao, "
                    + "ativo, "
                    + "tipo_pessoa "
                    + " FROM"
                    + " clientes WHERE ativo = 1"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelCliente = new Cliente();
                modelCliente.setCodigo(this.getResultSet().getInt(1));
                modelCliente.setNome(this.getResultSet().getString(2));
                modelCliente.setNomeFantasia(this.getResultSet().getString(3));
                modelCliente.setEndereco(this.getResultSet().getString(4));
                modelCliente.setBairro(this.getResultSet().getString(5));
                modelCliente.setCodCidade(this.getResultSet().getInt(6));
                modelCliente.setCep(this.getResultSet().getString(7));
                modelCliente.setTelefone(this.getResultSet().getString(8));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(9));
                modelCliente.setObservacao(this.getResultSet().getString(10));
                modelCliente.setAtivo(this.getResultSet().getInt(11));
                modelCliente.setTipoPessoa(this.getResultSet().getString(12));
                listamodelCliente.add(modelCliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelCliente;
    }

    /**
     * atualiza Cliente
     *
     * @param pCliente return boolean
     */
    public boolean atualizarClienteDAO(Cliente pCliente) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE clientes SET "
                    + "nome = '" + pCliente.getNome() + "',"
                    + "nome_fantasia = '" + pCliente.getNomeFantasia() + "',"
                    + "endereco = '" + pCliente.getEndereco() + "',"
                    + "bairro = '" + pCliente.getBairro() + "',"
                    + "cod_cidade = '" + pCliente.getCodCidade() + "',"
                    + "cep = '" + pCliente.getCep() + "',"
                    + "telefone = '" + pCliente.getTelefone() + "',"
                    + "cpf_cnpj = '" + pCliente.getCpfCNPJ() + "',"
                    + "observacao = '" + pCliente.getObservacao() + "',"
                    + "ativo = '" + pCliente.getAtivo() + "',"
                    + "tipo_pessoa = '" + pCliente.getTipoPessoa() + "'"
                    + " WHERE "
                    + "codigo = '" + pCliente.getCodigo() + "'"
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
     * exclui Cliente
     *
     * @param pCodigo return boolean
     */
    public boolean excluirClienteDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM clientes "
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

    public boolean atualizarEnderecoClienteDAO(Cliente pCliente) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE clientes SET "
                    + "nome = '" + pCliente.getNome() + "',"
                    + "endereco = '" + pCliente.getEndereco() + "',"
                    + "bairro = '" + pCliente.getBairro() + "',"
                    + "cod_cidade = '" + pCliente.getCodCidade() + "',"
                    + "cep = '" + pCliente.getCep() + "',"
                    + "telefone = '" + pCliente.getTelefone() + "'"
                    + " WHERE "
                    + "codigo = '" + pCliente.getCodigo() + "'"
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
}
