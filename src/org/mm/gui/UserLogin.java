package org.mm.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import org.mm.dao.UserC;
import org.mm.pojo.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 * @author atharv
 *
 */
public class UserLogin extends JFrame 
{

	private JPanel contentPane;
	private NewRoomSelect nws = null ;
	private String errorMessage = "Not Set";
	private Main main = null;
	private JTextField userName;
	private JPasswordField pwd;
	private JButton btnLogin;

	public Main getMain() 
	{
		return main;
	}
	public void setMain(Main main)
	{
		this.main = main;
	}
	public String getErrorMessage() 
	{
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}
	public NewRoomSelect getNws()
	{
		return nws;
	}
	public void setNws(NewRoomSelect nws)
	{
		this.nws = nws;
	}
	public JButton getBtnLogin()
	{
		return btnLogin;
	}
	public void setBtnLogin(JButton btnLogin) 
	{
		this.btnLogin = btnLogin;
	}		
	public void setUserName(JTextField jt)
	{
		this.userName = jt;
	}
	public JTextField getUserName()
	{
		return userName;
	}
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					UserLogin frame = new UserLogin();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public JPasswordField getPwd() {
		return pwd;
	}
	public void setPwd(JPasswordField pwd) {
		this.pwd = pwd;
	}
	/**
	 * Create the frame.
	 */
	public UserLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblLogin.setBounds(39, 111, 68, 20);
		contentPane.add(lblLogin);
		
		this.userName = new JTextField();
		userName.setBounds(144, 112, 182, 22);
		contentPane.add(userName);
		userName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblPassword.setBounds(39, 188, 68, 17);
		contentPane.add(lblPassword);
		
		pwd = new JPasswordField();
		pwd.setBounds(144, 188, 182, 20);
		contentPane.add(pwd);
		pwd.setColumns(10);
		
		this.btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
		        {
		        	UserC user1 = new UserC() ;
		        	User u = new User() ;
		        	u.setUserName(userName.getText());
		        	u.setPassword(pwd.getText());
		        	ResultSet rs = user1.selectData(u);
		        	if(rs.next())
		        	{
		        		JOptionPane.showMessageDialog(null,"Login Successful");
		        		
		        		main = new Main();
		        		main.setVisible(true);
		        		setVisible(false);
		        	}
		        	else
		        	{
		        		setErrorMessage("Invalid Username or Password");
		        		JOptionPane.showMessageDialog(null,errorMessage);	
		        	}
		        }
		        catch(Exception e1)
		        {
		            System.out.println(e1);
		        }
				
			}
		});
		btnLogin.setBounds(149, 266, 98, 33);
		contentPane.add(btnLogin);
		
		JButton btnSignin = new JButton("Signup");
		btnSignin.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		btnSignin.addActionListener(new ActionListener() 
//		{
//			public void actionPerformed(ActionEvent arg0) 
//			{
//				signin s = new signin();
//				s.setVisible(true);
//				setVisible(false);
//			}
//		});
		btnSignin.setBounds(479, 266, 89, 33);
		contentPane.add(btnSignin);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 415, 329);
		contentPane.add(label);
		
		JLabel lblHotelManagementSystem = new JLabel("Hotel Management System");
		lblHotelManagementSystem.setBackground(Color.GRAY);
		lblHotelManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblHotelManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblHotelManagementSystem.setBounds(0, 0, 620, 60);
		contentPane.add(lblHotelManagementSystem);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("/home/atharv/Documents/BE1/Lab/LP2/STQA/MyHotelManagement/Webp.net-resizeimage (7).png")); 
		label_1.setBounds(374, 70, 213, 185);
		contentPane.add(label_1);
		
		JLabel lblDontHaveAn = new JLabel("Don't have an account?");
		lblDontHaveAn.setBounds(342, 277, 123, 14);
		contentPane.add(lblDontHaveAn);
	}
}