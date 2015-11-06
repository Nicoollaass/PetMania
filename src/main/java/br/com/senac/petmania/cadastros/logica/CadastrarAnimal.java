/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.cadastros.logica;

import br.com.petmania.cadastros.dao.DAOCliente;
import br.com.petmania.cadastros.dao.DAOPorte;
import br.com.petmania.cadastros.dao.DAORaca;
import br.com.petmania.cadastros.dao.DAOTipoAnimal;
import br.com.petmania.cadastros.model.Cliente;
import br.com.petmania.cadastros.model.Porte;
import br.com.petmania.cadastros.model.Raca;
import br.com.petmania.cadastros.model.TipoAnimal;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nicolas
 */
public class CadastrarAnimal implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res, String method) throws Exception {
        //Passando titulo e descrição da página
        String titulo = "Cadastro de Animal";
        String descricao = "Cadastro de Animal";
        req.setAttribute("titulo", titulo);
        req.setAttribute("descricao", descricao);
        req.setAttribute("action", "/sistema?acao=CadastrarAnimal");
        
        //nome dos clientes
        DAOCliente daoCliente = new  DAOCliente();
        ArrayList<Cliente> clientes = daoCliente.buscarCliente();
        req.setAttribute("clientes", clientes);
        
        //porte dos cachorros
        DAOPorte daoPorte = new DAOPorte();
        ArrayList<Porte> portes = daoPorte.buscarPorte();
        req.setAttribute("portes", portes);
        
        //racas de animais
        DAORaca daoRaca = new DAORaca();
        ArrayList<Raca> racas = daoRaca.buscarRaca();
        req.setAttribute("racas", racas);
        
        //tipo de animal
        DAOTipoAnimal daoTipoAnimal = new DAOTipoAnimal();
        ArrayList<TipoAnimal> tiposAnimais = daoTipoAnimal.buscarTipoAnimal();
        req.setAttribute("tiposAnimais", tiposAnimais);
    
        return "view/cadastro-animal.jsp";
    }
    
}
