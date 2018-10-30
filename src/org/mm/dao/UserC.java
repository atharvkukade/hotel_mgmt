package org.mm.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.mm.pojo.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class UserC
{
	public Connection conn = null;
	private PreparedStatement insertStatement = null;
	private PreparedStatement selectStatement = null;
    public UserC()
  {
      try
      {
          Class.forName("com.mysql.jdbc.Driver");
          conn =DriverManager.getConnection("jdbc:mysql://localhost/HotelBilling","root","root");
          System.out.println("Connection established");
      }
      catch(Exception e)
      {
          System.out.println(e);
      }
  }
    public int insertData(String userName , String password) throws Exception
    {
    	this.insertStatement = conn.prepareStatement("insert into Users(UserName,Password) values(?,?)");
    	insertStatement.setString(1, userName);
    	insertStatement.setString(2, password);
    	return insertStatement.executeUpdate();
    }
    public ResultSet selectData(User u) throws Exception
    {
    	this.selectStatement = conn.prepareStatement("select * from Users where UserName=? and Password=?");
    	selectStatement.setString(1,u.getUserName());
        selectStatement.setString(2,u.getPassword());
        ResultSet rs = selectStatement.executeQuery();
          return rs ;
    }
}
