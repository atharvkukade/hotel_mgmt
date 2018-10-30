package org.mm.pojo;

import java.util.Date;

public class RoomDates
{
  private int roomDateID;
  private int roomNo;
  private Date checkInDate;
  private Date checkOutDate;
  
  	public RoomDates()
  	{
  		this(0 , 0 , null , null) ;
  	}
  	public RoomDates(int roomDateID, int roomNo, Date checkInDate, Date checkOutDate)
  	{
	  	this.roomDateID = roomDateID;
		this.roomNo = roomNo;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
  	}
  	public int getRoomDateID()
	{
		return roomDateID;
	}
	public void setRoomDateID(int roomDateID)
	{
		this.roomDateID = roomDateID;
	}
	public int getRoomNo()
	{
		return roomNo;
	}
	public void setRoomNo(int roomNo)
	{
		this.roomNo = roomNo;
	}
	public Date getCheckInDate()
	{
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate)
	{
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate()
	{
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate)
	{
		this.checkOutDate = checkOutDate;
	}
	@Override
	public String toString()
	{
		return "RoomDates [roomDateID=" + roomDateID + ", roomNo=" + roomNo + ", checkInDate=" + checkInDate
				+ ", checkOutDate=" + checkOutDate + "]";
	}
	
}
