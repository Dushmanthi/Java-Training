package com.dushi.designpatterns.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static volatile DBManager dbManager;
    private static volatile Connection connection;


    public DBManager() {
        //to stop creating second instance by reflection
        if(dbManager != null){
            throw new RuntimeException("please use getDbManager method");
        }
    }

    //this is not safe to avoid that we can use double checking singleton
  /*  public static DBManager getDbManager() {
        //create new db manage if it null
        if(dbManager == null){
            dbManager = new DBManager();
        }
        return dbManager;
    }

   */

    //double checking singleton
    public static DBManager getDbManager() {
        //create new db manage if it null
        if(dbManager == null){
            //to obtain a log
            synchronized (DBManager.class){
                if(dbManager == null){
                    dbManager = new DBManager();
                }
            }
        }
        return dbManager;
    }

    //get the connection
    public Connection getConnection() {
        if(connection == null){
            synchronized (DBManager.class){
                if(connection == null){
                    String url = "jdbc:derby:memory:sample;create=true";
                    try {
                        connection = DriverManager.getConnection(url);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }
}
