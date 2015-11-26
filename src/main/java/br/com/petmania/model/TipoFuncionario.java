/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.model;

/**
 *
 * @author Hp
 */
public class TipoFuncionario {
    
    private int id_tipo_funcionario = 0;
    private String descricao = "";

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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
