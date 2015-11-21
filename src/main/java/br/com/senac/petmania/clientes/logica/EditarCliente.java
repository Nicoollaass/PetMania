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
 * @author Nicolas
 */
public class EditarCliente implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res, String method) throws Exception {
        
        //Passando titulo e descrição da página
        String titulo = "Editar Cliente";
        String descricao = "Editar Cliente";
        req.setAttribute("titulo", titulo);
        req.setAttribute("descricao", descricao);
        req.setAttribute("action", "/sistema?acao=EditarCliente");

        //Criando o object para consutas e inserções na base de dados
        DAOCliente dao = new DAOCliente();
        Utils utils = new Utils();
        
        
        if (method.equals("POST")) {
            //recupera os dados
            String id_old = req.getParameter("id_cliente");
            String nome = req.getParameter("cliente_nome");
            String cpf = req.getParameter("cliente_cpf");
            String data_old = req.getParameter("cliente_data_nascimento");
            String email = req.getParameter("cliente_email");
            String sexo = req.getParameter("cliente_sexo");
            String telefone = req.getParameter("cliente_telefone");
            String erroMsg = null;
            int id = utils.parseStringInt(id_old); 

            if  (!cpf.equals("")
                    && !data_old.equals("")
                    && !sexo.equals("")
                    && !telefone.equals("")
                    && dao.getCliente(id) != null) {

                //Formata data
                Date data = utils.formatarData(data_old);

                //Passando as informações para a model
                Cliente model = new Cliente();
                model.setId_cliente(id);
                model.setCpf(cpf);
                model.setData_nascimento(data);
                model.setEmail(email);
                model.setIdade(20);
                model.setNome(nome);
                model.setSexo(sexo);
                model.setTelefone(telefone);

                //Update em cliente
                dao.alterarCliente(model);
                res.sendRedirect("sistema?acao=ListarClientes&editar=true");
            } else {
                erroMsg = "Todos os campos devem estar preenchidos";
                req.setAttribute("erroMsg", erroMsg);
            }
        }
        /*======== Method 'GET' =========*/
        else {
            String identificador = req.getParameter("id");
            if(identificador != null){
                int id = utils.parseStringInt(identificador);
                Cliente cliente = dao.getCliente(id);
                req.setAttribute("cliente", cliente);
            }
        }
        return "view/cadastro-cliente.jsp";
    }

}
