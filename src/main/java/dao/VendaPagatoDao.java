/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.VendaPagtoModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author samsung
 */
public class VendaPagatoDao implements GenericDao<VendaPagtoModel> {

    @Override
    public void incluir(VendaPagtoModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(objModel);
        t.commit();
        session.close();
    }

    @Override
    public void alterar(VendaPagtoModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(objModel);
        t.commit();
        session.close();
    }

    @Override
    public ArrayList<VendaPagtoModel> consultar(String filtro) {
        String sql = "from " + VendaPagtoModel.class.getName() + " as c " + filtro;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        ArrayList lista = (ArrayList<VendaPagtoModel>) session.createQuery(sql).list();
        t.commit();
        session.close();
        return lista;
    }

    @Override
    public void excluir(VendaPagtoModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(objModel);
        t.commit();
        session.close();
    }

    @Override
    public VendaPagtoModel get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (VendaPagtoModel) session.load(VendaPagtoModel.class, id);
    }
}