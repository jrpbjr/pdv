/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.CidadeDao;
import com.inosystem.pdv.model.Cidade;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class CidadeController {
    
private CidadeDao daoCidade = new CidadeDao();

    /**
    * grava Cidade
    * @param pCidade
    * return int
    */
    public int salvarCidadeController(Cidade pCidade){
        return this.daoCidade.salvarCidadeDAO(pCidade);
    }

    /**
    * recupera Cidade
    * @param pCodigo
    * return Cidade
    */
    public Cidade getCidadeController(int pCodigo){
        return this.daoCidade.getCidadeDAO(pCodigo);
    }
    
    /**
    * recupera Cidade
    * @param pNome
    * return Cidade
    */
    public Cidade getCidadeController(String pNome){
        return this.daoCidade.getCidadeDAO(pNome);
    }

    /**
    * recupera uma lista deCidade
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<Cidade> getListaCidadeController(){
        return this.daoCidade.getListaCidadeDAO();
    }
    /**
    * recupera uma lista deCidade
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<Cidade> getListaCidadePorEstadoController(int pCodigoEstado){
        return this.daoCidade.getListaCidadePorEstadoDAO(pCodigoEstado);
    }

    /**
    * atualiza Cidade
    * @param pCidade
    * return boolean
    */
    public boolean atualizarCidadeController(Cidade pCidade){
        return this.daoCidade.atualizarCidadeDAO(pCidade);
    }

    /**
    * exclui Cidade
    * @param pCodigo
    * return boolean
    */
    public boolean excluirCidadeController(int pCodigo){
        return this.daoCidade.excluirCidadeDAO(pCodigo);
    }
}
