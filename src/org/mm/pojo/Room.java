package org.mm.pojo;

public class Room
{
	private int roomNo;
	private String roomType;
	private String bedType;
	private double cost;
	public Room()
	{
		this(0 , "Not Set" , "Not Set" , 0.0);
	}
	public Room(int roomNo, String roomType, String bedType, double cost)
	{
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.bedType = bedType;
		this.cost = cost;
	}
	public int getRoomNo()
	{
		return roomNo;
	}
	public void setRoomNo(int roomNo)
	{
		this.roomNo = roomNo;
	}
	public String getRoomType()
	{
		return roomType;
	}
	public void setRoomType(String roomType)
	{
		this.roomType = roomType;
	}
	public String getBedType()
	{
		return bedType;
	}
	public void setBedType(String bedType)
	{
		this.bedType = bedType;
	}
	public double getCost()
	{
		return cost;
	}
	public void setCost(double cost)
	{
		this.cost = cost;
	}
	@Override
	public String toString()
	{
		return "Room [roomNo=" + roomNo + ", roomType=" + roomType + ", bedType=" + bedType + ", cost=" + cost + "]";
	}
	
}
