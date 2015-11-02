/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.cadastros.logica;

import br.com.petmania.cadastros.dao.DAOCliente;
import br.com.petmania.cadastros.model.Cliente;
import br.com.senac.petmania.cadastros.utils.Utils;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hp
 */
public class CadastroCliente implements Logica{

    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        System.out.println("aqui passou");
        
        String valor = "19950302";
        Date data = null;
        
        DAOCliente dao = new DAOCliente();
        Cliente model = new Cliente();
        Utils utils = new Utils();
    
        data = utils.formatarData(valor);
        
        //System.out.println(data);
        System.out.println("ok");
        
        model.setCpf("1234567");
        model.setData_nascimento(data);
        model.setEmail("felipesantos.magalhaes@gmail.com");
        model.setIdade(20);
        model.setNome("Felipe");
        model.setSexo("M");
        model.setTelefone("943912345");
        
        dao.inserirCliente(model);
        
        return "view/index.html";
    
    }
    
    
}
