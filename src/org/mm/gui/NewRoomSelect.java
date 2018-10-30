package org.mm.gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import org.mm.dao.RoomC;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class NewRoomSelect extends JFrame 
{
	private JTextField textField;
	private UserDetails usrDetail = null;
	private String errorCheckInMsg = "Not Set";
	private String errorCheckOutMsg = "Not Set";
	private JTable table;
	private Date checkInDate=null;
	private Date checkOutDate=null;
	private RoomC roomC = new RoomC();
	private int roomSelected = 0;
	private JDateChooser dateChooser = null;
	private JDateChooser dateChooser_1 = null;
	private JButton check = null;
	private JButton book = null;
	
	
	
	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public UserDetails getUsrDetail()
	{
		return usrDetail;
	}

	public void setUsrDetail(UserDetails usrDetail)
	{
		this.usrDetail = usrDetail;
	}

	public String getErrorCheckInMsg() 
	{
		return errorCheckInMsg;
	}

	public void setErrorCheckInMsg(String errorCheckInMsg) 
	{
		this.errorCheckInMsg = errorCheckInMsg;
	}

	public String getErrorCheckOutMsg() {
		return errorCheckOutMsg;
	}

	public void setErrorCheckOutMsg(String errorCheckOutMsg) {
		this.errorCheckOutMsg = errorCheckOutMsg;
	}

	public int getRoomSelected() {
		return roomSelected;
	}

	public void setRoomSelected(int roomSelected) {
		this.roomSelected = roomSelected;
	}

	public JTable getTable() 
	{
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	public JButton getBook() {
		return book;
	}

	public void setBook(JButton book) {
		this.book = book;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewRoomSelect frame = new NewRoomSelect();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JButton getCheck() {
		return check;
	}

	public void setCheck(JButton check) {
		this.check = check;
	}

	/**
	 * Create the frame.
	 */
	public NewRoomSelect() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 701);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 882, 204);
		getContentPane().add(panel);
		
		JLabel lblRoom = new JLabel("Room Booking Counter");
		lblRoom.setBounds(0, 204, 882, 46);
		getContentPane().add(lblRoom);
		lblRoom.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblRoom.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblArrivalDate = new JLabel("Check In Date");
		lblArrivalDate.setBounds(12, 286, 105, 20);
		getContentPane().add(lblArrivalDate);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(136, 286, 119, 20);
		 dateChooser.setDate(new Date());
		dateChooser.getDateEditor().addPropertyChangeListener(new PropertyChangeListener()
		{
			
			@Override
			public void propertyChange(PropertyChangeEvent evt)
			{
				if ("date".equals(evt.getPropertyName())) 
				{
	                	final Date date = dateChooser.getDate();
	                	setCheckInDate(date);
			     }
			}
		});
		getContentPane().add(dateChooser);
		
		JLabel lblDepartureDate = new JLabel("Check Out Date");
		lblDepartureDate.setBounds(298, 289, 128, 14);
		getContentPane().add(lblDepartureDate);
		
		 dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(423, 286, 128, 20);
		dateChooser_1.getDateEditor().addPropertyChangeListener(new PropertyChangeListener()
		{
			@Override
			public void propertyChange(PropertyChangeEvent arg0)
			{
				if ("date".equals(arg0.getPropertyName())) 
				{
	                	final Date date = dateChooser_1.getDate();
	                	setCheckOutDate(date);
			     }
			}
		});
		getContentPane().add(dateChooser_1);
		
		JLabel lblNewLabel = new JLabel("Booking for");
		lblNewLabel.setBounds(630, 286, 94, 20);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(732, 286, 48, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDays = new JLabel("Day(s)");
		lblDays.setBounds(790, 289, 46, 14);
		getContentPane().add(lblDays);
		
		JLabel lblSelecteRooms = new JLabel("Select Rooms");
		lblSelecteRooms.setBounds(0, 329, 882, 37);
		lblSelecteRooms.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSelecteRooms.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblSelecteRooms);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 392, 621, 271);
		getContentPane().add(scrollPane);
		
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.setColumnIdentifiers(new String[] {"Room no","Room Type","Bed Type","Tarrif per day"});
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);
        ListSelectionModel select= table.getSelectionModel();  
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
        select.addListSelectionListener(new ListSelectionListener() {  
          public void valueChanged(ListSelectionEvent e) {  
            int Data = 0;  
            int[] row = table.getSelectedRows();  
            int[] columns = table.getSelectedColumns();  
            for (int i = 0; i < row.length; i++) {  
              for (int j = 0; j < columns.length; j++) {  
                Data = (int) table.getValueAt(row[i], columns[j]);  
              } }  
            roomSelected = (Data);    
          }       
        });  
		table.setModel(dtm);
		table.getColumnModel().getColumn(1).setPreferredWidth(107);
		table.getColumnModel().getColumn(2).setPreferredWidth(107);
		table.getColumnModel().getColumn(3).setPreferredWidth(106);
		
		 check = new JButton("Check Rooms");
		check.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{	
				DefaultTableModel dtm = new DefaultTableModel();
				dtm.setColumnIdentifiers(new String[] {"Room no","Room Type","Bed Type","Tarrif per day"});
				
				ResultSet rs=null;
                try
                {
                	SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd") ;
					Date formattedCheckInDate = smf.parse(smf.format(checkInDate)) ;
					Date formattedCurrentDate = smf.parse(smf.format(new Date())) ;
                	if(formattedCheckInDate.before(formattedCurrentDate) )
    				{
                		errorCheckInMsg = "It seems you have selected wrong Check IN Date...";
    					JOptionPane.showMessageDialog(null, errorCheckInMsg ,"Error Message",JOptionPane.ERROR_MESSAGE);
    					return;
    				}
    				else if(checkOutDate.before(checkInDate))
    				{
    					errorCheckOutMsg = "It seems you have selected wrong Check OUT Date...";
    					JOptionPane.showMessageDialog(null, errorCheckOutMsg ,"Error Message",JOptionPane.ERROR_MESSAGE);
    					return;
    				}
                	rs = roomC.getUnallocatedRooms(checkInDate,checkOutDate) ;
                    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    table.setFillsViewportHeight(true);
                    while(rs.next())
                    {
                                dtm.addRow(new Object[] {rs.getInt(1) , rs.getString(2) ,rs.getString(3) , rs.getDouble(4)});
                                table.setModel(dtm);
                    }
                    if( roomC.getRoomDateCount() > 0 )                    //Table will get populated additional available booked rooms of there are any
                    {
                    	int[] availableRooms = roomC.getAvailableBookedRooms(checkInDate, checkOutDate) ;
                        int noOfRooms = availableRooms[0] -1 , currentRoom = 1;
                        System.out.println("No Of rooms:"+noOfRooms);
                        while(noOfRooms != 0)
                        {
                     	   rs = roomC.getSelectedData(availableRooms[currentRoom++]) ;
                     	   rs.next();
                     	   dtm.addRow(new Object[] {rs.getInt(1) , rs.getString(2) ,rs.getString(3) , rs.getDouble(4)});
                            table.setModel(dtm);
                            noOfRooms--;
                       }
                    }                  
                    textField.setText(""+TimeUnit.DAYS.convert((checkOutDate.getTime() - checkInDate.getTime()),TimeUnit.MILLISECONDS));
                } 
                catch (Exception e)
                {
                	// TODO Auto-generated catch block
                	e.printStackTrace();
                }
			}
		});
		check.setBounds(683, 447, 128, 31);
		getContentPane().add(check);
		
		 book = new JButton("Book Room");
		book.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				usrDetail = new UserDetails(roomSelected, checkInDate, checkOutDate);
				usrDetail.setVisible(true);
				setVisible(false);
			}
		});
		book.setBounds(683, 523, 128, 31);
		getContentPane().add(book);
		
		JButton back = new JButton("Back");
		back.setBounds(683, 598, 128, 31);
		getContentPane().add(back);
	
	}
	public JDateChooser getDateChooser() {
		return dateChooser;
	}

	public void setDateChooser(JDateChooser dateChooser) {
		this.dateChooser = dateChooser;
	}

	public JDateChooser getDateChooser_1() {
		return dateChooser_1;
	}

	public void setDateChooser_1(JDateChooser dateChooser_1) {
		this.dateChooser_1 = dateChooser_1;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date date)
	{
		this.checkInDate = date;
	}
	public void setCheckOutDate(Date date)
	{
		this.checkOutDate = date ;
	}
}