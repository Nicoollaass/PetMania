/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.cadastros.model;

import com.mysql.fabric.xmlrpc.base.Data;
import java.sql.Date;

/**
 *
 * @author caio
 */
public class VendaServico {

    private int id_venda_servico = 0;
    private int id_cliente_servico = 0;
    private int id_funcionario_servico = 0;
    private Data data_venda;

    public int getId_venda_servico() {
        return id_venda_servico;
    }

    public void setId_venda_servico(int id_venda_servico) {
        this.id_venda_servico = id_venda_servico;
    }

    public int getId_cliente_servico() {
        return id_cliente_servico;
    }

    public void setId_cliente_servico(int id_cliente_servico) {
        this.id_cliente_servico = id_cliente_servico;
    }

    public int getId_funcionario_servico() {
        return id_funcionario_servico;
    }

    public void setId_funcionario_servico(int id_funcionario_servico) {
        this.id_funcionario_servico = id_funcionario_servico;
    }

    public Data getData_venda() {
        return data_venda;
    }

    public void setData_venda(Data data_venda) {
        this.data_venda = data_venda;
    }
    
    
}

