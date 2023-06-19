import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Project.ConnectionProvider;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntensiveCareRoom extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private javax.swing.JComboBox<String>comboBox;
	private javax.swing.JComboBox<String>comboBox_1;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JLabel lblNewLabel_3;
	private JTextField textField_13;
	private JButton btnNewButton;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntensiveCareRoom frame = new IntensiveCareRoom();
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
	public IntensiveCareRoom() {
		setUndecorated(true);
		setLocation(new Point(280, 150));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 150, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Room1");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(57, 65, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Room 2");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(57, 114, 60, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Room 3\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(57, 164, 60, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Room 4\r\n");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(57, 226, 60, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Room 5\r\n\r\n");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(57, 280, 60, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Room 6\r\n");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_3.setBounds(57, 348, 60, 14);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Room 7\r\n");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_4.setBounds(57, 409, 60, 14);
		contentPane.add(lblNewLabel_2_4);
		
		textField_6 = new JTextField();
		textField_6.setBounds(153, 63, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(153, 112, 86, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(153, 162, 86, 20);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(153, 224, 86, 20);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(153, 278, 86, 20);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(153, 346, 86, 20);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(153, 407, 86, 20);
		contentPane.add(textField_12);
		
		lblNewLabel_3 = new JLabel("Please select the room number you want to edit");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(485, 66, 327, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_13 = new JTextField();
		textField_13.setBounds(495, 91, 143, 20);
		contentPane.add(textField_13);
		textField_13.setColumns(10);
		
		btnNewButton = new JButton("Select\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField_13.getText().equals("1")) {
					
					textField_6.setEditable(true);
					textField_14.setEditable(true);
					
				}
				else if(textField_13.getText().equals("2")) {
					textField_7.setEditable(true);
					textField_15.setEditable(true);
					
				}
				else if(textField_13.getText().equals("3")) {
					
					textField_8.setEditable(true);
					textField_16.setVisible(true);
					
				}
				else if(textField_13.getText().equals("4")) {
					
					textField_9.setEditable(true);
					textField_17.setEditable(true);
					
				}
				else if(textField_13.getText().equals("5")) {
					
					textField_10.setEditable(true);
					textField_18.setEditable(true);
					
				}
				else if(textField_13.getText().equals("6")) {
					
					textField_11.setEditable(true);
					textField_19.setEditable(true);
					
				}
				else if(textField_13.getText().equals("7")) {
					
					textField_12.setEditable(true);
					textField_20.setEditable(true);
				}
				
				
			}
		});
		btnNewButton.setBounds(662, 90, 75, 21);
		contentPane.add(btnNewButton);
		
		textField_14 = new JTextField();
		textField_14.setBounds(249, 63, 86, 20);
		contentPane.add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(249, 112, 86, 20);
		contentPane.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(249, 162, 86, 20);
		contentPane.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(249, 224, 86, 20);
		contentPane.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(249, 278, 86, 20);
		contentPane.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(249, 346, 86, 20);
		contentPane.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(249, 407, 86, 20);
		contentPane.add(textField_20);
		
		btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String available="";
				String petName = "";
				String idRoom=textField_13.getText();
				if(idRoom.equals("1")) {
		
					available =textField_6.getText();
					 petName=textField_14.getText();
					 
				}
				else if(idRoom.equals("2")) {
					 available =textField_7.getText();
					petName=textField_15.getText();
				}
				else if(idRoom.equals("3")) {
					 available =textField_8.getText();
					 petName=textField_16.getText();
				}
				else if(idRoom.equals("4")) {
					 available =textField_9.getText();
					 petName=textField_17.getText();
				}
				else if(idRoom.equals("5")) {
					 available =textField_10.getText();
					 petName=textField_18.getText();
				}
				else if(idRoom.equals("6")) {
					 available =textField_11.getText();
					 petName=textField_19.getText();
				}
				else if(idRoom.equals("7")) {
					 available =textField_12.getText();
					 petName=textField_20.getText();
				}
				try {
					 
					Connection conn = ConnectionProvider.getConn();
					PreparedStatement ps = conn.prepareStatement("update intensivecare set available=?,petName=? where idRoom=?");
					ps.setString(1, available);
					ps.setString(2, petName);
					ps.setString(3, idRoom);
					
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"SUCCESFULLY UPTADED");
					
					
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null,"Please enter data in correct form");
				}
				
				
			
			}
		});
		btnNewButton_1.setBounds(474, 223, 89, 23);
		contentPane.add(btnNewButton_1);
		
		String idRoom="1";
		for(int i=0;i<7;i++) {
  		try
  		{
  			
  			Connection conn = ConnectionProvider.getConn();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select *from intensivecare where idRoom='"+idRoom+"'");
			if(rs.next()) {
				if(idRoom.equals("1")) {
					textField_6.setText(rs.getString(2));
					textField_14.setText(rs.getString(3));
					textField_6.setEditable(false);
					textField_14.setEditable(false);
					idRoom="2";
				}
				else if(idRoom.equals("2")) {
					textField_7.setText(rs.getString(2));
					textField_15.setText(rs.getString(3));
					textField_7.setEditable(false);
					textField_15.setEditable(false);
					idRoom="3";
				}
				else if(idRoom.equals("3")) {
					textField_8.setText(rs.getString(2));
					textField_16.setText(rs.getString(3));
					textField_8.setEditable(false);
					textField_16.setEditable(false);
					idRoom="4";
				}
				else if(idRoom.equals("4")) {
					textField_9.setText(rs.getString(2));
					textField_17.setText(rs.getString(3));
					textField_9.setEditable(false);
					textField_17.setEditable(false);
					idRoom="5";
				}
				else if(idRoom.equals("5")) {
					textField_10.setText(rs.getString(2));
					textField_18.setText(rs.getString(3));
					textField_10.setEditable(false);
					textField_18.setEditable(false);
					idRoom="6";
				}
				else if(idRoom.equals("6")) {
					textField_11.setText(rs.getString(2));
					textField_19.setText(rs.getString(3));
					textField_11.setEditable(false);
					textField_19.setEditable(false);
					idRoom="7";
				}
				else if(idRoom.equals("7")) {
					textField_12.setText(rs.getString(2));
					textField_20.setText(rs.getString(3));
					textField_12.setEditable(false);
					textField_20.setEditable(false);
				}
				
			}
			
  		}catch(Exception e) {
  			JOptionPane.showMessageDialog(null,e);
  		}
  		
  		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(-37, 0, 937, 500);
		  contentPane.add(lblNewLabel_4);
		  Image img2=new ImageIcon(this.getClass().getResource("/back2.jpg")).getImage();
		  lblNewLabel_4.setIcon(new ImageIcon(img2));
		}
		
	}
	
}
