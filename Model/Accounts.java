/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MSI GF
 */
public class Accounts {
    private int id;
    private int AccountsNum;
    private int user_id;
    private String UserName;
    private String Currency;
    private double Balance;
    private String CreationDate;

    public Accounts(int AccountsNum,  String UserName, String Currency, double Balance, String CreationDate) {
        this.AccountsNum = AccountsNum;
//        this.user_id = user_id;
        this.UserName = UserName;
        this.Currency = Currency;
        this.Balance = Balance;
        this.CreationDate = CreationDate;
    }

 
    public Accounts(String AccountsNum, String UserName, String Currency, String Balance, String CreationDate) {
    }

    




    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountsNum() {
        return AccountsNum;
    }

    public void setAccountsNum(int AccountsNum) {
        this.AccountsNum = AccountsNum;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

//    public int getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(int user_id) {
//        this.user_id = user_id;
//    }



    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String Currency) {
        this.Currency = Currency;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String CreationDate) {
        this.CreationDate = CreationDate;
    }


    
    
    
    
    
        //create a new user in users table
    public int save() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter =0;
        String sql = "INSERT INTO ACCOUNTS (ID,ACCOUNT_NUMBER,USERNAME,EMAIL,CURRENCY,BALANCE,CREATION_DATE) VALUES (?,?, ?, ?, ?,?,?)";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.id);
//        ps.setInt(2, this.user_id);
        ps.setInt(2, this.AccountsNum);
        ps.setString(3, this.UserName);
        ps.setString(4, this.Currency);
        ps.setDouble(5, this.Balance);
        ps.setString(6, this.CreationDate);
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println(this.getUserName()
                    +" User was added successfully!");
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return recordCounter;  
    }
    //get all accounts from accounts table
     public static ArrayList<Accounts> getAllAccounts() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Accounts> accounts = new ArrayList<>();
        String sql = "SELECT * FROM ACCOUNTS ";
        ps = c.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()){
   
            Accounts account = new Accounts(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6));
             account.setId(rs.getInt(1));
             accounts.add(account);
            
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return accounts;
    }
     
    //update an existing accounts in users table 
    public int update() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter =0;
        String sql = "UPDATE ACCOUNTS SET USER_ID=?, ACCOUNT_NUMBER=?, USERNAME=? , CURRENCY=?,BALANCE=?,CREATION_DATE=? WHERE ID=?";
        ps = c.prepareStatement(sql);
 ps.setInt(1, this.id);
        ps.setInt(2, this.user_id);
        ps.setInt(3, this.AccountsNum);
        ps.setString(4, this.UserName);
        ps.setString(5, this.Currency);
        ps.setDouble(6, this.Balance);
        ps.setString(7, this.CreationDate);
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("Account with id : "+this.getId()+" was updated successfully!");
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return recordCounter;  
    }
    
    //delete an account from users table 
    public int delete() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter =0;
        String sql = "DELETE FROM ACCOUNTS WHERE ID=? ";
        ps = c.prepareStatement(sql);
        ps.setInt(1, this.getId());
        recordCounter = ps.executeUpdate();
        if (recordCounter > 0) {
            System.out.println("The account with id : "+this.getId()+" was deleted successfully!");
        }
        if (ps != null){
            ps.close();
        }
        c.close();
        return recordCounter;  
    }
     
    
    
    
}
