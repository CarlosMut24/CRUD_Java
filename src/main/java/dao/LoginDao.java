/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.UsuarioModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author samsung
 */
public class LoginDao {

    public boolean consultar(String condicao1, String condicao2){
        String sql = "from " + UsuarioModel.class.getName() + " where USU_LOGIN = '"+ condicao1 + "' and USU_SENHA = '" +  condicao2 +"'";

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        ArrayList lista = (ArrayList<UsuarioModel>) session.createQuery(sql).list();
        boolean verivicasao = false;
        if (!lista.isEmpty())
            verivicasao = true;
        t.commit();
        session.close();
        return verivicasao;
    }
}
