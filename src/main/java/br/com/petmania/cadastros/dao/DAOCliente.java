/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.cadastros.dao;

import br.com.petmania.cadastros.model.Cliente;
import br.com.petmania.cadastros.model.Pessoa;
import br.com.senac.petmania.cadastros.utils.Utils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hp
 */
public class DAOCliente
{
    
    private Connection con;
    
    public DAOCliente() 
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
     * Metodo responsavel para inserir novos clientes na base de dados
     * @param cliente
     * @throws SQLException 
     */
    public void inserirCliente (Cliente cliente) throws SQLException
    {
        
        Date data = null;
        
        //Timestamp stamp = new Timestamp(data.getDate());
        
        cliente.setData_inclusao(data);
        
        try
        {
            
            PreparedStatement stmt = con.prepareStatement("INSERT INTO cliente (nome, "
                                                                             + "idade, "
                                                                             + "data_nascimento, "
                                                                             + "email, "
                                                                             + "cpf, "
                                                                             + "sexo, "
                                                                             + "telefone) "
                                                                             
                                                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            
            
            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, cliente.getIdade());
            stmt.setDate(3, cliente.getData_nascimento());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getCpf());
            stmt.setString(6, cliente.getSexo());
            stmt.setString(7, cliente.getTelefone());
           // stmt.setDate(8, data);
            
            //ResultSet rs = stmt.executeQuery();
            
            //rs.close();
            stmt.close();
        }
        catch(SQLException e)
        {
            throw new SQLException("Erro ao inserir um novo cliente na base de dados. ", e);
        }
        finally
        {
            con.close();
        }
    }
    
    /**
     * metodo responsavel por buscar todos os clientes cadastrados na base de dados
     * e retorna-los em um array.
     * @param cliente
     * @return
     * @throws SQLException 
     */
    public ArrayList<Cliente> buscarCliente () throws SQLException
    {   
        ArrayList<Cliente> listaClientes = new ArrayList();
        try
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * "
                                                        + "  FROM CLIENTE");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Cliente cliente = new Cliente();
                cliente.setCpf(rs.getString("CPF"));
                cliente.setData_nascimento(rs.getDate("DATA_NASCIMENTO"));
                cliente.setEmail(rs.getString("EMAIL"));
                cliente.setIdade(rs.getInt("IDADE"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setSexo(rs.getString("SEXO"));
                cliente.setTelefone(rs.getString("TELEFONE"));
                cliente.setData_inclusao(rs.getDate("DATA_INCLUSAO"));
                cliente.setId_cliente(rs.getInt("ID_CLIENTE"));
                listaClientes.add(cliente);
            }
        }
        
        catch(SQLException e)
        {
            throw new SQLException ("Erro ao buscar os clientes na base de dados. ", e);
            
        }
        finally
        {
            con.close();
        }
        
        return listaClientes;
    }
    
    /**
     * Metodo responsavel por alterar um registro na base de dados com base no seu ID.
     * @param cliente 
     */
    public void alterarCliente(Cliente cliente) throws SQLException
    {
        
        try
        {
            
            PreparedStatement stmt = con.prepareStatement("UPDATE CLIENTE SET (nome, "
                                                                             + "idade, "
                                                                             + "data_nascimento, "
                                                                             + "email, "
                                                                             + "cpf, "
                                                                             + "sexo, "
                                                                             + "telefone) "
                                                            + "VALUES (?, ?, ?, ?, ?, ?, ?) "
                                                            + "WHERE ID_CLIENTE = ?");
            
            
            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, cliente.getIdade());
            stmt.setDate(3, cliente.getData_nascimento());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getCpf());
            stmt.setString(6, cliente.getSexo());
            stmt.setString(7, cliente.getTelefone());
            stmt.setInt(8, cliente.getId_cliente());
            ResultSet rs = stmt.executeQuery();
            
            rs.close();
            stmt.close();
        }
        catch(SQLException e)
        {
            throw new SQLException("Erro ao alterar o cadastro do cliente selecionado! ", e);
        }
        finally
        {
            con.close();
        }
        
    }
    
    /**
     * Metodo responsavel por inativar um cliente em nossa base de dados, por regra de negocio,
     * nao excluimos nenhum registro, sendo assim, mantendo um histórico e a integridade do banco.
     * @param cliente
     * @throws SQLException 
     */
    public void inativarCliente(Cliente cliente) throws SQLException
    {
        
        
        
        PreparedStatement stmt = con.prepareStatement("UPDATE CLIENTE SET (status) "
                                                            + "VALUES (?)"
                                                            + "WHERE ID_CLIENTE =?");

        stmt.setInt(1, cliente.getStatus_Inativo());
        stmt.setInt(2, cliente.getId_cliente());
    }
    
}
