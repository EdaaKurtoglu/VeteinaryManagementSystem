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

public class UpdateDeleteAnimal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private javax.swing.JComboBox<String>comboBox;
	private javax.swing.JComboBox<String>comboBox_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDeleteAnimal frame = new UpdateDeleteAnimal();
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
	public UpdateDeleteAnimal() {
		setUndecorated(true);
		setLocation(new Point(280, 150));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 150, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		  JLabel lblNewLabel = new JLabel("PET ID\r\n");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setBounds(220, 42, 112, 34);
			contentPane.add(lblNewLabel);
			
			JLabel lblPetName = new JLabel("PET NAME\r\n");
			lblPetName.setForeground(Color.WHITE);
			lblPetName.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblPetName.setBounds(220, 90, 112, 34);
			contentPane.add(lblPetName);
			
			JLabel lblGender = new JLabel("GENDER\r\n");
			lblGender.setBounds(220, 158, 112, 34);
			contentPane.add(lblGender);
			lblGender.setForeground(Color.WHITE);
			lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JLabel lblAgeinMonths = new JLabel("AGE (in months)");
			lblAgeinMonths.setBounds(220, 211, 112, 34);
			contentPane.add(lblAgeinMonths);
			lblAgeinMonths.setForeground(Color.WHITE);
			lblAgeinMonths.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JLabel lblOwnerAddress = new JLabel("OWNER ADDRESS");
			lblOwnerAddress.setBounds(220, 294, 112, 34);
			contentPane.add(lblOwnerAddress);
			lblOwnerAddress.setForeground(Color.WHITE);
			lblOwnerAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JLabel lblOwnerPhone = new JLabel("OWNER PHONE");
			lblOwnerPhone.setBounds(220, 345, 112, 34);
			contentPane.add(lblOwnerPhone);
			lblOwnerPhone.setForeground(Color.WHITE);
			lblOwnerPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JLabel lblAllergie = new JLabel("ALLERGIE");
			lblAllergie.setBounds(220, 406, 112, 34);
			contentPane.add(lblAllergie);
			lblAllergie.setForeground(Color.WHITE);
			lblAllergie.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			textField = new JTextField();
			textField.setBounds(445, 49, 86, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(445, 104, 129, 20);
			contentPane.add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(445, 218, 86, 20);
			contentPane.add(textField_2);
			
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(445, 282, 121, 59);
			contentPane.add(textField_3);
			
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(445, 352, 112, 20);
			contentPane.add(textField_4);
			
			comboBox= new JComboBox<String>();
			comboBox.setBounds(445, 164, 112, 22);
			contentPane.add(comboBox);
			comboBox.addItem("GENDER");
			comboBox.addItem("MALE");
			comboBox.addItem("FEMALE");
			
			comboBox_1= new JComboBox<String>();
			comboBox_1.setBounds(445, 471, 112, 22);
			contentPane.add(comboBox_1);
			comboBox_1.addItem("TYPES");
			comboBox_1.addItem("DOG");
			comboBox_1.addItem("CAT");
			comboBox_1.addItem("RABBIT");
			comboBox_1.addItem("HAMSTER");
			comboBox_1.addItem("BIRD");
			comboBox_1.addItem("OTHER");
			
			JLabel lblNewLabel2 = new JLabel("TYPE");
			lblNewLabel2.setBounds(220, 475, 46, 14);
			contentPane.add(lblNewLabel2);
			lblNewLabel2.setForeground(Color.WHITE);
			lblNewLabel2.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(445, 413, 106, 20);
			contentPane.add(textField_5);
			
			
			
			
			  JButton btnNewButton_1 = new JButton("SEARCH");
			  
			 
			  
			  btnNewButton_1.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent evt) {
			  		
			  		String idAnimal=textField.getText();
			  		try
			  		{
			  			Connection conn = ConnectionProvider.getConn();
						Statement st = conn.createStatement();
						ResultSet rs = st.executeQuery("select *from animal where idAnimal='"+idAnimal+"'");
						if(rs.next()) {
						 	textField.setEditable(false);
							textField_1.setText(rs.getString(2));
							comboBox.setSelectedItem(rs.getString(3));
							textField_2.setText(rs.getString(4));
							textField_3.setText(rs.getString(5));
							textField_4.setText(rs.getString(6));
							textField_5.setText(rs.getString(7));
							comboBox_1.setSelectedItem(rs.getString(8));
							
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
						String idAnimal=textField.getText();
						String name =textField_1.getText();
						String gender = (String)comboBox.getSelectedItem();
						String pet_age =textField_2.getText();
						String owner_address =textField_3.getText();
						String owner_phone =textField_4.getText();
						String allergies =textField_5.getText();
						String type =(String) comboBox_1.getSelectedItem();
						
						try {
							 
							Connection conn = ConnectionProvider.getConn();
							PreparedStatement ps = conn.prepareStatement("update animal set name=?,gender=?,pet_age=?,owner_address=?,owner_phone=?,allergie=?,type=? where idAnimal=?");
							ps.setString(1, name);
							ps.setString(2, gender);
							ps.setString(3, pet_age);
							ps.setString(4, owner_address);
							ps.setString(5, owner_phone);
							ps.setString(6, allergies);
							ps.setString(7, type);
							ps.setString(8, idAnimal);
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
				
				btnNewButton.setBounds(597, 190, 125, 113);
				contentPane.add(btnNewButton);
			  
				  JButton btnNewButton_2 = new JButton("DELETE\r\n");
				  btnNewButton_2.addActionListener(new ActionListener() {
				  	public void actionPerformed(ActionEvent evt) {
				  		
				  		String idAnimal =textField.getText();
				  		
				  		try
				  		{
				  			Connection conn = ConnectionProvider.getConn();
							Statement st = conn.createStatement();
							 st.executeUpdate("delete from animal where idAnimal='"+idAnimal+"'");
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
					lblNewLabel_1.setBounds(-37, 0, 937, 500);
					  contentPane.add(lblNewLabel_1);
					  Image img2=new ImageIcon(this.getClass().getResource("/back2.jpg")).getImage();
					  lblNewLabel_1.setIcon(new ImageIcon(img2));
			  
	}
	public void clear() {
		textField.setText("");
		textField_1.setText("");
		comboBox.setSelectedItem("GENDER");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		comboBox_1.setSelectedItem("GENDER");
		
	}

}
