/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.CfopDao;
import com.inosystem.pdv.model.Cfop;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class CfopController {
    
private CfopDao daoCFOP = new CfopDao();

    /**
    * grava CFOP
    * @param pCfop
    * return int
    */
    public int salvarCFOPController(Cfop pCfop){
        return this.daoCFOP.salvarCFOPDAO(pCfop);
    }

    /**
    * recupera CFOP
    * @param pCodigo
    * return Cfop
    */
    public Cfop getCFOPController(int pCodigo){
        return this.daoCFOP.getCFOPDAO(pCodigo);
    }

    /**
    * recupera uma lista deCFOP
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<Cfop> getListaCFOPController(){
        return this.daoCFOP.getListaCFOPDAO();
    }

    /**
    * atualiza CFOP
    * @param pCfop
    * return boolean
    */
    public boolean atualizarCFOPController(Cfop pCfop){
        return this.daoCFOP.atualizarCFOPDAO(pCfop);
    }

    /**
    * exclui CFOP
    * @param pCodigo
    * return boolean
    */
    public boolean excluirCFOPController(int pCodigo){
        return this.daoCFOP.excluirCFOPDAO(pCodigo);
    }
}
