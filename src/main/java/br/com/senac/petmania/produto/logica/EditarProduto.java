/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.produto.logica;

import br.com.petmania.dao.DAOCliente;
import br.com.petmania.dao.DAOProduto;
import br.com.petmania.model.Produto;
import br.com.senac.petmania.logica.Logica;
import br.com.senac.petmania.utils.Contantes;
import br.com.senac.petmania.utils.Utils;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hp
 */
public class EditarProduto implements Logica 
{
    
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
        String titulo = "Editar Produto";
        String descricao = "Editar produto";
        req.setAttribute("titulo", titulo);
        req.setAttribute("descricao", descricao);
        req.setAttribute("action", "/sistema?acao=EditarProduto");

        DAOProduto dao = new DAOProduto();
        Utils utils = new Utils();
        
        if (method.equals("POST")) 
        {
            this.nome = req.getParameter("nome");
            this.descricao = req.getParameter("descricao");
            this.id_categoria = req.getParameter("categoria");
            this.id_marca = req.getParameter("marca");
            this.preco = req.getParameter("preco");
            this.data_entrada = req.getParameter("data_entrada");
            
            if(!this.nome.equals("") &&
                !this.descricao.equals("")&&
                !this.preco.equals("") &&
                !this.data_entrada.equals("")
            )
                
            {
                
                Produto prod = new Produto();
                
                Date data = utils.formatarData(this.data_entrada);

                prod.setNome(this.nome);
                prod.setDescricao(this.descricao);
                prod.setId_marca(Integer.parseInt(this.id_marca));
                prod.setId_categoria(Integer.parseInt(this.id_categoria));
                prod.setPreco(Double.parseDouble(this.preco));
                prod.setData_entrada((java.sql.Date) data);
                
                dao.alterarProduto(prod);
                res.sendRedirect("sistema?acao=Listarprodutos&editar=true");
                
            }
            
            else 
            {
                this.erroMsg = "Todos os campos devem estar preenchidos";
                req.setAttribute("erroMsg", this.erroMsg);
            }
        
        }
        
        /*======== Method 'GET' =========*/
        else 
        {
            String identificador = req.getParameter("id");
            if(identificador != null)
            {
                int id = utils.parseStringInt(identificador);
                Produto produto = dao.getProduto(id);
                req.setAttribute("cliente", produto);
            }
        }
        
        return "view/listar-produtos.jsp";
    }
    
}
