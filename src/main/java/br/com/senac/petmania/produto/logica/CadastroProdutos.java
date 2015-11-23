/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.produto.logica;

import br.com.petmania.dao.DAOCategoria;
import br.com.petmania.dao.DAOMarca;
import br.com.petmania.dao.DAOProduto;
import br.com.petmania.model.Categoria;
import br.com.petmania.model.Marca;
import br.com.petmania.model.Produto;
import br.com.senac.petmania.logica.Logica;
import br.com.senac.petmania.utils.Utils;

import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hp
 */
public class CadastroProdutos implements Logica {

    String nome = "";
    String descricao = "";
    String id_marca = "";
    String id_categoria = "";
    String preco = "";
    String data_entrada = "";
    
    String erroMsg = null;
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res, String method) throws Exception {
        
    //Passando titulo e descrição da página
        String titulo = "Cadastrar Produtos";
        String descricao = "Adicionar novos produtos";
        req.setAttribute("titulo", titulo);
        req.setAttribute("descricao", descricao);
        req.setAttribute("action", "/sistema?param=produto&acao=CadastroProdutos"); 
        
        
        //Categoria
        DAOCategoria cat = new DAOCategoria();
        ArrayList<Categoria> categoria = cat.buscarCategoria();
        req.setAttribute("categoria", categoria);
        
        //Marca
        DAOMarca marca = new DAOMarca();
        ArrayList<Marca> marc = marca.buscarMarca();
        req.setAttribute("marca", marc);
        
         if(method.equals("POST"))
         {
             
             this.nome = req.getParameter("nome");
             this.descricao = req.getParameter("descricao");
             this.id_categoria = req.getParameter("categoria");
             this.id_marca = req.getParameter("marca");
             this.preco = req.getParameter("preco");
             this.data_entrada = req.getParameter("data_entrada");
             
             if(this.nome != null &&
                this.descricao != null &&
                this.id_categoria != null &&
                this.preco != null &&
                this.data_entrada != null &&     
                !this.nome.equals("") &&
                !this.descricao.equals("")&&
                !this.preco.equals("") &&
                !this.data_entrada.equals("")     
                     
                )
             {
                Produto prod = new Produto();
                
                
                Utils utils = new Utils();
                Date data = utils.formatarData(this.data_entrada);

                
                prod.setNome(this.nome);
                prod.setDescricao(this.descricao);
                prod.setId_marca(Integer.parseInt(this.id_marca));
                prod.setId_categoria(Integer.parseInt(this.id_categoria));
                prod.setPreco(Double.parseDouble(this.preco));
                prod.setData_entrada((java.sql.Date) data);
                
                 DAOProduto dao = new DAOProduto();
                 
                 dao.inserirProduto(prod);
                 
                 res.sendRedirect("sistema?param=produto&acao=CadastroProdutos");
             }
             else
             {
                 this.erroMsg = "Todos os campos devem estar preenchidos";
                req.setAttribute("erroMsg", this.erroMsg);
             }
             
         }
        
    return "view/cadastro-produtos.jsp";
    }
    
}
