/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.dao;

import br.com.petmania.model.Marca;
import br.com.senac.petmania.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class DAOMarca {
    
    public DAOMarca(){
        
    }
    
    public ArrayList<Marca> buscarMarca ()throws SQLException, ClassNotFoundException
    {
      
        ArrayList<Marca> listarMarca = new ArrayList();
        Connection con = new ConnectionFactory().getConnection();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * "
                                                        + "FROM MARCA");
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Marca marca = new Marca();
                
                marca.setMarca(rs.getInt("ID_MARCA"));
                marca.setDescricao(rs.getString("DESCRICAO"));
                
                listarMarca.add(marca);
            }
            
        }
        
        catch(SQLException e)
        {
            throw new SQLException ("Erro ao buscar categoria na base de dados. ", e);
        }
        
        finally
        {
            con.close();
        }
        
        
        
        return listarMarca;
    }
    
}
