/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.VendaPagtoModel;

/**
 *
 * @author samsung
 */
public class VendaPagtoTabelaModel extends AbstractTableModel {
    
    private ArrayList<VendaPagtoModel> linhas;
     String[] colunas;
     
       public VendaPagtoTabelaModel(ArrayList<VendaPagtoModel> arrayusuario, String[] colunas) {
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
        VendaPagtoModel usuario = (VendaPagtoModel) linhas.get(row);
        switch (col) {
            case 0:
                return usuario.getFPG_codigo().getFPG_nome();
            case 1:
                return usuario.getVDP_valor();
            default:
                return null;
        }
    }
}
