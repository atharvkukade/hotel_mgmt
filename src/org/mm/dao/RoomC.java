package org.mm.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RoomC extends UserC
{
	private PreparedStatement getCountStatement ;
	private PreparedStatement selectStatement;
	private PreparedStatement selectStatement1;
	private PreparedStatement selectStatement2;
	private PreparedStatement selectStatement3;
	private PreparedStatement insertStatement;
	private PreparedStatement updateStatement;
	public int getRowCount() throws Exception
	{
		this.getCountStatement = conn.prepareStatement("select count(roomNo) from Room") ;
		ResultSet rs =this.getCountStatement.executeQuery();
		rs.next() ;
		return rs.getInt(1) ;
	}
	public ResultSet getAllData() throws Exception
	{
		this.selectStatement = conn.prepareStatement("Select * from Room") ;
		return this.selectStatement.executeQuery() ;
	}
	public ResultSet getUnallocatedRooms(Date checkInDate , Date checkOutDate) throws Exception
	{
		this.selectStatement1 = conn.prepareStatement("select * from  Room as R where R.roomNo not in (Select RD.roomNo from RoomDates as RD) ") ;		
		return selectStatement1.executeQuery();
    }
	public int[] getAvailableBookedRooms(Date checkInDate , Date checkOutDate) throws Exception
	{
		this.selectStatement2 = conn.prepareStatement("Select * from RoomDates order by roomNo , checkInDate , checkOutDate") ;
		ResultSet rs = this.selectStatement2.executeQuery();
		rs.next();
		System.out.println("CID : "+checkInDate);
		int currentRoom = rs.getInt(2) ;
		int partiallyConfirmedRoom = 0 , previouslySelected = currentRoom, failedRoom = 0 , endFlag = 0;
		int [] availabeRooms = new int[20];
		int availabeRoomIndex =1;
		int roomDateCounter = getRoomDateCount() ;
    		while(roomDateCounter != 0)
			{
    			if(rs == null || rs.isLast())
    				break;
				while(previouslySelected == currentRoom && (rs != null  ) && endFlag != 1)
				{
					if((rs.getDate(4).before(checkInDate))||((rs.getDate(4).after(checkOutDate))&&(rs.getDate(3).after(checkOutDate))))
					{
						partiallyConfirmedRoom = currentRoom ;
					}
					else
					{
						failedRoom = currentRoom;
					}
					if(rs.next())
					{
						currentRoom = rs.getInt(2) ;
					}
					else
					{
						endFlag = 1; 
					}
				}
				if((previouslySelected == partiallyConfirmedRoom) && (partiallyConfirmedRoom != failedRoom))
				{
					System.out.println("Available Rooms : "+previouslySelected);
					availabeRooms[availabeRoomIndex++] = previouslySelected ;
				}
				previouslySelected = currentRoom ;
				partiallyConfirmedRoom = 0;
				roomDateCounter--;
				failedRoom = 0 ;
			}
    	
    		availabeRooms[0] = availabeRoomIndex ;
    		return availabeRooms ;
	}
	public ResultSet getSelectedData(int roomNo) throws Exception
	{
		this.selectStatement3 = conn.prepareStatement("select * from Room where roomNo=?");
		this.selectStatement3.setInt(1, roomNo);
		return this.selectStatement3.executeQuery();
	}
	public int getRoomDateCount() throws Exception
	{
		this.selectStatement = conn.prepareStatement("Select count(distinct roomNo) from RoomDates");
		ResultSet rs = this.selectStatement.executeQuery() ;
		rs.next();
		return rs.getInt(1) ;
	}
	
	
	
	public static void main(String[] args)
	{
		RoomC r = new RoomC();
		try
		{
			System.out.println(r.getRowCount());
		} catch (Exception e)
		{
			
			e.printStackTrace();
		}
	}
}
