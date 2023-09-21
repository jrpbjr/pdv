/*
 * Fornecedores.java
 *
 * Created on 24 de Janeiro de 2008, 23:33
 */
package com.inosystem.pdv.view;


import com.inosystem.pdv.contoller.CidadeController;
import com.inosystem.pdv.contoller.EstadoController;
import com.inosystem.pdv.contoller.TransportadoraCidEstController;
import com.inosystem.pdv.contoller.TransportadoraController;
import com.inosystem.pdv.model.Cidade;
import com.inosystem.pdv.model.Estado;
import com.inosystem.pdv.model.Transportadora;
import com.inosystem.pdv.model.TransportadoraCidEst;
import com.inosystem.pdv.util.Mascara;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * @author Jrpbjr * jrpbjr *
 */
public class ViewTransportadora extends javax.swing.JFrame {

    TransportadoraController controllerTransportadora = new TransportadoraController();
    CidadeController controllerCidade = new CidadeController();
    Transportadora modelTransportadora = new Transportadora();
    TransportadoraCidEstController controllerTransportadoraCidEst = new TransportadoraCidEstController();
    ArrayList<Cidade> listaCidades = new ArrayList<>();
    ArrayList<Estado> listaEstados = new ArrayList<>();
    ArrayList<Transportadora> listTransportadoras = new ArrayList<>();
    ArrayList<TransportadoraCidEst> listaTransportadoraCidadeEstados = new ArrayList<>();
    EstadoController EstadoController = new EstadoController();
    String tipoCadastro;
    Mascara bLMascaras = new Mascara();

    /**
     * Creates new form Fornecedores
     */
    public ViewTransportadora() {
        initComponents();
        setLocationRelativeTo(null);
        carregarTransportadora();
        this.listarEstados();
        this.listarCidades();
        novo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfPesquisa = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfEndereco = new javax.swing.JTextField();
        tfBairro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfTelefone = new javax.swing.JTextField();
        btAlterar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbTransportadora = new javax.swing.JTable();
        tfCodigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btNovaCidade = new javax.swing.JButton();
        cbCidade = new javax.swing.JComboBox();
        cbEstado = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jtfCNPJ = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jtfNomeFantasia = new javax.swing.JTextField();
        tfCep = new javax.swing.JFormattedTextField();
        jtfIncEstad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transportadora");
        setIconImage(new ImageIcon(getClass().getResource("/imagens/blicon.png")).getImage());
        setResizable(false);

        tfPesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPesquisaFocusLost(evt);
            }
        });

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-binóculos-filled-50.png"))); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        jLabel1.setText("Razão Social");

        tfNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfNomeFocusLost(evt);
            }
        });

        jLabel2.setText("Endereço:");

        jLabel3.setText("Bairro:");

        tfEndereco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfEnderecoFocusLost(evt);
            }
        });

        tfBairro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfBairroFocusLost(evt);
            }
        });

        jLabel4.setText("Cidade:");

        jLabel5.setText("UF:");

        jLabel6.setText("CEP:");

        jLabel7.setText("Telefone:");

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-editar-filled-50.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-fechar-janela-filled-50.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-excluir-filled-50.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-salvar-filled-50.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        tbTransportadora.setAutoCreateRowSorter(true);
        tbTransportadora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Cidade", "Estado", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbTransportadora.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbTransportadora.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbTransportadora.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbTransportadora);
        if (tbTransportadora.getColumnModel().getColumnCount() > 0) {
            tbTransportadora.getColumnModel().getColumn(1).setMinWidth(200);
            tbTransportadora.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbTransportadora.getColumnModel().getColumn(2).setMinWidth(200);
            tbTransportadora.getColumnModel().getColumn(2).setPreferredWidth(200);
        }

        tfCodigo.setEditable(false);

        jLabel8.setText("Codigo:");

        btNovaCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-adicionar-filled-50.png"))); // NOI18N
        btNovaCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovaCidadeActionPerformed(evt);
            }
        });

        cbEstado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbEstadoFocusLost(evt);
            }
        });
        cbEstado.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbEstadoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel9.setText("CNPJ:");

        try {
            jtfCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel10.setText("Nome fantasia");

        jtfNomeFantasia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfNomeFantasiaFocusLost(evt);
            }
        });

        try {
            tfCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel11.setText("Inscrição estadual");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jtfNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfBairro)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfNome)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(tfTelefone)
                                                .addGap(7, 7, 7)))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jtfCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfIncEstad)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(cbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btNovaCidade))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btPesquisar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btSalvar)))
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCancelar, btPesquisar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel11))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfIncEstad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(26, 26, 26))))
                    .addComponent(btNovaCidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPesquisar)
                    .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAlterar)
                    .addComponent(btCancelar)
                    .addComponent(jbExcluir)
                    .addComponent(btSalvar))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAlterar, btCancelar, btPesquisar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
//filtrar dados na tabela
        DefaultTableModel tabela = (DefaultTableModel) this.tbTransportadora.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabela);
        this.tbTransportadora.setRowSorter(sorter);
        String text = tfPesquisa.getText();
        sorter.setRowFilter(RowFilter.regexFilter(text, 1));
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        this.novo();
        this.recuperarFornecedor();
        tipoCadastro = "alteracao";
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (tipoCadastro.equals("novo")) {
            salvarFornecedor();
        } else if (tipoCadastro.equals("alteracao")) {
            alteraFornecedor();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        int linha = tbTransportadora.getSelectedRow();
        String nome = (String) tbTransportadora.getValueAt(linha, 1);
        int codigo = (int) tbTransportadora.getValueAt(linha, 0);

        //pegunta se realmente deseja excluir
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                + " excluir o registro:\n" + "\n " + nome + "?", "Atenção", JOptionPane.YES_NO_OPTION);
        //se sim exclui, se não não faz nada    
        if (opcao == JOptionPane.OK_OPTION) {
            if (controllerTransportadora.excluirTransportadoraController(codigo)) {
                JOptionPane.showMessageDialog(this, "Registro excluido com suscesso!");
                carregarTransportadora();
            } else {
                JOptionPane.showMessageDialog(this, "Você não pode excluir uma transportadora já vinculada a uma venda ou NFe! \n"
                        + "Para excluir a transportadora, delete primeiro os registros vinculados a ela.", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        this.novo();
        listarCidades();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void tfNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNomeFocusLost
        // converte em maiusculo o que o usuario digitar
        this.tfNome.setText(tfNome.getText().toUpperCase());
        this.tfNome.setText(bLMascaras.TiraAcentos(tfNome.getText()));
    }//GEN-LAST:event_tfNomeFocusLost

    private void btNovaCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovaCidadeActionPerformed
        // TODO add your handling code here:
        new ViewCidade().setVisible(true);
    }//GEN-LAST:event_btNovaCidadeActionPerformed

    private void cbEstadoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbEstadoPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (this.cbEstado.isPopupVisible()) {
            listarCidades();
        }
    }//GEN-LAST:event_cbEstadoPopupMenuWillBecomeInvisible

    private void cbEstadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbEstadoFocusLost
        listarCidades();

    }//GEN-LAST:event_cbEstadoFocusLost

    private void tfBairroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBairroFocusLost
        // converte em maiusculo o que o usuario digitar
        this.tfBairro.setText(tfBairro.getText().toUpperCase());
        this.tfBairro.setText(bLMascaras.TiraAcentos(tfBairro.getText()));
    }//GEN-LAST:event_tfBairroFocusLost

    private void tfEnderecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfEnderecoFocusLost
        // converte em maiusculo o que o usuario digitar
        this.tfEndereco.setText(tfEndereco.getText().toUpperCase());
        this.tfEndereco.setText(bLMascaras.TiraAcentos(tfEndereco.getText()));
    }//GEN-LAST:event_tfEnderecoFocusLost

    private void tfPesquisaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPesquisaFocusLost
        // converte em maiusculo o que o usuario digitar
        this.tfPesquisa.setText(tfPesquisa.getText().toUpperCase());
        this.tfPesquisa.setText(bLMascaras.TiraAcentos(tfPesquisa.getText()));
    }//GEN-LAST:event_tfPesquisaFocusLost

    private void jtfNomeFantasiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNomeFantasiaFocusLost
        // converte em maiusculo o que o usuario digitar
        this.jtfNomeFantasia.setText(jtfNomeFantasia.getText().toUpperCase());
        this.jtfNomeFantasia.setText(bLMascaras.TiraAcentos(jtfNomeFantasia.getText()));
    }//GEN-LAST:event_jtfNomeFantasiaFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTransportadora().setVisible(true);
            }
        });
    }

    /**
     * Preencher combobox estados
     */
    private void listarEstados() {
        listaEstados = EstadoController.getListaEstadoController();
        cbEstado.removeAllItems();
        for (int i = 0; i < listaEstados.size(); i++) {
            cbEstado.addItem(listaEstados.get(i).getUf());
        }
    }

    /**
     * Preencher combobox cidades
     */
    private void listarCidades() {
        try {
            listaCidades = controllerCidade.getListaCidadePorEstadoController(EstadoController.getEstadoUFController(this.cbEstado.getSelectedItem().toString()).getCodigo());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Você deve cadastrar cidades e estados primeiro!");
        }
        cbCidade.removeAllItems();
        for (int i = 0; i < listaCidades.size(); i++) {
            cbCidade.addItem(listaCidades.get(i).getNome());
        }
    }

    private boolean alteraFornecedor() {
        modelTransportadora.setCodigo(Integer.parseInt(this.tfCodigo.getText()));
        modelTransportadora.setNome(this.tfNome.getText());
        modelTransportadora.setEndereco(this.tfEndereco.getText());
        modelTransportadora.setBairro(this.tfBairro.getText());
        modelTransportadora.setCodCidade(controllerCidade.getCidadeController(this.cbCidade.getSelectedItem().toString()).getCodigo());
        modelTransportadora.setCep(this.tfCep.getText());
        modelTransportadora.setTelefone(this.tfTelefone.getText());
        modelTransportadora.setNomeFantasia(this.jtfNomeFantasia.getText());
        modelTransportadora.setCnpj(this.jtfCNPJ.getText());
        modelTransportadora.setInscEstad(this.jtfIncEstad.getText());

        //alterar 
        if (controllerTransportadora.atualizarTransportadoraController(modelTransportadora)) {
            JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
            this.novo();
            this.carregarTransportadora();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private boolean salvarFornecedor() {
        modelTransportadora.setNome(this.tfNome.getText());
        modelTransportadora.setEndereco(this.tfEndereco.getText());
        modelTransportadora.setBairro(this.tfBairro.getText());
        modelTransportadora.setCodCidade(controllerCidade.getCidadeController(this.cbCidade.getSelectedItem().toString()).getCodigo());
        modelTransportadora.setCep(this.tfCep.getText());
        modelTransportadora.setTelefone(this.tfTelefone.getText());
        modelTransportadora.setNomeFantasia(this.jtfNomeFantasia.getText());
        modelTransportadora.setCnpj(this.jtfCNPJ.getText());
        modelTransportadora.setInscEstad(this.jtfIncEstad.getText());

        //salvar 
        if (controllerTransportadora.salvarTransportadoraController(modelTransportadora) > 0) {
            JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
            this.novo();
            this.carregarTransportadora();
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private boolean recuperarFornecedor() {
        //recebe a linha selecionada
        int linha = this.tbTransportadora.getSelectedRow();

        //pega o codigo do cliente na linha selecionada
        int codigo = (Integer) tbTransportadora.getValueAt(linha, 0);

        try {
            //recupera os dados do banco
            modelTransportadora = controllerTransportadora.getTransportadoraController(codigo);
            //seta os dados na interface
            this.tfCodigo.setText(String.valueOf(modelTransportadora.getCodigo()));
            this.tfNome.setText(modelTransportadora.getNome());
            this.tfEndereco.setText(modelTransportadora.getEndereco());
            this.tfBairro.setText(modelTransportadora.getBairro());
            this.cbEstado.setSelectedItem(tbTransportadora.getValueAt(linha, 3));
            this.listarCidades();
            this.cbCidade.setSelectedItem(controllerCidade.getCidadeController(modelTransportadora.getCodCidade()).getNome());
            this.tfCep.setText(modelTransportadora.getCep());
            this.tfTelefone.setText(modelTransportadora.getTelefone());
            this.jtfNomeFantasia.setText(modelTransportadora.getNomeFantasia());
            this.jtfCNPJ.setText(modelTransportadora.getCnpj());
            this.jtfIncEstad.setText(modelTransportadora.getInscEstad());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private void carregarTransportadora() {
        listaTransportadoraCidadeEstados = controllerTransportadoraCidEst.getListaTransportadoraCidadeEstadoController();
        DefaultTableModel modelo = (DefaultTableModel) tbTransportadora.getModel();
        modelo.setNumRows(0);
        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listaTransportadoraCidadeEstados.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaTransportadoraCidadeEstados.get(i).getTransportadora().getCodigo(),
                listaTransportadoraCidadeEstados.get(i).getTransportadora().getNome(),
                listaTransportadoraCidadeEstados.get(i).getCidade().getNome(),
                listaTransportadoraCidadeEstados.get(i).getEstado().getUf(),
                listaTransportadoraCidadeEstados.get(i).getTransportadora().getTelefone()

            });
        }
    }

    private void novo() {
        tfCodigo.setText("Novo");
        tfNome.setText("");
        tfEndereco.setText("");
        tfBairro.setText("");
        cbEstado.setSelectedIndex(0);
        tfCep.setText("");
        tfTelefone.setText("");
        jtfNomeFantasia.setText("");
        jtfCNPJ.setText("");
        jtfIncEstad.setText("");
        jtfCNPJ.setValue(null);
        tfCep.setValue(null);
        listarCidades();
        listarEstados();
        tipoCadastro = "novo";
    }

    protected boolean verificarCampos() {
        if (!tfNome.getText().trim().equals("")) {
            return true;
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btNovaCidade;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox cbCidade;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JFormattedTextField jtfCNPJ;
    private javax.swing.JTextField jtfIncEstad;
    private javax.swing.JTextField jtfNomeFantasia;
    private javax.swing.JTable tbTransportadora;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JFormattedTextField tfCep;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPesquisa;
    private javax.swing.JTextField tfTelefone;
    // End of variables declaration//GEN-END:variables

}
