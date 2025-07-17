/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ProdutoController;
import model.ProdutoModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ProdutoView extends JFrame {

    private JPanel formulario, consulta, botaoPanel, f1, f2;
    private JLabel LCodigo, LNome, LEstoque, LUnidade, LPreco, LCusto,
            LAtacado, LMin, LMax, LEnbalagem, LPeso, LCadastro, LOBS, LAtivo;
    private JTextField TCodigo, TNome, TEStoque, TUnidade, TPreco, TAtacado, TMin,
            TMax, TEnbalagem, TPeso, TOBS, SCusto;
    private SpinnerDateModel date;
    private JSpinner SCadastro;
    private JCheckBox CAtivo;
    private JTable TAconsulta;
    private JButton BPesquisar, BSalvar, BEditar, BExcluir, BLinpar, BImpimir;

    private String operacao;
    private JLabel A, ComCodigo, ComNome, ComPreco;
    private JTextField edtCONS_ID1, edtCONS_ID2, edtCONS_NOME, edtCONS_Preco1, edtCONS_Preco2;
    private ArrayList<ProdutoModel> lista;
    private String colunas[] = {"Código", "Nome", "Estoque", "Unidade", "Preço", "Cadastro", "OBS", "Ativo"};
    private ProdutoTabelaModel tabela;
    private JScrollPane Scon;

    public ProdutoView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(625, 630)); // ajuste do tamanho e layout
        setLayout(null);
        setTitle("Produtos"); // título do frame
        CriarComponentes(); // instancia componentes (objetos Swing);
        AdicionarComponentes(); // adiciona componentes no frame
        ConfigurarPosicoes(); // configura as posices dos componentes;
        pack(); // reorganiza os componentes (objetos) no frame
        setVisible(true); // deixa o frame visível
        consultar();
        TCodigo.setText("0");
    }

    public void CriarComponentes() {
        formulario = new JPanel(null);
        formulario.setBorder(BorderFactory.createTitledBorder("Dados do Produtos"));

        f1 = new JPanel(new GridLayout(0, 2, 40, 8));

        f2 = new JPanel(new GridLayout(0, 2, 50, 5));

        LCodigo = new JLabel("Codigo:");
        TCodigo = new JTextField();
        LCodigo.setFont(new Font("Arial", Font.PLAIN, 20));

        LNome = new JLabel("Nome:");
        TNome = new JTextField();
        LNome.setFont(new Font("Arial", Font.PLAIN, 20));

        LEstoque = new JLabel("Estoque:");
        TEStoque = new JTextField();
        LEstoque.setFont(new Font("Arial", Font.PLAIN, 20));

        LUnidade = new JLabel("Unidade:");
        TUnidade = new JTextField();
        LUnidade.setFont(new Font("Arial", Font.PLAIN, 20));

        LPreco = new JLabel("Preço:");
        TPreco = new JTextField();
        LPreco.setFont(new Font("Arial", Font.PLAIN, 20));

        LCusto = new JLabel("Custo:");
        SCusto = new JTextField();
        LCusto.setFont(new Font("Arial", Font.PLAIN, 20));

        LAtacado = new JLabel("Atacado:");
        TAtacado = new JTextField();
        LAtacado.setFont(new Font("Arial", Font.PLAIN, 20));

        LMin = new JLabel("Minimu:");
        TMin = new JTextField();
        LMin.setFont(new Font("Arial", Font.PLAIN, 20));

        LMax = new JLabel("Maximo:");
        TMax = new JTextField();
        LMax.setFont(new Font("Arial", Font.PLAIN, 20));

        LEnbalagem = new JLabel("Enbalagem:");
        TEnbalagem = new JTextField();
        LEnbalagem.setFont(new Font("Arial", Font.PLAIN, 20));

        LPeso = new JLabel("Peso:");
        TPeso = new JTextField();
        LPeso.setFont(new Font("Arial", Font.PLAIN, 20));

        LCadastro = new JLabel("Cadastro:");
        date = new SpinnerDateModel();
        SCadastro = new JSpinner(date);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(SCadastro, "yyyy-MM-dd");
        SCadastro.setEditor(editor);
        LCadastro.setFont(new Font("Arial", Font.PLAIN, 20));

        LOBS = new JLabel("OBS:");
        TOBS = new JTextField();
        LOBS.setFont(new Font("Arial", Font.PLAIN, 20));

        CAtivo = new JCheckBox("Ativo?");
        CAtivo.setFont(new Font("Arial", Font.PLAIN, 20));

        consulta = new JPanel(null);
        consulta.setBorder(BorderFactory.createTitledBorder("Consulta de Produtos"));
        ComCodigo = new JLabel("Codigo:");
        edtCONS_ID1 = new JTextField();
        edtCONS_ID2 = new JTextField();
        ComPreco = new JLabel("Preço:");
        edtCONS_Preco1 = new JTextField();
        edtCONS_Preco2 = new JTextField();
        ComNome = new JLabel("Nome:");
        edtCONS_NOME = new JTextField();
        A = new JLabel("Á");
        TAconsulta = new JTable();
        Scon = new JScrollPane(TAconsulta);
        BPesquisar = new JButton("Pesquisar");

        botaoPanel = new JPanel(new FlowLayout());
        BLinpar = new JButton("Limpar");
        BSalvar = new JButton("Salvar");
        BEditar = new JButton("Editar");
        BExcluir = new JButton("Excluir");
        BImpimir = new JButton("Impimir");

        // Adicionar eventos aos botões
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

        TAconsulta.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()) {
                    return;
                }
                int selecionado = TAconsulta.getSelectedRow();
                if (selecionado >= 0) {
                    mostrar(lista.get(selecionado));
                }
            }
        });
    }

    public void AdicionarComponentes() {

        consulta.add(Scon);
        consulta.add(BPesquisar);
        consulta.add(ComCodigo);
        consulta.add(ComNome);
        consulta.add(ComPreco);
        consulta.add(A);
        consulta.add(edtCONS_ID1);
        consulta.add(edtCONS_ID2);
        consulta.add(edtCONS_NOME);
        consulta.add(edtCONS_Preco1);
        consulta.add(edtCONS_Preco2);

        f1.add(LCodigo);
        f1.add(TCodigo);

        f1.add(LNome);
        f1.add(TNome);

        f1.add(LEstoque);
        f1.add(TEStoque);

        f1.add(LUnidade);
        f1.add(TUnidade);

        f1.add(LPreco);
        f1.add(TPreco);

        f1.add(LCusto);
        f1.add(SCusto);

        f1.add(LAtacado);
        f1.add(TAtacado);

        f2.add(LMin);
        f2.add(TMin);

        f2.add(LMax);
        f2.add(TMax);

        f2.add(LEnbalagem);
        f2.add(TEnbalagem);

        f2.add(LPeso);
        f2.add(TPeso);

        f2.add(LCadastro);
        f2.add(SCadastro);

        f2.add(LOBS);
        f2.add(TOBS);

        f2.add(CAtivo);

        formulario.add(f1);
        formulario.add(f2);

        botaoPanel.add(BLinpar);
        botaoPanel.add(BSalvar);
        botaoPanel.add(BEditar);
        botaoPanel.add(BExcluir);
        botaoPanel.add(BImpimir);

        add(formulario);
        add(consulta);
        add(botaoPanel);
    }

    private void ConfigurarPosicoes() {
        formulario.setBounds(10, 10, 600, 225);
        f1.setBounds(10, 20, 250, 200);
        f2.setBounds(290, 20, 300, 200);

        consulta.setBounds(10, 240, 600, 300);
        ComCodigo.setBounds(5, 25, 100, 25);
        edtCONS_ID1.setBounds(50, 25, 100, 25);
        A.setBounds(160, 45, 100, 25);
        edtCONS_ID2.setBounds(180, 25, 100, 25);
        ComPreco.setBounds(5, 55, 100, 25);
        edtCONS_Preco1.setBounds(50, 55, 100, 25);
        edtCONS_Preco2.setBounds(180, 55, 100, 25);
        ComNome.setBounds(290, 25, 100, 25);
        edtCONS_NOME.setBounds(330, 25, 340, 25);
        BPesquisar.setBounds(400, 55, 100, 25);
        Scon.setBounds(5, 100, 590, 200);

        botaoPanel.setBounds(100, 545, 400, 150);
    }

    private void limparCampos() {
        TCodigo.setText("0");
        TNome.setText("");
        TEStoque.setText("");
        TUnidade.setText("");
        TPreco.setText("");
        TAtacado.setText("");
        TMin.setText("");
        TMax.setText("");
        TEnbalagem.setText("");
        TPeso.setText("");
        TOBS.setText("");
        SCusto.setText("");
        CAtivo.setSelected(false);
        edtCONS_ID1.setText("");
        edtCONS_ID2.setText("");
        edtCONS_NOME.setText("");
        edtCONS_Preco1.setText("");
        edtCONS_Preco2.setText("");
    }

    private void gravar() {
        if (JOptionPane.showConfirmDialog(null, "Confirma Gravação deste Usuário ?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                ProdutoModel objusuario = new ProdutoModel();
                objusuario.setPRO_codigo(Integer.parseInt(TCodigo.getText()));
                objusuario.setPRO_nome(TNome.getText());
                objusuario.setPRO_estoque(new BigDecimal(TEStoque.getText()));
                objusuario.setPRO_unidade(TUnidade.getText());
                objusuario.setPRO_preco(new BigDecimal(TPreco.getText()));
                objusuario.setPRO_custo(new BigDecimal(SCusto.getText()));
                objusuario.setPRO_atacado(new BigDecimal(TAtacado.getText()));
                objusuario.setPRO_min(new BigDecimal(TMin.getText()));
                objusuario.setPRO_max(new BigDecimal(TMax.getText()));
                objusuario.setPRO_embalagem(new BigDecimal(TEnbalagem.getText()));
                objusuario.setPRO_peso(new BigDecimal(TPeso.getText()));
                objusuario.setPRO_cadastro(date.getDate());
                objusuario.setPRO_OBS(TOBS.getText());
                objusuario.setPRO_ativo((CAtivo.isSelected() ? 1 : 0));

                ProdutoController usuariocontroller = new ProdutoController();
                usuariocontroller.gravar(objusuario, getOperacao());

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
                ProdutoModel objusuario = new ProdutoModel();
                objusuario.setPRO_codigo(Integer.parseInt(TCodigo.getText()));
                objusuario.setPRO_nome(TNome.getText());

                ProdutoController usuariocontroller = new ProdutoController();
                usuariocontroller.excluir(objusuario);

                JOptionPane.showMessageDialog(null, "Registro Excluído com Sucesso");
                consultar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro na Exclusão de Registro \n" + ex.getMessage());
            }
        }
    }

    private void consultar() {
        String condicao = filtroConsulta();
        ProdutoController produtocontroller = new ProdutoController();
        lista = null;
        lista = produtocontroller.consultar(condicao);
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não Existem Produto Cadastrados !");
        } else {
            tabela = new ProdutoTabelaModel(lista, colunas);
            TAconsulta.setModel(tabela);
            TAconsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
    }

    private String filtroConsulta() {
        String condicao = "";
        if (!edtCONS_ID1.getText().trim().equals("")) {
            condicao += "(PRO_codigo >= " + edtCONS_ID1.getText() + ")";
        }
        if (!edtCONS_ID2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(PRO_codigo <= " + edtCONS_ID2.getText() + ")";
        }
        if (!edtCONS_NOME.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(PRO_nome LIKE ('%" + edtCONS_NOME.getText() + "%'))";
        }
        if (!edtCONS_Preco1.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(PRO_preco >= " + edtCONS_Preco1.getText() + ")";
        }
        if (!edtCONS_Preco2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(PRO_preco <= " + edtCONS_Preco2.getText() + ")";
        }
        if (!condicao.isEmpty()) {
            condicao = " where " + condicao;
        }
        return condicao;
    }
    private void mostrar(ProdutoModel objModel) {
        TCodigo.setText(String.valueOf(objModel.getPRO_codigo()));
        TNome.setText(String.valueOf(objModel.getPRO_nome()));
        TEStoque.setText(String.valueOf(objModel.getPRO_estoque()));
        TUnidade.setText(String.valueOf(objModel.getPRO_unidade()));
        TPreco.setText(String.valueOf(objModel.getPRO_preco()));
        SCusto.setText(String.valueOf(objModel.getPRO_custo()));
        TAtacado.setText(String.valueOf(objModel.getPRO_atacado()));
        TMin.setText(String.valueOf(objModel.getPRO_min()));
        TMax.setText(String.valueOf(objModel.getPRO_max()));
        TEnbalagem.setText(String.valueOf(objModel.getPRO_embalagem()));
        TPeso.setText(String.valueOf(objModel.getPRO_peso()));
        TOBS.setText(String.valueOf(objModel.getPRO_OBS()));
        CAtivo.setSelected((objModel.getPRO_ativo() == 1));
    }

    private void Imprimir(java.awt.event.ActionEvent evt) {
        ProdutoController objController = new ProdutoController();
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
