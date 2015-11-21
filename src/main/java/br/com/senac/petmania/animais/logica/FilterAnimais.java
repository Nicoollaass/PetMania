/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.animais.logica;

import br.com.petmania.dao.DAOAnimal;
import br.com.petmania.model.Animal;
import br.com.senac.petmania.logica.Logica;
import br.com.senac.petmania.utils.QueryFactory;
import com.google.gson.Gson;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Nicolas
 */
public class FilterAnimais implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res, String method) throws Exception {
        
        String[] racas = req.getParameterValues("racas");
        String[] tipos = req.getParameterValues("tipos");
        
        //gerando a query de inserção
        QueryFactory gera = new QueryFactory();
        gera.geraFilterQuery(racas, "ANIMAL.ID_RACA");
        gera.geraFilterQuery(tipos, "ANIMAL.ID_TIPO_ANIMAL");
        
        DAOAnimal daoAnimal = new DAOAnimal();
        ArrayList<Animal> animais = daoAnimal.buscarAnimal(gera);
        
        if(animais != null){
            Gson gson = new Gson();
            // convert java object to JSON format,
            // and returned as JSON formatted string
            String json = gson.toJson(animais);
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
