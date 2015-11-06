/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petmania.cadastros.model;

/**
 *
 * @author felipe.smagalhaes
 */
public class Funcionario extends Pessoa
{
    private int id_funcionario = 0;
    private int id_tipo_funcionario = 0;
    private int Status = 0;
    private double salario = 0d;

    /**
     * @return the id_funcionario
     */
    public int getId_funcionario() {
        return id_funcionario;
    }

    /**
     * @param id_funcionario the id_funcionario to set
     */
    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    /**
     * @return the salario
     */
    public double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * @return the id_tipo_funcionario
     */
    public int getId_tipo_funcionario() {
        return id_tipo_funcionario;
    }

    /**
     * @param id_tipo_funcionario the id_tipo_funcionario to set
     */
    public void setId_tipo_funcionario(int id_tipo_funcionario) {
        this.id_tipo_funcionario = id_tipo_funcionario;
    }

    /**
     * @return the Status
     */
    public int getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(int Status) {
        this.Status = Status;
    }
}
