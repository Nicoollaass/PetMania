/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.venda.logica;

import br.com.petmania.dao.DAOVenda;
import br.com.petmania.model.VendaProdutos;
import br.com.senac.petmania.logica.Logica;
import br.com.senac.petmania.utils.Utils;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nicolas
 */
public class Pedido implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res, String method) throws Exception {
        
        String id_venda_old = req.getParameter("id_venda");
        
        
        if(
            id_venda_old != null &&
            !id_venda_old.equals("")
        ){
            Utils tools = new Utils();
            int id_venda = tools.parseStringInt(id_venda_old);
            
            DAOVenda daoVenda = new DAOVenda();
            
            List<VendaProdutos> vendas = daoVenda.getVendas(id_venda);
            req.setAttribute("vendas", vendas);
            req.setAttribute("codigo", vendas.get(0).getCodigo());
            req.setAttribute("total", vendas.get(0).getTotal());
            req.setAttribute("vendedor", vendas.get(0).getVendedor());
            req.setAttribute("cliente", vendas.get(0).getCliente());
        }
        return "view/pedido.jsp";
    }
    
}
