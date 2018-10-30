package org.mm.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import org.mm.gui.UserDetails;

import org.mm.pojo.GuestDetails;

import junit.framework.Assert;

public class UserDetailsTest 
{
	UserDetails ud = new UserDetails(200,new Date(),new Date());
	public UserDetailsTest()
	{
		ud.setVisible(true);
	}
	
	
	GuestDetails gd = new GuestDetails();
	
	
	@Test
	public void phnocheck() throws Exception
	{
		Thread.sleep(1000);
		ud.getPhno().setText("7588bc6423");
		String phno = ud.getPhno().getText().toString();
		Assert.assertTrue(!phno.matches("\\d{10}"));
        System.out.println("Contact No."+phno+" field is invalid.");
        Thread.sleep(1000);
	}
	
	@Test
	public void Emailcheck() throws Exception
	{
		Thread.sleep(1000);
		ud.getEmail().setText("abcexample.com");
		String Email = ud.getEmail().getText().toString();
		Assert.assertTrue(!Email.matches("^[A-Za-z0-9._]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$"));   //If the email is same as format Test case Pass
		
		System.out.println("Email field is invalid.");
        System.out.println(Email);
        Thread.sleep(1000);
	}
	
	@Test
	public void Namecheck() throws Exception
	{
		Thread.sleep(1000);
		ud.getNames().setText("Nach1ket");
		String name = ud.getNames().getText().toString();
		Assert.assertTrue(!name.matches("^[A-Z][A-Za-z]+$"));
        System.out.println("Name field is invalid. Cannot contain numbers or special char");
        Thread.sleep(1000);
	}
	
	@Test
	public void NoofPeoplecheck() throws Exception
	{
		Thread.sleep(1000);
		ud.getAdult().setText("5");
		String adult = ud.getAdult().getText().toString();
		ud.getDone().doClick();
		System.out.println("No of Adults "+adult+" valid per room.");
		Assert.assertTrue(!adult.matches("^[0-4]$"));
		System.out.println("No of adult exceeds max limit");

        Thread.sleep(1000);
	}
	
	@Test 
	public void NoEmptyFieldtcheck() throws Exception
	{
		ud.getNames().setText("Nachiket");
		ud.getCity().setText("Pune");
		ud.getCountry().setText("India");
		ud.getEmail().setText("abc@example.com");
		ud.getStates().setText("Maharashtra");
		ud.getAdult().setText("3");
		ud.getMinor().setText("2");
		ud.getPhno().setText("7588276423");
		Thread.sleep(3000);
		String mail = ud.getEmail().getText().toString();
		String state = ud.getStates().getText().toString();
		String city = ud.getCity().getText().toString();
		String country = ud.getCountry().getText().toString();
		String adult = ud.getAdult().getText().toString();
		String name = ud.getNames().getText().toString();
		String minor = ud.getMinor().getText().toString();
		String phno = ud.getPhno().getText().toString();
		
		if(phno.isEmpty()||mail.isEmpty() || state.isEmpty() ||city.isEmpty() ||country.isEmpty() ||name.isEmpty() || adult.isEmpty() ||minor.isEmpty())
		{
			System.out.println("EmptyFields");
			Assert.assertTrue(false);       //if any of the filled is empty test case fails
			
		}
		else
		{
			System.out.println("No Empty Fields");
			Assert.assertTrue(true);       //if all fields are filled test case success
		}
		ud.getDone().doClick();
		
	}
	
	@Test
	public void DoubleEntrycheck() throws Exception
	{
		ud.getNames().setText("Nachiket");
		ud.getCity().setText("Pune");
		ud.getCountry().setText("India");
		ud.getEmail().setText("abc@example.com");
		ud.getStates().setText("Maharashtra");
		ud.getAdult().setText("3");
		ud.getMinor().setText("2");
		ud.getPhno().setText("7588276423");
		Thread.sleep(3000);
		
		String checkErrMsg = ud.getErrorMessage();
		System.out.println("Error msg op : "+checkErrMsg);
		Assert.assertTrue(checkErrMsg.matches("Data Already Entered"));		
		System.out.println("Test case Pass");
				
	}	

}