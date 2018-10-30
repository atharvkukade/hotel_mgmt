package org.mm.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckOut extends JFrame {

	private JPanel contentPane;
	private JTextField room;
	private JButton btnBack;

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
					CheckOut frame = new CheckOut();
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CheckOut() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRoomNo = new JLabel("Room no");
		lblRoomNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoomNo.setBounds(73, 40, 86, 28);
		contentPane.add(lblRoomNo);
		
		room = new JTextField();
		room.setFont(new Font("Tahoma", Font.PLAIN, 16));
		room.setBounds(223, 42, 125, 27);
		contentPane.add(room);
		room.setColumns(10);
		
		JButton btnEnter = new JButton("Checkout");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Bill b = new Bill();
			b.setVisible(true);
			setVisible(false);
			}
		});
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEnter.setBounds(262, 118, 86, 28);
		contentPane.add(btnEnter);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Main m = new Main();
			m.setVisible(true);
			setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(70, 118, 92, 27);
		contentPane.add(btnBack);
	}
}
