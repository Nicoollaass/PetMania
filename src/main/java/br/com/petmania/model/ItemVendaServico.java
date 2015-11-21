/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.model;

/**
 *
 * @author HERICK
 */
public class ItemVendaServico {
    private int id_item_servico = 0;
    private int id_venda_servico = 0;
    private int id_servico = 0;
    private int quantidade = 0;
    private double preco_total = 0f;

    public int getId_item_servico() {
        return id_item_servico;
    }

    public void setId_item_servico(int id_item_servico) {
        this.id_item_servico = id_item_servico;
    }

    public int getId_venda_servico() {
        return id_venda_servico;
    }

    public void setId_venda_servico(int id_venda_servico) {
        this.id_venda_servico = id_venda_servico;
    }

    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco_total() {
        return preco_total;
    }

    public void setPreco_total(double preco_total) {
        this.preco_total = preco_total;
    }
    
    
}
 