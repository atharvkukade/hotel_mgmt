package org.mm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.mm.pojo.BillP;
import org.mm.pojo.GuestDetails;

//Setting Current Date as checkout method

public class BillC extends UserC
{
	private PreparedStatement selectStatement;
	private PreparedStatement updateStatement;
	
	public GuestDetails getGuest( int roomNo , Date currDate ) throws SQLException
	{
		this.selectStatement = conn.prepareStatement("SELECT * FROM Guest WHERE roomDateID in (SELECT roomDateID FROM RoomDates WHERE roomNo=? AND checkInDate<=? AND checkOutDate>=?)");
		SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
		
		this.selectStatement.setInt(1,roomNo);
		this.selectStatement.setString(2, smf.format(currDate));
		this.selectStatement.setString(3, smf.format(currDate));
		
		ResultSet  rs = this.selectStatement.executeQuery();
		rs.next();
		return new GuestDetails(rs.getInt(1),rs.getInt("noOfAdults"),rs.getInt("noOfMinors"),rs.getInt("roomDateID"),rs.getString("name"),rs.getString("email"),rs.getString("phoneNo"),rs.getString("city"),rs.getString("state"),rs.getString("country"));
	}
	public BillP getBill( int billId ) throws SQLException
	{
		this.selectStatement = conn.prepareStatement("SELECT * from Bill where ID=?");
		this.selectStatement.setInt(1, billId);
		
		ResultSet rs = this.selectStatement.executeQuery() ;
		rs.next();
		
		return new BillP( rs.getInt(1) , rs.getDouble(2) , rs.getDouble(3) , rs.getDouble(4) ) ;
	}
	public int updateFoodCost( GuestDetails gd , int totalFoodCost ) throws SQLException
	{
		BillP bl = getBill(gd.getId()) ;
		
		this.updateStatement = conn.prepareStatement("UPDATE Bill SET foodCost = ? where ID = ?") ;
		this.updateStatement.setDouble(1, new Double( bl.getFoodCost() + totalFoodCost ));
		this.updateStatement.setInt(2, gd.getId());
		
		return this.updateStatement.executeUpdate() ;
	}
	public int updateStayCharges(GuestDetails gd , double stayCharges ) throws SQLException
	{	
		this.updateStatement = conn.prepareStatement("UPDATE Bill SET stayCharges = ? where ID = ?") ;
		
		this.updateStatement.setDouble(1, new Double( stayCharges )); // Stay charges will not be UPDATED, instead it will overridden
		this.updateStatement.setInt(2, gd.getId());
		
		return this.updateStatement.executeUpdate() ;
	}
}
