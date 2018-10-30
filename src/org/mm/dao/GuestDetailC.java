package org.mm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.mm.pojo.GuestDetails;


public class GuestDetailC extends UserC
{
	private PreparedStatement insertStatementGuestDetails;
	private PreparedStatement insertStatementRoomDates;
	private PreparedStatement selectStatement ;
	private PreparedStatement selectStatement1 ;
	private PreparedStatement updateStatement;
	private PreparedStatement updateStayChargesStatement;
	public int addGuest(GuestDetails g) throws Exception
	{
		this.insertStatementGuestDetails = conn.prepareStatement("insert into Guest(name,city,state,country,phoneNo ,email ,noOfAdults,noOfMinors ) values(?,?,?,?,?,?,?,?)");
		this.insertStatementGuestDetails.setString(1,g.getName());
		this.insertStatementGuestDetails.setString(2,g.getCity());
		this.insertStatementGuestDetails.setString(3,g.getState());
		this.insertStatementGuestDetails.setString(4,g.getCountry());
		this.insertStatementGuestDetails.setString(5,g.getPhoneNo());
		this.insertStatementGuestDetails.setString(6,g.getEmail());
		this.insertStatementGuestDetails.setInt(7,g.getNoOfAdults() );
		this.insertStatementGuestDetails.setInt(8,g.getNoOfMinors() );
		int noOfRowsUpdated = this.insertStatementGuestDetails.executeUpdate();
	
		return  noOfRowsUpdated;	
	}
	public void insertBillID(GuestDetails g) throws Exception
	{
		this.insertStatementRoomDates = conn.prepareStatement("insert into Bill(ID) values(?)");
		this.insertStatementRoomDates.setInt(1, g.getId());
		this.insertStatementRoomDates.executeUpdate();	
	}
	public int getGuestID( GuestDetails g) throws SQLException
	{
		this.selectStatement = conn.prepareStatement("select id from Guest where email=?");
		this.selectStatement.setString(1, g.getEmail());
		ResultSet rs = this.selectStatement.executeQuery();
		rs.next();
		return rs.getInt(1) ;
	}
	public int getRoomDateID(int roomNo , Date checkInDate , Date checkOutDate) 
	{	
		try
		{
			this.insertStatementRoomDates = conn.prepareStatement("insert into RoomDates(roomNo,checkInDate,checkOutDate) values(?,?,?)") ;
			this.insertStatementRoomDates.setInt(1, roomNo);
			SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd") ;
			insertStatementRoomDates.setString(2, smf.format(checkInDate));
			insertStatementRoomDates.setString(3, smf.format(checkOutDate));
			insertStatementRoomDates.executeUpdate();
			
			this.selectStatement = conn.prepareStatement("select roomDateID from RoomDates where roomNo=? and checkInDate=? and checkOutDate=?");
			this.selectStatement.setInt(1, roomNo);
			this.selectStatement.setString(2, smf.format(checkInDate));
			this.selectStatement.setString(3, smf.format(checkOutDate));
			ResultSet rs =this.selectStatement.executeQuery();
			rs.next();
			
			return  rs.getInt(1);
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 1;
	}
	public int updateRoomDateID(GuestDetails g)
	{
		try
		{
			this.insertStatementGuestDetails = conn.prepareStatement("Update Guest set  roomDateID=? where phoneNo=?") ;
			this.insertStatementGuestDetails.setInt(1, g.getRoomDateID());
			this.insertStatementGuestDetails.setString(2, g.getPhoneNo());
			return this.insertStatementGuestDetails.executeUpdate();
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
}
