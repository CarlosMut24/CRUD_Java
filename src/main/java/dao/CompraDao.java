/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.CompraModel;
import model.CompraProdutoModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author samsung
 */
public class CompraDao implements GenericDao<CompraModel> {

    @Override
    public void incluir(CompraModel objModel) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(objModel);
        t.commit();
        session.close();
    }

    @Override
    public void alterar(CompraModel objModel) throws Exception {
        String sql = "delete from " + CompraProdutoModel.class.getName() + " as c where (c.CPR_codigo.CPR_codigo = "+ objModel.getCPR_codigo()+")" ;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.createQuery("DELETE FROM " + CompraProdutoModel.class.getName() + " as c WHERE c.CPR_codigo.CPR_codigo = :usuarioId")
           .setParameter("usuarioId", objModel.getCPR_codigo())
           .executeUpdate();
        session.createQuery(sql);
        session.update(objModel);
        t.commit();
        session.close();
    }

    @Override
    public ArrayList<CompraModel> consultar(String filtro) {
        String sql = "from " + CompraModel.class.getName() + filtro;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        ArrayList lista = (ArrayList<CompraModel>) session.createQuery(sql).list();
        t.commit();
        session.close();
        return lista;
    }

    @Override
    public void excluir(CompraModel objModel) throws Exception {
        
//        String sql = "delete from " + CompraProdutoModel.class.getName() + " as c where (c.CPR_codigo.CPR_codigo = "+ objModel.getCPR_codigo()+")" ;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
         session.createQuery("DELETE FROM " + CompraProdutoModel.class.getName() + " as c WHERE c.CPR_codigo.CPR_codigo = :usuarioId")
           .setParameter("usuarioId", objModel.getCPR_codigo())
           .executeUpdate();
        CompraModel compra = session.get(CompraModel.class, objModel.getCPR_codigo());
            if (compra != null) {
                session.delete(compra);
                t.commit();
            }
        session.close();
    }

    @Override
    public CompraModel get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (CompraModel) session.load(CompraModel.class, id);
    }
}
