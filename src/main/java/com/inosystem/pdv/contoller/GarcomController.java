/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.GarcomDao;
import com.inosystem.pdv.model.Garcom;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class GarcomController {
    
private GarcomDao daoGarcom = new GarcomDao();

    /**
    * grava Garcom
    * @param pGarcom
    * return int
    */
    public int salvarGarcomController(Garcom pGarcom){
        return this.daoGarcom.salvarGarcomDAO(pGarcom);
    }

    /**
    * recupera Garcom
    * @param pCodigo
    * return Garcom
    */
    public Garcom getGarcomController(int pCodigo){
        return this.daoGarcom.getGarcomDAO(pCodigo);
    }
    
    /**
    * recupera Garcom
    * @param pCodigo
    * return Garcom
    */
    public Garcom getGarcomController(String pNome){
        return this.daoGarcom.getGarcomDAO(pNome);
    }

    /**
    * recupera uma lista deGarcom
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<Garcom> getListaGarcomController(){
        return this.daoGarcom.getListaGarcomDAO();
    }

    /**
    * atualiza Garcom
    * @param pGarcom
    * return boolean
    */
    public boolean atualizarGarcomController(Garcom pGarcom){
        return this.daoGarcom.atualizarGarcomDAO(pGarcom);
    }

    /**
    * exclui Garcom
    * @param pCodigo
    * return boolean
    */
    public boolean excluirGarcomController(int pCodigo){
        return this.daoGarcom.excluirGarcomDAO(pCodigo);
    }
}
