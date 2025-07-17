/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.VendaProdutoModel;

/**
 *
 * @author samsung
 */
public class VendaProdutoTabelaModel extends AbstractTableModel {
    
    private ArrayList<VendaProdutoModel> linhas;
     String[] colunas;
     
       public VendaProdutoTabelaModel(ArrayList<VendaProdutoModel> arrayusuario, String[] colunas) {
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
        VendaProdutoModel usuario = (VendaProdutoModel) linhas.get(row);
        switch (col) {
            case 0:
                return usuario.getPRO_codigo().getPRO_nome();
            case 1:
                return usuario.getVEP_qtde();
            case 2:
                return usuario.getVEP_preco();
             case 3:
                return usuario.getVEP_desconto();
            case 4:
                return usuario.getVEP_total();                
            default:
                return null;
        }
    }
}