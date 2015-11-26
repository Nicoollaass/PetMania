/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.model;

import java.sql.Date;



/**
 *
 * @author felipe.smagalhaes
 */
public class Funcionario extends Pessoa
{
    private String nome = "";
    private String email = "";
    private String cpf = "";
    private Date data_nascimento = null;
    private int id_funcionario = 0;
    private int id_tipo_funcionario = 0;
    private int id_locacao = 0;
    private int Status = 0;
    

    
    public Date getData_nascimento(){
     return data_nascimento;   
    }
    
    public void setData_nascimento(Date data_nascimento){
        this.data_nascimento = data_nascimento;
    }
    
    /**
     * @return the id_funcionario
     */
    public int getId_funcionario() {
        return id_funcionario;
    }

    /**
     * @param id_funcionario the id_funcionario to set
     */
    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    /**
     * @return the id_tipo_funcionario
     */
    public int getId_tipo_funcionario() {
        return id_tipo_funcionario;
    }

    /**
     * @param id_tipo_funcionario the id_tipo_funcionario to set
     */
    public void setId_tipo_funcionario(int id_tipo_funcionario) {
        this.id_tipo_funcionario = id_tipo_funcionario;
    }

    /**
     * @return the Status
     */
    public int getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(int Status) {
        this.Status = Status;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    /**
     * @return the id_locacao
     */
    public int getId_locacao() {
        return id_locacao;
    }

    /**
     * @param id_locacao the id_locacao to set
     */
    public void setId_locacao(int id_locacao) {
        this.id_locacao = id_locacao;
    }

    
}
