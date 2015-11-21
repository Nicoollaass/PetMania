/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.dao;

import br.com.senac.petmania.utils.ConnectionFactory;
import br.com.petmania.model.Animal;
import br.com.petmania.model.Cliente;
import br.com.senac.petmania.utils.QueryFactory;
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
    
    
    
    public DAOAnimal() 
    {
        
    }
    
     /**
     * Metodo responsavel para inserir novos animais na base de dados
     * @param animal
     * @throws SQLException 
     */
    public void inserirAnimal(Animal animal) throws SQLException, ClassNotFoundException
    {
        
        Connection con = new ConnectionFactory().getConnection();
        try
        {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO animal (id_cliente, "
                                                                            + "nome,"
                                                                            + "cor,"
                                                                            + "idade,"
                                                                            + "id_tipo_animal, "
                                                                            + "id_porte, "
                                                                            + "id_raca) "
                                                        + "VALUES (?, ?, ?, ?, ?, ?,?)");
            
            stmt.setString(1, animal.getId_cliente());
            stmt.setString(2, animal.getNome());
            stmt.setString(3, animal.getCor());
            stmt.setInt(4, animal.getIdade());
            stmt.setString(5, animal.getId_tipo_animal());
            stmt.setString(6, animal.getId_porte());
            stmt.setString(7, animal.getId_raca());
            stmt.execute();
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
    * metodo responsavel por buscar todos os animais cadastrados na base de dados
    * e retorna-los em um array.
    * @return ArrayList<Animal>
    * @throws SQLException 
    */
    
    public ArrayList<Animal> buscarAnimal(QueryFactory gera) throws SQLException, ClassNotFoundException
    {
        
        ArrayList<Animal> listaAnimal = new ArrayList();
        Connection con = new ConnectionFactory().getConnection();
        try
        {
            String query =  "SELECT " +
                            "ANIMAL.ID_ANIMAL, " +
                            "CLIENTE.NOME AS 'DONO', " +
                            "ANIMAL.NOME  AS 'NOME', " +
                            "ANIMAL.COR   AS 'COR', " +
                            "ANIMAL.IDADE AS 'IDADE', " +
                            "TIPO_ANIMAL.DESCRICAO AS 'TIPO', " +
                            "PORTE.DESCRICAO 'PORTE', " +
                            "RACA.DESCRICAO  'RACA', " +
                            "ANIMAL.STATUS  " +
                            "FROM ANIMAL " +
                            "INNER JOIN CLIENTE " +
                            "ON ANIMAL.ID_CLIENTE = CLIENTE.ID_CLIENTE " +
                            "INNER JOIN TIPO_ANIMAL " +
                            "ON ANIMAL.ID_TIPO_ANIMAL = TIPO_ANIMAL.ID_TIPO_ANIMAL " +
                            "INNER JOIN PORTE " +
                            "ON ANIMAL.ID_PORTE = PORTE.ID_PORTE " +
                            "INNER JOIN RACA " +
                            "ON ANIMAL.ID_RACA = RACA.ID_RACA ";
            
            query += gera.getQuery();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt = gera.preparQuery(stmt);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Animal animal = new Animal();
                animal.setId_animal(rs.getInt("ID_ANIMAL"));
                animal.setId_cliente(rs.getString("DONO"));
                animal.setNome(rs.getString("NOME"));
                animal.setCor(rs.getString("COR"));
                animal.setIdade(rs.getInt("IDADE"));
                animal.setId_tipo_animal(rs.getString("TIPO"));
                animal.setId_porte(rs.getString("PORTE"));
                animal.setId_raca(rs.getString("RACA"));
                listaAnimal.add(animal);
            }
            rs.close();
            stmt.close();
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
    
    public void alterarAnimal(Animal animal) throws SQLException, ClassNotFoundException
    {
        Connection con = new ConnectionFactory().getConnection();
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
            stmt.setString(4, animal.getId_tipo_animal());
            stmt.setString(5, animal.getId_porte());
            stmt.setString(6, animal.getId_raca());
            stmt.setInt(7, animal.getId_animal());
            stmt.execute();
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
    
    public void inativarCliente(Animal animal) throws SQLException, ClassNotFoundException
    {
        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = con.prepareStatement("UPDATE ANIMAL SET (status) "
                                                            + "VALUES (?)"
                                                            + "WHERE ID_ANIMAL =?");
        
        stmt.setInt(1, animal.getStatus_inativo());
        stmt.setInt(2, animal.getId_animal());
        
    }
    
}
