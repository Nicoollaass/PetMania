/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.produto.logica;

import br.com.petmania.dao.DAOEstoque;
import br.com.petmania.dao.DAOProduto;
import br.com.petmania.model.EstoqueProduto;
import br.com.petmania.model.Produto;
import br.com.senac.petmania.logica.Logica;
import com.google.gson.Gson;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nicolas
 */
public class FilterProduto implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res, String method) throws Exception {
        //gerando a query de inserção
        //QueryFactory gera = new QueryFactory();
        //gera.geraFilterQuery(racas, "ANIMAL.ID_RACA");
        //gera.geraFilterQuery(tipos, "ANIMAL.ID_TIPO_ANIMAL");
        
        DAOEstoque daoEstoque = new  DAOEstoque();
        List<EstoqueProduto> estoque = daoEstoque.buscarProdutos();
        
        if(estoque != null){
            Gson gson = new Gson();
            // convert java object to JSON format,
            // and returned as JSON formatted string
            String json = gson.toJson(estoque);
            res.setContentType("application/json");
            res.setCharacterEncoding("UTF-8");
            // Get the printwriter object from response to write the required json object to the output stream      
            PrintWriter out = res.getWriter();
            // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
            out.print(json);
            out.flush();
        }
        return "";
    }
    
}
