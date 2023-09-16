/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.FornecedorCidadeEstadoDao;
import com.inosystem.pdv.model.FornecedorCidadeEstado;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class FornecedorCidadeEstadoController {
    
private FornecedorCidadeEstadoDao dAOFornecedorCidadeEstado = new FornecedorCidadeEstadoDao();

    /**
    * recupera uma lista de fornecedores estado cidade
    * @param
    * return ArrayList
    */
    public ArrayList<FornecedorCidadeEstado> getlistaFornecedorCidadeEstados(){
        return this.dAOFornecedorCidadeEstado.getListaFornecedorCidadeEstadoDAO();
    }
}
