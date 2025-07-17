/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.VendaModel;
import model.VendaPagtoModel;
import model.VendaProdutoModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author samsung
 */
public class VendaDao implements GenericDao<VendaModel> {

    @Override
    public void incluir(VendaModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(objModel);
        t.commit();
        session.close();
    }

    @Override
    public void alterar(VendaModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.createQuery("DELETE FROM " + VendaProdutoModel.class.getName() + " as c WHERE c.VDA_codigo.VDA_codigo = :usuarioId")
           .setParameter("usuarioId", objModel.getVDA_codigo())
           .executeUpdate();
        session.createQuery("DELETE FROM " + VendaPagtoModel.class.getName() + " as c WHERE c.VDA_codigo.VDA_codigo = :usuarioId")
           .setParameter("usuarioId", objModel.getVDA_codigo())
           .executeUpdate();
        session.update(objModel);
        t.commit();
        session.close();
    }

    @Override
    public ArrayList<VendaModel> consultar(String filtro) {
        String sql = "from " + VendaModel.class.getName() +" as c "+ filtro;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        ArrayList lista = (ArrayList<VendaModel>) session.createQuery(sql).list();
        t.commit();
        session.close();
        return lista;
    }

    @Override
    public void excluir(VendaModel objModel) throws Exception {
        
//        String sql = "delete from " + VendaProdutoModel.class.getName() + " as c where (c.VDA_codigo.VDA_codigo = "+ objModel.getVDA_codigo()+")" ;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
         session.createQuery("DELETE FROM " + VendaProdutoModel.class.getName() + " as c WHERE c.VDA_codigo.VDA_codigo = :usuarioId")
           .setParameter("usuarioId", objModel.getVDA_codigo())
           .executeUpdate();
         session.createQuery("DELETE FROM " + VendaPagtoModel.class.getName() + " as c WHERE c.VDA_codigo.VDA_codigo = :usuarioId")
           .setParameter("usuarioId", objModel.getVDA_codigo())
           .executeUpdate();
        VendaModel venda = session.get(VendaModel.class, objModel.getVDA_codigo());
            if (venda != null) {
                session.delete(venda);
                t.commit();
            }
        session.close();
    }

    @Override
    public VendaModel get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (VendaModel) session.load(VendaModel.class, id);
    }
}

