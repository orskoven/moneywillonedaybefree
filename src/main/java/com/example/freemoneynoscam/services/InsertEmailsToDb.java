package com.example.freemoneynoscam.services;


import java.sql.*;


public class InsertEmailsToDb {
     static int rs;
     static Connection con;



     public static void connectToDb(){

         try {
             //Define URL of database server for database named test_hotel
             //on the localhost with the default port number 3306.
             String url = "jdbc:mysql://localhost:3306/free_money";

             con = DriverManager.getConnection(url, "root", "");

             //Display the URL and connection information
             System.out.println("URL: " + url);
             System.out.println("Det gik bra!");

         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }


     }
    public static void insertEmailToDb(String email) throws SQLException {
        Statement stmt = con.createStatement();
        String  sqlString =  "INSERT INTO user_email (`emails`) VALUES ('" + email + "');";
        rs = stmt.executeUpdate(sqlString);

    }




        /*
        CREATE TABLE `free_money`.`user_email` (
  `iduser_emails` INT NOT NULL AUTO_INCREMENT,
  `emails` VARCHAR(45) NOT NULL,
        PRIMARY KEY (`iduser_emails`));


         */
}
