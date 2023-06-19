import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Project.ConnectionProvider;

public class UpdateDeleteRec extends JFrame {


	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JComboBox comboBox;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDeleteRec frame = new UpdateDeleteRec();
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
	public UpdateDeleteRec() {
		setUndecorated(true);
		setLocation(new Point(280, 150));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 150, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		  JLabel lblNewLabel = new JLabel("RECEPTIONIST ID\r\n");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setBounds(220, 36, 112, 34);
			contentPane.add(lblNewLabel);
			
			JLabel lblPetName = new JLabel("NAME\r\n");
			lblPetName.setForeground(Color.WHITE);
			lblPetName.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblPetName.setBounds(220, 81, 112, 34);
			contentPane.add(lblPetName);
			
			JLabel lblGender = new JLabel("SURNAME\r\n");
			lblGender.setBounds(220, 115, 112, 34);
			contentPane.add(lblGender);
			lblGender.setForeground(Color.WHITE);
			lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JLabel lblAgeinMonths = new JLabel("AGE");
			lblAgeinMonths.setBounds(220, 160, 112, 34);
			contentPane.add(lblAgeinMonths);
			lblAgeinMonths.setForeground(Color.WHITE);
			lblAgeinMonths.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JLabel lblOwnerAddress = new JLabel("PHONE");
			lblOwnerAddress.setBounds(220, 245, 112, 34);
			contentPane.add(lblOwnerAddress);
			lblOwnerAddress.setForeground(Color.WHITE);
			lblOwnerAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JLabel lblOwnerPhone = new JLabel("ADDRESS");
			lblOwnerPhone.setBounds(220, 325, 112, 34);
			contentPane.add(lblOwnerPhone);
			lblOwnerPhone.setForeground(Color.WHITE);
			lblOwnerPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JLabel lblAllergie = new JLabel("SALARY");
			lblAllergie.setBounds(220, 386, 112, 34);
			contentPane.add(lblAllergie);
			lblAllergie.setForeground(Color.WHITE);
			lblAllergie.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			textField = new JTextField();
			textField.setBounds(445, 49, 86, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(445, 90, 129, 20);
			contentPane.add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(445, 124, 129, 20);
			contentPane.add(textField_2);
			
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(445, 165, 121, 28);
			contentPane.add(textField_3);
			
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(445, 254, 112, 20);
			contentPane.add(textField_4);
						
			
			
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(445, 334, 106, 20);
			contentPane.add(textField_5);
			
			textField_7 = new JTextField();
			  textField_7.setBounds(445, 395, 86, 20);
			  contentPane.add(textField_7);
			  textField_7.setColumns(10);
			  
			  JLabel lblGender_1 = new JLabel("GENDER\r\n");
			  lblGender_1.setForeground(Color.WHITE);
			  lblGender_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			  lblGender_1.setBounds(220, 205, 112, 34);
			  contentPane.add(lblGender_1);
			  
			   comboBox = new JComboBox();
			  comboBox.setBounds(445, 213, 120, 22);
			  contentPane.add(comboBox);
			  comboBox.addItem("GENDER");
			  comboBox.addItem("MALE");
			  comboBox.addItem("FEMALE");
			
			
			JButton btnNewButton_1 = new JButton("SEARCH");
			  
			 
			  
			  btnNewButton_1.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent evt) {
			  		
			  		String idReceptionist=textField.getText();
			  		try
			  		{
			  			Connection conn = ConnectionProvider.getConn();
						Statement st = conn.createStatement();
						ResultSet rs = st.executeQuery("select *from receptionist where idReceptionist='"+idReceptionist+"'");
						if(rs.next()) {
						//System.out.print(rs.getString(1));
						
						 	textField.setEditable(false);
							textField_1.setText(rs.getString(2));
							textField_2.setText(rs.getString(3));
							textField_3.setText(rs.getString(4));
							comboBox.setSelectedItem(rs.getString(5));
							textField_4.setText(rs.getString(6));
							textField_5.setText(rs.getString(7));
							textField_7.setText(rs.getString(8));
							
						}
						
			  		}catch(Exception e) {
			  			JOptionPane.showMessageDialog(null,e);
			  		}
			  	}
			  });
			  btnNewButton_1.setForeground(Color.BLACK);
			  btnNewButton_1.setBounds(597, 50, 89, 23);
			  contentPane.add(btnNewButton_1);
			  JButton btnNewButton = new JButton("UPDATE\r\n");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String idReceptionist=textField.getText();
						String Name =textField_1.getText();
						String Surname = textField_1.getText();
						String Age =textField_3.getText();
						String Gender =(String) comboBox.getSelectedItem();
						String Phone =textField_4.getText();
						String Address =textField_5.getText();
						String Salary =textField_7.getText();
						
						
						try {
							 
							Connection conn = ConnectionProvider.getConn();
							PreparedStatement ps = conn.prepareStatement("update receptionist set Name=?,Surname=?,Age=?,Gender=?,Phone=?,Address=?,Salary=? where idReceptionist=?");
							ps.setString(1, Name);
							ps.setString(2, Surname);
							ps.setString(3, Age);
							ps.setString(4, Gender);
							ps.setString(5, Phone);
							ps.setString(6, Address);
							ps.setString(7, Salary);
							ps.setString(8, idReceptionist);
							
							ps.executeUpdate();
							
							JOptionPane.showMessageDialog(null,"SUCCESFULLY UPTADED");
							textField.setEditable(true);
							clear();
							
						}
						catch (Exception e)
						{
							JOptionPane.showMessageDialog(null,"Please enter data in correct form");
						}
						
					}
				});
				
				btnNewButton.setBounds(597, 190, 125, 113);
				contentPane.add(btnNewButton);
			  
				 JButton btnNewButton_2 = new JButton("DELETE\r\n");
				  btnNewButton_2.addActionListener(new ActionListener() {
				  	public void actionPerformed(ActionEvent evt) {
				  		
				  		String idReceptionist =textField.getText();
				  		
				  		try
				  		{
				  			Connection conn = ConnectionProvider.getConn();
							Statement st = conn.createStatement();
							 st.executeUpdate("delete from receptionist where idReceptionist='"+idReceptionist+"'");
							 JOptionPane.showMessageDialog(null,"SUCCESFULLY DELETED");
								clear();
								textField.setEditable(true);
				  		}catch(Exception e) {
				  			JOptionPane.showMessageDialog(null,e);
				  		}
				  	}
				  });
				  btnNewButton_2.setBounds(612, 345, 89, 75);
				  contentPane.add(btnNewButton_2);
				  
				  
					  
					  
					  
					  JLabel lblNewLabel_1 = new JLabel("");
						lblNewLabel_1.setBounds(-37, -11, 937, 500);
						  contentPane.add(lblNewLabel_1);
						  Image img2=new ImageIcon(this.getClass().getResource("/back2.jpg")).getImage();
						  lblNewLabel_1.setIcon(new ImageIcon(img2));
						  
						
						  
	}					
	
	public void clear() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_7.setText("");
	}
}
