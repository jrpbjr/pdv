/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.util;


import com.inosystem.pdv.contoller.ClienteCidadeEstadoController;
import com.inosystem.pdv.contoller.EmpresaCidadeEstadoController;
import com.inosystem.pdv.contoller.ProdutoController;
import com.inosystem.pdv.contoller.VendaController;
import com.inosystem.pdv.contoller.VendaProdutoController;
import com.inosystem.pdv.model.ClienteCidadeEstado;
import com.inosystem.pdv.model.EmpresaCidadeEstado;
import com.inosystem.pdv.model.Venda;
import com.inosystem.pdv.model.VendaProduto;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jrpbj
 */


public class GerarCupom {

    VendaProdutoController VendaControllerProdutos = new VendaProdutoController();
    ProdutoController controllerProdutos = new ProdutoController();
    VendaController VendaController = new VendaController();
    EmpresaCidadeEstadoController controllerEmpresaCidadeEstado = new EmpresaCidadeEstadoController();
    ArrayList<VendaProduto> listaVendaProdutoes = new ArrayList<>();
    Venda modelVendas = new Venda();
    EmpresaCidadeEstado modelEmpresaCidadeEstado = new EmpresaCidadeEstado();
    Mascara bLMascaras = new Mascara();
    ClienteCidadeEstado modelClienteCidadeEstado = new ClienteCidadeEstado();
    ClienteCidadeEstadoController controllerClienteCidadeEstado = new ClienteCidadeEstadoController();

    public String geraCupomCozinha(int pCodigo) throws IOException {
        String textoParaImprimir = "";
        try {

            modelVendas = VendaController.getVendasController(pCodigo);
            listaVendaProdutoes = VendaControllerProdutos.getListaVendasProdutosController(pCodigo);
            modelEmpresaCidadeEstado = controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(1);

            //data e hora do sistema
            String data = "dd/MM/yyyy";
            String hora = "h:mm - a";
            String data1, hora1;
            java.util.Date agora = new java.util.Date();
            SimpleDateFormat formata = new SimpleDateFormat(data);
            data1 = formata.format(agora);
            formata = new SimpleDateFormat(hora);
            hora1 = formata.format(agora);
            //fim data e hora do sistema

            String conteudoFor = "";
            for (int i = 0; i < listaVendaProdutoes.size(); i++) {
                conteudoFor += listaVendaProdutoes.get(i).getQuantidade() + " x " + controllerProdutos.getProdutosController(listaVendaProdutoes.get(i).getCodigo_produto()).getNome() + " - " + listaVendaProdutoes.get(i).getCodigo_venda() + "\n\r";
            }
            //armazenar em uma string o texto(cupom) para imprimir
            textoParaImprimir = (modelEmpresaCidadeEstado.getEmpresa().getNomeFantasia() + "\n\r"
                    + modelEmpresaCidadeEstado.getEmpresa().getEndereco() + "\n\r"
                    + modelEmpresaCidadeEstado.getCidade().getNome() + "-" + modelEmpresaCidadeEstado.getEstado().getUf() + "\n\r"
                    + modelEmpresaCidadeEstado.getEmpresa().getCnpj() + "\n\r"
                    + "Data venda: " + modelVendas.getDataVenda() + "\n\r" + "Impressao:" + data1 + "-" + hora1 + "\n\r"
                    + "--------------------------------\n\r"
                    + "        CUPOM COZINHA        \n\r"
                    + "--------------------------------\n\r"
                    + "QT   DESCRICAO   OBS.\n\r"
                    + conteudoFor + ""
                    + "--------------------------------\n\r"
                    + "Valor bruto: " + bLMascaras.arredondamentoComPontoDuasCasasString(modelVendas.getValorTotal().floatValue()) + "\n\r"
                    + "   Desconto: " + bLMascaras.arredondamentoComPontoDuasCasasString(modelVendas.getDesconto().floatValue()) + "\n\r"
                    + "Valor total: " + bLMascaras.arredondamentoComPontoDuasCasasString(modelVendas.getValorTotal().floatValue() - modelVendas.getDesconto().floatValue()) + "\n\r"
                    + "\n\r\n\r\n\r\n\r\f");
            //chamar metodo para imprimir
            // /n/r para novas linhas e /f para fim da pagina  
        } catch (Exception e) {
            textoParaImprimir = "erro";
            JOptionPane.showMessageDialog(null, "Erro ao imprimir");
        }
        return textoParaImprimir;

    }

    public String geraCupomDelivery(int pCodigo) throws IOException {
        String textoParaImprimir = "";
        modelVendas = VendaController.getVendasController(pCodigo);
        listaVendaProdutoes = VendaControllerProdutos.getListaVendasProdutosController(pCodigo);
        modelEmpresaCidadeEstado = controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(1);
        modelClienteCidadeEstado = controllerClienteCidadeEstado.getClienteCidadeEstadoController(modelVendas.getClientesCodigo());

        //data e hora do sistema
        String data = "dd/MM/yyyy";
        String hora = "h:mm - a";
        String data1, hora1;
        java.util.Date agora = new java.util.Date();
        SimpleDateFormat formata = new SimpleDateFormat(data);
        data1 = formata.format(agora);
        formata = new SimpleDateFormat(hora);
        hora1 = formata.format(agora);
        //fim data e hora do sistema

        try {

            String conteudoFor = "";
            for (int i = 0; i < listaVendaProdutoes.size(); i++) {
                conteudoFor += listaVendaProdutoes.get(i).getQuantidade() + " x " + controllerProdutos.getProdutosController(listaVendaProdutoes.get(i).getCodigo_produto()).getNome() + " - " + listaVendaProdutoes.get(i).getCodigo_venda() + "\n\r";
            }
            //armazenar em uma string o texto(cupom) para imprimir
            textoParaImprimir = (modelEmpresaCidadeEstado.getEmpresa().getNomeFantasia() + "\n\r"
                    + modelEmpresaCidadeEstado.getEmpresa().getEndereco() + "\n\r"
                    + modelEmpresaCidadeEstado.getCidade().getNome() + "-" + modelEmpresaCidadeEstado.getEstado().getUf() + "\n\r"
                    + modelEmpresaCidadeEstado.getEmpresa().getCnpj() + "\n\r"
                    + "Data venda: " + modelVendas.getDataVenda() + "\n\r" + "Impressao:" + data1 + "-" + hora1 + "\n\r"
                    + "--------------------------------\n\r"
                    + "         CUPOM DELIVERY         \n\r"
                    + "--------------------------------\n\r"
                    + "             CLIENTE            \n\r"
                    + "--------------------------------\n\r"
                    + modelClienteCidadeEstado.getCliente().getNome() + "\n\r"
                    + modelClienteCidadeEstado.getCliente().getTelefone() + "\n\r"
                    + modelClienteCidadeEstado.getCliente().getEndereco() + "\n\r"
                    + modelClienteCidadeEstado.getCliente().getBairro() + "\n\r"
                    + "--------------------------------\n\r"
                    + "QT   DESCRICAO   OBS.\n\r"
                    + conteudoFor + ""
                    + "--------------------------------\n\r"
                    + "Valor bruto: " + bLMascaras.arredondamentoComPontoDuasCasasString(modelVendas.getValorTotal().floatValue()) + "\n\r"
                    + "   Desconto: " + bLMascaras.arredondamentoComPontoDuasCasasString(modelVendas.getDesconto().floatValue()) + "\n\r"
                    + "Valor total: " + bLMascaras.arredondamentoComPontoDuasCasasString(modelVendas.getValorTotal().floatValue() - modelVendas.getDesconto().floatValue()) + "\n\r"
                    + "OBS: " + modelVendas.getObservacao() + "\n\r"
                    + "\n\r\n\r\n\r\n\r\f");
            //chamar metodo para imprimir
            // /n/r para novas linhas e /f para fim da pagina  
        } catch (Exception e) {
            textoParaImprimir = "erro";
            JOptionPane.showMessageDialog(null, "Erro ao imprimir");
        }
        return textoParaImprimir;

    }

    public String gerarCupomPDV(int pCodigo) throws IOException {
        modelVendas = VendaController.getVendasController(pCodigo);
        listaVendaProdutoes = VendaControllerProdutos.getListaVendasProdutosController(pCodigo);
        modelEmpresaCidadeEstado = controllerEmpresaCidadeEstado.getEmpresaCidadeEstadoController(1);

        String textoParaImprimir = "";
        //data e hora do sistema
        String data = "dd/MM/yyyy";
        String hora = "h:mm - a";
        String data1, hora1;
        java.util.Date agora = new java.util.Date();
        SimpleDateFormat formata = new SimpleDateFormat(data);
        data1 = formata.format(agora);
        formata = new SimpleDateFormat(hora);
        hora1 = formata.format(agora);
        //fim data e hora do sistema

        try {

            String conteudoFor = "";
            for (int i = 0; i < listaVendaProdutoes.size(); i++) {
                conteudoFor += listaVendaProdutoes.get(i).getQuantidade() + " x " + bLMascaras.arredondamentoDoubleComPontoDuasCasasString(controllerProdutos.getProdutosController(listaVendaProdutoes.get(i).getCodigo_produto()).getValor()) + " - " + controllerProdutos.getProdutosController(listaVendaProdutoes.get(i).getCodigo_produto()).getNome() + "\n\r";
            }
            textoParaImprimir = (modelEmpresaCidadeEstado.getEmpresa().getNomeFantasia() + "\n\r"
                    + modelEmpresaCidadeEstado.getEmpresa().getEndereco() + "\n\r"
                    + modelEmpresaCidadeEstado.getCidade().getNome() + "-" + modelEmpresaCidadeEstado.getEstado().getUf() + "\n\r"
                    + modelEmpresaCidadeEstado.getEmpresa().getCnpj() + "\n\r"
                    + "Data venda: " + modelVendas.getDataVenda() + "\n\r" + "Impressao:" + data1 + "-" + hora1 + "\n\r"
                    + "--------------------------------\n\r"
                    + "        CUPOM NAO FISCAL        \n\r"
                    + "--------------------------------\n\r"
                    + "QT  X PRECO - DESCRICAO\n\r"
                    + conteudoFor + ""
                    + "--------------------------------\n\r"
                    + "........Valor bruto: " + bLMascaras.arredondamentoComPontoDuasCasasString(modelVendas.getValorTotal().floatValue() + modelVendas.getDesconto().floatValue()) + "\n\r"
                    + "...........Desconto: " + bLMascaras.arredondamentoComPontoDuasCasasString(modelVendas.getDesconto().floatValue()) + "\n\r"
                    + "...Acrecimo ou Taxa: " + bLMascaras.arredondamentoComPontoDuasCasasString(modelVendas.getTaxaEntrega().floatValue()) + "\n\r"
                    + "......Valor a pagar: " + bLMascaras.arredondamentoComPontoDuasCasasString(modelVendas.getValorTotal().floatValue()) + "\n\r"
                    + "\n\r\n\r\n\r\n\r\f");

        } catch (Exception e) {
            textoParaImprimir = "erro";
            JOptionPane.showMessageDialog(null, "Erro ao imprimir");
        }
        return textoParaImprimir;

    }

}

