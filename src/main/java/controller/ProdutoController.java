/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ProdutoDao;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.ProdutoModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.ReportUtils;

/**
 *
 * @author samsung
 */
public class ProdutoController implements GenericController<ProdutoModel> {

    ProdutoDao usuariodao;

    public ProdutoController() {
        usuariodao = new ProdutoDao();
    }

    @Override
    public void incluir(ProdutoModel obj) throws Exception{
        usuariodao.incluir(obj);
    }

    @Override
    public void alterar(ProdutoModel obj) throws Exception{
        usuariodao.alterar(obj);
    }

    @Override
    public void excluir(ProdutoModel obj) throws Exception{
        usuariodao.excluir(obj);
    }

    @Override
    public ArrayList<ProdutoModel> consultar(String filtro) {
        return usuariodao.consultar(filtro);
    }

    @Override
    public void gravar(ProdutoModel obj, String operacao) throws Exception{
        if (operacao.equals("incluir")) {
            incluir(obj);
        } else {
            alterar(obj);
        }
    }
    
    public ProdutoModel get(long id) {
        return usuariodao.get(id);
    }

    @Override
    public Exception imprimir() {
        Exception retorno = null;
        InputStream inputStream = getClass().getResourceAsStream("/relatorios/RelatorioProduto.jasper");
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
