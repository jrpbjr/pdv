/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.CidadeEstadoDao;
import com.inosystem.pdv.model.CidadeEstado;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class CidadeEstadoController {
    
private CidadeEstadoDao daoCidadeEstado = new CidadeEstadoDao();

    /**
    * recupera uma lista deCidadeEstado
    * @param pModelCidade
    * return ArrayList
    */
    public ArrayList<CidadeEstado> getListaCidadeEstadoController(){
        return this.daoCidadeEstado.getListaCidadeEstadoDAO();
    }
}
