/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.TransportadoraCidEstDao;
import com.inosystem.pdv.model.TransportadoraCidEst;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class TransportadoraCidEstController {
    
private TransportadoraCidEstDao daoTransportadoraCidEst = new TransportadoraCidEstDao();

    /**
     * recupera uma lista deTransportadoraCidEst
     *
     * @param pCidade return ArrayList
     */
    public ArrayList<TransportadoraCidEst> getListaTransportadoraCidadeEstadoController() {
        return this.daoTransportadoraCidEst.getListaTransportadoraCidadeEstadoDAO();
    }
}

