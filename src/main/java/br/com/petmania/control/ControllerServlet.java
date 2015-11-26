/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.control;

import br.com.petmania.dao.DAOUsuario;
import br.com.petmania.model.Usuario;
import br.com.senac.petmania.logica.AutenticaUsuario;
import br.com.senac.petmania.logica.Logica;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nicolas
 */
@WebServlet("/sistema")
public class ControllerServlet extends HttpServlet {
    
    /**
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
    * methods.
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String method)
        throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Usuario usuarioLogado = (Usuario)(session.getAttribute("usuarioLogado"));
        
        //Resgata os parametros da url
        String pagina = "/WEB-INF/";
        String param = request.getParameter("param");
        String acao = request.getParameter("acao");
        
        //verifica se usuario está logado no sistema ou se está acessando a pagina 
        //de login
        if(acao.equals("Login") || usuarioLogado != null){
            
            //Nome da lógica
            String nomeDaClasse = null; 
            
            //if param == null então chamamos o packge defaut da aplição
            if(param != null) {
                nomeDaClasse = "br.com.senac.petmania."+param+".logica."+acao;
            }else {
                nomeDaClasse = "br.com.senac.petmania.logica."+acao;
            }
            
            
            
            try {
                
                if(!acao.equals("Login")){
                    
                    AutenticaUsuario autentica = new AutenticaUsuario(usuarioLogado);
                
                    //Autentica acesso de páginas
                    if(!autentica.validaAcesso(acao)){
                        nomeDaClasse = "br.com.senac.petmania.logica.AcessoNegado";
                    }
                }
                
                
                
                Class<?> classe = Class.forName(nomeDaClasse);
                Logica logica = (Logica) classe.newInstance();

                // Recebe o String após a execução da lógica
                pagina += logica.executa(request, response, method);

                if (!response.isCommitted()){  
                    // Faz o forward para a página JSP
                    request.getRequestDispatcher(pagina).forward(request, response);
                }  
                return;  
            } catch (Exception e) {
                throw new ServletException(
                "A lógica de negócios causou uma exceção", e);
            }
        }else {
            //redireciona usuario para página de login
            response.sendRedirect("sistema?acao=Login");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response,"GET");
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet responsse
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response, "POST");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
