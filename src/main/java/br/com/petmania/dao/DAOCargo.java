/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.dao;

import br.com.petmania.model.TipoFuncionario;
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
public class DAOCargo {
    
    public DAOCargo (){
        
    }
    
    public ArrayList<TipoFuncionario> buscarCargo ()throws SQLException, ClassNotFoundException
    {
        
        ArrayList<TipoFuncionario> listarCargo = new ArrayList();
        Connection con = new ConnectionFactory().getConnection();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * "
                                                        + "FROM TIPO_FUNCIONARIO");
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                TipoFuncionario funcionario = new TipoFuncionario();
                
                funcionario.setId_tipo_funcionario(rs.getInt("ID_TIPO_FUNCIONARIO"));
                funcionario.setDescricao(rs.getString("DESCRICAO"));
                listarCargo.add(funcionario);
            }
            
        }
        catch(SQLException e)
        {
            throw new SQLException ("Erro ao buscar categoria na base de dados. ", e);
        }
        finally
        {
            
        }
        
        return listarCargo;
    }
}
