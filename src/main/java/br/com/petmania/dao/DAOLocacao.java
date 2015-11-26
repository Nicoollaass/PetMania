/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.dao;

import br.com.petmania.model.Locacao;
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
public class DAOLocacao {
    
    public DAOLocacao(){
    
    }
    
    public ArrayList<Locacao> buscarLocacao ()throws SQLException, ClassNotFoundException
    {
        
        ArrayList<Locacao> listarLocacao = new ArrayList();
        Connection con = new ConnectionFactory().getConnection();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * "
                                                        + "FROM LOCACAO");
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Locacao locacao = new Locacao();
                
                locacao.setId_locacao(rs.getInt("ID_LOCACAO"));
                locacao.setDescricao(rs.getString("DESCRICAO"));
                
                listarLocacao.add(locacao);
            }
        }
        catch(SQLException e)
        {
            throw new SQLException ("Erro ao buscar os itens de locacao na base de dados. ", e);        
        }
        finally
        {
            con.close();
        }
        
        
        return listarLocacao;
    }
}
