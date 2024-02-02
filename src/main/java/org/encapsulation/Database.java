package org.encapsulation;

public class Database {
    public static void main(String[] args) {
        DbConnection dbConnection = DbConnection.getDbConnection();
        System.out.println(dbConnection);

        DbConnection secondDbConnection = DbConnection.getDbConnection();
        System.out.println(secondDbConnection);


    }
}
