import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
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
import java.awt.Font;
import java.awt.Color;

public class AddReceptionist extends JFrame {

	private JPanel contentPane;
	private JTextField ID;
	private JTextField vetName;
	private JTextField vetSurname;
	private JTextField vetAge;
	private JTextField vetPhone;
	private JTextField vetAddress;
	private JTextField vetSalary;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddReceptionist frame = new AddReceptionist();
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
	public AddReceptionist() {
		setUndecorated(true);
		setLocation(new Point(280, 150));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 150, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID\r\n");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(214, 72, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("NAME\r\n");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(214, 127, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("SURNAME\r\n");
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSurname.setBounds(214, 174, 71, 14);
		contentPane.add(lblSurname);
		
		JLabel lblAge = new JLabel("AGE\r\n");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAge.setForeground(Color.WHITE);
		lblAge.setBounds(214, 224, 46, 14);
		contentPane.add(lblAge);
		
		JLabel lblGender = new JLabel("GENDER\r\n");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(214, 274, 71, 14);
		contentPane.add(lblGender);
		
		JLabel lblPhone = new JLabel("PHONE\r\n");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setBounds(214, 323, 60, 14);
		contentPane.add(lblPhone);
		
		JLabel lblAddress = new JLabel("ADDRESS\r\n");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(214, 369, 71, 14);
		contentPane.add(lblAddress);
		
		JLabel lblSalary = new JLabel("SALARY\r\n");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalary.setForeground(Color.WHITE);
		lblSalary.setBounds(214, 413, 71, 14);
		contentPane.add(lblSalary);
		
		ID = new JTextField();
		ID.setBounds(355, 71, 86, 20);
		contentPane.add(ID);
		ID.setColumns(10);
		
		vetName = new JTextField();
		vetName.setColumns(10);
		vetName.setBounds(355, 124, 86, 20);
		contentPane.add(vetName);
		
		vetSurname = new JTextField();
		vetSurname.setColumns(10);
		vetSurname.setBounds(355, 171, 86, 20);
		contentPane.add(vetSurname);
		
		vetAge = new JTextField();
		vetAge.setColumns(10);
		vetAge.setBounds(355, 221, 86, 20);
		contentPane.add(vetAge);
		
		vetPhone = new JTextField();
		vetPhone.setColumns(10);
		vetPhone.setBounds(355, 320, 86, 20);
		contentPane.add(vetPhone);
		
		vetAddress = new JTextField();
		vetAddress.setColumns(10);
		vetAddress.setBounds(355, 366, 86, 20);
		contentPane.add(vetAddress);
		
		
		
		JComboBox vetGender = new JComboBox();
		vetGender.setBounds(355, 272, 86, 22);
		contentPane.add(vetGender);
		vetGender.addItem("GENDER");
		vetGender.addItem("MALE");
		vetGender.addItem("FEMALE");
		
		vetSalary = new JTextField();
		vetSalary.setColumns(10);
		vetSalary.setBounds(355, 412, 86, 20);
		contentPane.add(vetSalary);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String idReceptionist =ID.getText();
				String Name =vetName.getText();
				String Surname =vetSurname.getText();
				String Gender = (String)vetGender.getSelectedItem();
				String Age =vetAge.getText();
				String Address =vetAddress.getText();
				String Phone =vetPhone.getText();
				String Salary =vetSalary.getText();
				
				try {
					 
					Connection conn = ConnectionProvider.getConn();
					Statement st = conn.createStatement();
					st.executeUpdate("INSERT into receptionist VALUES ('"+idReceptionist+"','"+Name+"','"+Surname+"','"+Gender+"','"+Age+"','"+Address+"','"+Phone+"','"+Salary+"')");
					JOptionPane.showMessageDialog(null,"SUCCESFULLY UPTADED");
					setVisible(false);
					new AddVet().setVisible(true);
				}
				catch (Exception e1)
				{
					JOptionPane.showMessageDialog(null,"Please enter data in correct form");
				}
				
			}
		});
		btnNewButton.setBounds(618, 209, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		  lblNewLabel_1.setBounds(-37, 0, 937, 500);
		  contentPane.add(lblNewLabel_1);
		  Image img2=new ImageIcon(this.getClass().getResource("/back2.jpg")).getImage();
		  lblNewLabel_1.setIcon(new ImageIcon(img2));
	}

}
