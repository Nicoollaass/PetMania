/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.cadastros.dao;


import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.petmania.cadastros.model.Cliente;
import br.com.petmania.cadastros.model.Funcionario;
import br.com.petmania.cadastros.model.Pessoa;
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
      private Connection con;
    
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
    
   }


  public void inserirFuncionario (Funcionario funcionario) throws SQLException
    {
        try
        {
            
            PreparedStatement stmt = con.prepareStatement("INSERT INTO cliente (nome, "
                                                                             + "id_tipo_funcionario, "
                                                                             + "data_nascimento, "
                                                                             + "email, "
                                                                             + "cpf )"
                                                                             
                                                            + "VALUES (?, ?, ?, ?, ?,)");
            
            
            stmt.setString(1, funcionario.getNome());
            stmt.setInt(2, funcionario.getId_tipo_funcionario());
            stmt.setDate(3, funcionario.getData_nascimento());
            stmt.setString(4, funcionario.getEmail());
            stmt.setString(5, funcionario.getCpf());
           
            
            //ResultSet rs = stmt.executeQuery();
            
            //rs.close();
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
  
    public List<Funcionario> buscarFuncionario (Funcionario funcionario) throws SQLException
    {
        
        List<Funcionario> listaFuncionarios = new ArrayList();
        try
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * "
                                                        + "  FROM funcionario");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next())
            {
                funcionario.setCpf(rs.getString("NOME"));
                funcionario.setData_nascimento(rs.getDate("ID_TIPO_FUNCIONARIO"));
                funcionario.setEmail(rs.getString("DATA_NASCIMENTO"));
                funcionario.setIdade(rs.getInt("EMAIL"));
                funcionario.setNome(rs.getString("CPF"));
                funcionario.setSexo(rs.getString("DATA_INCLUSAO"));
                
                
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
   public void alterarFuncionario(Funcionario funcionario) throws SQLException
    {
        
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
    public void inativarFuncionario(Funcionario funcionario) throws SQLException
    {
        
        
        
        PreparedStatement stmt = con.prepareStatement("UPDATE CLIENTE SET (status) "
                                                            + "VALUES (?)"
                                                            + "WHERE ID_CLIENTE =?");

        stmt.setInt(1, funcionario.getStatus());
        stmt.setInt(2, funcionario.getId_funcionario());
    }
    
}
  
