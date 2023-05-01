package com.workshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcExample {
    //JDBC stands for Java Database Connectivity. It is a Java API (Application Programming Interface) that enables Java programs to interact with databases.
    //JDBC provides a set of classes and interfaces that allow Java applications to connect to a database, send SQL queries to the database, and process the results.
    // It allows Java programs to work with various types of relational databases, such as MySQL
    //we follow these following steps to set databse and do operations on it.
    //Step 1: Load Driver to Project (Jar file/Maven Dependency) for mysql

    //Step 2:  Create Connection to database

    //Step 3: Create Statement Object using connection to execute queries.
    //   The createStatement() method of Connection interface is used to create statement.
    //   The object of statement is responsible to execute queries with the database.
    //Step 4: Exceute queries using methods of Statement class
    //   executeQuery  method returns the object of ResultSet that can be used to get all the records of a table.
    //Step 5: Print Result  if Any using Result Set class
    //   ResultSet set = stmt.executeQuery("select * from employee_payroll");
    //Step 6: Close the connection to Database.
            //connection.close();
    public static void main(String[] args) {
        try {
            //Step 1 and Step 2
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service", "root", "");
            //Step 3
            Statement statement = connection.createStatement();
            //Step 4
            //statement.execute("CREATE TABLE collage(clg_id int auto_increment primary key,clg_name varchar(50),clg_board varchar(50));");
            statement.executeUpdate("INSERT INTO collage(clg_name,clg_board) values ('EATM','BPUT'),('GEC','MIT'),('GITA','BPUT');");
            statement.executeUpdate("UPDATE collage SET clg_board = 'IIT' WHERE clg_name = 'GITA';");


            //step 5
            ResultSet result = statement.executeQuery("select * from collage;");

            while (result.next()) {
                System.out.println("Collage Id: " + result.getInt(1));
                System.out.println("Collage Name: " + result.getString(2));
                System.out.println("Collage Board: " + result.getString(3));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
