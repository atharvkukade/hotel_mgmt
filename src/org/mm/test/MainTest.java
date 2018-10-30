package org.mm.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mm.gui.Main;

public class MainTest
{
	private Main main = new Main() ;
	public MainTest()
	{
		this.main.setVisible(true);
	}
	
	@Test
	public void checkInNavigationTest()
	{
		this.main.getCheckin().doClick();
		assertNotNull(this.main.getNrs());
	}

	@Test
	public void checkOutNavigationTest()
	{
		this.main.getCheckout().doClick();
		assertNotNull(this.main.getC());
	}
	
	@Test
	public void manageNavigationTest()
	{
		this.main.getManage().doClick();
		assertNotNull(this.main.getSg());
	}
}
