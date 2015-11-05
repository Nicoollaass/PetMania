/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.cadastros.logica;

import br.com.petmania.cadastros.dao.DAOCliente;
import br.com.petmania.cadastros.model.Cliente;
import br.com.senac.petmania.cadastros.utils.Contantes;
import br.com.senac.petmania.cadastros.utils.Utils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nicolas
 */
public class ExcluirCliente implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res, String method) throws Exception {
            
            String identificador = req.getParameter("id");
            if(identificador != null){
                Utils utils = new Utils();
                DAOCliente dao = new DAOCliente();
                int id = utils.parseStringInt(identificador);
                Contantes contante = new Contantes();
                dao.inativarCliente(contante,id);
            }
            
            return "view/listar-clientes.jsp";
    }
    
}
