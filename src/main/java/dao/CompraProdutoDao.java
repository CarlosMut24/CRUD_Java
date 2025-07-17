/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.CompraProdutoModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author samsung
 */
public class CompraProdutoDao implements GenericDao<CompraProdutoModel> {

    @Override
    public void incluir(CompraProdutoModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(objModel);
        t.commit();
        session.close();
    }

    @Override
    public void alterar(CompraProdutoModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(objModel);
        t.commit();
        session.close();
    }

    @Override
    public ArrayList<CompraProdutoModel> consultar(String filtro) {
        String sql = "from " + CompraProdutoModel.class.getName() + " as c " + filtro;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        ArrayList lista = (ArrayList<CompraProdutoModel>) session.createQuery(sql).list();
        t.commit();
        session.close();
        return lista;
    }

    @Override
    public void excluir(CompraProdutoModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(objModel);
        t.commit();
        session.close();
    }

    @Override
    public CompraProdutoModel get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (CompraProdutoModel) session.load(CompraProdutoModel.class, id);
    }
}
