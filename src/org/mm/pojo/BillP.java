package org.mm.pojo;

public class BillP 
{
	private int id ;
	private double laundryCost;
	private double foodCost;
	private double stayCharges;
	private static int searchButtonClickCount = 0 ;
	
	public BillP()
	{
 	   this(0 , 0.0 , 0.0 , 0.0) ; 	
	}
	public BillP(int id, double laundryCost, double foodCost, double stayCharges)
	{
		super();
		this.id = id;
		this.laundryCost = laundryCost;
		this.foodCost = foodCost;
		this.stayCharges = stayCharges;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getLaundryCost() {
		return laundryCost;
	}
	public void setLaundryCost(double laundryCost) {
		this.laundryCost = laundryCost;
	}
	public double getFoodCost() {
		return foodCost;
	}
	public void setFoodCost(double foodCost) {
		this.foodCost = foodCost;
	}
	public double getStayCharges() {
		return stayCharges;
	}
	public void setStayCharges(double stayCharges) {
		this.stayCharges = stayCharges;
	}
	@Override
	public String toString()
	{
		return "BillP [id=" + id + ", laundryCost=" + laundryCost + ", foodCost=" + foodCost + ", stayCharges="
				+ stayCharges + "]";
	}
	public static int getSearchButtonClickCount()
	{
		return ++BillP.searchButtonClickCount ;
	}
	public static void resetSeachButtonCount()
	{
		BillP.searchButtonClickCount = 0 ;
	}
}
