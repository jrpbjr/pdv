/**
 * @author  jrpbjr
 *
 * *
 */
package com.inosystem.pdv.view;


import com.inosystem.pdv.contoller.BancoController;
import com.inosystem.pdv.contoller.EmpresaController;
import com.inosystem.pdv.contoller.UsuarioController;
import com.inosystem.pdv.model.Config;
import com.inosystem.pdv.model.Empresa;
import com.inosystem.pdv.model.SessaoUsuario;
import com.inosystem.pdv.model.Usuario;
import com.inosystem.pdv.serial.ConfigXML;
import com.inosystem.pdv.serial.CriptografiaReversivel;
import com.inosystem.pdv.util.ManipularXML;

import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class ViewLogin extends javax.swing.JFrame {

    Config modelConfig = new Config();
    ManipularXML manipularXML = new ManipularXML();
    ConfigXML configXML = new ConfigXML();
    CriptografiaReversivel criptografiaReversivel = new CriptografiaReversivel();
    EmpresaController controllerEmpresa = new EmpresaController();
    Empresa modelEmpresa = new Empresa();
    ArrayList<Empresa> listaEmpresas = new ArrayList<>();

    public ViewLogin() throws Exception {
        initComponents();
        setLocationRelativeTo(null);
        this.jbAtivacaoSerial.setVisible(false);

        jpBarLogin.setIndeterminate(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                // carregar dados
                carregarDadosDoBanco();
                retornarEmpresa();
                jtfUsuario.grabFocus();

//         Comente a validação de serial para desativala ou descomente para ativar caso vc tenho o gerador de serial
//         INICIO - VALIDADAÇÃO POR SERIAL
//        BLSerial blserial = new BLSerial();
//        if (!blserial.imprimirLicenca() || !blserial.validarArquivoXML()) {
//            this.jbAtivacaoSerial.setVisible(true);
//            this.jtfUsuario.setEnabled(false);
//            this.bEntrar.setEnabled(false);
//            this.jtfSenha.setEditable(false);
//            this.dispose();
//            this.jbAtivacaoSerial.setVisible(true);
//        }
//         FIM - VALIDAÇÃO POR SERIAL 

//          terminar a barra de progresso
                jpBarLogin.setIndeterminate(false);
                jpBarLogin.setVisible(false);
            }
        };
        t.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        uJComboBox1 = new componentes.UJComboBox();
        jButton2 = new javax.swing.JButton();
        uJPanelImagem1 = new componentes.UJPanelImagem();
        jbAtivacaoSerial = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jtfSenha = new javax.swing.JPasswordField();
        bEntrar = new javax.swing.JButton();
        bSair = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jpBarLogin = new javax.swing.JProgressBar();
        jtfNomeEmpresa = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        jCheckBox1.setText("jCheckBox1");

        jLabel7.setText("jLabel7");

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(255, 255, 0));
        setIconImage(new ImageIcon(getClass().getResource("/imagens/blicon.png")).getImage());
        setMaximumSize(new java.awt.Dimension(321, 167));
        setMinimumSize(new java.awt.Dimension(321, 167));
        setUndecorated(true);
        setResizable(false);

        uJPanelImagem1.setImagem(new java.io.File("C:\\BLVendas\\src\\imagens\\fundo login.jpg"));
        uJPanelImagem1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbAtivacaoSerial.setBackground(new java.awt.Color(255, 255, 0));
        jbAtivacaoSerial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-desbloquear-filled-50.png"))); // NOI18N
        jbAtivacaoSerial.setText("Ativação do Software");
        jbAtivacaoSerial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtivacaoSerialActionPerformed(evt);
            }
        });
        uJPanelImagem1.add(jbAtivacaoSerial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 181, 49));

        jLabel11.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("loja.blsoft.com.br - contato@blsoft.com.br");
        uJPanelImagem1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 250, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-manutenção-filled-50.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        uJPanelImagem1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuário:");
        uJPanelImagem1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Senha:");
        uJPanelImagem1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        jtfUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfUsuarioActionPerformed(evt);
            }
        });
        uJPanelImagem1.add(jtfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 170, -1));

        jtfSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSenhaActionPerformed(evt);
            }
        });
        uJPanelImagem1.add(jtfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 168, -1));

        bEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-entrar-20.png"))); // NOI18N
        bEntrar.setText("Entrar");
        bEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEntrarActionPerformed(evt);
            }
        });
        uJPanelImagem1.add(bEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 116, -1));

        bSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-sair-20.png"))); // NOI18N
        bSair.setText("Sair");
        bSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSairActionPerformed(evt);
            }
        });
        uJPanelImagem1.add(bSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 116, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/login.png"))); // NOI18N
        uJPanelImagem1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, -1, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nfe/imagens/nfe 100.png"))); // NOI18N
        jLabel12.setText("Em desenvolvimento...");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel12.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        uJPanelImagem1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Empresa:");
        uJPanelImagem1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));
        uJPanelImagem1.add(jpBarLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 620, -1));

        jtfNomeEmpresa.setEditable(false);
        jtfNomeEmpresa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtfNomeEmpresa.setForeground(new java.awt.Color(0, 102, 51));
        uJPanelImagem1.add(jtfNomeEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 300, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 30)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nova logo 50.png"))); // NOI18N
        jLabel1.setText("Vendas");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Copyright @ ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Versão x.x - 202x");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 51));
        jLabel9.setText("Atualização: 09/201x");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logoSiteMini.png"))); // NOI18N

        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Ambiente:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 51, 0));
        jLabel14.setText("homologação");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-ajuda-filled-50.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(uJPanelImagem1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uJPanelImagem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_bSairActionPerformed

    private void bEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEntrarActionPerformed
        // TODO add your handling code here:
        autenticar();
    }//GEN-LAST:event_bEntrarActionPerformed

    private void retornarEmpresa() {
        try {
            listaEmpresas = controllerEmpresa.getListaEmpresaController();
            for (int i = 0; i < listaEmpresas.size(); i++) {
                jtfNomeEmpresa.setText(listaEmpresas.get(i).getRazaoSocial());
            }
        } catch (Exception e) {
            System.err.println("ERRO. -> Empresa não cadastrada!");
        }

    }

    private void carregarDadosDoBanco() {
        modelConfig = new Config();
        modelConfig = manipularXML.lerXmlConfig();
        SessaoUsuario.ipServidor = modelConfig.getIp();
        SessaoUsuario.nomeDoBanco = modelConfig.getNomeBanco();
        SessaoUsuario.usuarioBanco = modelConfig.getUsuario();
        SessaoUsuario.senhaBanco = modelConfig.getSenha();
        SessaoUsuario.caminhoMySQL = modelConfig.getCaminhoMySQL();
        SessaoUsuario.quantidadeMesas = modelConfig.getQuantidadeMesas();
    }

    private void autenticar() {
        Usuario modelUsuario = new Usuario();
        UsuarioController controllerUsuario = new UsuarioController();
        modelUsuario.setLogin(this.jtfUsuario.getText());
        modelUsuario.setSenha(new String(this.jtfSenha.getPassword()));

        try {
            if (controllerUsuario.getUsuarioController(modelUsuario)) {
                modelUsuario = controllerUsuario.getUsuarioController(modelUsuario.getLogin());
                SessaoUsuario.nome = modelUsuario.getNome();
                SessaoUsuario.codigo = modelUsuario.getCodigo();
                SessaoUsuario.login = modelUsuario.getLogin();

                ViewPrincipal viewPrincipal = new ViewPrincipal();
                viewPrincipal.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuário/Senha inválida.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            try {
                BancoController controllerBanco = new BancoController();
                if (controllerBanco.criarBancoCtrl()) {
                    new ViewBackup().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Não foi possível criar o banco.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception ex) {
                Logger.getLogger(ViewLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private void jtfSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSenhaActionPerformed
        // TODO add your handling code here:
        autenticar();
    }//GEN-LAST:event_jtfSenhaActionPerformed

    private void jtfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfUsuarioActionPerformed
        // TODO add your handling code here:
        jtfSenha.grabFocus();
    }//GEN-LAST:event_jtfUsuarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new ViewConfiguracao().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbAtivacaoSerialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtivacaoSerialActionPerformed
        // TODO add your handling code here:
        ViewAtivacao viewValidaArquivoXML = new ViewAtivacao();
        viewValidaArquivoXML.setVisible(true);
    }//GEN-LAST:event_jbAtivacaoSerialActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Senha pardrão do Administrador do sistema: Usuário: admin, Senha: 123.\n"
                + "É recomendado alteração da senha do administrador após o primeiro acesso.");
    }//GEN-LAST:event_jLabel15MouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //começa o look aqui
                LookAndFeel lf = UIManager.getLookAndFeel();

                try {

                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }

                } catch (UnsupportedLookAndFeelException exc) {
                } catch (ClassNotFoundException exc) {
                } catch (InstantiationException exc) {
                } catch (IllegalAccessException exc) {
                }

                UIManager.put("botoes e barras", new Color(238, 232, 170));

                UIManager.put("Botoes e barras", new Color(240, 255, 240));

                UIManager.put("Paineis das interfaces", new Color(250, 250, 250));
                try {
                    //temina o look aqui
                    new ViewLogin().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ViewLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEntrar;
    private javax.swing.JButton bSair;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbAtivacaoSerial;
    private javax.swing.JProgressBar jpBarLogin;
    private javax.swing.JTextField jtfNomeEmpresa;
    private javax.swing.JPasswordField jtfSenha;
    private javax.swing.JTextField jtfUsuario;
    private componentes.UJComboBox uJComboBox1;
    private componentes.UJPanelImagem uJPanelImagem1;
    // End of variables declaration//GEN-END:variables

}
