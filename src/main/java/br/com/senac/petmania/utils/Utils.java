/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.utils;


import com.google.gson.Gson;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

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
    public  Date formatarData (String valor) throws Exception
    {
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        java.util.Date data = null;
        java.sql.Date dataSql = null;
        
        try
        {
            data =  format.parse(valor);
            dataSql = new java.sql.Date(data.getTime());
            
        }
        catch(ParseException e)
        {
            throw new Exception("Erro ao converter data. " + e.getMessage());
            
        }
       
        return dataSql;
    }
    
    /**
     * Metodo responsável por transformar um string num inteiro
     * @param valor
     * @return 
     */
    public  int  parseStringInt (String valor) throws Exception
    {   
        int number;
        try
        {
            number = parseInt(valor);
        }
        catch(Exception e)
        {
            throw new Exception("Erro ao converter data. " + e.getMessage());
        }
       
        return number;
    }
    
    
    public String parseJson(Object objeto){
        Gson gson = new Gson();
        // convert java object to JSON format,
        // and returned as JSON formatted string
        String json = gson.toJson(objeto);
        return json;
    }
}
