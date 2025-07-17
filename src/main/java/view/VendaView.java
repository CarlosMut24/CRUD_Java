/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.UsuarioController;
import controller.ClienteController;
import controller.ProdutoController;
import controller.VendaController;
import controller.FormaPagtoController;
import controller.VendaProdutoController;
import controller.VendaPagatoController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.ClienteModel;
import model.UsuarioModel;
import model.VendaModel;
import model.VendaPagtoModel;
import model.VendaProdutoModel;

public class VendaView extends JFrame {

    private JPanel dados, consulta, botaoPanel, f1, f2, f3, f4, f5, f7, f8;
    private JLabel LCodigo, LValor, LDesconto, LTotal, LForpagamento, LEntrada;
    private JTextField TCodigo, NValor, NDesconto, NTotal;
    private JTable TAConsulta, TACarinho, TAForpagamento;
    private JComboBox<String> CUsuario, CCliente;
    private JTextArea OBS;
    private JScrollPane f6;
    private JSpinner SEntrada;
    private SpinnerDateModel date;
    private JButton BPesquisar, BCarinho, BSalvar, BEditar, BExcluir, BLinpar, BForpagamento, BImpimir;

    private String operacao;
    private JLabel A, A2, A3, ComCodigo, ComUsu, ComValor, ComDescomto, ComTotal;
    private JTextField edtCONS_ID1, edtCONS_ID2, edtCONS_USU1, edtCONS_USU2, edtCONS_Vol1, edtCONS_Vol2,
            edtCONS_Des1, edtCONS_Des2, edtCONS_Tot1, edtCONS_Tot2;
    private ArrayList<VendaModel> lista;
    private ArrayList<VendaProdutoModel> Carrinho = new ArrayList<>();
    private ArrayList<VendaPagtoModel> ForPagato = new ArrayList<>();
    private String colunas[] = {"Código", "Valor", "Desconto", "Total", "Usuario", "Fonecedor"};
    private String colunas2[] = {"Prduto", "Quantidade", "Valor", "Desconto", "Total"};
    private String colunas3[] = {"Fromade de pagamento", "Valor"};
    private VendaTabelaModel tabela;
    private VendaProdutoTabelaModel tabela2;
    private VendaPagtoTabelaModel tabela3;
    private JScrollPane Scon, Scon2, Scon3;

    ArrayList<ClienteModel> listaCliente;
    ArrayList<UsuarioModel> listaUsuario;

    public VendaView() {
        setTitle("Venda"); // título do frame
        setPreferredSize(new Dimension(1610, 710)); // ajuste do tamanho e layout
        setLayout(null); // aqui a definicao para utilizacao de layout absoluto
        CriarComponentes(); // instancia componentes (objetos Swing);
        AdicionarComponentes(); // adiciona componentes no frame
        ConfigurarPosicoes(); // configura as posices dos componentes;
        pack(); // reorganiza os componentes (objetos) no frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true); // deixa o frame visível
        setLocationRelativeTo(null);
        usuarioCom();
        clienteCom();
        consultar();
        TCodigo.setText("0");
    }

    public void CriarComponentes() {
        f1 = new JPanel(null);
        f1.setBorder(BorderFactory.createTitledBorder("Venda"));

        botaoPanel = new JPanel(new GridLayout(5, 0, 10, 20));
        BLinpar = new JButton("Limpar");
        BLinpar.setFont(new Font("Arial", Font.PLAIN, 22));
        BSalvar = new JButton("Salvar");
        BSalvar.setFont(new Font("Arial", Font.PLAIN, 22));
        BEditar = new JButton("Editar");
        BEditar.setFont(new Font("Arial", Font.PLAIN, 22));
        BExcluir = new JButton("Excluir");
        BExcluir.setFont(new Font("Arial", Font.PLAIN, 22));
        BImpimir = new JButton("Impimir");
        BImpimir.setFont(new Font("Arial", Font.PLAIN, 22));

        dados = new JPanel(new BorderLayout());
        dados.setBorder(BorderFactory.createTitledBorder("Dados"));

        f2 = new JPanel(new GridLayout(3, 2, 10, 80));
        f2.setBorder(BorderFactory.createTitledBorder("Preço"));

        LValor = new JLabel("Valor:");
        LValor.setFont(new Font("Arial", Font.PLAIN, 18));
        NValor = new JTextField();
        NValor.setText("0.00");
        NValor.setFont(new Font("Arial", Font.PLAIN, 15));

        LDesconto = new JLabel("Desconto:");
        LDesconto.setFont(new Font("Arial", Font.PLAIN, 18));
        NDesconto = new JTextField();
        NDesconto.setText("0.00");
        NDesconto.setFont(new Font("Arial", Font.PLAIN, 15));

        LTotal = new JLabel("Total:");
        LTotal.setFont(new Font("Arial", Font.PLAIN, 18));
        NTotal = new JTextField();
        NTotal.setText("0.00");
        NTotal.setFont(new Font("Arial", Font.PLAIN, 15));

        f3 = new JPanel(null);
        f3.setBorder(BorderFactory.createTitledBorder("Lista de Compra"));
        TACarinho = new JTable();
        Scon2 = new JScrollPane(TACarinho);
        BCarinho = new JButton("Add+");
        BCarinho.setFont(new Font("Arial", Font.PLAIN, 18));

        f4 = new JPanel(new GridLayout(1, 6, 0, 10));
        LCodigo = new JLabel("Codigo:");
        LCodigo.setFont(new Font("Arial", Font.PLAIN, 18));
        TCodigo = new JTextField();
        LEntrada = new JLabel("Data de Entrada:");
        LEntrada.setFont(new Font("Arial", Font.PLAIN, 18));
        date = new SpinnerDateModel();
        SEntrada = new JSpinner(date);
        JSpinner.DateEditor editor2 = new JSpinner.DateEditor(SEntrada, "yyyy-MM-dd");
        SEntrada.setEditor(editor2);

        f7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        CUsuario = new JComboBox();
        CUsuario.addItem("Usuario   ");
        CCliente = new JComboBox();
        CCliente.addItem("Cliente   ");

        consulta = new JPanel(null);
        consulta.setBorder(BorderFactory.createTitledBorder("Consulta de Compra"));
        ComCodigo = new JLabel("Codigo:");
        edtCONS_ID1 = new JTextField();
        edtCONS_ID2 = new JTextField();
        ComValor = new JLabel("Valor:");
        edtCONS_Vol1 = new JTextField();
        edtCONS_Vol2 = new JTextField();
        ComDescomto = new JLabel("Descomto:");
        edtCONS_Des1 = new JTextField();
        edtCONS_Des2 = new JTextField();
        ComTotal = new JLabel("Total:");
        edtCONS_Tot1 = new JTextField();
        edtCONS_Tot2 = new JTextField();
        ComUsu = new JLabel("Usuario:");
        edtCONS_USU1 = new JTextField();
        A = new JLabel("Á");
        A2 = new JLabel("Á");
        A3 = new JLabel("Á");
        TAConsulta = new JTable();
        Scon = new JScrollPane(TAConsulta);
        BPesquisar = new JButton("Pesquisar");

        f5 = new JPanel(new GridLayout(1, 1, 0, 0));
        f5.setBorder(BorderFactory.createTitledBorder("OBS"));

        OBS = new JTextArea();
        f6 = new JScrollPane(OBS);

        f8 = new JPanel(null);
        f8.setBorder(BorderFactory.createTitledBorder("Forma de pagameto"));
        TAForpagamento = new JTable();
        Scon3 = new JScrollPane(TAForpagamento);
        BForpagamento = new JButton("Add+");

        BLinpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        BSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOperacao("incluir");
                gravar();
            }
        });

        BEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOperacao("alterar");
                gravar();
            }
        });

        BExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluir();
            }
        });

        BImpimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Imprimir(evt);
            }
        });

        BPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultar();
            }
        });

        BCarinho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add();
            }
        });

        BForpagamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addForPagato();
            }
        });

        TAConsulta.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()) {
                    return;
                }
                int selecionado = TAConsulta.getSelectedRow();
                if (selecionado >= 0) {
                    mostrarCarrinho(lista.get(selecionado));
                    mostrarPagamento(lista.get(selecionado));
                }
            }
        });
    }

    public void AdicionarComponentes() {
        add(f1);

        f1.add(botaoPanel);
        botaoPanel.add(BLinpar);
        botaoPanel.add(BSalvar);
        botaoPanel.add(BEditar);
        botaoPanel.add(BExcluir);
        botaoPanel.add(BImpimir);

        f1.add(dados);
        dados.add(f2, BorderLayout.WEST);
        f2.add(LValor);
        f2.add(NValor);
        f2.add(LDesconto);
        f2.add(NDesconto);
        f2.add(LTotal);
        f2.add(NTotal);
        dados.add(f3, BorderLayout.CENTER);
        f3.add(Scon2);
        f3.add(BCarinho);
        dados.add(f4, BorderLayout.NORTH);
        f4.add(LCodigo);
        f4.add(TCodigo);
        f4.add(LEntrada);
        f4.add(SEntrada);
        dados.add(f7, BorderLayout.SOUTH);
        f7.add(CUsuario);
        f7.add(CCliente);

        f1.add(f5);
        f5.add(f6);

        f1.add(consulta);
        consulta.add(Scon);
        consulta.add(BPesquisar);
        consulta.add(ComCodigo);
        consulta.add(ComUsu);
        consulta.add(ComValor);
        consulta.add(ComDescomto);
        consulta.add(ComTotal);
        consulta.add(A);
        consulta.add(A2);
        consulta.add(A3);
        consulta.add(edtCONS_ID1);
        consulta.add(edtCONS_ID2);
        consulta.add(edtCONS_USU1);
        consulta.add(edtCONS_Vol1);
        consulta.add(edtCONS_Vol2);
        consulta.add(edtCONS_Des1);
        consulta.add(edtCONS_Des2);
        consulta.add(edtCONS_Tot1);
        consulta.add(edtCONS_Tot2);

        f1.add(f8);
        f8.add(Scon3);
        f8.add(BForpagamento);
    }

    private void ConfigurarPosicoes() {
        f1.setBounds(1, 1, 1550, 680);
        botaoPanel.setBounds(15, 20, 150, 300);
        f5.setBounds(170, 20, 230, 340);
        dados.setBounds(400, 20, 950, 340);
        consulta.setBounds(15, 360, 870, 300);
        f8.setBounds(890, 360, 450, 300);

        ComCodigo.setBounds(5, 25, 100, 25);
        A.setBounds(160, 25, 100, 25);
        edtCONS_ID1.setBounds(50, 25, 100, 25);
        edtCONS_ID2.setBounds(180, 25, 100, 25);
        ComValor.setBounds(290, 25, 100, 25);
        edtCONS_Vol1.setBounds(325, 25, 100, 25);
        edtCONS_Vol2.setBounds(450, 25, 100, 25);
        ComTotal.setBounds(290, 55, 100, 25);
        edtCONS_Tot1.setBounds(325, 55, 100, 25);
        edtCONS_Tot2.setBounds(450, 55, 100, 25);
        A2.setBounds(435, 45, 100, 25);
        ComDescomto.setBounds(560, 25, 100, 25);
        edtCONS_Des1.setBounds(625, 25, 100, 25);
        edtCONS_Des2.setBounds(760, 25, 100, 25);
        A3.setBounds(740, 25, 100, 25);
        ComUsu.setBounds(5, 55, 100, 25);
        edtCONS_USU1.setBounds(50, 55, 200, 25);
        BPesquisar.setBounds(625, 55, 100, 25);
        Scon.setBounds(5, 90, 860, 200);

        Scon2.setBounds(5, 15, 650, 240);
        BCarinho.setBounds(660, 15, 95, 25);

        Scon3.setBounds(5, 15, 335, 280);
        BForpagamento.setBounds(345, 15, 100, 25);
    }

    private void usuarioCom() {
        UsuarioController compracontroller = new UsuarioController();
        listaUsuario = null;
        listaUsuario = compracontroller.consultar("");
        for (int i = 0; i < listaUsuario.size(); i++) {
            CUsuario.addItem(listaUsuario.get(i).getUSU_NOME());
        }
    }

    private void clienteCom() {

        ClienteController compracontroller = new ClienteController();
        listaCliente = null;
        listaCliente = compracontroller.consultar("");
        for (int i = 0; i < listaCliente.size(); i++) {
            CCliente.addItem(listaCliente.get(i).getPES_codigo().getPES_nome());
        }

    }

    private void limparCampos() {
        TCodigo.setText("0");
        edtCONS_ID1.setText("");
        edtCONS_ID2.setText("");
        edtCONS_USU1.setText("");
        edtCONS_Vol1.setText("");
        edtCONS_Vol2.setText("");
        edtCONS_Des1.setText("");
        edtCONS_Des2.setText("");
        edtCONS_Tot1.setText("");
        edtCONS_Tot2.setText("");

        Carrinho = null;
        DefaultTableModel modeloVazio = new DefaultTableModel();
        TACarinho.setModel(modeloVazio);
        TACarinho.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ForPagato = null;
        TAForpagamento.setModel(modeloVazio);
        TAForpagamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void add() {
        String Produto = JOptionPane.showInputDialog("digite o codigo do produto");
        String Qtde = JOptionPane.showInputDialog("Quantidade");
        String Desconto = JOptionPane.showInputDialog("Desconto");

        try {
            ProdutoController pro = new ProdutoController();
            VendaProdutoModel addProduto = new VendaProdutoModel();
            addProduto.setPRO_codigo(pro.get(Integer.parseInt(Produto)));
            addProduto.setVEP_qtde(new BigDecimal(Qtde));
            BigDecimal preco = new BigDecimal(0);
            addProduto.setVEP_preco(preco.add(addProduto.getPRO_codigo().getPRO_custo()));
            preco.multiply(addProduto.getVEP_qtde());
            addProduto.setVEP_desconto(new BigDecimal(Desconto));
            addProduto.setVEP_total(preco.subtract(addProduto.getVEP_desconto()));
            Carrinho.add(addProduto);
            TabelaCarrinho();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro na Exclusão de Registro \n" + ex.getMessage());
        }
    }

    private void addForPagato() {
        String FormaPagamento = JOptionPane.showInputDialog("digite o codigo da forma de pagamento");
        String Valor = JOptionPane.showInputDialog("Valor");

        try {
            FormaPagtoController forpa = new FormaPagtoController();
            VendaPagtoModel FormaPag = new VendaPagtoModel();
            FormaPag.setFPG_codigo(forpa.get(Integer.parseInt(FormaPagamento)));
            FormaPag.setVDP_valor(new BigDecimal(Valor));
            ForPagato.add(FormaPag);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro na Exclusão de Registro \n" + ex.getMessage());
        }
        tabela3 = new VendaPagtoTabelaModel(ForPagato, colunas3);
        TAForpagamento.setModel(tabela3);
        TAForpagamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void TabelaCarrinho() {

        tabela2 = new VendaProdutoTabelaModel(Carrinho, colunas2);
        TACarinho.setModel(tabela2);
        TACarinho.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        BigDecimal v = new BigDecimal(0.0);
        BigDecimal d = new BigDecimal(0.0);
        BigDecimal t = new BigDecimal(0.0);

        for (int i = 0; i < Carrinho.size(); i++) {
            v = Carrinho.get(i).getVEP_preco().add(v);
            d = Carrinho.get(i).getVEP_desconto().add(d);
            t = t.add((Carrinho.get(i).getVEP_qtde().multiply(Carrinho.get(i).getVEP_preco())).subtract(Carrinho.get(i).getVEP_desconto()));
        }
        NValor.setText("" + v);
        NDesconto.setText("" + d);
        NTotal.setText("" + t);
    }

    private int gravarUSU() {
        int u;
        if (CUsuario.getSelectedIndex() > 0) {
            u = CUsuario.getSelectedIndex() - 1;
        } else {
            u = CUsuario.getSelectedIndex();
        }
        return u;
    }

    private int gravarCLI() {
        int u;
        if (CCliente.getSelectedIndex() > 0) {
            u = CCliente.getSelectedIndex() - 1;
        } else {
            u = CCliente.getSelectedIndex();
        }
        return u;
    }

    private void gravar() {
        if (JOptionPane.showConfirmDialog(null, "Confirma Gravação deste Venda ?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                VendaModel objusuario = new VendaModel();
                objusuario.setVDA_codigo(Integer.parseInt(TCodigo.getText()));
                objusuario.setUSU_codigo(listaUsuario.get(gravarUSU()));
                objusuario.setCLI_codigo(listaCliente.get(gravarCLI()));
                objusuario.setVDA_date(date.getDate());
                objusuario.setVDA_valor(new BigDecimal(NValor.getText()));
                objusuario.setVDA_desconto(new BigDecimal(NDesconto.getText()));
                objusuario.setVDA_total(new BigDecimal(NTotal.getText()));
                objusuario.setVEP_OBS((OBS.getText()));

                VendaController usuariocontroller = new VendaController();
                usuariocontroller.gravar(objusuario, getOperacao());

                VendaProdutoController a = new VendaProdutoController();
                for (int i = 0; i < Carrinho.size(); i++) {
                    Carrinho.get(i).setVDA_codigo(objusuario);
                    a.gravar(Carrinho.get(i), getOperacao());
                }
                VendaPagatoController b = new VendaPagatoController();
                for (int i = 0; i < ForPagato.size(); i++) {
                    ForPagato.get(i).setVDA_codigo(objusuario);
                    b.gravar(ForPagato.get(i), getOperacao());
                }
                JOptionPane.showMessageDialog(null, "Dados Gravados com Sucesso");
                consultar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro na Gravação \n" + ex.getMessage());
            }
        }
    }

    private void excluir() {
        // Implementar lógica para excluir o produto
        if (JOptionPane.showConfirmDialog(null, "Confirma Exclusão deste Registro ?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                VendaModel objusuario = new VendaModel();
                objusuario.setVDA_codigo(Integer.parseInt(TCodigo.getText()));
                VendaController usuariocontroller = new VendaController();
                usuariocontroller.excluir(objusuario);

                JOptionPane.showMessageDialog(null, "Registro Excluído com Sucesso");
                consultar();

                Carrinho = null;
                DefaultTableModel modeloVazio = new DefaultTableModel();
                TACarinho.setModel(modeloVazio);
                TACarinho.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                ForPagato = null;
                TAForpagamento.setModel(modeloVazio);
                TAForpagamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro na Exclusão de Registro \n" + ex.getMessage());
            }
        }
    }

    private void consultar() {
        String condicao = filtroConsulta();
        VendaController usuariocontroller = new VendaController();
        lista = null;
        lista = usuariocontroller.consultar(condicao);
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não Existem Usuários Cadastrados !");
        } else {
            tabela = new VendaTabelaModel(lista, colunas);
            TAConsulta.setModel(tabela);
            TAConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
    }

    private String filtroConsulta() {
        String condicao = "";
        if (!edtCONS_ID1.getText().trim().equals("")) {
            condicao += "(VDA_codigo >= " + edtCONS_ID1.getText() + ")";
        }
        if (!edtCONS_ID2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(VDA_codigo <= " + edtCONS_ID2.getText() + ")";
        }
        if (!edtCONS_Vol1.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(VDA_valor >= " + edtCONS_Vol1.getText() + ")";
        }
        if (!edtCONS_Vol2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(VDA_valor <= " + edtCONS_Vol2.getText() + ")";
        }
        if (!edtCONS_Tot1.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(VDA_total >= " + edtCONS_Tot1.getText() + ")";
        }
        if (!edtCONS_Tot2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(VDA_total <= " + edtCONS_Tot2.getText() + ")";
        }
        if (!edtCONS_Des1.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(VDA_desconto >= " + edtCONS_Des1.getText() + ")";
        }
        if (!edtCONS_Des2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(VDA_desconto <= " + edtCONS_Des2.getText() + ")";
        }
        if (!edtCONS_USU1.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(c.USU_codigo.USU_NOME LIKE ('%" + edtCONS_USU1.getText() + "%'))";
        }
        if (!condicao.isEmpty()) {
            condicao = " where " + condicao;
        }
        return condicao;
    }

    private void mostrarCarrinho(VendaModel objModel) {
        TCodigo.setText(String.valueOf(objModel.getVDA_codigo()));

        VendaProdutoController usuariocontroller = new VendaProdutoController();
        Carrinho = null;
        Carrinho = usuariocontroller.consultar("where (c.VDA_codigo.VDA_codigo = " + objModel.getVDA_codigo() + ")");
        if (Carrinho.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Compra vasia!");
        } else {
            tabela2 = new VendaProdutoTabelaModel(Carrinho, colunas2);
            TACarinho.setModel(tabela2);
            TACarinho.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
    }

    private void mostrarPagamento(VendaModel objModel) {
        TCodigo.setText(String.valueOf(objModel.getVDA_codigo()));

        VendaPagatoController usuariocontroller = new VendaPagatoController();
        ForPagato = null;
        ForPagato = usuariocontroller.consultar("where (c.VDA_codigo.VDA_codigo = " + objModel.getVDA_codigo() + ")");
        if (ForPagato.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Compra vasia!");
        } else {
            tabela3 = new VendaPagtoTabelaModel(ForPagato, colunas3);
            TAForpagamento.setModel(tabela3);
            TAForpagamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
    }

    private void Imprimir(java.awt.event.ActionEvent evt) {
        VendaController objController = new VendaController();
        Exception retorno = objController.imprimir();
        if (retorno != null) {
            JOptionPane.showMessageDialog(null, "Erro no Relatório de Usuários /n" + retorno.getMessage());
        }
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }
}
