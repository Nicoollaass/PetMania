/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.funcionario.logica;

import br.com.petmania.dao.DAOCargo;
import br.com.petmania.dao.DAOFuncionario;
import br.com.petmania.dao.DAOLocacao;
import br.com.petmania.model.Funcionario;
import br.com.petmania.model.Locacao;
import br.com.petmania.model.TipoFuncionario;
import br.com.senac.petmania.logica.Logica;
import br.com.senac.petmania.utils.Utils;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hp
 */
public class CadastroFuncionario implements Logica{
    
    String nome = "";
    String id_tipo_funcionario = "";
    String data_nascimento = "";
    String email = "";
    String cpf = "";
    String id_locacao = "";
    String erroMsg = "";
    
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res, String method) throws Exception {
    
        //Passando titulo e descrição da página
        String titulo = "Cadastrar Funcionarios";
        String descricao = "Adicionar novos funcionarios";
        req.setAttribute("titulo", titulo);
        req.setAttribute("descricao", descricao);
        req.setAttribute("action", "/sistema?param=funcionario&acao=CadastroFuncionario");
   
        //Cargo
        DAOCargo carg = new DAOCargo();
        ArrayList<TipoFuncionario> cargo = carg.buscarCargo();
        req.setAttribute("TipoFuncionario", cargo);
        
        //localidade
        DAOLocacao loc = new DAOLocacao();
        ArrayList<Locacao> locacao = loc.buscarLocacao();
        req.setAttribute("locacao", locacao);
        
         if(method.equals("POST"))
         {
             this.cpf = req.getParameter("cpf");
             this.data_nascimento = req.getParameter("data_nascimento");
             this.email = req.getParameter("email");
             this.id_locacao = req.getParameter("locacao");
             this.id_tipo_funcionario = req.getParameter("TipoFuncionario");
             this.nome = req.getParameter("nome");
             
             if(this.cpf != null &&
                this.data_nascimento != null &&
                this.email != null &&
                this.id_locacao != null &&
                this.id_tipo_funcionario != null &&
                this.nome != null &&
                !this.cpf.equals("") &&
                !this.data_nascimento.equals("") &&
                !this.email.equals("")&&
                !this.id_locacao.equals("") &&
                !this.id_tipo_funcionario.equals("") &&
                !this.nome.equals("")
              )
             {
                 
                 Funcionario funcionario = new Funcionario ();
                 
                Utils utils = new Utils();
                Date data = utils.formatarData(this.data_nascimento);
                
                funcionario.setCpf(this.cpf);
                funcionario.setData_nascimento((java.sql.Date) data);
                funcionario.setEmail(this.email);
                funcionario.setId_locacao(Integer.parseInt(this.id_locacao));
                funcionario.setId_tipo_funcionario(Integer.parseInt(this.id_tipo_funcionario));
                funcionario.setNome(this.nome);
                
                
                 DAOFuncionario dao = new DAOFuncionario();
                 
                 dao.inserirFuncionario(funcionario);
                 
                 res.sendRedirect("sistema?param=funcionario&acao=CadastroFuncionario");
             }    
             else
             {
                 this.erroMsg = "Todos os campos devem estar preenchidos";
                req.setAttribute("erroMsg", this.erroMsg);
             }
         }
         
             

        
        
        return "view/cadastro-funcionario.jsp";
    }
    
}
