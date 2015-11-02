/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.cadastros.model;

/**
 *
 * @author felipe.smagalhaes
 */
public class Animal 
{
    private String nome = "";
    private String cor = "";
    private int idade = 0;
    private int id_tipo_animal = 0;
    private String data_inclusao = "";
    private int id_porte = 0;
    private int id_raca = 0;

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
    public int getId_tipo_animal() {
        return id_tipo_animal;
    }

    /**
     * @param id_tipo_animal the id_tipo_animal to set
     */
    public void setId_tipo_animal(int id_tipo_animal) {
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
    public int getId_porte() {
        return id_porte;
    }

    /**
     * @param id_porte the id_porte to set
     */
    public void setId_porte(int id_porte) {
        this.id_porte = id_porte;
    }

    /**
     * @return the id_raca
     */
    public int getId_raca() {
        return id_raca;
    }

    /**
     * @param id_raca the id_raca to set
     */
    public void setId_raca(int id_raca) {
        this.id_raca = id_raca;
    }
    
    
    
    
}


