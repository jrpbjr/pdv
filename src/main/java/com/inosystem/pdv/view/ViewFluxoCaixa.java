package com.inosystem.pdv.view;

import com.inosystem.pdv.contoller.ClienteController;
import com.inosystem.pdv.contoller.ContaPagarController;
import com.inosystem.pdv.contoller.ContaReceberController;
import com.inosystem.pdv.contoller.FormaPagamentoController;
import com.inosystem.pdv.contoller.FornecedorController;
import com.inosystem.pdv.contoller.VendaController;
import com.inosystem.pdv.model.Cliente;
import com.inosystem.pdv.model.ContaPagar;
import com.inosystem.pdv.model.ContaReceber;
import com.inosystem.pdv.model.FormaPagamento;
import com.inosystem.pdv.model.Fornecedor;
import com.inosystem.pdv.model.Venda;
import com.inosystem.pdv.util.AguardeGerandoRelatorio;
import com.inosystem.pdv.util.Mascara;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;

/**
 *
 * @author Jrpbjr
 */
public class ViewFluxoCaixa extends javax.swing.JFrame {

    ContaPagar modelContasPagar = new ContaPagar();
    ContaReceber modelContasReceber = new ContaReceber();
    ClienteController controllerCliente = new ClienteController();
    FornecedorController controllerFornecedor = new FornecedorController();
    ArrayList<ContaPagar> listaModelContasPagar = new ArrayList<>();
    ArrayList<ContaReceber> listaModelContasReceber = new ArrayList<>();
    ContaPagarController controllerContasPagar = new ContaPagarController();
    ContaReceberController controllerContaReceber = new ContaReceberController();
    FormaPagamentoController controllerTipoPagamento = new FormaPagamentoController();
    ArrayList<FormaPagamento> listaModelTipoPagamentos = new ArrayList<>();
    ArrayList<Cliente> listaClientes = new ArrayList<>();
    ArrayList<Fornecedor> listaFornecedor = new ArrayList<>();
    VendaController controllerVendas = new VendaController();
    ArrayList<Venda> listaVendas = new ArrayList<>();
    Mascara bLMascaras = new Mascara();
    Venda modelVendas = new Venda();

    /**
     * Creates new form ViewFluxoCaixa
     */
    public ViewFluxoCaixa() {
        initComponents();
        setLocationRelativeTo(null);
        //pega a data de hoje
        this.jdDataInicio.setDate(new java.util.Date());
        this.jdDataFim.setDate(new java.util.Date());
        carregarContas();
        somaEAtualizaValorTotal();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tbFluxoCaixa = new javax.swing.JTable();
        jbVisualizarConta = new javax.swing.JButton();
        jbCancelar2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jlDebito = new javax.swing.JLabel();
        jlCredito = new javax.swing.JLabel();
        jlSaldoTotalCaixa = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jdDataInicio = new com.toedter.calendar.JDateChooser();
        jbAtualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jdDataFim = new com.toedter.calendar.JDateChooser();
        jtRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fluxo de caixa");
        setIconImage(new ImageIcon(getClass().getResource("/imagens/blicon.png")).getImage());
        setResizable(false);

        tbFluxoCaixa.setAutoCreateRowSorter(true);
        tbFluxoCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Cliente", "Data", "Vencimento", "Valor", "Tipo", "Forma de pagamento", "Tipo C/V"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbFluxoCaixa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbFluxoCaixa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbFluxoCaixa.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbFluxoCaixa);
        if (tbFluxoCaixa.getColumnModel().getColumnCount() > 0) {
            tbFluxoCaixa.getColumnModel().getColumn(0).setMinWidth(70);
            tbFluxoCaixa.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbFluxoCaixa.getColumnModel().getColumn(0).setMaxWidth(70);
            tbFluxoCaixa.getColumnModel().getColumn(1).setMinWidth(200);
            tbFluxoCaixa.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbFluxoCaixa.getColumnModel().getColumn(2).setMinWidth(200);
            tbFluxoCaixa.getColumnModel().getColumn(2).setPreferredWidth(200);
            tbFluxoCaixa.getColumnModel().getColumn(6).setMinWidth(100);
            tbFluxoCaixa.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        jbVisualizarConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pdf-2-filled-50.png"))); // NOI18N
        jbVisualizarConta.setText("Visualizar conta");
        jbVisualizarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVisualizarContaActionPerformed(evt);
            }
        });

        jbCancelar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-fechar-janela-filled-50.png"))); // NOI18N
        jbCancelar2.setText("Cancelar");
        jbCancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelar2ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(102, 255, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setText("Total Debito:");

        jLabel10.setText("Total Credito:");

        jLabel11.setText("Saldo do dia:");

        jLabel12.setText("R$");

        jLabel13.setText("R$");

        jLabel14.setText("R$");

        jlDebito.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jlDebito.setText("jLabel7");

        jlCredito.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jlCredito.setText("jLabel8");

        jlSaldoTotalCaixa.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jlSaldoTotalCaixa.setText("jLabel9");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlSaldoTotalCaixa))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(30, 30, 30)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlDebito))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlCredito)))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(jlDebito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(jlCredito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14)
                    .addComponent(jlSaldoTotalCaixa))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("De:");

        jdDataInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jdDataInicioFocusLost(evt);
            }
        });

        jbAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-atualizações-disponíveis-filled-50.png"))); // NOI18N
        jbAtualizar.setText("Atualizar");
        jbAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-binóculos-filled-50.png"))); // NOI18N
        jButton1.setText("Filtrar dados pelo periodo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("a:");

        jtRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pdf-2-filled-50.png"))); // NOI18N
        jtRelatorio.setText("Gerar relatório");
        jtRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbCancelar2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbVisualizarConta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtRelatorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jdDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addComponent(jdDataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbVisualizarConta)
                        .addComponent(jbAtualizar)
                        .addComponent(jbCancelar2)
                        .addComponent(jtRelatorio))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbVisualizarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVisualizarContaActionPerformed
        final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
        int linha = tbFluxoCaixa.getSelectedRow();
        final int codigo = (int) tbFluxoCaixa.getValueAt(linha, 0);
        final String tipo = (String) tbFluxoCaixa.getValueAt(linha, 6);
        final String tipoCV = (String) tbFluxoCaixa.getValueAt(linha, 8);
        carregando.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                // gerar pdf
                if (tipoCV.equals("VENDA")) {
                    controllerContasPagar.gerarRelatorioContaVenda(codigo);
                } else {
                    if (tipo.equals("DÉBITO")) {
                        controllerContasPagar.gerarRelatorioContaPagar(codigo);
                    } else if (tipo.equals("CRÉDITO")) {
                        controllerContaReceber.gerarRelatorioContaReceber(codigo);
                    }
                }

                carregando.dispose();
            }
        };
        t.start();


    }//GEN-LAST:event_jbVisualizarContaActionPerformed

    private void jbCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelar2ActionPerformed
        // TODO add your handling code here:
        this.jdDataInicio.setDate(new java.util.Date());
        carregarContas();
    }//GEN-LAST:event_jbCancelar2ActionPerformed

    private void jbAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarActionPerformed
        // TODO add your handling code here:
        carregarContas();
        somaEAtualizaValorTotal();
    }//GEN-LAST:event_jbAtualizarActionPerformed

    private void jdDataInicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jdDataInicioFocusLost
        // TODO add your handling code here:
        carregarContas();
        somaEAtualizaValorTotal();
    }//GEN-LAST:event_jdDataInicioFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        carregarContas();
        somaEAtualizaValorTotal();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtRelatorioActionPerformed
        // TODO add your handling code here:
            try {
                DefaultTableModel de = (DefaultTableModel) tbFluxoCaixa.getModel();
                JRTableModelDataSource dataSource = new JRTableModelDataSource(de);
                String reportSource = "C:/BLVendas/src/ArquivosJasper/fluxoCaixaRelatorio.jrxml";

                JasperReport jr = JasperCompileManager.compileReport(reportSource);

                Map<String, Object> params = new HashMap<String, Object>();
                params.put("title1", "Periodo: " + bLMascaras.formatarData(jdDataInicio.getDate()) + " à " + bLMascaras.formatarData(jdDataFim.getDate()));

                JasperPrint jp = JasperFillManager.fillReport(jr, params, dataSource);

                String nomeArquivo = "C:/BLVendas/rel.pdf";
                JasperExportManager.exportReportToPdfFile(jp, nomeArquivo);
                File file = new File(nomeArquivo);
                try {
                    Desktop.getDesktop().open(file);
                } catch (Exception e) {
                    JOptionPane.showConfirmDialog(null, e);
                }
                file.deleteOnExit();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }//GEN-LAST:event_jtRelatorioActionPerformed

    private void carregarContas() {
        DefaultTableModel modelo = (DefaultTableModel) tbFluxoCaixa.getModel();
        //seta situação 1 como paga
        modelContasPagar.setSituacao(1);
        try {
            modelContasPagar.setData(bLMascaras.converterDataParaDateUS(jdDataInicio.getDate()));
            modelContasPagar.setPagamento(bLMascaras.converterDataParaDateUS(jdDataFim.getDate()));
            modelVendas.setDataVenda(bLMascaras.converterDataParaDateUS(jdDataInicio.getDate()));
            modelVendas.setDataPagamento(bLMascaras.converterDataParaDateUS(jdDataFim.getDate()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Você deve preencher as datas de inicio e fim!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        }
        listaModelContasPagar = controllerContasPagar.getListaContasController(modelContasPagar);
        listaVendas = controllerVendas.getListaPedidosController(modelVendas);
        modelo.setNumRows(0);
        String nomePessoa, tipoPagamento = "";
        //CARREGA OS DADOS DA LISTA NA TABELA as contas a pagar
        int contPagar = listaModelContasPagar.size();
        for (int i = 0; i < contPagar; i++) {
            nomePessoa = controllerFornecedor.getFornecedorController(listaModelContasPagar.get(i).getCodigoPessoa()).getNome();
            tipoPagamento = controllerTipoPagamento.getFormaPagamentoController(listaModelContasPagar.get(i).getTipoPagamento()).getDescricao();

            modelo.addRow(new Object[]{
                listaModelContasPagar.get(i).getCodigo(),
                listaModelContasPagar.get(i).getDescricao(),
                nomePessoa,
                bLMascaras.formatarData(listaModelContasPagar.get(i).getData()),
                bLMascaras.formatarData(listaModelContasPagar.get(i).getVencimento()),
                listaModelContasPagar.get(i).getValor(),
                "DÉBITO",
                tipoPagamento,
                "CONTA"
            });
        }

        modelContasReceber.setSituacao(1);
        try {
            modelContasReceber.setData(bLMascaras.converterDataParaDateUS(jdDataInicio.getDate()));
            modelContasReceber.setPagamento(bLMascaras.converterDataParaDateUS(jdDataFim.getDate()));
        } catch (Exception ex) {
            Logger.getLogger(ViewFluxoCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        listaModelContasReceber = controllerContaReceber.getListaContasController(modelContasReceber);
        //CARREGA OS DADOS DA LISTA NA TABELA as contas receber
        int contReceber = listaModelContasReceber.size();
        for (int i = 0; i < contReceber; i++) {
            nomePessoa = controllerCliente.getClienteController(listaModelContasReceber.get(i).getCodigoPessoa()).getNome();
            tipoPagamento = controllerTipoPagamento.getFormaPagamentoController(listaModelContasReceber.get(i).getTipoPagamento()).getDescricao();
            modelo.addRow(new Object[]{
                listaModelContasReceber.get(i).getCodigo(),
                listaModelContasReceber.get(i).getDescricao(),
                nomePessoa,
                bLMascaras.formatarData(listaModelContasReceber.get(i).getData()),
                bLMascaras.formatarData(listaModelContasReceber.get(i).getVencimento()),
                listaModelContasReceber.get(i).getValor(),
                "CRÉDITO",
                tipoPagamento,
                "CONTA"
            });
        }

        //CARREGA OS DADOS DA LISTA NA TABELA as vendas
        int cont2 = listaVendas.size();
        for (int i = 0; i < cont2; i++) {
            nomePessoa = controllerCliente.getClienteController(listaVendas.get(i).getClientesCodigo()).getNome();
            tipoPagamento = controllerTipoPagamento.getFormaPagamentoController(listaVendas.get(i).getTipoPagamento()).getDescricao();
            modelo.addRow(new Object[]{
                listaVendas.get(i).getCodigo(),
                "VENDA DE PRODUTO NO CAIXA",
                nomePessoa,
                bLMascaras.formatarData(listaVendas.get(i).getDataVenda()),
                bLMascaras.formatarData(listaVendas.get(i).getDataVenda()),
                listaVendas.get(i).getValorTotal(),
                "CRÉDITO",
                tipoPagamento,
                "VENDA"
            });
        }
    }

    /**
     * Soma e atualiza os valores total
     *
     * @return
     */
    private void somaEAtualizaValorTotal() {
        float totalPagar = 0;
        float totalReceber = 0;
        float valorPagar = 0;
        float valorReceber = 0;
        int cont = tbFluxoCaixa.getRowCount();
        for (int i = 0; i < cont; i++) {
            if (tbFluxoCaixa.getValueAt(i, 6).equals("DÉBITO")) {
                valorPagar = Float.parseFloat(String.valueOf(tbFluxoCaixa.getValueAt(i, 5)));
                totalPagar = valorPagar + totalPagar;
            } else {
                valorReceber = Float.parseFloat(String.valueOf(tbFluxoCaixa.getValueAt(i, 5)));
                totalReceber = valorReceber + totalReceber;
            }
        }
        jlDebito.setText(bLMascaras.arredondamentoComPontoDuasCasasString(totalPagar));
        jlCredito.setText(bLMascaras.arredondamentoComPontoDuasCasasString(totalReceber));
        jlSaldoTotalCaixa.setText(bLMascaras.arredondamentoComPontoDuasCasasString(totalReceber - totalPagar));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewFluxoCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewFluxoCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewFluxoCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewFluxoCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewFluxoCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbAtualizar;
    private javax.swing.JButton jbCancelar2;
    private javax.swing.JButton jbVisualizarConta;
    private com.toedter.calendar.JDateChooser jdDataFim;
    private com.toedter.calendar.JDateChooser jdDataInicio;
    private static javax.swing.JLabel jlCredito;
    private static javax.swing.JLabel jlDebito;
    private static javax.swing.JLabel jlSaldoTotalCaixa;
    private javax.swing.JButton jtRelatorio;
    private javax.swing.JTable tbFluxoCaixa;
    // End of variables declaration//GEN-END:variables
}
