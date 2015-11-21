/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.dao;


import br.com.petmania.model.Raca;
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
public class DAORaca {
    public DAORaca(){
        
    }
    
    /**
    * metodo responsavel por buscar raças de animais cadastrados na base de dados
    * e retorna-los em um array.
    * @return ArrayList<Raca> 
    * @throws SQLException 
    */
    
    public ArrayList<Raca> buscarRaca () throws SQLException, ClassNotFoundException
    {
        
        ArrayList<Raca> listaRaca = new ArrayList();
        Connection con = new ConnectionFactory().getConnection();
        try
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * "
                                                        + "FROM RACA");
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Raca raca = new Raca();
                raca.setId(rs.getInt("ID_RACA"));
                raca.setDescricao(rs.getString("DESCRICAO"));
                listaRaca.add(raca);
                
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
        
        
        return listaRaca;
    }  
}
