/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.dao;

import br.com.petmania.model.Animal;
import br.com.petmania.model.Porte;
import br.com.senac.petmania.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nicolas
 */
public class DAOPorte {
    
    public DAOPorte(){
        
    }
    /**
    * metodo responsavel por buscar porte de animais cadastrados na base de dados
    * e retorna-los em um array.
    * @return
    * @throws SQLException 
    */
    
    public ArrayList<Porte> buscarPorte () throws SQLException, ClassNotFoundException
    {
        
        ArrayList<Porte> listaPorte = new ArrayList();
        Connection con = new ConnectionFactory().getConnection();
        try
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * "
                                                        + "FROM PORTE");
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Porte porte = new Porte();
                porte.setId(rs.getInt("ID_PORTE"));
                porte.setDescricao(rs.getString("DESCRICAO"));
                listaPorte.add(porte);
                
            }
        }
        catch(SQLException e)
        {
            throw new SQLException ("Erro ao buscar porte na base de dados. ", e);
        }
        
        finally
        {
            con.close();
        }
        
        
        return listaPorte;
    }  
}
