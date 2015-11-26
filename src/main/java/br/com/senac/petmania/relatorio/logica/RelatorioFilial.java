/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.relatorio.logica;

import br.com.petmania.dao.DAORelatorio;
import br.com.senac.petmania.logica.Logica;
import br.com.senac.petmania.utils.Utils;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nicolas
 */
public class RelatorioFilial implements  Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res, String method) throws Exception {
        DAORelatorio relatorio = new DAORelatorio();
        List<Object> relatorioFiliais =  relatorio.filial();
        
        Utils util = new Utils();
        String json = util.parseJson(relatorioFiliais);

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        // Get the printwriter object from response to write the required json object to the output stream      
        
        PrintWriter out = res.getWriter();
        // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
        out.print(json);
        out.flush();
        
        return "";
    }
    
}
