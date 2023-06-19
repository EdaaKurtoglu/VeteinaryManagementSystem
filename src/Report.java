import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Project.ConnectionProvider;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.proteanit.sql.DbUtils;
import javax.swing.table.DefaultTableModel;

public class Report extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JCheckBox chckbxYes;
	public int flag=0;
	public String operation ="";
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField textField_4;
	DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report frame = new Report();
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
	public Report() {
		flag=0;
				
		setUndecorated(true);
		setLocation(new Point(280, 150));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 150, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ANIMAL ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(282, 50, 94, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(414, 49, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		model.addColumn("Id");
        model.addColumn("name");
        model.addColumn("gender");
        model.addColumn("age");
        model.addColumn("owner_address");
        model.addColumn("owner_phone");
        model.addColumn("allergie");
        model.addColumn("type");
		
		JButton btnNewButton = new JButton("SEARCH");
		
		lblNewLabel_1 = new JLabel("Animal ID does not exist!!");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(388, 87, 197, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String idAnimal=textField.getText();
				
				try {
					Connection conn = ConnectionProvider.getConn();
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("select *from animal where idAnimal='"+idAnimal+"'");
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,"Connection Error");
				}
			}
		});
		btnNewButton.setBounds(575, 48, 89, 23);
		contentPane.add(btnNewButton);
		
		
		lblNewLabel_2 = new JLabel("Symptom's");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(198, 229, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Diagnosis\r\n");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(198, 299, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Medıcınes");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(194, 378, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		  chckbxYes = new JCheckBox("YES\r\n");
		chckbxYes.setFont(new Font("Tahoma", Font.BOLD, 13));
		  chckbxYes.setForeground(Color.BLACK);
		  chckbxYes.setBounds(658, 369, 97, 23);
		  contentPane.add(chckbxYes);
		  lblNewLabel_5 = new JLabel("Required Operation?");
		  lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		  lblNewLabel_5.setBounds(499, 379, 137, 14);
		  contentPane.add(lblNewLabel_5);
		  
		  
		  textField_4 = new JTextField();
		  textField_4.setBounds(659, 408, 126, 20);
		  contentPane.add(textField_4);
		  textField_4.setColumns(10);
		  lblNewLabel_6 = new JLabel("Operation Type\r\n");
		  lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		  lblNewLabel_6.setBounds(544, 410, 104, 14);
		  contentPane.add(lblNewLabel_6);
		  
		  lblNewLabel_6.setVisible(false);
		  textField_4.setVisible(false);
		
		textField_1 = new JTextField();
		textField_1.setBounds(290, 219, 157, 39);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(290, 289, 157, 39);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(290, 368, 157, 39);
		contentPane.add(textField_3);
		
		btnNewButton_1 = new JButton("SAVE\r\n");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(229, 446, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
	
		
		  chckbxYes.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		
		  		if(chckbxYes.isSelected()) {
		  			 lblNewLabel_6.setVisible(true);
		  			  textField_4.setVisible(true);
		  			  flag=1;
		  			  
		  		}
		  		else flag=0;
		  		
		  		btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
					
						String idAnimal=textField.getText();
						String symptom=textField_1.getText();
						String diagnosis=textField_2.getText();
						String medicine=textField_3.getText();
						if(flag==1) operation = textField_4.getText();
						else operation="Not Required!";
						try {
							Connection conn=ConnectionProvider.getConn();
							Statement st = conn.createStatement();
							st.executeUpdate("insert into report values ('"+idAnimal+"','"+symptom+"', '"+diagnosis+"','"+medicine+"','"+operation+"')");
							JOptionPane.showMessageDialog(null,"SUCCESFULLY UPDATED!!");
							setVisible(false);
							new Report().setVisible(true);
							
						
						}catch(Exception e1) {
							
							JOptionPane.showMessageDialog(null,this);
						}
						
						
					}
					});
		  	}
		  });
		  
		  
		  
		btnNewButton_2 = new JButton("CLOSE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(388, 446, 89, 23);
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(-25, 0, 937, 500);
		  contentPane.add(lblNewLabel_1);
		  Image img2=new ImageIcon(this.getClass().getResource("/back2.jpg")).getImage();
		  lblNewLabel_1.setIcon(new ImageIcon(img2));
		  
		  
		 
		  
		  
		 
	}
}
