/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.FornecedorModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author samsung
 */
public class FornecedorDao implements GenericDao<FornecedorModel> {

    @Override
    public void incluir(FornecedorModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(objModel.getPES_codigo());
        session.save(objModel);
        t.commit();
        session.close();
    }

    @Override
    public void alterar(FornecedorModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(objModel.getPES_codigo());
        session.update(objModel);
        t.commit();
        session.close();
    }

    @Override
    public ArrayList<FornecedorModel> consultar(String filtro) {
        String sql = "from " + FornecedorModel.class.getName() + " as c " + filtro;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        ArrayList lista = (ArrayList<FornecedorModel>) session.createQuery(sql).list();
        t.commit();
        session.close();
        return lista;
    }

    @Override
    public void excluir(FornecedorModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(objModel);
        session.delete(objModel.getPES_codigo());
        t.commit();
        session.close();
    }

    @Override
    public FornecedorModel get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (FornecedorModel) session.load(FornecedorModel.class, id);
    }
}
