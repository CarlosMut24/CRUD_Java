/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.FormaPagtoController;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.FormaPagtoModel;

/**
 *
 * @author samsung
 */
public class FormaPagtoView extends JFrame {

    private JPanel formulario, consulta, botaoPanel;
    private JLabel LCodigo, LNome;
    private JTextField TCodigo, TNome;
    private JCheckBox CAtivo;
    private JTable TAconsulta;
    private JButton BPesquisar, BSalvar, BEditar, BExcluir, BLinpar, BImpimir;

    private String operacao;
    private JLabel A, ComCodigo, ComNome;
    private JTextField edtCONS_ID1, edtCONS_ID2, edtCONS_NOME;
    private ArrayList<FormaPagtoModel> lista;
    private String colunas[] = {"Código", "Nome", "Ativo"};
    private FormaPagtoTabelaModel tabela;
    private JScrollPane Scon;

    public FormaPagtoView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(625, 455)); // ajuste do tamanho e layout
        setLayout(null);
        setTitle("Forma de pagamento"); // título do frame
        CriarComponentes(); // instancia componentes (objetos Swing);
        AdicionarComponentes(); // adiciona componentes no frame
        ConfigurarPosicoes(); // configura as posices dos componentes;
        consultar();
        pack(); // reorganiza os componentes (objetos) no frame
        setVisible(true); // deixa o frame visível
    }

    public void CriarComponentes() {
        formulario = new JPanel(null);
        formulario.setBorder(BorderFactory.createTitledBorder("Dados"));

        LCodigo = new JLabel("Codigo:");
        TCodigo = new JTextField();
        TCodigo.setText("0");

        LNome = new JLabel("Nome:");
        TNome = new JTextField();

        CAtivo = new JCheckBox("Ativo?");

        consulta = new JPanel(null);
        consulta.setBorder(BorderFactory.createTitledBorder("Consulta de Usuario"));
        ComCodigo = new JLabel("Codigo:");
        edtCONS_ID1 = new JTextField();
        edtCONS_ID2 = new JTextField();
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
        consulta.add(A);
        consulta.add(edtCONS_ID1);
        consulta.add(edtCONS_ID2);
        consulta.add(edtCONS_NOME);

        formulario.add(LCodigo);
        formulario.add(TCodigo);
        formulario.add(LNome);
        formulario.add(TNome);
        formulario.add(CAtivo);

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
        formulario.setBounds(10, 10, 600, 60);
        LCodigo.setBounds(5, 20, 100, 25);
        TCodigo.setBounds(50, 20, 100, 25);
        LNome.setBounds(160, 20, 100, 25);
        TNome.setBounds(200, 20, 300, 25);
        CAtivo.setBounds(500, 20, 60, 25);

        consulta.setBounds(10, 75, 600, 300);
        ComCodigo.setBounds(5, 25, 100, 25);
        edtCONS_ID1.setBounds(50, 25, 100, 25);
        A.setBounds(160, 25, 100, 25);
        edtCONS_ID2.setBounds(180, 25, 100, 25);
        ComNome.setBounds(5, 55, 100, 25);
        edtCONS_NOME.setBounds(50, 55, 430, 25);
        BPesquisar.setBounds(490, 25, 100, 25);
        Scon.setBounds(5, 100, 590, 200);

        botaoPanel.setBounds(100, 380, 400, 150);
    }

    private void limparCampos() {
        TCodigo.setText("0");
        TNome.setText("");
        CAtivo.setSelected(false);
        edtCONS_ID1.setText("");
        edtCONS_ID2.setText("");
        edtCONS_NOME.setText("");
    }

    private void gravar() {
        if (JOptionPane.showConfirmDialog(null, "Confirma Gravação deste Forma de Pagamento ?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                FormaPagtoModel objusuario = new FormaPagtoModel();
                objusuario.setFPG_codigo(Integer.parseInt(TCodigo.getText()));
                objusuario.setFPG_nome(TNome.getText());
                objusuario.setFPG_ativo((CAtivo.isSelected() ? 1 : 0));

                FormaPagtoController usuariocontroller = new FormaPagtoController();
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
                FormaPagtoModel objusuario = new FormaPagtoModel();
                objusuario.setFPG_codigo(Integer.parseInt(TCodigo.getText()));
                objusuario.setFPG_nome(TNome.getText());
                objusuario.setFPG_ativo((CAtivo.isSelected() ? 1 : 0));

                FormaPagtoController formaoagtocontroller = new FormaPagtoController();
                formaoagtocontroller.excluir(objusuario);

                JOptionPane.showMessageDialog(null, "Registro Excluído com Sucesso");
                consultar();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro na Exclusão de Registro \n" + ex.getMessage());
            }
        }
    }

    private void consultar() {
        String condicao = filtroConsulta();
        FormaPagtoController FormaPagtoController = new FormaPagtoController();
        lista = null;
        lista = FormaPagtoController.consultar(condicao);
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não Existem Usuários Cadastrados !");
        } else {
            tabela = new FormaPagtoTabelaModel(lista, colunas);
            TAconsulta.setModel(tabela);
            TAconsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
    }

    private String filtroConsulta() {
        String condicao = "";
        if (!edtCONS_ID1.getText().trim().equals("")) {
            condicao += "(FPG_codigo >= " + edtCONS_ID1.getText() + ")";
        }
        if (!edtCONS_ID2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(FPG_codigo <= " + edtCONS_ID2.getText() + ")";
        }
        if (!edtCONS_NOME.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(FPG_nome LIKE ('%" + edtCONS_NOME.getText() + "%'))";
        }
        if (!condicao.isEmpty()) {
            condicao = " where " + condicao;
        }
        return condicao;
    }
    
    private void mostrar(FormaPagtoModel objModel) {
        TCodigo.setText(String.valueOf(objModel.getFPG_codigo()));
        TNome.setText(String.valueOf(objModel.getFPG_nome()));
        CAtivo.setSelected((objModel.getFPG_ativo() == 1));
    }

    private void Imprimir(java.awt.event.ActionEvent evt) {
        FormaPagtoController objController = new FormaPagtoController();
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
