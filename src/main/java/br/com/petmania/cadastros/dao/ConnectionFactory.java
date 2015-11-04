package br.com.petmania.cadastros.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private String host = "localhost:3306";
    private String user = "root";
    private String pass = "";
    private String database = "pet_mania" ;
    
    //retorna uma conexão para utilizar seus metodos
    public Connection getConnection() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
            "jdbc:mysql://"+host+"/"+this.database,this.user,this.pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
