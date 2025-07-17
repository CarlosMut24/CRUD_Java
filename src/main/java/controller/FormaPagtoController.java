/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.FormaPagtoDao;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FormaPagtoModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.ReportUtils;

/**
 *
 * @author samsung
 */
public class FormaPagtoController implements GenericController<FormaPagtoModel> {

    FormaPagtoDao formapagtodao;

    public FormaPagtoController() {
        formapagtodao = new FormaPagtoDao();
    }

    @Override
    public void incluir(FormaPagtoModel obj) throws Exception {
        formapagtodao.incluir(obj);
    }

    @Override
    public void alterar(FormaPagtoModel obj) throws Exception {
        formapagtodao.alterar(obj);
    }

    @Override
    public void excluir(FormaPagtoModel obj) throws Exception {
        formapagtodao.excluir(obj);
    }

    @Override
    public ArrayList<FormaPagtoModel> consultar(String filtro) {
        return formapagtodao.consultar(filtro);
    }

    @Override
    public void gravar(FormaPagtoModel obj, String operacao) throws Exception {
        if (operacao.equals("incluir")) {
            incluir(obj);
        } else {
            alterar(obj);
        }
    }

    public FormaPagtoModel get(long id) {
        return formapagtodao.get(id);
    }

    @Override
    public Exception imprimir() {
        Exception retorno = null;
        InputStream inputStream = getClass().getResourceAsStream("/relatorios/RelatorioFormaPagto.jasper");
//        btnPRIMEIRO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/primeiro.png"))); // NOI18N

        Map parametros = new HashMap();

        List dados = consultar("");

        // criando o datasource com os dados criados
        JRDataSource ds = new JRBeanCollectionDataSource(dados);

        try {
            // passando o datasource para o método de criação e exibição do relatório
            ReportUtils.openReport("Usuários - Bean Collection Data Source", inputStream, parametros, ds);

        } catch (Exception ex) {
            retorno = ex;
        }
        return retorno;
    }
}
