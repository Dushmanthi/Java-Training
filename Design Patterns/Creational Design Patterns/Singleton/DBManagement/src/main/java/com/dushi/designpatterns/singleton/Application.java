package com.dushi.designpatterns.singleton;

import java.sql.Connection;

public class Application {
    public static void main(String[] args) {
        long start;
        long end;

        DBManager dbManager = DBManager.getDbManager();
        System.out.println(dbManager);

        start=System.currentTimeMillis();
        Connection connection=dbManager.getConnection();
        end=System.currentTimeMillis();
        System.out.println("Spent time for the connection in dbManager to create this instance: "+ (end-start));

        DBManager dbManager1 = DBManager.getDbManager();
        System.out.println(dbManager1);

        start=System.currentTimeMillis();
        Connection connection1=dbManager1.getConnection();
        end=System.currentTimeMillis();
        System.out.println("Spent time for the connection in dbManager1 to create this instance: "+ (end-start));


    }
}
