/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.Cidade;
import com.inosystem.pdv.model.Estado;
import com.inosystem.pdv.model.Fornecedor;
import com.inosystem.pdv.model.FornecedorCidadeEstado;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class FornecedorCidadeEstadoDao extends ConexaoMySql {
    
/**
     * recupera uma lista de CidadeEstado return ArrayList
     */
    public ArrayList<FornecedorCidadeEstado> getListaFornecedorCidadeEstadoDAO() {
        
        ArrayList<FornecedorCidadeEstado> listaFornecedorCidadeEstado = new ArrayList();    
        
        FornecedorCidadeEstado modelFornecedorCidadeEstado = new FornecedorCidadeEstado();
        //Fornecedor modelFornecedor = new Fornecedor();
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
                    + "fornecedores.codigo, "
                    + "fornecedores.nome, "
                    + "fornecedores.endereco, "
                    + "fornecedores.bairro, "
                    + "fornecedores.cod_cidade, "
                    + "estado.codigo, "
                    + "fornecedores.cep, "
                    + "fornecedores.telefone,"
                    + "fornecedores.nome_fantasia,"
                    + "fornecedores.cnpj,"
                    + "fornecedores.insc_estad "
                    + " FROM"
                    + " cidade inner join estado on estado.codigo = cidade.fk_cod_estado "
                    + " inner join fornecedores on cidade.codigo = fornecedores.cod_cidade"
                    + ";"
            );

            while (this.getResultSet().next()) {
                
                Cidade modelCidade = new Cidade();
                Estado modelEstado = new Estado();
                Fornecedor modelFornecedor = new Fornecedor();
                
                ///modelFornecedorCidadeEstado = new FornecedorCidadeEstado();
                
                
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setNome(this.getResultSet().getString(2));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(3));
                modelEstado.setCodigo(this.getResultSet().getInt(4));
                modelEstado.setUf(this.getResultSet().getString(5));
                modelEstado.setNome(this.getResultSet().getString(6));
                modelFornecedor.setCodigo(this.getResultSet().getInt(7));
                modelFornecedor.setNome(this.getResultSet().getString(8));
                modelFornecedor.setEndereco(this.getResultSet().getString(9));
                modelFornecedor.setBairro(this.getResultSet().getString(10));
                modelFornecedor.setCodCidade(this.getResultSet().getInt(11));
                modelFornecedor.setCodEstado(this.getResultSet().getInt(12));
                modelFornecedor.setCep(this.getResultSet().getString(13));
                modelFornecedor.setTelefone(this.getResultSet().getString(14));
                modelFornecedor.setNomeFantasia(this.getResultSet().getString(15));
                modelFornecedor.setCnpj(this.getResultSet().getString(16));
                modelFornecedor.setInscEstadual(this.getResultSet().getString(17));

                modelFornecedorCidadeEstado.setModelCidade(modelCidade);
                modelFornecedorCidadeEstado.setModelEstado(modelEstado);
                modelFornecedorCidadeEstado.setModelFornecedor(modelFornecedor);

                listaFornecedorCidadeEstado.add(modelFornecedorCidadeEstado);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaFornecedorCidadeEstado;
    }

}

