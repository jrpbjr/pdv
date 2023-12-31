/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inosystem.pdv.view;

import com.inosystem.pdv.model.Config;
import com.inosystem.pdv.util.Impressora;
import com.inosystem.pdv.util.ManipularXML;
import javax.swing.JOptionPane;


/**
 *
 * @author Jrpbjr
 */
public class ViewConfiguracao extends javax.swing.JFrame {

    Config modelConfig = new Config();
    ManipularXML manipularXML = new ManipularXML();

    /**
     * Creates new form ViewConfiguracao
     */
    public ViewConfiguracao() {
        initComponents();
        carregarDados();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jtfSenha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfNomeBanco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfIP = new javax.swing.JTextField();
        jtfUsuario = new javax.swing.JTextField();
        jtfCaminhoMysql = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jrbProducao = new javax.swing.JRadioButton();
        jrbHomologacao = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jrbNormal = new javax.swing.JRadioButton();
        jrbOffLine = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jtfImpressoraPDV = new javax.swing.JTextField();
        jtfImpressoraCozinha = new javax.swing.JTextField();
        jbPDV = new javax.swing.JButton();
        jbCozinha = new javax.swing.JButton();
        jtfImpressoraDelivery = new javax.swing.JTextField();
        jbDelivery = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurações do sistema");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configuração de banco de dados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel2.setText("IP do servidor");

        jLabel4.setText("Usuário do banco");

        jLabel5.setText("Senha do banco:");

        jLabel6.setText("Caminho da pasta do MySQL");

        jtfNomeBanco.setEditable(false);

        jLabel3.setText("Banco de dados");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNomeBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfIP, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jtfSenha)))
                    .addComponent(jtfCaminhoMysql, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNomeBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfCaminhoMysql, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ambiente de execução", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        buttonGroup1.add(jrbProducao);
        jrbProducao.setForeground(new java.awt.Color(0, 0, 102));
        jrbProducao.setSelected(true);
        jrbProducao.setText("Produção");
        jrbProducao.setEnabled(false);

        buttonGroup1.add(jrbHomologacao);
        jrbHomologacao.setForeground(new java.awt.Color(153, 0, 0));
        jrbHomologacao.setText("Homologação");
        jrbHomologacao.setEnabled(false);

        jLabel10.setText("Para alterar o ambiente, por segurança você deve modificar diretamente no arquivo de configuração, tag ambiente");

        jLabel9.setText("Informe 0 para homologação ou 1 para produção e 0 para Off-line e 1 para Normal.");

        buttonGroup2.add(jrbNormal);
        jrbNormal.setForeground(new java.awt.Color(0, 0, 102));
        jrbNormal.setSelected(true);
        jrbNormal.setText("Normal");
        jrbNormal.setEnabled(false);

        buttonGroup2.add(jrbOffLine);
        jrbOffLine.setForeground(new java.awt.Color(153, 0, 0));
        jrbOffLine.setText("Off-line");
        jrbOffLine.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jrbProducao)
                        .addGap(18, 18, 18)
                        .addComponent(jrbHomologacao)
                        .addGap(65, 65, 65)
                        .addComponent(jrbNormal)
                        .addGap(18, 18, 18)
                        .addComponent(jrbOffLine)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(5, 5, 5)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbProducao)
                    .addComponent(jrbHomologacao)
                    .addComponent(jrbNormal)
                    .addComponent(jrbOffLine))
                .addGap(50, 50, 50))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Somente altere os dados abaixo se você tem conhecimento para isso!");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configuração da impressora de cupom", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jtfImpressoraPDV.setEditable(false);

        jtfImpressoraCozinha.setEditable(false);

        jbPDV.setText("Impressora PDV");
        jbPDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPDVActionPerformed(evt);
            }
        });

        jbCozinha.setText("Impressora Cozinha");
        jbCozinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCozinhaActionPerformed(evt);
            }
        });

        jtfImpressoraDelivery.setEditable(false);

        jbDelivery.setText("Impressora Delivery");
        jbDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeliveryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfImpressoraDelivery)
                    .addComponent(jtfImpressoraCozinha)
                    .addComponent(jtfImpressoraPDV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbPDV, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jbCozinha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbDelivery, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfImpressoraPDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPDV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfImpressoraCozinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCozinha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfImpressoraDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbDelivery))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-salvar-filled-50.png"))); // NOI18N
        jbSalvar.setText("Salvar alteração");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-sair-filled-50.png"))); // NOI18N
        jbFechar.setText("Fechar");
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbFechar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSalvar))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbFechar)
                    .addComponent(jbSalvar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        try {
            modelConfig.setNomeBanco(jtfNomeBanco.getText());
            modelConfig.setUsuario(jtfUsuario.getText());
            modelConfig.setSenha(jtfSenha.getText());
            modelConfig.setIp(jtfIP.getText());
            modelConfig.setCaminhoMySQL(jtfCaminhoMysql.getText());
            modelConfig.setQuantidadeMesas(modelConfig.getQuantidadeMesas());
            modelConfig.setImpressoraPDV(jtfImpressoraPDV.getText());
            modelConfig.setImpressoraCozinha(jtfImpressoraCozinha.getText());
            modelConfig.setImpressoraDelivery(jtfImpressoraDelivery.getText());

            manipularXML.gravaXML(modelConfig);
            JOptionPane.showMessageDialog(this, "Registro salvo com sucesso!", "Atenção", JOptionPane.WARNING_MESSAGE);
            carregarDados();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jbPDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPDVActionPerformed
        // TODO add your handling code here:
        try {
            Object[] impressoras = Impressora.listaImpressora();
            Object res = JOptionPane.showInputDialog(null, "Escolha uma impressora para o PDV", "Selecao de impressora",
                    JOptionPane.PLAIN_MESSAGE, null, impressoras, "");
            jtfImpressoraPDV.setText(res.toString());
        } catch (Exception e) {
            jtfImpressoraPDV.setText("");
        }
    }//GEN-LAST:event_jbPDVActionPerformed

    private void jbCozinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCozinhaActionPerformed
        try {
            Object[] impressoras = Impressora.listaImpressora();
            Object res = JOptionPane.showInputDialog(null, "Escolha uma impressora para a cozinha", "Selecao de impressora",
                    JOptionPane.PLAIN_MESSAGE, null, impressoras, "");
            jtfImpressoraCozinha.setText(res.toString());
        } catch (Exception e) {
            jtfImpressoraCozinha.setText("");
        }
    }//GEN-LAST:event_jbCozinhaActionPerformed

    private void jbDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeliveryActionPerformed
        try {
            Object[] impressoras = Impressora.listaImpressora();
            Object res = JOptionPane.showInputDialog(null, "Escolha uma impressora para o delivery", "Selecao de impressora",
                    JOptionPane.PLAIN_MESSAGE, null, impressoras, "");
            jtfImpressoraDelivery.setText(res.toString());
        } catch (Exception e) {
            jtfImpressoraDelivery.setText("");
        }
    }//GEN-LAST:event_jbDeliveryActionPerformed

    //carregar dados na interface
    private void carregarDados() {
        modelConfig = new Config();
        modelConfig = ManipularXML.lerXmlConfig();
        jtfNomeBanco.setText(modelConfig.getNomeBanco());
        jtfUsuario.setText(modelConfig.getUsuario());
        jtfSenha.setText(modelConfig.getSenha());
        jtfIP.setText(modelConfig.getIp());
        jtfCaminhoMysql.setText(modelConfig.getCaminhoMySQL());
        if (modelConfig.getAmbiente() == 0) {
            jrbHomologacao.setSelected(true);
        } else {
            jrbProducao.setSelected(true);
        }
        if (modelConfig.getOnOfLine() == 0) {
            jrbOffLine.setSelected(true);
        } else {
            jrbNormal.setSelected(true);
        }
        jtfImpressoraPDV.setText(modelConfig.getImpressoraPDV());
        jtfImpressoraCozinha.setText(modelConfig.getImpressoraCozinha());
        jtfImpressoraDelivery.setText(modelConfig.getImpressoraDelivery());
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
            java.util.logging.Logger.getLogger(ViewConfiguracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewConfiguracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewConfiguracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewConfiguracao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewConfiguracao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton jbCozinha;
    private javax.swing.JButton jbDelivery;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbPDV;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JRadioButton jrbHomologacao;
    private javax.swing.JRadioButton jrbNormal;
    private javax.swing.JRadioButton jrbOffLine;
    private javax.swing.JRadioButton jrbProducao;
    private javax.swing.JTextField jtfCaminhoMysql;
    private javax.swing.JTextField jtfIP;
    private javax.swing.JTextField jtfImpressoraCozinha;
    private javax.swing.JTextField jtfImpressoraDelivery;
    private javax.swing.JTextField jtfImpressoraPDV;
    private javax.swing.JTextField jtfNomeBanco;
    private javax.swing.JTextField jtfSenha;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}
