/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inosystem.pdv.view;

import controller.ControllerBanco;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelBanco;
import util.BLMascaras;
import util.ExecutarSemLogin;

/**
 *
 * @author jrpbjr
 */
public class ViewBanco_1 extends javax.swing.JFrame {

    ControllerBanco controllerBanco = new ControllerBanco();
    ModelBanco modelBanco = new ModelBanco();
    ArrayList<ModelBanco> listaModelBancos = new ArrayList<>();
    String tipoCadastro;
    BLMascaras bLMascaras = new BLMascaras();

    /**
     * Creates new form ViewBanco
     */
    public ViewBanco_1() {
        initComponents();
//        new ExecutarSemLogin().autenticar();
        setLocationRelativeTo(null);
        carregarBanco();
        tipoCadastro = "novo";
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jtfCodigoBanco = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfNomeReduzido = new javax.swing.JTextField();
        jrbSim = new javax.swing.JRadioButton();
        jrbNao = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtBancos = new javax.swing.JTable();
        jbExcluir = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bancos");
        setResizable(false);

        jLabel1.setText("Código");

        jtfCodigo.setEnabled(false);

        jLabel2.setText("Código do banco");

        jtfDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDescricaoKeyReleased(evt);
            }
        });

        jLabel3.setText("Descrição");

        jLabel4.setText("Nome reduzido");

        jtfNomeReduzido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfNomeReduzidoKeyReleased(evt);
            }
        });

        buttonGroup1.add(jrbSim);
        jrbSim.setText("Sim");

        buttonGroup1.add(jrbNao);
        jrbNao.setSelected(true);
        jrbNao.setText("Não");

        jLabel5.setText("Emite boleto ?");

        jtBancos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Cód. Banco", "Nome Reduzido", "Boleto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtBancos);
        if (jtBancos.getColumnModel().getColumnCount() > 0) {
            jtBancos.getColumnModel().getColumn(0).setMinWidth(70);
            jtBancos.getColumnModel().getColumn(0).setPreferredWidth(70);
            jtBancos.getColumnModel().getColumn(0).setMaxWidth(70);
            jtBancos.getColumnModel().getColumn(1).setMinWidth(70);
            jtBancos.getColumnModel().getColumn(1).setPreferredWidth(70);
            jtBancos.getColumnModel().getColumn(1).setMaxWidth(70);
            jtBancos.getColumnModel().getColumn(3).setMinWidth(50);
            jtBancos.getColumnModel().getColumn(3).setPreferredWidth(50);
            jtBancos.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-excluir-filled-50.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-salvar-filled-50.png"))); // NOI18N
        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-fechar-janela-filled-50.png"))); // NOI18N
        jbLimpar.setText("Limpar");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);
            }
        });

        jbAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-editar-filled-50.png"))); // NOI18N
        jbAlterar.setText("Alterar");
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jtfNomeReduzido, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtfCodigoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))))
                            .addComponent(jLabel4))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 10, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrbSim)
                                .addGap(18, 18, 18)
                                .addComponent(jrbNao)
                                .addGap(57, 57, 57))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbSalvar)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCodigoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNomeReduzido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbSim)
                    .addComponent(jrbNao)
                    .addComponent(jLabel5))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbExcluir)
                    .addComponent(jbSalvar)
                    .addComponent(jbLimpar)
                    .addComponent(jbAlterar))
                .addGap(177, 177, 177))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        if (tipoCadastro.equals("novo")) {
            salvarBanco();
        } else if (tipoCadastro.equals("alteracao")) {
            alterarBanco();
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        int linhaSelecionada = jtBancos.getSelectedRow();
        // Verificamos se existe realmente alguma linha selecionada
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item na tabela antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            this.excluirBanco();
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_jbLimparActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        int linhaSelecionada = jtBancos.getSelectedRow();
        // Verificamos se existe realmente alguma linha selecionada
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item na tabela antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            tipoCadastro = "alteracao";
            retornarBanco();
        }
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jtfDescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescricaoKeyReleased
        //tira acentos
        this.jtfDescricao.setText(bLMascaras.TiraAcentos(jtfDescricao.getText()));
        // converte em maiusculo o que o usuario digitar
        this.jtfDescricao.setText(jtfDescricao.getText().toUpperCase());
    }//GEN-LAST:event_jtfDescricaoKeyReleased

    private void jtfNomeReduzidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeReduzidoKeyReleased
        //tira acentos
        this.jtfDescricao.setText(bLMascaras.TiraAcentos(jtfDescricao.getText()));
        // converte em maiusculo o que o usuario digitar
        this.jtfDescricao.setText(jtfDescricao.getText().toUpperCase());
    }//GEN-LAST:event_jtfNomeReduzidoKeyReleased

    private boolean retornarBanco() {
        //recebe a linha selecionada
        int linha = this.jtBancos.getSelectedRow();
        //pega o codigo do cliente na linha selecionada
        int codigo = (Integer) jtBancos.getValueAt(linha, 0);

        try {
            //recupera os dados do banco
            modelBanco = controllerBanco.getBancoController(codigo);
            //seta os dados na interface
            this.jtfCodigo.setText(String.valueOf(modelBanco.getCodigo()));
            this.jtfCodigoBanco.setText(modelBanco.getBanco());
            this.jtfDescricao.setText(modelBanco.getDescricao());
            this.jtfNomeReduzido.setText(modelBanco.getNomeReduzido());
            if (modelBanco.getEmiteBoleto().equals("s")) {
                jrbSim.setSelected(true);
            } else {
                jrbNao.setSelected(true);
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    //excluir um banco selecionado
    private void excluirBanco() {
        int linha = jtBancos.getSelectedRow();
        String nome = (String) jtBancos.getValueAt(linha, 2);
        int codigo = (Integer) jtBancos.getValueAt(linha, 0);
        //pegunta se realmente deseja excluir
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                + " excluir o registro \nNome: "
                + nome + " ?", "Atenção", JOptionPane.YES_NO_OPTION);
        //se sim exclui, se não não faz nada    
        if (opcao == JOptionPane.OK_OPTION) {
            if (controllerBanco.excluirBancoController(codigo)) {
                JOptionPane.showMessageDialog(this, "Registro excluido com suscesso!");
                carregarBanco();
            } else {
                JOptionPane.showMessageDialog(this, "Você não pode excluir uma que possui vinculos!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    //salvar novo banco
    private boolean salvarBanco() {
        modelBanco = new ModelBanco();
        modelBanco.setBanco(jtfCodigoBanco.getText());
        modelBanco.setDescricao(jtfDescricao.getText());
        modelBanco.setNomeReduzido(jtfNomeReduzido.getText());
        if (jrbSim.isSelected()) {
            modelBanco.setEmiteBoleto("s");
        } else {
            modelBanco.setEmiteBoleto("n");
        }
        //salvar 
        if (controllerBanco.salvarBancoController(modelBanco) > 0) {
            JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
            this.limparCampos();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    //salvar alterações
    private boolean alterarBanco() {
        modelBanco = new ModelBanco();
        modelBanco.setCodigo(Integer.parseInt(jtfCodigo.getText()));
        modelBanco.setBanco(jtfCodigoBanco.getText());
        modelBanco.setDescricao(jtfDescricao.getText());
        modelBanco.setNomeReduzido(jtfNomeReduzido.getText());
        if (jrbSim.isSelected()) {
            modelBanco.setEmiteBoleto("s");
        } else {
            modelBanco.setEmiteBoleto("n");
        }

        //alterar 
        if (controllerBanco.atualizarBancoController(modelBanco)) {
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
            this.limparCampos();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private void limparCampos() {
        jtfCodigo.setText("");
        jtfCodigoBanco.setText("");
        jtfDescricao.setText("");
        jtfNomeReduzido.setText("");
        carregarBanco();
        tipoCadastro = "novo";
    }

    // carregar bancos salvos
    private void carregarBanco() {
        listaModelBancos = controllerBanco.getListaBancoController();
        DefaultTableModel modelo = (DefaultTableModel) jtBancos.getModel();
        modelo.setNumRows(0);
        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listaModelBancos.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelBancos.get(i).getCodigo(),
                listaModelBancos.get(i).getBanco(),
                listaModelBancos.get(i).getNomeReduzido(),
                listaModelBancos.get(i).getEmiteBoleto()
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
            java.util.logging.Logger.getLogger(ViewBanco_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBanco_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBanco_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBanco_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBanco_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JRadioButton jrbNao;
    private javax.swing.JRadioButton jrbSim;
    private javax.swing.JTable jtBancos;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfCodigoBanco;
    private javax.swing.JTextField jtfDescricao;
    private javax.swing.JTextField jtfNomeReduzido;
    // End of variables declaration//GEN-END:variables
}