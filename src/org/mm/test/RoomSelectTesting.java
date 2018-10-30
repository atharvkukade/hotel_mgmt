package org.mm.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JTable;

import org.junit.Test; 
import org.mm.gui.NewRoomSelect;

import com.toedter.calendar.JDateChooser;

public class RoomSelectTesting 
{
	private NewRoomSelect nsr  = new NewRoomSelect();
	public RoomSelectTesting() 
	{
		this.nsr.setVisible(true);
	}
	@Test
	public void selectInvalidCheckInDate()
	{
		
		final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -2);
		    
		nsr.getDateChooser().setDate(cal.getTime());
		nsr.getCheck().doClick();
		
		assertTrue(isCorrectCheckInErrorMsg());
		
		try 
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
		
			e.printStackTrace();
		}
	//	fail("Not yet implemented");
	}
	@Test
	public void selectInvalidCheckOutDate()
	{
		this.nsr.getDateChooser().setDate(new Date());
		
		final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, -2);
        
	    this.nsr.getDateChooser_1().setDate(cal.getTime());
	    this.nsr.getCheck().doClick();
	    
	    assertTrue(isCorrectCheckOutErrorMsg());
	    
	    try 
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	@Test
	public void validateBookRoom()
	{
		try 
        {
			final Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, 3);
		    
			this.nsr.getDateChooser().setDate(new Date());
			this.nsr.getDateChooser_1().setDate(cal.getTime());
			Thread.sleep(3000);
			
			this.nsr.getCheck().doClick();
			Thread.sleep(3000);
		
			JTable table = this.nsr.getTable() ;
			Integer manuallySelectedRoom =  (int) table.getValueAt(0, 0) ;  
			this.nsr.setRoomSelected(manuallySelectedRoom); 
			this.nsr.getBook().doClick();
			
			assertNotNull(this.nsr.getUsrDetail()) ;              // Expected : Object should not be NULL
			Thread.sleep(3000);
		}
        catch (InterruptedException e)
        {
			e.printStackTrace();
		}
	}
	@Test
	public void validateCountOfDays()
	{
		assertTrue(isCorrectCountOfDays());
	}
	public boolean isCorrectCheckInErrorMsg()
	{
		if( this.nsr.getErrorCheckInMsg().equals(new String("It seems you have selected wrong Check IN Date...")) )
			return true;
		return false ;
	}
	public boolean isCorrectCheckOutErrorMsg()
	{
		if( this.nsr.getErrorCheckOutMsg().equals(new String("It seems you have selected wrong Check OUT Date...")) )
			return true;
		return false ;
	}
	public boolean isCorrectCountOfDays()
	{
		if( TimeUnit.DAYS.convert((this.nsr.getCheckInDate().getTime() - this.nsr.getCheckOutDate().getTime()),TimeUnit.MILLISECONDS) == Integer.parseInt(this.nsr.getTextField().getText())) 
		{
			return true;
		}
		return false;
	}
}
