package com.inosystem.pdv.view;

import com.inosystem.pdv.contoller.ClienteController;
import com.inosystem.pdv.contoller.VendaController;
import com.inosystem.pdv.model.Config;
import com.inosystem.pdv.model.Venda;
import com.inosystem.pdv.util.GerarCupom;
import com.inosystem.pdv.util.Impressora;
import com.inosystem.pdv.util.ManipularXML;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jrpbjr
 */
public class ViewImprimirPDV extends javax.swing.JDialog {

    VendaController VendaController = new VendaController();
    Venda modelVendas = new Venda();
    ArrayList<Venda> listaVenda = new ArrayList<>();
    ClienteController controllerCliente = new ClienteController();
    Config modelConfig = new Config();

    /**
     * Creates new form ViewImprimirPDV
     */
    public ViewImprimirPDV(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.carregarVendas();
        //pegar os dados do xml
        modelConfig = ManipularXML.lerXmlConfig();
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
        jScrollPane4 = new javax.swing.JScrollPane();
        tbConsultasVendas = new javax.swing.JTable();
        jtfPesquisa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btPesquisar = new javax.swing.JButton();
        jbImprimir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        rbCompleto = new javax.swing.JRadioButton();
        rbPDV = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Imprimir Relatório");
        setIconImage(new ImageIcon(getClass().getResource("/imagens/blicon.png")).getImage());

        tbConsultasVendas.setAutoCreateRowSorter(true);
        tbConsultasVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Venda", "Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbConsultasVendas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbConsultasVendas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbConsultasVendas.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tbConsultasVendas);
        if (tbConsultasVendas.getColumnModel().getColumnCount() > 0) {
            tbConsultasVendas.getColumnModel().getColumn(1).setMinWidth(450);
            tbConsultasVendas.getColumnModel().getColumn(1).setMaxWidth(450);
        }

        jLabel8.setText("Pesquisa:");

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-binóculos-filled-50.png"))); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        jbImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-impressão-filled-50.png"))); // NOI18N
        jbImprimir.setText("Imprimir");
        jbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-sair-filled-50.png"))); // NOI18N
        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbCompleto);
        rbCompleto.setSelected(true);
        rbCompleto.setText("Formato completo");

        buttonGroup1.add(rbPDV);
        rbPDV.setText("Formato PDV");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btPesquisar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jbImprimir)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(rbCompleto)
                        .addGap(61, 61, 61)
                        .addComponent(rbPDV))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPesquisar)
                    .addComponent(jbImprimir)
                    .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbCompleto)
                    .addComponent(rbPDV))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        DefaultTableModel tabela = (DefaultTableModel) this.tbConsultasVendas.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabela);
        this.tbConsultasVendas.setRowSorter(sorter);
        String text = jtfPesquisa.getText();
        sorter.setRowFilter(RowFilter.regexFilter(text, 1));
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirActionPerformed
        int linha = tbConsultasVendas.getSelectedRow();
        int codigo = (int) tbConsultasVendas.getValueAt(linha, 0);
        if (rbCompleto.isSelected()) {
            VendaController.gerarRelatorioVenda(codigo);
        } else {
            imprimirCupom(codigo);
        }
    }//GEN-LAST:event_jbImprimirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Imprimir cupom
     */
    private void imprimirCupom(int pCodigo) {
        try {
            //definir impressora
            String nomeImpressora = modelConfig.getImpressoraPDV();
            //gerar dados e imprimir
            String textoImprimir = new GerarCupom().gerarCupomPDV(pCodigo);
            //enviar para impressora
            Impressora.imprimir(nomeImpressora, textoImprimir);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a impressão !!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregarVendas() {
        listaVenda = VendaController.getListaPedidosController();
        DefaultTableModel modelo = (DefaultTableModel) tbConsultasVendas.getModel();
        modelo.setNumRows(0);
        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listaVenda.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaVenda.get(i).getCodigo(),
                controllerCliente.getClienteController(listaVenda.get(i).getClientesCodigo()).getNome()
            });
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
            java.util.logging.Logger.getLogger(ViewImprimirPDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewImprimirPDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewImprimirPDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewImprimirPDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewImprimirPDV dialog = new ViewImprimirPDV(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPesquisar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jbImprimir;
    private javax.swing.JTextField jtfPesquisa;
    private javax.swing.JRadioButton rbCompleto;
    private javax.swing.JRadioButton rbPDV;
    private javax.swing.JTable tbConsultasVendas;
    // End of variables declaration//GEN-END:variables
}
