/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.PermissaoUsuarioDao;
import com.inosystem.pdv.model.PermissaoUsuario;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class PermissaoUsuarioController {
    
private PermissaoUsuarioDao daoPermissaousuario = new PermissaoUsuarioDao();

    /**
     * grava Permissaousuario
     *
     * @param pPermissaoUsuario return int
     */
    public int salvarPermissaousuarioController(PermissaoUsuario pPermissaoUsuario) {
        return this.daoPermissaousuario.salvarPermissaousuarioDAO(pPermissaoUsuario);
    }

    /**
     * recupera Permissaousuario
     *
     * @param pCodigo return PermissaoUsuario
     */
    public PermissaoUsuario getPermissaousuarioController(int pCodigo) {
        return this.daoPermissaousuario.getPermissaousuarioDAO(pCodigo);
    }

    /**
     * recupera uma lista dePermissaousuario
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<PermissaoUsuario> getListaPermissaousuarioController() {
        return this.daoPermissaousuario.getListaPermissaousuarioDAO();
    }

    /**
     * atualiza Permissaousuario
     *
     * @param pPermissaoUsuario return boolean
     */
    public boolean atualizarPermissaousuarioController(PermissaoUsuario pPermissaoUsuario) {
        return this.daoPermissaousuario.atualizarPermissaousuarioDAO(pPermissaoUsuario);
    }

    /**
     * exclui Permissaousuario
     *
     * @param pCodigo return boolean
     */
    public boolean excluirPermissaousuarioController(int pCodigo) {
        return this.daoPermissaousuario.excluirPermissaousuarioDAO(pCodigo);
    }

    /**
     * RETORNAR LISTA DE PREMISSAOES DO USUARIO
     *
     * @param pCodigo
     * @return
     */
    public ArrayList<PermissaoUsuario> getListaPermissaousuarioController(int pCodigo) {
        return this.daoPermissaousuario.getListaPermissaousuarioDAO(pCodigo);
    }

    public PermissaoUsuario getPermissaousuarioCodUsuController(int pCodigoUsuario) {
        return this.daoPermissaousuario.getPermissaousuarioCodUsuDAO(pCodigoUsuario);
    }

    public PermissaoUsuario getVerificaPermissaoNFeController(int pCodigoUsuario) {
        return this.daoPermissaousuario.getVerificaPermissaoNFeDAO(pCodigoUsuario);
    }
}

