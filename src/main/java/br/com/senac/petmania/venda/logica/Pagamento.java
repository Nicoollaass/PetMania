/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.venda.logica;

import br.com.petmania.dao.DAOEstoque;
import br.com.petmania.dao.DAOVenda;
import br.com.petmania.model.Produto;
import br.com.petmania.model.SaidaProduto;
import br.com.petmania.model.Usuario;
import br.com.senac.petmania.carrinho.logica.Carrinho;
import br.com.senac.petmania.carrinho.logica.Item;
import br.com.senac.petmania.logica.Logica;
import br.com.senac.petmania.produto.logica.Estoque;
import br.com.senac.petmania.utils.Utils;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

/**
 *
 * @author Nicolas
 */
public class Pagamento implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res, String method) throws Exception {
        Utils tools = new Utils();

        //Resgatando as informações para popular o carriho
        String id_cliente_before = req.getParameter("id_cliente");

        int id_cliente = 0;
        int id_venda = 0;
        String mensagem = "false";

        if (id_cliente_before != null) {
            try {
                mensagem = "true";

                id_cliente = tools.parseStringInt(id_cliente_before);

                //resgatando a sessão
                HttpSession session = req.getSession(false);

                //Pegando objeto carrinho na sessão do usuário
                Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
                Usuario user = (Usuario) session.getAttribute("usuarioLogado");

                DAOEstoque estoque = new DAOEstoque();
                List<Item> itens = carrinho.getItens();

                DAOVenda daoVenda = new DAOVenda();
                id_venda = daoVenda.criarVenda();
                
                Produto prod = null;
                Estoque validaEstoque = new Estoque();

                if (validaEstoque.isProduto(carrinho, prod) == null) {
                    for (Item item : itens) {

                        //instancias para formar saida da venda 
                        SaidaProduto saida = new SaidaProduto();
                        Produto produto = item.getProduto();
                        saida.setId_produto(produto.getId_produto());
                        saida.setId_cliente(id_cliente);
                        saida.setId_vendedor(user.getId());
                        saida.setId_venda_produto(id_venda);
                        saida.setQtde(item.getQuantidade());
                        saida.setValor_unitario(produto.getPreco());

                        estoque.inserirProduto(saida);

                    }
                    daoVenda.processaDesconto(id_cliente, id_venda);
                }else {
                    mensagem = "quant_invalid";
                }

            } catch (Exception e) {
                mensagem = "false";
                System.out.println("Houve um erro ao efetuar uma venda: " + e.getMessage());
            }

        }

        JSONObject json = new JSONObject();
        json.put("insert", mensagem);
        json.put("id_venda", id_venda);

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        // Get the printwriter object from response to write the required json object to the output stream      

        PrintWriter out = res.getWriter();
        // Assuming your json object is **jsonObject**, perform the following, it will return your json object  
        out.print(json.toString());
        out.flush();
        return "";
    }

}
