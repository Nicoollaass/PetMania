/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.petmania.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nicolas
 */
public class QueryFactory {

    private boolean checkFilter = false;
    private int posStmt;
    private String query;
    private ArrayList<String> valuesFiler;

    public QueryFactory() {
        this.query = "";
        this.posStmt = 1;
        this.valuesFiler = new ArrayList();

    }

    public void geraFilterQuery(String[] values, String condicao) {
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                if (this.query.contains("WHERE")) {
                    query += " OR ";
                } else {
                    query += " WHERE ";
                }
                query += condicao + " = ? ";
                this.valuesFiler.add(values[i]);
            }
        }

        this.checkFilter = true;

    }

    public PreparedStatement preparQuery(PreparedStatement stmt) throws SQLException {
        if (this.query != null) {
            for (String value : valuesFiler) {
                stmt.setString(this.posStmt, value);
                this.posStmt++;
            }
        }
        return stmt;
    }

    public int getPosStm() {
        return posStmt;
    }

    public void resetPos() {
        this.posStmt = 1;
    }

    public String getQuery() {
        return this.query;
    }

    public boolean containsFilter() {
        return this.checkFilter;
    }

}
