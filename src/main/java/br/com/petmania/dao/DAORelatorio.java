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
                                                    "	GROUP BY ID_VENDEDOR");
            
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
}
