package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import controller.LogimController;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Login extends JFrame {

    private JLabel lblTitulo, lblSenha, lblLogin;
    private JTextField edtLogin;
    private JPasswordField edtSenha;
    private JButton bEntrar;
    private JPanel MyFrame;
    
    LogimController logimcontroller = new LogimController();

    ImageIcon image = new ImageIcon("");

    public Login() {
        setTitle("Login"); // título do frame
        setPreferredSize(new Dimension(500, 300)); // ajuste do tamanho e layout
        setLayout(null); // aqui a definicao para utilizacao de layout absoluto
        CriarComponentes(); // instancia componentes (objetos Swing);
        AdicionarComponentes(); // adiciona componentes no frame
        ConfigurarPosicoes(); // configura as posices dos componentes;
        //ConfigurarComponente(); / configura aos componentes;
        pack(); // reorganiza os componentes (objetos) no frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); // deixa o frame visível
        setLocationRelativeTo(null);
        setResizable(false);

    }

    public void CriarComponentes() {
        lblTitulo = new JLabel("Login");
        lblTitulo.setFont(new Font("Arial", Font.PLAIN, 18));
        lblTitulo.setForeground(Color.WHITE);

        lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Arial", Font.PLAIN, 18));
        lblSenha.setForeground(Color.WHITE);

        edtSenha = new JPasswordField();

        lblLogin = new JLabel("Login:");
        lblLogin.setFont(new Font("Arial", Font.PLAIN, 18));
        lblLogin.setForeground(Color.WHITE);

        edtLogin = new JTextField();

        bEntrar = new JButton("ENTRAR");
        bEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (logimcontroller.consultar(edtLogin.getText(), edtSenha.getText())) {

                    Menu novaTela = new Menu();
                    novaTela.setVisible(true);
                    dispose();
                }
            }
        });

        MyFrame = new JPanel();
        MyFrame.setBackground(Color.BLACK);

    }

    public void AdicionarComponentes() {
        add(lblTitulo);
        add(lblSenha);
        add(lblLogin);
        add(edtSenha);
        add(edtLogin);
        add(bEntrar);
        add(MyFrame);
    }

    private void ConfigurarPosicoes() {
        // Setbounds( posicao x, posicao y, largura, algura )
        lblTitulo.setBounds(210, 40, 100, 25);
        lblSenha.setBounds(26, 130, 100, 25);
        lblLogin.setBounds(35, 95, 100, 25);
        edtSenha.setBounds(85, 130, 330, 30);
        edtLogin.setBounds(85, 90, 330, 30);
        bEntrar.setBounds(190, 175, 100, 25);
        MyFrame.setBounds(0, 0, 600, 300);
    }

}
