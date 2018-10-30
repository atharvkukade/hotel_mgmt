package org.mm.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mm.dao.GuestDetailC;
import org.mm.pojo.GuestDetails;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Canvas;
import javax.swing.ImageIcon;

public class UserDetails extends JFrame 
{
	private JTextField textField;
	private JButton done;
	private JTextField phno;
	private JTextField names;
	private JTextField email;
	private JTextField adult;
	private JTextField minor;
	private JTextField country;
	private JTextField states;
	private JTextField city;
	private String errorMessage = "Not Set";
	
	public String getErrorMessage() 
	{
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	} 
	
	public JTextField getCountry() {
		return country;
	}

	public void setCountry(JTextField country) {
		this.country = country;
	}

	public JTextField getStates() {
		return states;
	}

	public void setStates(JTextField states) {
		this.states = states;
	}

	public JTextField getCity() {
		return city;
	}

	public void setCity(JTextField city) {
		this.city = city;
	}
	public JTextField getPhno() {
		return phno;
	}
	public JTextField getNames() {
		return names;
	}
	public void setNames(JTextField names) {
		this.names = names;
	}
	public void setPhno(JTextField phno) {
		this.phno = phno;
	}
	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	public JTextField getEmail() {
		return email;
	}
	public void setEmail(JTextField email) {
		this.email = email;
	}
	public JTextField getAdult() {
		return adult;
	}
	public void setAdult(JTextField adult) {
		this.adult = adult;
	}
	public JTextField getMinor() {
		return minor;
	}
	public void setMinor(JTextField minor) {
		this.minor = minor;
	}
	private GuestDetailC guestC = new GuestDetailC() ;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDetails frame = new UserDetails(201 , new Date() , new Date());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public UserDetails(int roomNo ,Date checkInDate , Date checkOutDate ) 
	{
		GuestDetails.resetCountDoneButtonClicked();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 494);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JLabel lblEnterYourDetails = new JLabel("Enter Your Details");
		lblEnterYourDetails.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblEnterYourDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterYourDetails.setBounds(0, 0, 620, 86);
		getContentPane().add(lblEnterYourDetails);
		
		
		JLabel lblName = new JLabel("Name ");
		lblName.setBounds(27, 153, 68, 19);
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().add(lblName);
		
		JLabel lblPhoneNo = new JLabel("Phone no.");
		lblPhoneNo.setBounds(27, 210, 83, 19);
		lblPhoneNo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().add(lblPhoneNo);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(27, 264, 68, 19);
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().add(lblEmail);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(340, 153, 68, 19);
		lblCity.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().add(lblCity);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(340, 210, 68, 19);
		lblState.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().add(lblState);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(340, 264, 75, 19);
		lblCountry.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		getContentPane().add(lblCountry);
		
		JLabel lblNoOfAdults = new JLabel("No of Adults");
		lblNoOfAdults.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNoOfAdults.setBounds(120, 318, 123, 20);
		getContentPane().add(lblNoOfAdults);
		
		JLabel lblMinors = new JLabel("Minors");
		lblMinors.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMinors.setBounds(340, 318, 68, 20);
		getContentPane().add(lblMinors);
			
		phno = new JTextField();
		phno.setBounds(120, 211, 178, 20);
		getContentPane().add(phno);
		phno.setColumns(10);
		
		names = new JTextField();
		names.setBounds(120, 154, 178, 20);
		getContentPane().add(names);
		names.setColumns(10);
		
		email = new JTextField();
		email.setBounds(120, 265, 178, 20);
		getContentPane().add(email);
		email.setColumns(10);
		
		adult = new JTextField();
		adult.setBounds(230, 320, 68, 20);
		getContentPane().add(adult);
		adult.setColumns(10);
		
		minor = new JTextField();
		minor.setBounds(434, 320, 68, 20);
		getContentPane().add(minor);
		minor.setColumns(10);
		
		country = new JTextField();
		country.setBounds(431, 265, 133, 20);
		getContentPane().add(country);
		country.setColumns(10);
		
		states = new JTextField();
		states.setBounds(431, 211, 133, 20);
		getContentPane().add(states);
		states.setColumns(10);
		
		city = new JTextField();
		city.setBounds(431, 154, 133, 20);
		getContentPane().add(city);
		city.setColumns(10);
		
		done = new JButton("Done");
		done.addMouseListener(new MouseAdapter()  
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(GuestDetails.getCountDoneButtonClicked() == 1)
				{
					GuestDetails gd = new GuestDetails();
					try
					{
						gd.setName(names.getText());
						gd.setCity(city.getText());
						gd.setCountry(country.getText());
						gd.setState(states.getText());
						gd.setEmail(email.getText());
						gd.setPhoneNo(phno.getText());
						gd.setNoOfAdults(Integer.parseInt(adult.getText()));
						gd.setNoOfMinors(Integer.parseInt(minor.getText()));
						if(guestC.addGuest(gd)>0)
						{
							gd.setRoomDateID(guestC.getRoomDateID(roomNo, checkInDate, checkOutDate));
							
							if(guestC.updateRoomDateID(gd)>0   )
							{
								gd.setId(guestC.getGuestID(gd));   //Getting auto generated guest id from table
								guestC.insertBillID(gd);					//Setting it as Bill id
							
								JOptionPane.showMessageDialog(null, "Room Booked Successfully!!!");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Errored Occurred...","Error",JOptionPane.ERROR_MESSAGE);
						}
					} 
					catch (Exception e1)
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
//			Main m = new Main();
//			m.setVisible(true);
//			setVisible(false);
				}
				else
				{
					setErrorMessage("Data Already Entered");
					JOptionPane.showMessageDialog(null, "Result already successfully submitted...");
				}
		}});
		done.setBounds(250, 393, 99, 34);
		getContentPane().add(done);
		
		JLabel lblRoomNo = new JLabel("Room No  :");
		lblRoomNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRoomNo.setBounds(27, 97, 83, 14);
		getContentPane().add(lblRoomNo);
		
		JLabel roomno = new JLabel(""+roomNo);
		roomno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		roomno.setBounds(120, 97, 60, 14);
		getContentPane().add(roomno);
		
		SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd") ;
		JLabel lblCheckinDate = new JLabel("Checkin Date :");
		lblCheckinDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCheckinDate.setBounds(165, 97, 110, 14);
		getContentPane().add(lblCheckinDate);
		
		JLabel lblNewLabel = new JLabel(""+smf.format(checkInDate));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(285, 97, 83, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCheckoutDate = new JLabel("Checkout Date :");
		lblCheckoutDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCheckoutDate.setBounds(369, 97, 123, 14);
		getContentPane().add(lblCheckoutDate);
		
		JLabel label_1 = new JLabel(""+smf.format(checkOutDate));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(502, 97, 83, 14);
		getContentPane().add(label_1);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/atharv/eclipseTrial/hotelmgmt/Webp.net-resizeimage (1).jpg"));
		label.setBounds(0, 0, 620, 455);
		getContentPane().add(label);
		
	}
	public JButton getDone() {
		return done;
	}
	public void setDone(JButton done) {
		this.done = done;
	}
}