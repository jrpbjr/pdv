/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.inosystem.pdv.view;


import com.inosystem.pdv.contoller.ContaPagarController;
import com.inosystem.pdv.contoller.FormaPagamentoController;
import com.inosystem.pdv.contoller.FornecedorController;
import com.inosystem.pdv.model.ContaPagar;
import com.inosystem.pdv.model.FormaPagamento;
import com.inosystem.pdv.model.Fornecedor;
import com.inosystem.pdv.util.Mascara;
import java.util.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


/**
 *
 * @author Jrpbjr
 */
public class ViewRelatoriosContasPagar extends javax.swing.JFrame {
    
    ContaPagarController controllerContaPagar = new ContaPagarController();
    ContaPagar modelContaPagar = new ContaPagar();
    FornecedorController controllerFornecedor = new FornecedorController();
    ArrayList<ContaPagar> listamContaPagar = new ArrayList<>();
    FormaPagamentoController controllerFormaPagamento = new FormaPagamentoController();
    ArrayList<FormaPagamento> listaFormaPagamentos = new ArrayList<>();
    ArrayList<Fornecedor> listaFornecedor = new ArrayList<>();
    Fornecedor modelFornecedor = new Fornecedor();
    Mascara bLMascaras = new Mascara();

    /**
     * Creates new form ViewRelatoriosContas
     */
    public ViewRelatoriosContasPagar() {
        initComponents();
        this.jdDataInicio.setDate(new java.util.Date());
        this.jdDataTermino.setDate(new java.util.Date());
        setLocationRelativeTo(null);
        this.listarFornecedores();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jrbPagar = new javax.swing.JRadioButton();
        jrbPagas = new javax.swing.JRadioButton();
        jbCancelar = new javax.swing.JButton();
        jbGerarRelatorio = new javax.swing.JButton();
        jdDataInicio = new com.toedter.calendar.JDateChooser();
        jdDataTermino = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cbCodFornecedor = new javax.swing.JComboBox();
        cbFornecedor = new javax.swing.JComboBox();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de contas pagar");
        setIconImage(new ImageIcon(getClass().getResource("/imagens/blicon.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecione a conta"));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        buttonGroup1.add(jrbPagar);
        jrbPagar.setSelected(true);
        jrbPagar.setText("Contas a pagar");

        buttonGroup1.add(jrbPagas);
        jrbPagas.setText("Contas pagas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jrbPagar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jrbPagas)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbPagar)
                    .addComponent(jrbPagas))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-fechar-janela-filled-50.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbGerarRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-pdf-2-filled-50.png"))); // NOI18N
        jbGerarRelatorio.setText("Gerar relatório");
        jbGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGerarRelatorioActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Entre datas");

        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("De:");

        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("até:");

        jPanel3.setBackground(new java.awt.Color(153, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecione a conta"));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        cbCodFornecedor.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbCodFornecedorPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbFornecedor.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbFornecedorPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbCodFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCodFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 67, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jdDataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbGerarRelatorio)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jdDataTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jdDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbGerarRelatorio))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGerarRelatorioActionPerformed
        Date dataInicial = null, dataFinal = null;
        int codigoFornecedor = 0;
        codigoFornecedor = Integer.parseInt(cbCodFornecedor.getSelectedItem().toString());
        try {
            dataInicial = bLMascaras.converterDataParaDateUS(bLMascaras.converterDataParaDateUS(jdDataInicio.getDate()));
            dataFinal = bLMascaras.converterDataParaDateUS(bLMascaras.converterDataParaDateUS(jdDataTermino.getDate()));
        } catch (Exception ex) {
            Logger.getLogger(ViewVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        //RELATÓRIO TODOS FORNECEDORES
        if (cbFornecedor.getSelectedItem().toString().equals("TODOS OS FORNECEDORES")) {
            if (jrbPagar.isSelected()) {
                controllerContaPagar.gerarRelatorioContasPagarTODAS(0, dataInicial, dataFinal);
            } else if (jrbPagas.isSelected()) {
                controllerContaPagar.gerarRelatorioContasPagarTODAS(1, dataInicial, dataFinal);
            }
        } else {
            //RELATORIO POR FORNECEDOR
            if (jrbPagar.isSelected()) {
                controllerContaPagar.gerarRelatorioContasPagarFornecedor(codigoFornecedor, 0, dataInicial, dataFinal);
            } else if (jrbPagas.isSelected()) {
                controllerContaPagar.gerarRelatorioContasPagarFornecedor(codigoFornecedor, 1, dataInicial, dataFinal);
            }
        }
    }//GEN-LAST:event_jbGerarRelatorioActionPerformed

    private void cbFornecedorPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbFornecedorPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (this.cbFornecedor.isPopupVisible()) {
            modelFornecedor = controllerFornecedor.getFornecedorController(cbFornecedor.getSelectedItem().toString());
            //recupera o código
            this.cbCodFornecedor.setSelectedItem(modelFornecedor.getCodigo());
        }
    }//GEN-LAST:event_cbFornecedorPopupMenuWillBecomeInvisible

    private void cbCodFornecedorPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbCodFornecedorPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (this.cbCodFornecedor.isPopupVisible()) {
            modelFornecedor = controllerFornecedor.getFornecedorController(Integer.parseInt(cbCodFornecedor.getSelectedItem().toString()));
            //recupera o nome
            this.cbFornecedor.setSelectedItem(String.valueOf(modelFornecedor.getNome()));
        }
    }//GEN-LAST:event_cbCodFornecedorPopupMenuWillBecomeInvisible

    private void listarFornecedores(){
        listaFornecedor = controllerFornecedor.getListaFornecedorController();
        cbFornecedor.removeAllItems();
        cbCodFornecedor.removeAllItems();
        cbCodFornecedor.addItem("0");
        cbFornecedor.addItem("TODOS OS FORNECEDORES");
        for (int i = 0; i < listaFornecedor.size(); i++){
            cbCodFornecedor.addItem(listaFornecedor.get(i).getCodigo());
            cbFornecedor.addItem(listaFornecedor.get(i).getNome());
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
            java.util.logging.Logger.getLogger(ViewRelatoriosContasPagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewRelatoriosContasPagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewRelatoriosContasPagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewRelatoriosContasPagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRelatoriosContasPagar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cbCodFornecedor;
    private javax.swing.JComboBox cbFornecedor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbGerarRelatorio;
    private com.toedter.calendar.JDateChooser jdDataInicio;
    private com.toedter.calendar.JDateChooser jdDataTermino;
    private javax.swing.JRadioButton jrbPagar;
    private javax.swing.JRadioButton jrbPagas;
    // End of variables declaration//GEN-END:variables
}
