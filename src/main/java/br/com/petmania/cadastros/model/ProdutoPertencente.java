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
public class ProdutoPertencente {

    private int id_prod_pertencente = 0;
    private int id_tipo_animal = 0;
    private int id_produto = 0;

    public int getId_prod_pertencente() {
        return id_prod_pertencente;
    }

    public void setId_prod_pertencente(int id_prod_pertencente) {
        this.id_prod_pertencente = id_prod_pertencente;
    }

    public int getId_tipo_animal() {
        return id_tipo_animal;
    }

    public void setId_tipo_animal(int id_tipo_animal) {
        this.id_tipo_animal = id_tipo_animal;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

}
