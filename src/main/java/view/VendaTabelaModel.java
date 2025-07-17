/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.VendaModel;


/**
 *
 * @author samsung
 */
public class VendaTabelaModel extends AbstractTableModel {

    private ArrayList<VendaModel> linhas;
    String[] colunas;

    public VendaTabelaModel(ArrayList<VendaModel> arraycompra, String[] colunas) {
        this.colunas = colunas;
        linhas = arraycompra;
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
        VendaModel compra = (VendaModel) linhas.get(row);
        switch (col) {
            case 0:
                return compra.getVDA_codigo();
            case 1:
                return compra.getVDA_valor();
            case 2:
                return compra.getVDA_desconto();
            case 3:
                return compra.getVDA_total();
            case 4:
                return compra.getUSU_codigo().getUSU_NOME();
            case 5:
                return compra.getCLI_codigo().getPES_codigo().getPES_nome();  
            default:
                return null;
        }
    }
}