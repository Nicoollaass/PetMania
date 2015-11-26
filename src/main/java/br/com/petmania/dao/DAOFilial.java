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
public class DAOFilial  {
    
    /**
    * metodo responsavel por buscar todas as filiais 
    * e retorna-los em um array.
    * @return <List>
    * @throws SQLException 
    */
    
     /**
    * metodo responsavel por buscar todas as filiais
    * @return <list>
    * @throws SQLException 
    */
    public List<Object> getFiliais () throws SQLException, ClassNotFoundException
    {   
        List<Object> filiais = new ArrayList();
        Map<String,Object> filial;
        
        Connection con = new ConnectionFactory().getConnection();
        try
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * "
                                                        + "FROM LOCACAO ");
    
            
            ResultSet rs = stmt.executeQuery();    
            
            while (rs.next())
            {
                filial = new HashMap<String,Object>();
                filial.put("ID", rs.getInt("ID_LOCACAO"));
                filial.put("DESCRICAO", rs.getString("DESCRICAO"));
                filiais.add(filial);
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
        
        return filiais;
    }
}
