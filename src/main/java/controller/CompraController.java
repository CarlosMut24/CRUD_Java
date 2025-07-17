/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CompraDao;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.CompraModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.ReportUtils;

/**
 *
 * @author samsung
 */
public class CompraController implements GenericController<CompraModel> {

    CompraDao compradao;

    public CompraController() {
        compradao = new CompraDao();
    }

    @Override
    public void incluir(CompraModel obj) throws Exception{
        compradao.incluir(obj);
    }

    @Override
    public void alterar(CompraModel obj) throws Exception{
        compradao.alterar(obj);
    }

    @Override
    public void excluir(CompraModel obj) throws Exception{
        compradao.excluir(obj);
    }

    @Override
    public ArrayList<CompraModel> consultar(String filtro) {
        return compradao.consultar(filtro);
    }

    @Override
    public void gravar(CompraModel obj, String operacao) throws Exception{
        if (operacao.equals("incluir")) {
            incluir(obj);
        } else {
            alterar(obj);
        }
    }

    @Override
    public Exception imprimir() {
        Exception retorno = null;
        InputStream inputStream = getClass().getResourceAsStream("/relatorios/RelatorioCompra.jasper");
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
