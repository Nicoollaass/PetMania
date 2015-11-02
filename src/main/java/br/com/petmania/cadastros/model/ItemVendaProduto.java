/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.cadastros.model;

/**
 *
 * @author HERICK
 */
public class ItemVendaProduto {
    private int id_item_produto = 0;
    private int id_venda_produto = 0;
    private int id_produto = 0;
    private int quantidade = 0;
    private double preco_total = 0f;

    public int getId_item_produto() {
        return id_item_produto;
    }

    public void setId_item_produto(int id_item_produto) {
        this.id_item_produto = id_item_produto;
    }

    public int getId_venda_produto() {
        return id_venda_produto;
    }

    public void setId_venda_produto(int id_venda_produto) {
        this.id_venda_produto = id_venda_produto;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
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
