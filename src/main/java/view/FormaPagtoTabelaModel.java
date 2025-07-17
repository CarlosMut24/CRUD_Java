/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.FormaPagtoModel;

public class FormaPagtoTabelaModel extends AbstractTableModel {

    private ArrayList<FormaPagtoModel> linhas;
    String[] colunas;

    public FormaPagtoTabelaModel(ArrayList<FormaPagtoModel> arrayusuario, String[] colunas) {
        this.colunas = colunas;
        linhas = arrayusuario;
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    //Retorna a quantidade de linhas atual do objeto, que no caso é o tamnho da lista
    @Override
    public int getRowCount() {
        return linhas.size();
    }
    
    @Override
    public String getColumnName(int indiceColuna) {
        return colunas[indiceColuna];
    }
    
    @Override
    public Object getValueAt(int row, int col) {
        FormaPagtoModel FormaPagto = (FormaPagtoModel) linhas.get(row);
        switch (col) {
            case 0:
                return FormaPagto.getFPG_codigo();
            case 1:
                return FormaPagto.getFPG_nome();
            case 2:
                return (FormaPagto.getFPG_ativo()== 1 ? "Sim" : "Não");                        
            default:
                return null;
        }
    }
}
