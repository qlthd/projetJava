/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 20170027
 */
public class BaseDeDonnees {
    private static Connection conn;
    //CTRL + SHIFT + O pour générer les imports
  public BaseDeDonnees(String url, String user, String password) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      this.conn = DriverManager.getConnection(url, user, password);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static ResultSet req(String requete) throws SQLException{
        Statement state = conn.createStatement();
        //L'objet ResultSet contient le résultat de la requête SQL
        ResultSet result = state.executeQuery(requete);
        return result;
   }
  
  public static ResultSet req(PreparedStatement ps) throws SQLException{
        Statement state = conn.createStatement();
        //L'objet ResultSet contient le résultat de la requête SQL
        ResultSet result = ps.executeQuery();
        return result;
   }

  public static PreparedStatement prepare(String query) throws SQLException{
      return conn.prepareStatement(query);
  }

  public static void updateDB(PreparedStatement ps) throws SQLException{
      ps.execute();
  }

  public static void closeDB() throws SQLException{
    BaseDeDonnees.conn.close();
  }

}
