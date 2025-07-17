/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.CompraProdutoModel;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author samsung
 */
public class CompraProdutoTabelaModel extends AbstractTableModel {
    private ArrayList<CompraProdutoModel> linhas;
     String[] colunas;
     
       public CompraProdutoTabelaModel(ArrayList<CompraProdutoModel> arrayusuario, String[] colunas) {
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
        CompraProdutoModel usuario = (CompraProdutoModel) linhas.get(row);
        switch (col) {
            case 0:
                return usuario.getPRO_codigo().getPRO_nome();
            case 1:
                return usuario.getCPP_qtde();
            case 2:
                return usuario.getCPP_preco();
             case 3:
                return usuario.getCPP_desconto();
            case 4:
                return (usuario.getCPP_qtde().multiply(usuario.getCPP_preco())).subtract(usuario.getCPP_desconto());                
            default:
                return null;
        }
    }
}
