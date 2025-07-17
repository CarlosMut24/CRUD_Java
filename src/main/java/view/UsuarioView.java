package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.UsuarioModel;
import java.util.ArrayList;
import controller.UsuarioController;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class UsuarioView extends JFrame {

    private JPanel formulario, consulta, botaoPanel;
    private JLabel LCodigo, LNome, LLogin, LSenha, LCadastro, LAtivo;
    private JTextField TCodigo, TNome, TLogin, TSenha;
    private JSpinner SCadastro;
    private SpinnerDateModel date;
    private JCheckBox CAtivo;
    private JTable TAconsulta;
    private JButton BPesquisar, BSalvar, BEditar, BExcluir, BLinpar, BImpimir;

    private String operacao;
    private JLabel A, ComCodigo, ComNome, ComLogin;
    private JTextField edtCONS_ID1, edtCONS_ID2, edtCONS_NOME, edtCONS_LOGIN;
    private ArrayList<UsuarioModel> lista;
    private String colunas[] = {"Código", "Nome", "Login", "Senha", "Cadastro", "Ativo"};
    private UsuarioTabelaModel tabela;
    private JScrollPane Scon;

    public UsuarioView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(625, 630)); // ajuste do tamanho e layout
        setLayout(null);
        setTitle("Usuario"); // título do frame
        CriarComponentes(); // instancia componentes (objetos Swing);
        AdicionarComponentes(); // adiciona componentes no frame
        ConfigurarPosicoes(); // configura as posices dos componentes;
        pack(); // reorganiza os componentes (objetos) no frame
        consultar();
        setVisible(true); // deixa o frame visível
        setOperacao("");
    }

    public void CriarComponentes() {
        formulario = new JPanel(new GridLayout(6, 2, 10, 10));
        formulario.setBorder(BorderFactory.createTitledBorder("Dados do Usuario"));

        LCodigo = new JLabel("Codigo:");
        TCodigo = new JTextField();
//        TCodigo.setText("0");

        LNome = new JLabel("Nome:");
        TNome = new JTextField();

        LLogin = new JLabel("Login:");
        TLogin = new JTextField();

        LSenha = new JLabel("Senha:");
        TSenha = new JTextField();

        LCadastro = new JLabel("Cadastro:");
        date = new SpinnerDateModel();
        SCadastro = new JSpinner(date);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(SCadastro, "yyyy-MM-dd");
        SCadastro.setEditor(editor);

//        LAtivo = new JLabel("Ativo:");
        CAtivo = new JCheckBox("Ativo?");

        consulta = new JPanel(null);
        consulta.setBorder(BorderFactory.createTitledBorder("Consulta de Usuario"));
        ComCodigo = new JLabel("Codigo:");
        edtCONS_ID1 = new JTextField();
        edtCONS_ID2 = new JTextField();
        ComLogin = new JLabel("Logim:");
        edtCONS_LOGIN = new JTextField();
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
        consulta.add(ComLogin);
        consulta.add(A);
        consulta.add(edtCONS_ID1);
        consulta.add(edtCONS_ID2);
        consulta.add(edtCONS_NOME);
        consulta.add(edtCONS_LOGIN);

        formulario.add(LCodigo);
        formulario.add(TCodigo);
        formulario.add(LNome);
        formulario.add(TNome);
        formulario.add(LLogin);
        formulario.add(TLogin);
        formulario.add(LSenha);
        formulario.add(TSenha);
        formulario.add(LCadastro);
        formulario.add(SCadastro);
//        formulario.add(LAtivo);
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
        formulario.setBounds(10, 10, 600, 225);

        consulta.setBounds(10, 240, 600, 300);
        ComCodigo.setBounds(5, 25, 100, 25);
        edtCONS_ID1.setBounds(50, 25, 100, 25);
        A.setBounds(160, 25, 100, 25);
        edtCONS_ID2.setBounds(180, 25, 100, 25);
        ComLogin.setBounds(290, 25, 100, 25);
        edtCONS_LOGIN.setBounds(330, 25, 150, 25);
        ComNome.setBounds(5, 55, 100, 25);
        edtCONS_NOME.setBounds(50, 55, 430, 25);
        BPesquisar.setBounds(490, 25, 100, 25);
        Scon.setBounds(5, 100, 590, 200);

        botaoPanel.setBounds(100, 545, 400, 150);
    }

    private void limparCampos() {
        TCodigo.setText("0");
        TNome.setText("");
        TLogin.setText("");
        TSenha.setText("");
        CAtivo.setSelected(false);
        edtCONS_ID1.setText("");
        edtCONS_ID2.setText("");
        edtCONS_NOME.setText("");
        edtCONS_LOGIN.setText("");
    }

    private void gravar() {
        if (JOptionPane.showConfirmDialog(null, "Confirma Gravação deste Usuário ?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                UsuarioModel objusuario = new UsuarioModel();
                if (operacao.equals("alterar")) {
                    objusuario.setUSU_CODIGO(Integer.parseInt(TCodigo.getText()));
                }
                objusuario.setUSU_NOME(TNome.getText());
                objusuario.setUSU_LOGIN(TLogin.getText());
                objusuario.setUSU_SENHA(TSenha.getText());
                objusuario.setUSU_cadrastro(date.getDate());
                objusuario.setUSU_ATIVO((CAtivo.isSelected() ? 1 : 0));

                UsuarioController usuariocontroller = new UsuarioController();
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
                UsuarioModel objusuario = new UsuarioModel();
                objusuario.setUSU_CODIGO(Integer.parseInt(TCodigo.getText()));
                objusuario.setUSU_NOME(TNome.getText());
                objusuario.setUSU_LOGIN(TLogin.getText());
                objusuario.setUSU_SENHA(TSenha.getText());
                objusuario.setUSU_cadrastro(date.getDate());
                objusuario.setUSU_ATIVO((CAtivo.isSelected() ? 1 : 0));

                UsuarioController usuariocontroller = new UsuarioController();
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
        UsuarioController usuariocontroller = new UsuarioController();
        lista = null;
        lista = usuariocontroller.consultar(condicao);
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não Existem Usuários Cadastrados !");
        } else {
            tabela = new UsuarioTabelaModel(lista, colunas);
            TAconsulta.setModel(tabela);
            TAconsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
    }

    private String filtroConsulta() {
        String condicao = "";
        if (!edtCONS_ID1.getText().trim().equals("")) {
            condicao += "(USU_CODIGO >= " + edtCONS_ID1.getText() + ")";
        }
        if (!edtCONS_ID2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(USU_CODIGO <= " + edtCONS_ID2.getText() + ")";
        }
        if (!edtCONS_NOME.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(USU_NOME LIKE ('%" + edtCONS_NOME.getText() + "%'))";
        }
        if (!edtCONS_LOGIN.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(USU_LOGIN ILIKE ('%" + edtCONS_LOGIN.getText() + "%'))";
        }
        if (!condicao.isEmpty()) {
            condicao = " where " + condicao;
        }
        return condicao;
    }

    private void Imprimir(java.awt.event.ActionEvent evt) {
        UsuarioController objController = new UsuarioController();
        Exception retorno = objController.imprimir();
        if (retorno != null) {
            JOptionPane.showMessageDialog(null, "Erro no Relatório de Usuários /n" + retorno.getMessage());
        }
    }
    
    private void mostrar(UsuarioModel objModel) {
        TCodigo.setText(String.valueOf(objModel.getUSU_CODIGO()));
        TNome.setText(String.valueOf(objModel.getUSU_NOME()));
        TLogin.setText(String.valueOf(objModel.getUSU_LOGIN()));
        TSenha.setText(String.valueOf(objModel.getUSU_SENHA()));
        CAtivo.setSelected((objModel.getUSU_ATIVO() == 1));
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

}
