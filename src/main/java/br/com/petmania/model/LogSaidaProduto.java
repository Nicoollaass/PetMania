/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.model;

import java.util.Date;

/**
 *
 * @author Caio
 */
public class LogSaidaProduto {

    private int id_log_saida_produto = 0;
    private int id_venda_produto = 0;
    private Date data_alteracao;

    public int getId_log_saida_produto() {
        return id_log_saida_produto;
    }

    public void setId_log_saida_produto(int id_log_saida_produto) {
        this.id_log_saida_produto = id_log_saida_produto;
    }

    public int getId_venda_produto() {
        return id_venda_produto;
    }

    public void setId_venda_produto(int id_venda_produto) {
        this.id_venda_produto = id_venda_produto;
    }

    public Date getData_alteracao() {
        return data_alteracao;
    }

    public void setData_alteracao(Date data_alteracao) {
        this.data_alteracao = data_alteracao;
    }

}
