package org.encapsulation;

public class DbConnection {
    private static DbConnection dbConnection = new DbConnection();

    private DbConnection(){

    }

    public static DbConnection getDbConnection(){
        if(dbConnection == null){
            dbConnection = new DbConnection();
        }
        return dbConnection;
    }
}
