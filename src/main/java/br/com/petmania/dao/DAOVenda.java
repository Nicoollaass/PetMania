/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.dao;

import br.com.petmania.model.SaidaProduto;
import br.com.petmania.model.VendaProdutos;
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
public class DAOVenda {
     
    /**
     * metodo responsavel por efetuar uma saida de produto
     * e retorna-los em um array.
     * @throws SQLException 
     */
    
    public int criarVenda () throws SQLException, ClassNotFoundException
    {   
        int id_venda=0;
        Connection con = new ConnectionFactory().getConnection();
        try
        {
            
            PreparedStatement stmt = con.prepareStatement(""
                                            + "INSERT INTO VENDA_PRODUTO (CODIGO,TOTAL_NORMAL,TOTAL_DESCONTO,TOTAL) " +
                                            "VALUES (UUID(),0,0,0);");
            stmt.execute();
            
            stmt.close();
            
            PreparedStatement stmt2 = con.prepareStatement(""
                                                            + "SELECT "
                                                            + "ID_VENDA "
                                                            + "FROM VENDA_PRODUTO  "
                                                            + "ORDER BY (ID_VENDA) DESC LIMIT 1 ");
            
            ResultSet rs = stmt2.executeQuery();
            
            while (rs.next())
            {
               id_venda =  rs.getInt("ID_VENDA");
            }
            
           stmt2.close();
           
        }
        catch(SQLException e)
        {
            throw new SQLException("Erro ao efetuar uma venda. ", e);
        }
        finally
        {
            con.close();
        }
        return id_venda;
    }
    
    /**
     * metodo responsavel por disparar a procidore referente aos descontos do cliente
     * @throws SQLException 
     */
    
     public void processaDesconto (int id_cliente, int id_venda) throws SQLException, ClassNotFoundException
    {   
        
        Connection con = new ConnectionFactory().getConnection();
        try
        {
            
            PreparedStatement stmt = con.prepareStatement("CALL CALCULA_DESCONTO(?,?); ");
            
            stmt.setInt(1, id_cliente);
            stmt.setInt(2, id_venda);
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e)
        {
            throw new SQLException("Erro ao calcular desconto. ", e);
        }
        finally
        {
            con.close();
        }
    }
     
      /**
     * metodo responsavel por efetuar uma saida de produto
     * e retorna-los em um array.
     * @return 
     * @throws SQLException 
     * @throws java.lang.ClassNotFoundException 
     */
    
    public List<VendaProdutos> getVendas (int id_venda) throws SQLException, ClassNotFoundException
    {   
        List<VendaProdutos> vendas = new ArrayList();
        Connection con = new ConnectionFactory().getConnection();
        try
        {
            
            PreparedStatement stmt = con.prepareStatement("" +
                                                        " SELECT " +
                                                        "   CODIGO, " +
                                                        "   PRODUTO.DESCRICAO, " +
                                                        "   PRODUTO.PRECO, " +
                                                        "   CLIENTE.NOME AS 'CLIENTE', " +
                                                        "   USUARIO.NOME AS 'VENDEDOR', " +
                                                        "   VENDA_PRODUTO.TOTAL, " +
                                                        "   QTDE " +
                                                        " FROM SAIDA_PRODUTO " +
                                                        " INNER JOIN PRODUTO " +
                                                        " ON SAIDA_PRODUTO.ID_PRODUTO = PRODUTO.ID_PRODUTO " +
                                                        " INNER JOIN CLIENTE " +
                                                        " ON SAIDA_PRODUTO.ID_CLIENTE= CLIENTE.ID_CLIENTE " +
                                                        " INNER JOIN USUARIO " +
                                                        " ON SAIDA_PRODUTO.ID_VENDEDOR = USUARIO.ID_USUARIO " +
                                                        " INNER JOIN VENDA_PRODUTO " +
                                                        " ON SAIDA_PRODUTO.ID_VENDA_PRODUTO = VENDA_PRODUTO.ID_VENDA " +
                                                        " WHERE ID_VENDEDOR = (SELECT ID_VENDEDOR FROM SAIDA_PRODUTO WHERE ID_VENDA_PRODUTO = ? LIMIT 1) " +
                                                        " AND ID_VENDA_PRODUTO  = ? ");
            stmt.setInt(1, id_venda);
            stmt.setInt(2, id_venda);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
              VendaProdutos venda = new VendaProdutos();
              venda.setCodigo(rs.getString("CODIGO"));
              venda.setDescricao(rs.getString("DESCRICAO"));
              venda.setPreco(rs.getDouble("PRECO"));
              venda.setCliente(rs.getString("CLIENTE"));
              venda.setVendedor(rs.getString("VENDEDOR"));
              venda.setTotal(rs.getDouble("TOTAL"));
              venda.setQtde(rs.getInt("QTDE"));
              vendas.add(venda);
            }
           rs.close();
           stmt.close();
           
        }
        catch(SQLException e)
        {
            throw new SQLException("Erro ao efetuar uma venda. ", e);
        }
        finally
        {
            con.close();
        }
        return vendas;
    }
     
    
}
