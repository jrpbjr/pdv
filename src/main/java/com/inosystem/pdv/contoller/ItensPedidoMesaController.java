/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.ItensPedidoMesaDao;
import com.inosystem.pdv.model.ItensPedidoMesa;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class ItensPedidoMesaController {
    
 private ItensPedidoMesaDao daoItensPedidoMesa = new ItensPedidoMesaDao();

    /**
    * grava ItensPedidoMesa
    * @param pItensPedidoMesa
    * return int
    */
    public int salvarItensPedidoMesaController(ItensPedidoMesa pItensPedidoMesa){
        return this.daoItensPedidoMesa.salvarItensPedidoMesaDAO(pItensPedidoMesa);
    }
    
        /**
    * grava ItensPedidoMesa
    * @param pItensPedidoMesa
    * return int
    */
    public boolean salvarItensPedidoMesaController(ArrayList<ItensPedidoMesa> pListaItensPedidoMesas){
        return this.daoItensPedidoMesa.salvarItensPedidoMesaDAO(pListaItensPedidoMesas);
    }

    /**
    * recupera ItensPedidoMesa
    * @param pCodigo
    * return ItensPedidoMesa
    */
    public ItensPedidoMesa getItensPedidoMesaController(int pCodigo){
        return this.daoItensPedidoMesa.getItensPedidoMesaDAO(pCodigo);
    }

    /**
    * recupera uma lista deItensPedidoMesa
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ItensPedidoMesa> getListaItensPedidoMesaController(){
        return this.daoItensPedidoMesa.getListaItensPedidoMesaDAO();
    }
    /**
    /**
    * recupera uma lista deItensPedidoMesa
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ItensPedidoMesa> getListaItensPedidoMesaCozinhaController(){
        return this.daoItensPedidoMesa.getListaItensPedidoMesaCozinhaDAO();
    }
    /**
    * recupera uma lista deItensPedidoMesa
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ItensPedidoMesa> getListaItensPedidoMesaController(int pCodigoMesa){
        return this.daoItensPedidoMesa.getListaItensPedidoMesaDAO(pCodigoMesa);
    }

    /**
    * atualiza ItensPedidoMesa
    * @param pItensPedidoMesa
    * return boolean
    */
    public boolean atualizarItensPedidoMesaController(ItensPedidoMesa pItensPedidoMesa){
        return this.daoItensPedidoMesa.atualizarItensPedidoMesaDAO(pItensPedidoMesa);
    }
    /**
    * atualiza status item
    * @param pItensPedidoMesa
    * return boolean
    */
    public boolean atualizarStatusItemController(ItensPedidoMesa pItensPedidoMesa){
        return this.daoItensPedidoMesa.atualizarStatusItemDAO(pItensPedidoMesa);
    }

    /**
    * exclui ItensPedidoMesa
    * @param pCodigo
    * return boolean
    */
    public boolean excluirItensPedidoMesaController(int pCodigo){
        return this.daoItensPedidoMesa.excluirItensPedidoMesaDAO(pCodigo);
    }

    public ArrayList<Integer> getListaMesasOcupadasController() {
        return this.daoItensPedidoMesa.getListaMesasOcupadasDAO();
    }
}
