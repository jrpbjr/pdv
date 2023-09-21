/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.contoller;

import com.inosystem.pdv.dao.RelatorioDao;
import com.inosystem.pdv.model.RelatorioProduto;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author jrpbj
 */
public class RelatorioProdutoController {
    
private RelatorioDao dAORelatorios = new RelatorioDao();

    public ArrayList<RelatorioProduto> retornarProdutosCidadeController(int codigoCidade, Date dataInicial, Date dataFinal) {
        return this.dAORelatorios.gerarRelatorioClienteIndividual(codigoCidade, dataInicial, dataFinal);
    }

    public ArrayList<RelatorioProduto> retornarProdutosTodasCidadeController(int codigoCidade, Date dataInicial, Date dataFinal) {
        return this.dAORelatorios.retornarProdutosTodasCidadeController(codigoCidade, dataInicial, dataFinal);
    }

}

