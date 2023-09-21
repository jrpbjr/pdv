package com.inosystem.pdv.view;

import com.inosystem.pdv.contoller.CaixaController;
import com.inosystem.pdv.contoller.CidadeController;
import com.inosystem.pdv.contoller.ClienteCidadeEstadoController;
import com.inosystem.pdv.contoller.ClienteController;
import com.inosystem.pdv.contoller.CompraProdutoController;
import com.inosystem.pdv.contoller.EstadoController;
import com.inosystem.pdv.contoller.FormaPagamentoController;
import com.inosystem.pdv.contoller.FornecedorController;
import com.inosystem.pdv.contoller.PermissaoUsuarioController;
import com.inosystem.pdv.contoller.ProdutoController;
import com.inosystem.pdv.contoller.UnidadeMedidaController;
import com.inosystem.pdv.contoller.VendaController;
import com.inosystem.pdv.model.Caixa;
import com.inosystem.pdv.model.Cliente;
import com.inosystem.pdv.model.ClienteCidadeEstado;
import com.inosystem.pdv.model.CompraProduto;
import com.inosystem.pdv.model.FormaPagamento;
import com.inosystem.pdv.model.Produto;
import com.inosystem.pdv.model.SessaoUsuario;
import com.inosystem.pdv.model.Venda;
import com.inosystem.pdv.util.AguardeGerandoRelatorio;
import com.inosystem.pdv.util.Mascara;
import java.math.BigDecimal;
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


/**
 * @author Jrpbjr * jrpbjr *
 */
public class ViewVenda extends javax.swing.JFrame {

    VendaController VendaController = new VendaController();
    Venda modelVendas = new Venda();
    Produto modelProdutos = new Produto();
    UnidadeMedidaController controllerUnidadeMedia = new UnidadeMedidaController();
    ArrayList<Venda> listaVenda = new ArrayList<>();
    ArrayList<Venda> listaVendaAlterar = new ArrayList<>();
    ArrayList<Produto> listaProduto = new ArrayList<>();
    ArrayList<Cliente> listaClientes = new ArrayList<>();
    ClienteController controllerCliente = new ClienteController();
    Cliente modelCliente = new Cliente();
    ProdutoController controllerProdutos = new ProdutoController();
    Caixa modelCaixa = new Caixa();
    CaixaController controllerCaixa = new CaixaController();
    EstadoController EstadoController = new EstadoController();
    CidadeController controllerCidade = new CidadeController();
    FormaPagamentoController controllerTipoPagamento = new FormaPagamentoController();
    ArrayList<FormaPagamento> listaModelTipoPagamentos = new ArrayList<>();
    FornecedorController controllerFornecedor = new FornecedorController();
    Mascara bLMascaras = new Mascara();
    float valorCartao, valorCheque, valorDinheiro, valorVale;
    String tipoCadastro;
    int contVendaMenor;
    CompraProduto modelComprasProdutos = new CompraProduto();
    CompraProdutoController controllerComprasProdutos = new CompraProdutoController();
    private ViewVerificarPermissao viewVerificarPermissao;
    ClienteCidadeEstadoController controllerClienteCidadeEstado = new ClienteCidadeEstadoController();
    ClienteCidadeEstado modelClienteCidadeEstado = new ClienteCidadeEstado();

    /**
     * Creates new form RegistrarVenda
     */
    public ViewVenda() {
        initComponents();
        listarClientes();
        listarCodigosClientes();
        listarProdutos();
        listarCodigoProdutos();
        listarTipoPagamento();
        tfQuantidade.setText("1");
        this.carregarPedidos();
        this.carregarOrcamentos();
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
        if (cbProduto.getItemCount() < 1) {
            JOptionPane.showMessageDialog(this, "Cadastre primeiro um produto!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void retornarprodutoPeloNome() {
        //INICIO recupera o nome
        modelProdutos = controllerProdutos.getProdutosController(cbProduto.getSelectedItem().toString());
        this.cbCodProduto.setSelectedItem(modelProdutos.getCodigo());
        this.tfUnidadeMedida.setText(controllerUnidadeMedia.getUnidadeMediaController(modelProdutos.getUnidadeMedida()).getAbreviacao());
        this.tfValorUnitario.setText(String.valueOf(modelProdutos.getValor()));
        //FIM recupera o nome
        tfValorTotalProduto.setText(calcularValorproduto(this.tfQuantidade.getText(), this.tfValorUnitario.getText()) + "");
    }

    private void listarProdutos() {
        listaProduto = controllerProdutos.getListaProdutosAtivosController();
        cbProduto.removeAllItems();
        for (int i = 0; i < listaProduto.size(); i++) {
            cbProduto.addItem(listaProduto.get(i).getNome());
        }
    }

    private void listarCodigoProdutos() {
        listaProduto = controllerProdutos.getListaProdutosAtivosController();
        cbCodProduto.removeAllItems();
        for (int i = 0; i < listaProduto.size(); i++) {
            cbCodProduto.addItem(listaProduto.get(i).getCodigo());
        }
    }

    private void listarClientes() {
        listaClientes = controllerCliente.getListaClienteAtivoController();
        cbClientes.removeAllItems();
        for (int i = 0; i < listaClientes.size(); i++) {
            cbClientes.addItem(listaClientes.get(i).getNome());
        }
    }

    private void listarCodigosClientes() {
        listaClientes = controllerCliente.getListaClienteController();
        cbCodCliente.removeAllItems();
        for (int i = 0; i < listaClientes.size(); i++) {
            cbCodCliente.addItem(listaClientes.get(i).getCodigo());
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
        tfTelefone = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        tfCpfCnpj = new javax.swing.JTextField();
        tfObservacaoCliente = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbClientes = new br.com.inosystem.ugcomp.components.UJComboBox();
        cbCodCliente = new br.com.inosystem.ugcomp.components.UJComboBox();
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
        cbCodProduto = new br.com.inosystem.ugcomp.components.UJComboBox();
        cbProduto = new br.com.inosystem.ugcomp.components.UJComboBox();
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
        btDesaprovar = new javax.swing.JButton();
        cbFiltroPesquisaPedido = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jbImprimirOrcamento = new javax.swing.JButton();
        tfPesquisaorcamento = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbConsultasOrcamentos = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        btPesquisarOrcamento = new javax.swing.JButton();
        btCancelar2 = new javax.swing.JButton();
        btAprovar = new javax.swing.JButton();
        cbFiltroPesquisaOrcamento = new javax.swing.JComboBox();

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
        tfValorTotal.setFocusable(false);
        jPanel1.add(tfValorTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 540, 110, -1));

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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 810, 238));

        jPanel1.add(jcbTipoPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, 260, -1));

        jLabel7.setText("Forma de pagamento:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, -1, -1));

        jPanel3.setBackground(new java.awt.Color(153, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel1.setText("Nome do cliente:");

        tfNumeroVenda.setEditable(false);
        tfNumeroVenda.setBackground(new java.awt.Color(102, 255, 204));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Nº da venda:");

        jLabel9.setText("Código cliente:");

        jLabel12.setText("Endereço:");

        tfEndereco.setEditable(false);

        tfBairro.setEditable(false);

        jLabel13.setText("Bairro:");

        tfEstado.setEditable(false);

        jLabel14.setText("Estado:");

        jLabel15.setText("Cidade:");

        tfCidade.setEditable(false);

        tfTelefone.setEditable(false);

        jLabel16.setText("Telefone");

        tfCpfCnpj.setEditable(false);

        tfObservacaoCliente.setEditable(false);
        tfObservacaoCliente.setEnabled(false);

        jLabel17.setText("CPF/CNPJ");

        jLabel18.setText("Observação");

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
                        .addComponent(tfObservacaoCliente))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 224, Short.MAX_VALUE))
                            .addComponent(tfEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbCodCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cbClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(6, 6, 6)
                        .addComponent(tfCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addComponent(tfNumeroVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(tfObservacaoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 822, 150));

        jLabel10.setText("Cód. Produto:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel11.setText("Unid. Med.");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, -1));

        tfUnidadeMedida.setEditable(false);
        jPanel1.add(tfUnidadeMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 52, -1));

        btIncluirProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/inosystem/pdv/imagem/icon20/icons8-adicionar-filled-50.png"))); // NOI18N
        btIncluirProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirProdutoActionPerformed(evt);
            }
        });
        jPanel1.add(btIncluirProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 60, -1));

        jLabel2.setText("Produto:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, -1));

        btRetirar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/inosystem/pdv/imagem/icon20/icons8-checkbox-indeterminado-filled-50.png"))); // NOI18N
        btRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRetirarActionPerformed(evt);
            }
        });
        jPanel1.add(btRetirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, 60, -1));

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
        tfObservacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfObservacaoFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(tfObservacao);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 540, 94));

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
        jPanel1.add(tfQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 50, -1));

        jLabel3.setText("Quant.:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, -1, -1));

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

        jLabel20.setText("Val. Unitário");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, -1));

        tfValorTotalProduto.setEditable(false);
        jPanel1.add(tfValorTotalProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 70, -1));

        jLabel21.setText("Val. Total");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, -1, -1));
        jPanel1.add(cbCodProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));
        jPanel1.add(cbProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 290, -1));

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
        jPanel2.add(btAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 580, -1, -1));

        btDesaprovar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-baixar-filled-50.png"))); // NOI18N
        btDesaprovar.setText("Desaprovar pedido");
        btDesaprovar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesaprovarActionPerformed(evt);
            }
        });
        jPanel2.add(btDesaprovar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 580, -1, -1));

        cbFiltroPesquisaPedido.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nº de compra", "Cliente", "Unidade", "Obra", "Data", "Observação" }));
        jPanel2.add(cbFiltroPesquisaPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 200, -1));

        jTabbedPane1.addTab("Vendas", jPanel2);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbImprimirOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-impressão-filled-50.png"))); // NOI18N
        jbImprimirOrcamento.setText("Imprimir");
        jbImprimirOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirOrcamentoActionPerformed(evt);
            }
        });
        jPanel4.add(jbImprimirOrcamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, -1, -1));

        tfPesquisaorcamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPesquisaorcamentoFocusLost(evt);
            }
        });
        jPanel4.add(tfPesquisaorcamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 390, -1));

        tbConsultasOrcamentos.setAutoCreateRowSorter(true);
        tbConsultasOrcamentos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbConsultasOrcamentos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbConsultasOrcamentos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbConsultasOrcamentos.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tbConsultasOrcamentos);
        if (tbConsultasOrcamentos.getColumnModel().getColumnCount() > 0) {
            tbConsultasOrcamentos.getColumnModel().getColumn(0).setMinWidth(80);
            tbConsultasOrcamentos.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbConsultasOrcamentos.getColumnModel().getColumn(1).setMinWidth(280);
            tbConsultasOrcamentos.getColumnModel().getColumn(1).setPreferredWidth(280);
            tbConsultasOrcamentos.getColumnModel().getColumn(2).setMinWidth(150);
            tbConsultasOrcamentos.getColumnModel().getColumn(2).setPreferredWidth(150);
            tbConsultasOrcamentos.getColumnModel().getColumn(3).setMinWidth(100);
            tbConsultasOrcamentos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbConsultasOrcamentos.getColumnModel().getColumn(4).setMinWidth(100);
            tbConsultasOrcamentos.getColumnModel().getColumn(4).setPreferredWidth(100);
            tbConsultasOrcamentos.getColumnModel().getColumn(5).setMinWidth(300);
            tbConsultasOrcamentos.getColumnModel().getColumn(5).setPreferredWidth(300);
        }

        jPanel4.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 69, 822, 500));

        jLabel19.setText("Pesquisar:");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btPesquisarOrcamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-binóculos-filled-50.png"))); // NOI18N
        btPesquisarOrcamento.setText("Pesquisar");
        btPesquisarOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarOrcamentoActionPerformed(evt);
            }
        });
        jPanel4.add(btPesquisarOrcamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, -1, -1));

        btCancelar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-fechar-janela-filled-50.png"))); // NOI18N
        btCancelar2.setText("Cancelar");
        btCancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar2ActionPerformed(evt);
            }
        });
        jPanel4.add(btCancelar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, -1, -1));

        btAprovar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-caixa-de-seleção-marcada-filled-50.png"))); // NOI18N
        btAprovar.setText("Aprovar orçamento");
        btAprovar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAprovarActionPerformed(evt);
            }
        });
        jPanel4.add(btAprovar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 580, -1, -1));

        cbFiltroPesquisaOrcamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nº de compra", "Cliente", "Unidade", "Obra", "Data", "Observação" }));
        jPanel4.add(cbFiltroPesquisaOrcamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 200, -1));

        jTabbedPane1.addTab("Orçamentos", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

            listaVenda = new ArrayList<>();
            listaProduto = new ArrayList<>();
            int codigoProduto;
            float quantidade;

            for (int i = 0; i < tbProdutos.getRowCount(); i++) {
                modelVendas = new Venda();
                modelProdutos = new Produto();
                modelVendas.setCodigo(Integer.parseInt(this.tfNumeroVenda.getText()));
                modelVendas.setClientesCodigo(controllerCliente.getClienteController(cbClientes.getSelectedItem().toString()).getCodigo());
                
                
                modelVendas.setDesconto(new BigDecimal(this.tfDesconto.getText()));
                modelVendas.setTaxaEntrega(new BigDecimal(0f));
                modelVendas.setValorTotal(new BigDecimal(this.tfValorTotal.getText()));
                modelVendas.setObservacao(this.tfObservacao.getText());
                modelVendas.setCodigoUsuario(SessaoUsuario.codigo);
                try {
                    modelVendas.setDataVenda(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
                } catch (Exception ex) {
                    Logger.getLogger(ViewOrcamento.class.getName()).log(Level.SEVERE, null, ex);
                }

                codigoProduto = Integer.parseInt(tbProdutos.getValueAt(i, 0).toString());
                modelVendas.setProdutosCodigo(codigoProduto);
                modelVendas.setTipo(1);
                modelVendas.setValor(new BigDecimal(tbProdutos.getValueAt(i, 3).toString()));
                modelVendas.setQuantidade(new BigDecimal(tbProdutos.getValueAt(i, 4).toString()));
                modelVendas.setTipoPagamento(controllerTipoPagamento.getFormaPagamentoController(this.jcbTipoPagamento.getSelectedItem().toString()).getCodigo());
                quantidade = controllerProdutos.getProdutosController(codigoProduto).getEstoque() - Float.parseFloat(tbProdutos.getValueAt(i, 4).toString());
                modelProdutos.setEstoque(quantidade);
                modelProdutos.setCodigo(codigoProduto);
                listaVenda.add(modelVendas);
                listaProduto.add(modelProdutos);
            }
            modelVendas.setListamVendaes(listaVenda);
            modelProdutos.setListaProdutoes(listaProduto);

            //salvar venda
            if (VendaController.atualizarVendasController(modelVendas)) {
                //excluir dados alteriores
                VendaController.excluirProdutoVendasController(modelVendas.getCodigo());
                //da baixa no estoque
                controllerProdutos.atualizarProdutosQuantidadeController(modelProdutos);
                //salvar novamente lista de produtos tualisados
                VendaController.salvarVendasProdutosController(modelVendas);
                JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
                adicionarValorCaixa();
                this.habilitarCampos();
                this.carregarOrcamentos();
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
            listaVenda = new ArrayList<>();
            listaProduto = new ArrayList<>();
            int codigoProduto;
            float quantidade;

            for (int i = 0; i < tbProdutos.getRowCount(); i++) {
                modelVendas = new Venda();
                modelProdutos = new Produto();
                modelVendas.setCodigo(Integer.parseInt(this.tfNumeroVenda.getText()));
                modelVendas.setClientesCodigo(controllerCliente.getClienteController(cbClientes.getSelectedItem().toString()).getCodigo());
                modelVendas.setDesconto(new BigDecimal(this.tfDesconto.getText()));
                modelVendas.setTaxaEntrega(new BigDecimal(0f));
                modelVendas.setValorTotal(new BigDecimal(this.tfValorTotal.getText()));
                modelVendas.setObservacao(this.tfObservacao.getText());
                modelVendas.setCodigoUsuario(SessaoUsuario.codigo);
                try {
                    modelVendas.setDataVenda(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
                } catch (Exception ex) {
                    Logger.getLogger(ViewOrcamento.class.getName()).log(Level.SEVERE, null, ex);
                }

                codigoProduto = Integer.parseInt(tbProdutos.getValueAt(i, 0).toString());
                modelVendas.setProdutosCodigo(codigoProduto);
                modelVendas.setTipo(1);
                modelVendas.setValor(new BigDecimal(tbProdutos.getValueAt(i, 3).toString()));
                modelVendas.setQuantidade(new BigDecimal(tbProdutos.getValueAt(i, 4).toString()));
                modelVendas.setTipoPagamento(controllerTipoPagamento.getFormaPagamentoController(this.jcbTipoPagamento.getSelectedItem().toString()).getCodigo());
                quantidade = controllerProdutos.getProdutosController(codigoProduto).getEstoque() - Float.parseFloat(tbProdutos.getValueAt(i, 4).toString());
                modelProdutos.setEstoque(quantidade);
                modelProdutos.setCodigo(codigoProduto);
                listaVenda.add(modelVendas);
                listaProduto.add(modelProdutos);
            }
            modelVendas.setListamVendaes(listaVenda);
            modelProdutos.setListaProdutoes(listaProduto);

            //salvar venda
            if (VendaController.atualizarVendasController(modelVendas)) {
                //excluir dados alteriores
                VendaController.excluirProdutoVendasController(modelVendas.getCodigo());
                //da baixa no estoque
                controllerProdutos.atualizarProdutosQuantidadeController(modelProdutos);
                //salvar novamente lista de produtos tualisados
                VendaController.salvarVendasProdutosController(modelVendas);
                JOptionPane.showMessageDialog(this, "Orçamento aprovado com sucesso!");
                adicionarValorCaixa();
                this.habilitarCampos();
                this.carregarOrcamentos();
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
            listaVenda = new ArrayList<>();
            listaProduto = new ArrayList<>();
            int codigoProduto;
            float quantidade;

            for (int i = 0; i < tbProdutos.getRowCount(); i++) {
                modelVendas = new Venda();
                modelProdutos = new Produto();
                modelVendas.setClientesCodigo(controllerCliente.getClienteController(cbClientes.getSelectedItem().toString()).getCodigo());
                modelVendas.setDesconto(new BigDecimal(this.tfDesconto.getText()));
                modelVendas.setTaxaEntrega(new BigDecimal(0f));
                modelVendas.setValorTotal(new BigDecimal(this.tfValorTotal.getText()));
                modelVendas.setObservacao(this.tfObservacao.getText());
                modelVendas.setCodigoUsuario(SessaoUsuario.codigo);
                try {
                    modelVendas.setDataVenda(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
                } catch (Exception ex) {
                    Logger.getLogger(ViewVenda.class.getName()).log(Level.SEVERE, null, ex);
                }

                codigoProduto = Integer.parseInt(tbProdutos.getValueAt(i, 0).toString());
                modelVendas.setProdutosCodigo(codigoProduto);
                modelVendas.setTipo(1);
                modelVendas.setValor(new BigDecimal(tbProdutos.getValueAt(i, 3).toString()));
                modelVendas.setQuantidade(new BigDecimal(tbProdutos.getValueAt(i, 4).toString()));
                try {
                    modelVendas.setTipoPagamento(controllerTipoPagamento.getFormaPagamentoController(this.jcbTipoPagamento.getSelectedItem().toString()).getCodigo());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Você deve cadastrar uma forma de pagamento!");
                }
                modelProdutos.setCodigo(codigoProduto);
                quantidade = controllerProdutos.getProdutosController(codigoProduto).getEstoque() - Float.parseFloat(tbProdutos.getValueAt(i, 4).toString());
                modelProdutos.setEstoque(quantidade);
                listaVenda.add(modelVendas);
                listaProduto.add(modelProdutos);
            }
            modelVendas.setListamVendaes(listaVenda);
            modelProdutos.setListaProdutoes(listaProduto);

            //salvar venda
            int codigoVenda = VendaController.salvarVendasController(modelVendas);
            if (codigoVenda > 0) {
                modelVendas.setCodigo(codigoVenda);
                //da baixa no estoque
                controllerProdutos.atualizarProdutosQuantidadeController(modelProdutos);
                //salvar lista de produtos
                VendaController.salvarVendasProdutosController(modelVendas);
                JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
                adicionarValorCaixa();
                this.habilitarCampos();
                this.carregarPedidos();
                this.carregarOrcamentos();
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
            if (VendaController.excluirProdutoVendasController(codigo)) {
                if (VendaController.excluirVendasController(codigo)) {
                    JOptionPane.showMessageDialog(this, "Registro excluido com suscesso!");
                } else {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
                carregarPedidos();
                this.carregarOrcamentos();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void btCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar1ActionPerformed
        // TODO add your handling code here:
        this.limpaTelaNovoProduto();
        this.carregarPedidos();
        this.carregarOrcamentos();
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
        final VendaController VendaController = new VendaController();
        carregando.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                // imprimir vendas
                int linha = tbConsultasPedidos.getSelectedRow();
                int codigo = (int) tbConsultasPedidos.getValueAt(linha, 0);
                VendaController.gerarRelatorioVenda(codigo);
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
        this.tfDesconto.setText(bLMascaras.converterVirgulaParaPonto(this.tfDesconto.getText()));
        this.tfValorTotal.setText(String.valueOf(this.somaEAtualizaValorTotal()));
    }//GEN-LAST:event_tfDescontoKeyReleased

    private void jbImprimirOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirOrcamentoActionPerformed
        final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
        final VendaController VendaController = new VendaController();
        carregando.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                // imprimir vendas
                int linha = tbConsultasOrcamentos.getSelectedRow();
                int codigo = (int) tbConsultasOrcamentos.getValueAt(linha, 0);
                VendaController.gerarRelatorioOrcamento(codigo);
                carregando.dispose();
            }
        };
        t.start();
    }//GEN-LAST:event_jbImprimirOrcamentoActionPerformed

    private void btPesquisarOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarOrcamentoActionPerformed
        DefaultTableModel tabela = (DefaultTableModel) this.tbConsultasOrcamentos.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabela);
        this.tbConsultasOrcamentos.setRowSorter(sorter);
        String text = tfPesquisaorcamento.getText();

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
    }//GEN-LAST:event_btPesquisarOrcamentoActionPerformed

    private void btCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar2ActionPerformed
        // TODO add your handling code here:
        this.limpaTelaNovoProduto();
        this.carregarPedidos();
        this.carregarOrcamentos();
    }//GEN-LAST:event_btCancelar2ActionPerformed

    private void btAprovarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAprovarActionPerformed
        //recebe a linha selecionada
        int linha = this.tbConsultasOrcamentos.getSelectedRow();
        //pega o codigo na linha selecionada
        int pCodigo = (Integer) tbConsultasOrcamentos.getValueAt(linha, 0);
        tipoCadastro = "Aprovar";
        //limpa tela
        this.limpaTelaNovoProduto();
        //recupera os dados do pedido para adicionar ao estoque
        this.recuperarPedido(pCodigo);
        //recupera cliente
        retornarClientePeloCodigo();
        //valta para aba 1
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btAprovarActionPerformed

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

    private void btDesaprovarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesaprovarActionPerformed
        //recebe a linha selecionada
        int linha = this.tbConsultasPedidos.getSelectedRow();
        //pega o codigo na linha selecionada
        int pCodigo = (Integer) tbConsultasPedidos.getValueAt(linha, 0);
        //pegunta se realmente deseja excluir
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                + " transformar o pedido nº:" + pCodigo + " em um orçamento ?", "Atenção", JOptionPane.YES_NO_OPTION);
        //se sim exclui, se não não faz nada    
        if (opcao == JOptionPane.OK_OPTION) {
            //limpa tela
            this.limpaTelaNovoProduto();
            //recupera os dados do pedido para adicionar ao estoque
            this.recuperarPedido(pCodigo);
            //adiciona ao estoque
            this.retornarProdutoAoEstoque();
            //trasfora pedido em orçamento
            VendaController.desaprovarPedidoController(pCodigo);
            //limpa a tela novamente
            this.limpaTelaNovoProduto();
            //carregar lista de v e o
            this.carregarPedidos();
            this.carregarOrcamentos();
        } else {
            JOptionPane.showMessageDialog(this, "Você cancelou a operação!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btDesaprovarActionPerformed

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
        this.tfValorUnitario.setText(bLMascaras.converterVirgulaParaPonto(this.tfValorUnitario.getText()));
    }//GEN-LAST:event_tfValorUnitarioKeyReleased

    private void tfQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQuantidadeKeyReleased
        // TODO add your handling code here:
        this.tfQuantidade.setText(bLMascaras.converterVirgulaParaPonto(this.tfQuantidade.getText()));
    }//GEN-LAST:event_tfQuantidadeKeyReleased

    private void tfObservacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfObservacaoFocusLost
        this.tfObservacao.setText(tfObservacao.getText().toUpperCase());
        this.tfObservacao.setText(bLMascaras.TiraAcentos(tfObservacao.getText()));
    }//GEN-LAST:event_tfObservacaoFocusLost

    private void tfPesquisaPedidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPesquisaPedidoFocusLost
        this.tfPesquisaPedido.setText(tfPesquisaPedido.getText().toUpperCase());
        this.tfPesquisaPedido.setText(bLMascaras.TiraAcentos(tfPesquisaPedido.getText()));
    }//GEN-LAST:event_tfPesquisaPedidoFocusLost

    private void tfPesquisaorcamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPesquisaorcamentoFocusLost
        this.tfPesquisaorcamento.setText(tfPesquisaorcamento.getText().toUpperCase());
        this.tfPesquisaorcamento.setText(bLMascaras.TiraAcentos(tfPesquisaorcamento.getText()));
    }//GEN-LAST:event_tfPesquisaorcamentoFocusLost

    private void cbClientesPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbClientesPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (this.cbClientes.isPopupVisible()) {
            modelClienteCidadeEstado = controllerClienteCidadeEstado.getClienteCidadeEstadoController(cbClientes.getSelectedItem().toString());
            //recupera o código
            this.cbCodCliente.setSelectedItem(modelClienteCidadeEstado.getCliente().getCodigo());
            this.tfEndereco.setText(modelClienteCidadeEstado.getCliente().getEndereco());
            this.tfBairro.setText(modelClienteCidadeEstado.getCliente().getBairro());
            this.tfEstado.setText(modelClienteCidadeEstado.getEstado().getUf());
            this.tfCidade.setText(modelClienteCidadeEstado.getCidade().getNome());
            this.tfTelefone.setText(modelClienteCidadeEstado.getCliente().getTelefone());
            this.tfCpfCnpj.setText(modelClienteCidadeEstado.getCliente().getCpfCNPJ());
            this.tfObservacaoCliente.setText(modelClienteCidadeEstado.getCliente().getObservacao());
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
        if (this.cbProduto.isPopupVisible()) {
            //INICIO recupera o nome
            retornarprodutoPeloNome();
        }
    }//GEN-LAST:event_cbProdutosPopupMenuWillBecomeInvisible

    private void cbCodProdutoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbCodProdutoPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (this.cbCodProduto.isPopupVisible()) {
            modelProdutos = controllerProdutos.getProdutosController(Integer.parseInt(cbCodProduto.getSelectedItem().toString()));
            //recupera o código
            this.cbProduto.setSelectedItem(String.valueOf(modelProdutos.getNome()));
            this.tfUnidadeMedida.setText(controllerUnidadeMedia.getUnidadeMediaController(modelProdutos.getUnidadeMedida()).getAbreviacao());
            this.tfValorUnitario.setText(String.valueOf(modelProdutos.getValor()));
            tfValorTotalProduto.setText(calcularValorproduto(this.tfQuantidade.getText(), this.tfValorUnitario.getText()) + "");
        }
    }//GEN-LAST:event_cbCodProdutoPopupMenuWillBecomeInvisible

    /**
     *
     * @param pClienteCodigo 0 - busca o cliente baseado no combobox codigo
     * cliente
     */
    private void retornarClientePeloCodigo() {
        modelClienteCidadeEstado = controllerClienteCidadeEstado.getClienteCidadeEstadoController(Integer.parseInt(cbCodCliente.getSelectedItem().toString()));

        this.cbClientes.setSelectedItem(String.valueOf(modelClienteCidadeEstado.getCliente().getNome()));
        this.tfEndereco.setText(modelClienteCidadeEstado.getCliente().getEndereco());
        this.tfBairro.setText(modelClienteCidadeEstado.getCliente().getBairro());
        this.tfEstado.setText(modelClienteCidadeEstado.getEstado().getUf());
        this.tfCidade.setText(modelClienteCidadeEstado.getCidade().getNome());
        this.tfTelefone.setText(modelClienteCidadeEstado.getCliente().getTelefone());
        this.tfCpfCnpj.setText(modelClienteCidadeEstado.getCliente().getCpfCNPJ());
        this.tfObservacaoCliente.setText(modelClienteCidadeEstado.getCliente().getObservacao());
    }

    private int recuperarPedido(int pCodigo) {
        try {
            int codigoProduto;
            modelVendas.setCodigo(pCodigo);
            //recupera os dados do banco
            modelVendas = VendaController.getVendasController(pCodigo);
            //seta os dados na interface
            this.cbCodCliente.setSelectedItem(modelVendas.getClientesCodigo());
            this.tfNumeroVenda.setText(String.valueOf(modelVendas.getCodigo()));
            this.tfDesconto.setText(String.valueOf(modelVendas.getDesconto()));
            this.tfValorTotal.setText(String.valueOf(modelVendas.getValorTotal()));
            this.jcbTipoPagamento.setSelectedItem(controllerTipoPagamento.getFormaPagamentoController(modelVendas.getTipoPagamento()).getDescricao());
            this.tfObservacao.setText(modelVendas.getObservacao());
            //recupera os dados do banco
            listaVendaAlterar = VendaController.getListaVendasController(pCodigo);
            //carregar lista de produtos da venda
            DefaultTableModel modelo = (DefaultTableModel) tbProdutos.getModel();
            modelo.setNumRows(0);

            int cont = listaVendaAlterar.size();
            String unidadeMedida = "";
            String fornecedor = "";
            for (int i = 0; i < cont; i++) {
                codigoProduto = listaVendaAlterar.get(i).getProdutosCodigo();
                modelProdutos = controllerProdutos.getProdutosController(codigoProduto);
                unidadeMedida = controllerUnidadeMedia.getUnidadeMediaController(modelProdutos.getUnidadeMedida()).getAbreviacao();
                fornecedor = controllerFornecedor.getFornecedorProdutoController(codigoProduto).getNome();
                modelo.addRow(new Object[]{
                    listaVendaAlterar.get(i).getProdutosCodigo(),
                    modelProdutos.getNome(),
                    fornecedor,
                    listaVendaAlterar.get(i).getValor(),
                    listaVendaAlterar.get(i).getQuantidade(),
                    listaVendaAlterar.get(i).getQuantidade().multiply(listaVendaAlterar.get(i).getValor()),
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
        modelCaixa = new Caixa();
        modelCaixa = controllerCaixa.getCaixaController(1);
        if (modelVendas.getTipoPagamento() == 1) {
            valorDinheiro = modelVendas.getValorTotal().floatValue();
            modelCaixa.setDinheiro(modelCaixa.getDinheiro() + valorDinheiro);
        } else if (modelVendas.getTipoPagamento() == 2) {
            valorCartao = modelVendas.getValorTotal().floatValue();
            modelCaixa.setCartao(modelCaixa.getCartao() + valorCartao);
        } else if (modelVendas.getTipoPagamento() == 3) {
            valorCheque = modelVendas.getValorTotal().floatValue();
            modelCaixa.setCheque(modelCaixa.getCheque() + valorCheque);
        } else if (modelVendas.getTipoPagamento() == 4) {
            valorVale = modelVendas.getValorTotal().floatValue();
            modelCaixa.setConvenio(modelCaixa.getConvenio() + valorVale);
        }
        controllerCaixa.atualizarCaixaController(modelCaixa);
    }

    //usa apenas para carregar os dados da interface quando abre o software
    private void retornarDadosCliente() {
        modelClienteCidadeEstado = controllerClienteCidadeEstado.getClienteCidadeEstadoController(cbClientes.getSelectedItem().toString());
        //recupera o código
        this.cbCodCliente.setSelectedItem(modelClienteCidadeEstado.getCliente().getCodigo());
        this.tfEndereco.setText(modelClienteCidadeEstado.getCliente().getEndereco());
        this.tfBairro.setText(modelClienteCidadeEstado.getCliente().getBairro());
        this.tfEstado.setText(modelClienteCidadeEstado.getEstado().getUf());
        this.tfCidade.setText(modelClienteCidadeEstado.getCidade().getNome());
        this.tfTelefone.setText(modelClienteCidadeEstado.getCliente().getTelefone());
        this.tfCpfCnpj.setText(modelClienteCidadeEstado.getCliente().getCpfCNPJ());
        this.tfObservacaoCliente.setText(modelClienteCidadeEstado.getCliente().getObservacao());
    }

    //usa apenas para carregar os dados da interface quando abre o software
    private void retornarDadosProduto() {
        modelProdutos = controllerProdutos.getProdutosController(Integer.parseInt(cbCodProduto.getSelectedItem().toString()));
        //recupera o código
        this.cbProduto.setSelectedItem(String.valueOf(modelProdutos.getNome()));
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
        this.tfDesconto.setText("0");
        this.tfObservacao.setText("");
        tipoCadastro = "Novo";
        contVendaMenor = 0;
        tfValorTotalProduto.setText(calcularValorproduto(this.tfQuantidade.getText(), this.tfValorUnitario.getText()) + "");
    }

    private void habilitarCampos() {
        cbClientes.setEnabled(true);
        cbProduto.setEnabled(true);
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
            String permissao = new PermissaoUsuarioController().getPermissaousuarioCodUsuController(new SessaoUsuario().codigo).getPermissao();
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
            this.cbProduto.getSelectedItem().toString(),
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

    private void carregarPedidos() {
        listaVenda = VendaController.getListaPedidosController();
        DefaultTableModel modelo = (DefaultTableModel) tbConsultasPedidos.getModel();
        modelo.setNumRows(0);
        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listaVenda.size();
        for (int i = 0; i < cont; i++) {
            modelCliente = controllerCliente.getClienteController(listaVenda.get(i).getClientesCodigo());
            modelo.addRow(new Object[]{
                listaVenda.get(i).getCodigo(),
                modelCliente.getNome(),
                modelCliente.getCpfCNPJ(),
                listaVenda.get(i).getValorTotal(),
                bLMascaras.formatarData(listaVenda.get(i).getDataVenda()),
                listaVenda.get(i).getObservacao(),
                modelCliente.getObservacao()
            });
        }
    }

    private void carregarOrcamentos() {
        listaVenda = VendaController.getListaOrcamentoController();
        DefaultTableModel modelo = (DefaultTableModel) tbConsultasOrcamentos.getModel();
        modelo.setNumRows(0);
        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listaVenda.size();
        for (int i = 0; i < cont; i++) {
            modelCliente = controllerCliente.getClienteController(listaVenda.get(i).getClientesCodigo());
            modelo.addRow(new Object[]{
                listaVenda.get(i).getCodigo(),
                modelCliente.getNome(),
                modelCliente.getCpfCNPJ(),
                listaVenda.get(i).getValorTotal(),
                bLMascaras.formatarData(listaVenda.get(i).getDataVenda()),
                listaVenda.get(i).getObservacao(),
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
        listaProduto = new ArrayList<>();
        int cont = listaVendaAlterar.size();
        for (int i = 0; i < cont; i++) {
            modelProdutos = new Produto();
            modelProdutos.setCodigo(listaVendaAlterar.get(i).getProdutosCodigo());
            quantidade = (new BigDecimal(controllerProdutos.getProdutosController(modelProdutos.getCodigo()).getEstoque()).add(listaVendaAlterar.get(i).getQuantidade())).floatValue();
            modelProdutos.setEstoque(quantidade);
            listaProduto.add(modelProdutos);
        }
        modelProdutos.setListaProdutoes(listaProduto);
        controllerProdutos.atualizarProdutosQuantidadeController(modelProdutos);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btAprovar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCancelar1;
    private javax.swing.JButton btCancelar2;
    private javax.swing.JButton btDesaprovar;
    private javax.swing.JButton btFinalizar;
    private javax.swing.JButton btIncluirProduto;
    private javax.swing.JButton btPesquisarOrcamento;
    private javax.swing.JButton btPesquisarPedido;
    private javax.swing.JButton btRetirar;
    private br.com.inosystem.ugcomp.components.UJComboBox cbClientes;
    private br.com.inosystem.ugcomp.components.UJComboBox cbCodCliente;
    private br.com.inosystem.ugcomp.components.UJComboBox cbCodProduto;
    private javax.swing.JComboBox cbFiltroPesquisaOrcamento;
    private javax.swing.JComboBox cbFiltroPesquisaPedido;
    private br.com.inosystem.ugcomp.components.UJComboBox cbProduto;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbImprimirOrcamento;
    private javax.swing.JButton jbImprimirPedido;
    private javax.swing.JComboBox jcbTipoPagamento;
    private javax.swing.JTable tbConsultasOrcamentos;
    private javax.swing.JTable tbConsultasPedidos;
    private javax.swing.JTable tbProdutos;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfCpfCnpj;
    private javax.swing.JTextField tfDesconto;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfEstado;
    private javax.swing.JTextField tfNumeroVenda;
    private javax.swing.JTextPane tfObservacao;
    private javax.swing.JTextField tfObservacaoCliente;
    private javax.swing.JTextField tfPesquisaPedido;
    private javax.swing.JTextField tfPesquisaorcamento;
    private javax.swing.JTextField tfQuantidade;
    private javax.swing.JTextField tfTelefone;
    private javax.swing.JTextField tfUnidadeMedida;
    private javax.swing.JFormattedTextField tfValorTotal;
    private javax.swing.JTextField tfValorTotalProduto;
    private javax.swing.JTextField tfValorUnitario;
    // End of variables declaration//GEN-END:variables

}
