package com.inosystem.pdv.view;

import com.inosystem.pdv.contoller.CidadeController;
import com.inosystem.pdv.contoller.ClienteCidadeEstadoController;
import com.inosystem.pdv.contoller.EstadoController;
import com.inosystem.pdv.contoller.RelatorioProdutoController;
import com.inosystem.pdv.model.Cidade;
import com.inosystem.pdv.model.Estado;
import com.inosystem.pdv.model.RelatorioProduto;
import com.inosystem.pdv.util.AguardeGerandoRelatorio;
import com.inosystem.pdv.util.Mascara;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.awt.Desktop;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
public class ViewRelatorioProduto extends javax.swing.JFrame {

    EstadoController EstadoController = new EstadoController();
    CidadeController controllerCidade = new CidadeController();
    ClienteCidadeEstadoController controllerClienteCidadeEstado = new ClienteCidadeEstadoController();
    ArrayList<Cidade> listaCidades = new ArrayList<>();
    ArrayList<Estado> listaEstados = new ArrayList<>();
    RelatorioProduto modelRelatorioProdutos = new RelatorioProduto();
    ArrayList<RelatorioProduto> listaRelatorioProdutoses = new ArrayList<>();
    RelatorioProdutoController controllerRelatorioProdutos = new RelatorioProdutoController();
    Mascara bLMascaras = new Mascara();

    /**
     * Creates new form ViewRelatorioProduto
     */
    public ViewRelatorioProduto() {
        initComponents();
        setLocationRelativeTo(null);
        limparCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProdutos = new javax.swing.JTable();
        jrbCidade = new javax.swing.JRadioButton();
        jrbTodasCidades = new javax.swing.JRadioButton();
        btGerar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jbImprimir = new javax.swing.JButton();
        jdcInicio = new com.toedter.calendar.JDateChooser();
        jdcFim = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de produtos");

        jtProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod Produto", "Nome Prodduto", "Unidade Medida", "Quant.", "Cidade", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProdutos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtProdutos);

        buttonGroup1.add(jrbCidade);
        jrbCidade.setSelected(true);
        jrbCidade.setText("Por cidade");
        jrbCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbCidadeActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbTodasCidades);
        jrbTodasCidades.setText("Todas Cidades");
        jrbTodasCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTodasCidadesActionPerformed(evt);
            }
        });

        btGerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-caixa-de-seleção-marcada-filled-50.png"))); // NOI18N
        btGerar.setText("Gerar dados");
        btGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-fechar-janela-filled-50.png"))); // NOI18N
        jButton2.setText("Limpar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jbImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pdf-2-filled-50.png"))); // NOI18N
        jbImprimir.setText("Vizualizar/Imprimir");
        jbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirActionPerformed(evt);
            }
        });

        jLabel1.setText("De:");

        jLabel2.setText("a:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jdcFim, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jrbCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrbTodasCidades)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(btGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbImprimir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jrbCidade)
                        .addComponent(jrbTodasCidades)
                        .addComponent(btGerar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jbImprimir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirActionPerformed
        final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
        carregando.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                // imprimir
                if (jrbCidade.isSelected()) {
                    relatorioPorCidade();
                } else {
                    relatorioTodasCidades();
                }
                carregando.dispose();
            }
        };
        t.start();
    }//GEN-LAST:event_jbImprimirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void relatorioTodasCidades() {
        try {
            DefaultTableModel de = (DefaultTableModel) jtProdutos.getModel();
            JRTableModelDataSource dataSource = new JRTableModelDataSource(de);
            String reportSource = "C:/BLVendas/src/ArquivosJasper/produtosTodosCliente.jrxml";

            JasperReport jr = JasperCompileManager.compileReport(reportSource);

            Map<String, Object> params = new HashMap<String, Object>();
            params.put("title1", "Periodo: " + bLMascaras.formatarData(jdcInicio.getDate()) + " à " + bLMascaras.formatarData(jdcFim.getDate()));

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
    }

    private void relatorioPorCidade() {
        try {
            DefaultTableModel de = (DefaultTableModel) jtProdutos.getModel();
            JRTableModelDataSource dataSource = new JRTableModelDataSource(de);
            String reportSource = "C:/BLVendas/src/ArquivosJasper/produtosTodosCliente.jrxml";

            JasperReport jr = JasperCompileManager.compileReport(reportSource);

            Map<String, Object> params = new HashMap<String, Object>();
            params.put("title1", "Periodo: " + bLMascaras.formatarData(jdcInicio.getDate()) + " à " + bLMascaras.formatarData(jdcFim.getDate()));

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
    }

    private void limparCampos() {
        DefaultTableModel modelo = (DefaultTableModel) jtProdutos.getModel();
        modelo.setNumRows(0);
        jdcInicio.setDate(new java.util.Date());
        jdcFim.setDate(new java.util.Date());
    }

    private void btGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerarActionPerformed
        // TODO add your handling code here:
        processarRelatorio();

    }//GEN-LAST:event_btGerarActionPerformed

    private void jrbCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCidadeActionPerformed
        // TODO add your handling code here:
        processarRelatorio();
    }//GEN-LAST:event_jrbCidadeActionPerformed

    private void jrbTodasCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTodasCidadesActionPerformed
        // TODO add your handling code here:
        processarRelatorio();
    }//GEN-LAST:event_jrbTodasCidadesActionPerformed

    private void processarRelatorio() {
        try {
            Date dataInicial = null, dataFinal = null;
            int codigoCidade = 0;
            try {
                dataInicial = bLMascaras.converterDataParaDateUS(bLMascaras.converterDataParaDateUS(jdcInicio.getDate()));
                dataFinal = bLMascaras.converterDataParaDateUS(bLMascaras.converterDataParaDateUS(jdcFim.getDate()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Informe as datas de inicio e fim para pesquisar!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            }

            if (jrbCidade.isSelected()) {
                listaRelatorioProdutoses = controllerRelatorioProdutos.retornarProdutosCidadeController(codigoCidade, dataInicial, dataFinal);

                DefaultTableModel modelo = (DefaultTableModel) jtProdutos.getModel();
                modelo.setNumRows(0);
                //CARREGA OS DADOS DA LISTA NA TABELA
                int cont = listaRelatorioProdutoses.size();
                for (int i = 0; i < cont; i++) {
                    modelo.addRow(new Object[]{
                        listaRelatorioProdutoses.get(i).getCodigoProduto(),
                        listaRelatorioProdutoses.get(i).getNomeProduto(),
                        listaRelatorioProdutoses.get(i).getUnidadeMedida(),
                        listaRelatorioProdutoses.get(i).getQuantidadeProduto(),
                        "AGRUPADOS",
                        "AGRUPADOS"
                    });
                }
            } else {
                listaRelatorioProdutoses = controllerRelatorioProdutos.retornarProdutosTodasCidadeController(codigoCidade, dataInicial, dataFinal);

                DefaultTableModel modelo = (DefaultTableModel) jtProdutos.getModel();
                modelo.setNumRows(0);
                //CARREGA OS DADOS DA LISTA NA TABELA
                int cont = listaRelatorioProdutoses.size();
                for (int i = 0; i < cont; i++) {
                    modelo.addRow(new Object[]{
                        listaRelatorioProdutoses.get(i).getCodigoProduto(),
                        listaRelatorioProdutoses.get(i).getNomeProduto(),
                        listaRelatorioProdutoses.get(i).getUnidadeMedida(),
                        listaRelatorioProdutoses.get(i).getQuantidadeProduto(),
                        listaRelatorioProdutoses.get(i).getCidade(),
                        listaRelatorioProdutoses.get(i).getEstado()
                    });
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Você deve preencher todos os campos!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        }
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
            java.util.logging.Logger.getLogger(ViewRelatorioProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewRelatorioProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewRelatorioProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewRelatorioProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRelatorioProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGerar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbImprimir;
    private com.toedter.calendar.JDateChooser jdcFim;
    private com.toedter.calendar.JDateChooser jdcInicio;
    private javax.swing.JRadioButton jrbCidade;
    private javax.swing.JRadioButton jrbTodasCidades;
    private javax.swing.JTable jtProdutos;
    // End of variables declaration//GEN-END:variables
}
