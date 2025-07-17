/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.LoginDao;

/**
 *
 * @author samsung
 */
public class LogimController {
    
    LoginDao logimdoa;
    
    public LogimController() {
        logimdoa = new LoginDao();
    }
    public boolean consultar(String condicao1, String condicao2) {
        return logimdoa.consultar(condicao1, condicao2);
    }
    
}
