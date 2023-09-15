/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inosystem.pdv.dao;

import com.inosystem.pdv.conexoes.ConexaoMySql;
import com.inosystem.pdv.model.RelatorioProduto;
import com.inosystem.pdv.util.Mascara;
import java.awt.Desktop;
import java.io.File;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author jrpbj
 */
public class RelatorioDao extends ConexaoMySql {
    
 Mascara mascaras = new Mascara();

    public boolean gerarRelatorioCliente() {
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     clientes.codigo AS clientes_codigo, "
                    + "     clientes.nome AS clientes_nome, "
                    + "     clientes.nome_fantasia AS clientes_nome_fantasia, "
                    + "     clientes.endereco AS clientes_endereco, "
                    + "     clientes.bairro AS clientes_bairro, "
                    + "     clientes.cep AS clientes_cep, "
                    + "     clientes.telefone AS clientes_telefone, "
                    + "     clientes.cpf_cnpj AS clientes_cpf_cnpj, "
                    + "     clientes.observacao AS clientes_observacao, "
                    + "     clientes.ativo AS clientes_ativo, "
                    + "     clientes.tipo_pessoa AS clientes_tipo_pessoa, "
                    + "     cidade.codigo_ibge AS cidade_codigo_ibge, "
                    + "     cidade.codigo AS cidade_codigo, "
                    + "     cidade.nome AS cidade_nome, "
                    + "     estado.uf AS estado_uf, "
                    + "     estado.nome AS estado_nome "
                    + "FROM "
                    + "     cidade cidade INNER JOIN clientes clientes ON cidade.codigo = clientes.cod_cidade "
                    + "     INNER JOIN estado estado ON cidade.fk_cod_estado = estado.codigo");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioClientes.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/BLVendas/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioClienteIndividual(int pCodigoCliente) {
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     clientes.codigo AS clientes_codigo, "
                    + "     clientes.nome AS clientes_nome, "
                    + "     clientes.nome_fantasia AS clientes_nome_fantasia, "
                    + "     clientes.endereco AS clientes_endereco, "
                    + "     clientes.bairro AS clientes_bairro, "
                    + "     clientes.cep AS clientes_cep, "
                    + "     clientes.telefone AS clientes_telefone, "
                    + "     clientes.cpf_cnpj AS clientes_cpf_cnpj, "
                    + "     clientes.observacao AS clientes_observacao, "
                    + "     clientes.ativo AS clientes_ativo, "
                    + "     clientes.tipo_pessoa AS clientes_tipo_pessoa, "
                    + "     cidade.codigo_ibge AS cidade_codigo_ibge, "
                    + "     cidade.codigo AS cidade_codigo, "
                    + "     cidade.nome AS cidade_nome, "
                    + "     estado.uf AS estado_uf, "
                    + "     estado.nome AS estado_nome "
                    + "FROM "
                    + "     cidade cidade INNER JOIN clientes clientes ON cidade.codigo = clientes.cod_cidade "
                    + "     INNER JOIN estado estado ON cidade.fk_cod_estado = estado.codigo "
                    + "WHERE clientes.codigo = '" + pCodigoCliente + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioClientes.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/BLVendas/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioProdutos() {
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     produtos.codigo AS produtos_codigo, "
                    + "     produtos.nome AS produtos_nome, "
                    + "     produtos.valor AS produtos_valor, "
                    + "     produtos.codigo_barras_ean AS produtos_codigo_barras_ean, "
                    + "     produtos.estoque AS produtos_estoque, "
                    + "     fornecedores.nome AS fornecedores_nome, "
                    + "     unidade_medida.abreviacao AS unidade_medida_abreviacao "
                    + "FROM "
                    + "     fornecedores fornecedores INNER JOIN produtos produtos ON fornecedores.codigo = produtos.fornecedores_codigo "
                    + "     INNER JOIN unidade_medida unidade_medida ON produtos.unidade_medida = unidade_medida.codigo");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioProdutos.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/BLVendas/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioFornecedores() {
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     fornecedores.codigo AS fornecedores_codigo, "
                    + "     fornecedores.nome AS fornecedores_nome, "
                    + "     fornecedores.endereco AS fornecedores_endereco, "
                    + "     fornecedores.bairro AS fornecedores_bairro, "
                    + "     fornecedores.cep AS fornecedores_cep, "
                    + "     fornecedores.telefone AS fornecedores_telefone, "
                    + "     cidade.codigo AS cidade_codigo, "
                    + "     cidade.nome AS cidade_nome, "
                    + "     estado.uf AS estado_uf, "
                    + "     estado.nome AS estado_nome "
                    + "FROM "
                    + "     cidade cidade INNER JOIN fornecedores fornecedores ON cidade.codigo = fornecedores.cod_cidade "
                    + "     INNER JOIN estado estado ON cidade.fk_cod_estado = estado.codigo");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioFornecedores.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/BLVendas/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioVenda(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     vendas.codigo AS vendas_codigo, "
                    + "     vendas.data_venda AS vendas_data_venda, "
                    + "     vendas.valor_total AS vendas_valor_total, "
                    + "     vendas.desconto AS vendas_desconto, "
                    + "     vendas.observacao AS vendas_observacao, "
                    + "     vendas_produto.quantidade AS vendas_produto_quantidade, "
                    + "     vendas_produto.valor_unitario AS vendas_produto_valor_unitario, "
                    + "     produtos.codigo AS produtos_codigo, "
                    + "     produtos.nome AS produtos_nome, "
                    + "     produtos.valor AS produtos_valor, "
                    + "     produtos.codigo_barras_ean AS produtos_codigo_barras_ean, "
                    + "     unidade_medida.abreviacao AS unidade_medida_abreviacao, "
                    + "     clientes.codigo AS clientes_codigo, "
                    + "     clientes.nome AS clientes_nome, "
                    + "     clientes.nome_fantasia AS clientes_nome_fantasia, "
                    + "     clientes.endereco AS clientes_endereco, "
                    + "     clientes.bairro AS clientes_bairro, "
                    + "     clientes.cep AS clientes_cep, "
                    + "     clientes.telefone AS clientes_telefone, "
                    + "     clientes.cpf_cnpj AS clientes_cpf_cnpj, "
                    + "     clientes.observacao AS clientes_observacao, "
                    + "     cidade.nome AS cidade_nome, "
                    + "     estado.uf AS estado_uf, "
                    + "     forma_pagamento.descricao AS forma_pagamento_descricao, "
                    + "     vendas.taxa_entrega AS vendas_taxa_entrega "
                    + "FROM "
                    + "     vendas vendas INNER JOIN vendas_produto vendas_produto ON vendas.codigo = vendas_produto.codigo_venda "
                    + "     INNER JOIN produtos produtos ON vendas_produto.codigo_produto = produtos.codigo "
                    + "     INNER JOIN unidade_medida unidade_medida ON produtos.unidade_medida = unidade_medida.codigo "
                    + "     INNER JOIN clientes clientes ON vendas.clientes_codigo = clientes.codigo "
                    + "     INNER JOIN forma_pagamento forma_pagamento ON vendas.tipo_pagamento = forma_pagamento.codigo "
                    + "     INNER JOIN cidade cidade ON clientes.cod_cidade = cidade.codigo "
                    + "     INNER JOIN estado estado ON cidade.fk_cod_estado = estado.codigo "
                    + " where vendas.codigo = '" + pCodigo + "'"
            );
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioVendas.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/BLVendas/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioOrcamento(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     vendas.codigo AS vendas_codigo, "
                    + "     vendas.data_venda AS vendas_data_venda, "
                    + "     vendas.valor_total AS vendas_valor_total, "
                    + "     vendas.desconto AS vendas_desconto, "
                    + "     vendas.observacao AS vendas_observacao, "
                    + "     vendas_produto.quantidade AS vendas_produto_quantidade, "
                    + "     vendas_produto.valor_unitario AS vendas_produto_valor_unitario, "
                    + "     produtos.codigo AS produtos_codigo, "
                    + "     produtos.nome AS produtos_nome, "
                    + "     produtos.valor AS produtos_valor, "
                    + "     produtos.codigo_barras_ean AS produtos_codigo_barras_ean, "
                    + "     unidade_medida.abreviacao AS unidade_medida_abreviacao, "
                    + "     clientes.codigo AS clientes_codigo, "
                    + "     clientes.nome AS clientes_nome, "
                    + "     clientes.nome_fantasia AS clientes_nome_fantasia, "
                    + "     clientes.endereco AS clientes_endereco, "
                    + "     clientes.bairro AS clientes_bairro, "
                    + "     clientes.cep AS clientes_cep, "
                    + "     clientes.telefone AS clientes_telefone, "
                    + "     clientes.cpf_cnpj AS clientes_cpf_cnpj, "
                    + "     clientes.observacao AS clientes_observacao, "
                    + "     cidade.nome AS cidade_nome, "
                    + "     estado.uf AS estado_uf, "
                    + "     forma_pagamento.descricao AS forma_pagamento_descricao, "
                    + "     vendas.taxa_entrega AS vendas_taxa_entrega "
                    + " FROM "
                    + "     vendas vendas INNER JOIN vendas_produto vendas_produto ON vendas.codigo = vendas_produto.codigo_venda "
                    + "     INNER JOIN produtos produtos ON vendas_produto.codigo_produto = produtos.codigo "
                    + "     INNER JOIN unidade_medida unidade_medida ON produtos.unidade_medida = unidade_medida.codigo "
                    + "     INNER JOIN clientes clientes ON vendas.clientes_codigo = clientes.codigo "
                    + "     INNER JOIN forma_pagamento forma_pagamento ON vendas.tipo_pagamento = forma_pagamento.codigo "
                    + "     INNER JOIN cidade cidade ON clientes.cod_cidade = cidade.codigo "
                    + "     INNER JOIN estado estado ON cidade.fk_cod_estado = estado.codigo "
                    + "WHERE vendas.codigo = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioOrcamento.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/BLVendas/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioPDV(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     VENDAS.CODIGO AS VENDASCODIGO, "
                    + "     VENDAS.CLIENTES_CODIGO AS VENDASCLIENTES_CODIGO, "
                    + "     VENDAS.DATA_VENDA AS VENDASDATA_VENDA, "
                    + "     VENDAS.VALOR_TOTAL AS VENDASVALOR_TOTAL, "
                    + "     VENDAS.DESCONTO AS VENDASDESCONTO, "
                    + "     VENDAS_PRODUTO.CODIGO AS VENDAS_PRODUTOCODIGO, "
                    + "     VENDAS_PRODUTO.CODIGO_PRODUTO AS VENDAS_PRODUTOCODIGO_PRODUTO, "
                    + "     VENDAS_PRODUTO.CODIGO_VENDA AS VENDAS_PRODUTOCODIGO_VENDA, "
                    + "     VENDAS_PRODUTO.QUANTIDADE AS VENDAS_PRODUTOQUANTIDADE, "
                    + "     PRODUTOS.CODIGO AS PRODUTOSCODIGO, "
                    + "     PRODUTOS.NOME AS PRODUTOSNOME, "
                    + "     PRODUTOS.VALOR AS PRODUTOSVALOR, "
                    + "     CLIENTES.CODIGO AS CLIENTESCODIGO, "
                    + "     empresa.RAZAO_SOCIAL AS empresa_RAZAO_SOCIAL, "
                    + "     empresa.NOME_FANTASIA AS empresa_NOME_FANTASIA, "
                    + "     empresa.ENDERECO AS empresa_ENDERECO, "
                    + "     empresa.BAIRRO AS empresa_BAIRRO, "
                    + "     empresa.COD_CIDADE AS empresa_COD_CIDADE, "
                    + "     empresa.COD_ESTADO AS empresa_COD_ESTADO, "
                    + "     empresa.CEP AS empresa_CEP, "
                    + "     empresa.TELEFONE AS empresa_TELEFONE, "
                    + "     empresa.CNPJ AS empresa_CNPJ, "
                    + "     estado.uf AS estado_uf, "
                    + "     cidade.nome AS cidade_nome "
                    + "FROM "
                    + "     VENDAS VENDAS INNER JOIN VENDAS_PRODUTO VENDAS_PRODUTO ON VENDAS.CODIGO = VENDAS_PRODUTO.CODIGO_VENDA "
                    + "     INNER JOIN CLIENTES CLIENTES ON VENDAS.CLIENTES_CODIGO = CLIENTES.CODIGO "
                    + "     INNER JOIN PRODUTOS PRODUTOS ON VENDAS_PRODUTO.CODIGO_PRODUTO = PRODUTOS.CODIGO, "
                    + "     estado estado INNER JOIN cidade cidade ON estado.codigo = cidade.fk_cod_estado "
                    + "     INNER JOIN empresa empresa ON cidade.codigo = empresa.COD_CIDADE "
                    + "     AND empresa.COD_ESTADO = estado.codigo where VENDAS.CODIGO = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioPDV.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:\\BLVendas\\rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioContaReceber(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     contas_receber.pk_codigo AS contas_receber_pk_codigo, "
                    + "     contas_receber.descricao AS contas_receber_descricao, "
                    + "     contas_receber.data AS contas_receber_data, "
                    + "     contas_receber.vencimento AS contas_receber_vencimento, "
                    + "     contas_receber.observacao AS contas_receber_observacao, "
                    + "     contas_receber.situacao AS contas_receber_situacao, "
                    + "     contas_receber.valor AS contas_receber_valor, "
                    + "     contas_receber.pagamento AS contas_receber_pagamento, "
                    + "     clientes.codigo AS clientes_codigo, "
                    + "     clientes.nome AS clientes_nome, "
                    + "     clientes.nome_fantasia AS clientes_nome_fantasia, "
                    + "     clientes.endereco AS clientes_endereco, "
                    + "     clientes.bairro AS clientes_bairro, "
                    + "     clientes.cep AS clientes_cep, "
                    + "     clientes.telefone AS clientes_telefone, "
                    + "     clientes.cpf_cnpj AS clientes_cpf_cnpj, "
                    + "     clientes.observacao AS clientes_observacao, "
                    + "     clientes.ativo AS clientes_ativo, "
                    + "     clientes.tipo_pessoa AS clientes_tipo_pessoa, "
                    + "     cidade.nome AS cidade_nome, "
                    + "     estado.uf AS estado_uf, "
                    + "     forma_pagamento.descricao AS forma_pagamento_descricao "
                    + "FROM "
                    + "     clientes clientes INNER JOIN contas_receber contas_receber ON clientes.codigo = contas_receber.clientes_codigo "
                    + "     INNER JOIN cidade cidade ON clientes.cod_cidade = cidade.codigo "
                    + "     INNER JOIN estado estado ON cidade.fk_cod_estado = estado.codigo "
                    + "     INNER JOIN forma_pagamento forma_pagamento ON contas_receber.fk_tipo_pagamento = forma_pagamento.codigo "
                    + "WHERE contas_receber.pk_codigo = '" + pCodigo + "';");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioContaReceber.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/BLVendas/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioContaPagar(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     contas_pagar.pk_codigo AS contas_pagar_pk_codigo, "
                    + "     contas_pagar.descricao AS contas_pagar_descricao, "
                    + "     contas_pagar.data AS contas_pagar_data, "
                    + "     contas_pagar.vencimento AS contas_pagar_vencimento, "
                    + "     contas_pagar.observacao AS contas_pagar_observacao, "
                    + "     contas_pagar.situacao AS contas_pagar_situacao, "
                    + "     contas_pagar.valor AS contas_pagar_valor, "
                    + "     contas_pagar.pagamento AS contas_pagar_pagamento, "
                    + "     fornecedores.codigo AS fornecedores_codigo, "
                    + "     fornecedores.nome AS fornecedores_nome, "
                    + "     fornecedores.endereco AS fornecedores_endereco, "
                    + "     fornecedores.bairro AS fornecedores_bairro, "
                    + "     fornecedores.cep AS fornecedores_cep, "
                    + "     fornecedores.telefone AS fornecedores_telefone, "
                    + "     fornecedores.nome_fantasia AS fornecedores_nome_fantasia, "
                    + "     fornecedores.cnpj AS fornecedores_cnpj, "
                    + "     fornecedores.insc_estad AS fornecedores_insc_estad, "
                    + "     cidade.nome AS cidade_nome, "
                    + "     estado.uf AS estado_uf, "
                    + "     forma_pagamento.descricao AS forma_pagamento_descricao "
                    + "FROM "
                    + "     fornecedores fornecedores INNER JOIN contas_pagar contas_pagar ON fornecedores.codigo = contas_pagar.fk_codigo_pessoa "
                    + "     INNER JOIN cidade cidade ON fornecedores.cod_cidade = cidade.codigo "
                    + "     INNER JOIN estado estado ON cidade.fk_cod_estado = estado.codigo "
                    + "     INNER JOIN forma_pagamento forma_pagamento ON contas_pagar.fk_tipo_pagamento = forma_pagamento.codigo "
                    + "WHERE contas_pagar.pk_codigo = " + pCodigo + ";");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioContaPagar.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/BLVendas/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioVendasCliente(Date pDataInicial, Date dataFinal, int pCodigoCliente) {
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     vendas.codigo AS vendas_codigo, "
                    + "     vendas.data_venda AS vendas_data_venda, "
                    + "     vendas.valor_total AS vendas_valor_total, "
                    + "     vendas.desconto AS vendas_desconto, "
                    + "     vendas.observacao AS vendas_observacao, "
                    + "     clientes.codigo AS clientes_codigo, "
                    + "     clientes.nome AS clientes_nome, "
                    + "     clientes.nome_fantasia AS clientes_nome_fantasia, "
                    + "     forma_pagamento.descricao AS forma_pagamento_descricao, "
                    + "     cidade.nome AS cidade_nome, "
                    + "     estado.uf AS estado_uf, "
                    + "     clientes.endereco AS clientes_endereco, "
                    + "     clientes.bairro AS clientes_bairro, "
                    + "     clientes.cod_cidade AS clientes_cod_cidade, "
                    + "     clientes.cep AS clientes_cep, "
                    + "     clientes.telefone AS clientes_telefone, "
                    + "     clientes.cpf_cnpj AS clientes_cpf_cnpj, "
                    + "     clientes.observacao AS clientes_observacao "
                    + "FROM "
                    + "     clientes clientes INNER JOIN vendas vendas ON clientes.codigo = vendas.clientes_codigo "
                    + "     INNER JOIN forma_pagamento forma_pagamento ON vendas.tipo_pagamento = forma_pagamento.codigo "
                    + "     INNER JOIN cidade cidade ON clientes.cod_cidade = cidade.codigo "
                    + "     INNER JOIN estado estado ON cidade.fk_cod_estado = estado.codigo "
                    + "WHERE "
                    + "(data_venda BETWEEN  '" + pDataInicial + "' AND '" + dataFinal + "' )"
                    + "AND (vendas.tipo = 1) "
                    + "AND (clientes.codigo = '" + pCodigoCliente + "')");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioVendasPorCliente.jasper");
            //paramentro
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("title1", "Periodo: " + mascaras.formatarData(pDataInicial) + " à " + mascaras.formatarData(dataFinal));

            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, params, jrRS);

            String nomeArquivo = "C:/BLVendas/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioVendaTodosCliente(Date pDataInicial, Date dataFinal) {
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     vendas.codigo AS vendas_codigo, "
                    + "     vendas.data_venda AS vendas_data_venda, "
                    + "     vendas.valor_total AS vendas_valor_total, "
                    + "     vendas.desconto AS vendas_desconto, "
                    + "     vendas.observacao AS vendas_observacao, "
                    + "     clientes.codigo AS clientes_codigo, "
                    + "     clientes.nome AS clientes_nome, "
                    + "     clientes.nome_fantasia AS clientes_nome_fantasia, "
                    + "     forma_pagamento.descricao AS forma_pagamento_descricao, "
                    + "     cidade.nome AS cidade_nome, "
                    + "     estado.uf AS estado_uf "
                    + "FROM "
                    + "     clientes clientes INNER JOIN vendas vendas ON clientes.codigo = vendas.clientes_codigo "
                    + "     INNER JOIN forma_pagamento forma_pagamento ON vendas.tipo_pagamento = forma_pagamento.codigo "
                    + "     INNER JOIN cidade cidade ON clientes.cod_cidade = cidade.codigo "
                    + "     INNER JOIN estado estado ON cidade.fk_cod_estado = estado.codigo "
                    + "WHERE "
                    + "(data_venda BETWEEN  '" + pDataInicial + "' AND '" + dataFinal + "' )"
                    + "AND (vendas.tipo = 1)");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioVendasPeriodo.jasper");
            //paramentro
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("title1", "Periodo: " + mascaras.formatarData(pDataInicial) + " à " + mascaras.formatarData(dataFinal));

            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, params, jrRS);

            String nomeArquivo = "C:/BLVendas/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Gerar relatório de venda de uma conta a receber
     *
     * @param pCodigo
     * @return
     */
    public boolean gerarRelatorioContaVenda(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     vendas.codigo AS vendas_codigo, "
                    + "     vendas.data_venda AS vendas_data_venda, "
                    + "     vendas.valor_total AS vendas_valor_total, "
                    + "     vendas.desconto AS vendas_desconto, "
                    + "     vendas.tipo AS vendas_tipo, "
                    + "     vendas.observacao AS vendas_observacao, "
                    + "     vendas_produto.codigo AS vendas_produto_codigo, "
                    + "     vendas_produto.quantidade AS vendas_produto_quantidade, "
                    + "     vendas_produto.valor_unitario AS vendas_produto_valor_unitario, "
                    + "     clientes.codigo AS clientes_codigo, "
                    + "     clientes.nome AS clientes_nome, "
                    + "     clientes.nome_fantasia AS clientes_nome_fantasia, "
                    + "     clientes.endereco AS clientes_endereco, "
                    + "     clientes.bairro AS clientes_bairro, "
                    + "     clientes.cep AS clientes_cep, "
                    + "     clientes.telefone AS clientes_telefone, "
                    + "     clientes.cpf_cnpj AS clientes_cpf_cnpj, "
                    + "     clientes.observacao AS clientes_observacao, "
                    + "     clientes.ativo AS clientes_ativo, "
                    + "     clientes.tipo_pessoa AS clientes_tipo_pessoa, "
                    + "     cidade.nome AS cidade_nome, "
                    + "     estado.uf AS estado_uf, "
                    + "     produtos.codigo AS produtos_codigo, "
                    + "     produtos.nome AS produtos_nome, "
                    + "     produtos.valor AS produtos_valor, "
                    + "     produtos.valor_custo AS produtos_valor_custo, "
                    + "     produtos.codigo_barras_ean AS produtos_codigo_barras_ean "
                    + "FROM "
                    + "     vendas vendas INNER JOIN vendas_produto vendas_produto ON vendas.codigo = vendas_produto.codigo_venda "
                    + "     INNER JOIN clientes clientes ON vendas.clientes_codigo = clientes.codigo "
                    + "     INNER JOIN cidade cidade ON clientes.cod_cidade = cidade.codigo "
                    + "     INNER JOIN estado estado ON cidade.fk_cod_estado = estado.codigo "
                    + "     INNER JOIN produtos produtos ON vendas_produto.codigo_produto = produtos.codigo "
                    + " WHERE vendas.codigo = '" + pCodigo + "';");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioContaVendasReceber.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/BLVendas/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioContasReceberCliente(int pCodigoCliente, int pStatus, Date pDataInicial, Date pDataFinal) {
        String pCaminho = "ArquivosJasper/relatorioReceber.jasper";
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     contas_receber.pk_codigo AS contas_receber_pk_codigo, "
                    + "     contas_receber.descricao AS contas_receber_descricao, "
                    + "     contas_receber.data AS contas_receber_data, "
                    + "     contas_receber.vencimento AS contas_receber_vencimento, "
                    + "     contas_receber.observacao AS contas_receber_observacao, "
                    + "     contas_receber.situacao AS contas_receber_situacao, "
                    + "     contas_receber.valor AS contas_receber_valor, "
                    + "     contas_receber.pagamento AS contas_receber_pagamento, "
                    + "     clientes.codigo AS clientes_codigo, "
                    + "     clientes.nome AS clientes_nome "
                    + "FROM "
                    + "     clientes clientes INNER JOIN contas_receber contas_receber ON clientes.codigo = contas_receber.clientes_codigo "
                    + "WHERE (clientes.codigo = '" + pCodigoCliente + "') AND (contas_receber.pagamento BETWEEN  '" + pDataInicial + "' AND '" + pDataFinal + "'"
                    + " ) AND (contas_receber.situacao = '" + pStatus + "');");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream(pCaminho);
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/BLVendas/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioContasPagarFornecedor(int pCodigoFornecedor, int pStatus, Date pDataInicial, Date pDataFinal) {
        String pCaminho = "ArquivosJasper/relatorioContaPagar.jasper";
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     contas_pagar.pk_codigo AS contas_pagar_pk_codigo, "
                    + "     contas_pagar.descricao AS contas_pagar_descricao, "
                    + "     contas_pagar.data AS contas_pagar_data, "
                    + "     contas_pagar.vencimento AS contas_pagar_vencimento, "
                    + "     contas_pagar.observacao AS contas_pagar_observacao, "
                    + "     contas_pagar.situacao AS contas_pagar_situacao, "
                    + "     contas_pagar.valor AS contas_pagar_valor, "
                    + "     contas_pagar.pagamento AS contas_pagar_pagamento, "
                    + "     fornecedores.codigo AS fornecedores_codigo, "
                    + "     fornecedores.nome AS fornecedores_nome, "
                    + "     fornecedores.endereco AS fornecedores_endereco, "
                    + "     fornecedores.bairro AS fornecedores_bairro, "
                    + "     fornecedores.cep AS fornecedores_cep, "
                    + "     fornecedores.telefone AS fornecedores_telefone, "
                    + "     fornecedores.nome_fantasia AS fornecedores_nome_fantasia, "
                    + "     fornecedores.cnpj AS fornecedores_cnpj, "
                    + "     fornecedores.insc_estad AS fornecedores_insc_estad, "
                    + "     cidade.nome AS cidade_nome, "
                    + "     estado.uf AS estado_uf, "
                    + "     forma_pagamento.descricao AS forma_pagamento_descricao "
                    + "FROM "
                    + "     fornecedores fornecedores INNER JOIN contas_pagar contas_pagar ON fornecedores.codigo = contas_pagar.fk_codigo_pessoa "
                    + "     INNER JOIN cidade cidade ON fornecedores.cod_cidade = cidade.codigo "
                    + "     INNER JOIN estado estado ON cidade.fk_cod_estado = estado.codigo "
                    + "     INNER JOIN forma_pagamento forma_pagamento ON contas_pagar.fk_tipo_pagamento = forma_pagamento.codigo "
                    + "WHERE (fornecedores.codigo = '" + pCodigoFornecedor + "') AND (contas_pagar.pagamento BETWEEN  '" + pDataInicial + "' AND '" + pDataFinal + "'"
                    + " ) AND (contas_pagar.situacao = '" + pStatus + "');");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream(pCaminho);
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/BLVendas/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioContasReceberTODAS(int pStatus, Date pDataInicial, Date pDataFinal) {
        String pCaminho = "ArquivosJasper/relatorioReceber.jasper";
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     contas_receber.pk_codigo AS contas_receber_pk_codigo, "
                    + "     contas_receber.descricao AS contas_receber_descricao, "
                    + "     contas_receber.data AS contas_receber_data, "
                    + "     contas_receber.vencimento AS contas_receber_vencimento, "
                    + "     contas_receber.observacao AS contas_receber_observacao, "
                    + "     contas_receber.situacao AS contas_receber_situacao, "
                    + "     contas_receber.valor AS contas_receber_valor, "
                    + "     contas_receber.pagamento AS contas_receber_pagamento, "
                    + "     clientes.codigo AS clientes_codigo, "
                    + "     clientes.nome AS clientes_nome "
                    + "FROM "
                    + "     clientes clientes INNER JOIN contas_receber contas_receber ON clientes.codigo = contas_receber.clientes_codigo "
                    + " WHERE contas_receber.pagamento BETWEEN  '" + pDataInicial + "' AND '" + pDataFinal + "'"
                    + " AND contas_receber.situacao = '" + pStatus + "';");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream(pCaminho);
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/BLVendas/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioContasPagarTODAS(int pStatus, Date pDataInicial, Date pDataFinal) {
        String pCaminho = "ArquivosJasper/relatorioPagar.jasper";
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     cidade.nome AS cidade_nome, "
                    + "     fornecedores.nome AS fornecedores_nome, "
                    + "     estado.uf AS estado_uf, "
                    + "     contas_pagar.pk_codigo AS contas_pagar_pk_codigo, "
                    + "     contas_pagar.descricao AS contas_pagar_descricao, "
                    + "     contas_pagar.data AS contas_pagar_data, "
                    + "     contas_pagar.vencimento AS contas_pagar_vencimento, "
                    + "     contas_pagar.observacao AS contas_pagar_observacao, "
                    + "     contas_pagar.situacao AS contas_pagar_situacao, "
                    + "     contas_pagar.valor AS contas_pagar_valor, "
                    + "     contas_pagar.pagamento AS contas_pagar_pagamento "
                    + "FROM "
                    + "     cidade cidade INNER JOIN fornecedores fornecedores ON cidade.codigo = fornecedores.cod_cidade "
                    + "     INNER JOIN estado estado ON cidade.fk_cod_estado = estado.codigo "
                    + "     INNER JOIN contas_pagar contas_pagar ON fornecedores.codigo = contas_pagar.fk_codigo_pessoa "
                    + " WHERE contas_pagar.pagamento BETWEEN  '" + pDataInicial + "' AND '" + pDataFinal + "'"
                    + " AND contas_pagar.situacao = '" + pStatus + "';");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream(pCaminho);
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/BLVendas/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public ArrayList<RelatorioProduto> gerarRelatorioClienteIndividual(int codigoCidade, Date dataInicial, Date dataFinal) {
        ArrayList<RelatorioProduto> listaprodutosRelatorio = new ArrayList();
        RelatorioProduto modelRelatorioProdutos = new RelatorioProduto();
        try {
            this.conectar();
            //todas cidades
            this.executarSQL("SELECT SUM(vendas_produto.QUANTIDADE) AS quant, "
                    + "     produtos.NOME AS produtos_NOME, "
                    + "     unidade_medida.abreviacao AS unidade_medida_abrevceacao, "
                    + "     vendas_produto.CODIGO_PRODUTO AS vendas_produto_CODIGO_PRODUTO "
                    + "FROM "
                    + "     vendas vendas INNER JOIN vendas_produto vendas_produto ON vendas.CODIGO = vendas_produto.CODIGO_VENDA "
                    + "     INNER JOIN clientes clientes ON vendas.CLIENTES_CODIGO = clientes.CODIGO "
                    + "     INNER JOIN cidade cidade ON clientes.COD_CIDADE = cidade.codigo "
                    + "     INNER JOIN produtos produtos ON vendas_produto.CODIGO_PRODUTO = produtos.CODIGO "
                    + "     INNER JOIN unidade_medida unidade_medida ON produtos.UNIDADE_MEDIDA = unidade_medida.codigo "
                    + "WHERE vendas.DATA_VENDA BETWEEN '" + dataInicial + "' AND '" + dataFinal + "'"
                    + " GROUP BY PRODUTOS.CODIGO;"
            );

            while (this.getResultSet().next()) {
                modelRelatorioProdutos = new RelatorioProduto();
                modelRelatorioProdutos.setQuantidadeProduto(this.getResultSet().getInt(1));
                modelRelatorioProdutos.setNomeProduto(this.getResultSet().getString(2));
                modelRelatorioProdutos.setUnidadeMedida(this.getResultSet().getString(3));
                modelRelatorioProdutos.setCodigoProduto(this.getResultSet().getInt(4));
                listaprodutosRelatorio.add(modelRelatorioProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaprodutosRelatorio;
    }

    public ArrayList<RelatorioProduto> retornarProdutosTodasCidadeController(int codigoCidade, Date dataInicial, Date dataFinal) {
        ArrayList<RelatorioProduto> listaprodutosRelatorio = new ArrayList();
        RelatorioProduto modelRelatorioProdutos = new RelatorioProduto();
        try {
            this.conectar();
            //todas cidades
            this.executarSQL("SELECT SUM(vendas_produto.QUANTIDADE) AS quant, "
                    + "     produtos.NOME AS produtos_NOME, "
                    + "     unidade_medida.abreviacao AS unidade_medida_abreviacao, "
                    + "     cidade.nome AS cidade_nome, "
                    + "     produtos.CODIGO AS produtos_CODIGO, "
                    + "     estado.nome AS estado_nome  "
                    + "FROM "
                    + " produtos produtos INNER JOIN vendas_produto vendas_produto ON produtos.CODIGO = vendas_produto.CODIGO_PRODUTO "
                    + "     INNER JOIN vendas vendas ON vendas_produto.CODIGO_VENDA = vendas.CODIGO "
                    + "     INNER JOIN clientes clientes ON vendas.CLIENTES_CODIGO = clientes.CODIGO "
                    + "     INNER JOIN cidade cidade ON clientes.COD_CIDADE = cidade.codigo "
                    + "     INNER JOIN estado estado ON cidade.fk_cod_estado = estado.codigo "
                    + "     INNER JOIN unidade_medida unidade_medida ON produtos.UNIDADE_MEDIDA = unidade_medida.codigo "
                    + "WHERE vendas.DATA_VENDA BETWEEN '" + dataInicial + "' AND '" + dataFinal + "'"
                    + "     GRoUP BY cidade.codigo, PRODUTOS.CODIGO ORDER BY cidade.nome asc;"
            );

            while (this.getResultSet().next()) {
                modelRelatorioProdutos = new RelatorioProduto();
                modelRelatorioProdutos.setQuantidadeProduto(this.getResultSet().getInt(1));
                modelRelatorioProdutos.setNomeProduto(this.getResultSet().getString(2));
                modelRelatorioProdutos.setUnidadeMedida(this.getResultSet().getString(3));
                modelRelatorioProdutos.setCidade(this.getResultSet().getString(4));
                modelRelatorioProdutos.setCodigoProduto(this.getResultSet().getInt(5));
                modelRelatorioProdutos.setEstado(this.getResultSet().getString(6));
                listaprodutosRelatorio.add(modelRelatorioProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaprodutosRelatorio;
    }

    public boolean gerarRelatorioCompraDAO(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     compras.codigo AS compras_codigo, "
                    + "     compras.valor_total AS compras_valor_total, "
                    + "     compras.data AS compras_data, "
                    + "     compras_produtos.valor_custo AS compras_produtos_valor_custo, "
                    + "     compras_produtos.valor_venda AS compras_produtos_valor_venda, "
                    + "     compras_produtos.quantidade AS compras_produtos_quantidade, "
                    + "     produtos.codigo AS produtos_codigo, "
                    + "     produtos.nome AS produtos_nome, "
                    + "     produtos.codigo_barras_ean AS produtos_codigo_barras_ean, "
                    + "     fornecedores.nome AS fornecedores_nome, "
                    + "     unidade_medida.abreviacao AS unidade_medida_abreviacao, "
                    + "     produtos.marca AS produtos_marca "
                    + "FROM "
                    + "     compras compras INNER JOIN compras_produtos compras_produtos ON compras.codigo = compras_produtos.cod_compras "
                    + "     INNER JOIN produtos produtos ON compras_produtos.cod_produto = produtos.codigo "
                    + "     INNER JOIN fornecedores fornecedores ON produtos.fornecedores_codigo = fornecedores.codigo "
                    + "     INNER JOIN unidade_medida unidade_medida ON produtos.unidade_medida = unidade_medida.codigo "
                    + " WHERE compras.codigo = '" + pCodigo + "';");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioCompras.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/BLVendas/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean vizualizarPedidoDaMesa(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     itens_pedido_mesa.codigo AS itens_pedido_mesa_codigo, "
                    + "     itens_pedido_mesa.fk_codigo_mesa AS itens_pedido_mesa_fk_codigo_mesa, "
                    + "     itens_pedido_mesa.fk_codigo_produto AS itens_pedido_mesa_fk_codigo_produto, "
                    + "     itens_pedido_mesa.status_pedido AS itens_pedido_mesa_status_pedido, "
                    + "     itens_pedido_mesa.observacao AS itens_pedido_mesa_observacao, "
                    + "     itens_pedido_mesa.quantidade AS itens_pedido_mesa_quantidade, "
                    + "     mesas.codigo AS mesas_codigo, "
                    + "     mesas.numero_mesa AS mesas_numero_mesa, "
                    + "     mesas.situacao_mesa AS mesas_situacao_mesa, "
                    + "     produtos.CODIGO AS produtos_CODIGO, "
                    + "     produtos.FORNECEDORES_CODIGO AS produtos_FORNECEDORES_CODIGO, "
                    + "     produtos.NOME AS produtos_NOME, "
                    + "     produtos.VALOR AS produtos_VALOR, "
                    + "     produtos.ESTOQUE AS produtos_ESTOQUE, "
                    + "     produtos.CODIGO_BARRAS AS produtos_CODIGO_BARRAS, "
                    + "     empresa.RAZAO_SOCIAL AS empresa_RAZAO_SOCIAL, "
                    + "     empresa.NOME_FANTASIA AS empresa_NOME_FANTASIA, "
                    + "     empresa.ENDERECO AS empresa_ENDERECO, "
                    + "     empresa.BAIRRO AS empresa_BAIRRO, "
                    + "     empresa.CEP AS empresa_CEP, "
                    + "     empresa.TELEFONE AS empresa_TELEFONE, "
                    + "     empresa.CNPJ AS empresa_CNPJ, "
                    + "     cidade.nome AS cidade_nome, "
                    + "     estado.codigo AS estado_codigo, "
                    + "     estado.uf AS estado_uf "
                    + " FROM "
                    + "     itens_pedido_mesa itens_pedido_mesa INNER JOIN mesas mesas ON itens_pedido_mesa.fk_codigo_mesa = mesas.codigo "
                    + "     INNER JOIN produtos produtos ON itens_pedido_mesa.fk_codigo_produto = produtos.CODIGO, "
                    + "     cidade cidade INNER JOIN empresa empresa ON cidade.codigo = empresa.COD_CIDADE "
                    + "     INNER JOIN estado estado ON empresa.COD_ESTADO = estado.codigo where mesas.numero_mesa = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioPedidoMesa.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/BLVendas/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean gerarRelatorioPedidoCozinha(int pCodigo) {
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "     itens_pedido_mesa.codigo AS itens_pedido_mesa_codigo, "
                    + "     itens_pedido_mesa.fk_codigo_mesa AS itens_pedido_mesa_fk_codigo_mesa, "
                    + "     itens_pedido_mesa.fk_codigo_produto AS itens_pedido_mesa_fk_codigo_produto, "
                    + "     itens_pedido_mesa.status_pedido AS itens_pedido_mesa_status_pedido, "
                    + "     itens_pedido_mesa.observacao AS itens_pedido_mesa_observacao, "
                    + "     itens_pedido_mesa.quantidade AS itens_pedido_mesa_quantidade, "
                    + "     mesas.codigo AS mesas_codigo, "
                    + "     mesas.numero_mesa AS mesas_numero_mesa, "
                    + "     mesas.situacao_mesa AS mesas_situacao_mesa, "
                    + "     produtos.CODIGO AS produtos_CODIGO, "
                    + "     produtos.FORNECEDORES_CODIGO AS produtos_FORNECEDORES_CODIGO, "
                    + "     produtos.NOME AS produtos_NOME, "
                    + "     produtos.VALOR AS produtos_VALOR, "
                    + "     produtos.ESTOQUE AS produtos_ESTOQUE, "
                    + "     produtos.CODIGO_BARRAS AS produtos_CODIGO_BARRAS "
                    + "FROM "
                    + "     itens_pedido_mesa itens_pedido_mesa INNER JOIN mesas mesas ON itens_pedido_mesa.fk_codigo_mesa = mesas.codigo "
                    + "     INNER JOIN produtos produtos ON itens_pedido_mesa.fk_codigo_produto = produtos.CODIGO where mesas.numero_mesa = '" + pCodigo + "'");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioCozinha.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/BLVendas/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean vizualizarMesaDAO(int pCodigo) {
        try {
            this.conectar();
            String sql = "SELECT "
                    + "     itens_pedido_mesa.codigo AS itens_pedido_mesa_codigo, "
                    + "     itens_pedido_mesa.status_pedido AS itens_pedido_mesa_status_pedido, "
                    + "     itens_pedido_mesa.observacao AS itens_pedido_mesa_observacao, "
                    + "     itens_pedido_mesa.quantidade AS itens_pedido_mesa_quantidade, "
                    + "     itens_pedido_mesa.horario AS itens_pedido_mesa_horario, "
                    + "     itens_pedido_mesa.codigo_mesa AS itens_pedido_mesa_codigo_mesa, "
                    + "     produtos.nome AS produtos_nome, "
                    + "     produtos.descricao_produto AS produtos_descricao_produto, "
                    + "     produtos.valor AS produtos_valor, "
                    + "     produtos.valor_custo AS produtos_valor_custo, "
                    + "     unidade_medida.abreviacao AS unidade_medida_abreviacao, "
                    + "     empresa.razao_social AS empresa_razao_social, "
                    + "     empresa.nome_fantasia AS empresa_nome_fantasia, "
                    + "     empresa.endereco AS empresa_endereco, "
                    + "     empresa.endereco_numero AS empresa_endereco_numero, "
                    + "     empresa.complemento AS empresa_complemento, "
                    + "     empresa.bairro AS empresa_bairro, "
                    + "     empresa.cep AS empresa_cep, "
                    + "     empresa.telefone AS empresa_telefone, "
                    + "     empresa.insc_estad AS empresa_insc_estad, "
                    + "     empresa.cnpj AS empresa_cnpj, "
                    + "     cidade.nome AS cidade_nome, "
                    + "     estado.uf AS estado_uf "
                    + "FROM "
                    + "     produtos produtos INNER JOIN itens_pedido_mesa itens_pedido_mesa ON produtos.codigo = itens_pedido_mesa.codigo_produto "
                    + "     INNER JOIN unidade_medida unidade_medida ON produtos.unidade_medida = unidade_medida.codigo, "
                    + "     cidade cidade INNER JOIN empresa empresa ON cidade.codigo = empresa.cod_cidade "
                    + "     INNER JOIN estado estado ON cidade.fk_cod_estado = estado.codigo "
                    + "WHERE itens_pedido_mesa.codigo_mesa = '" + pCodigo + "'";
            System.out.println(sql);
            this.executarSQL(sql);
            JRResultSetDataSource jrRS = new JRResultSetDataSource(getResultSet());
            // caminho do arquivo dentro dos pacotes  
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("ArquivosJasper/relatorioMesa.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRS);

            String nomeArquivo = "C:/BLVendas/rel.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, nomeArquivo);
            File file = new File(nomeArquivo);
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

}
