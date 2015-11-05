/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.cadastros.logica;

import br.com.petmania.cadastros.dao.DAOCliente;
import br.com.petmania.cadastros.model.Cliente;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Nicolas
 */
public class ListarClientes implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        DAOCliente daoCliente = new  DAOCliente();
        ArrayList<Cliente> clientes = daoCliente.buscarCliente();
        req.setAttribute("clientes", clientes);
        return "view/listar-clientes.jsp";
    }
    
}
