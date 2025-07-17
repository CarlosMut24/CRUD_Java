/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ClienteDao;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.ClienteModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.ReportUtils;

/**
 *
 * @author samsung
 */
public class ClienteController implements GenericController<ClienteModel> {

    ClienteDao clientedao;

    public ClienteController() {
        clientedao = new ClienteDao();
    }

    @Override
    public void incluir(ClienteModel obj) throws Exception{
        clientedao.incluir(obj);
    }

    @Override
    public void alterar(ClienteModel obj) throws Exception{
        clientedao.alterar(obj);
    }

    @Override
    public void excluir(ClienteModel obj) throws Exception{
        clientedao.excluir(obj);
    }

    @Override
    public ArrayList<ClienteModel> consultar(String filtro) {
        return clientedao.consultar(filtro);
    }

    @Override
    public void gravar(ClienteModel obj, String operacao) throws Exception{
        if (operacao.equals("incluir")) {
            incluir(obj);
        } else {
            alterar(obj);
        }
    }

    @Override
    public Exception imprimir() {
        Exception retorno = null;
        InputStream inputStream = getClass().getResourceAsStream("/relatorios/RelatorioCliente.jasper");
//        btnPRIMEIRO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/primeiro.png"))); // NOI18N

        Map parametros = new HashMap();
        
        List dados = consultar("");
        
        // criando o datasource com os dados criados
        JRDataSource ds = new JRBeanCollectionDataSource(dados);

        try {
            // passando o datasource para o método de criação e exibição do relatório
            ReportUtils.openReport("Cliente - Bean Collection Data Source", inputStream, parametros, ds);

        } catch (Exception ex) {
            retorno =  ex;
        }
        return retorno;
    }
}
