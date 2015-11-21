/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.produto.logica;

import br.com.senac.petmania.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hp
 */
public class CadastroProdutos implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res, String method) throws Exception {
        
    //Passando titulo e descrição da página
        String titulo = "Cadastrar Produtos";
        String descricao = "Adicionar novos produtos";
        req.setAttribute("titulo", titulo);
        req.setAttribute("descricao", descricao);
        req.setAttribute("action", "/sistema?param=produto&acao=CadastroProdutos"); 
        
        
    return "view/cadastro-produtos.jsp";
    }
    
}
