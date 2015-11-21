/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.carrinho.logica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nicolas
 */

public class Carrinho {
    
    private List<Item> itens = new ArrayList<Item>();
    private Double total = 0.0;
    
    public void adiciona(Item item) {
        itens.add(item);
        total += item.getProduto().getPreco() * item.getQuantidade();
    }
    
    public Integer getTotalDeItens() {
        return itens.size();
    }
    
    public void remove(int indiceItem) {
        Item removido = itens.remove(indiceItem);
        total -= removido.getProduto().getPreco() * removido.getQuantidade();
    }
    
}
