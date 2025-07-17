/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.CompraModel;

public class CompraTabelaModel extends AbstractTableModel {
    
     private ArrayList<CompraModel> linhas;
     String[] colunas;
     
       public CompraTabelaModel(ArrayList<CompraModel> arraycliente, String[] colunas) {
        this.colunas = colunas;
        linhas = arraycliente;
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
        CompraModel compra = (CompraModel) linhas.get(row);
         switch (col) {
            case 0:
                return compra.getCPR_codigo();
            case 1:
                return compra.getCPR_valor();
            case 2:
                return compra.getCPR_desconto();
            case 3:
                return compra.getCPR_total();
            case 4:
                return compra.getUSU_codigo().getUSU_NOME();
            case 5:
                return compra.getFOR_codigo().getPES_codigo().getPES_nome();
            default:
                return null;
        }
    }
}
