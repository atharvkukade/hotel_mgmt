package org.mm.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import org.mm.gui.SignupFrame;
import org.mm.gui.UserLogin; 
public class SignupFrameTest 
{
	SignupFrame sf = new SignupFrame();
	
	@Test
	public void EmptyFields() throws Exception
	{
		sf.getUsername().setText("Admin");
		sf.getPassword().setText("Admin");
		
		String usrname = sf.getUsername().getText().toString();
		String pwd = sf.getPassword().getText().toString();
		
		if(usrname.isEmpty() || pwd.isEmpty())
		{
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			System.out.println("No Empty Fields");
		}

	}

}