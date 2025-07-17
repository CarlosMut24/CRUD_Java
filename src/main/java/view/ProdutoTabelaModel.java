/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.ProdutoModel;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ProdutoTabelaModel extends AbstractTableModel {

    private ArrayList<ProdutoModel> linhas;
    String[] colunas;

    public ProdutoTabelaModel(ArrayList<ProdutoModel> arrayproduto, String[] colunas) {
        this.colunas = colunas;
        linhas = arrayproduto;
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
//        private String colunas[] = {"Código", "Nome", "Estoque", "Unidade", "Preço", "Cadastro", "OBS", "Ativo"};
    public Object getValueAt(int row, int col) {
        ProdutoModel produto = (ProdutoModel) linhas.get(row);
        switch (col) {
            case 0:
                return produto.getPRO_codigo();
            case 1:
                return produto.getPRO_nome();
            case 2:
                return produto.getPRO_estoque();
            case 3:
                return produto.getPRO_unidade();
            case 4:
                return produto.getPRO_preco();
            case 5:
                return produto.getPRO_cadastro();
            case 6:
                return produto.getPRO_OBS();
            case 7:
                return (produto.getPRO_ativo() == 1 ? "Sim" : "Não");
            default:
                return null;
        }
    }
}
