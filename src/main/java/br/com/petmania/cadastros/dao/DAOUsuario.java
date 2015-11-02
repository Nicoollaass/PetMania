/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.cadastros.dao;
import br.com.petmania.cadastros.model.Usuario;
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
    
    private Connection con;
    
    public DAOUsuario() {
        try {
            this.con = new ConnectionFactory().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Usuario getUsuario(String usuario,String senha) throws SQLException{
        Usuario user = null;
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM USUARIO WHERE USUARIO=? AND SENHA=?");
            stmt.setString(1,usuario);
            stmt.setString(2,senha);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
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
