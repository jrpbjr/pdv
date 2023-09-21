/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.VendaProdutoDao;
import com.inosystem.pdv.model.VendaProduto;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class VendaProdutoController {
    
private VendaProdutoDao daoVendasProdutos = new VendaProdutoDao();

    /**
    * grava VendasProdutos
    * @param pVendaProduto
    * return int
    */
    public int salvarVendasProdutosController(VendaProduto pVendaProduto){
        return this.daoVendasProdutos.salvarVendasProdutosDAO(pVendaProduto);
    }

    /**
    * recupera VendasProdutos
    * @param pCodigo
    * return VendaProduto
    */
    public VendaProduto getVendasProdutosController(int pCodigo){
        return this.daoVendasProdutos.getVendasProdutosDAO(pCodigo);
    }

    /**
    * recupera uma lista deVendasProdutos
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<VendaProduto> getListaVendasProdutosController(){
        return this.daoVendasProdutos.getListaVendasProdutosDAO();
    }

    /**
    * atualiza VendasProdutos
    * @param pVendaProduto
    * return boolean
    */
    public boolean atualizarVendasProdutosController(VendaProduto pVendaProduto){
        return this.daoVendasProdutos.atualizarVendasProdutosDAO(pVendaProduto);
    }

    /**
    * exclui VendasProdutos
    * @param pCodigo
    * return boolean
    */
    public boolean excluirVendasProdutosController(int pCodigo){
        return this.daoVendasProdutos.excluirVendasProdutosDAO(pCodigo);
    }

    public ArrayList<VendaProduto> getListaVendasProdutosController(int pCodigoVenda) {
        return this.daoVendasProdutos.getListaVendasProdutosDAO(pCodigoVenda);
    }
}
