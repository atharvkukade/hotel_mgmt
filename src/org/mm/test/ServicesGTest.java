package org.mm.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mm.gui.ServicesG;

public class ServicesGTest
{
	private ServicesG sg = null;
	public ServicesGTest()
	{
		this.sg = new ServicesG() ;
	}
	
	@Test
	public void emptyRoomNoCheck()
	{
		assertTrue(isCorrectEmptyLaundryClothesMsgSet());
		this.sg.getSearch().doClick();
	}
	@Test
	public void emptyNoOfClothesCheck()
	{
		assertTrue(isCorrectEmptyLaundryClothesMsgSet());
		this.sg.getDone().doClick();
	}
	public boolean isCorrectEmptyRoomNoMsgSet()
	{
		if( this.sg.getSearchFieldEmptyErrorMessage().equals(new String( "Please Enter room number..." )))
			return true ;
		return false;			
	}
	
	public boolean isCorrectEmptyLaundryClothesMsgSet()
	{
		if( this.sg.getNoOfClothesFieldEmptyErrorMessage().equals(new String( "Please enter no of clothes..." )) )
			return true ;
		return false;			
	}

}
