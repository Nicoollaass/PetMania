/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.cadastros.model;

import java.sql.Date;

/**
 *
 * @author Hp
 */
public class Cliente extends Pessoa 
{
    private final int status_inativo = 0; //Variavel utilizada para inativar um cliente. Valor fixo 0
    private int id_cliente = 0;
    private Date data_inclusao; //Campo utilizado apenas para consulta, nao utilizamos para gravar no banco.

    
    
    public int getStatus_Inativo(){
        return status_inativo;
    }
            
    /**
     * @return the id_cliente
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the data_inclusao
     */
    public Date getData_inclusao() {
        return data_inclusao;
    }

    /**
     * @param data_inclusao the data_inclusao to set
     */
    public void setData_inclusao(Date data_inclusao) {
        this.data_inclusao = data_inclusao;
    }
    
}
