/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.dao;

import br.com.petmania.model.EstoqueProduto;
import br.com.petmania.model.Produto;
import br.com.senac.petmania.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class DAOEstoque {
     /**
     * metodo responsavel por buscar todos os produtos cadastrados no estoque
     * e retorna-los em um array.
     * @return ArrayList<EstoqueProduto>
     * @throws SQLException 
     */
    public List<EstoqueProduto> buscarProdutos () throws SQLException, ClassNotFoundException
    {   
        Connection con = new ConnectionFactory().getConnection();
        List<EstoqueProduto> listaEstoque = new ArrayList();
        try
        {
            EstoqueProduto estoque;
            PreparedStatement stmt = con.prepareStatement(""+
                                                        "SELECT " +
                                                        "   ESTOQUE_PRODUTO.ID_ESTOQUE_PROD, " +
                                                        "   ESTOQUE_PRODUTO.ID_PRODUTO_ESTOQUE, " +
                                                        "   ESTOQUE_PRODUTO.QUANTIDADE, " +
                                                        "   PRODUTO.* " +
                                                        "FROM ESTOQUE_PRODUTO " +
                                                        "INNER JOIN PRODUTO " +
                                                        "ON ESTOQUE_PRODUTO.ID_PRODUTO_ESTOQUE = PRODUTO.ID_PRODUTO ");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                estoque = new EstoqueProduto(
                    rs.getInt("ID_PRODUTO"),
                    rs.getString("NOME"),
                    rs.getString("DESCRICAO"),
                    rs.getDate("DATA_ENTRADA"),
                    rs.getDate("DATA_INCLUSAO"),
                    rs.getDouble("PRECO"),
                    rs.getInt("ID_CATEGORIA"),
                    rs.getInt("ID_MARCA")
                );
                estoque.setId_estoque_prod(rs.getInt("ID_ESTOQUE_PROD"));
                estoque.setQuantidade(rs.getInt("QUANTIDADE"));
                listaEstoque.add(estoque);
            }
            rs.close();
            stmt.close();
        }
        
        catch(SQLException e)
        {
            throw new SQLException ("Erro ao buscar produtos no estoque. ", e);
        }
        finally
        {
            con.close();
        }
        
        return listaEstoque;
    }
}
