package view;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame {

    private JMenuItem UsuárioItem, ClienteItem, FornecedorItem, ProdutoItem, FormaItem, VendaItem, CompraItem;
    private JMenu CadastroMenu, MovimentoMenu, SairMenu;
    private JMenuBar Barra;

    public Menu() {
        setTitle(""); // título do frame
        setPreferredSize(new Dimension(500, 300)); // ajuste do tamanho e layout
        setLayout(null); // aqui a definicao para utilizacao de layout absoluto
        CriarComponentes(); // instancia componentes (objetos Swing);
        AdicionarComponentes(); // adiciona componentes no frame
        ConfigurarPosicoes(); // configura as posices dos componentes;
        pack(); // reorganiza os componentes (objetos) no frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); // deixa o frame visível
        setLocationRelativeTo(null);
        setJMenuBar(Barra);

    }

    public void CriarComponentes() {

        UsuárioItem = new JMenuItem("Usuário");
        UsuárioItem.setMnemonic('U');
        UsuárioItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent p) {
                UsuarioView novaTela = new UsuarioView();
                novaTela.setVisible(true);
            }
        });
        ClienteItem = new JMenuItem("Cliente");
        ClienteItem.setMnemonic('C');
        ClienteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent p) {
                ClienteView novaTela = new ClienteView();
                novaTela.setVisible(true);
            }
        });
        FornecedorItem = new JMenuItem("Fornecedor");
        FornecedorItem.setMnemonic('F');
        FornecedorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent p) {
                FornecedorView novaTela = new FornecedorView();
                novaTela.setVisible(true);
            }
        });
        ProdutoItem = new JMenuItem("Produto");
        ProdutoItem.setMnemonic('P');
        ProdutoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent p) {
                ProdutoView novaTela = new ProdutoView();
                novaTela.setVisible(true);
            }
        });
        FormaItem = new JMenuItem("Forma de Pagamento");
        FormaItem.setMnemonic('O');
        FormaItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent p) {
                FormaPagtoView novaTela = new FormaPagtoView();
                novaTela.setVisible(true);
            }
        });
        VendaItem = new JMenuItem("Venda");
        VendaItem.setMnemonic('V');
        VendaItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent p) {
                VendaView novaTela = new VendaView();
                novaTela.setVisible(true);
            }
        });
        CompraItem = new JMenuItem("Compra");
        CompraItem.setMnemonic('M');
        CompraItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent p) {
                CompraView novaTela = new CompraView();
                novaTela.setVisible(true);
            }
        });

        CadastroMenu = new JMenu("Cadastro");
        CadastroMenu.add(UsuárioItem);
        CadastroMenu.add(ClienteItem);
        CadastroMenu.add(FornecedorItem);
        CadastroMenu.add(ProdutoItem);
        CadastroMenu.add(FormaItem);

        MovimentoMenu = new JMenu("Movimento");
        MovimentoMenu.add(VendaItem);
        MovimentoMenu.add(CompraItem);

        
        SairMenu = new JMenu("Sair");
      JMenuItem SairMenuItem = new JMenuItem("Voltar para Login");
      SairMenu.add(SairMenuItem);
      SairMenuItem.addActionListener(new ActionListener() {
          @Override
      public void actionPerformed(ActionEvent p) {
        Login novaTela = new Login();
        novaTela.setVisible(true);
        dispose();
       }
     });

        Barra = new JMenuBar();
        Barra.add(CadastroMenu);
        Barra.add(MovimentoMenu);
        Barra.add(SairMenu); 
        SairMenu.add(SairMenuItem); 

   
      
}

    private void AdicionarComponentes() {
    }

    private void ConfigurarPosicoes() {
        
    }
    }
