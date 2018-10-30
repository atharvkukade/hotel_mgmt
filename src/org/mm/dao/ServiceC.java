package org.mm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.mm.pojo.BillP;
import org.mm.pojo.GuestDetails;
import org.mm.pojo.Room;

public class ServiceC extends UserC
{
	private PreparedStatement selectStatement;
	private PreparedStatement selectStatement1;
	private PreparedStatement updateStatement;
	public GuestDetails getGuest(int roomNo,Date currentDate) throws Exception
	{
		this.selectStatement = conn.prepareStatement("SELECT * FROM Guest WHERE roomDateID in (SELECT roomDateID FROM RoomDates WHERE roomNo=? AND checkInDate<=? AND checkOutDate>=?)");
		SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
		
		this.selectStatement.setInt(1,roomNo);
		this.selectStatement.setString(2, smf.format(currentDate));
		this.selectStatement.setString(3, smf.format(currentDate));
		
		ResultSet  rs = this.selectStatement.executeQuery();
		rs.next();
		return new GuestDetails(rs.getInt(1),rs.getInt("noOfAdults"),rs.getInt("noOfMinors"),rs.getInt("roomDateID"),rs.getString("name"),rs.getString("email"),rs.getString("phoneNo"),rs.getString("city"),rs.getString("state"),rs.getString("country"));
	}
	public Room getRoom(int roomNo) throws Exception
	{
		this.selectStatement1 = conn.prepareStatement("SELECT * FROM Room WHERE roomNo=?");
		this.selectStatement1.setInt(1, roomNo);
		ResultSet rs = this.selectStatement1.executeQuery();
		rs.next();
		return new Room(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
	}
	public int updateLaudryCost(double laundryCost,int billID) throws Exception
	{	
		BillP b = new BillC().getBill(billID) ;
		
		this.updateStatement = conn.prepareStatement("UPDATE Bill SET laundryCost=? where ID=?");
		this.updateStatement.setDouble(1, (b.getLaundryCost() + laundryCost ) );
		this.updateStatement.setInt(2, billID);
		return this.updateStatement.executeUpdate() ;
	}
}
