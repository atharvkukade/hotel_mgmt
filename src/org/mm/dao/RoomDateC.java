package org.mm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RoomDateC extends UserC
{
	private PreparedStatement updateStaement;
	private PreparedStatement selectStatement;
	
	public int updateCheckOutDate( int roomDateId , Date checkOutDate ) throws SQLException
	{
		this.updateStaement = conn.prepareStatement("UPDATE RoomDates SET checkOutDate = ? where roomDateID = ?") ;
		SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd") ;
		this.updateStaement.setString(1, smf.format(checkOutDate));
		this.updateStaement.setInt(2, roomDateId);
		return this.updateStaement.executeUpdate() ;
	}
	public ResultSet getRoomDateRow(int roomDateID ) throws Exception
	{
		this.selectStatement = conn.prepareStatement("Select * from RoomDates where roomDateID = ?") ;
		this.selectStatement.setInt(1, roomDateID);
		ResultSet rs = this.selectStatement.executeQuery() ;
		rs.next();
		return rs ;
	}
}
