/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.cadastros.model;

/**
 *
 * @author caio
 */
public class CategoriaServico {
     private int id_categoria_servico = 0;
 private String descricao = "";

    public int getId_categoria_servico() {
        return id_categoria_servico;
    }

    public void setId_categoria_servico(int id_categoria_servico) {
        this.id_categoria_servico = id_categoria_servico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
