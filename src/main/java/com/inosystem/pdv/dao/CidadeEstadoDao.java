/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.Cidade;
import com.inosystem.pdv.model.CidadeEstado;
import com.inosystem.pdv.model.Estado;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class CidadeEstadoDao extends ConexaoMySql {
    
/**
     * recupera uma lista de CidadeEstado return ArrayList
     */
    public ArrayList<CidadeEstado> getListaCidadeEstadoDAO() {
        ArrayList<CidadeEstado> listamodelCidadeEstado = new ArrayList();
        
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "cidade.codigo,"
                    + "cidade.codigo_ibge,"
                    + "cidade.nome,"
                    + "cidade.fk_cod_estado,"
                    + "estado.codigo,"
                    + "estado.uf,"
                    + "estado.nome "
                    + " FROM"
                    + " cidade inner join estado on estado.codigo = cidade.fk_cod_estado"
                    + ";"
            );

            while (this.getResultSet().next()) {
                
               Cidade modelCidade = new Cidade();
               Estado modelEstado = new Estado();
               CidadeEstado modelCidadeEstado = new CidadeEstado();
                
                modelCidade.setCodigo(this.getResultSet().getInt(1));
                modelCidade.setCodigoIBGE(this.getResultSet().getInt(2));
                modelCidade.setNome(this.getResultSet().getString(3));
                modelCidade.setFk_cod_estado(this.getResultSet().getInt(4));
                modelEstado.setCodigo(this.getResultSet().getInt(5));
                modelEstado.setUf(this.getResultSet().getString(6));
                modelEstado.setNome(this.getResultSet().getString(7));
                modelCidadeEstado.setCidade(modelCidade);
                modelCidadeEstado.setEstado(modelEstado);
                listamodelCidadeEstado.add(modelCidadeEstado);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelCidadeEstado;
    }

}