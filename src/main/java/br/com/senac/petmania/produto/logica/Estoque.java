/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.produto.logica;

import br.com.petmania.dao.DAOEstoque;
import br.com.petmania.model.Produto;
import br.com.senac.petmania.carrinho.logica.Carrinho;
import br.com.senac.petmania.carrinho.logica.Item;
import br.com.senac.petmania.logica.Logica;
import br.com.senac.petmania.utils.Utils;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nicolas
 */
public class Estoque implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res, String method) throws Exception {
        
        
        //resgatando a sessão
        HttpSession session = req.getSession(false);
        boolean checkProd = true;
        Produto produto = null;
        try {
            //Pegando objeto carrinho na sessão do usuário
            Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
            produto = this.isProduto(carrinho,produto);
        }catch (Exception e) {
           System.out.println("Erro ao buscar carrinho na sessão");
        }
        
        
        Utils util = new Utils();
        String json = util.parseJson(produto);

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        // Get the printwriter object from response to write the required json object to the output stream      

        PrintWriter out = res.getWriter();
        // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
        out.print(json);
        out.flush();
        return "";
    }
    
    public Produto isProduto(Carrinho carrinho,Produto produto) throws SQLException, ClassNotFoundException{
        DAOEstoque estoque = new DAOEstoque();
        List<Item> itens = carrinho.getItens();
        for (Item item:itens) {
            Produto prod = item.getProduto();
            produto = estoque.isProduto(prod.getId_produto(), item.getQuantidade());
            if(produto != null) {
                break;
            }
        }
        return produto;
    }
    
}
