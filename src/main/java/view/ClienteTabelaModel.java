/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.ClienteModel;

/**
 *
 * @author samsung
 */
public class ClienteTabelaModel extends AbstractTableModel {
    
     private ArrayList<ClienteModel> linhas;
     String[] colunas;
     
       public ClienteTabelaModel(ArrayList<ClienteModel> arraycliente, String[] colunas) {
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
        ClienteModel cliente = (ClienteModel) linhas.get(row);
        switch (col) {
            case 0:
                return cliente.getCLI_codigo();
            case 1:
                return cliente.getPES_codigo().getPES_codigo();
            case 2:
                return cliente.getCLI_LimiteCred(); 
            case 3:
                return cliente.getPES_codigo().getPES_nome();
            case 4:
                return cliente.getPES_codigo().getPES_CpfCnpj(); 
            case 5:
                return cliente.getPES_codigo().getPES_email();
            case 6:
                return cliente.getPES_codigo().getPES_cadrastro();
            case 7:
                return (cliente.getPES_codigo().getPES_ativo()== 1 ? "Sim" : "Não");              
            default:
                return null;
        }
    }
}