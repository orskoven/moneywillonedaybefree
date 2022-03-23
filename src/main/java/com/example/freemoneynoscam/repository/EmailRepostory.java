package com.example.freemoneynoscam.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



import java.sql.*;
import java.util.Random;

public class EmailRepostory {
       static Random rnd = new Random();
        static ResultSet rs;
        static Connection con;



        public static void connectToDb(){

            try {
                //Define URL of database server for database named test_hotel
                //on the localhost with the default port number 3306.
                String url = "jdbc:mysql://localhost:3306/free_money";

                con = DriverManager.getConnection(url, "root", "aqs81rqKk");

                //Display the URL and connection information
                System.out.println("URL: " + url);
                System.out.println("Det gik bra!");

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }
        public static String fetchSingleEmail() throws SQLException {
            String fetchedEmail = "";
            String lastIdNmb = "";
            Statement stmt = con.createStatement();
            String sqlGetLastId = "SELECT MAX(iduser_emails) FROM user_email;";
            rs = stmt.executeQuery(sqlGetLastId);
            while (rs.next()) {
                lastIdNmb = rs.getString("MAX(iduser_emails)");
            }
            String  sqlString =  "SELECT * FROM user_email WHERE iduser_emails=" + rnd.nextInt(Integer.parseInt(lastIdNmb)) + ";";
            rs = stmt.executeQuery(sqlString);
            while (rs.next()) {
                fetchedEmail = rs.getString("emails");
            }
            return fetchedEmail;
        }




        /*
        CREATE TABLE `free_money`.`user_email` (
  `iduser_emails` INT NOT NULL AUTO_INCREMENT,
  `emails` VARCHAR(45) NOT NULL,
        PRIMARY KEY (`iduser_emails`));


         */
    }

