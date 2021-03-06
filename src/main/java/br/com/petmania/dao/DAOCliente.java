/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.dao;

import br.com.senac.petmania.utils.ConnectionFactory;
import br.com.petmania.model.Cliente;
import br.com.petmania.model.Pessoa;
import br.com.senac.petmania.utils.Contantes;
import br.com.senac.petmania.utils.Utils;
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
    
    
    
    
    public DAOCliente() 
    {
       
    }
    
    /**
     * Metodo responsavel para inserir novos clientes na base de dados
     * @param cliente
     * @throws SQLException 
     */
    public void inserirCliente (Cliente cliente) throws SQLException, ClassNotFoundException
    {
        
        Date data = null;
        
        //Timestamp stamp = new Timestamp(data.getDate());
        
        cliente.setData_inclusao(data);
        Connection con = new ConnectionFactory().getConnection();
        
        try
        {
            
            PreparedStatement stmt = con.prepareStatement("INSERT INTO cliente (nome, "
                                                                             + "idade, "
                                                                             + "data_nascimento, "
                                                                             + "email, "
                                                                             + "cpf, "
                                                                             + "sexo, "
                                                                             + "telefone) "                                                                             
                                                            + "VALUES (?, ?, ?, ?, ?, ?, ?)");
            
            
            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, cliente.getIdade());
            stmt.setDate(3, cliente.getData_nascimento());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getCpf());
            stmt.setString(6, cliente.getSexo());
            stmt.setString(7, cliente.getTelefone());
            stmt.execute();
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
     * @return ArrayList<Cliente>
     * @throws SQLException 
     */
    public ArrayList<Cliente> buscarCliente () throws SQLException, ClassNotFoundException
    {   
        ArrayList<Cliente> listaClientes = new ArrayList();
        Connection con = new ConnectionFactory().getConnection();
        try
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * "
                                                        + "  FROM CLIENTE"
                                                        + " WHERE STATUS = 1"
                                                        + " ORDER BY nome ASC");
            
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
            rs.close();
            stmt.close();
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
    * metodo responsavel por buscar um cliente na base de dados
    * @return Cliente
    * @throws SQLException 
    */
    public Cliente getCliente (int id) throws SQLException, ClassNotFoundException
    {   
        Cliente cliente = null;
        Connection con = new ConnectionFactory().getConnection();
        try
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * "
                                                        + "FROM CLIENTE "
                                                        + "WHERE ID_CLIENTE = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                cliente = new Cliente();
                cliente.setCpf(rs.getString("CPF"));
                cliente.setData_nascimento(rs.getDate("DATA_NASCIMENTO"));
                cliente.setEmail(rs.getString("EMAIL"));
                cliente.setIdade(rs.getInt("IDADE"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setSexo(rs.getString("SEXO"));
                cliente.setTelefone(rs.getString("TELEFONE"));
                cliente.setData_inclusao(rs.getDate("DATA_INCLUSAO"));
                cliente.setId_cliente(rs.getInt("ID_CLIENTE"));
            }
            rs.close();
            stmt.close();
        }
        
        catch(SQLException e)
        {
            throw new SQLException ("Erro ao buscar os clientes na base de dados. ", e);            
        }
        
        finally
        {
            con.close();
        }
        
        
        return cliente;
    }
    
    /**
     * Metodo responsavel por alterar um registro na base de dados com base no seu ID.
     * @param cliente 
     */
    public void alterarCliente(Cliente cliente) throws SQLException, ClassNotFoundException
    {
        Connection con = new ConnectionFactory().getConnection();
        try
        {
            
            PreparedStatement stmt = con.prepareStatement("UPDATE CLIENTE SET  NOME=?, "
                                                                             + "IDADE=?, "
                                                                             + "DATA_NASCIMENTO=?, "
                                                                             + "EMAIL=?, "
                                                                             + "CPF=?, "
                                                                             + "SEXO=?, "
                                                                             + "TELEFONE=? "
                                                            + "WHERE ID_CLIENTE = ?");
            
            System.out.println(stmt.toString());
            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, cliente.getIdade());
            stmt.setDate(3, cliente.getData_nascimento());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getCpf());
            stmt.setString(6, cliente.getSexo());
            stmt.setString(7, cliente.getTelefone());
            stmt.setInt(8, cliente.getId_cliente());            
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e)
        {
            throw new SQLException("Erro ao alterar o cadastro do cliente selecionado! ", e.getMessage());
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
    public void inativarCliente(Contantes contante, int id) throws SQLException, ClassNotFoundException
    {        
        Connection con = new ConnectionFactory().getConnection();
        try
        {
            
            PreparedStatement stmt = con.prepareStatement("UPDATE CLIENTE SET status=? "
                                                                + "WHERE ID_CLIENTE =?");
            stmt.setInt(1, contante.getStatus_Inativo());
            stmt.setInt(2, id);           
            stmt.execute();
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
    
}
