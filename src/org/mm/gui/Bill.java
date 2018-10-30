package org.mm.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mm.dao.BillC;
import org.mm.dao.RoomC;
import org.mm.dao.RoomDateC;
import org.mm.dao.ServiceC;
import org.mm.pojo.BillP;
import org.mm.pojo.GuestDetails;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Bill extends JFrame 
{

	private JPanel contentPane;
	private JTextField textField;
	private BillC billC = new BillC() ;
	private GuestDetails gd;
	private BillP bill;
    private int roomNoInTxtField = 0 ;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill frame = new Bill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Bill() 
	{
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFoodCharges = new JLabel("Food Charges");
		lblFoodCharges.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFoodCharges.setBounds(25, 106, 98, 23);
		contentPane.add(lblFoodCharges);
		
		JLabel lblLaundryCharges = new JLabel("Laundry Charges");
		lblLaundryCharges.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLaundryCharges.setBounds(25, 161, 115, 23);
		contentPane.add(lblLaundryCharges);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal.setBounds(25, 274, 98, 23);
		contentPane.add(lblTotal);
		
		JLabel lblStayCharges = new JLabel("Stay Charges");
		lblStayCharges.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStayCharges.setBounds(25, 216, 98, 23);
		contentPane.add(lblStayCharges);
		
		JLabel foodChargesLabel = new JLabel("");
		foodChargesLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		foodChargesLabel.setBounds(183, 106, 98, 23);
		contentPane.add(foodChargesLabel);
		
		JLabel laundryLabel = new JLabel("");
		laundryLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		laundryLabel.setBounds(183, 161, 98, 23);
		contentPane.add(laundryLabel);
		
		JLabel stayChargesLabel = new JLabel("");
		stayChargesLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		stayChargesLabel.setBounds(183, 216, 98, 23);
		contentPane.add(stayChargesLabel);
		
		JLabel totalLabel = new JLabel("");
		totalLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		totalLabel.setBounds(183, 274, 98, 23);
		contentPane.add(totalLabel);
		
		JButton btnSendMail = new JButton("CheckOut");
		btnSendMail.setVisible(false);
		btnSendMail.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
				   if(	new RoomDateC().updateCheckOutDate(gd.getRoomDateID(), new Date()) > 0)
				   {
					   JOptionPane.showMessageDialog(null,"Thankyou For Visiting :)");
						Main m = new Main();
						m.setVisible(true);
						setVisible(false);
				   }
				   else
					   JOptionPane.showMessageDialog(null, "Error in updating check Out Date");
				} 
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnSendMail.setBounds(257, 308, 92, 30);
		contentPane.add(btnSendMail);
		
		JLabel lblBill = new JLabel("Bill");
		lblBill.setHorizontalAlignment(SwingConstants.CENTER);
		lblBill.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBill.setBounds(0, 0, 546, 68);
		contentPane.add(lblBill);
		
		JLabel lblRoomNo = new JLabel("Room No");
		lblRoomNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRoomNo.setBounds(25, 60, 67, 23);
		contentPane.add(lblRoomNo);
		
		textField = new JTextField();
		textField.setBounds(102, 63, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Guest Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(310, 60, 91, 23);
		lblNewLabel.setVisible(false);
		contentPane.add(lblNewLabel);
		
		JLabel guestNameLabel = new JLabel("");
		guestNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		guestNameLabel.setBounds(421, 60, 85, 23);
		guestNameLabel.setVisible(false);
		contentPane.add(guestNameLabel);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(!textField.getText().isEmpty())
				{
					try
					{
						if( roomNoInTxtField != Integer.parseInt(textField.getText())) //Avoiding DB access  iff roomNo remain same in search text field
						{
							roomNoInTxtField = Integer.parseInt(textField.getText()) ;
							
							//Assumed entered value of roomNo is correct i.e. present in Room Table.
							gd = billC.getGuest(Integer.parseInt(textField.getText()), new Date()) ;   //1.Getting the guest from DB
							
							//2.Getting check in date from DB for calculation of numOfDays
							ResultSet roomDateEntry = new RoomDateC().getRoomDateRow(gd.getRoomDateID());
							
							//3.Calculating number of days
							int numOfDays = (int) TimeUnit.DAYS.convert((new Date().getTime() - roomDateEntry.getDate(3).getTime()),TimeUnit.MILLISECONDS);
							
							//4.Multiplying num of days with stay charges 
							double stayCharges = numOfDays * new RoomC().getSelectedData(roomDateEntry.getInt(2)).getDouble(4) ;
							
							//5.Updating stay charges to Bill Table
							billC.updateStayCharges(gd, stayCharges) ;
							
							bill = billC.getBill(gd.getId()) ;
						}
						btnSendMail.setVisible(true);
						guestNameLabel.setVisible(true);
						lblNewLabel.setVisible(true);
						guestNameLabel.setText(gd.getName());
						
						foodChargesLabel.setText(""+bill.getFoodCost());
						laundryLabel.setText(""+bill.getLaundryCost());
						stayChargesLabel.setText(""+bill.getStayCharges());
						totalLabel.setText(""+( bill.getFoodCost() + bill.getLaundryCost() + bill.getStayCharges()));
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Search field is empty!!!");
				}
				
			}
		});
		btnSearch.setBounds(198, 62, 89, 23);
		contentPane.add(btnSearch);

	}
}