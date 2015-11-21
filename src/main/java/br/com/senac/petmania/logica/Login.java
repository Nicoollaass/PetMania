/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.logica;


import br.com.petmania.dao.DAOUsuario;
import br.com.petmania.model.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nicolas
 */
public class Login implements Logica{
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res, String method) throws Exception {
        
        String user  = req.getParameter("loginUsuario");
        String pass  = req.getParameter("loginSenha");
        
        if(user != null && pass != null) {
            DAOUsuario daoLogin = new DAOUsuario();
            Usuario usuario = daoLogin.getUsuario(user, pass);
            if(usuario != null) {
                HttpSession session = req.getSession(); 
                session.setMaxInactiveInterval(2*60*60);  // two hours
                session.setAttribute("usuarioLogado",usuario);
                res.sendRedirect("sistema?acao=Home");
            }else {
                String erroMsg = "Usuário ou senha inválidos !";
                req.setAttribute("erroMsg", erroMsg);
            }
        }
        
        return "view/login.jsp";
    }
}
