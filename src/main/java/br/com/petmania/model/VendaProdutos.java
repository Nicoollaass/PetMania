/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.model;

import com.mysql.fabric.xmlrpc.base.Data;

/**
 *
 * @author HERICK
 */
public class VendaProdutos {

    private int id_venda_produto = 0;
    private int id_cliente_prod = 0;
    private int id_funcionario_prod = 0;
    private Data data_venda;

    public int getId_venda_produto() {
        return id_venda_produto;
    }

    public void setId_venda_produto(int id_venda_produto) {
        this.id_venda_produto = id_venda_produto;
    }

    public int getId_cliente_prod() {
        return id_cliente_prod;
    }

    public void setId_cliente_prod(int id_cliente_prod) {
        this.id_cliente_prod = id_cliente_prod;
    }

    public int getId_funcionario_prod() {
        return id_funcionario_prod;
    }

    public void setId_funcionario_prod(int id_funcionario_prod) {
        this.id_funcionario_prod = id_funcionario_prod;
    }

    public Data getData_venda() {
        return data_venda;
    }

    public void setData_venda(Data data_venda) {
        this.data_venda = data_venda;
    }

}
