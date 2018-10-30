package org.mm.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.mm.dao.BillC;
import org.mm.pojo.GuestDetails;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class FoodG extends JFrame {

	private JPanel contentPane;
	private JTable Items;
	private JTable table_1;
	private int totalFoodCost = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodG frame = new FoodG(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public FoodG(GuestDetails gd) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{204, 73, 0, 92, 0, 176, 51, 0};
		gbl_contentPane.rowHeights = new int[]{29, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblFood = new JLabel("MENU");
		lblFood.setHorizontalAlignment(SwingConstants.CENTER);
		lblFood.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFood.setBounds(0, 0, 816, 74);
		GridBagConstraints gbc_lblFood = new GridBagConstraints();
		gbc_lblFood.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblFood.insets = new Insets(0, 0, 5, 5);
		gbc_lblFood.gridx = 1;
		gbc_lblFood.gridy = 0;
		contentPane.add(lblFood, gbc_lblFood);
		
		JLabel lblMenu = new JLabel("Itemsss List :");
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMenu.setBounds(30, 114, 185, 31);
		GridBagConstraints gbc_lblMenu = new GridBagConstraints();
		gbc_lblMenu.anchor = GridBagConstraints.WEST;
		gbc_lblMenu.insets = new Insets(0, 0, 5, 5);
		gbc_lblMenu.gridx = 0;
		gbc_lblMenu.gridy = 2;
		contentPane.add(lblMenu, gbc_lblMenu);
		
		JLabel lblYouHaveSelected = new JLabel("You have selected :");
		lblYouHaveSelected.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblYouHaveSelected.setBounds(429, 114, 185, 31);
		GridBagConstraints gbc_lblYouHaveSelected = new GridBagConstraints();
		gbc_lblYouHaveSelected.anchor = GridBagConstraints.WEST;
		gbc_lblYouHaveSelected.insets = new Insets(0, 0, 5, 5);
		gbc_lblYouHaveSelected.gridx = 5;
		gbc_lblYouHaveSelected.gridy = 2;
		contentPane.add(lblYouHaveSelected, gbc_lblYouHaveSelected);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridheight = 10;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		Items = new JTable();
		
		Items.setBorder(new LineBorder(new Color(0, 0, 0)));
		Items.setModel(new DefaultTableModel(
			new Object[][] {
				{"FF", 100},
				{"Pohe", 20},
				{"Burger", 90},
				{"Sandwitch", 40},
			},
			new String[] {
				"Food Items", "Cost"
			}
		));
		scrollPane.setColumnHeaderView(Items);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 10;
		gbc_scrollPane_1.gridwidth = 4;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 3;
		gbc_scrollPane_1.gridy = 3;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Food Item", "Price"
			}
		){
			boolean[] columnEditables = new boolean[] {
				true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setColumnHeaderView(table_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				   TableModel tm1 = Items.getModel();
			        int indexes[] = Items.getSelectedRows();
			        
			        Object[] row =new Object[2];
			        
			        DefaultTableModel model2 =  (DefaultTableModel)table_1.getModel();      
			        for(int i = 0 ;i<indexes.length ;i++)
			        {
			            row[0] = tm1.getValueAt(indexes[i], 0);
			            row[1] = tm1.getValueAt(indexes[i], 1);
			            
			            model2.addRow(row);
			        }
			}
		});
		btnAdd.setBounds(378, 531, 97, 31);
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.anchor = GridBagConstraints.WEST;
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 17;
		contentPane.add(btnAdd, gbc_btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				for( int i = 0 ; i < table_1.getRowCount() ; i++ )
				{
					 totalFoodCost += (int)table_1.getModel().getValueAt(i, 1) ;
				}
				
				try
				{
					new BillC().updateFoodCost(gd, totalFoodCost) ;
				} 
				catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				setVisible(false);				
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 3;
		gbc_btnBack.gridy = 17;
		contentPane.add(btnBack, gbc_btnBack);
	}
}