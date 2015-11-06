/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.cadastros.dao;

import br.com.senac.petmania.cadastros.utils.ConnectionFactory;
import br.com.petmania.cadastros.model.Animal;
import br.com.petmania.cadastros.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felipe.smagalhaes
 */
public class DAOAnimal 
{
    
    private Connection con;
    
    public DAOAnimal() 
    {
        try 
        {
            this.con = new ConnectionFactory().getConnection();
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     /**
     * Metodo responsavel para inserir novos animais na base de dados
     * @param animal
     * @throws SQLException 
     */
    public void inserirAnimal(Animal animal) throws SQLException
    {
        

        try
        {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO animal (id_cliente, "
                                                                            + "nome,"
                                                                            + "cor,"
                                                                            + "idade,"
                                                                            + "id_tipo_animal, "
                                                                            + "id_porte, "
                                                                            + "id_raca) "
                                                        + "VALUES (?, ?, ?, ?, ?, ?)");
            
            stmt.setInt(1, animal.getId_cliente());
            stmt.setString(2, animal.getNome());
            stmt.setString(3, animal.getCor());
            stmt.setInt(4, animal.getIdade());
            stmt.setInt(5, animal.getId_tipo_animal());
            stmt.setInt(6, animal.getId_porte());
            stmt.setInt(7, animal.getId_raca());
            
            stmt.close();
            
        }
        
        catch(SQLException e)
        {
            throw new SQLException("Erro ao inserir um novo animal na base de dados. ", e);
        }
        
        finally
        {
            con.close();
        }
    }
    
    /**
    * metodo responsavel por buscar todos os clientes cadastrados na base de dados
    * e retorna-los em um array.
    * @return
    * @throws SQLException 
    */
    
    public ArrayList<Animal> buscarCliente () throws SQLException
    {
        
        ArrayList<Animal> listaAnimal = new ArrayList();
        
        try
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * "
                                                        + "  FROM ANIMAL");
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Animal animal = new Animal();
                animal.setId_animal(rs.getInt("ID_ANIMAL"));
                animal.setId_cliente(rs.getInt("ID_CLIENTE"));
                animal.setNome(rs.getString("NOME"));
                animal.setCor(rs.getString("COR"));
                animal.setIdade(rs.getInt("IDADE"));
                animal.setId_tipo_animal(rs.getInt("ID_TIPO_ANIMAL"));
                animal.setId_porte(rs.getInt("ID_PORTE"));
                animal.setId_raca(rs.getInt("ID_RACA"));
                listaAnimal.add(animal);
                
            }
        }
        catch(SQLException e)
        {
            throw new SQLException ("Erro ao buscar os animais na base de dados. ", e);
        }
        
        finally
        {
            con.close();
        }
        
        
        return listaAnimal;
    }  
    
     /**
     * Metodo responsavel por alterar um registro na base de dados com base no seu ID.
     * @param animal 
     */
    
    public void alterarAnimal(Animal animal) throws SQLException
    {
        
        try
        {
            PreparedStatement stmt = con.prepareStatement("UPDATE ANIMAL SET (nome=?, "
                                                                            + "cor=?,"
                                                                            + "idade=?, "
                                                                            + "ID_TIPO_ANIMAL=?, "
                                                                            + "ID_PORTE=?, "
                                                                            + "ID_RACA=?"
                                                                    + "WHERE ID_ANIMAL =?");
            
            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getCor());
            stmt.setInt(3, animal.getIdade());
            stmt.setInt(4, animal.getId_tipo_animal());
            stmt.setInt(5, animal.getId_porte());
            stmt.setInt(6, animal.getId_raca());
            stmt.setInt(7, animal.getId_animal());
            
            stmt.close();
        }
        
        catch(SQLException e)
        {
            throw new SQLException("Erro ao alterar o cadastro do animal selecionado! ", e);
        }
        
        finally
        {
            con.close();
        }
        
    }
    
     /**
     * Metodo responsavel por inativar um animal em nossa base de dados, por regra de negocio,
     * nao excluimos nenhum registro, sendo assim, mantendo um histórico e a integridade do banco.
     * @param animal
     * @throws SQLException 
     */
    
    public void inativarCliente(Animal animal) throws SQLException
    {
        PreparedStatement stmt = con.prepareStatement("UPDATE ANIMAL SET (status) "
                                                            + "VALUES (?)"
                                                            + "WHERE ID_ANIMAL =?");
        
        stmt.setInt(1, animal.getStatus_inativo());
        stmt.setInt(2, animal.getId_animal());
        
    }
    
}
