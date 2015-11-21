/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.animais.logica;

import br.com.petmania.dao.DAOAnimal;
import br.com.petmania.dao.DAOCliente;
import br.com.petmania.dao.DAOPorte;
import br.com.petmania.dao.DAORaca;
import br.com.petmania.dao.DAOTipoAnimal;
import br.com.petmania.model.Animal;
import br.com.petmania.model.Cliente;
import br.com.petmania.model.Porte;
import br.com.petmania.model.Raca;
import br.com.petmania.model.TipoAnimal;
import br.com.senac.petmania.logica.Logica;
import br.com.senac.petmania.utils.Utils;
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
        
        if(method.equals("POST")){
            
            //recupera os dados
            String id_cliente  = req.getParameter("id_cliente");
            String nome  = req.getParameter("nome");
            String idade  = req.getParameter("idade");
            String id_tipo_animal  = req.getParameter("id_tipo_animal");
            String id_porte  = req.getParameter("id_porte");
            String id_raca  = req.getParameter("id_raca");
            String cor  = req.getParameter("cor");
            String erroMsg = null;

            if(
                id_cliente != null && 
                nome != null &&
                idade != null &&
                id_tipo_animal != null &&
                id_porte != null &&
                id_raca != null &&
                cor != null &&
                !id_cliente.equals("") && 
                !nome.equals("") &&
                !idade.equals("") &&
                !id_tipo_animal.equals("") &&
                !id_porte.equals("") &&
                !id_raca.equals("") &&
                !cor.equals("")
              ){
                
                //Formata data
                Utils utils = new Utils();
              
                //Passando as informações para a model
                Animal model = new Animal();
                model.setId_cliente(id_cliente);
                model.setNome(nome);
                model.setIdade(utils.parseStringInt(idade));
                model.setId_tipo_animal(id_tipo_animal);
                model.setId_porte(id_porte);
                model.setId_raca(id_raca);
                model.setCor(cor);

                //salvando cliente
                DAOAnimal dao = new DAOAnimal();
                dao.inserirAnimal(model);
                res.sendRedirect("sistema?acao=ListarAnimal&salvar=true");
            }else {
                erroMsg = "Todos os campos devem estar preenchidos";
                req.setAttribute("erroMsg", erroMsg);
            }
        }
        return "view/cadastro-animal.jsp";
    }
}
