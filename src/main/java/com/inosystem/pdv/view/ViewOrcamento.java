/*
 * ViewVenda.java
 *
 * Created on 2 de Fevereiro de 2008, 00:13
 */
package com.inosystem.pdv.view;

import controller.ControllerCaixa;
import controller.ControllerCidade;
import controller.ControllerCliente;
import controller.ControllerComprasProdutos;
import controller.ControllerEstado;
import controller.ControllerFormaPagamento;
import controller.ControllerFornecedor;
import controller.ControllerPermissaousuario;
import controller.ControllerProdutos;
import controller.ControllerUnidadeMedia;
import controller.ControllerVendas;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.ModelCaixa;
import model.ModelCliente;
import model.ModelComprasProdutos;
import model.ModelFormaPagamento;
import model.ModelProdutos;
import model.ModelSessaoUsuario;
import model.ModelVendas;
import util.AguardeGerandoRelatorio;
import util.BLMascaras;

/**
 * @author Jrpbjr * jrpbjr *
 */
public class ViewOrcamento extends javax.swing.JFrame {

    ControllerVendas controllerVendas = new ControllerVendas();
    ModelVendas modelVendas = new ModelVendas();
    ModelProdutos modelProdutos = new ModelProdutos();
    ControllerUnidadeMedia controllerUnidadeMedia = new ControllerUnidadeMedia();
    ArrayList<ModelVendas> listaModelVendas = new ArrayList<>();
    ArrayList<ModelVendas> listaModelVendasAlterar = new ArrayList<>();
    ArrayList<ModelProdutos> listaProdutoses = new ArrayList<>();
    ArrayList<ModelCliente> listaModelClientes = new ArrayList<>();
    ControllerCliente controllerCliente = new ControllerCliente();
    ModelCliente modelCliente = new ModelCliente();
    ControllerProdutos controllerProdutos = new ControllerProdutos();
    ModelCaixa modelCaixa = new ModelCaixa();
    ControllerCaixa controllerCaixa = new ControllerCaixa();
    ControllerEstado controllerEstado = new ControllerEstado();
    ControllerCidade controllerCidade = new ControllerCidade();
    ControllerFormaPagamento controllerTipoPagamento = new ControllerFormaPagamento();
    ArrayList<ModelFormaPagamento> listaModelTipoPagamentos = new ArrayList<>();
    ControllerFornecedor controllerFornecedor = new ControllerFornecedor();
    BLMascaras bLMascaras = new BLMascaras();
    float valorCartao, valorCheque, valorDinheiro, valorVale;
    String tipoCadastro;
    int contVendaMenor;
    ModelComprasProdutos modelComprasProdutos = new ModelComprasProdutos();
    ControllerComprasProdutos controllerComprasProdutos = new ControllerComprasProdutos();
    private ViewVerificarPermissao viewVerificarPermissao;

    /**
     * Creates new form RegistrarVenda
     */
    public ViewOrcamento() {
        initComponents();
        listarClientes();
        listarCodigosClientes();
        listarProdutos();
        listarCodigoProdutos();
        listarTipoPagamento();
        this.carregarOrcamento();
        setLocationRelativeTo(null);
        this.limparTela();
        retornarDadosCliente();
        retornarDadosProduto();
        tfQuantidade.setText("1");
        //INICIO recupera o nome
        retornarprodutoPeloNome();
        tfValorTotalProduto.setText(calcularValorproduto(this.tfQuantidade.getText(), this.tfValorUnitario.getText()) + "");
        this.viewVerificarPermissao = new ViewVerificarPermissao(this, true);
    }

    private void retornarprodutoPeloNome() {
        //INICIO recupera o nome
        modelProdutos = controllerProdutos.getProdutosController(cbProdutos.getSelectedItem().toString());
        this.cbCodProduto.setSelectedItem(modelProdutos.getCodigo());
        this.tfUnidadeMedida.setText(controllerUnidadeMedia.getUnidadeMediaController(modelProdutos.getUnidadeMedida()).getAbreviacao());
        this.tfValorUnitario.setText(String.valueOf(modelProdutos.getValor()));
        //FIM recupera o nome
        tfValorTotalProduto.setText(calcularValorproduto(this.tfQuantidade.getText(), this.tfValorUnitario.getText()) + "");
    }

    private void listarProdutos() {
        listaProdutoses = controllerProdutos.getListaProdutosAtivosController();
        cbProdutos.removeAllItems();
        for (int i = 0; i < listaProdutoses.size(); i++) {
            cbProdutos.addItem(listaProdutoses.get(i).getNome());
        }
    }

    private void listarCodigoProdutos() {
        listaProdutoses = controllerProdutos.getListaProdutosAtivosController();
        cbCodProduto.removeAllItems();
        for (int i = 0; i < listaProdutoses.size(); i++) {
            cbCodProduto.addItem(listaProdutoses.get(i).getCodigo());
        }
    }

    private void listarClientes() {
        listaModelClientes = controllerCliente.getListaClienteController();
        cbClientes.removeAllItems();
        for (int i = 0; i < listaModelClientes.size(); i++) {
            cbClientes.addItem(listaModelClientes.get(i).getNome());
        }
    }

    private void listarCodigosClientes() {
        listaModelClientes = controllerCliente.getListaClienteController();
        cbCodCliente.removeAllItems();
        for (int i = 0; i < listaModelClientes.size(); i++) {
            cbCodCliente.addItem(listaModelClientes.get(i).getCodigo());
        }
    }

    private void listarTipoPagamento() {
        listaModelTipoPagamentos = controllerTipoPagamento.getListaFormaPagamentoController();
        jcbTipoPagamento.removeAllItems();
        for (int i = 0; i < listaModelTipoPagamentos.size(); i++) {
            jcbTipoPagamento.addItem(listaModelTipoPagamentos.get(i).getDescricao());
        }
    }

    public void setViewConsultarVendas() {
        this.jTabbedPane1.setSelectedIndex(1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btFinalizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btCancelar = new javax.swing.JButton();
        tfValorTotal = new JFormattedTextField(NumberFormat.getNumberInstance());
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();
        jcbTipoPagamento = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfNumeroOrcamento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfEndereco = new javax.swing.JTextField();
        tfBairro = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfEstado = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tfCidade = new javax.swing.JTextField();
        tfTelefone = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tfCpfCnpj = new javax.swing.JTextField();
        tfObservacaoCliente = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbClientes = new componentes.UJComboBox();
        cbCodCliente = new componentes.UJComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfUnidadeMedida = new javax.swing.JTextField();
        btIncluirProduto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btRetirar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tfQuantidade = new javax.swing.JTextField();
        tfDesconto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfObservacao = new javax.swing.JTextPane();
        tfValorTotalProduto = new javax.swing.JTextField();
        tfValorUnitario = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cbProdutos = new componentes.UJComboBox();
        cbCodProduto = new componentes.UJComboBox();
        jPanel2 = new javax.swing.JPanel();
        btPesquisar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        btCancelar1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tfPesquisa = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbConsultasVendas = new javax.swing.JTable();
        jbImprimir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        cbFiltroPesquisaOrcamento = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Orçamento");
        setAlwaysOnTop(true);
        setIconImage(new ImageIcon(getClass().getResource("/imagens/blicon.png")).getImage());
        setResizable(false);

        jTabbedPane1.setMinimumSize(new java.awt.Dimension(520, 405));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-salvar-filled-50.png"))); // NOI18N
        btFinalizar.setText("Salvar");
        btFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarActionPerformed(evt);
            }
        });
        jPanel1.add(btFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 580, -1, -1));

        jLabel5.setText("Total:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 520, -1, -1));

        jLabel4.setText("Aplicar desconto:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 520, -1, -1));

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-fechar-janela-filled-50.png"))); // NOI18N
        btCancelar.setText("Limpar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, -1, -1));

        tfValorTotal.setEditable(false);
        tfValorTotal.setBackground(new java.awt.Color(255, 153, 153));
        tfValorTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));
        jPanel1.add(tfValorTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 540, 120, -1));

        tbProdutos.setAutoCreateRowSorter(true);
        tbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod. Prod.", "Produto", "Fornecedor", "Valor unit.", "Quantidade", "Valor total", "UM"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProdutos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbProdutos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbProdutos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tbProdutos);
        if (tbProdutos.getColumnModel().getColumnCount() > 0) {
            tbProdutos.getColumnModel().getColumn(1).setMinWidth(300);
            tbProdutos.getColumnModel().getColumn(1).setPreferredWidth(300);
            tbProdutos.getColumnModel().getColumn(1).setMaxWidth(300);
            tbProdutos.getColumnModel().getColumn(2).setMinWidth(180);
            tbProdutos.getColumnModel().getColumn(2).setPreferredWidth(180);
            tbProdutos.getColumnModel().getColumn(6).setMinWidth(60);
            tbProdutos.getColumnModel().getColumn(6).setPreferredWidth(60);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 822, 240));

        jPanel1.add(jcbTipoPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, 270, -1));

        jLabel7.setText("Forma de pagamento:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, -1, -1));

        jPanel3.setBackground(new java.awt.Color(153, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Nome do cliente:");

        tfNumeroOrcamento.setEditable(false);
        tfNumeroOrcamento.setBackground(new java.awt.Color(102, 255, 204));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Nº do orçamento");

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Código cliente:");

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Endereço:");

        tfEndereco.setEditable(false);

        tfBairro.setEditable(false);

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Bairro:");

        tfEstado.setEditable(false);

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Estado:");

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Cidade:");

        tfCidade.setEditable(false);

        tfTelefone.setEditable(false);

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("Telefone");

        tfCpfCnpj.setEditable(false);

        tfObservacaoCliente.setEditable(false);
        tfObservacaoCliente.setEnabled(false);

        jLabel17.setBackground(new java.awt.Color(0, 0, 0));
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("CPF/CNPJ");

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Observação:");

        cbClientes.setAutocompletar(true);
        cbClientes.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbClientesPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbCodCliente.setAutocompletar(true);
        cbCodCliente.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbCodClientePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfObservacaoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfEndereco))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addGap(100, 100, 100)
                                .addComponent(jLabel16))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNumeroOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(6, 6, 6)
                                .addComponent(tfCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(6, 6, 6)
                                .addComponent(tfNumeroOrcamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfObservacaoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 9, 822, 150));

        jLabel10.setText("Cód. Produto:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel11.setText("Unid. Med.");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, -1));

        tfUnidadeMedida.setEditable(false);
        jPanel1.add(tfUnidadeMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 52, -1));

        btIncluirProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-adicionar-filled-50.png"))); // NOI18N
        btIncluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirProdutoActionPerformed(evt);
            }
        });
        jPanel1.add(btIncluirProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, 60, -1));

        jLabel2.setText("Produto:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, -1));

        btRetirar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-checkbox-indeterminado-filled-50.png"))); // NOI18N
        btRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRetirarActionPerformed(evt);
            }
        });
        jPanel1.add(btRetirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 180, 60, -1));

        jLabel3.setText("Quant.:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, -1, -1));

        tfQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfQuantidadeFocusLost(evt);
            }
        });
        jPanel1.add(tfQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 50, -1));

        tfDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDescontoFocusLost(evt);
            }
        });
        tfDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfDescontoKeyReleased(evt);
            }
        });
        jPanel1.add(tfDesconto, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 540, 140, -1));

        tfObservacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Observação:"));
        jScrollPane2.setViewportView(tfObservacao);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 540, 100));

        tfValorTotalProduto.setEditable(false);
        jPanel1.add(tfValorTotalProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 70, -1));

        tfValorUnitario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfValorUnitarioFocusLost(evt);
            }
        });
        tfValorUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfValorUnitarioKeyReleased(evt);
            }
        });
        jPanel1.add(tfValorUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 70, -1));

        jLabel19.setText("Val. Unitário");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, -1));

        jLabel20.setText("Val. Total");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, -1, -1));

        cbProdutos.setAutocompletar(true);
        cbProdutos.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbProdutosPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel1.add(cbProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 290, -1));

        cbCodProduto.setAutocompletar(true);
        cbCodProduto.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbCodProdutoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel1.add(cbCodProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 90, -1));

        jTabbedPane1.addTab("Cadastro", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-binóculos-filled-50.png"))); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });
        jPanel2.add(btPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, -1, -1));

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-excluir-filled-50.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(jbExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 580, -1, -1));

        btCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-fechar-janela-filled-50.png"))); // NOI18N
        btCancelar1.setText("Cancelar");
        btCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, -1, -1));

        jLabel8.setText("Pesquisar nome do Cliente/Obra:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        tfPesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPesquisaFocusLost(evt);
            }
        });
        jPanel2.add(tfPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 400, -1));

        tbConsultasVendas.setAutoCreateRowSorter(true);
        tbConsultasVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Compra", "Cliente", "Data", "Valor total", "Tipo de Pagamento"
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
        tbConsultasVendas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbConsultasVendas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbConsultasVendas.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tbConsultasVendas);
        if (tbConsultasVendas.getColumnModel().getColumnCount() > 0) {
            tbConsultasVendas.getColumnModel().getColumn(0).setMinWidth(100);
            tbConsultasVendas.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbConsultasVendas.getColumnModel().getColumn(0).setMaxWidth(100);
            tbConsultasVendas.getColumnModel().getColumn(1).setMinWidth(300);
            tbConsultasVendas.getColumnModel().getColumn(1).setPreferredWidth(300);
            tbConsultasVendas.getColumnModel().getColumn(1).setMaxWidth(300);
            tbConsultasVendas.getColumnModel().getColumn(2).setMinWidth(100);
            tbConsultasVendas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbConsultasVendas.getColumnModel().getColumn(3).setMinWidth(100);
            tbConsultasVendas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbConsultasVendas.getColumnModel().getColumn(4).setMinWidth(200);
            tbConsultasVendas.getColumnModel().getColumn(4).setPreferredWidth(200);
            tbConsultasVendas.getColumnModel().getColumn(4).setMaxWidth(200);
        }

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 69, 822, 500));

        jbImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-impressão-filled-50.png"))); // NOI18N
        jbImprimir.setText("Imprimir");
        jbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirActionPerformed(evt);
            }
        });
        jPanel2.add(jbImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, -1, -1));

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-editar-filled-50.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });
        jPanel2.add(btAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 580, -1, -1));

        cbFiltroPesquisaOrcamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nº de compra", "Cliente", "Unidade", "Obra", "Data", "Observação" }));
        jPanel2.add(cbFiltroPesquisaOrcamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 180, -1));

        jTabbedPane1.addTab("Consulta de orçamento", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        limparTela();
    }//GEN-LAST:event_btCancelarActionPerformed


    private void btFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarActionPerformed
        if (contVendaMenor == 0) {
            if (tipoCadastro.equals("Novo")) {
                zerarValoresCaixa();
                cadastrarOrcamento();
                limparTela();
            } else if (tipoCadastro.equals("Alterar")) {
                zerarValoresCaixa();
                alterarOrcmento();
                limparTela();
            }
            //verifica a permissão do usuário para vender com valor menor que o de custo
        } else if (retornarCodigoUsuarioLogado()) {
            if (tipoCadastro.equals("Novo")) {
                zerarValoresCaixa();
                cadastrarOrcamento();
                limparTela();
            } else if (tipoCadastro.equals("Alterar")) {
                zerarValoresCaixa();
                alterarOrcmento();
                limparTela();
            }
            //pede permissão para o usuário vender com valor menor que o de custo
        } else {
            viewVerificarPermissao.setVisible(true);
            if (viewVerificarPermissao.isPermissao()) {
                if (tipoCadastro.equals("Novo")) {
                    zerarValoresCaixa();
                    cadastrarOrcamento();
                    limparTela();
                } else if (tipoCadastro.equals("Alterar")) {
                    zerarValoresCaixa();
                    alterarOrcmento();
                    limparTela();
                }
            } else {
                System.err.println("Sair");
            }
        }
    }//GEN-LAST:event_btFinalizarActionPerformed

    //verificar permissão do usuário
    public boolean retornarCodigoUsuarioLogado() {
        try {
            String permissao = new ControllerPermissaousuario().getPermissaousuarioCodUsuController(new ModelSessaoUsuario().codigo).getPermissao();
            if (permissao.equals("compras")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private boolean cadastrarOrcamento() {
        if (tfDesconto.getText().equals("") || tfValorTotal.getText().equals("") || tbProdutos.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Você deve preencher todos os campos!", "ATENÇÂO", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            listaModelVendas = new ArrayList<>();
            listaProdutoses = new ArrayList<>();
            int codigoProduto;
            float quantidade;

            for (int i = 0; i < tbProdutos.getRowCount(); i++) {
                modelVendas = new ModelVendas();
                modelProdutos = new ModelProdutos();
                modelVendas.setClientesCodigo(controllerCliente.getClienteController(cbClientes.getSelectedItem().toString()).getCodigo());
                modelVendas.setDesconto(Float.parseFloat(this.tfDesconto.getText()));
                modelVendas.setTaxaEntrega(0f);
                modelVendas.setValorTotal(Float.parseFloat(this.tfValorTotal.getText()));
                modelVendas.setObservacao(this.tfObservacao.getText());
                modelVendas.setCodigoUsuario(ModelSessaoUsuario.codigo);
                try {
                    modelVendas.setDataVenda(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
                } catch (Exception ex) {
                    Logger.getLogger(ViewOrcamento.class.getName()).log(Level.SEVERE, null, ex);
                }

                codigoProduto = Integer.parseInt(tbProdutos.getValueAt(i, 0).toString());
                modelVendas.setProdutosCodigo(codigoProduto);
                modelVendas.setTipo(0);
                modelVendas.setValor(Double.parseDouble(tbProdutos.getValueAt(i, 3).toString()));
                modelVendas.setQuantidade(Float.parseFloat(tbProdutos.getValueAt(i, 4).toString()));
                modelVendas.setTipoPagamento(controllerTipoPagamento.getFormaPagamentoController(this.jcbTipoPagamento.getSelectedItem().toString()).getCodigo());
                modelProdutos.setCodigo(codigoProduto);
                quantidade = controllerProdutos.getProdutosController(codigoProduto).getEstoque();
                modelProdutos.setEstoque(quantidade);
                listaModelVendas.add(modelVendas);
                listaProdutoses.add(modelProdutos);
            }
            modelVendas.setListamModelVendases(listaModelVendas);
            modelProdutos.setListaModelProdutoses(listaProdutoses);

            //salvar venda
            int codigoVenda = controllerVendas.salvarVendasController(modelVendas);
            if (codigoVenda > 0) {
                modelVendas.setCodigo(codigoVenda);
                //da baixa no estoque
                controllerProdutos.atualizarProdutosQuantidadeController(modelProdutos);
                //salvar lista de produtos
                controllerVendas.salvarVendasProdutosController(modelVendas);
                JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
                adicionarValorCaixa();
                this.limparTela();
                this.carregarOrcamento();
                //avançar para aba 2
                jTabbedPane1.setSelectedIndex(jTabbedPane1.getSelectedIndex() + 1);
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }

    private void btIncluirProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncluirProdutoActionPerformed
        this.incluirProduto();
        this.tfValorTotal.setText(String.valueOf(this.somaEAtualizaValorTotal()));
    }//GEN-LAST:event_btIncluirProdutoActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        DefaultTableModel tabela = (DefaultTableModel) this.tbConsultasVendas.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabela);
        this.tbConsultasVendas.setRowSorter(sorter);
        String text = tfPesquisa.getText();

        if (cbFiltroPesquisaOrcamento.getSelectedIndex() == 0) {
            //definir pesquisa por n° compra
            sorter.setRowFilter(RowFilter.regexFilter(text, 0));
        } else if (cbFiltroPesquisaOrcamento.getSelectedIndex() == 1) {
            //definir pesquisa por cliente
            sorter.setRowFilter(RowFilter.regexFilter(text, 1));
        } else if (cbFiltroPesquisaOrcamento.getSelectedIndex() == 2) {
            //definir pesquisa por unidade
            sorter.setRowFilter(RowFilter.regexFilter(text, 2));
        } else if (cbFiltroPesquisaOrcamento.getSelectedIndex() == 3) {
            //definir pesquisa por obra
            sorter.setRowFilter(RowFilter.regexFilter(text, 3));
        } else if (cbFiltroPesquisaOrcamento.getSelectedIndex() == 4) {
            //definir pesquisa por data
            sorter.setRowFilter(RowFilter.regexFilter(text, 4));
        } else if (cbFiltroPesquisaOrcamento.getSelectedIndex() == 6) {
            //definir pesquisa por observação
            sorter.setRowFilter(RowFilter.regexFilter(text, 6));
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        int linha = tbConsultasVendas.getSelectedRow();
        String nome = (String) tbConsultasVendas.getValueAt(linha, 1);
        int codigo = (int) tbConsultasVendas.getValueAt(linha, 0);

        //pegunta se realmente deseja excluir
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                + " excluir o registro:\n" + "\n " + nome + "?", "Atenção", JOptionPane.YES_NO_OPTION);
        //se sim exclui, se não não faz nada    
        if (opcao == JOptionPane.OK_OPTION) {
            if (controllerVendas.excluirProdutoVendasController(codigo)) {
                if (controllerVendas.excluirVendasController(codigo)) {
                    JOptionPane.showMessageDialog(this, "Registro excluido com suscesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
                carregarOrcamento();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void btCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar1ActionPerformed
        // TODO add your handling code here:
        limparTela();
        carregarOrcamento();
    }//GEN-LAST:event_btCancelar1ActionPerformed

    private void btRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRetirarActionPerformed
        // para excluir a linha
        int linhaSelecionada = tbProdutos.getSelectedRow();
        int codigoProduto = (int) tbProdutos.getValueAt(linhaSelecionada, 0);
        double valorVenda = (double) tbProdutos.getValueAt(linhaSelecionada, 3);

        // Verificamos se existe realmente alguma linha selecionada
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item na tabela antes de clicar no botão!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            // Obtem o modelo da JTable
            DefaultTableModel modelo = (DefaultTableModel) tbProdutos.getModel();
            //verifica se é um produto de menor preço
            modelProdutos = controllerProdutos.getProdutosController(codigoProduto);
            if (modelProdutos.getValorCusto() > valorVenda) {
                contVendaMenor -= 1;
            }
            // Remove a linha
            modelo.removeRow(linhaSelecionada);
            this.tfValorTotal.setText(String.valueOf(this.somaEAtualizaValorTotal()));
        }
    }//GEN-LAST:event_btRetirarActionPerformed

    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirActionPerformed
        final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
        final ControllerVendas controllerVendas = new ControllerVendas();
        carregando.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                // imprimir vendas
                int linha = tbConsultasVendas.getSelectedRow();
                int codigo = (int) tbConsultasVendas.getValueAt(linha, 0);
                controllerVendas.gerarRelatorioOrcamento(codigo);
                carregando.dispose();
            }
        };
        t.start();
    }//GEN-LAST:event_jbImprimirActionPerformed

    private void tfDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescontoFocusLost
        this.tfValorTotal.setText(String.valueOf(this.somaEAtualizaValorTotal()));
    }//GEN-LAST:event_tfDescontoFocusLost

    private void tfDescontoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDescontoKeyReleased
        // TODO add your handling code here:
        this.tfDesconto.setText(new BLMascaras().converterVirgulaParaPonto(this.tfDesconto.getText()));
        this.tfValorTotal.setText(String.valueOf(this.somaEAtualizaValorTotal()));
    }//GEN-LAST:event_tfDescontoKeyReleased

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        // TODO add your handling code here:
        tipoCadastro = "Alterar";
        this.limparTela();
        this.recuperarOrcamento();
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btAlterarActionPerformed

    private void tfValorUnitarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorUnitarioFocusLost
        // TODO add your handling code here:
        tfValorTotalProduto.setText(calcularValorproduto(this.tfQuantidade.getText(), this.tfValorUnitario.getText()) + "");
    }//GEN-LAST:event_tfValorUnitarioFocusLost

    private void tfValorUnitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfValorUnitarioKeyReleased
        // TODO add your handling code here:
        this.tfValorUnitario.setText(new BLMascaras().converterVirgulaParaPonto(this.tfValorUnitario.getText()));
    }//GEN-LAST:event_tfValorUnitarioKeyReleased

    private void tfPesquisaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPesquisaFocusLost
        // converte em maiusculo o que o usuario digitar
        this.tfPesquisa.setText(tfPesquisa.getText().toUpperCase());
        this.tfPesquisa.setText(bLMascaras.TiraAcentos(tfPesquisa.getText()));
    }//GEN-LAST:event_tfPesquisaFocusLost

    private void cbClientesPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbClientesPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (this.cbClientes.isPopupVisible()) {
            modelCliente = controllerCliente.getClienteController(cbClientes.getSelectedItem().toString());
            //recupera o código
            this.cbCodCliente.setSelectedItem(modelCliente.getCodigo());
            this.tfEndereco.setText(modelCliente.getEndereco());
            this.tfBairro.setText(modelCliente.getBairro());
            this.tfEstado.setText(controllerEstado.getEstadoController(modelCliente.getCodEstado()).getUf());
            this.tfCidade.setText(controllerCidade.getCidadeController(modelCliente.getCodCidade()).getNome());
            this.tfTelefone.setText(modelCliente.getTelefone());
            this.tfCpfCnpj.setText(modelCliente.getCpfCNPJ());
            this.tfObservacaoCliente.setText(modelCliente.getObservacao());
        }
    }//GEN-LAST:event_cbClientesPopupMenuWillBecomeInvisible

    private void cbCodClientePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbCodClientePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (this.cbCodCliente.isPopupVisible()) {
            this.retornarClientePeloCodigo();
        }
    }//GEN-LAST:event_cbCodClientePopupMenuWillBecomeInvisible

    private void cbProdutosPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbProdutosPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (this.cbProdutos.isPopupVisible()) {
            //INICIO recupera o nome
            retornarprodutoPeloNome();
        }
    }//GEN-LAST:event_cbProdutosPopupMenuWillBecomeInvisible

    private void cbCodProdutoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbCodProdutoPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (this.cbCodProduto.isPopupVisible()) {
            modelProdutos = controllerProdutos.getProdutosController(Integer.parseInt(cbCodProduto.getSelectedItem().toString()));
            //recupera o código
            this.cbProdutos.setSelectedItem(String.valueOf(modelProdutos.getNome()));
            this.tfUnidadeMedida.setText(controllerUnidadeMedia.getUnidadeMediaController(modelProdutos.getUnidadeMedida()).getAbreviacao());
            this.tfValorUnitario.setText(String.valueOf(modelProdutos.getValor()));
            tfValorTotalProduto.setText(calcularValorproduto(this.tfQuantidade.getText(), this.tfValorUnitario.getText()) + "");
        }
    }//GEN-LAST:event_cbCodProdutoPopupMenuWillBecomeInvisible

    private void tfQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfQuantidadeFocusLost
        // TODO add your handling code here:
        tfValorTotalProduto.setText(calcularValorproduto(this.tfQuantidade.getText(), this.tfValorUnitario.getText()) + "");
    }//GEN-LAST:event_tfQuantidadeFocusLost

    // calcula o valor total do produto com quantidade
    private double calcularValorproduto(String pValorUnitario, String pQuantidade) {
        Double valorTotal = null, valorUnitario = null, quantidade = null;
        try {
            quantidade = Double.parseDouble(pQuantidade);
        } catch (NumberFormatException e) {
            quantidade = 0.0;
        }
        try {
            valorUnitario = Double.parseDouble(pValorUnitario);
        } catch (Exception e) {
            valorUnitario = 0.0;
        }
        try {
            valorTotal = valorUnitario * quantidade;
        } catch (Exception e) {
            valorTotal = 0.0;
        }
        return valorTotal;
    }

    private void retornarClientePeloCodigo() {
        modelCliente = controllerCliente.getClienteController(Integer.parseInt(cbCodCliente.getSelectedItem().toString()));
        //recupera o nome
        this.cbClientes.setSelectedItem(String.valueOf(modelCliente.getNome()));
        this.tfEndereco.setText(modelCliente.getEndereco());
        this.tfBairro.setText(modelCliente.getBairro());
        this.tfEstado.setText(controllerEstado.getEstadoController(modelCliente.getCodEstado()).getUf());
        this.tfCidade.setText(controllerCidade.getCidadeController(modelCliente.getCodCidade()).getNome());
        this.tfTelefone.setText(modelCliente.getTelefone());
        this.tfCpfCnpj.setText(modelCliente.getCpfCNPJ());
        this.tfObservacaoCliente.setText(modelCliente.getObservacao());
    }

    private void adicionarValorCaixa() {
        modelCaixa = new ModelCaixa();
        modelCaixa = controllerCaixa.getCaixaController(1);
        if (modelVendas.getTipoPagamento() == 1) {
            valorDinheiro = modelVendas.getValorTotal();
            modelCaixa.setDinheiro(modelCaixa.getDinheiro() + valorDinheiro);
        } else if (modelVendas.getTipoPagamento() == 2) {
            valorCartao = modelVendas.getValorTotal();
            modelCaixa.setCartao(modelCaixa.getCartao() + valorCartao);
        } else if (modelVendas.getTipoPagamento() == 3) {
            valorCheque = modelVendas.getValorTotal();
            modelCaixa.setCheque(modelCaixa.getCheque() + valorCheque);
        } else if (modelVendas.getTipoPagamento() == 4) {
            valorVale = modelVendas.getValorTotal();
            modelCaixa.setConvenio(modelCaixa.getConvenio() + valorVale);
        }
        controllerCaixa.atualizarCaixaController(modelCaixa);
    }

    //usa apenas para carregar os dados da interface quando abre o software
    private void retornarDadosCliente() {
        modelCliente = controllerCliente.getClienteController(Integer.parseInt(cbCodCliente.getSelectedItem().toString()));
        //recupera o nome
        this.cbClientes.setSelectedItem(String.valueOf(modelCliente.getNome()));
        this.tfEndereco.setText(modelCliente.getEndereco());
        this.tfBairro.setText(modelCliente.getBairro());
        this.tfEstado.setText(controllerEstado.getEstadoController(modelCliente.getCodEstado()).getUf());
        this.tfCidade.setText(controllerCidade.getCidadeController(modelCliente.getCodCidade()).getNome());
        this.tfTelefone.setText(modelCliente.getTelefone());
        this.tfCpfCnpj.setText(modelCliente.getCpfCNPJ());
        this.tfObservacaoCliente.setText(modelCliente.getObservacao());
    }

    //usa apenas para carregar os dados da interface quando abre o software
    private void retornarDadosProduto() {
        modelProdutos = controllerProdutos.getProdutosController(Integer.parseInt(cbCodProduto.getSelectedItem().toString()));
        //recupera o código
        this.cbProdutos.setSelectedItem(String.valueOf(modelProdutos.getNome()));
        this.tfUnidadeMedida.setText(controllerUnidadeMedia.getUnidadeMediaController(modelProdutos.getUnidadeMedida()).getAbreviacao());
    }

    private void zerarValoresCaixa() {
        valorCartao = 0;
        valorCheque = 0;
        valorDinheiro = 0;
        valorVale = 0;
    }

    private boolean recuperarOrcamento() {
        try {
            //recebe a linha selecionada
            int linha = this.tbConsultasVendas.getSelectedRow();
            //pega o codigo na linha selecionada
            int codigo = (Integer) tbConsultasVendas.getValueAt(linha, 0);
            String nome = (String) tbConsultasVendas.getValueAt(linha, 1);
            int codigoProduto;
            modelVendas.setCodigo(codigo);
            //recupera os dados do banco
            modelVendas = controllerVendas.getVendasController(codigo);
            //seta os dados na interface
            this.cbClientes.setSelectedItem(nome);
            this.tfNumeroOrcamento.setText(String.valueOf(modelVendas.getCodigo()));
            this.tfDesconto.setText(String.valueOf(modelVendas.getDesconto()));
            this.tfValorTotal.setText(String.valueOf(modelVendas.getValorTotal()));
            this.tfObservacao.setText(modelVendas.getObservacao());
            this.jcbTipoPagamento.setSelectedItem(controllerTipoPagamento.getFormaPagamentoController(modelVendas.getTipoPagamento()).getDescricao());
            //recupera os dados do banco
            listaModelVendasAlterar = controllerVendas.getListaVendasController(codigo);
            //carregar lista de produtos da venda
            DefaultTableModel modelo = (DefaultTableModel) tbProdutos.getModel();
            modelo.setNumRows(0);

            String unidadeMedida = "";
            String fornecedor = "";
            for (int i = 0; i < listaModelVendasAlterar.size(); i++) {
                codigoProduto = listaModelVendasAlterar.get(i).getProdutosCodigo();
                modelProdutos = controllerProdutos.getProdutosController(codigoProduto);
                unidadeMedida = controllerUnidadeMedia.getUnidadeMediaController(modelProdutos.getUnidadeMedida()).getAbreviacao();
                fornecedor = controllerFornecedor.getFornecedorProdutoController(codigoProduto).getNome();
                modelo.addRow(new Object[]{
                    modelProdutos.getCodigo(),
                    modelProdutos.getNome(),
                    fornecedor,
                    listaModelVendasAlterar.get(i).getValor(),
                    listaModelVendasAlterar.get(i).getQuantidade(),
                    listaModelVendasAlterar.get(i).getQuantidade() * listaModelVendasAlterar.get(i).getValor(),
                    unidadeMedida
                });
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    private void limparTela() {
        tipoCadastro = "Novo";
        tfNumeroOrcamento.setText("Novo");
        tfQuantidade.setText("1");
        listarClientes();
        listarProdutos();
        DefaultTableModel modelo = (DefaultTableModel) tbProdutos.getModel();
        modelo.setNumRows(0);
        this.tfDesconto.setText("0");
        this.tfObservacao.setText("");
    }

    private void incluirProduto() {
        // testa se tem campo vazio
        int codigoproduto = Integer.parseInt(this.cbCodProduto.getSelectedItem().toString());
        double valorUnitario = Double.parseDouble(this.tfValorUnitario.getText());
        modelProdutos = controllerProdutos.getProdutosController(codigoproduto);
        if (tfQuantidade.getText().equals("") || tfQuantidade.getText().equals("0")) {
            JOptionPane.showMessageDialog(rootPane, "Você deve informar a quantidade para adicionar!");
        } else {
            //verifica a quantidade em estoque
            if (modelProdutos.getEstoque() < Float.parseFloat(tfQuantidade.getText())) {
                //pegunta se realmente deseja excluir
                int opcao = JOptionPane.showConfirmDialog(this, "Você não tem essa quantidade de produto em estoque!\n"
                        + "Quantidade atual de " + modelProdutos.getNome() + " é " + modelProdutos.getEstoque() + "\n"
                        + "Deseja efeuar o orçamento do produto mesmo assim?", "Atenção", JOptionPane.YES_NO_OPTION);
                //testa se usuario selecionou sim
                if (opcao == JOptionPane.OK_OPTION) {
                    //testa se o valor de venda é menor que o valor de compra
                    if (modelProdutos.getValorCusto() > valorUnitario) {
                        viewVerificarPermissao.setValorCusto(valorUnitario);
                        viewVerificarPermissao.setValorVenda(valorUnitario);
                        viewVerificarPermissao.setVisible(true);
                        if (viewVerificarPermissao.isPermissao()) {
                            addTabela(codigoproduto, valorUnitario);
                        }
                    } else {
                        //chama o método de add na tabela
                        this.addTabela(codigoproduto, valorUnitario);
                    }
                } else {
                    //não incluir pq não tem em estoque e o usuário não quer add
                }
            } else {
                //testa se o valor de venda é menor que o valor de compra
                if (modelProdutos.getValorCusto() > valorUnitario) {
                    viewVerificarPermissao.setValorCusto(valorUnitario);
                    viewVerificarPermissao.setValorVenda(valorUnitario);
                    viewVerificarPermissao.setVisible(true);
                    if (viewVerificarPermissao.isPermissao()) {
                        addTabela(codigoproduto, valorUnitario);
                    }
                } else {
                    //chama o método de add na tabela
                    this.addTabela(codigoproduto, valorUnitario);
                }
            }
        }
    }

    //adicionar produtos na tabela
    private void addTabela(int pCodigoProduto, double pValorUnitario) {
        //Adiciona linhas na tabela
        DefaultTableModel modelo = (DefaultTableModel) tbProdutos.getModel();
        float quantidadeProduto = Float.parseFloat(tfQuantidade.getText());
        double valorTotal = 0.0;

        // INICIO verifica se jai foi inserido um produto igual
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (modelo.getValueAt(i, 0).toString().equals(cbCodProduto.getSelectedItem().toString())) {
                quantidadeProduto += (float) modelo.getValueAt(i, 4);
                modelo.removeRow(i);
            }
        }
        // FIM verifica se jai foi inserido um produto igual

        valorTotal = calcularValorproduto(quantidadeProduto + "", pValorUnitario + "");

        String fornecedor = controllerFornecedor.getFornecedorProdutoController(pCodigoProduto).getNome();
        //pega a quantidade de linhas e joga na variavel
        modelo.addRow(new Object[]{
            pCodigoProduto,
            this.cbProdutos.getSelectedItem().toString(),
            fornecedor,
            pValorUnitario,
            quantidadeProduto,
            valorTotal,
            this.tfUnidadeMedida.getText()
        });
    }

    /**
     * Soma e atualiza os valores total
     *
     * @return
     */
    private float somaEAtualizaValorTotal() {
        float soma = 0, valor = 0, desconto = 0;
        int cont = tbProdutos.getRowCount();
        //pegar valor desconto
        try {
            desconto = Float.parseFloat(tfDesconto.getText());
        } catch (Exception e) {
            desconto = 0;
        }
        for (int i = 0; i < cont; i++) {
            valor = Float.parseFloat(String.valueOf(tbProdutos.getValueAt(i, 5)));
            soma = valor + soma;
        }
        soma = soma - desconto;
        return bLMascaras.arredondamentoComPontoDuasCasas(soma);
    }

    private void carregarOrcamento() {
        listaModelVendas = controllerVendas.getListaOrcamentoController();
        DefaultTableModel modelo = (DefaultTableModel) tbConsultasVendas.getModel();
        modelo.setNumRows(0);
        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listaModelVendas.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{
                listaModelVendas.get(i).getCodigo(),
                controllerCliente.getClienteController(listaModelVendas.get(i).getClientesCodigo()).getNome(),
                listaModelVendas.get(i).getDataVenda(),
                listaModelVendas.get(i).getValorTotal(),
                controllerTipoPagamento.getFormaPagamentoController(listaModelVendas.get(i).getTipoPagamento()).getDescricao()
            });
        }
    }

    private boolean alterarOrcmento() {
        if (tfDesconto.getText().equals("") || tfValorTotal.getText().equals("") || tbProdutos.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Você deve preencher todos os campos!", "ATENÇÂO", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            listaModelVendas = new ArrayList<>();
            listaProdutoses = new ArrayList<>();
            int codigoProduto;
            float quantidade;

            for (int i = 0; i < tbProdutos.getRowCount(); i++) {
                modelVendas = new ModelVendas();
                modelProdutos = new ModelProdutos();
                modelVendas.setCodigo(Integer.parseInt(this.tfNumeroOrcamento.getText()));
                modelVendas.setClientesCodigo(controllerCliente.getClienteController(cbClientes.getSelectedItem().toString()).getCodigo());
                modelVendas.setDesconto(Float.parseFloat(this.tfDesconto.getText()));
                modelVendas.setTaxaEntrega(0f);
                modelVendas.setValorTotal(Float.parseFloat(this.tfValorTotal.getText()));
                modelVendas.setObservacao(this.tfObservacao.getText());
                modelVendas.setCodigoUsuario(ModelSessaoUsuario.codigo);
                try {
                    modelVendas.setDataVenda(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
                } catch (Exception ex) {
                    Logger.getLogger(ViewOrcamento.class.getName()).log(Level.SEVERE, null, ex);
                }

                codigoProduto = Integer.parseInt(tbProdutos.getValueAt(i, 0).toString());
                modelVendas.setProdutosCodigo(codigoProduto);
                modelVendas.setTipo(0);
                modelVendas.setValor(Double.parseDouble(tbProdutos.getValueAt(i, 3).toString()));
                modelVendas.setQuantidade(Float.parseFloat(tbProdutos.getValueAt(i, 4).toString()));
                modelVendas.setTipoPagamento(controllerTipoPagamento.getFormaPagamentoController(this.jcbTipoPagamento.getSelectedItem().toString()).getCodigo());
                modelProdutos.setCodigo(codigoProduto);
                quantidade = controllerProdutos.getProdutosController(codigoProduto).getEstoque();
                modelProdutos.setEstoque(quantidade);
                listaModelVendas.add(modelVendas);
                listaProdutoses.add(modelProdutos);
            }
            modelVendas.setListamModelVendases(listaModelVendas);
            modelProdutos.setListaModelProdutoses(listaProdutoses);

            //salvar venda
            if (controllerVendas.atualizarVendasController(modelVendas)) {
                //da baixa no estoque
                controllerProdutos.atualizarProdutosQuantidadeController(modelProdutos);
                //excluir dados alteriores
                controllerVendas.excluirProdutoVendasController(modelVendas.getCodigo());
                //salvar novamente lista de produtos tualisados
                controllerVendas.salvarVendasProdutosController(modelVendas);
                JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
                adicionarValorCaixa();
                this.limparTela();
                this.carregarOrcamento();
                //avançar para aba 2
                jTabbedPane1.setSelectedIndex(jTabbedPane1.getSelectedIndex() + 1);
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }

    /**
     * retorna os produtos para o estoque
     *
     * @param pCodigoProduto
     */
    private void retornarProdutoAoEstoque() {
        float quantidade;
        int cont = listaModelVendasAlterar.size();
        for (int i = 0; i < cont; i++) {
            modelProdutos.setCodigo(listaModelVendasAlterar.get(i).getProdutosCodigo());
            quantidade = controllerProdutos.getProdutosController(modelProdutos.getCodigo()).getEstoque() + listaModelVendasAlterar.get(i).getQuantidade();
            modelProdutos.setEstoque(quantidade);
            listaProdutoses.add(modelProdutos);
        }
        controllerProdutos.atualizarProdutosQuantidadeController(modelProdutos);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewOrcamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCancelar1;
    private javax.swing.JButton btFinalizar;
    private javax.swing.JButton btIncluirProduto;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btRetirar;
    private componentes.UJComboBox cbClientes;
    private componentes.UJComboBox cbCodCliente;
    private componentes.UJComboBox cbCodProduto;
    private javax.swing.JComboBox cbFiltroPesquisaOrcamento;
    private componentes.UJComboBox cbProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbImprimir;
    private javax.swing.JComboBox jcbTipoPagamento;
    private javax.swing.JTable tbConsultasVendas;
    private javax.swing.JTable tbProdutos;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfCpfCnpj;
    private javax.swing.JTextField tfDesconto;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfEstado;
    private javax.swing.JTextField tfNumeroOrcamento;
    private javax.swing.JTextPane tfObservacao;
    private javax.swing.JTextField tfObservacaoCliente;
    private javax.swing.JTextField tfPesquisa;
    private javax.swing.JTextField tfQuantidade;
    private javax.swing.JTextField tfTelefone;
    private javax.swing.JTextField tfUnidadeMedida;
    private javax.swing.JFormattedTextField tfValorTotal;
    private javax.swing.JTextField tfValorTotalProduto;
    private javax.swing.JTextField tfValorUnitario;
    // End of variables declaration//GEN-END:variables

}
