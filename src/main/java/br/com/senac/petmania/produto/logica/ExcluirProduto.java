/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.produto.logica;

import br.com.petmania.dao.DAOProduto;
import br.com.petmania.model.Produto;
import br.com.senac.petmania.logica.Logica;
import br.com.senac.petmania.utils.Contantes;
import br.com.senac.petmania.utils.Utils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hp
 */
public class ExcluirProduto implements Logica
{
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res, String method) throws Exception {
        
        String identificador = req.getParameter("id");
        
        if(identificador != null)
        {
            Utils utils = new Utils();
            DAOProduto dao = new DAOProduto();
            
            int id = utils.parseStringInt(identificador);
            
            Contantes contante = new Contantes();
            dao.inativarProduto(contante, id);
            res.sendRedirect("sistema?param=produto&acao=ListarProdutos");
            
            
        }
        
        return "view/listar-produtos.jsp";
    }
     
}
