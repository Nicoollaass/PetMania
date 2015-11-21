/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.dao;


import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.petmania.model.Cliente;
import br.com.petmania.model.Funcionario;
import br.com.petmania.model.Pessoa;
import br.com.petmania.model.Produto;
import br.com.senac.petmania.utils.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HERICK
 */
public class DAOProduto {
    
     
    
     public void inserirProduto (Produto produto) throws SQLException, ClassNotFoundException
    {   
        Connection con = new ConnectionFactory().getConnection();
        try
        {
            
            PreparedStatement stmt = con.prepareStatement("INSERT INTO produto (Nome,"
                                                                             + "descricao, "
                                                                             + "data_entrada, "
                                                                             + "data_inclusao, "
                                                                             + "preco, "
                                                         		 + "id_categoria, "
                                                                             + "id_marca )"
                                                                             
                                                            + "VALUES (?, ?, ?, ?, ?, ?, ?)");
            
            
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDate(3, produto.getData_entrada());
            stmt.setDate(4, produto.getData_inclusao());
            stmt.setDouble(5, produto.getPreco());
            stmt.setInt(5, produto.getId_categoria());
            stmt.setInt(5, produto.getId_marca());
           
            stmt.close();
        }
        catch(SQLException e)
        {
            throw new SQLException("Erro ao inserir um novo produto na base de dados. ", e);
        }
        finally
        {
            con.close();
        }
    }
     
    public List<Produto> buscarProduto () throws SQLException, ClassNotFoundException
    {
        Connection con = new ConnectionFactory().getConnection();
        List<Produto> listaProdutos = new ArrayList();
        try
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * "
                                                        + "  FROM produto");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Produto produto = new Produto();
                produto.setId_produto(rs.getInt("ID_PRODUTO"));
                produto.setNome(rs.getString("NOME"));
                produto.setDescricao(rs.getString("DESCRICAO"));   
                produto.setPreco(rs.getDouble("PRECO"));
                produto.setId_categoria(rs.getInt("ID_CATEGORIA"));
                produto.setId_marca(rs.getInt("ID_MARCA"));
                
                listaProdutos.add(produto);
            }
        } 
        
        catch(SQLException e)
        {
            throw new SQLException ("Erro ao listar os produtos ", e);
            
        }
        finally
        {
            con.close();
        }
        
        return listaProdutos;
    }
    
    public Produto isProduto (int id) throws SQLException, ClassNotFoundException
    {
        Produto produto = null;
        Connection con = new ConnectionFactory().getConnection();
        try
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * "
                                                        + "FROM produto "
                                                        + "WHERE ID_PRODUTO = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                produto = new Produto();
                produto.setNome(rs.getString("NOME"));
                produto.setDescricao(rs.getString("DESCRICAO"));   
                produto.setPreco(rs.getDouble("PRECO"));
                produto.setId_categoria(rs.getInt("ID_CATEGORIA"));
                produto.setId_marca(rs.getInt("ID_MARCA"));
            }
            
        } 
        
        catch(SQLException e)
        {
            throw new SQLException ("Erro ao listar os produtos ", e);
            
        }
        finally
        {
            con.close();
        }
        return produto;
    }
}
