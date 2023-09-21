/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.UsuarioDao;
import com.inosystem.pdv.model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class UsuarioController {
    
private UsuarioDao daoUsuario = new UsuarioDao();

    /**
    * grava Usuario
    * @param pUsuario
    * return int
    */
    public int salvarUsuarioController(Usuario pUsuario){
        return this.daoUsuario.salvarUsuarioDAO(pUsuario);
    }

    /**
    * recupera Usuario
    * @param pCodigo
    * return Usuario
    */
    public Usuario getUsuarioController(int pCodigo){
        return this.daoUsuario.getUsuarioDAO(pCodigo);
    }
    
    /**
    * recupera Usuario
    * @param pLogin
    * return Usuario
    */
    public Usuario getUsuarioController(String pLogin){
        return this.daoUsuario.getUsuarioDAO(pLogin);
    }
    
    /**
    * recupera Usuario
    * @param pUsuario
    * return Usuario
    */
    public boolean getUsuarioController(Usuario pUsuario){
        return this.daoUsuario.getUsuarioDAO(pUsuario);
    }

    /**
    * recupera uma lista deUsuario
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<Usuario> getListaUsuarioController(){
        return this.daoUsuario.getListaUsuarioDAO();
    }

    /**
    * atualiza Usuario
    * @param pUsuario
    * return boolean
    */
    public boolean atualizarUsuarioController(Usuario pUsuario){
        return this.daoUsuario.atualizarUsuarioDAO(pUsuario);
    }

    /**
    * exclui Usuario
    * @param pCodigo
    * return boolean
    */
    public boolean excluirUsuarioController(int pCodigo){
        return this.daoUsuario.excluirUsuarioDAO(pCodigo);
    }
}
