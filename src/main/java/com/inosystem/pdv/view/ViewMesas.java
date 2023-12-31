package com.inosystem.pdv.view;

import com.inosystem.pdv.contoller.CaixaController;
import com.inosystem.pdv.contoller.ClienteCidadeEstadoController;
import com.inosystem.pdv.contoller.EmpresaCidadeEstadoController;
import com.inosystem.pdv.contoller.FormaPagamentoController;
import com.inosystem.pdv.contoller.GarcomController;
import com.inosystem.pdv.contoller.ItensPedidoMesaController;
import com.inosystem.pdv.contoller.ProdutoController;
import com.inosystem.pdv.contoller.VendaController;
import com.inosystem.pdv.contoller.VendaProdutoController;
import com.inosystem.pdv.model.Caixa;
import com.inosystem.pdv.model.ClienteCidadeEstado;
import com.inosystem.pdv.model.Config;
import com.inosystem.pdv.model.EmpresaCidadeEstado;
import com.inosystem.pdv.model.Garcom;
import com.inosystem.pdv.model.ItensPedidoMesa;
import com.inosystem.pdv.model.Mesas;
import com.inosystem.pdv.model.Produto;
import com.inosystem.pdv.model.SessaoUsuario;
import com.inosystem.pdv.model.Venda;
import com.inosystem.pdv.model.VendaProduto;
import com.inosystem.pdv.util.AguardeGerandoRelatorio;
import com.inosystem.pdv.util.GerarCupom;
import com.inosystem.pdv.util.Impressora;
import com.inosystem.pdv.util.ManipularXML;
import com.inosystem.pdv.util.Mascara;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jrpbjr
 */
public class ViewMesas extends javax.swing.JFrame {

    ArrayList<Produto> listaProdutoses = new ArrayList<>();
    Produto modelProdutos = new Produto();
    ProdutoController controllerProdutos = new ProdutoController();
    ItensPedidoMesa modelItensPedidoMesa = new ItensPedidoMesa();
    ItensPedidoMesaController controllerItensPedidoMesa = new ItensPedidoMesaController();
    ArrayList<ItensPedidoMesa> listaItensPedidoMesas = new ArrayList<>();
    ArrayList<Mesas> listaMesases = new ArrayList<>();
    Mesas modelMesas = new Mesas();
    ArrayList<Venda> listaVenda = new ArrayList<>();
    VendaController VendaController = new VendaController();
    Caixa modelCaixa = new Caixa();
    CaixaController controllerCaixa = new CaixaController();
    Venda modelVendas = new Venda();
    FormaPagamentoController controllerFormaPagamento = new FormaPagamentoController();
    private ViewPagamentoPDV viewPagamentoPDV;
    private ViewQuantidadeProdutoMesa viewQuantMesas;
    private ViewAlterStatus viewAlterStatus;
    float valorCartao, valorCheque, valorDinheiro, valorVale;
    public int codigoVenda;
    ArrayList<JRadioButton> listadeBotoes = new ArrayList<>();
    int mesaParaImprimir;
    String nomeImpressora;
    Mascara bLMascaras = new Mascara();
    ArrayList<Integer> listaMesasOcupadas = new ArrayList<>();
    Config modelConfig = new Config();
    ManipularXML manipularXML = new ManipularXML();
    VendaProdutoController VendaControllerProdutos = new VendaProdutoController();
    EmpresaCidadeEstadoController controllerEmpresaCidadeEstado = new EmpresaCidadeEstadoController();
    ArrayList<VendaProduto> listaVendaProdutoses = new ArrayList<>();
    EmpresaCidadeEstado modelEmpresaCidadeEstado = new EmpresaCidadeEstado();
    ClienteCidadeEstado modelClienteCidadeEstado = new ClienteCidadeEstado();
    ClienteCidadeEstadoController controllerClienteCidadeEstado = new ClienteCidadeEstadoController();
    ArrayList<Garcom> listaGarcoms = new ArrayList<>();
    GarcomController GarcomController = new GarcomController();
    int codigoGarcom;

    /**
     * Creates new form ViewMesas
     */
    public ViewMesas() {
        initComponents();
//        new ExecutarSemLogin().autenticar();
        //pegar os dados do xml
        modelConfig = manipularXML.lerXmlConfig();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        redimesionar();
        this.popularTabela();
        this.viewPagamentoPDV = new ViewPagamentoPDV(this, true);
        this.viewQuantMesas = new ViewQuantidadeProdutoMesa(this, true);
        this.viewAlterStatus = new ViewAlterStatus(this, true);
        carregarProdutosList();
        carregarNumeroMesas();
        executarem5S();
        listaGarcom();
        retornarGarcom();
    }

    private void retornarGarcom() {
        codigoGarcom = GarcomController.getGarcomController(jcbGarcom.getSelectedItem().toString()).getCodigo();
    }

    private void redimesionar() {
        jPanelMesas.setMinimumSize(new Dimension(450, jPanel2.getHeight() - 30));
        jPanelMesas.setPreferredSize(new Dimension(450, jPanel2.getHeight() - 30));
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanelMesas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jlStatus = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlNumeroMesa = new javax.swing.JLabel();
        jcbGarcom = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbNomeProdutos = new javax.swing.JTable();
        jtfPesquisar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfValorTotalMesa = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProdutosStatus = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiConfigurar = new javax.swing.JMenuItem();
        jmiSair = new javax.swing.JMenuItem();
        jmiVizualizar = new javax.swing.JMenu();
        jmiFecharConta = new javax.swing.JMenuItem();
        jmiRemoverProduto = new javax.swing.JMenuItem();
        jmiVizualizarped = new javax.swing.JMenuItem();
        jmiImprimirCozinha = new javax.swing.JMenuItem();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Venda por Mesas");
        setIconImage(new ImageIcon(getClass().getResource("/imagens/blicon.png")).getImage());
        setUndecorated(true);
        setResizable(false);

        jTabbedPane1.setToolTipText("");

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanelMesas.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setViewportView(jPanelMesas);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("ITENS DO PEDIDO"));

        tbProdutos.setBackground(new java.awt.Color(0, 255, 204));
        tbProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod.", "Produto", "Qt.", "Valor Unit.", "Valor Total", "Status", "OBS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbProdutos);
        if (tbProdutos.getColumnModel().getColumnCount() > 0) {
            tbProdutos.getColumnModel().getColumn(0).setMinWidth(0);
            tbProdutos.getColumnModel().getColumn(0).setPreferredWidth(0);
            tbProdutos.getColumnModel().getColumn(0).setMaxWidth(0);
            tbProdutos.getColumnModel().getColumn(1).setMinWidth(150);
            tbProdutos.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbProdutos.getColumnModel().getColumn(1).setMaxWidth(150);
            tbProdutos.getColumnModel().getColumn(2).setMinWidth(40);
            tbProdutos.getColumnModel().getColumn(2).setPreferredWidth(40);
            tbProdutos.getColumnModel().getColumn(2).setMaxWidth(40);
            tbProdutos.getColumnModel().getColumn(3).setMinWidth(70);
            tbProdutos.getColumnModel().getColumn(3).setPreferredWidth(70);
            tbProdutos.getColumnModel().getColumn(3).setMaxWidth(70);
            tbProdutos.getColumnModel().getColumn(4).setMinWidth(70);
            tbProdutos.getColumnModel().getColumn(4).setPreferredWidth(70);
            tbProdutos.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Status:");

        jlStatus.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlStatus.setForeground(new java.awt.Color(0, 102, 102));
        jlStatus.setText("Status");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 255));
        jLabel4.setText("MESA SELECIONADA - ");

        jlNumeroMesa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlNumeroMesa.setForeground(new java.awt.Color(51, 102, 255));
        jlNumeroMesa.setText("0");

        jcbGarcom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jcbGarcom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbGarcom.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbGarcomPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlNumeroMesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbGarcom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jlStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel4)
                .addComponent(jlNumeroMesa)
                .addComponent(jcbGarcom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("PRODUTOS"));

        tbNomeProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod.", "Produto", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbNomeProdutos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbNomeProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbNomeProdutosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbNomeProdutos);
        if (tbNomeProdutos.getColumnModel().getColumnCount() > 0) {
            tbNomeProdutos.getColumnModel().getColumn(0).setMinWidth(0);
            tbNomeProdutos.getColumnModel().getColumn(0).setPreferredWidth(0);
            tbNomeProdutos.getColumnModel().getColumn(0).setMaxWidth(0);
            tbNomeProdutos.getColumnModel().getColumn(2).setMinWidth(60);
            tbNomeProdutos.getColumnModel().getColumn(2).setPreferredWidth(60);
            tbNomeProdutos.getColumnModel().getColumn(2).setMaxWidth(60);
        }

        jtfPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPesquisarKeyReleased(evt);
            }
        });

        jLabel2.setText("Pesquisar:");

        tfValorTotalMesa.setEditable(false);
        tfValorTotalMesa.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 0));
        jLabel12.setText("Valor total:");

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("[F4]FECHAR CONTA - [F5]REMOVER PRODUTO - [F7]VIZUALIZAR - [F8]IMPRIMIR PARA COZINHA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfPesquisar))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfValorTotalMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfValorTotalMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))))
        );

        jTabbedPane1.addTab("Mesas", jPanel2);

        jtProdutosStatus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº da Mesa", "Status", "Nome", "Quant.", "Observação", "Cod item"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtProdutosStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProdutosStatusMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProdutosStatus);
        if (jtProdutosStatus.getColumnModel().getColumnCount() > 0) {
            jtProdutosStatus.getColumnModel().getColumn(0).setMinWidth(80);
            jtProdutosStatus.getColumnModel().getColumn(0).setPreferredWidth(80);
            jtProdutosStatus.getColumnModel().getColumn(0).setMaxWidth(80);
            jtProdutosStatus.getColumnModel().getColumn(1).setPreferredWidth(150);
            jtProdutosStatus.getColumnModel().getColumn(3).setMinWidth(80);
            jtProdutosStatus.getColumnModel().getColumn(3).setPreferredWidth(80);
            jtProdutosStatus.getColumnModel().getColumn(3).setMaxWidth(80);
            jtProdutosStatus.getColumnModel().getColumn(5).setMinWidth(0);
            jtProdutosStatus.getColumnModel().getColumn(5).setPreferredWidth(0);
            jtProdutosStatus.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Acompanhar/Alterar Status", jPanel4);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-funcionalidades-extra-filled-50(1).png"))); // NOI18N
        jMenu1.setText("Arquivo");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jmiConfigurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-manutenção-filled-50.png"))); // NOI18N
        jmiConfigurar.setText("Alterar quantidade de mesas");
        jmiConfigurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConfigurarActionPerformed(evt);
            }
        });
        jMenu1.add(jmiConfigurar);

        jmiSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 20/icons8-sair-filled-50.png"))); // NOI18N
        jmiSair.setText("Sair");
        jmiSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSairActionPerformed(evt);
            }
        });
        jMenu1.add(jmiSair);

        jMenuBar1.add(jMenu1);

        jmiVizualizar.setText("Comandos");

        jmiFecharConta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jmiFecharConta.setText("Fechar Conta");
        jmiFecharConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiFecharContaActionPerformed(evt);
            }
        });
        jmiVizualizar.add(jmiFecharConta);

        jmiRemoverProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jmiRemoverProduto.setText("Remover Produto");
        jmiRemoverProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRemoverProdutoActionPerformed(evt);
            }
        });
        jmiVizualizar.add(jmiRemoverProduto);

        jmiVizualizarped.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        jmiVizualizarped.setText("Vizualizar Pedido");
        jmiVizualizarped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiVizualizarpedActionPerformed(evt);
            }
        });
        jmiVizualizar.add(jmiVizualizarped);

        jmiImprimirCozinha.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        jmiImprimirCozinha.setText("Imprimir para Cozinha");
        jmiImprimirCozinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiImprimirCozinhaActionPerformed(evt);
            }
        });
        jmiVizualizar.add(jmiImprimirCozinha);

        jMenuBar1.add(jmiVizualizar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbNomeProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbNomeProdutosMouseClicked
        // TODO add your handling code here:
        if (jlNumeroMesa.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Nenhuma mesa selecionada!");
        } else {
            int linha = tbNomeProdutos.getSelectedRow();
            int codigo = (Integer) tbNomeProdutos.getValueAt(linha, 0);
            String nome = (String) tbNomeProdutos.getValueAt(linha, 1);
            double valor = (double) tbNomeProdutos.getValueAt(linha, 2);
            viewQuantMesas.setVisible(true);
            if (viewQuantMesas.getQuantidade() > 0) {
                double valorTotal = somaValorTotal(viewQuantMesas.getQuantidade(), valor);
                String observacao = viewQuantMesas.getObservacao();

                //Adiciona linhas na tabela
                DefaultTableModel modelo = (DefaultTableModel) tbProdutos.getModel();
                int cont = 0;
                for (int i = 0; i < cont; i++) {
                    modelo.setNumRows(0);
                }

                //pega a quantidade de linhas e joga na variavel
                modelo.addRow(new Object[]{
                    codigo,
                    nome,
                    viewQuantMesas.getQuantidade(),
                    valor,
                    bLMascaras.arredondamentoDoubleComPontoDuasCasasString(valorTotal),
                    "Em pedido",
                    observacao
                });

                this.tfValorTotalMesa.setText(String.valueOf(this.somaEAtualizaValorTotal()));
                //salva uma venda
                cadastrarVendaMesa();
                popularTabela();
                revalidate();
            }
        }
    }//GEN-LAST:event_tbNomeProdutosMouseClicked

    private void jtfPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisarKeyReleased
        //filtrar na tabela quando digitar
        this.jtfPesquisar.setText(jtfPesquisar.getText().toUpperCase());
        DefaultTableModel tabelaProdutos = (DefaultTableModel) this.tbNomeProdutos.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabelaProdutos);
        this.tbNomeProdutos.setRowSorter(sorter);
        String text = jtfPesquisar.getText();
        sorter.setRowFilter(RowFilter.regexFilter(text, 1));
    }//GEN-LAST:event_jtfPesquisarKeyReleased

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jmiConfigurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConfigurarActionPerformed
        // TODO add your handling code here:
        int quantMesas = 0;
        try {
            quantMesas = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de mesas do bar?"));
            salarArquivoXML(quantMesas);
            JOptionPane.showMessageDialog(this, "Inicia novamente a venda por mesa!");
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Você deve informar um número inteiro!");
            quantMesas = 50;
        }
    }//GEN-LAST:event_jmiConfigurarActionPerformed

    private void jmiSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jmiSairActionPerformed

    private void jmiImprimirCozinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiImprimirCozinhaActionPerformed
        //pegar numero da mesa
        int mesa = 0;
        try {
            mesa = Integer.parseInt(jlNumeroMesa.getText());
        } catch (Exception e) {
            mesa = 0;
        }
        mesaParaImprimir = mesa;
        //pegunta
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja"
                + " imprimir o pedido n°:\n" + "\n " + mesa + "?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.OK_OPTION) {
            final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
            carregando.setVisible(true);
            Thread t = new Thread() {
                @Override
                public void run() {
                    //relatorio cozinha
                    //passo o nome da impressora, e o texto a ser impresso
                    imprimirCupom(mesaParaImprimir);
                    carregando.dispose();
                }
            };
            t.start();
        }
    }//GEN-LAST:event_jmiImprimirCozinhaActionPerformed

    private void jmiVizualizarpedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiVizualizarpedActionPerformed
        final AguardeGerandoRelatorio carregando = new AguardeGerandoRelatorio();
        final VendaController VendaController = new VendaController();
        carregando.setVisible(true);
        Thread t = new Thread() {
            @Override
            public void run() {
                // vizualizar vendas;
                VendaController.vizualizarMesaController(Integer.parseInt(jlNumeroMesa.getText()));
                carregando.dispose();
            }
        };
        t.start();
    }//GEN-LAST:event_jmiVizualizarpedActionPerformed

    private void jmiRemoverProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRemoverProdutoActionPerformed
        JComboBox jcb = new JComboBox();
        DefaultTableModel modelo = (DefaultTableModel) tbProdutos.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            jcb.addItem(modelo.getValueAt(i, 1));
        }
        int opcao = JOptionPane.showConfirmDialog(null, jcb, "Selecione o item para cancelar!", JOptionPane.OK_CANCEL_OPTION);
        //se sim exclui, se não não faz nada
        if (opcao == JOptionPane.OK_OPTION) {
            // Remove a linha
            modelo.removeRow(jcb.getSelectedIndex());
        }
        this.tfValorTotalMesa.setText(String.valueOf(this.somaEAtualizaValorTotal()));

        cadastrarVendaMesa();
        popularTabela();
        revalidate();
    }//GEN-LAST:event_jmiRemoverProdutoActionPerformed

    private void jmiFecharContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiFecharContaActionPerformed
        // TODO add your handling code here:
        if (tbProdutos.getRowCount() < 1) {
            JOptionPane.showMessageDialog(this, "Você deve adicioar ao menos um produto para prosseguir!");
        } else {
            modelMesas = new Mesas();
            //fechar conta da mesa

            //setar os dados da mesa
            try {
                modelMesas.setNumeroMesa(Integer.parseInt(this.jlNumeroMesa.getText()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Você deve selecionar uma mesa para prosseguir!");
            }
            modelMesas.setSituacaoMesa("livre");

            viewPagamentoPDV.setValorTotal(Float.parseFloat(this.tfValorTotalMesa.getText()));
            viewPagamentoPDV.setTextFildValorTotal();
            viewPagamentoPDV.setVisible(true);
            zerarValoresCaixa();
            if (viewPagamentoPDV.getReturnStatus() == 1) {
                salvarVenda();
                //exlui dados anteriores
                controllerItensPedidoMesa.excluirItensPedidoMesaController(Integer.parseInt(this.jlNumeroMesa.getText()));
                //pintar na tela
                popularTabela();
                //limpar dados da interface
                this.limparCamposAbaDois();
                this.limparTabelaAbaDois();
            }
        }
    }//GEN-LAST:event_jmiFecharContaActionPerformed

    private void jtProdutosStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProdutosStatusMouseClicked
        // TODO add your handling code here:
        int linha = jtProdutosStatus.getSelectedRow();
        // Verificamos se existe realmente alguma linha selecionada
        if (linha < 0) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um item na tabela antes de clicar aqui!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            String status = (String) jtProdutosStatus.getValueAt(linha, 1);
            int item = (int) jtProdutosStatus.getValueAt(linha, 5);
            //setar dados na proxima interface
            viewAlterStatus.setStatus(status);
            viewAlterStatus.setItem(item);
            viewAlterStatus.setTextFildStatus();
            //chamr interface
            viewAlterStatus.setVisible(true);
            //atualiza a tabela
            carregarItensStatusMesa();
        }
    }//GEN-LAST:event_jtProdutosStatusMouseClicked

    private void jcbGarcomPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbGarcomPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        if (this.jcbGarcom.isPopupVisible()) {
            retornarGarcom();
        }
    }//GEN-LAST:event_jcbGarcomPopupMenuWillBecomeInvisible

    private void irPraMesa() {
        // TODO add your handling code here:  
        int mesa = 0;
        String mesaString;
        for (int i = 0; i < listadeBotoes.size(); i++) {
            if (listadeBotoes.get(i).isSelected()) {
                mesaString = listadeBotoes.get(i).getText();
                mesaString = mesaString.trim();
                mesa = Integer.parseInt(mesaString);
            }
        }
        if (mesa == 0) {

        } else {
            this.jlNumeroMesa.setText(mesa + "");
            //retornar todos os produtos do pedido da mesa
            listaItensPedidoMesas = controllerItensPedidoMesa.getListaItensPedidoMesaController(mesa);

            //preencher a tabela com os itens retornados
            DefaultTableModel modelo = (DefaultTableModel) tbProdutos.getModel();
            modelo.setNumRows(0);
            //CARREGA OS DADOS DA LISTA NA TABELA
            int cont = listaItensPedidoMesas.size();
            for (int i = 0; i < cont; i++) {
                modelProdutos = controllerProdutos.getProdutosController(listaItensPedidoMesas.get(i).getCodigoProduto());
                modelo.addRow(new Object[]{
                    listaItensPedidoMesas.get(i).getCodigoProduto(),
                    modelProdutos.getNome(),
                    listaItensPedidoMesas.get(i).getQuantidade(),
                    modelProdutos.getValor(),
                    modelProdutos.getValor() * listaItensPedidoMesas.get(i).getQuantidade(),
                    listaItensPedidoMesas.get(i).getStatusPedido(),
                    listaItensPedidoMesas.get(i).getObservacao()
                });
            }
            //SOMA VALOR TOTAL 
            this.tfValorTotalMesa.setText(String.valueOf(this.somaEAtualizaValorTotal()));
        }
    }

    //chamar o metodo para executar de 5 em 5 segundos a população e atualização da tabela
    public void executarem5S() {
        Timer timer = null;
        long TEMPO = (1000 * 5); // chama o método a cada 5 segundos 
        if (timer == null) {
            timer = new Timer();
            TimerTask tarefa = new TimerTask() {
                public void run() {
                    try {
                        //chama outro metodo ou executa uma função...
                        popularTabela();
                        carregarItensStatusMesa();
                    } catch (Exception e) {
                        System.out.println(e.getStackTrace());
                    }
                }
            };
            timer.scheduleAtFixedRate(tarefa, TEMPO, TEMPO);
        }
    }

    private void salarArquivoXML(int pquantMesas) {
        modelConfig = new Config();
        modelConfig = manipularXML.lerXmlConfig();

        try {
            modelConfig.setQuantidadeMesas(pquantMesas);
            SessaoUsuario.quantidadeMesas = modelConfig.getQuantidadeMesas();
            manipularXML.gravaXML(modelConfig);
            JOptionPane.showMessageDialog(this, "Registro salvo com sucesso!", "Atenção", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Imprimir cupom
     */
    private void imprimirCupom(int pCodigo) {
        try {
            //definir impressora
            String nomeImpressora = modelConfig.getImpressoraCozinha();
            //gerar dados e imprimir
            String textoImprimir = new GerarCupom().geraCupomCozinha(pCodigo);
            //enviar para impressora
            Impressora.imprimir(nomeImpressora, textoImprimir);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a impressão !!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregarItensStatusMesa() {
        //retornar todos os produtos do pedido da mesa
        listaItensPedidoMesas = controllerItensPedidoMesa.getListaItensPedidoMesaController();

        //preencher a tabela com os itens retornados
        DefaultTableModel modelo = (DefaultTableModel) jtProdutosStatus.getModel();
        modelo.setNumRows(0);
        //CARREGA OS DADOS DA LISTA NA TABELA
        int cont = listaItensPedidoMesas.size();
        for (int i = 0; i < cont; i++) {
            modelProdutos = controllerProdutos.getProdutosController(listaItensPedidoMesas.get(i).getCodigoProduto());
            modelo.addRow(new Object[]{
                listaItensPedidoMesas.get(i).getCodigoMesa(),
                listaItensPedidoMesas.get(i).getStatusPedido(),
                modelProdutos.getNome(),
                listaItensPedidoMesas.get(i).getQuantidade(),
                listaItensPedidoMesas.get(i).getObservacao(),
                listaItensPedidoMesas.get(i).getCodigo()
            });
        }
    }

    public void centralizarContainer(Component pai, Component filho) {

        // obter dimensões do pai  
        int larguraPai = pai.getWidth();
        int alturaPai = pai.getHeight();

        // obter dimensões do filho  
        int larguraFilho = filho.getWidth();
        int alturaFilho = filho.getWidth();

        // calcular novas coordenadas do filho    
        int novoX = (larguraPai - larguraFilho);
        int novoY = (alturaPai - alturaFilho);

        // centralizar filho  
        filho.setSize(new Dimension(novoX, novoY));
        filho.repaint();
    }

    /**
     * inserir e pentar mesas.
     */
    private void popularTabela() {
        jPanelMesas.removeAll();
        listaMesasOcupadas = controllerItensPedidoMesa.getListaMesasOcupadasController();
        for (int i = 1; i <= modelConfig.getQuantidadeMesas(); i++) {
            JLabel labelDesenho = new JLabel();
            JRadioButton btRadio = new JRadioButton();
            labelDesenho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 30/mesa-30.png")));
            labelDesenho.setText("      ");

            btRadio.setFont(new Font("Tahoma", 0, 18));

            btRadio.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    irPraMesa();
                }
            });

//            pinta de verde
            btRadio.setForeground(Color.GREEN);
            for (int j = 0; j < listaMesasOcupadas.size(); j++) {
                if (i == listaMesasOcupadas.get(j)) {
                    labelDesenho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons 30/mesa-de-restaurante-30.png")));
                    btRadio.setForeground(Color.BLUE);
                    break;
                }
            }
            if (i < 10) {
                btRadio.setText("0" + i);
            } else {
                btRadio.setText("" + i);
            }
            buttonGroup1.add(btRadio);
            listadeBotoes.add(btRadio);
            // adicionar no painel
            jPanelMesas.add(btRadio);
            jPanelMesas.add(labelDesenho);

            labelDesenho.setLabelFor(btRadio);
        }
        jPanelMesas.validate();
    }

    //salvar uma venda de mesa
    private boolean salvarVenda() {
        listaVenda = new ArrayList<>();
        listaProdutoses = new ArrayList<>();
        int codigoProduto;
        float quantidade = 0;

        for (int i = 0; i < tbProdutos.getRowCount(); i++) {
            modelVendas = new Venda();
            modelProdutos = new Produto();
            modelVendas.setClientesCodigo(1);
            modelVendas.setDesconto(new BigDecimal(viewPagamentoPDV.getDesconto()));
            modelVendas.setTaxaEntrega(new BigDecimal(0f));
            modelVendas.setValorTotal(new BigDecimal(viewPagamentoPDV.getValorTotal()));
            modelVendas.setCodigoUsuario(SessaoUsuario.codigo);
            modelVendas.setTipo(1);
            try {
                modelVendas.setDataVenda(bLMascaras.converterDataParaDateUS(new java.util.Date(System.currentTimeMillis())));
            } catch (Exception ex) {
                Logger.getLogger(ViewVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
            codigoProduto = Integer.parseInt(tbProdutos.getValueAt(i, 0).toString());
            modelVendas.setProdutosCodigo(codigoProduto);
            modelVendas.setQuantidade(new BigDecimal(tbProdutos.getValueAt(i, 2).toString()));
            modelVendas.setTipoPagamento(controllerFormaPagamento.getFormaPagamentoController(viewPagamentoPDV.getTipoPagamento()).getCodigo());
            modelVendas.setValor(new BigDecimal(tbProdutos.getValueAt(i, 3).toString()));
            modelProdutos.setCodigo(codigoProduto);
            quantidade = Float.parseFloat(tbProdutos.getValueAt(i, 2).toString());
            modelProdutos.setEstoque(quantidade);
            modelProdutos.setValor(Double.parseDouble(tbProdutos.getValueAt(i, 3).toString()));
            listaVenda.add(modelVendas);
            listaProdutoses.add(modelProdutos);
        }
        modelVendas.setListamVendaes(listaVenda);
        modelProdutos.setListaProdutoes(listaProdutoses);

        //salvar venda
        codigoVenda = VendaController.salvarVendasController(modelVendas);
        if (codigoVenda > 0) {
            modelVendas.setCodigo(codigoVenda);
            //da baixa no estoque
            for (int i = 0; i < modelProdutos.getListaProdutoes().size(); i++) {
                codigoProduto = modelProdutos.getListaProdutoes().get(i).getCodigo();
                quantidade = controllerProdutos.getProdutosController(codigoProduto).getEstoque() - modelProdutos.getListaProdutoes().get(i).getEstoque();
                controllerProdutos.atualizarProdutosQuantidadeUmController(codigoProduto, quantidade);
            }

            //salvar lista de produtos
            VendaController.salvarVendasProdutosController(modelVendas);
            JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!");
            adicionarValorCaixa();
            //imprimir cupom
            imprimirCupomPDV(codigoVenda);

            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao gravar os dados!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Imprimir cupom
     */
    private void imprimirCupomPDV(int pCodigo) {
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

    //adicionar valor ao caixa
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

    //zerar o caixa
    private void zerarValoresCaixa() {
        valorCartao = 0;
        valorCheque = 0;
        valorDinheiro = 0;
        valorVale = 0;
    }

    //soma valor total da conta do cliente e seta no campo total
    private double somaValorTotal(float pQuantidade, double pValor) {
        return (pQuantidade * pValor);
    }

    //limpar dados da tabela da aba 2
    private void limparTabelaAbaDois() {
        DefaultTableModel modelo = (DefaultTableModel) tbProdutos.getModel();
        modelo.setNumRows(0);
    }

    //limpar campos da tabela da aba 2
    private void limparCamposAbaDois() {
        this.tfValorTotalMesa.setText("");
    }

    /**
     * Preencher combobox estados
     */
    private void listaGarcom() {
        listaGarcoms = GarcomController.getListaGarcomController();
        jcbGarcom.removeAllItems();
        for (int i = 0; i < listaGarcoms.size(); i++) {
            jcbGarcom.addItem(listaGarcoms.get(i).getNome());
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
            java.util.logging.Logger.getLogger(ViewMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMesas().setVisible(true);
            }
        });
    }

    //listar todos os produtos no jlist
    private void carregarProdutosList() {
        DefaultTableModel modelo = (DefaultTableModel) tbNomeProdutos.getModel();
        modelo.setNumRows(0);
        listaProdutoses = controllerProdutos.getListaProdutosController();
        for (int i = 0; i < listaProdutoses.size(); i++) {
            modelo.addRow(new Object[]{
                listaProdutoses.get(i).getCodigo(),
                listaProdutoses.get(i).getNome(),
                listaProdutoses.get(i).getValor()
            });
        }

    }

    private void carregarNumeroMesas() {
        carregarItensStatusMesa();
    }

    //cadastrar um venda de uma mesa
    private boolean cadastrarVendaMesa() {
        try {
            int numeroMesa = Integer.parseInt(this.jlNumeroMesa.getText());

            //exlui dados anteriores
            controllerItensPedidoMesa.excluirItensPedidoMesaController(numeroMesa);
            if (tbProdutos.getRowCount() < 1) {
                JOptionPane.showMessageDialog(this, "Você deve adicionar ao menos um produto para salvar!", "ATENÇÂO", JOptionPane.WARNING_MESSAGE);
                return false;
            } else {
                listaItensPedidoMesas = new ArrayList<>();

                for (int i = 0; i < tbProdutos.getRowCount(); i++) {
                    modelItensPedidoMesa = new ItensPedidoMesa();
                    modelItensPedidoMesa.setCodigoMesa(numeroMesa);
                    modelItensPedidoMesa.setCodigoProduto(Integer.parseInt(tbProdutos.getValueAt(i, 0).toString()));
                    modelItensPedidoMesa.setQuantidade(Float.parseFloat(tbProdutos.getValueAt(i, 2).toString()));
                    modelItensPedidoMesa.setObservacao(tbProdutos.getValueAt(i, 6).toString());
                    modelItensPedidoMesa.setHora(bLMascaras.retornarHora());
                    modelItensPedidoMesa.setCodigoGarcom(codigoGarcom);
                    modelItensPedidoMesa.setStatusPedido("Em aberto");
                    
                    listaItensPedidoMesas.add(modelItensPedidoMesa);
                }

                modelProdutos.setListaProdutoes(listaProdutoses);

                //exclui registros anteriores se ouver
                controllerItensPedidoMesa.excluirItensPedidoMesaController(modelItensPedidoMesa.getCodigoMesa());
                //salvar
                controllerItensPedidoMesa.salvarItensPedidoMesaController(listaItensPedidoMesas);
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Você deve adicionar ao menos um produto para salvar!", "ATENÇÂO", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    /**
     * Soma e atualiza os valores total
     *
     * @return
     */
    private float somaEAtualizaValorTotal() {
        float soma = 0;
        float valor = 0;
        int cont = tbProdutos.getRowCount();
        for (int i = 0; i < cont; i++) {
            valor = Float.parseFloat(String.valueOf(tbProdutos.getValueAt(i, 4)));
            soma = valor + soma;
        }
        return new Mascara().arredondamentoComPontoDuasCasas(soma);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanelMesas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> jcbGarcom;
    private javax.swing.JLabel jlNumeroMesa;
    private javax.swing.JLabel jlStatus;
    private javax.swing.JMenuItem jmiConfigurar;
    private javax.swing.JMenuItem jmiFecharConta;
    private javax.swing.JMenuItem jmiImprimirCozinha;
    private javax.swing.JMenuItem jmiRemoverProduto;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JMenu jmiVizualizar;
    private javax.swing.JMenuItem jmiVizualizarped;
    private javax.swing.JTable jtProdutosStatus;
    private javax.swing.JTextField jtfPesquisar;
    private javax.swing.JTable tbNomeProdutos;
    private javax.swing.JTable tbProdutos;
    private javax.swing.JTextField tfValorTotalMesa;
    // End of variables declaration//GEN-END:variables
}
