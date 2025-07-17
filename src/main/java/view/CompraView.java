/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.CompraController;
import controller.FornecedorController;
import controller.ProdutoController;
import controller.UsuarioController;
import controller.CompraProdutoController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.CompraModel;
import model.CompraProdutoModel;
import model.FornecedorModel;
import model.UsuarioModel;

/**
 *
 * @author samsung
 */
public class CompraView extends JFrame {

    private JPanel dados, consulta, botaoPanel, f1, f2, f3, f4, f5, f7, f8;
    private JLabel LCodigo, LValor, LDesconto, LTotal, LEmissao, LEntrada;
    private JTextField TCodigo, NValor, NDesconto, NTotal;
    private JTable TAConsulta, TACarinho;
    private JComboBox<String> CUsuario, CFornesedor;
    private JTextArea OBS;
    private JScrollPane f6;
    private JSpinner SEmissao, SEntrada;
    private SpinnerDateModel date, date2;
    private JButton BPesquisar, BCarinho, BSalvar, BEditar, BExcluir, BLinpar, BImpimir;

    private String operacao;
    private JLabel A, A2, A3, ComCodigo, ComUsu, ComValor, ComDescomto, ComTotal;
    private JTextField edtCONS_ID1, edtCONS_ID2, edtCONS_USU1, edtCONS_USU2, edtCONS_Vol1, edtCONS_Vol2,
            edtCONS_Des1, edtCONS_Des2, edtCONS_Tot1, edtCONS_Tot2;
    private ArrayList<CompraModel> lista;
    private ArrayList<CompraProdutoModel> Carrinho = new ArrayList<>();
    private String colunas[] = {"Código", "Valor", "Desconto", "Total", "Usuario", "Fonecedor"};
    private String colunas2[] = {"Prduto", "Quantidade", "Valor", "Desconto", "Total"};
    private CompraTabelaModel tabela;
    private CompraProdutoTabelaModel tabela2;
    private JScrollPane Scon, Scon2;

    ArrayList<FornecedorModel> listaFornecedor;
    ArrayList<UsuarioModel> listaUsuario;

    public CompraView() {
        setTitle("Compra"); // título do frame
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
        fonecedorCom();
        consultar();
        TCodigo.setText("0");
    }

    public void CriarComponentes() {
        f1 = new JPanel(null);
        f1.setBorder(BorderFactory.createTitledBorder("Compra"));

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
        TCodigo.setText("0");
        LEmissao = new JLabel("Data de Emissao:");
        LEmissao.setFont(new Font("Arial", Font.PLAIN, 18));
        date = new SpinnerDateModel();
        SEmissao = new JSpinner(date);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(SEmissao, "yyyy-MM-dd");
        SEmissao.setEditor(editor);
        LEntrada = new JLabel("Data de Entrada:");
        LEntrada.setFont(new Font("Arial", Font.PLAIN, 18));
        date2 = new SpinnerDateModel();
        SEntrada = new JSpinner(date2);
        JSpinner.DateEditor editor2 = new JSpinner.DateEditor(SEntrada, "yyyy-MM-dd");
        SEntrada.setEditor(editor2);

        f7 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        CUsuario = new JComboBox();
        CUsuario.addItem("Usuario   ");
        CFornesedor = new JComboBox();
        CFornesedor.addItem("Fornesedor   ");

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
        ComTotal = new JLabel("Total:");
        edtCONS_Tot1 = new JTextField();
        edtCONS_Tot2 = new JTextField();
        ComUsu = new JLabel("Usuario:");
        edtCONS_USU1 = new JTextField();
        edtCONS_USU2 = new JTextField();
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

        BPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultar();
            }
        });

        BImpimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Imprimir(evt);
            }
        });

        BCarinho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                add();
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
                    mostrar(lista.get(selecionado));
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
        f4.add(LEmissao);
        f4.add(SEmissao);
        f4.add(LEntrada);
        f4.add(SEntrada);
        dados.add(f7, BorderLayout.SOUTH);
        f7.add(CUsuario);
        f7.add(CFornesedor);

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
    }

    private void ConfigurarPosicoes() {
        f1.setBounds(1, 1, 1550, 680);
        botaoPanel.setBounds(15, 20, 150, 300);
        f5.setBounds(170, 20, 230, 340);
        dados.setBounds(400, 20, 950, 340);
        consulta.setBounds(260, 360, 870, 300);

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
    }

    private void usuarioCom() {
        UsuarioController compracontroller = new UsuarioController();
        listaUsuario = null;
        listaUsuario = compracontroller.consultar("");
        for (int i = 0; i < listaUsuario.size(); i++) {
            CUsuario.addItem(listaUsuario.get(i).getUSU_NOME());
        }

    }

    private void fonecedorCom() {
        FornecedorController compracontroller = new FornecedorController();
        listaFornecedor = null;
        listaFornecedor = compracontroller.consultar("");
        for (int i = 0; i < listaFornecedor.size(); i++) {
            CFornesedor.addItem(listaFornecedor.get(i).getPES_codigo().getPES_nome());
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
    }

    private void add() {
        String Produto = JOptionPane.showInputDialog("digite o codigo do produto");
        String Qtde = JOptionPane.showInputDialog("Quantidade");
        String Desconto = JOptionPane.showInputDialog("Desconto");

        try {
            ProdutoController pro = new ProdutoController();
            CompraProdutoModel addProduto = new CompraProdutoModel();
            addProduto.setPRO_codigo(pro.get(Integer.parseInt(Produto)));
            addProduto.setCPP_qtde(new BigDecimal(Qtde));
            BigDecimal preco = new BigDecimal(0);
            addProduto.setCPP_preco(preco.add(addProduto.getPRO_codigo().getPRO_custo()));
            addProduto.setCPP_desconto(new BigDecimal(Desconto));
            Carrinho.add(addProduto);
            TabelaCarrinho();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro na Exclusão de Registro \n" + ex.getMessage());
        }
    }

    private void TabelaCarrinho() {
        tabela2 = new CompraProdutoTabelaModel(Carrinho, colunas2);
        TACarinho.setModel(tabela2);
        TACarinho.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        BigDecimal v = new BigDecimal(0.0);
        BigDecimal d = new BigDecimal(0.0);
        BigDecimal t = new BigDecimal(0.0);

        for (int i = 0; i < Carrinho.size(); i++) {
            v = Carrinho.get(i).getCPP_preco().add(v);
            d = Carrinho.get(i).getCPP_desconto().add(d);
            t = t.add((Carrinho.get(i).getCPP_qtde().multiply(Carrinho.get(i).getCPP_preco())).subtract(Carrinho.get(i).getCPP_desconto()));
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

    private int gravarFOR() {
        int u;
        if (CFornesedor.getSelectedIndex() > 0) {
            u = CFornesedor.getSelectedIndex() - 1;
        } else {
            u = CFornesedor.getSelectedIndex();
        }
        return u;
    }

    private void gravar() {
        if (JOptionPane.showConfirmDialog(null, "Confirma Gravação desta Compra ?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {

                CompraModel objusuario = new CompraModel();
                objusuario.setCPR_codigo(Integer.parseInt(TCodigo.getText()));
                objusuario.setUSU_codigo(listaUsuario.get(gravarUSU()));
                objusuario.setFOR_codigo(listaFornecedor.get(gravarFOR()));
                objusuario.setCPR_dtentrada(date2.getDate());
                objusuario.setCPR_emissao(date.getDate());
                objusuario.setCPR_valor(new BigDecimal(NValor.getText()));
                objusuario.setCPR_desconto(new BigDecimal(NDesconto.getText()));
                objusuario.setCPR_total(new BigDecimal(NTotal.getText()));
                objusuario.setCPR_OBS((OBS.getText()));

                CompraController usuariocontroller = new CompraController();
                usuariocontroller.gravar(objusuario, getOperacao());

                CompraProdutoController a = new CompraProdutoController();
                for (int i = 0; i < Carrinho.size(); i++) {
                    Carrinho.get(i).setCPR_codigo(objusuario);
                    a.gravar(Carrinho.get(i), getOperacao());
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
                CompraModel objusuario = new CompraModel();
                objusuario.setCPR_codigo(Integer.parseInt(TCodigo.getText()));
                CompraController usuariocontroller = new CompraController();
                usuariocontroller.excluir(objusuario);

                JOptionPane.showMessageDialog(null, "Registro Excluído com Sucesso");
                consultar();
                
                Carrinho = null;
                DefaultTableModel modeloVazio = new DefaultTableModel();
                TACarinho.setModel(modeloVazio);
                TACarinho.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro na Exclusão de Registro \n" + ex.getMessage());
            }
        }
    }

    private void consultar() {
        String condicao = filtroConsulta();
        CompraController usuariocontroller = new CompraController();
        lista = null;
        lista = usuariocontroller.consultar(condicao);
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não Existem Compras Cadastrados !");
        } else {
            tabela = new CompraTabelaModel(lista, colunas);
            TAConsulta.setModel(tabela);
            TAConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
    }

    private String filtroConsulta() {
        String condicao = "";
        if (!edtCONS_ID1.getText().trim().equals("")) {
            condicao += "(CPR_codigo >= " + edtCONS_ID1.getText() + ")";
        }
        if (!edtCONS_ID2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(CPR_codigo <= " + edtCONS_ID2.getText() + ")";
        }
        if (!edtCONS_Vol1.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(CPR_valor >= " + edtCONS_Vol1.getText() + ")";
        }
        if (!edtCONS_Vol2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(CPR_valor <= " + edtCONS_Vol2.getText() + ")";
        }
        if (!edtCONS_Tot1.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(CPR_total >= " + edtCONS_Tot1.getText() + ")";
        }
        if (!edtCONS_Tot2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(CPR_total <= " + edtCONS_Tot2.getText() + ")";
        }
        if (!edtCONS_Des1.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(CPR_desconto >= " + edtCONS_Des1.getText() + ")";
        }
        if (!edtCONS_Des2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(CPR_desconto <= " + edtCONS_Des2.getText() + ")";
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

    private void mostrar(CompraModel objModel) {
        TCodigo.setText(String.valueOf(objModel.getCPR_codigo()));

        CompraProdutoController usuariocontroller = new CompraProdutoController();
        Carrinho = null;
        Carrinho = usuariocontroller.consultar("where (c.CPR_codigo.CPR_codigo = " + objModel.getCPR_codigo() + ")");
        if (Carrinho.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Compra vasia!");
        } else {
            tabela2 = new CompraProdutoTabelaModel(Carrinho, colunas2);
            TACarinho.setModel(tabela2);
            TACarinho.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
    }

    private void Imprimir(java.awt.event.ActionEvent evt) {
        CompraController objController = new CompraController();
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
