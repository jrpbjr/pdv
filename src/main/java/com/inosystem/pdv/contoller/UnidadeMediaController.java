/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.UnidadeMediaDao;
import com.inosystem.pdv.model.UnidadeMedia;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class UnidadeMediaController {
    
private UnidadeMediaDao daoUnidadeMedia = new UnidadeMediaDao();

    /**
    * grava UnidadeMedia
    * @param pUnidadeMedia
    * return int
    */
    public int salvarUnidadeMediaController(UnidadeMedia pUnidadeMedia){
        return this.daoUnidadeMedia.salvarUnidadeMediaDAO(pUnidadeMedia);
    }

    /**
    * recupera UnidadeMedia
    * @param pCodigo
    * return UnidadeMedia
    */
    public UnidadeMedia getUnidadeMediaController(int pCodigo){
        return this.daoUnidadeMedia.getUnidadeMediaDAO(pCodigo);
    }
    
    /**
    * recupera UnidadeMedia
    * @param pCodigo
    * return UnidadeMedia
    */
    public UnidadeMedia getUnidadeMediaController(String pNome){
        return this.daoUnidadeMedia.getUnidadeMediaDAO(pNome);
    }

    /**
    * recupera uma lista deUnidadeMedia
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<UnidadeMedia> getListaUnidadeMediaController(){
        return this.daoUnidadeMedia.getListaUnidadeMediaDAO();
    }

    /**
    * atualiza UnidadeMedia
    * @param pUnidadeMedia
    * return boolean
    */
    public boolean atualizarUnidadeMediaController(UnidadeMedia pUnidadeMedia){
        return this.daoUnidadeMedia.atualizarUnidadeMediaDAO(pUnidadeMedia);
    }

    /**
    * exclui UnidadeMedia
    * @param pCodigo
    * return boolean
    */
    public boolean excluirUnidadeMediaController(int pCodigo){
        return this.daoUnidadeMedia.excluirUnidadeMediaDAO(pCodigo);
    }
}
