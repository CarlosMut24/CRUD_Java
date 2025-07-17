/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.FornecedorModel;
/**
 *
 * @author samsung
 */
public class FornecedorTabelaModel extends AbstractTableModel {
    
     private ArrayList<FornecedorModel> linhas;
     String[] colunas;
     
       public FornecedorTabelaModel(ArrayList<FornecedorModel> arrayfornecedor, String[] colunas) {
        this.colunas = colunas;
        linhas = arrayfornecedor;
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
        FornecedorModel fornecedor = (FornecedorModel) linhas.get(row);
        switch (col) {
            case 0:
                return fornecedor.getFOR_codigo();
            case 1:
                return fornecedor.getPES_codigo().getPES_codigo();
            case 2:
                return fornecedor.getFOR_contato(); 
            case 3:
                return fornecedor.getPES_codigo().getPES_nome();
            case 4:
                return fornecedor.getPES_codigo().getPES_CpfCnpj(); 
            case 5:
                return fornecedor.getPES_codigo().getPES_email();
            case 6:
                return fornecedor.getPES_codigo().getPES_cadrastro();
            case 7:
                return (fornecedor.getPES_codigo().getPES_ativo()== 1 ? "Sim" : "Não");              
            default:
                return null;
        }
    }
}
