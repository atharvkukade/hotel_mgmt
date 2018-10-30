package org.mm.pojo;

public class GuestDetails
{
	private int id ;
	private int noOfAdults;
	private int noOfMinors;
	private int roomDateID ;
	private String name;
	private String email;
	private String phoneNo;
	private String city;
	private String state;
	private String country;
	private static int doneButtonClicks = 0;
	public GuestDetails()
	{
		this(0 ,0 , 0 , 0,"Not Set" , "Not Set" , "Not Set" ,"Not Set","Not Set","Not Set" );
	}
	public GuestDetails(int id, int noOfAdults, int noOfMinors, int roomDateID, String name, String email,
			String phoneNo, String city, String state, String country)
	{
		this.id = id;
		this.noOfAdults = noOfAdults;
		this.noOfMinors = noOfMinors;
		this.roomDateID = roomDateID;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getNoOfAdults()
	{
		return noOfAdults;
	}
	public void setNoOfAdults(int noOfAdults)
	{
		this.noOfAdults = noOfAdults;
	}
	public int getNoOfMinors()
	{
		return noOfMinors;
	}
	public void setNoOfMinors(int noOfMinors)
	{
		this.noOfMinors = noOfMinors;
	}
	public int getRoomDateID()
	{
		return roomDateID;
	}
	public void setRoomDateID(int roomDateID)
	{
		this.roomDateID = roomDateID;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPhoneNo()
	{
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo)
	{
		this.phoneNo = phoneNo;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public String getCountry()
	{
		return country;
	}
	public void setCountry(String country)
	{
		this.country = country;
	}
	@Override
	public String toString()
	{
		return "GuestDetails [id=" + id + ", noOfAdults=" + noOfAdults + ", noOfMinors="
				+ noOfMinors + ", roomDateID=" + roomDateID + ", name=" + name + ", email=" + email + ", phoneNo="
				+ phoneNo + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}
	public static int getCountDoneButtonClicked()
	{
		return ++GuestDetails.doneButtonClicks ;
	}
	public static void resetCountDoneButtonClicked()
	{
		GuestDetails.doneButtonClicks = 0 ;
	}
}
