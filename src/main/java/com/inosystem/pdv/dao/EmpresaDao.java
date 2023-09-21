/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.Cidade;
import com.inosystem.pdv.model.Empresa;
import com.inosystem.pdv.model.EmpresaCidadeEstado;
import com.inosystem.pdv.model.Estado;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class EmpresaDao extends ConexaoMySql {
    
/**
     * grava Empresa
     *
     * @param pEmpresa return int
     */
    public int salvarEmpresaDAO(Empresa pEmpresa) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO empresa ("
                    + "codigo,"
                    + "razao_social,"
                    + "nome_fantasia,"
                    + "endereco,"
                    + "endereco_numero,"
                    + "complemento,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cod_estado,"
                    + "cod_pais,"
                    + "cep,"
                    + "telefone, "
                    + "isnc_estad, "
                    + "cnpj, "
                    + "crt "
                    + ") VALUES ("
                    + "'" + pEmpresa.getCodigo() + "',"
                    + "'" + pEmpresa.getRazaoSocial() + "',"
                    + "'" + pEmpresa.getNomeFantasia() + "',"
                    + "'" + pEmpresa.getEndereco() + "',"
                    + "'" + pEmpresa.getEnderecoNumero() + "',"
                    + "'" + pEmpresa.getEnderecoComplemento() + "',"
                    + "'" + pEmpresa.getBairro() + "',"
                    + "'" + pEmpresa.getCodCidade() + "',"
                    + "'" + pEmpresa.getCodEstado() + "',"
                    + "'" + pEmpresa.getCodPais() + "',"
                    + "'" + pEmpresa.getCep() + "',"
                    + "'" + pEmpresa.getTelefone() + "',"
                    + "'" + pEmpresa.getInscEstad() + "',"
                    + "'" + pEmpresa.getCnpj() + "'"
                    + "'" + pEmpresa.getCrt() + "'"
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
     * recupera Empresa
     *
     * @param pCodigo return Empresa
     */
    public EmpresaCidadeEstado getEmpresaDAO(int pCodigo) {
        EmpresaCidadeEstado modelEmpresaCidadeEstado = new EmpresaCidadeEstado();  
        
        //Cidade modelCidade = new Cidade();
        //Estado modelEstado = new Estado();
        //Empresa modelEmpresa = new Empresa();
        
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "     empresa.codigo AS empresa_codigo, "
                    + "     empresa.razao_social AS empresa_razao_social, "
                    + "     empresa.nome_fantasia AS empresa_nome_fantasia, "
                    + "     empresa.endereco AS empresa_endereco, "
                    + "     empresa.endereco_numero AS empresa_endereco_numero, "
                    + "     empresa.complemento AS empresa_complemento, "
                    + "     empresa.bairro AS empresa_bairro, "
                    + "     empresa.cod_pais AS empresa_cod_pais, "
                    + "     empresa.cep AS empresa_cep, "
                    + "     empresa.telefone AS empresa_telefone, "
                    + "     empresa.insc_estad AS empresa_isnc_estad, "
                    + "     empresa.cnpj AS empresa_cnpj, "
                    + "     empresa.crt AS empresa_crt, "
                    + "     cidade.nome AS cidade_nome, "
                    + "     estado.uf AS estado_uf "
                    + "FROM "
                    + "     cidade cidade INNER JOIN empresa empresa ON cidade.codigo = empresa.cod_cidade "
                    + "     INNER JOIN estado estado ON cidade.fk_cod_estado = estado.codigo "
                    + " WHERE "
                    + " empresa.codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                
                Cidade modelCidade = new Cidade();
                Estado modelEstado = new Estado();
                Empresa modelEmpresa = new Empresa();
                
                //modelEmpresaCidadeEstado = new EmpresaCidadeEstado();
                
                modelEmpresa.setCodigo(this.getResultSet().getInt(1));
                modelEmpresa.setRazaoSocial(this.getResultSet().getString(2));
                modelEmpresa.setNomeFantasia(this.getResultSet().getString(3));
                modelEmpresa.setEndereco(this.getResultSet().getString(4));
                modelEmpresa.setEnderecoNumero(this.getResultSet().getString(5));
                modelEmpresa.setEnderecoComplemento(this.getResultSet().getString(6));
                modelEmpresa.setBairro(this.getResultSet().getString(7));
                modelEmpresa.setCodPais(this.getResultSet().getInt(8));
                modelEmpresa.setCep(this.getResultSet().getString(9));
                modelEmpresa.setTelefone(this.getResultSet().getString(10));
                modelEmpresa.setInscEstad(this.getResultSet().getString(11));
                modelEmpresa.setCnpj(this.getResultSet().getString(12));
                modelEmpresa.setCrt(this.getResultSet().getString(13));
                modelCidade.setNome(this.getResultSet().getString(14));
                modelEstado.setUf(this.getResultSet().getString(15));
                modelEmpresaCidadeEstado.setCidade(modelCidade);
                modelEmpresaCidadeEstado.setEstado(modelEstado);
                modelEmpresaCidadeEstado.setEmpresa(modelEmpresa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelEmpresaCidadeEstado;
    }
    
    /**
     * recupera Empresa
     * @param pNome
     * @return EmpresaCidadeEstado
     */
    public EmpresaCidadeEstado getEmpresaDAO(String pNome) {
        EmpresaCidadeEstado modelEmpresaCidadeEstado = new EmpresaCidadeEstado();
        
        //Cidade modelCidade = new Cidade();
        //Estado modelEstado = new Estado();
        //Empresa modelEmpresa = new Empresa();
        
        
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "     empresa.codigo AS empresa_codigo, "
                    + "     empresa.razao_social AS empresa_razao_social, "
                    + "     empresa.nome_fantasia AS empresa_nome_fantasia, "
                    + "     empresa.endereco AS empresa_endereco, "
                    + "     empresa.endereco_numero AS empresa_endereco_numero, "
                    + "     empresa.complemento AS empresa_complemento, "
                    + "     empresa.bairro AS empresa_bairro, "
                    + "     empresa.cod_pais AS empresa_cod_pais, "
                    + "     empresa.cep AS empresa_cep, "
                    + "     empresa.telefone AS empresa_telefone, "
                    + "     empresa.insc_estad AS empresa_isnc_estad, "
                    + "     empresa.cnpj AS empresa_cnpj, "
                    + "     empresa.crt AS empresa_crt, "
                    + "     cidade.nome AS cidade_nome, "
                    + "     estado.uf AS estado_uf "
                    + "FROM "
                    + "     cidade cidade INNER JOIN empresa empresa ON cidade.codigo = empresa.cod_cidade "
                    + "     INNER JOIN estado estado ON cidade.fk_cod_estado = estado.codigo "
                    + " WHERE "
                    + " empresa.razao_social = '" + pNome + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                
                Cidade modelCidade = new Cidade();
                Estado modelEstado = new Estado();
                Empresa modelEmpresa = new Empresa();
                
                //modelEmpresaCidadeEstado = new EmpresaCidadeEstado();
                
                
                modelEmpresa.setCodigo(this.getResultSet().getInt(1));
                modelEmpresa.setRazaoSocial(this.getResultSet().getString(2));
                modelEmpresa.setNomeFantasia(this.getResultSet().getString(3));
                modelEmpresa.setEndereco(this.getResultSet().getString(4));
                modelEmpresa.setEnderecoNumero(this.getResultSet().getString(5));
                modelEmpresa.setEnderecoComplemento(this.getResultSet().getString(6));
                modelEmpresa.setBairro(this.getResultSet().getString(7));
                modelEmpresa.setCodPais(this.getResultSet().getInt(8));
                modelEmpresa.setCep(this.getResultSet().getString(9));
                modelEmpresa.setTelefone(this.getResultSet().getString(10));
                modelEmpresa.setInscEstad(this.getResultSet().getString(11));
                modelEmpresa.setCnpj(this.getResultSet().getString(12));
                modelEmpresa.setCrt(this.getResultSet().getString(13));
                modelCidade.setNome(this.getResultSet().getString(14));
                modelEstado.setUf(this.getResultSet().getString(15));
                modelEmpresaCidadeEstado.setCidade(modelCidade);
                modelEmpresaCidadeEstado.setEstado(modelEstado);
                modelEmpresaCidadeEstado.setEmpresa(modelEmpresa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelEmpresaCidadeEstado;
    }

    /**
     * recupera uma lista de Empresa return ArrayList
     */
    public ArrayList<Empresa> getListaEmpresaDAO() {
        ArrayList<Empresa> listamodelEmpresa = new ArrayList();
        Empresa modelEmpresa = new Empresa();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "codigo,"
                    + "razao_social,"
                    + "nome_fantasia,"
                    + "endereco,"
                    + "endereco_numero,"
                    + "complemento,"
                    + "bairro,"
                    + "cod_cidade,"
                    + "cod_pais,"
                    + "cep,"
                    + "telefone, "
                    + "insc_estad, "
                    + "cnpj, "
                    + "crt "
                    + " FROM"
                    + " empresa"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelEmpresa = new Empresa();
                modelEmpresa.setCodigo(this.getResultSet().getInt(1));
                modelEmpresa.setRazaoSocial(this.getResultSet().getString(2));
                modelEmpresa.setNomeFantasia(this.getResultSet().getString(3));
                modelEmpresa.setEndereco(this.getResultSet().getString(4));
                modelEmpresa.setEnderecoNumero(this.getResultSet().getString(5));
                modelEmpresa.setEnderecoComplemento(this.getResultSet().getString(6));
                modelEmpresa.setBairro(this.getResultSet().getString(7));
                modelEmpresa.setCodCidade(this.getResultSet().getInt(8));
                modelEmpresa.setCodPais(this.getResultSet().getInt(9));
                modelEmpresa.setCep(this.getResultSet().getString(10));
                modelEmpresa.setTelefone(this.getResultSet().getString(11));
                modelEmpresa.setInscEstad(this.getResultSet().getString(12));
                modelEmpresa.setCnpj(this.getResultSet().getString(13));
                modelEmpresa.setCrt(this.getResultSet().getString(14));
                listamodelEmpresa.add(modelEmpresa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelEmpresa;
    }

    /**
     * atualiza Empresa
     *
     * @param pEmpresa return boolean
     */
    public boolean atualizarEmpresaDAO(Empresa pEmpresa) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE empresa SET "
                    + "razao_social = '" + pEmpresa.getRazaoSocial() + "',"
                    + "nome_fantasia = '" + pEmpresa.getNomeFantasia() + "',"
                    + "endereco = '" + pEmpresa.getEndereco() + "',"
                    + "endereco_numero = '" + pEmpresa.getEnderecoNumero() + "',"
                    + "complemento = '" + pEmpresa.getEnderecoComplemento() + "',"
                    + "bairro = '" + pEmpresa.getBairro() + "',"
                    + "cod_cidade = '" + pEmpresa.getCodCidade() + "',"
                    + "cod_pais = '" + pEmpresa.getCodPais() + "',"
                    + "cep = '" + pEmpresa.getCep() + "',"
                    + "telefone = '" + pEmpresa.getTelefone() + "',"
                    + "cnpj = '" + pEmpresa.getCnpj() + "',"
                    + "insc_estad = '" + pEmpresa.getInscEstad() + "',"
                    + "crt = '" + pEmpresa.getCrt() + "'"
                    + " WHERE "
                    + "codigo = '" + pEmpresa.getCodigo() + "'"
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
     * exclui Empresa
     *
     * @param pCodigo return boolean
     */
    public boolean excluirEmpresaDAO(int pCodigo) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM empresa "
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

