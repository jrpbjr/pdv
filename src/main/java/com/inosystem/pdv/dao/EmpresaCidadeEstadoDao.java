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
public class EmpresaCidadeEstadoDao extends ConexaoMySql {

    /**
     * recupera EmpresaCidadeEstado
     *
     * @param pCidade return EmpresaCidadeEstado
     */
    public EmpresaCidadeEstado getEmpresaCidadeEstadoDAO(int pCodigo) {
        EmpresaCidadeEstado modelEmpresaCidadeEstado = new EmpresaCidadeEstado();

        //Cidade modelCidade = new Cidade();
        //Estado modelEstado = new Estado();
        //Empresa modelEmpresa = new Empresa();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT cidade.codigo,"
                    + "cidade.nome,"
                    + "cidade.fk_cod_estado, "
                    + "estado.codigo, "
                    + "estado.uf, "
                    + "estado.nome, "
                    + "empresa.codigo,"
                    + "empresa.razao_social,"
                    + "empresa.nome_fantasia,"
                    + "empresa.endereco,"
                    + "empresa.bairro,"
                    + "empresa.cod_cidade,"
                    + "empresa.cep,"
                    + "empresa.telefone, "
                    + "empresa.cnpj "
                    + "FROM "
                    + "cidade inner join estado on estado.codigo = cidade.fk_cod_estado "
                    + "inner join empresa on cidade.codigo = empresa.cod_cidade "
                    + " WHERE "
                    + " empresa.codigo = '" + pCodigo + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {

                Cidade modelCidade = new Cidade();
                Estado modelEstado = new Estado();
                Empresa modelEmpresa = new Empresa();

                //modelEmpresaCidadeEstado = new EmpresaCidadeEstado();
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setNome(this.getResultSet().getString(2));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(3));
                modelEstado.setCodigo(this.getResultSet().getInt(4));
                modelEstado.setUf(this.getResultSet().getString(5));
                modelEstado.setNome(this.getResultSet().getString(6));
                modelEmpresa.setCodigo(this.getResultSet().getInt(7));
                modelEmpresa.setRazaoSocial(this.getResultSet().getString(8));
                modelEmpresa.setNomeFantasia(this.getResultSet().getString(9));
                modelEmpresa.setEndereco(this.getResultSet().getString(10));
                modelEmpresa.setBairro(this.getResultSet().getString(11));
                modelEmpresa.setCodCidade(this.getResultSet().getInt(12));
                modelEmpresa.setCep(this.getResultSet().getString(13));
                modelEmpresa.setTelefone(this.getResultSet().getString(14));
                modelEmpresa.setCnpj(this.getResultSet().getString(15));
                modelEmpresaCidadeEstado.setCidade(modelCidade);
                modelEmpresaCidadeEstado.setestado(modelEstado);
                modelEmpresaCidadeEstado.setModelEmpresa(modelEmpresa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelEmpresaCidadeEstado;
    }

    /**
     * recupera uma lista de EmpresaCidadeEstado return ArrayList
     */
    public ArrayList<EmpresaCidadeEstado> getListaEmpresaCidadeEstadoDAO() {
        ArrayList<EmpresaCidadeEstado> listamodelEmpresaCidadeEstado = new ArrayList();
        
        EmpresaCidadeEstado modelEmpresaCidadeEstado = new EmpresaCidadeEstado();
                
        //Cidade modelCidade = new Cidade();
        //Estado modelEstado = new Estado();
        //Empresa modelEmpresa = new Empresa();
        
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT cidade.codigo,"
                    + "cidade.nome,"
                    + "cidade.fk_cod_estado, "
                    + "estado.codigo, "
                    + "estado.uf, "
                    + "estado.nome, "
                    + "empresa.codigo,"
                    + "empresa.razao_social,"
                    + "empresa.nome_fantasia,"
                    + "empresa.endereco,"
                    + "empresa.bairro,"
                    + "empresa.cod_cidade,"
                    + "empresa.cod_estado,"
                    + "empresa.cep,"
                    + "empresa.telefone "
                    + "FROM "
                    + "cidade inner join estado on estado.codigo = cidade.fk_cod_estado "
                    + "inner join empresa on cidade.codigo = empresa.cod_cidade "
                    + ";"
            );

            while (this.getResultSet().next()) {
                
                Cidade modelCidade = new Cidade();
                Estado modelEstado = new Estado();
                Empresa modelEmpresa = new Empresa();
               // modelEmpresaCidadeEstado = new EmpresaCidadeEstado();
               
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setNome(this.getResultSet().getString(2));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(3));
                modelEstado.setCodigo(this.getResultSet().getInt(4));
                modelEstado.setUf(this.getResultSet().getString(5));
                modelEstado.setNome(this.getResultSet().getString(6));
                modelEmpresa.setCodigo(this.getResultSet().getInt(1));
                modelEmpresa.setRazaoSocial(this.getResultSet().getString(2));
                modelEmpresa.setNomeFantasia(this.getResultSet().getString(3));
                modelEmpresa.setEndereco(this.getResultSet().getString(4));
                modelEmpresa.setBairro(this.getResultSet().getString(5));
                modelEmpresa.setCodCidade(this.getResultSet().getInt(6));
                modelEmpresa.setCodEstado(this.getResultSet().getInt(7));
                modelEmpresa.setCep(this.getResultSet().getString(8));
                modelEmpresa.setTelefone(this.getResultSet().getString(9));
                modelEmpresaCidadeEstado.setCidade(modelCidade);
                modelEmpresaCidadeEstado.setestado(modelEstado);
                modelEmpresaCidadeEstado.setModelEmpresa(modelEmpresa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelEmpresaCidadeEstado;
    }
}
