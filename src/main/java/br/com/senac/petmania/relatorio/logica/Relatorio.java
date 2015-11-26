/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.relatorio.logica;

import br.com.petmania.dao.DAOFilial;
import br.com.senac.petmania.logica.Logica;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nicolas
 */
public class Relatorio implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res, String method) throws Exception {
         List<Object> filiais = new DAOFilial().getFiliais();
         req.setAttribute("filiais", filiais);
        return "view/relatorio.jsp";
    }
    
}
