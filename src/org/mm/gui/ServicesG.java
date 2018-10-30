package org.mm.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mm.dao.RoomC;
import org.mm.dao.ServiceC;
import org.mm.pojo.GuestDetails;
import org.mm.pojo.Room;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class ServicesG extends JFrame {

	private JPanel contentPane;
	private JTextField roomno;
	private JTextField clothes;
	private ServiceC serviceC = new ServiceC();
	private static final int  laundryCostPerCloth = 20 ;  
	private static int billID = 0 ;
	private GuestDetails gd = null;
	private String searchFieldEmptyErrorMessage="Not Set" ;
	private String noOfClothesFieldEmptyErrorMessage="Not Set" ;
	private JButton search=null;
	private JButton done = null;
	
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ServicesG frame = new ServicesG();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public JButton getSearch()
	{
		return search;
	}

	public void setSearch(JButton search)
	{
		this.search = search;
	}

	public JButton getDone()
	{
		return done;
	}

	public void setDone(JButton done)
	{
		this.done = done;
	}

	public JTextField getRoomno()
	{
		return roomno;
	}
	public void setRoomno(JTextField roomno)
	{
		this.roomno = roomno;
	}
	public JTextField getClothes()
	{
		return clothes;
	}
	public void setClothes(JTextField clothes)
	{
		this.clothes = clothes;
	}
	public String getSearchFieldEmptyErrorMessage()
	{
		return searchFieldEmptyErrorMessage;
	}
	public void setSearchFieldEmptyErrorMessage(String searchFieldEmptyErrorMessage)
	{
		this.searchFieldEmptyErrorMessage = searchFieldEmptyErrorMessage;
	}
	public String getNoOfClothesFieldEmptyErrorMessage()
	{
		return noOfClothesFieldEmptyErrorMessage;
	}
	public void setNoOfClothesFieldEmptyErrorMessage(String noOfClothesFieldEmptyErrorMessage)
	{
		this.noOfClothesFieldEmptyErrorMessage = noOfClothesFieldEmptyErrorMessage;
	}



	/**
	 * Create the frame.
	 */
	public ServicesG() 
	{	
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectYourChoice = new JLabel("Select your Choice");
		lblSelectYourChoice.setVisible(false);
		
		JLabel lblname = new JLabel("Name");
		lblname.setVisible(false);
		
		JComboBox choice = new JComboBox();
		choice.setModel(new DefaultComboBoxModel(new String[] {"Laundry", "Food Items"}));
		choice.setVisible(false);
		
		JLabel lblRoomType = new JLabel("Room Type");
		lblRoomType.setVisible(false);
		
		JLabel lblServices = new JLabel("Services");
		lblServices.setVisible(false);
		
		 done = new JButton("Done");
		done.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if( !clothes.getText().isEmpty()  )
				{
					try
					{
						if(serviceC.updateLaudryCost(laundryCostPerCloth*Integer.parseInt(clothes.getText()),ServicesG.getBillID() ) > 0)
						{
							JOptionPane.showMessageDialog(null, "Entry updated successfully...");
						}
						else
						{						
							JOptionPane.showMessageDialog(null, "Oops! Error Ocurred...","Error Message",JOptionPane.ERROR_MESSAGE);
						}
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
				else
				{
					noOfClothesFieldEmptyErrorMessage = "Please enter no of clothes..." ;
					setNoOfClothesFieldEmptyErrorMessage(noOfClothesFieldEmptyErrorMessage);
					JOptionPane.showMessageDialog(null, noOfClothesFieldEmptyErrorMessage);
				}
			}
		});
		done.setFont(new Font("Tahoma", Font.PLAIN, 14));
		done.setVisible(false);
		
		JLabel lblNoOfClothes = new JLabel("No of Clothes");
		lblNoOfClothes.setVisible(false);
		
		JButton ok = new JButton("OK");
		ok.setVisible(false);
		
		roomno = new JTextField();
		roomno.setBounds(128, 39, 160, 26);
		contentPane.add(roomno);
		roomno.setColumns(10);
		
		JLabel lblRoomNo = new JLabel("Room no");
		lblRoomNo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblRoomNo.setBounds(29, 39, 86, 30);
		contentPane.add(lblRoomNo);
		
		JLabel name = new JLabel("");
		name.setBounds(128, 107, 160, 20);
		contentPane.add(name);
		
		JLabel roomtype = new JLabel("");
		roomtype.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		roomtype.setBounds(399, 99, 96, 28);
		contentPane.add(roomtype);
		
		 search = new JButton("Search");
		search.setFont(new Font("Tahoma", Font.PLAIN, 14));
		search.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(!roomno.getText().isEmpty())
				{
					try
					{
						 gd  = serviceC.getGuest(Integer.parseInt(roomno.getText()), new Date());
						name.setText(gd.getName());
						ServicesG.setBillID(gd.getId());
						
						Room room = serviceC.getRoom(Integer.parseInt(roomno.getText()));
						roomtype.setText(room.getRoomType());
						
						lblSelectYourChoice.setVisible(true);
						lblname.setVisible(true);
						choice.setVisible(true);
						lblRoomType.setVisible(true);
						lblServices.setVisible(true);
						ok.setVisible(true);
					}
					catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
				else
				{
					searchFieldEmptyErrorMessage = "Please Enter room number..." ;
					setSearchFieldEmptyErrorMessage(searchFieldEmptyErrorMessage);
					JOptionPane.showMessageDialog(null, searchFieldEmptyErrorMessage);
				}
			}
		});
		search.setBounds(399, 39, 96, 30);
		contentPane.add(search);
		
		lblname.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblname.setBounds(32, 107, 86, 20);
		contentPane.add(lblname);
		lblSelectYourChoice.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSelectYourChoice.setBounds(32, 231, 150, 25);
		contentPane.add(lblSelectYourChoice);
		
		choice.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		choice.setBounds(32, 271, 150, 30);
		contentPane.add(choice);
		
		lblNoOfClothes.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNoOfClothes.setBounds(32, 319, 150, 26);
		contentPane.add(lblNoOfClothes);
		
		ok.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ok.setVisible(false);
		ok.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				String s = (String) choice.getSelectedItem();
				
				if(s.equals("Laundry"))
				{
					clothes.setVisible(true);
					lblNoOfClothes.setVisible(true);
					done.setVisible(true);
				}
				else
				{
					FoodG f = new FoodG(gd);
					f.setVisible(true);
	
				}
				
			}
		});
		ok.setBounds(399, 267, 96, 24);
		contentPane.add(ok);
		
		clothes = new JTextField();
		clothes.setVisible(false);
		clothes.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		clothes.setBounds(214, 320, 102, 25);
		contentPane.add(clothes);
		clothes.setColumns(10);
		
		lblRoomType.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblRoomType.setBounds(290, 108, 100, 19);
		contentPane.add(lblRoomType);
		
		lblServices.setHorizontalAlignment(SwingConstants.CENTER);
		lblServices.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblServices.setBounds(0, 153, 578, 67);
		contentPane.add(lblServices);
		
		
		done.setBounds(399, 323, 96, 23);
		contentPane.add(done);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 153, 578, 67);
		contentPane.add(panel);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(241, 356, 89, 23);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Main main = new Main();
				main.setVisible(true);
				setVisible(false);
			}
		});
	}

	public static int getBillID()
	{
		return billID;
	}
	public static void setBillID(int billID)
	{
		ServicesG.billID = billID;
	}
}