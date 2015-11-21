/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.dao;


import br.com.petmania.model.TipoAnimal;
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
public class DAOTipoAnimal {
    
    public DAOTipoAnimal(){
        
    }
    
    /**
    * metodo responsavel por buscar raças de animais cadastrados na base de dados
    * e retorna-los em um array.
    * @return ArrayList<TipoAnimal>
    * @throws SQLException 
    */
    public ArrayList<TipoAnimal> buscarTipoAnimal () throws SQLException, ClassNotFoundException
    {
        
        ArrayList<TipoAnimal> listaTipoAnimal = new ArrayList();
        Connection con = new ConnectionFactory().getConnection();
        try
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * "
                                                        + "FROM TIPO_ANIMAL");
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                TipoAnimal tipoAnimal = new TipoAnimal();
                tipoAnimal.setId(rs.getInt("ID_TIPO_ANIMAL"));
                tipoAnimal.setDescricao(rs.getString("DESCRICAO"));
                listaTipoAnimal.add(tipoAnimal);
                
            }
        }
        catch(SQLException e)
        {
            throw new SQLException ("Erro ao buscar tipo do animal cadastrado na base de dados. ", e);
        }
        
        finally
        {
            con.close();
        }
        
        
        return listaTipoAnimal;
    } 
}
