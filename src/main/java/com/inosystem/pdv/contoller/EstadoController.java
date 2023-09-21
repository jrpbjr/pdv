/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.EstadoDao;
import com.inosystem.pdv.model.Estado;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class EstadoController {
    
private EstadoDao daoEstado = new EstadoDao();

    /**
    * grava Estado
    * @param pEstado
    * return int
    */
    public int salvarEstadoController(Estado pEstado){
        return this.daoEstado.salvarEstadoDAO(pEstado);
    }

    /**
    * recupera Estado
    * @param pCodigo
    * return Estado
    */
    public Estado getEstadoController(int pCodigo){
        return this.daoEstado.getEstadoDAO(pCodigo);
    }
    
    
    /**
    * recupera Estado
    * @param pNome
    * return Estado
    */
    public Estado getEstadoController(String pNome){
        return this.daoEstado.getEstadoDAO(pNome);
    }

    /**
    * recupera Estado
    * @param pNome
    * return Estado
    */
    public Estado getEstadoUFController(String pUF){
        return this.daoEstado.getEstadoUFDAO(pUF);
    }
    
    /**
    * recupera uma lista deEstado
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<Estado> getListaEstadoController(){
        return this.daoEstado.getListaEstadoDAO();
    }

    /**
    * atualiza Estado
    * @param pEstado
    * return boolean
    */
    public boolean atualizarEstadoController(Estado pEstado){
        return this.daoEstado.atualizarEstadoDAO(pEstado);
    }

    /**
    * exclui Estado
    * @param pCodigo
    * return boolean
    */
    public boolean excluirEstadoController(int pCodigo){
        return this.daoEstado.excluirEstadoDAO(pCodigo);
    }
}
