/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.model;

import java.sql.Date;

/**
 *
 * @author HERICK
 */
public class EstoqueProduto {
    private int id_estoque_prod = 0;
    private Produto produto; 
    private int quantidade = 0;
    private double valor_uni = 0;

   
    
    public EstoqueProduto(
            int id,String nome, 
            String descricao, 
            Date dataEntrada, 
            Date dataInclusao, 
            Double preco,
            int id_categoria, 
            int id_marca
    ){
        this.produto = new Produto();
        this.produto.setId_produto(id);
        this.produto.setNome(nome);
        this.produto.setDescricao(descricao);
        this.produto.setData_entrada(dataEntrada);
        this.produto.setData_inclusao(dataInclusao);
        this.produto.setPreco(preco);
        this.produto.setId_categoria(id_categoria);
        this.produto.setId_marca(id_marca);
    }
    

    public int getId_estoque_prod() {
        return id_estoque_prod;
    }

    public void setId_estoque_prod(int id_estoque_prod) {
        this.id_estoque_prod = id_estoque_prod;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public Produto getProduto() {
        return this.produto;
    }
    
}
