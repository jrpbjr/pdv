/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.Cidade;
import com.inosystem.pdv.model.Cliente;
import com.inosystem.pdv.model.ClienteCidadeEstado;
import com.inosystem.pdv.model.Estado;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class ClienteCidadeEstadoDao extends ConexaoMySql {

    /**
     * recupera uma lista de CidadeEstado return ArrayList
     */
    public ArrayList<ClienteCidadeEstado> getListaClienteCidadeEstadoDAO() {
        ArrayList<ClienteCidadeEstado> listaClienteCidadeEstados = new ArrayList();
        ClienteCidadeEstado modelClienteCidadeEstado = new ClienteCidadeEstado();
        //Cliente modelCliente = new Cliente();
        //Cidade modelCidade = new Cidade();
        //Estado modelEstado = new Estado();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "cidade.codigo,"
                    + "cidade.nome,"
                    + "cidade.fk_cod_estado,"
                    + "estado.codigo,"
                    + "estado.uf,"
                    + "estado.nome,"
                    + "clientes.codigo, "
                    + "clientes.nome, "
                    + "clientes.endereco, "
                    + "clientes.bairro, "
                    + "clientes.cod_cidade, "
                    + "estado.codigo, "
                    + "clientes.cep, "
                    + "clientes.telefone, "
                    + "clientes.cpf_cnpj, "
                    + "clientes.observacao, "
                    + "clientes.ativo, "
                    + "clientes.tipo_pessoa, "
                    + "clientes.nome_fantasia "
                    + " FROM"
                    + " cidade inner join estado on estado.codigo = cidade.fk_cod_estado "
                    + " inner join clientes on cidade.codigo = clientes.cod_cidade"
                    + ";"
            );

            while (this.getResultSet().next()) {
                Cidade modelCidade = new Cidade();
                Estado modelEstado = new Estado();
                Cliente modelCliente = new Cliente();

                modelClienteCidadeEstado = new ClienteCidadeEstado();
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setNome(this.getResultSet().getString(2));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(3));
                modelEstado.setCodigo(this.getResultSet().getInt(4));
                modelEstado.setUf(this.getResultSet().getString(5));
                modelEstado.setNome(this.getResultSet().getString(6));
                modelCliente.setCodigo(this.getResultSet().getInt(7));
                modelCliente.setNome(this.getResultSet().getString(8));
                modelCliente.setEndereco(this.getResultSet().getString(9));
                modelCliente.setBairro(this.getResultSet().getString(10));
                modelCliente.setCodCidade(this.getResultSet().getInt(11));
                modelCliente.setCodEstado(this.getResultSet().getInt(12));
                modelCliente.setCep(this.getResultSet().getString(13));
                modelCliente.setTelefone(this.getResultSet().getString(14));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(15));
                modelCliente.setObservacao(this.getResultSet().getString(16));
                modelCliente.setAtivo(this.getResultSet().getInt(17));
                modelCliente.setTipoPessoa(this.getResultSet().getString(18));
                modelCliente.setNomeFantasia(this.getResultSet().getString(19));

                modelClienteCidadeEstado.setCidade(modelCidade);
                modelClienteCidadeEstado.setEstado(modelEstado);
                modelClienteCidadeEstado.setCliente(modelCliente);

                listaClienteCidadeEstados.add(modelClienteCidadeEstado);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaClienteCidadeEstados;
    }

    public ClienteCidadeEstado getClienteCidadeEstadoDAO(String pNome) {

        ClienteCidadeEstado modelClienteCidadeEstado = new ClienteCidadeEstado();      
        //Cliente modelCliente = new Cliente();
        //Cidade modelCidade = new Cidade();
        //Estado modelEstado = new Estado();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "cidade.codigo,"
                    + "cidade.nome,"
                    + "cidade.fk_cod_estado,"
                    + "estado.codigo,"
                    + "estado.uf,"
                    + "estado.nome,"
                    + "clientes.codigo, "
                    + "clientes.nome, "
                    + "clientes.endereco, "
                    + "clientes.bairro, "
                    + "clientes.cod_cidade, "
                    + "estado.codigo, "
                    + "clientes.cep, "
                    + "clientes.telefone, "
                    + "clientes.cpf_cnpj, "
                    + "clientes.observacao, "
                    + "clientes.ativo, "
                    + "clientes.tipo_pessoa, "
                    + "clientes.nome_fantasia "
                    + " FROM"
                    + " cidade inner join estado on estado.codigo = cidade.fk_cod_estado "
                    + " inner join clientes on cidade.codigo = clientes.cod_cidade"
                    + " WHERE"
                    + " clientes.nome = '" + pNome + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                Cidade modelCidade = new Cidade();
                Estado modelEstado = new Estado();
                Cliente modelCliente = new Cliente();
                //ClienteCidadeEstado modelClienteCidadeEstado = new ClienteCidadeEstado();

                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setNome(this.getResultSet().getString(2));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(3));
                modelEstado.setCodigo(this.getResultSet().getInt(4));
                modelEstado.setUf(this.getResultSet().getString(5));
                modelEstado.setNome(this.getResultSet().getString(6));
                modelCliente.setCodigo(this.getResultSet().getInt(7));
                modelCliente.setNome(this.getResultSet().getString(8));
                modelCliente.setEndereco(this.getResultSet().getString(9));
                modelCliente.setBairro(this.getResultSet().getString(10));
                modelCliente.setCodCidade(this.getResultSet().getInt(11));
                modelCliente.setCodEstado(this.getResultSet().getInt(12));
                modelCliente.setCep(this.getResultSet().getString(13));
                modelCliente.setTelefone(this.getResultSet().getString(14));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(15));
                modelCliente.setObservacao(this.getResultSet().getString(16));
                modelCliente.setAtivo(this.getResultSet().getInt(17));
                modelCliente.setTipoPessoa(this.getResultSet().getString(18));
                modelCliente.setNomeFantasia(this.getResultSet().getString(19));

                modelClienteCidadeEstado.setCidade(modelCidade);
                modelClienteCidadeEstado.setEstado(modelEstado);
                modelClienteCidadeEstado.setCliente(modelCliente);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelClienteCidadeEstado;
    }

    public ClienteCidadeEstado getClienteCidadeEstadoDAO(int pCodigo) {

        ClienteCidadeEstado modelClienteCidadeEstado = new ClienteCidadeEstado();
        //Cliente modelCliente = new Cliente();
        //Cidade modelCidade = new Cidade();
        //Estado modelEstado = new Estado();
        try {
            this.conectar();

            String sql = "SELECT "
                    + "cidade.codigo,"
                    + "cidade.nome,"
                    + "cidade.fk_cod_estado,"
                    + "estado.codigo,"
                    + "estado.uf,"
                    + "estado.nome,"
                    + "clientes.codigo, "
                    + "clientes.nome, "
                    + "clientes.endereco, "
                    + "clientes.bairro, "
                    + "clientes.cod_cidade, "
                    + "estado.codigo, "
                    + "clientes.cep, "
                    + "clientes.telefone, "
                    + "clientes.cpf_cnpj, "
                    + "clientes.observacao, "
                    + "clientes.ativo, "
                    + "clientes.tipo_pessoa, "
                    + "clientes.nome_fantasia "
                    + " FROM"
                    + " cidade inner join estado on estado.codigo = cidade.fk_cod_estado "
                    + " inner join clientes on cidade.codigo = clientes.cod_cidade"
                    + " WHERE"
                    + " clientes.codigo = '" + pCodigo + "'"
                    + ";";

            this.executarSQL(
                    sql
            );

            while (this.getResultSet().next()) {
                Cidade modelCidade = new Cidade();
                Estado modelEstado = new Estado();
                Cliente modelCliente = new Cliente();
                //ClienteCidadeEstado modelClienteCidadeEstado = new ClienteCidadeEstado();

                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setNome(this.getResultSet().getString(2));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(3));
                modelEstado.setCodigo(this.getResultSet().getInt(4));
                modelEstado.setUf(this.getResultSet().getString(5));
                modelEstado.setNome(this.getResultSet().getString(6));
                modelCliente.setCodigo(this.getResultSet().getInt(7));
                modelCliente.setNome(this.getResultSet().getString(8));
                modelCliente.setEndereco(this.getResultSet().getString(9));
                modelCliente.setBairro(this.getResultSet().getString(10));
                modelCliente.setCodCidade(this.getResultSet().getInt(11));
                modelCliente.setCodEstado(this.getResultSet().getInt(12));
                modelCliente.setCep(this.getResultSet().getString(13));
                modelCliente.setTelefone(this.getResultSet().getString(14));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(15));
                modelCliente.setObservacao(this.getResultSet().getString(16));
                modelCliente.setAtivo(this.getResultSet().getInt(17));
                modelCliente.setTipoPessoa(this.getResultSet().getString(18));
                modelCliente.setNomeFantasia(this.getResultSet().getString(19));

                modelClienteCidadeEstado.setCidade(modelCidade);
                modelClienteCidadeEstado.setEstado(modelEstado);
                modelClienteCidadeEstado.setCliente(modelCliente);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelClienteCidadeEstado;
    }

    public ClienteCidadeEstado getClienteCidadeEstadoPorTelefoneDAO(String pTelefone) {
        
        ClienteCidadeEstado modelClienteCidadeEstado = new ClienteCidadeEstado();
        //Cliente modelCliente = new Cliente();
        //Cidade modelCidade = new Cidade();
        //Estado modelEstado = new Estado();
        
        try {            
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "cidade.codigo,"
                    + "cidade.nome,"
                    + "cidade.fk_cod_estado,"
                    + "estado.codigo,"
                    + "estado.uf,"
                    + "estado.nome,"
                    + "clientes.codigo, "
                    + "clientes.nome, "
                    + "clientes.endereco, "
                    + "clientes.bairro, "
                    + "clientes.cod_cidade, "
                    + "estado.codigo, "
                    + "clientes.cep, "
                    + "clientes.telefone, "
                    + "clientes.cpf_cnpj, "
                    + "clientes.observacao, "
                    + "clientes.ativo, "
                    + "clientes.tipo_pessoa, "
                    + "clientes.nome_fantasia "
                    + " FROM"
                    + " cidade inner join estado on estado.codigo = cidade.fk_cod_estado "
                    + " inner join clientes on cidade.codigo = clientes.cod_cidade"
                    + " WHERE"
                    + " clientes.telefone = '" + pTelefone + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                Cidade modelCidade = new Cidade();
                Estado modelEstado = new Estado();
                Cliente modelCliente = new Cliente();
                //ClienteCidadeEstado modelClienteCidadeEstado = new ClienteCidadeEstado();
                
                
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setNome(this.getResultSet().getString(2));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(3));
                modelEstado.setCodigo(this.getResultSet().getInt(4));
                modelEstado.setUf(this.getResultSet().getString(5));
                modelEstado.setNome(this.getResultSet().getString(6));
                modelCliente.setCodigo(this.getResultSet().getInt(7));
                modelCliente.setNome(this.getResultSet().getString(8));
                modelCliente.setEndereco(this.getResultSet().getString(9));
                modelCliente.setBairro(this.getResultSet().getString(10));
                modelCliente.setCodCidade(this.getResultSet().getInt(11));
                modelCliente.setCodEstado(this.getResultSet().getInt(12));
                modelCliente.setCep(this.getResultSet().getString(13));
                modelCliente.setTelefone(this.getResultSet().getString(14));
                modelCliente.setCpfCNPJ(this.getResultSet().getString(15));
                modelCliente.setObservacao(this.getResultSet().getString(16));
                modelCliente.setAtivo(this.getResultSet().getInt(17));
                modelCliente.setTipoPessoa(this.getResultSet().getString(18));
                modelCliente.setNomeFantasia(this.getResultSet().getString(19));

                modelClienteCidadeEstado.setCidade(modelCidade);
                modelClienteCidadeEstado.setEstado(modelEstado);
                modelClienteCidadeEstado.setCliente(modelCliente);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelClienteCidadeEstado;
    }

}
