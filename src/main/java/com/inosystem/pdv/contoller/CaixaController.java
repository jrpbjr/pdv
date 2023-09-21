/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.CaixaDao;
import com.inosystem.pdv.model.Caixa;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class CaixaController {
    
private CaixaDao daoCaixa = new CaixaDao();

    /**
    * grava Caixa
    * @param pCaixa
    * return int
    */
    public int salvarCaixaController(Caixa pCaixa){
        return this.daoCaixa.salvarCaixaDAO(pCaixa);
    }

    /**
    * recupera Caixa
    * @param pCodigo
    * return Caixa
    */
    public Caixa getCaixaController(int pCodigo){
        return this.daoCaixa.getCaixaDAO(pCodigo);
    }

    /**
    * recupera uma lista deCaixa
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<Caixa> getListaCaixaController(){
        return this.daoCaixa.getListaCaixaDAO();
    }

    /**
    * atualiza Caixa
    * @param pCaixa
    * return boolean
    */
    public boolean atualizarCaixaController(Caixa pCaixa){
        return this.daoCaixa.atualizarCaixaDAO(pCaixa);
    }

    /**
    * exclui Caixa
    * @param pCodigo
    * return boolean
    */
    public boolean excluirCaixaController(int pCodigo){
        return this.daoCaixa.excluirCaixaDAO(pCodigo);
    }

    public Caixa verificarRetorarCaixaControler(int numeroCaixa) {
        return this.daoCaixa.verificarRetorarCaixaDAO(numeroCaixa);
    }

    public boolean atualizarCaixaPDVController(Caixa pCaixa) {
        return this.daoCaixa.atualizarCaixaPDVDAO(pCaixa);
    }

    public Caixa retorarCaixaControler(int numeroCaixa) {
        return this.daoCaixa.retorarCaixaDAO(numeroCaixa);
    }
}