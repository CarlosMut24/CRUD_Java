/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.ClienteModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author samsung
 */
public class ClienteDao implements GenericDao<ClienteModel> {

    @Override
    public void incluir(ClienteModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(objModel.getPES_codigo());
        session.save(objModel);
        t.commit();
        session.close();
    }

    @Override
    public void alterar(ClienteModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(objModel.getPES_codigo());
        session.update(objModel);
        t.commit();
        session.close();
    }

    @Override
    public ArrayList<ClienteModel> consultar(String filtro) {
        String sql = "from " + ClienteModel.class.getName() + " as c " + filtro;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        ArrayList lista = (ArrayList<ClienteModel>) session.createQuery(sql).list();
        t.commit();
        session.close();
        return lista;
    }

    @Override
    public void excluir(ClienteModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(objModel);
        session.delete(objModel.getPES_codigo());
        t.commit();
        session.close();
    }

    @Override
    public ClienteModel get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (ClienteModel) session.load(ClienteModel.class, id);
    }
}
