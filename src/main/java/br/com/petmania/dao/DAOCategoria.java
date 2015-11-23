/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.dao;

import br.com.petmania.model.Categoria;
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
public class DAOCategoria {
    
    public DAOCategoria(){
        
    }
    
    public ArrayList<Categoria> buscarCategoria () throws SQLException, ClassNotFoundException
    {
        ArrayList<Categoria> listarCategoria = new ArrayList();
        Connection con = new ConnectionFactory().getConnection();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * "
                                                        + "FROM CATEGORIA");
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Categoria cat = new Categoria();
                
                cat.setId_categoria(rs.getInt("ID_CATEGORIA"));
                cat.setDescricao(rs.getString("DESCRICAO"));
                
                listarCategoria.add(cat);
                
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
        
        return listarCategoria;
    }
    
}
