/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.CompraProdutoDao;
import com.inosystem.pdv.model.CompraProduto;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class CompraProdutoController {
    
private CompraProdutoDao daocompras_produtos = new CompraProdutoDao();

    /**
    * grava compras_produtos
    * @param pModelcompras_produtos
    * return int
    */
    public int salvarcompras_produtosController(CompraProduto pModelcompras_produtos){
        return this.daocompras_produtos.salvarcompras_produtosDAO(pModelcompras_produtos);
    }

    /**
    * recupera compras_produtos
    * @param pCodigo
    * return Modelcompras_produtos
    */
    public CompraProduto getcompras_produtosController(int pCodigo){
        return this.daocompras_produtos.getcompras_produtosDAO(pCodigo);
    }

    /**
    * recupera uma lista decompras_produtos
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<CompraProduto> getListacompras_produtosController(){
        return this.daocompras_produtos.getListacompras_produtosDAO();
    }
    
    /**
    * recupera uma lista decompras_produtos
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<CompraProduto> getListacompras_produtosController(int pCodigo){
        return this.daocompras_produtos.getListacompras_produtosDAO(pCodigo);
    }

    /**
    * atualiza compras_produtos
    * @param pModelcompras_produtos
    * return boolean
    */
    public boolean atualizarcompras_produtosController(CompraProduto pModelcompras_produtos){
        return this.daocompras_produtos.atualizarcompras_produtosDAO(pModelcompras_produtos);
    }

    /**
    * exclui compras_produtos
    * @param pCodigo
    * return boolean
    */
    public boolean excluircompras_produtosController(int pCodigo){
        return this.daocompras_produtos.excluircompras_produtosDAO(pCodigo);
    }
}
