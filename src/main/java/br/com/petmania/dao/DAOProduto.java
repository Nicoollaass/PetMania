/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.dao;


import br.com.petmania.model.Cliente;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.petmania.model.Produto;
import br.com.senac.petmania.utils.ConnectionFactory;
import br.com.senac.petmania.utils.Contantes;
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
            stmt.setDate(4, produto.getData_entrada());
            stmt.setDouble(5, produto.getPreco());
            stmt.setInt(6, produto.getId_categoria());
            stmt.setInt(7, produto.getId_marca());
            
            stmt.execute();
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
    
     /**
    * metodo responsavel por buscar um produto especifico pelo ID na base de dados
    * @return Produto
    * @throws SQLException 
    */
    public Produto getProduto (int id) throws SQLException, ClassNotFoundException
    {   
        Produto produto = null;
        
        Connection con = new ConnectionFactory().getConnection();
        try
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * "
                                                        + "FROM PRODUTO "
                                                        + "WHERE ID_PRODUTO = ?");
    
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();    
            
            while (rs.next())
            {
                produto = new Produto();
                produto.setId_produto(rs.getInt("ID_PRODUTO"));
                produto.setNome(rs.getString("NOME"));
                produto.setDescricao(rs.getString("DESCRICAO"));   
                produto.setPreco(rs.getDouble("PRECO"));
                produto.setData_entrada(rs.getDate("DATA_ENTRADA"));
                produto.setData_inclusao(rs.getDate("DATA_INCLUSAO"));
                produto.setId_categoria(rs.getInt("ID_CATEGORIA"));
                produto.setId_marca(rs.getInt("ID_MARCA"));
            }
            
            rs.close();
            stmt.close();
            
        }
        catch(SQLException e)
        {
           throw new SQLException ("Erro ao buscar o produto correspondente na base de dados. ", e);             
        }
        
        finally
        {
            con.close();
        }
        
        return produto;
    }
    
     public void alterarProduto (Produto prod) throws SQLException, ClassNotFoundException
     {
         Connection con = new ConnectionFactory().getConnection();
         
         try
         {
             PreparedStatement stmt = con.prepareStatement("UPDATE PRODUTO SET  nome =?,"
                                                                             + "descricao =?, "
                                                                             + "data_entrada =?, "
                                                                           //  + "data_inclusao =?, "
                                                                             + "preco=?, "
                                                                             + "id_categoria=?, "
                                                                             + "id_marca=? "
                                                                             
                                                             + "WHERE ID_PRODUTO = ?");
             
            stmt.setString(1, prod.getNome());
            stmt.setString(2, prod.getDescricao());
            stmt.setDate(3, prod.getData_entrada());
            stmt.setDouble(4, prod.getPreco());
            stmt.setInt(5, prod.getId_categoria());
            stmt.setInt(6, prod.getId_marca());
            stmt.setInt(7, prod.getId_produto());
            
            stmt.execute();
            stmt.close();
        
            
         }
         catch(SQLException e)
         {
             throw new SQLException("Erro ao alterar o cadastro do cliente selecionado! ", e.getMessage());
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
                                                        + "  FROM produto "
                                                      + "WHERE status = ? ");
            
            //Filtro para trazer apenas os produos ativos
            stmt.setInt(1, 1);           
            
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Produto produto = new Produto();
                produto.setId_produto(rs.getInt("ID_PRODUTO"));
                produto.setNome(rs.getString("NOME"));
                produto.setDescricao(rs.getString("DESCRICAO"));
                produto.setData_entrada(rs.getDate("DATA_ENTRADA"));
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
    
    /**
     * Metodo responsavel por inativar um produo em nossa base de dados, por regra de negocio,
     * nao excluimos nenhum registro, sendo assim, mantendo um histórico e a integridade do banco.
     * @param produto
     * @throws SQLException 
     */
    public void inativarProduto(Contantes contante, int id) throws SQLException, ClassNotFoundException
    {        
        Connection con = new ConnectionFactory().getConnection();
        try
        {
            
            PreparedStatement stmt = con.prepareStatement("UPDATE PRODUTO SET status=? "
                                                                + "WHERE ID_PRODUTO =?");
            stmt.setInt(1, contante.getStatus_Inativo());
            stmt.setInt(2, id);           
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e)
        {
            throw new SQLException("Erro ao inativar o produto selecionado! ", e);
        }
        finally
        {
            con.close();
        }
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
