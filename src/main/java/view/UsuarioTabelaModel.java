package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.UsuarioModel;

public class UsuarioTabelaModel extends AbstractTableModel {
    
     private ArrayList<UsuarioModel> linhas;
     String[] colunas;
     
       public UsuarioTabelaModel(ArrayList<UsuarioModel> arrayusuario, String[] colunas) {
        this.colunas = colunas;
        linhas = arrayusuario;
    }
       
     //Retorna a quantidade de colunas do modelo, que no caso será fixa
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    //Retorna a quantidade de linhas atual do objeto, que no caso é o tamnho da lista
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    //Retorna o nome da coluna, recebendo seu índice
    @Override
    public String getColumnName(int indiceColuna) {
        return colunas[indiceColuna];
    }
   
    @Override
    public Object getValueAt(int row, int col) {
        UsuarioModel usuario = (UsuarioModel) linhas.get(row);
        switch (col) {
            case 0:
                return usuario.getUSU_CODIGO();
            case 1:
                return usuario.getUSU_NOME();
            case 2:
                return usuario.getUSU_LOGIN();
            case 3:
                return usuario.getUSU_SENHA();
            case 4:
                return usuario.getUSU_cadrastro();    
            case 5:
                return (usuario.getUSU_ATIVO() == 1 ? "Sim" : "Não");                
            default:
                return null;
        }
    }
}
