/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.dao;
import br.com.senac.petmania.utils.ConnectionFactory;
import br.com.petmania.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolas
 */
public class DAOUsuario {
    
    
    
    public DAOUsuario() {
        
    }
    
    public Usuario getUsuario(String usuario,String senha) throws SQLException, ClassNotFoundException{
        Usuario user = null;
        Connection con = new ConnectionFactory().getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM USUARIO WHERE USUARIO=? AND SENHA=?");
            stmt.setString(1,usuario);
            stmt.setString(2,senha);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                //System.out.println("ok");
                user = new Usuario();
                user.setId(rs.getString("ID_USUARIO"));
                user.setUsuario(rs.getString("USUARIO"));
                user.setSenha(rs.getString("SENHA"));
                user.setAcesso(rs.getInt("ACESSO"));
                user.setNome(rs.getString("NOME"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException  e) {
            throw new SQLException("Problema na busca de um usuario na base de dados",  e);
        }
        finally {
            con.close();
        }
        return user;
    }
    
    
    
    
}
