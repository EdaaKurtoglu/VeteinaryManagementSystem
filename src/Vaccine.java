import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Project.ConnectionProvider;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Vaccine extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JButton btnNewButton_3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vaccine frame = new Vaccine();
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
	public Vaccine() {

		setUndecorated(true);
		setLocation(new Point(280, 150));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 150, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Animal ID");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(157, 36, 76, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(236, 35, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				String petId=textField.getText();
		  		try
		  		{
		  			Connection conn = ConnectionProvider.getConn();
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("select *from vaccine where petId='"+petId+"'");
					if(rs.next()) {
					//System.out.print(rs.getString(1));
					
					 	textField.setEditable(false);
						textField_1.setText(rs.getString(2));
						textField_2.setText(rs.getString(3));
					}
					
		  		}catch(Exception e) {
		  			JOptionPane.showMessageDialog(null,e);
		  		}
			}
		});
		btnNewButton.setBounds(236, 60, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("PET NAME\r\n");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(157, 138, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("LAST DATE\r\n");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(157, 191, 99, 14);
		contentPane.add(lblNewLabel_2);
		btnNewButton_2 = new JButton("OKAY");
		
		lblNewLabel_3 = new JLabel("NEW DATE");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(70, 379, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(266, 132, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(266, 188, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		

		lblNewLabel_3.setVisible(false);
		btnNewButton_2.setVisible(false);
		
		textField_3 = new JTextField();
		textField_3.setBounds(181, 376, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		lblNewLabel_5 = new JLabel("ID");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(464, 113, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("NAME\r\n");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(464, 156, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("DATE");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(464, 211, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		textField_4 = new JTextField();
		textField_4.setBounds(553, 110, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(553, 153, 86, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(553, 208, 86, 20);
		contentPane.add(textField_6);
		
		btnNewButton_3 = new JButton("ADD");
		
		btnNewButton_3.setBounds(499, 240, 89, 23);
		contentPane.add(btnNewButton_3);
		
		
		textField_3.setVisible(false);
		lblNewLabel_3.setVisible(false);
		btnNewButton_2.setVisible(false);
		lblNewLabel_5.setVisible(false);
		lblNewLabel_6.setVisible(false);
		lblNewLabel_7.setVisible(false);
		textField_4.setVisible(false);
		textField_5.setVisible(false);
		textField_6.setVisible(false);
		btnNewButton_3.setVisible(false);
		
		btnNewButton_2.setBounds(181, 407, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("UPDATE DATE\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				textField_3.setVisible(true);
				lblNewLabel_3.setVisible(true);
				btnNewButton_2.setVisible(true);
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String petId=textField.getText();
						String Name =textField_1.getText();
						String LastDate = textField_3.getText();
						
						try {
						Connection conn = ConnectionProvider.getConn();
						PreparedStatement ps = conn.prepareStatement("update vaccine set Name=?,LastDate=? where petId=?");
						ps.setString(1, Name);
						ps.setString(2, LastDate);
						ps.setString(3, petId);
						ps.executeUpdate();
						
						JOptionPane.showMessageDialog(null,"SUCCESFULLY UPTADED");
						clear();
						textField.setEditable(true);
						
					}
					catch (Exception e)
					{
						JOptionPane.showMessageDialog(null,"Please enter data in correct form");
					}
						
					}
				});
				
			}
		});
		btnNewButton_1.setBounds(166, 219, 159, 23);
		contentPane.add(btnNewButton_1);
		
		
	
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("YES\r\n");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				lblNewLabel_5.setVisible(true);
				lblNewLabel_6.setVisible(true);
				lblNewLabel_7.setVisible(true);
				textField_4.setVisible(true);
				textField_5.setVisible(true);
				textField_6.setVisible(true);
				btnNewButton_3.setVisible(true);
				
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						String petId =textField_4.getText();
						String Name =textField_5.getText();
						String LastDate = textField_6.getText();
						
						
						try {
							 
							Connection conn = ConnectionProvider.getConn();
							Statement st = conn.createStatement();
							st.executeUpdate("INSERT into vaccine VALUES ('"+petId+"','"+Name+"','"+LastDate+"')");
							JOptionPane.showMessageDialog(null,"SUCCESFULLY UPTADED");
							setVisible(false);
							
						}
						catch (Exception e)
						{
							JOptionPane.showMessageDialog(null,"Please enter data in correct form");
						}
						
					}
				});
				
				
			}
		});
		chckbxNewCheckBox.setBounds(413, 60, 97, 23);
		contentPane.add(chckbxNewCheckBox);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("DO YOU WANT TO CREATE A NEW RECORD?");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(409, 42, 302, 11);
		contentPane.add(lblNewLabel_4);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(-37, 0, 937, 500);
		  contentPane.add(lblNewLabel_1);
		  Image img2=new ImageIcon(this.getClass().getResource("/back2.jpg")).getImage();
		  lblNewLabel_1.setIcon(new ImageIcon(img2));
		
		
		
		
		
	}
	public void clear() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		
	}
}
