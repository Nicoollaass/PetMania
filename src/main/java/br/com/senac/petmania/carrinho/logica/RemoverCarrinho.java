/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.carrinho.logica;

import br.com.senac.petmania.logica.Logica;
import br.com.senac.petmania.utils.Utils;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nicolas
 */
public class RemoverCarrinho implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res, String method) throws Exception {
        Utils tools = new Utils();
        
        //Resgatando as informações para popular o carriho
        String id_produto_before =  req.getParameter("id_prod_cart");
        
        if(id_produto_before != null){
            //resgatando a sessão
            HttpSession session = req.getSession(false);

            //Pegando objeto carrinho na sessão do usuário
            Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
            
            if(carrinho != null){
                
                int id_produto = 0;
                
                //Buscando o produto na base de dados
                id_produto = tools.parseStringInt(id_produto_before);
                
                carrinho.remove(id_produto);
                
                //setando carrinho na sessão
                session.setAttribute("carrinho", carrinho);

                Utils util = new Utils();
                String json = util.parseJson(carrinho);

                res.setContentType("application/json");
                res.setCharacterEncoding("UTF-8");
                // Get the printwriter object from response to write the required json object to the output stream      
                PrintWriter out = res.getWriter();
                // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
                out.print(json);
                out.flush();
                
            }
            
        }
        
        
        
       
        return "";
    }
    
}
