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
public class EstoqueProduto {
    private int id_estoque_prod = 0;
    private int id_produto_estoque = 0;
    private int quantidade = 0;

    public int getId_estoque_prod() {
        return id_estoque_prod;
    }

    public void setId_estoque_prod(int id_estoque_prod) {
        this.id_estoque_prod = id_estoque_prod;
    }

    public int getId_produto_estoque() {
        return id_produto_estoque;
    }

    public void setId_produto_estoque(int id_produto_estoque) {
        this.id_produto_estoque = id_produto_estoque;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
