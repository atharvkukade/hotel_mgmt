package org.mm.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;

public class Main extends JFrame {

	private JPanel contentPane;
	private JButton checkin = null;
	private JButton Manage = null;
	private JButton Checkout = null;
	private NewRoomSelect nrs=null;
	private ServicesG sg = null;
	private Bill c = null;
	
	
	public NewRoomSelect getNrs()
	{
		return nrs;
	}

	public void setNrs(NewRoomSelect nrs)
	{
		this.nrs = nrs;
	}

	public ServicesG getSg()
	{
		return sg;
	}

	public void setSg(ServicesG sg)
	{
		this.sg = sg;
	}

	public Bill getC()
	{
		return c;
	}

	public void setC(Bill c)
	{
		this.c = c;
	}

	public JButton getCheckin()
	{
		return checkin;
	}

	public void setCheckin(JButton checkin)
	{
		this.checkin = checkin;
	}

	public JButton getManage()
	{
		return Manage;
	}

	public void setManage(JButton manage)
	{
		Manage = manage;
	}

	public JButton getCheckout()
	{
		return Checkout;
	}

	public void setCheckout(JButton checkout)
	{
		Checkout = checkout;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.checkin = new JButton("Checkin");
		checkin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				 nrs = new NewRoomSelect();
				nrs.setVisible(true);
				setVisible(false);
			}
		});
		checkin.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		checkin.setBounds(35, 259, 124, 47);
		contentPane.add(checkin);
		
		 Manage = new JButton("Manage");
		Manage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sg = new ServicesG();
				sg.setVisible(true);
				setVisible(false);
			}
		});
		Manage.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		Manage.setBounds(228, 259, 124, 47);
		contentPane.add(Manage);
		
		 Checkout = new JButton("Checkout");
		Checkout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				 c = new Bill();
				c.setVisible(true);
			}
		});
		Checkout.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		Checkout.setBounds(407, 259, 124, 47);
		contentPane.add(Checkout);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\215\\hotelmgmt\\image-5-(1).png"));
		label.setBounds(35, 129, 124, 108);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\215\\hotelmgmt\\image(1).jpg"));
		label_1.setBounds(228, 129, 117, 108);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\215\\hotelmgmt\\Webp.net-resizeimage (5).png"));
		label_2.setBounds(407, 129, 108, 108);
		contentPane.add(label_2);
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 563, 96);
		contentPane.add(lblNewLabel);
	}
}