/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.model;

/**
 *
 * @author felipe.smagalhaes
 */
public class Animal 
{
    private int id_animal = 0;
    private String id_cliente = null; 
    private String nome = "";
    private String cor = "";
    private int idade = 0;
    private String id_tipo_animal = null;
    private String data_inclusao = "";
    private String id_porte = null;
    private String id_raca = null;
    private int status_inativo = 0; //Valor fixo para excluir/inativar o cliente

    
    
    
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
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the id_tipo_animal
     */
    public String getId_tipo_animal() {
        return id_tipo_animal;
    }

    /**
     * @param id_tipo_animal the id_tipo_animal to set
     */
    public void setId_tipo_animal(String id_tipo_animal) {
        this.id_tipo_animal = id_tipo_animal;
    }

    /**
     * @return the data_inclusao
     */
    public String getData_inclusao() {
        return data_inclusao;
    }

    /**
     * @param data_inclusao the data_inclusao to set
     */
    public void setData_inclusao(String data_inclusao) {
        this.data_inclusao = data_inclusao;
    }

    /**
     * @return the id_porte
     */
    public String getId_porte() {
        return id_porte;
    }

    /**
     * @param id_porte the id_porte to set
     */
    public void setId_porte(String id_porte) {
        this.id_porte = id_porte;
    }

    /**
     * @return the id_raca
     */
    public String getId_raca() {
        return id_raca;
    }

    /**
     * @param id_raca the id_raca to set
     */
    public void setId_raca(String id_raca) {
        this.id_raca = id_raca;
    }

    /**
     * @return the id_cliente
     */
    public String getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the id_animal
     */
    public int getId_animal() {
        return id_animal;
    }

    /**
     * @param id_animal the id_animal to set
     */
    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    /**
     * @return the status_inativo
     */
    public int getStatus_inativo() {
        return status_inativo;
    }

    /**
     * @param status_inativo the status_inativo to set
     */
    public void setStatus_inativo(int status_inativo) {
        this.status_inativo = status_inativo;
    }
    
    
    
    
}


