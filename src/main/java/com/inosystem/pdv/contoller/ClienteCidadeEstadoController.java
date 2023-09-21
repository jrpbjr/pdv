/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.ClienteCidadeEstadoDao;
import com.inosystem.pdv.model.ClienteCidadeEstado;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class ClienteCidadeEstadoController {
    
private ClienteCidadeEstadoDao dAOClienteCidadeEstado = new ClienteCidadeEstadoDao();

    /**
    * recupera uma lista deCidadeEstado
    * @param pCidade
    * return ArrayList
    */
    public ArrayList<ClienteCidadeEstado> getListaClienteCidadeEstadoController(){
        return this.dAOClienteCidadeEstado.getListaClienteCidadeEstadoDAO();
    }

    public ClienteCidadeEstado getClienteCidadeEstadoController(String pNome) {
        return this.dAOClienteCidadeEstado.getClienteCidadeEstadoDAO(pNome);
    }
    
    public ClienteCidadeEstado getClienteCidadeEstadoController(int pCodigo) {
        return this.dAOClienteCidadeEstado.getClienteCidadeEstadoDAO(pCodigo);
    }

    public ClienteCidadeEstado getClienteCidadeEstadoPorTelefoneController(String pTelefone) {
        return this.dAOClienteCidadeEstado.getClienteCidadeEstadoPorTelefoneDAO(pTelefone);
    }
}
