/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.dao;


import br.com.senac.petmania.utils.ConnectionFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.petmania.model.Cliente;
import br.com.petmania.model.Funcionario;
import br.com.petmania.model.Pessoa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HERICK
 */
public class DAOFuncionario 


{
      


  public void inserirFuncionario (Funcionario funcionario) throws SQLException, ClassNotFoundException
    {

        Connection con = new ConnectionFactory().getConnection();
        try
        {
            
            PreparedStatement stmt = con.prepareStatement("INSERT INTO funcionario (nome, "
                                                                             + "id_tipo_funionario, "
                                                                             + "data_nascimento, "
                                                                             + "email, "
                                                                             + "cpf,"
                                                                             + "id_locacao )" 
                                                                             
                                                            + "VALUES (?, ?, ?, ?, ?, ?)");
            
            
            stmt.setString(1, funcionario.getNome());
            stmt.setInt(2, funcionario.getId_tipo_funcionario());
            stmt.setDate(3, funcionario.getData_nascimento());
            stmt.setString(4, funcionario.getEmail());
            stmt.setString(5, funcionario.getCpf());
            stmt.setInt(6, funcionario.getId_locacao());
           
            
            //ResultSet rs = stmt.executeQuery();
            
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e)
        {
            throw new SQLException("Erro ao inserir um novo Funcionário na base de dados. ", e);
        }
        finally
        {
            con.close();
        }
    }
  
    public List<Funcionario> buscarFuncionario () throws SQLException, ClassNotFoundException
    {
        
        Connection con = new ConnectionFactory().getConnection();
        

        List<Funcionario> listaFuncionarios = new ArrayList();
        try
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * "
                                                        + "  FROM funcionario");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Funcionario funcionario = new Funcionario();
                
                funcionario.setId_funcionario(rs.getInt("ID_FUNCIONARIO"));
                funcionario.setCpf(rs.getString("CPF"));
                funcionario.setData_nascimento(rs.getDate("DATA_NASCIMENTO"));
                funcionario.setId_locacao(rs.getInt("ID_LOCACAO"));
                funcionario.setEmail(rs.getString("EMAIL"));
                //funcionario.setIdade(rs.getInt("IDADE"));
                funcionario.setNome(rs.getString("NOME"));
                
                
                
                listaFuncionarios.add(funcionario);
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
        
        return listaFuncionarios;
    }
   public void alterarFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException
    {
        Connection con = new ConnectionFactory().getConnection();
        try
        {
            
             
            PreparedStatement stmt = con.prepareStatement("INSERT INTO cliente (nome, "
                                                                             + "id_tipo_funcionario, "
                                                                             + "data_nascimento, "
                                                                             + "email, "
                                                                             + "cpf) "
                                                                             
                                                            + "VALUES (?, ?, ?, ?, ?,)");
            
            
            stmt.setString(1, funcionario.getNome());
            stmt.setInt(2, funcionario.getId_tipo_funcionario());
            stmt.setDate(3, funcionario.getData_nascimento());
            stmt.setString(4, funcionario.getEmail());
            stmt.setString(5, funcionario.getCpf());
           
          
            stmt.close();
        }
        catch(SQLException e)
        {
            throw new SQLException("Erro ao alterar o cadastro do funcionario selecionado! ", e);
        }
        finally
        {
            con.close();
        }
        
    }
   
     /**
     * Metodo responsavel por inativar um cliente em nossa base de dados, por regra de negocio,
     * nao excluimos nenhum registro, sendo assim, mantendo um histórico e a integridade do banco.
     * @param funcionario
     * @throws SQLException 
     */
    public void inativarFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException
    {
        
        
         Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = con.prepareStatement("UPDATE CLIENTE SET (status) "
                                                            + "VALUES (?)"
                                                            + "WHERE ID_CLIENTE =?");

        stmt.setInt(1, funcionario.getStatus());
        stmt.setInt(2, funcionario.getId_funcionario());
    }
    
}
  
