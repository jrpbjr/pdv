/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.TotalMesasDao;
import com.inosystem.pdv.model.TotalMesa;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class TotalMesaController {
    
private TotalMesasDao daoTotalMesa = new TotalMesasDao();

    /**
    * grava TotalMesa
    * @param pTotalMesa
    * return int
    */
    public int salvarTotalMesaController(TotalMesa pTotalMesa){
        return this.daoTotalMesa.salvarTotalMesasDAO(pTotalMesa);
    }

    /**
    * recupera TotalMesa
    * @param pCodigo
    * return TotalMesa
    */
    public TotalMesa getTotalMesaController(int pCodigo){
        return this.daoTotalMesa.getTotalMesasDAO(pCodigo); 
    }

    /**
    * recupera uma lista deTotalMesa
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<TotalMesa> getListaTotalMesaController(){
        return this.daoTotalMesa.getListaTotalMesasDAO(); 
    }

    /**
    * atualiza TotalMesa
    * @param pTotalMesa
    * return boolean
    */
    public boolean atualizarTotalMesaController(TotalMesa pTotalMesa){
        return this.daoTotalMesa.atualizarTotalMesasDAO(pTotalMesa);
    }

    /**
    * exclui TotalMesa
    * @param pCodigo
    * return boolean
    */
    public boolean excluirTotalMesaController(int pCodigo){
        return this.daoTotalMesa.excluirTotalMesasDAO(pCodigo);
    }
}
