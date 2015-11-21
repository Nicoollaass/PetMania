/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.carrinho.logica;
import br.com.petmania.model.Produto;

/**
 *
 * @author Nicolas
 */
public class Item {
    
    private Produto produto;
    private int quantidade;
    
    /*
    *@param produto a ser adicionado no carrinho
    *@param quantidade do produto a ser levado
    */
    public Item(Produto produto,int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }
    
    /*
    *@return produto que está sendo comprado
    */
    public Produto getProduto(){
        return this.produto;
    }
    
    /*
    *@return quantidade do produto que está sendo comprado
    */
    public int getQuantidade(){
        return this.quantidade;
    }
    
    
}
