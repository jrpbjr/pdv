/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.FormaPagamentoDao;
import com.inosystem.pdv.model.FormaPagamento;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class FormaPagamentoController {
    
private FormaPagamentoDao daoFormaPagamento = new FormaPagamentoDao();

    /**
    * grava FormaPagamento
    * @param pFormaPagamento
    * return int
    */
    public int salvarFormaPagamentoController(FormaPagamento pFormaPagamento){
        return this.daoFormaPagamento.salvarFormaPagamentoDAO(pFormaPagamento);
    }

    /**
    * recupera FormaPagamento
    * @param pCodigo
    * return FormaPagamento
    */
    public FormaPagamento getFormaPagamentoController(int pCodigo){
        return this.daoFormaPagamento.getFormaPagamentoDAO(pCodigo);
    }
    
    /**
    * recupera FormaPagamento
    * @param pCodigo
    * return FormaPagamento
    */
    public FormaPagamento getFormaPagamentoController(String pCodigo){
        return this.daoFormaPagamento.getFormaPagamentoDAO(pCodigo);
    }

    /**
    * recupera uma lista deFormaPagamento
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<FormaPagamento> getListaFormaPagamentoController(){
        return this.daoFormaPagamento.getListaFormaPagamentoDAO();
    }

    /**
    * atualiza FormaPagamento
    * @param pFormaPagamento
    * return boolean
    */
    public boolean atualizarFormaPagamentoController(FormaPagamento pFormaPagamento){
        return this.daoFormaPagamento.atualizarFormaPagamentoDAO(pFormaPagamento);
    }

    /**
    * exclui FormaPagamento
    * @param pCodigo
    * return boolean
    */
    public boolean excluirFormaPagamentoController(int pCodigo){
        return this.daoFormaPagamento.excluirFormaPagamentoDAO(pCodigo);
    }
}
