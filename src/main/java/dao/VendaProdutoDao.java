/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.VendaProdutoModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author samsung
 */
public class VendaProdutoDao implements GenericDao<VendaProdutoModel> {

    @Override
    public void incluir(VendaProdutoModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(objModel);
        t.commit();
        session.close();
    }

    @Override
    public void alterar(VendaProdutoModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(objModel);
        t.commit();
        session.close();
    }

    @Override
    public ArrayList<VendaProdutoModel> consultar(String filtro) {
        String sql = "from " + VendaProdutoModel.class.getName() + " as c " + filtro;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        ArrayList lista = (ArrayList<VendaProdutoModel>) session.createQuery(sql).list();
        t.commit();
        session.close();
        return lista;
    }

    @Override
    public void excluir(VendaProdutoModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(objModel);
        t.commit();
        session.close();
    }

    @Override
    public VendaProdutoModel get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (VendaProdutoModel) session.load(VendaProdutoModel.class, id);
    }
}
