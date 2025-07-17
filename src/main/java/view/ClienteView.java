/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.ClienteModel;
import controller.ClienteController;
import java.math.BigDecimal;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.PessoaModel;

/**
 *
 * @author samsung
 */
public class ClienteView extends JFrame {

    private JPanel formulario, consulta, botaoPanel, f1, f2;
    private JLabel LCodigo, LNome, LFantasia, LFisoca, LCpfCnpj, LRgIe, LCadastro,
            LEndereco, LNumero, LComplemento, LBarro, LCidade, LUF, LCep, LFone1, LFone2,
            LCelular, LSite, LEmail, LLimite, LAtivo;
    private JTextField TCodigo, TNome, TFantasia, TCpfCnpj, TRgIe, TEndereco, TNumero,
            TComplemento, TBarro, TCidade, TUF, TCep, TFone1, TFone2,
            TCelular, TSite, TEmail, SLimite;
    private JSpinner SCadastro;
    private SpinnerDateModel date;
    private JCheckBox CAtivo, CFisoca;
    private JTable TAconsulta;
    private JButton BPesquisar, BSalvar, BEditar, BExcluir, BLinpar, BImpimir;

    private String operacao;
    private JLabel A, ComCodigo, ComNome, ComLogin;
    private JTextField edtCONS_ID1, edtCONS_ID2, edtCONS_NOME, edtCONS_LOGIN;
    private ArrayList<ClienteModel> lista;
    private String colunas[] = {"Código", "Pessoa", "Limite", "Nome", "CPF/Cnpj", "Email", "Cadastro", "Ativo"};
    private ClienteTabelaModel tabela;
    private JScrollPane Scon;

    private JLabel Lpessoa;
    private JTextField Tpessoa;

    public ClienteView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(625, 720)); // ajuste do tamanho e layout
        setLayout(null);
        setTitle("Cliente"); // título do frame
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
        formulario.setBorder(BorderFactory.createTitledBorder("Dados do Cliente"));

        f1 = new JPanel(new GridLayout(0, 2, 60, 8));;

        f2 = new JPanel(new GridLayout(0, 2, 50, 5));;

        LCodigo = new JLabel("Codigo:");
        TCodigo = new JTextField();

        Lpessoa = new JLabel("Pessoa:");;
        Tpessoa = new JTextField();;

        LNome = new JLabel("Nome:");
        TNome = new JTextField();

        LFantasia = new JLabel("Fantasia:");
        TFantasia = new JTextField();

        CFisoca = new JCheckBox("É pessoa fisica?");

        LCpfCnpj = new JLabel("CpfCnpj:");
        TCpfCnpj = new JTextField();

        LRgIe = new JLabel("RG/IE:");
        TRgIe = new JTextField();

        LCadastro = new JLabel("Cadastro:");
        date = new SpinnerDateModel();
        SCadastro = new JSpinner(date);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(SCadastro, "yyyy-MM-dd");
        SCadastro.setEditor(editor);

        LEndereco = new JLabel("Endereço:");
        TEndereco = new JTextField();

        LNumero = new JLabel("Numero:");
        TNumero = new JTextField();

        LComplemento = new JLabel("Complemento:");
        TComplemento = new JTextField();

        LBarro = new JLabel("Barro:");
        TBarro = new JTextField();

        LCidade = new JLabel("Cidade:");
        TCidade = new JTextField();

        LUF = new JLabel("UF:");
        TUF = new JTextField();

        LCep = new JLabel("Cep:");
        TCep = new JTextField();

        LFone1 = new JLabel("Fone 1:");
        TFone1 = new JTextField();

        LFone2 = new JLabel("Fone 2:");
        TFone2 = new JTextField();

        LCelular = new JLabel("Celular:");
        TCelular = new JTextField();

        LSite = new JLabel("Site:");
        TSite = new JTextField();

        LEmail = new JLabel("Email:");
        TEmail = new JTextField();

        LLimite = new JLabel("Limite:");
        SLimite = new JTextField();

        CAtivo = new JCheckBox("Ativo?");

        consulta = new JPanel(null);
        consulta.setBorder(BorderFactory.createTitledBorder("Consulta de Cliente"));
        ComCodigo = new JLabel("Codigo:");
        edtCONS_ID1 = new JTextField();
        edtCONS_ID2 = new JTextField();
        ComLogin = new JLabel("CPF/CNPJ:");
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

        f1.add(LCodigo);
        f1.add(TCodigo);

        f1.add(Lpessoa);
        f1.add(Tpessoa);

        f1.add(LNome);
        f1.add(TNome);

        f1.add(LFantasia);
        f1.add(TFantasia);

        f1.add(LCpfCnpj);
        f1.add(TCpfCnpj);

        f1.add(LRgIe);
        f1.add(TRgIe);

        f1.add(LCadastro);
        f1.add(SCadastro);

        f2.add(LEndereco);
        f2.add(TEndereco);

        f2.add(LNumero);
        f2.add(TNumero);

        f2.add(LComplemento);
        f2.add(TComplemento);

        f2.add(LBarro);
        f2.add(TBarro);

        f2.add(LCidade);
        f2.add(TCidade);

        f2.add(LUF);
        f2.add(TUF);

        f2.add(LCep);
        f2.add(TCep);

        f2.add(LFone1);
        f2.add(TFone1);

        f2.add(LFone2);
        f2.add(TFone2);

        f2.add(LCelular);
        f2.add(TCelular);

        f1.add(LSite);
        f1.add(TSite);

        f1.add(LEmail);
        f1.add(TEmail);

        f1.add(LLimite);
        f1.add(SLimite);

        f1.add(CAtivo);

        f2.add(CFisoca);

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
        formulario.setBounds(10, 0, 600, 350);
        f1.setBounds(10, 15, 250, 330);
        f2.setBounds(290, 15, 300, 330);

        consulta.setBounds(10, 350, 600, 300);
        ComCodigo.setBounds(5, 25, 100, 25);
        edtCONS_ID1.setBounds(50, 25, 100, 25);
        A.setBounds(160, 25, 100, 25);
        edtCONS_ID2.setBounds(180, 25, 100, 25);
        ComLogin.setBounds(290, 25, 100, 25);
        edtCONS_LOGIN.setBounds(355, 25, 235, 25);
        ComNome.setBounds(5, 55, 100, 25);
        edtCONS_NOME.setBounds(50, 55, 430, 25);
        BPesquisar.setBounds(490, 55, 100, 25);
        Scon.setBounds(5, 100, 590, 200);

        botaoPanel.setBounds(100, 645, 400, 150);
    }

    private void limparCampos() {
        TCodigo.setText("0");
        Tpessoa.setText("0");
        TNome.setText("");
        TFantasia.setText("");
        CFisoca.setText("");
        TCpfCnpj.setText("");
        TRgIe.setText("");
        TEndereco.setText("");
        TNumero.setText("");
        TComplemento.setText("");
        TBarro.setText("");
        TCidade.setText("");
        TUF.setText("");
        TCep.setText("");
        TFone1.setText("");
        TFone2.setText("");
        TCelular.setText("");
        TSite.setText("");
        TEmail.setText("");
        CAtivo.setText("");
        edtCONS_ID1.setText("0");
        edtCONS_ID2.setText("0");
        edtCONS_NOME.setText("0");
        edtCONS_LOGIN.setText("0");
    }

    private void gravar() {
        if (JOptionPane.showConfirmDialog(null, "Confirma Gravação deste Cliente ?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                ClienteModel objusuario = new ClienteModel();
                PessoaModel objpessoa = new PessoaModel();
                objusuario.setCLI_codigo(Integer.parseInt(TCodigo.getText()));
                objusuario.setPES_codigo(objpessoa);
                objusuario.getPES_codigo().setPES_codigo(Integer.parseInt(Tpessoa.getText()));
                objusuario.getPES_codigo().setPES_nome(TNome.getText());
                objusuario.getPES_codigo().setPES_fantasia(TFantasia.getText());
                objusuario.getPES_codigo().setPES_fisica((CFisoca.isSelected() ? 1 : 0));
                objusuario.getPES_codigo().setPES_CpfCnpj(TCpfCnpj.getText());
                objusuario.getPES_codigo().setPES_rgie(TRgIe.getText());
                objusuario.getPES_codigo().setPES_cadrastro(date.getDate());
                objusuario.getPES_codigo().setPES_endereco(TEndereco.getText());
                objusuario.getPES_codigo().setPES_numero(TNumero.getText());
                objusuario.getPES_codigo().setPES_complemento(TComplemento.getText());
                objusuario.getPES_codigo().setPES_bairro(TBarro.getText());
                objusuario.getPES_codigo().setPES_cidade(TCidade.getText());
                objusuario.getPES_codigo().setPES_uf(TUF.getText());
                objusuario.getPES_codigo().setPES_cep(TCep.getText());
                objusuario.getPES_codigo().setPES_fone1(TFone1.getText());
                objusuario.getPES_codigo().setPES_fone2(TFone2.getText());
                objusuario.getPES_codigo().setPES_celular(TCelular.getText());
                objusuario.getPES_codigo().setPES_site(TSite.getText());
                objusuario.getPES_codigo().setPES_email(TEmail.getText());
                objusuario.setCLI_LimiteCred(new BigDecimal(SLimite.getText()));
                objusuario.getPES_codigo().setPES_ativo((CAtivo.isSelected() ? 1 : 0));

                ClienteController usuariocontroller = new ClienteController();
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
                ClienteModel objusuario = new ClienteModel();
                PessoaModel objpessoa = new PessoaModel();
                objusuario.setCLI_codigo(Integer.parseInt(TCodigo.getText()));
                objusuario.setPES_codigo(objpessoa);
                objusuario.getPES_codigo().setPES_codigo(Integer.parseInt(Tpessoa.getText()));
                objusuario.getPES_codigo().setPES_nome(TNome.getText());
                objusuario.getPES_codigo().setPES_fisica((CFisoca.isSelected() ? 1 : 0));
                objusuario.getPES_codigo().setPES_CpfCnpj(TCpfCnpj.getText());

                ClienteController usuariocontroller = new ClienteController();
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
        ClienteController usuariocontroller = new ClienteController();
        lista = null;
        lista = usuariocontroller.consultar(condicao);
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não Existem Usuários Cadastrados !");
        } else {
            tabela = new ClienteTabelaModel(lista, colunas);
            TAconsulta.setModel(tabela);
            TAconsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
    }

    private String filtroConsulta() {
        String condicao = "";
        if (!edtCONS_ID1.getText().trim().equals("")) {
            condicao += "(CLI_codigo >= " + edtCONS_ID1.getText() + ")";
        }
        if (!edtCONS_ID2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(CLI_codigo <= " + edtCONS_ID2.getText() + ")";
        }
        if (!edtCONS_NOME.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(c.PES_codigo.PES_nome LIKE ('%" + edtCONS_NOME.getText() + "%'))";
        }
        if (!edtCONS_LOGIN.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(c.PES_codigo.PES_CpfCnpj LIKE ('%" + edtCONS_LOGIN.getText() + "%'))";
        }
        if (!condicao.isEmpty()) {
            condicao = " where " + condicao;
        }
        return condicao;
    }
    
    private void mostrar(ClienteModel objModel) {
        TCodigo.setText(String.valueOf(objModel.getCLI_codigo()));
        Tpessoa.setText(String.valueOf(objModel.getPES_codigo().getPES_codigo()));
        TNome.setText(String.valueOf(objModel.getPES_codigo().getPES_nome()));
        TFantasia.setText(String.valueOf(objModel.getPES_codigo().getPES_fantasia()));
        TCpfCnpj.setText(String.valueOf(objModel.getPES_codigo().getPES_CpfCnpj()));
        TRgIe.setText(String.valueOf(objModel.getPES_codigo().getPES_rgie()));
        TEndereco.setText(objModel.getPES_codigo().getPES_endereco());
        TNumero.setText(objModel.getPES_codigo().getPES_numero());
        TComplemento.setText(objModel.getPES_codigo().getPES_complemento());
        TBarro.setText(objModel.getPES_codigo().getPES_bairro());
        TCidade.setText(String.valueOf(objModel.getPES_codigo().getPES_cidade()));
        TUF.setText(String.valueOf(objModel.getPES_codigo().getPES_uf()));
        TCep.setText(String.valueOf(objModel.getPES_codigo().getPES_cep()));
        TFone1.setText(String.valueOf(objModel.getPES_codigo().getPES_fone1()));
        TFone2.setText(String.valueOf(objModel.getPES_codigo().getPES_fone2()));
        TCelular.setText(String.valueOf(objModel.getPES_codigo().getPES_celular()));
        TSite.setText(String.valueOf(objModel.getPES_codigo().getPES_site()));
        TEmail.setText(String.valueOf(objModel.getPES_codigo().getPES_email()));
        SLimite.setText(String.valueOf(objModel.getCLI_LimiteCred()));
        CFisoca.setSelected((objModel.getPES_codigo().getPES_fisica()== 1));
        CAtivo.setSelected((objModel.getPES_codigo().getPES_ativo() == 1));
    }

    private void Imprimir(java.awt.event.ActionEvent evt) {
        ClienteController objController = new ClienteController();
        Exception retorno = objController.imprimir();
        if (retorno != null) {
            JOptionPane.showMessageDialog(null, "Erro no Relatório de Cliente /n" + retorno.getMessage());
        }
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }
}
