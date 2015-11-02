/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.cadastros.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Hp
 */
public class Utils {
    
    /**
     * Metodo responsável por formatar a data conforme deve ser salvo na base de dados.
     * @param valor
     * @return 
     */
    public Date formatarData (String valor)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        Date data = null;
        
        try
        {
            data = (Date) format.parse(valor);
            
        }
        catch(ParseException e)
        {
            System.out.println("Erro ao converter data. " + e.getMessage());
        }
        return data;
    }
}
