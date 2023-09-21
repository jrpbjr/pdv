/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.Cidade;
import com.inosystem.pdv.model.Estado;
import com.inosystem.pdv.model.Transportadora;
import com.inosystem.pdv.model.TransportadoraCidEst;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class TransportadoraCidEstDao extends ConexaoMySql {
    
public ArrayList<TransportadoraCidEst> getListaTransportadoraCidadeEstadoDAO() {
        ArrayList<TransportadoraCidEst> listaFornecedorCidadeEstado = new ArrayList();
        
        //TransportadoraCidEst modelTransportadoraCidadeEstado = new TransportadoraCidEst();        
        //Transportadora modelTransportadora = new Transportadora();
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
                    + "transportadora.codigo, "
                    + "transportadora.nome, "
                    + "transportadora.endereco, "
                    + "transportadora.bairro, "
                    + "transportadora.cod_cidade, "
                    + "transportadora.cep, "
                    + "transportadora.telefone,"
                    + "transportadora.nome_fantasia,"
                    + "transportadora.cnpj,"
                    + "transportadora.insc_estad "
                    + " FROM"
                    + " cidade inner join estado on estado.codigo = cidade.fk_cod_estado "
                    + " inner join transportadora on cidade.codigo = transportadora.cod_cidade"
                    + ";"
            );

            while (this.getResultSet().next()) {
                
                Cidade modelCidade = new Cidade();
                Estado modelEstado = new Estado();
                Transportadora modelTransportadora = new Transportadora();
                TransportadoraCidEst modelTransportadoraCidadeEstado = new TransportadoraCidEst();
                
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setNome(this.getResultSet().getString(2));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(3));
                modelEstado.setCodigo(this.getResultSet().getInt(4));
                modelEstado.setUf(this.getResultSet().getString(5));
                modelEstado.setNome(this.getResultSet().getString(6));
                modelTransportadora.setCodigo(this.getResultSet().getInt(7));
                modelTransportadora.setNome(this.getResultSet().getString(8));
                modelTransportadora.setEndereco(this.getResultSet().getString(9));
                modelTransportadora.setBairro(this.getResultSet().getString(10));
                modelTransportadora.setCodCidade(this.getResultSet().getInt(11));
                modelTransportadora.setCep(this.getResultSet().getString(12));
                modelTransportadora.setTelefone(this.getResultSet().getString(13));
                modelTransportadora.setNomeFantasia(this.getResultSet().getString(14));
                modelTransportadora.setCnpj(this.getResultSet().getString(15));
                modelTransportadora.setInscEstad(this.getResultSet().getString(16));

                modelTransportadoraCidadeEstado.setCidade(modelCidade);
                modelTransportadoraCidadeEstado.setEstado(modelEstado);
                modelTransportadoraCidadeEstado.setModelTransportadora(modelTransportadora);

                listaFornecedorCidadeEstado.add(modelTransportadoraCidadeEstado);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaFornecedorCidadeEstado;
    }
}
