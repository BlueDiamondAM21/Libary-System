package DAO;

import Main.SqlConnection;

import javax.swing.*;
import java.sql.*;

public class Library_DAO {
    public static <PreparedStatment> int account(String username, String password) {
        int status = 0;
        try {
            Connection conn = SqlConnection.dbConnect();
            PreparedStatement preparedstm = conn.prepareStatement("INSERT INFO Users(username, password) Values(?, ?");

            preparedstm.setString(1, username);
            preparedstm.setString(2, password);

            status = preparedstm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }


    public static boolean checkusername (String username) {

             PreparedStatement preparedstm;
             ResultSet resultset;
             boolean check = false;
             String user = "SELECT * FROM Users WHERE username =?";


        try {
       Connection conn = SqlConnection.dbConnect();
       preparedstm = conn.prepareStatement(user);
       preparedstm.setString(1, username);
       resultset = preparedstm.executeQuery();

       if (resultset.next()) {
           check = true;
       }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return check;
    }
    public static int AddBook(String BookName, String BookAuthor, int BookQuantity) {

        int status = 0;
        try {
            Connection conn =  SqlConnection.dbConnect();
            PreparedStatement preparedstm = conn.prepareStatement("INSERT INTO Books (BookName, BookAuthor, BookQuantity) VALUES (?, ?, ?)");


            preparedstm.setString(1, BookName);
            preparedstm.setString(2, BookAuthor);
            preparedstm.setInt(3, BookQuantity);
            status = preparedstm.executeUpdate();
            conn.close();

        }
        catch(Exception ex) {
            System.out.println(ex);
        }

        return status;
    }







    }
    /*
    public static boolean checkUSername(String username) {
        PreparedStatement preparedstm;
        ResultSet resultset;
        boolean check = false;
    }
    */
