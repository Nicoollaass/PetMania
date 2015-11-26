/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.dao;

import br.com.senac.petmania.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Nicolas
 */
public class DAORelatorio {
    /**
    * metodo responsavel por buscar filtrar as vendas realizadas por filial
    * e retorna-los em um array.
    * @return ArrayList<Raca> 
    * @throws SQLException 
    */
    
    public List<Object> filial () throws SQLException, ClassNotFoundException
    {
        
       
        List<Object> relatorios = new ArrayList();
        Connection con = new ConnectionFactory().getConnection();
        try
        {
            PreparedStatement stmt = con.prepareStatement(""+
                                                    "   SELECT " +
                                                    "	    sum(QTDE) AS 'QUANTIDADE', " +
                                                    "	    FUNCIONARIO.NOME 'VENDEDOR', " +
                                                    "	    LOCACAO.DESCRICAO AS 'FILIAL' " +
                                                    "	     " +
                                                    "	FROM SAIDA_PRODUTO " +
                                                    "" +
                                                    "	INNER JOIN USUARIO " +
                                                    "	ON SAIDA_PRODUTO.ID_VENDEDOR = USUARIO.ID_USUARIO " +
                                                    "" +
                                                    "	INNER JOIN FUNCIONARIO " +
                                                    "	ON USUARIO.ID_FUNCIONARIO = FUNCIONARIO.ID_FUNCIONARIO " +
                                                    "" +
                                                    "	INNER JOIN LOCACAO " +
                                                    "	ON FUNCIONARIO.ID_LOCACAO = LOCACAO.ID_LOCACAO " +
                                                    "" +
                                                    "	GROUP BY LOCACAO.ID_LOCACAO");
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Map<String,Object> relatorio = new HashMap<String,Object>();
                relatorio.put("QUANTIDADE", rs.getInt("QUANTIDADE"));
                relatorio.put("VENDEDOR", rs.getString("VENDEDOR"));
                relatorio.put("FILIAL", rs.getString("FILIAL"));
                relatorios.add(relatorio);
            }
        }
        catch(SQLException e)
        {
            throw new SQLException ("Erro filtrar relatório de vendas por filial. ", e);
        }
        
        finally
        {
            con.close();
        }
        
        
        return relatorios;
    }  
    
    
    /**
    * metodo responsavel por buscar quantidade de produtos vendidos
    * e retorna-los em um array.
    * @return ArrayList<Raca> 
    * @throws SQLException 
    */
    
    public List<Object> produto () throws SQLException, ClassNotFoundException
    {
        
       
        List<Object> relatorios = new ArrayList();
        Connection con = new ConnectionFactory().getConnection();
        try
        {
            PreparedStatement stmt = con.prepareStatement("SELECT  " +
                                                        "    sum(QTDE) AS 'QUANTIDADE', " +
                                                        "    PRODUTO.DESCRICAO AS 'DESCRICAO' " +
                                                        "FROM SAIDA_PRODUTO " +
                                                        "INNER JOIN PRODUTO " +
                                                        "ON PRODUTO.ID_PRODUTO = SAIDA_PRODUTO.ID_PRODUTO  " +
                                                        "GROUP BY SAIDA_PRODUTO.ID_PRODUTO");
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Map<String,Object> relatorio = new HashMap<String,Object>();
                relatorio.put("QUANTIDADE", rs.getInt("QUANTIDADE"));
                relatorio.put("DESCRICAO", rs.getString("DESCRICAO"));
                relatorios.add(relatorio);
            }
        }
        catch(SQLException e)
        {
            throw new SQLException ("Erro filtrar relatório de vendas por filial. ", e);
        }
        
        finally
        {
            con.close();
        }
        
        
        return relatorios;
    } 
    
    
     /**
    * metodo responsavel por buscar vendedores por filial
    * e retorna-los em um LIST.
    * @param id_filial
    * @return List<Object> 
    * @throws SQLException 
    */
    
    public List<Object> vendedor (int id_filial) throws SQLException, ClassNotFoundException
    {
        
       
        List<Object> relatorios = new ArrayList();
        Connection con = new ConnectionFactory().getConnection();
        try
        {
            PreparedStatement stmt = con.prepareStatement(  "SELECT \n" +
                                                            "	 sum(QTDE) AS 'QUANTIDADE',\n" +
                                                            "    ID_VENDEDOR,\n" +
                                                            "    USUARIO.ID_FUNCIONARIO ,\n" +
                                                            "    FUNCIONARIO.NOME AS 'NOME',\n" +
                                                            "    LOCACAO.DESCRICAO\n" +
                                                            "    \n" +
                                                            "FROM SAIDA_PRODUTO\n" +
                                                            "\n" +
                                                            "INNER JOIN USUARIO\n" +
                                                            "ON SAIDA_PRODUTO.ID_VENDEDOR = USUARIO.ID_USUARIO\n" +
                                                            "\n" +
                                                            "INNER JOIN FUNCIONARIO\n" +
                                                            "ON USUARIO.ID_FUNCIONARIO = FUNCIONARIO.ID_FUNCIONARIO\n" +
                                                            "\n" +
                                                            "INNER JOIN LOCACAO\n" +
                                                            "ON FUNCIONARIO.ID_LOCACAO = LOCACAO.ID_LOCACAO \n" +
                                                            "\n" +
                                                            "WHERE LOCACAO.ID_LOCACAO = ?\n" +
                                                            "GROUP BY ID_VENDEDOR");
            stmt.setInt(1, id_filial);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Map<String,Object> relatorio = new HashMap<String,Object>();
                relatorio.put("QUANTIDADE", rs.getInt("QUANTIDADE"));
                relatorio.put("NOME", rs.getString("NOME"));
                relatorios.add(relatorio);
            }
        }
        catch(SQLException e)
        {
            throw new SQLException ("Erro filtrar relatório de vendas por filial. ", e);
        }
        
        finally
        {
            con.close();
        }
        
        
        return relatorios;
    } 
}
