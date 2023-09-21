/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.EmpresaCidadeEstadoDao;
import com.inosystem.pdv.model.EmpresaCidadeEstado;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class EmpresaCidadeEstadoController {
    
private final EmpresaCidadeEstadoDao daoEmpresaCidadeEstado = new EmpresaCidadeEstadoDao();

    /**
    * recupera EmpresaCidadeEstado
    * @param pCidade
    * return EmpresaCidadeEstadoDao
    */
    public EmpresaCidadeEstado getEmpresaCidadeEstadoController(int pCodigo){
        return this.daoEmpresaCidadeEstado.getEmpresaCidadeEstadoDAO(pCodigo);
        
        
    }

    /**
    * recupera uma lista deEmpresaCidadeEstado
    * @param pCidade
    * return ArrayList
    */
    public ArrayList<EmpresaCidadeEstado> getListaEmpresaCidadeEstadoController(){
        return this.daoEmpresaCidadeEstado.getListaEmpresaCidadeEstadoDAO();
    }
}
