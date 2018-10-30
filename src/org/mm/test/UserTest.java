package org.mm.test;
import static org.junit.Assert.*;

import javax.swing.JTextField;

import org.junit.Test;
import org.mm.gui.UserLogin;

public class UserTest 
{
	private UserLogin ul ;
	public UserTest()
	{
		this.ul = new UserLogin();
		this.ul.setVisible(true);
	}
	@Test
	public void testCorrectCreden() throws Exception
	{
		ul.getUserName().setText("atharv");
		Thread.sleep(500);
		
		ul.getPwd().setText("atharv");
		Thread.sleep(500);
		
		ul.getBtnLogin().doClick();
		
		assertNull(ul.getNws());
	}
	@Test
	public void testIncorrectCreden() throws Exception
	{
		ul.getUserName().setText("nachiket");
		Thread.sleep(500);
		
		ul.getPwd().setText("atharv");
		Thread.sleep(500);
		
		ul.getBtnLogin().doClick();
		assertNull(ul.getNws());
	}
	@Test
	public void emptyPasswordField() throws Exception
	{
		String password = ul.getPwd().getText();
		ul.getUserName().setText("ABCD");
		Thread.sleep(500);
		assertTrue(this.isCorrectEmptyMessage());
		Thread.sleep(500);
		ul.getBtnLogin().doClick();
	}
	
	@Test
	public void emptyUsrField() throws Exception
	{
		String username = ul.getUserName().getText();
		
		ul.getPwd().setText("ABCD");
		Thread.sleep(500);
		assertTrue(isCorrectEmptyMessage());
		Thread.sleep(500);
		ul.getBtnLogin().doClick();
	}
	
	public boolean isCorrectEmptyMessage()
	{
		if( this.ul.getErrorMessage().equals(new String("The field is empty!!!")) )
		{
			return true;
		}
		return false;
	}
}
