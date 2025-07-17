/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CompraProdutoDao;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.CompraProdutoModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.ReportUtils;

/**
 *
 * @author samsung
 */
public class CompraProdutoController implements GenericController<CompraProdutoModel> {

    CompraProdutoDao compradao;

    public CompraProdutoController() {
        compradao = new CompraProdutoDao();
    }

    @Override
    public void incluir(CompraProdutoModel obj) throws Exception{
        compradao.incluir(obj);
    }

    @Override
    public void alterar(CompraProdutoModel obj) throws Exception{
        compradao.alterar(obj);
    }

    @Override
    public void excluir(CompraProdutoModel obj) throws Exception{
        compradao.excluir(obj);
    }

    @Override
    public ArrayList<CompraProdutoModel> consultar(String filtro) {
        return compradao.consultar(filtro);
    }

    @Override
    public void gravar(CompraProdutoModel obj, String operacao) throws Exception{
            incluir(obj);
    }

    @Override
    public Exception imprimir() {
        Exception retorno = null;
        InputStream inputStream = getClass().getResourceAsStream("/relatorios/RelatorioUsuario.jasper");
//        btnPRIMEIRO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/primeiro.png"))); // NOI18N

        Map parametros = new HashMap();
        
        List dados = consultar("");
        
        // criando o datasource com os dados criados
        JRDataSource ds = new JRBeanCollectionDataSource(dados);

        try {
            // passando o datasource para o método de criação e exibição do relatório
            ReportUtils.openReport("Usuários - Bean Collection Data Source", inputStream, parametros, ds);

        } catch (Exception ex) {
            retorno =  ex;
        }
        return retorno;
    }
}

