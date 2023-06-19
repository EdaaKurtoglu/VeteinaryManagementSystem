import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Project.ConnectionProvider;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddAnimal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private javax.swing.JComboBox<String>comboBox;
	private javax.swing.JComboBox<String>comboBox_1;

	   private PreparedStatement selectAllAnimal; 
	   private PreparedStatement selectAnimalByID; 
	   private PreparedStatement insertNewAnimal; 
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAnimal frame = new AddAnimal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AddAnimal() {
		
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
		
		JLabel lblNewLabel_1 = new JLabel("TYPE");
		lblNewLabel_1.setBounds(220, 475, 46, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(445, 413, 106, 20);
		contentPane.add(textField_5);
		
		JButton btnNewButton = new JButton("ADD\r\n");
		
		btnNewButton.setBounds(597, 190, 125, 113);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				
				String idAnimal =textField.getText();
				String name =textField_1.getText();
				String gender = (String)comboBox.getSelectedItem();
				String pet_age =textField_2.getText();
				String owner_address =textField_3.getText();
				String owner_phone =textField_4.getText();
				String allergies =textField_5.getText();
				String type =(String) comboBox_1.getSelectedItem();
				
				try {
					 
					Connection conn = ConnectionProvider.getConn();
					Statement st = conn.createStatement();
					st.executeUpdate("INSERT into animal VALUES ('"+idAnimal+"','"+name+"','"+gender+"','"+pet_age+"','"+owner_address+"','"+owner_phone+"','"+allergies+"','"+type+"')");
					JOptionPane.showMessageDialog(null,"SUCCESFULLY UPTADED");
					setVisible(false);
					new AddAnimal().setVisible(true);
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(null,"Please enter data in correct form");
				}
				
				
				
				
				
			}
		});
		JLabel lblNewLabel_11 = new JLabel("");
		  lblNewLabel_11.setBounds(0, 0, 900, 515);
		  contentPane.add(lblNewLabel_11);
		  Image img2=new ImageIcon(this.getClass().getResource("/back2.jpg")).getImage();
		  lblNewLabel_11.setIcon(new ImageIcon(img2));
	}
	
	
	
}
