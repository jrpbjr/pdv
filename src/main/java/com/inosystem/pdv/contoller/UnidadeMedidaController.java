/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.UnidadeMediaDao;
import com.inosystem.pdv.model.UnidadeMedida;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class UnidadeMedidaController {
    
private UnidadeMediaDao daoUnidadeMedia = new UnidadeMediaDao();

    /**
    * grava UnidadeMedida
    * @param pUnidadeMedia
    * return int
    */
    public int salvarUnidadeMediaController(UnidadeMedida pUnidadeMedia){
        return this.daoUnidadeMedia.salvarUnidadeMediaDAO(pUnidadeMedia);
    }

    /**
    * recupera UnidadeMedida
    * @param pCodigo
    * return UnidadeMedida
    */
    public UnidadeMedida getUnidadeMediaController(int pCodigo){
        return this.daoUnidadeMedia.getUnidadeMediaDAO(pCodigo);
    }
    
    /**
    * recupera UnidadeMedida
    * @param pCodigo
    * return UnidadeMedida
    */
    public UnidadeMedida getUnidadeMediaController(String pNome){
        return this.daoUnidadeMedia.getUnidadeMediaDAO(pNome);
    }

    /**
    * recupera uma lista deUnidadeMedia
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<UnidadeMedida> getListaUnidadeMediaController(){
        return this.daoUnidadeMedia.getListaUnidadeMediaDAO();
    }

    /**
    * atualiza UnidadeMedida
    * @param pUnidadeMedia
    * return boolean
    */
    public boolean atualizarUnidadeMediaController(UnidadeMedida pUnidadeMedia){
        return this.daoUnidadeMedia.atualizarUnidadeMediaDAO(pUnidadeMedia);
    }

    /**
    * exclui UnidadeMedida
    * @param pCodigo
    * return boolean
    */
    public boolean excluirUnidadeMediaController(int pCodigo){
        return this.daoUnidadeMedia.excluirUnidadeMediaDAO(pCodigo);
    }
}
