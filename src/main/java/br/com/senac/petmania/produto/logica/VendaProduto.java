/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.produto.logica;

import br.com.senac.petmania.carrinho.logica.Carrinho;
import br.com.senac.petmania.carrinho.logica.Item;
import br.com.senac.petmania.logica.Logica;
import br.com.senac.petmania.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nicolas
 */
public class VendaProduto implements Logica {
   
    
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res, String method) throws Exception {
       
       //Criando um carrinho para a sessão do usuário
       HttpSession session = req.getSession(true);
       //se carrinho for igual a nulo cria outro carrinho senão regata da sessão
       Carrinho carrinho = (session.getAttribute("carrinho") !=  null)?(Carrinho)session.getAttribute("carrinho"):new Carrinho();
       session.setMaxInactiveInterval(1200);
       session.setAttribute("carrinho", carrinho);
       
           
       
       return "view/realizar-venda.jsp";
    }
    
}
