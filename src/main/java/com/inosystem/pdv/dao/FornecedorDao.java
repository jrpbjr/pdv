/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.Fornecedor;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class FornecedorDao extends ConexaoMySql {
    
/**
     * grava Fornecedor
     *
     * @param pFornecedor return int
     */
    public int salvarFornecedorDAO(Fornecedor pFornecedor) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO fornecedores ("
                    + "nome,"
                    + "endereco,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cep,"
                    + "telefone,"
                    + "nome_fantasia,"
                    + "cnpj,"
                    + "insc_estad"
                    + ") VALUES ("
                    + "'" + pFornecedor.getNome() + "',"
                    + "'" + pFornecedor.getEndereco() + "',"
                    + "'" + pFornecedor.getBairro() + "',"
                    + "'" + pFornecedor.getCodCidade() + "',"
                    + "'" + pFornecedor.getCep() + "',"
                    + "'" + pFornecedor.getTelefone() + "',"
                    + "'" + pFornecedor.getNomeFantasia() + "',"
                    + "'" + pFornecedor.getCnpj() + "',"
                    + "'" + pFornecedor.getInscEstadual() + "'"
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
     * recupera Fornecedor
     *
     * @param pCodigo return Fornecedor
     */
    public Fornecedor getFornecedorDAO(int pCodigo) {
        Fornecedor modelFornecedor = new Fornecedor();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "endereco,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cep,"
                    + "telefone,"
                    + "nome_fantasia,"
                    + "cnpj,"
                    + "insc_estad"
                    + " FROM"
                    + " fornecedores"
                    + " WHERE"
                    + " codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelFornecedor.setCodigo(this.getResultSet().getInt(1));
                modelFornecedor.setNome(this.getResultSet().getString(2));
                modelFornecedor.setEndereco(this.getResultSet().getString(3));
                modelFornecedor.setBairro(this.getResultSet().getString(4));
                modelFornecedor.setCodCidade(this.getResultSet().getInt(5));
                modelFornecedor.setCep(this.getResultSet().getString(6));
                modelFornecedor.setTelefone(this.getResultSet().getString(7));
                modelFornecedor.setNomeFantasia(this.getResultSet().getString(8));
                modelFornecedor.setCnpj(this.getResultSet().getString(9));
                modelFornecedor.setInscEstadual(this.getResultSet().getString(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelFornecedor;
    }

    /**
     * recupera Fornecedor
     *
     * @param pCodigoProduto return Fornecedor
     */
    public Fornecedor getFornecedorProdutoDAO(int pCodigoProduto) {
        Fornecedor modelFornecedor = new Fornecedor();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "fornecedores.codigo, "
                    + "fornecedores.nome, "
                    + "fornecedores.endereco, "
                    + "fornecedores.bairro, "
                    + "fornecedores.cod_cidade, "
                    + "fornecedores.cep, "
                    + "fornecedores.telefone,"
                    + "fornecedores.nome_fantasia,"
                    + "fornecedores.cnpj,"
                    + "fornecedores.insc_estad "
                    + "FROM fornecedores INNER JOIN produtos "
                    + "ON produtos.fornecedores_codigo = fornecedores.codigo "
                    + "WHERE produtos.codigo =  '" + pCodigoProduto + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelFornecedor.setCodigo(this.getResultSet().getInt(1));
                modelFornecedor.setNome(this.getResultSet().getString(2));
                modelFornecedor.setEndereco(this.getResultSet().getString(3));
                modelFornecedor.setBairro(this.getResultSet().getString(4));
                modelFornecedor.setCodCidade(this.getResultSet().getInt(5));
                modelFornecedor.setCep(this.getResultSet().getString(6));
                modelFornecedor.setTelefone(this.getResultSet().getString(7));
                modelFornecedor.setNomeFantasia(this.getResultSet().getString(8));
                modelFornecedor.setCnpj(this.getResultSet().getString(9));
                modelFornecedor.setInscEstadual(this.getResultSet().getString(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelFornecedor;
    }

    /**
     * recupera Fornecedor
     *
     * @param pNome return Fornecedor
     */
    public Fornecedor getFornecedorDAO(String pNome) {
        Fornecedor modelFornecedor = new Fornecedor();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "endereco,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cep,"
                    + "telefone,"
                    + "nome_fantasia,"
                    + "cnpj,"
                    + "insc_estad"
                    + " FROM"
                    + " fornecedores"
                    + " WHERE"
                    + " nome = '" + pNome + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelFornecedor.setCodigo(this.getResultSet().getInt(1));
                modelFornecedor.setNome(this.getResultSet().getString(2));
                modelFornecedor.setEndereco(this.getResultSet().getString(3));
                modelFornecedor.setBairro(this.getResultSet().getString(4));
                modelFornecedor.setCodCidade(this.getResultSet().getInt(5));
                modelFornecedor.setCep(this.getResultSet().getString(6));
                modelFornecedor.setTelefone(this.getResultSet().getString(7));
                modelFornecedor.setNomeFantasia(this.getResultSet().getString(8));
                modelFornecedor.setCnpj(this.getResultSet().getString(9));
                modelFornecedor.setInscEstadual(this.getResultSet().getString(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelFornecedor;
    }

    /**
     * recupera uma lista de Fornecedor return ArrayList
     */
    public ArrayList<Fornecedor> getListaFornecedorDAO() {
        ArrayList<Fornecedor> listamodelFornecedor = new ArrayList();
        Fornecedor modelFornecedor = new Fornecedor();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "endereco,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cep,"
                    + "telefone,"
                    + "nome_fantasia,"
                    + "cnpj,"
                    + "insc_estad"
                    + " FROM"
                    + " fornecedores"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelFornecedor = new Fornecedor();
                modelFornecedor.setCodigo(this.getResultSet().getInt(1));
                modelFornecedor.setNome(this.getResultSet().getString(2));
                modelFornecedor.setEndereco(this.getResultSet().getString(3));
                modelFornecedor.setBairro(this.getResultSet().getString(4));
                modelFornecedor.setCodCidade(this.getResultSet().getInt(5));
                modelFornecedor.setCep(this.getResultSet().getString(6));
                modelFornecedor.setTelefone(this.getResultSet().getString(7));
                modelFornecedor.setNomeFantasia(this.getResultSet().getString(8));
                modelFornecedor.setCnpj(this.getResultSet().getString(9));
                modelFornecedor.setInscEstadual(this.getResultSet().getString(10));
                listamodelFornecedor.add(modelFornecedor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelFornecedor;
    }

    /**
     * atualiza Fornecedor
     *
     * @param pFornecedor return boolean
     */
    public boolean atualizarFornecedorDAO(Fornecedor pFornecedor) {
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE fornecedores SET "
                    + "codigo = '" + pFornecedor.getCodigo() + "',"
                    + "nome = '" + pFornecedor.getNome() + "',"
                    + "endereco = '" + pFornecedor.getEndereco() + "',"
                    + "bairro = '" + pFornecedor.getBairro() + "',"
                    + "cod_cidade = '" + pFornecedor.getCodCidade() + "',"
                    + "cep = '" + pFornecedor.getCep() + "',"
                    + "telefone = '" + pFornecedor.getTelefone() + "',"
                    + "nome_fantasia = '" + pFornecedor.getNomeFantasia()+ "',"
                    + "cnpj = '" + pFornecedor.getCnpj()+ "',"
                    + "insc_estad = '" + pFornecedor.getInscEstadual()+ "'"
                    + " WHERE "
                    + "codigo = '" + pFornecedor.getCodigo() + "'"
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
     * exclui Fornecedor
     *
     * @param pCodigo return boolean
     */
    public boolean excluirFornecedorDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM fornecedores "
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

