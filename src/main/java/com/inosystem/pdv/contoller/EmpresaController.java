/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.EmpresaDao;
import com.inosystem.pdv.model.Empresa;
import com.inosystem.pdv.model.EmpresaCidadeEstado;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class EmpresaController {
    
 private EmpresaDao daoEmpresa = new EmpresaDao();

    /**
    * grava Empresa
    * @param pEmpresa
    * @return int
    */
    public int salvarEmpresaController(Empresa pEmpresa){
        return this.daoEmpresa.salvarEmpresaDAO(pEmpresa);
    }

    /**
    * recupera Empresa
    * @param pCodigo
     * @return Empresa
    */
    public EmpresaCidadeEstado getEmpresaController(int pCodigo){
        return this.daoEmpresa.getEmpresaDAO(pCodigo);
    }
    
    /**
    * recupera Empresa
     * @param pNome
     * @return Empresa
    */
    public EmpresaCidadeEstado getEmpresaController(String pNome){
        return this.daoEmpresa.getEmpresaDAO(pNome);
    }

    /**
    * recupera uma lista deEmpresa
     * @return listaModelempresa
    */
    public ArrayList<Empresa> getListaEmpresaController(){
        return this.daoEmpresa.getListaEmpresaDAO();
    }

    /**
    * atualiza Empresa
    * @param pEmpresa
    * @return boolean
    */
    public boolean atualizarEmpresaController(Empresa pEmpresa){
        return this.daoEmpresa.atualizarEmpresaDAO(pEmpresa);
    }

    /**
    * exclui Empresa
    * @param pCodigo
    * @return boolean
    */
    public boolean excluirEmpresaController(int pCodigo){
        return this.daoEmpresa.excluirEmpresaDAO(pCodigo);
    }
}
