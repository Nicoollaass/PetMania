/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.clientes.logica;

import br.com.petmania.dao.DAOCliente;
import br.com.petmania.model.Cliente;
import br.com.senac.petmania.logica.Logica;
import br.com.senac.petmania.utils.Utils;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hp
 */
public class CadastrarCliente implements Logica{

    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res,String method) throws Exception {
        
        //Passando titulo e descrição da página
        String titulo = "Cadastrar Cliente";
        String descricao = "Cadastrar Cliente";
        req.setAttribute("titulo", titulo);
        req.setAttribute("descricao", descricao);
        req.setAttribute("action", "/sistema?param=clientes&acao=CadastrarCliente");
        if(method.equals("POST")){
            //recupera os dados
            String nome  = req.getParameter("cliente_nome");
            String cpf  = req.getParameter("cliente_cpf");
            String data_old  = req.getParameter("cliente_data_nascimento");
            String email  = req.getParameter("cliente_email");
            String sexo  = req.getParameter("cliente_sexo");
            String telefone  = req.getParameter("cliente_telefone");
            String erroMsg = null;

            if(
                cpf != null && 
                data_old != null &&
                sexo != null &&
                telefone != null &&
                !cpf.equals("") && 
                !data_old.equals("") &&
                !sexo.equals("") &&
                !telefone.equals("")
              ){
                
                //Formata data
                Utils utils = new Utils();
                Date data = utils.formatarData(data_old);

                //Passando as informações para a model
                Cliente model = new Cliente();
                model.setCpf(cpf);
                model.setData_nascimento(data);
                model.setEmail(email);
                model.setIdade(20);
                model.setNome(nome);
                model.setSexo(sexo);
                model.setTelefone(telefone);

                //salvando cliente
                DAOCliente dao = new DAOCliente();
                dao.inserirCliente(model);
                res.sendRedirect("sistema?param=clientes&acao=ListarClientes");
            }else {
                erroMsg = "Todos os campos devem estar preenchidos";
                req.setAttribute("erroMsg", erroMsg);
            }
        }       
        return "view/cadastro-cliente.jsp";
    
    }
    
    
}
