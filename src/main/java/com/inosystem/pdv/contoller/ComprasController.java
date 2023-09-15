/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.ComprasDao;
import com.inosystem.pdv.dao.RelatorioDao;
import com.inosystem.pdv.model.Compras;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class ComprasController {

    private ComprasDao daoComprass = new ComprasDao();
    private RelatorioDao dAORelatorios = new RelatorioDao();

    /**
     * grava Comprass
     *
     * @param pCompras return int
     */
    public int salvarComprassController(Compras pCompras) {
        return this.daoComprass.salvarComprassDAO(pCompras);
    }

    /**
     * recupera Comprass
     *
     * @param pCodigo return Compras
     */
    public Compras getComprassController(int pCodigo) {
        return this.daoComprass.getComprassDAO(pCodigo);
    }

    /**
     * recupera uma lista deComprass
     *
     * @param pCodigo return ArrayList
     */
    public ArrayList<Compras> getListaComprassController() {
        return this.daoComprass.getListaComprassDAO();
    }

    /**
     * atualiza Comprass
     *
     * @param pCompras return boolean
     */
    public boolean atualizarComprassController(Compras pCompras) {
        return this.daoComprass.atualizarComprassDAO(pCompras);
    }

    /**
     * exclui Comprass
     *
     * @param pCodigo return boolean
     */
    public boolean excluirComprassController(int pCodigo) {
        return this.daoComprass.excluirComprassDAO(pCodigo);
    }

    /**
     * imprimir
     *
     * @param pCodigo
     * @return
     */
    public boolean gerarRelatorioComprasController(int pCodigo) {
        return this.dAORelatorios.gerarRelatorioCompraDAO(pCodigo);
    }
}
