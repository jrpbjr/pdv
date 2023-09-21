/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.model;

import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class PermissaoUsuario {
private int codigo;
    private int codigo_usuario;
    private String permissao;
    private ArrayList<PermissaoUsuario> listaPermissaoUsuarios;

    /**
    * Construtor
    */
    public PermissaoUsuario(){}

    /**
    * seta o valor de codigo
    * @param pCodigo
    */
    public void setCodigo(int pCodigo){
        this.codigo = pCodigo;
    }
    /**
    * return pk_codigo
    */
    public int getCodigo(){
        return this.codigo;
    }

    /**
    * seta o valor de codigo_usuario
    * @param pCodigo_usuario
    */
    public void setCodigo_usuario(int pCodigo_usuario){
        this.codigo_usuario = pCodigo_usuario;
    }
    /**
    * return fk_codigo_usuario
    */
    public int getCodigo_usuario(){
        return this.codigo_usuario;
    }

    /**
    * seta o valor de permissao
    * @param pPermissao
    */
    public void setPermissao(String pPermissao){
        this.permissao = pPermissao;
    }
    /**
    * return permissao
    */
    public String getPermissao(){
        return this.permissao;
    }

    @Override
    public String toString(){
        return "PermissaoUsuario {" + "::codigo = " + this.codigo + "::codigo_usuario = " + this.codigo_usuario + "::permissao = " + this.permissao +  "}";
    }

    /**
     * @return the listaPermissaoUsuarios
     */
    public ArrayList<PermissaoUsuario> getListaPermissaoUsuarios() {
        return listaPermissaoUsuarios;
    }

    /**
     * @param listaPermissaoUsuarios the listaPermissaoUsuarios to set
     */
    public void setListaPermissaoUsuarios(ArrayList<PermissaoUsuario> listaPermissaoUsuarios) {
        this.listaPermissaoUsuarios = listaPermissaoUsuarios;
    }
}
