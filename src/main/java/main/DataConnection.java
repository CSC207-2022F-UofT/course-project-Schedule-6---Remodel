package main;
import java.sql.Connection;
import java.sql.DriverManager;



public class DataConnection {
    public Connection databaseuser;

    public Connection getConnection(){
        String databaseUser = "root";
        String databasePassword = "root";
        String url = "jdbc:mysql://localhost:3306/database";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseuser = DriverManager.getConnection(url, databaseUser, databasePassword);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return databaseuser;
    }
}