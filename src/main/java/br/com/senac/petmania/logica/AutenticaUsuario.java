/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.logica;

import br.com.petmania.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class AutenticaUsuario {
    
    
    private List<String> page;
    private int GERENTE = 1;
    private int FUNCRETAGUARDA = 2;
    private int VENDEDOR = 3;
    
    public AutenticaUsuario(Usuario user){
        this.page = new ArrayList();
        int acesso = user.getAcesso();
        page.add("Home");
        if(acesso == VENDEDOR){
           //Cliente 
           page.add("CadastrarCliente");
           page.add("EditarCliente");
           page.add("ExcluirCliente");
           page.add("FilterClientes");
           page.add("ListarClientes");
           
           //Animal
           page.add("CadastrarAnimal");
           page.add("FilterAnimais");
           page.add("ListarAnimal");
           
           //Cart
           page.add("AdicionarCarrinho");
           page.add("RemoverCarrinho");
           
           //venda
           page.add("Pagamento");
           page.add("Pedido");
           page.add("ListarProdutos");
           page.add("FilterProduto");
           page.add("VendaProduto");
           page.add("Estoque");
           
           
        }else if (acesso == GERENTE){
           page.add("Relatorio");
           page.add("RelatorioFilial");
           page.add("RelatorioProduto");
           page.add("RelatorioVendedor");
           
        }else if (acesso == FUNCRETAGUARDA) {
            page.add("CadastrarProdutos");
            page.add("EditarProduto");
            page.add("ExcluirProduto");
            page.add("CadastroProdutos");
        }
    }
    
    
    
    public boolean validaAcesso(String pag) {
        for (String pags:this.page) {
            if(pags.equals(pag)){
                return true;
            }
        }
        return false;
    }
    
    
    
}
