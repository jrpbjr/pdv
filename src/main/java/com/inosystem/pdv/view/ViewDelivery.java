/*
 * ViewVenda.java
 *
 * Created on 2 de Fevereiro de 2008, 00:13
 */
package com.inosystem.pdv.view;

import controller.ControllerCaixa;
import controller.ControllerCidade;
import controller.ControllerCliente;
import controller.ControllerClienteCidadeEstado;
import controller.ControllerComprasProdutos;
import controller.ControllerEstado;
import controller.ControllerFormaPagamento;
import controller.ControllerFornecedor;
import controller.ControllerPermissaousuario;
import controller.ControllerProdutos;
import controller.ControllerUnidadeMedia;
import controller.ControllerVendas;
import java.io.IOException;
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
import model.ModelClienteCidadeEstado;
import model.ModelComprasProdutos;
import model.ModelConfig;
import model.ModelFormaPagamento;
import model.ModelProdutos;
import model.ModelSessaoUsuario;
import model.ModelVendas;
import util.AguardeGerandoRelatorio;
import util.BLMascaras;
import util.GerarCupom;
import util.Impressora;
import util.ManipularXML;

/**
 * @author Jrpbjr * jrpbjr *
 */
public class ViewDelivery extends javax.swing.JFrame {

    ControllerVendas controllerVendas = new ControllerVendas();
    ModelVendas modelVendas = new ModelVendas();
    ModelProdutos modelProdutos = new ModelProdutos();
    ControllerUnidadeMedia controllerUnidadeMedia = new ControllerUnidadeMedia();
    ArrayList<ModelVendas> listaModelVendas = new ArrayList<>();
    ArrayList<ModelVendas> listaModelVendasAlterar = new ArrayList<>();
    ArrayList<ModelProdutos> listaModelProdutos = new ArrayList<>();
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
    ControllerClienteCidadeEstado controllerClienteCidadeEstado = new ControllerClienteCidadeEstado();
    ModelClienteCidadeEstado modelClienteCidadeEstado = new ModelClienteCidadeEstado();
    private ViewEnderecoCliente viewEnderecoCliente;
    //lerxml
    ModelConfig modelConfig = new ModelConfig();

    /**
     * Creates new form RegistrarVenda
     */
    public ViewDelivery() {
        initComponents();
        listarClientes();
        listarProdutos();
        listarCodigoProdutos();
        listarTipoPagamento();
        tfQuantidade.setText("1");
        this.carregarPedidos();
        setLocationRelativeTo(null);
        this.limpaTelaNovoProduto();
        retornarDadosCliente();
        retornarDadosProduto();
        //INICIO recupera o nome
        retornarprodutoPeloNome();
        verificarFormaPagamento();
        verificarCliente();
        verificarProduto();
        this.viewVerificarPermissao = new ViewVerificarPermissao(this, true);
        this.viewEnderecoCliente = new ViewEnderecoCliente();
        //pegar os dados do xml
        modelConfig = ManipularXML.lerXmlConfig();
    }

    private void verificarFormaPagamento() {
        if (jcbTipoPagamento.getItemCount() < 1) {
            JOptionPane.showMessageDialog(this, "Cadastre primeiro uma forma de pagamento!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void verificarCliente() {
        if (cbClientes.getItemCount() < 1) {
            JOptionPane.showMessageDialog(this, "Cadastre primeiro um cliente!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void verificarProduto() {
        if (cbProdutos.getItemCount() < 1) {
            JOptionPane.showMessageDialog(this, "Cadastre primeiro um produto!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
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
        listaModelProdutos = controllerProdutos.getListaProdutosAtivosController();
        cbProdutos.removeAllItems();
        for (int i = 0; i < listaModelProdutos.size(); i++) {
            cbProdutos.addItem(listaModelProdutos.get(i).getNome());
        }
    }

    private void listarCodigoProdutos() {
        listaModelProdutos = controllerProdutos.getListaProdutosAtivosController();
        cbCodProduto.removeAllItems();
        for (int i = 0; i < listaModelProdutos.size(); i++) {
            cbCodProduto.addItem(listaModelProdutos.get(i).getCodigo());
        }
    }

    private void listarClientes() {
        listaModelClientes = controllerCliente.getListaClienteAtivoController();
        cbClientes.removeAllItems();
        cbCodCliente.removeAllItems();
        jcbTelefone.removeAllItems();
        for (int i = 0; i < listaModelClientes.size(); i++) {
            cbClientes.addItem(listaModelClientes.get(i).getNome());
            cbCodCliente.addItem(listaModelClientes.get(i).getCodigo());
            jcbTelefone.addItem(listaModelClientes.get(i).getTelefone());
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

    // calcula o valor total do produto com quantidade
    private double calcularValorproduto(String pValorUnitario, String pQuantidade) {
        double valorTotal = 0, valorUnitario = 0, quantidade = 0;
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
        tfNumeroVenda = new javax.swing.JTextField();
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
        tfObservacaoCliente = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cbClientes = new componentes.UJComboBox();
        cbCodCliente = new componentes.UJComboBox();
        jLabel17 = new javax.swing.JLabel();
        jcbTelefone = new componentes.UJComboBox();
        jbAlterarCliente = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tfUnidadeMedida = new javax.swing.JTextField();
        btIncluirProduto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btRetirar = new javax.swing.JButton();
        tfDesconto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfObservacao = new javax.swing.JTextPane();
        tfQuantidade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfValorUnitario = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tfValorTotalProduto = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        cbProdutos = new componentes.UJComboBox();
        cbCodProduto = new componentes.UJComboBox();
        jLabel16 = new javax.swing.JLabel();
        jtfTaxaEntrega = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btPesquisarPedido = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        btCancelar1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tfPesquisaPedido = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbConsultasPedidos = new javax.swing.JTable();
        jbImprimirPedido = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        cbFiltroPesquisaPedido = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vendas");
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
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, -1, -1));

        jLabel4.setText("Aplicar desconto:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 470, -1, -1));

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
        tfValorTotal.setFocusable(false);
        jPanel1.add(tfValorTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 490, 110, -1));

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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 228, 810, 230));

        jPanel1.add(jcbTipoPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 540, 330, -1));

        jLabel7.setText("Forma de pagamento:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 520, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setText("Nome do cliente:");

        tfNumeroVenda.setEditable(false);
        tfNumeroVenda.setBackground(new java.awt.Color(102, 255, 204));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Nº do pedido:");

        jLabel9.setText("Código cliente:");

        jLabel12.setText("Endereço:");

        tfEndereco.setEditable(false);

        tfBairro.setEditable(false);

        jLabel13.setText("Bairro:");

        tfEstado.setEditable(false);

        jLabel14.setText("Estado:");

        jLabel15.setText("Cidade:");

        tfCidade.setEditable(false);

        tfObservacaoCliente.setEditable(false);
        tfObservacaoCliente.setEnabled(false);

        jLabel18.setText("Observação");

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

        jLabel17.setText("Telefone:");

        jcbTelefone.setAutocompletar(true);
        jcbTelefone.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbTelefonePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jbAlterarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-editar-filled-50.png"))); // NOI18N
        jbAlterarCliente.setText("Alterar cliente");
        jbAlterarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfObservacaoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAlterarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 224, Short.MAX_VALUE))
                            .addComponent(tfEndereco))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addGap(219, 219, 219))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfCidade))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jcbTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNumeroVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(6, 6, 6)
                        .addComponent(cbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addComponent(tfNumeroVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel17))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(tfObservacaoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAlterarCliente))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 822, 160));

        jLabel10.setText("Cód. Produto:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel11.setText("Unid. Med.");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, -1));

        tfUnidadeMedida.setEditable(false);
        jPanel1.add(tfUnidadeMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 52, -1));

        btIncluirProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-adicionar-filled-50.png"))); // NOI18N
        btIncluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirProdutoActionPerformed(evt);
            }
        });
        jPanel1.add(btIncluirProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 190, 60, -1));

        jLabel2.setText("Produto:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, -1));

        btRetirar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-checkbox-indeterminado-filled-50.png"))); // NOI18N
        btRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRetirarActionPerformed(evt);
            }
        });
        jPanel1.add(btRetirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 190, 60, -1));

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
        jPanel1.add(tfDesconto, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, 110, -1));

        tfObservacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Observação:"));
        tfObservacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfObservacaoFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(tfObservacao);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 474, 460, 90));

        tfQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfQuantidadeFocusLost(evt);
            }
        });
        tfQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfQuantidadeKeyReleased(evt);
            }
        });
        jPanel1.add(tfQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 50, -1));

        jLabel3.setText("Quant.:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, -1, -1));

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
        jPanel1.add(tfValorUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 70, -1));

        jLabel20.setText("Val. Unitário");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, -1));

        tfValorTotalProduto.setEditable(false);
        jPanel1.add(tfValorTotalProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 70, -1));

        jLabel21.setText("Val. Total");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, -1, -1));

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
        jPanel1.add(cbProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 290, -1));

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
        jPanel1.add(cbCodProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 90, -1));

        jLabel16.setText("Taxa de entrega:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 470, -1, -1));

        jtfTaxaEntrega.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfTaxaEntregaFocusLost(evt);
            }
        });
        jtfTaxaEntrega.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfTaxaEntregaKeyReleased(evt);
            }
        });
        jPanel1.add(jtfTaxaEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 490, 90, -1));

        jTabbedPane1.addTab("Cadastro", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btPesquisarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-binóculos-filled-50.png"))); // NOI18N
        btPesquisarPedido.setText("Pesquisar");
        btPesquisarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarPedidoActionPerformed(evt);
            }
        });
        jPanel2.add(btPesquisarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, -1, -1));

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

        jLabel8.setText("Pesquisar:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        tfPesquisaPedido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPesquisaPedidoFocusLost(evt);
            }
        });
        jPanel2.add(tfPesquisaPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 390, -1));

        tbConsultasPedidos.setAutoCreateRowSorter(true);
        tbConsultasPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Compra", "Cliente", "CPF/CNPJ", "Valor total", "Data", "Observação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbConsultasPedidos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbConsultasPedidos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbConsultasPedidos.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tbConsultasPedidos);
        if (tbConsultasPedidos.getColumnModel().getColumnCount() > 0) {
            tbConsultasPedidos.getColumnModel().getColumn(0).setMinWidth(80);
            tbConsultasPedidos.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbConsultasPedidos.getColumnModel().getColumn(1).setMinWidth(280);
            tbConsultasPedidos.getColumnModel().getColumn(1).setPreferredWidth(280);
            tbConsultasPedidos.getColumnModel().getColumn(2).setMinWidth(150);
            tbConsultasPedidos.getColumnModel().getColumn(2).setPreferredWidth(150);
            tbConsultasPedidos.getColumnModel().getColumn(3).setMinWidth(100);
            tbConsultasPedidos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbConsultasPedidos.getColumnModel().getColumn(4).setMinWidth(100);
            tbConsultasPedidos.getColumnModel().getColumn(4).setPreferredWidth(100);
            tbConsultasPedidos.getColumnModel().getColumn(5).setMinWidth(150);
            tbConsultasPedidos.getColumnModel().getColumn(5).setPreferredWidth(150);
        }

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 69, 822, 500));

        jbImprimirPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-impressão-filled-50.png"))); // NOI18N
        jbImprimirPedido.setText("Imprimir");
        jbImprimirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirPedidoActionPerformed(evt);
            }
        });
        jPanel2.add(jbImprimirPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, -1, -1));

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-editar-filled-50.png"))); // NOI18N
        btAlterar.setText("Alterar pedido");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });
        jPanel2.add(btAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 580, -1, -1));

        cbFiltroPesquisaPedido.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nº de compra", "Cliente", "Unidade", "Obra", "Data", "Observação" }));
        jPanel2.add(cbFiltroPesquisaPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 200, -1));

        jTabbedPane1.addTab("Pedidos", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.limpaTelaNovoProduto();
    }//GEN-LAST:event_btCancelarActionPerformed


    private void btFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarActionPerformed
        if (contVendaMenor == 0) {
            if (tipoCadastro.equals("Novo")) {
                zerarValoresCaixa();
                cadastrarVenda();
                this.limpaTelaNovoProduto();
            } else if (tipoCadastro.equals("Alterar")) {
                zerarValoresCaixa();
                alterarPedido();
                this.limpaTelaNovoProduto();
            } else if (tipoCadastro.equals("Aprovar")) {
                zerarValoresCaixa();
                aprovarAlterarPedido();
                this.limpaTelaNovoProduto();
            }
            //verifica a permissão do usuário para vender com valor menor que o de custo
        } else if (retornarCodigoUsuarioLogado()) {
            if (tipoCadastro.equals("Novo")) {
                zerarValoresCaixa();
                cadastrarVenda();
                this.limpaTelaNovoProduto();
            } else if (tipoCadastro.equals("Alterar")) {
                zerarValoresCaixa();
                alterarPedido();
                this.limpaTelaNovoProduto();
            } else if (tipoCadastro.equals("Aprovar")) {
                zerarValoresCaixa();
                aprovarAlterarPedido();
                this.limpaTelaNovoProduto();
            }
            //pede permissão para o usuário vender com valor menor que o de custo
        } else {
            viewVerificarPermissao.setVisible(true);
            if (viewVerificarPermissao.isPermissao()) {
                if (tipoCadastro.equals("Novo")) {
                    zerarValoresCaixa();
                    cadastrarVenda();
                    this.limpaTelaNovoProduto();
                } else if (tipoCadastro.equals("Alterar")) {
                    zerarValoresCaixa();
                    alterarPedido();
                    this.limpaTelaNovoProduto();
                } else if (tipoCadastro.equals("Aprovar")) {
                    zerarValoresCaixa();
                    aprovarAlterarPedido();
                    this.limpaTelaNovoProduto();
                }
            } else {
                System.err.println("Sair");
            }
        }
    }//GEN-LAST:event_btFinalizarActionPerformed

    private boolean alterarPedido() {
        if (tfDesconto.getText().equals("") || tfValorTotal.getText().equals("") || tbProdutos.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Você deve preencher todos os campos!", "ATENÇÂO", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            //RETORNAR COM AS QUANTIDADES DOS PRODUTOS
            this.retornarProdutoAoEstoque();

            listaModelVendas = new ArrayList<>();
            listaModelProdutos = new ArrayList<>();
            int codigoProduto;
            float quantidade;

            for (int i = 0; i < tbProdutos.getRowCount(); i++) {
                modelVendas = new ModelVendas();
                modelProdutos = new ModelProdutos();
                modelVendas.setCodigo(Integer.parseInt(this.tfNumeroVenda.getText()));
                modelVendas.setClientesCodigo(controllerCliente.getClienteController(cbClientes.getSelectedItem().toString()).getCodigo());
                modelVendas.setDesconto(Float.parseFloat(this.tfDesconto.getText()));
                modelVendas.setTaxaEntrega(Float.parseFloat(this.jtfTaxaEntrega.getText()));
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
                modelVendas.setTipo(1);
                modelVendas.setValor(Double.parseDouble(tbProdutos.getValueAt(i, 3).toString()));
                modelVendas.setQuantidade(Float.parseFloat(tbProdutos.getValueAt(i, 4).toString()));
                modelVendas.setTipoPagamento(controllerTipoPagamento.getFormaPagamentoController(this.jcbTipoPagamento.getSelectedItem().toString()).getCodigo());
                quantidade = controllerProdutos.getProdutosController(codigoProduto).getEstoque() - Float.parseFloat(tbProdutos.getValueAt(i, 4).toString());
                modelProdutos.setEstoque(quantidade);
                modelProdutos.setCodigo(codigoProduto);
                listaModelVendas.add(modelVendas);
                listaModelProdutos.add(modelProdutos);
            }
            modelVendas.setListamModelVendases(listaModelVendas);
            modelProdutos.setListaModelProdutoses(listaModelProdutos);

            //salvar venda
            if (controllerVendas.atualizarVendasController(modelVendas)) {
                //excluir dados alteriores
                controllerVendas.excluirProdutoVendasController(modelVendas.getCodigo());
                //da baixa no estoque
                controllerProdutos.atualizarProdutosQuantidadeController(modelProdutos);
                //salvar novamente lista de produtos tualisados
                controllerVendas.salvarVendasProdutosController(modelVendas);
                JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
                adicionarValorCaixa();
                this.habilitarCampos();
                this.carregarPedidos();
                //avançar para aba 2
                jTabbedPane1.setSelectedIndex(jTabbedPane1.getSelectedIndex() + 1);
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }

    private boolean aprovarAlterarPedido() {
        if (tfDesconto.getText().equals("") || tfValorTotal.getText().equals("") || tbProdutos.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Você deve preencher todos os campos!", "ATENÇÂO", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            listaModelVendas = new ArrayList<>();
            listaModelProdutos = new ArrayList<>();
            int codigoProduto;
            float quantidade;

            for (int i = 0; i < tbProdutos.getRowCount(); i++) {
                modelVendas = new ModelVendas();
                modelProdutos = new ModelProdutos();
                modelVendas.setCodigo(Integer.parseInt(this.tfNumeroVenda.getText()));
                modelVendas.setClientesCodigo(controllerCliente.getClienteController(cbClientes.getSelectedItem().toString()).getCodigo());
                modelVendas.setDesconto(Float.parseFloat(this.tfDesconto.getText()));
                modelVendas.setTaxaEntrega(Float.parseFloat(this.jtfTaxaEntrega.getText()));
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
                modelVendas.setTipo(1);
                modelVendas.setValor(Double.parseDouble(tbProdutos.getValueAt(i, 3).toString()));
                modelVendas.setQuantidade(Float.parseFloat(tbProdutos.getValueAt(i, 4).toString()));
                modelVendas.setTipoPagamento(controllerTipoPagamento.getFormaPagamentoController(this.jcbTipoPagamento.getSelectedItem().toString()).getCodigo());
                quantidade = controllerProdutos.getProdutosController(codigoProduto).getEstoque() - Float.parseFloat(tbProdutos.getValueAt(i, 4).toString());
                modelProdutos.setEstoque(quantidade);
                modelProdutos.setCodigo(codigoProduto);
                listaModelVendas.add(modelVendas);
                listaModelProdutos.add(modelProdutos);
            }
            modelVendas.setListamModelVendases(listaModelVendas);
            modelProdutos.setListaModelProdutoses(listaModelProdutos);

            //salvar venda
            if (controllerVendas.atualizarVendasController(modelVendas)) {
                //excluir dados alteriores
                controllerVendas.excluirProdutoVendasController(modelVendas.getCodigo());
                //da baixa no estoque
                controllerProdutos.atualizarProdutosQuantidadeController(modelProdutos);
                //salvar novamente lista de produtos tualisados
                controllerVendas.salvarVendasProdutosController(modelVendas);
                JOptionPane.showMessageDialog(this, "Orçamento aprovado com sucesso!");
                adicionarValorCaixa();
                this.habilitarCampos();
                this.carregarPedidos();
                //avançar para aba 2
                jTabbedPane1.setSelectedIndex(jTabbedPane1.getSelectedIndex() + 1);
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }

    private boolean cadastrarVenda() {
        if (tfDesconto.getText().equals("") || tfValorTotal.getText().equals("") || tbProdutos.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Você deve preencher todos os campos!", "ATENÇÂO", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            listaModelVendas = new ArrayList<>();
            listaModelProdutos = new ArrayList<>();
            int codigoProduto;
            float quantidade;

            for (int i = 0; i < tbProdutos.getRowCount(); i++) {
                modelVendas = new ModelVendas();
                modelProdutos = new ModelProdutos();
                modelVendas.setClientesCodigo(controllerCliente.getClienteController(cbClientes.getSelectedItem().toString()).getCodigo());
                modelVendas.setDesconto(Float.parseFloat(this.tfDesconto.getText()));
                modelVendas.setTaxaEntrega(Float.parseFloat(this.jtfTaxaEntrega.getText()));
                modelVendas.setValorTotal(Float.parseFloat(this.tfValorTotal.getText()));
                modelVendas.setObservacao(this.tfObservacao.getText());
                modelVendas.setCodigoUsuario(ModelSessaoUsuario.codigo);
                try {
                    modelVendas.setDataVenda(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
                } catch (Exception ex) {
                    Logger.getLogger(ViewDelivery.class.getName()).log(Level.SEVERE, null, ex);
                }

                codigoProduto = Integer.parseInt(tbProdutos.getValueAt(i, 0).toString());
                modelVendas.setProdutosCodigo(codigoProduto);
                modelVendas.setTipo(1);
                modelVendas.setValor(Double.parseDouble(tbProdutos.getValueAt(i, 3).toString()));
                modelVendas.setQuantidade(Float.parseFloat(tbProdutos.getValueAt(i, 4).toString()));
                try {
                    modelVendas.setTipoPagamento(controllerTipoPagamento.getFormaPagamentoController(this.jcbTipoPagamento.getSelectedItem().toString()).getCodigo());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Você deve cadastrar uma forma de pagamento!");
                }
                modelProdutos.setCodigo(codigoProduto);
                quantidade = controllerProdutos.getProdutosController(codigoProduto).getEstoque() - Float.parseFloat(tbProdutos.getValueAt(i, 4).toString());
                modelProdutos.setEstoque(quantidade);
                listaModelVendas.add(modelVendas);
                listaModelProdutos.add(modelProdutos);
            }
            modelVendas.setListamModelVendases(listaModelVendas);
            modelProdutos.setListaModelProdutoses(listaModelProdutos);

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
                this.habilitarCampos();
                this.carregarPedidos();
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

    private void btPesquisarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarPedidoActionPerformed
        DefaultTableModel tabela = (DefaultTableModel) this.tbConsultasPedidos.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabela);
        this.tbConsultasPedidos.setRowSorter(sorter);
        String text = tfPesquisaPedido.getText();

        if (cbFiltroPesquisaPedido.getSelectedIndex() == 0) {
            //definir pesquisa por n° compra
            sorter.setRowFilter(RowFilter.regexFilter(text, 0));
        } else if (cbFiltroPesquisaPedido.getSelectedIndex() == 1) {
            //definir pesquisa por cliente
            sorter.setRowFilter(RowFilter.regexFilter(text, 1));
        } else if (cbFiltroPesquisaPedido.getSelectedIndex() == 2) {
            //definir pesquisa por unidade
            sorter.setRowFilter(RowFilter.regexFilter(text, 2));
        } else if (cbFiltroPesquisaPedido.getSelectedIndex() == 3) {
            //definir pesquisa por obra
            sorter.setRowFilter(RowFilter.regexFilter(text, 3));
        } else if (cbFiltroPesquisaPedido.getSelectedIndex() == 4) {
            //definir pesquisa por data
            sorter.setRowFilter(RowFilter.regexFilter(text, 4));
        } else if (cbFiltroPesquisaPedido.getSelectedIndex() == 6) {
            //definir pesquisa por observação
            sorter.setRowFilter(RowFilter.regexFilter(text, 6));
        }

    }//GEN-LAST:event_btPesquisarPedidoActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        int linha = tbConsultasPedidos.getSelectedRow();
        String nome = (String) tbConsultasPedidos.getValueAt(linha, 1);
        int codigo = (int) tbConsultasPedidos.getValueAt(linha, 0);

        //pegunta se realmente deseja excluir
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                + " excluir o registro:\n" + "\n " + nome + "?", "Atenção", JOptionPane.YES_NO_OPTION);
        //se sim exclui, se não não faz nada    
        //recupera os dados do pedido para adicionar ao estoque
        this.recuperarPedido(codigo);
        //adiciona ao estoque
        this.retornarProdutoAoEstoque();
        if (opcao == JOptionPane.OK_OPTION) {
            if (controllerVendas.excluirProdutoVendasController(codigo)) {
                if (controllerVendas.excluirVendasController(codigo)) {
                    JOptionPane.showMessageDialog(this, "Registro excluido com suscesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
                carregarPedidos();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void btCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar1ActionPerformed
        // TODO add your handling code here:
        this.limpaTelaNovoProduto();
        this.carregarPedidos();
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

    private void jbImprimirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirPedidoActionPerformed
        final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
        carregando.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                // imprimir vendas
                int linha = tbConsultasPedidos.getSelectedRow();
                int codigo = (int) tbConsultasPedidos.getValueAt(linha, 0);
                imprimirCupom(codigo);
                carregando.dispose();
            }
        };
        t.start();
    }//GEN-LAST:event_jbImprimirPedidoActionPerformed

    private void tfDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescontoFocusLost
        this.tfValorTotal.setText(String.valueOf(this.somaEAtualizaValorTotal()));
    }//GEN-LAST:event_tfDescontoFocusLost

    private void tfDescontoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDescontoKeyReleased
        // TODO add your handling code here:
        this.tfDesconto.setText(new BLMascaras().converterVirgulaParaPonto(this.tfDesconto.getText()));
        this.tfValorTotal.setText(String.valueOf(this.somaEAtualizaValorTotal()));
    }//GEN-LAST:event_tfDescontoKeyReleased

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        //recebe a linha selecionada
        int linha = this.tbConsultasPedidos.getSelectedRow();
        //pega o codigo na linha selecionada
        int pCodigo = (Integer) tbConsultasPedidos.getValueAt(linha, 0);
        //limpa tela
        this.limpaTelaNovoProduto();
        tipoCadastro = "Alterar";
        //recupera os dados do pedido para adicionar ao estoque
        this.recuperarPedido(pCodigo);
        //recupera cliente
        retornarClientePeloCodigo();
        //valta para aba 1
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btAlterarActionPerformed

    private void tfQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfQuantidadeFocusLost
        // TODO add your handling code here:
        tfValorTotalProduto.setText(calcularValorproduto(this.tfQuantidade.getText(), this.tfValorUnitario.getText()) + "");
    }//GEN-LAST:event_tfQuantidadeFocusLost

    private void tfValorUnitarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorUnitarioFocusLost
        // TODO add your handling code here:
        tfValorTotalProduto.setText(calcularValorproduto(this.tfQuantidade.getText(), this.tfValorUnitario.getText()) + "");
    }//GEN-LAST:event_tfValorUnitarioFocusLost

    private void tfValorUnitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfValorUnitarioKeyReleased
        // TODO add your handling code here:
        this.tfValorUnitario.setText(new BLMascaras().converterVirgulaParaPonto(this.tfValorUnitario.getText()));
    }//GEN-LAST:event_tfValorUnitarioKeyReleased

    private void tfQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQuantidadeKeyReleased
        // TODO add your handling code here:
        this.tfQuantidade.setText(new BLMascaras().converterVirgulaParaPonto(this.tfQuantidade.getText()));
    }//GEN-LAST:event_tfQuantidadeKeyReleased

    private void tfObservacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfObservacaoFocusLost
        this.tfObservacao.setText(tfObservacao.getText().toUpperCase());
        this.tfObservacao.setText(new BLMascaras().TiraAcentos(tfObservacao.getText()));
    }//GEN-LAST:event_tfObservacaoFocusLost

    private void tfPesquisaPedidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPesquisaPedidoFocusLost
        this.tfPesquisaPedido.setText(tfPesquisaPedido.getText().toUpperCase());
        this.tfPesquisaPedido.setText(new BLMascaras().TiraAcentos(tfPesquisaPedido.getText()));
    }//GEN-LAST:event_tfPesquisaPedidoFocusLost

    private void cbClientesPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbClientesPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (this.cbClientes.isPopupVisible()) {
            modelClienteCidadeEstado = controllerClienteCidadeEstado.getClienteCidadeEstadoController(cbClientes.getSelectedItem().toString());
            //recupera o código
            this.cbCodCliente.setSelectedItem(modelClienteCidadeEstado.getModelCliente().getCodigo());
            this.tfEndereco.setText(modelClienteCidadeEstado.getModelCliente().getEndereco());
            this.tfBairro.setText(modelClienteCidadeEstado.getModelCliente().getBairro());
            this.tfEstado.setText(modelClienteCidadeEstado.getModelEstado().getUf());
            this.tfCidade.setText(modelClienteCidadeEstado.getModelCidade().getNome());
            this.jcbTelefone.setSelectedItem(modelClienteCidadeEstado.getModelCliente().getTelefone());
            this.tfObservacaoCliente.setText(modelClienteCidadeEstado.getModelCliente().getObservacao());
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

    private void jcbTelefonePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbTelefonePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (this.jcbTelefone.isPopupVisible()) {
            modelClienteCidadeEstado = new ModelClienteCidadeEstado();
            modelClienteCidadeEstado = controllerClienteCidadeEstado.getClienteCidadeEstadoPorTelefoneController(jcbTelefone.getSelectedItem().toString());
            //recupera o código
            this.cbClientes.setSelectedItem(String.valueOf(modelClienteCidadeEstado.getModelCliente().getNome()));
            this.cbCodCliente.setSelectedItem(String.valueOf(modelClienteCidadeEstado.getModelCliente().getCodigo()));
            this.tfEndereco.setText(modelClienteCidadeEstado.getModelCliente().getEndereco());
            this.tfBairro.setText(modelClienteCidadeEstado.getModelCliente().getBairro());
            this.tfEstado.setText(modelClienteCidadeEstado.getModelEstado().getUf());
            this.tfCidade.setText(modelClienteCidadeEstado.getModelCidade().getNome());
            this.tfObservacaoCliente.setText(modelClienteCidadeEstado.getModelCliente().getObservacao());
        }
    }//GEN-LAST:event_jcbTelefonePopupMenuWillBecomeInvisible

    private void jbAlterarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarClienteActionPerformed
        // TODO add your handling code here:
        viewEnderecoCliente.setTextFildCodigo(Integer.parseInt(cbCodCliente.getSelectedItem().toString()));
        viewEnderecoCliente.retornarClientePeloCodigo();
        viewEnderecoCliente.setVisible(true);
    }//GEN-LAST:event_jbAlterarClienteActionPerformed

    private void jtfTaxaEntregaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfTaxaEntregaFocusLost
        // TODO add your handling code here:
        this.tfValorTotal.setText(String.valueOf(this.somaEAtualizaValorTotal()));
    }//GEN-LAST:event_jtfTaxaEntregaFocusLost

    private void jtfTaxaEntregaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfTaxaEntregaKeyReleased
        // TODO add your handling code here:
        this.jtfTaxaEntrega.setText(new BLMascaras().converterVirgulaParaPonto(this.jtfTaxaEntrega.getText()));
        this.tfValorTotal.setText(String.valueOf(this.somaEAtualizaValorTotal()));
    }//GEN-LAST:event_jtfTaxaEntregaKeyReleased

    /**
     * Imprimir cupom
     */
    private void imprimirCupom(int pCodigo) {
        try {
            //definir impressora
            String nomeImpressora = modelConfig.getImpressoraDelivery();
            //gerar dados e imprimir
            String textoImprimir = new GerarCupom().geraCupomDelivery(pCodigo);
            //enviar para impressora
            Impressora.imprimir(nomeImpressora, textoImprimir);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a impressão !!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * busca o cliente baseado no combobox codigo cliente
     */
    public void retornarClientePeloCodigo() {
        modelClienteCidadeEstado = controllerClienteCidadeEstado.getClienteCidadeEstadoController(Integer.parseInt(cbCodCliente.getSelectedItem().toString()));

        this.cbClientes.setSelectedItem(String.valueOf(modelClienteCidadeEstado.getModelCliente().getNome()));
        this.tfEndereco.setText(modelClienteCidadeEstado.getModelCliente().getEndereco());
        this.tfBairro.setText(modelClienteCidadeEstado.getModelCliente().getBairro());
        this.tfEstado.setText(modelClienteCidadeEstado.getModelEstado().getUf());
        this.tfCidade.setText(modelClienteCidadeEstado.getModelCidade().getNome());
        this.jcbTelefone.setSelectedItem(modelClienteCidadeEstado.getModelCliente().getTelefone());
        this.tfObservacaoCliente.setText(modelClienteCidadeEstado.getModelCliente().getObservacao());
    }

    private int recuperarPedido(int pCodigo) {
        try {
            int codigoProduto;
            modelVendas.setCodigo(pCodigo);
            //recupera os dados do banco
            modelVendas = controllerVendas.getVendasController(pCodigo);
            //seta os dados na interface
            this.cbCodCliente.setSelectedItem(modelVendas.getClientesCodigo());
            this.tfNumeroVenda.setText(String.valueOf(modelVendas.getCodigo()));
            this.tfDesconto.setText(String.valueOf(modelVendas.getDesconto()));
            this.jtfTaxaEntrega.setText(String.valueOf(modelVendas.getTaxaEntrega()));
            this.tfValorTotal.setText(String.valueOf(modelVendas.getValorTotal()));
            this.jcbTipoPagamento.setSelectedItem(controllerTipoPagamento.getFormaPagamentoController(modelVendas.getTipoPagamento()).getDescricao());
            this.tfObservacao.setText(modelVendas.getObservacao());
            //recupera os dados do banco
            listaModelVendasAlterar = controllerVendas.getListaVendasController(pCodigo);
            //carregar lista de produtos da venda
            DefaultTableModel modelo = (DefaultTableModel) tbProdutos.getModel();
            modelo.setNumRows(0);

            int cont = listaModelVendasAlterar.size();
            String unidadeMedida = "";
            String fornecedor = "";
            for (int i = 0; i < cont; i++) {
                codigoProduto = listaModelVendasAlterar.get(i).getProdutosCodigo();
                modelProdutos = controllerProdutos.getProdutosController(codigoProduto);
                unidadeMedida = controllerUnidadeMedia.getUnidadeMediaController(modelProdutos.getUnidadeMedida()).getAbreviacao();
                fornecedor = controllerFornecedor.getFornecedorProdutoController(codigoProduto).getNome();
                modelo.addRow(new Object[]{
                    listaModelVendasAlterar.get(i).getProdutosCodigo(),
                    modelProdutos.getNome(),
                    fornecedor,
                    listaModelVendasAlterar.get(i).getValor(),
                    listaModelVendasAlterar.get(i).getQuantidade(),
                    listaModelVendasAlterar.get(i).getQuantidade() * listaModelVendasAlterar.get(i).getValor(),
                    unidadeMedida
                });
            }
            return modelVendas.getClientesCodigo();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            return 0;
        }
    }

    private void adicionarValorCaixa() {
        modelCaixa = new ModelCaixa();
        modelCaixa = controllerCaixa.getCaixaController(1);
        if (modelVendas.getTipoPagamento() == 1) {
            valorDinheiro = modelVendas.getValorTotal();
            modelCaixa.setDinheiro(bLMascaras.converteArredondar2Casas(modelCaixa.getDinheiro() + valorDinheiro));
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
        modelClienteCidadeEstado = controllerClienteCidadeEstado.getClienteCidadeEstadoController(cbClientes.getSelectedItem().toString());
        //recupera o código
        this.cbCodCliente.setSelectedItem(modelClienteCidadeEstado.getModelCliente().getCodigo());
        this.tfEndereco.setText(modelClienteCidadeEstado.getModelCliente().getEndereco());
        this.tfBairro.setText(modelClienteCidadeEstado.getModelCliente().getBairro());
        this.tfEstado.setText(modelClienteCidadeEstado.getModelEstado().getUf());
        this.tfCidade.setText(modelClienteCidadeEstado.getModelCidade().getNome());
        this.jcbTelefone.setSelectedItem(modelClienteCidadeEstado.getModelCliente().getTelefone());
        this.tfObservacaoCliente.setText(modelClienteCidadeEstado.getModelCliente().getObservacao());
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

    private void limpaTelaNovoProduto() {
        tfNumeroVenda.setText("Novo");
        tfQuantidade.setText("1");
        listarClientes();
        listarProdutos();
        DefaultTableModel modelo = (DefaultTableModel) tbProdutos.getModel();
        modelo.setNumRows(0);
        tfDesconto.setText("0");
        jtfTaxaEntrega.setText("0");
        tfObservacao.setText("");
        tipoCadastro = "Novo";
        contVendaMenor = 0;
        tfValorTotalProduto.setText(calcularValorproduto(this.tfQuantidade.getText(), this.tfValorUnitario.getText()) + "");
    }

    private void habilitarCampos() {
        cbClientes.setEnabled(true);
        cbProdutos.setEnabled(true);
        cbCodCliente.setEnabled(true);
        cbCodProduto.setEnabled(true);
        tfQuantidade.setEnabled(true);
        tfDesconto.setEnabled(true);
        tfObservacao.setEnabled(true);
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
                        + "Deseja efeuar a venda do produto mesmo assim?", "Atenção", JOptionPane.YES_NO_OPTION);
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
        float soma = 0, valor = 0, taxaEntrega = 0, desconto = 0;
        int cont = tbProdutos.getRowCount();
        //pegar taxa de entrega
        try {
            taxaEntrega = Float.parseFloat(jtfTaxaEntrega.getText());
        } catch (Exception e) {
            taxaEntrega = 0;
        }
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
        soma = soma + taxaEntrega - desconto;
        return bLMascaras.arredondamentoComPontoDuasCasas(soma);
    }

    private void carregarPedidos() {
        listaModelVendas = controllerVendas.getListaPedidosController();
        DefaultTableModel modelo = (DefaultTableModel) tbConsultasPedidos.getModel();
        modelo.setNumRows(0);
        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listaModelVendas.size();
        for (int i = 0; i < cont; i++) {
            modelCliente = controllerCliente.getClienteController(listaModelVendas.get(i).getClientesCodigo());
            modelo.addRow(new Object[]{
                listaModelVendas.get(i).getCodigo(),
                modelCliente.getNome(),
                modelCliente.getCpfCNPJ(),
                listaModelVendas.get(i).getValorTotal(),
                bLMascaras.formatarData(listaModelVendas.get(i).getDataVenda()),
                listaModelVendas.get(i).getObservacao(),
                modelCliente.getObservacao()
            });
        }
    }

    /**
     * retorna os produtos para o estoque
     *
     * @param pCodigoProduto
     */
    private void retornarProdutoAoEstoque() {
        float quantidade;
        listaModelProdutos = new ArrayList<>();
        int cont = listaModelVendasAlterar.size();
        for (int i = 0; i < cont; i++) {
            modelProdutos = new ModelProdutos();
            modelProdutos.setCodigo(listaModelVendasAlterar.get(i).getProdutosCodigo());
            quantidade = controllerProdutos.getProdutosController(modelProdutos.getCodigo()).getEstoque() + listaModelVendasAlterar.get(i).getQuantidade();
            modelProdutos.setEstoque(quantidade);
            listaModelProdutos.add(modelProdutos);
        }
        modelProdutos.setListaModelProdutoses(listaModelProdutos);
        controllerProdutos.atualizarProdutosQuantidadeController(modelProdutos);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewDelivery().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCancelar1;
    private javax.swing.JButton btFinalizar;
    private javax.swing.JButton btIncluirProduto;
    private javax.swing.JButton btPesquisarPedido;
    private javax.swing.JButton btRetirar;
    private componentes.UJComboBox cbClientes;
    private componentes.UJComboBox cbCodCliente;
    private componentes.UJComboBox cbCodProduto;
    private javax.swing.JComboBox cbFiltroPesquisaPedido;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JButton jbAlterarCliente;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbImprimirPedido;
    private componentes.UJComboBox jcbTelefone;
    private javax.swing.JComboBox jcbTipoPagamento;
    private javax.swing.JTextField jtfTaxaEntrega;
    private javax.swing.JTable tbConsultasPedidos;
    private javax.swing.JTable tbProdutos;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfDesconto;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfEstado;
    private javax.swing.JTextField tfNumeroVenda;
    private javax.swing.JTextPane tfObservacao;
    private javax.swing.JTextField tfObservacaoCliente;
    private javax.swing.JTextField tfPesquisaPedido;
    private javax.swing.JTextField tfQuantidade;
    private javax.swing.JTextField tfUnidadeMedida;
    private javax.swing.JFormattedTextField tfValorTotal;
    private javax.swing.JTextField tfValorTotalProduto;
    private javax.swing.JTextField tfValorUnitario;
    // End of variables declaration//GEN-END:variables

}
