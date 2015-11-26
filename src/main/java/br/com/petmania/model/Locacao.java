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
public class Locacao {
    
    private int id_locacao = 0;
    private String descricao = "";

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
