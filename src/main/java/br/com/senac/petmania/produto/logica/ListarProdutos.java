/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.produto.logica;

import br.com.petmania.dao.DAOProduto;
import br.com.petmania.model.Produto;
import br.com.senac.petmania.logica.Logica;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hp
 */
public class ListarProdutos implements Logica{
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res, String method) throws Exception {
        
        //menssagens de erro ou sucesso da lógica de negócio de clientes
        String editar  = req.getParameter("editar");
        String salvar  = req.getParameter("salvar");
        String excluir  = req.getParameter("excluir");
        
        if(editar != null)
        {
            if(editar.equals("true"))
            {
                String sucessMsg = "Editado com sucesso";
                req.setAttribute("sucessMsg", sucessMsg);
            }
            else 
            {
                String erroMsg = "Erro ao editar o produto";
                req.setAttribute("erroMsg", erroMsg);
            }
        }
        else if(salvar != null) 
        {
            if(salvar.equals("true"))
            {
                String sucessMsg = "Salvo com sucesso";
                req.setAttribute("sucessMsg", sucessMsg);
            }
            else 
            {
                String erroMsg = "Erro ao salvar o produto";
                req.setAttribute("erroMsg", erroMsg);
            }
        }
        else if(excluir != null) 
        {
            if(excluir.equals("true"))
            {
                String sucessMsg = "Excluido com sucesso";
                req.setAttribute("sucessMsg", sucessMsg);
            }
            else 
            {
                String erroMsg = "Erro ao excluir o produto";
                req.setAttribute("erroMsg", erroMsg);
            }
        }
        
        DAOProduto dao = new DAOProduto();
        ArrayList<Produto> produtos =  (ArrayList<Produto>) dao.buscarProduto();
        req.setAttribute("produtos", produtos);
        
        return "view/listar-produtos.jsp";
    }
    
}
