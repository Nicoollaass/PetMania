/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.model;

import java.sql.Date;

/**
 *
 * @author Caio
 */
public class Servico {
    
    private String descricao="";
    private Date data_entrada;
    private Date data_inclusao;
    private double preco = 0f;
    private int categoria_servico = 0;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Date getData_inclusao() {
        return data_inclusao;
    }

    public void setData_inclusao(Date data_inclusao) {
        this.data_inclusao = data_inclusao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getCategoria_servico() {
        return categoria_servico;
    }

    public void setCategoria_servico(int categoria_servico) {
        this.categoria_servico = categoria_servico;
    }
    
}
