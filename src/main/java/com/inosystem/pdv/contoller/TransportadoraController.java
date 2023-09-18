/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.TransportadoraDao;
import com.inosystem.pdv.model.Transportadora;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class TransportadoraController {
    
 private TransportadoraDao daoTransportadora = new TransportadoraDao();

    /**
    * grava Transportadora
    * @param pTransportadora
    * return int
    */
    public int salvarTransportadoraController(Transportadora pTransportadora){
        return this.daoTransportadora.salvarTransportadoraDAO(pTransportadora);
    }

    /**
    * recupera Transportadora
    * @param pCodigo
    * return Transportadora
    */
    public Transportadora getTransportadoraController(int pCodigo){
        return this.daoTransportadora.getTransportadoraDAO(pCodigo);
    }

    /**
    * recupera uma lista deTransportadora
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<Transportadora> getListaTransportadoraController(){
        return this.daoTransportadora.getListaTransportadoraDAO();
    }

    /**
    * atualiza Transportadora
    * @param pTransportadora
    * return boolean
    */
    public boolean atualizarTransportadoraController(Transportadora pTransportadora){
        return this.daoTransportadora.atualizarTransportadoraDAO(pTransportadora);
    }

    /**
    * exclui Transportadora
    * @param pCodigo
    * return boolean
    */
    public boolean excluirTransportadoraController(int pCodigo){
        return this.daoTransportadora.excluirTransportadoraDAO(pCodigo);
    }
}
