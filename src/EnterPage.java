import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class EnterPage extends JFrame {
	
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/pet_clinic";

    static final String USER = "root";
    static final String PASS = "123456.Abc";
    
    
   

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnterPage frame = new EnterPage();
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
	
	
    

	public EnterPage() {
		String[][] loginP = new String[3][3];
		Connection conn = null;
	    Statement stmt = null;
	    int x=0, y=0;
	    
	    try{
	    	Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(DB_URL, USER, PASS);
	        stmt = conn.createStatement();
	        String sql = "SELECT usertype, username, password FROM login";
	        ResultSet rs = stmt.executeQuery(sql);
	        while(rs.next()){
	        	y=0;
	            loginP[x][y] = rs.getString("usertype");
	            y++;
	            loginP[x][y] = rs.getString("username");
	            y++;
	            loginP[x][y] = rs.getString("password");
	           x++;
	           
	//Verileri görüntüle - yaz
	           
	           
	        }
	        rs.close();
	    }catch(SQLException se){
	        se.printStackTrace();
	    }catch(Exception e){
	        e.printStackTrace();
	    }finally{
	        try{
	            if(stmt!=null)
	                conn.close();
	        }catch(SQLException se){
	        }
	        try{
	            if(conn!=null)
	                conn.close();
	        }catch(SQLException se){
	            se.printStackTrace();
	        }
	    }
	        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(25, 25, 25, 25));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel username = new JLabel("USERNAME");
		username.setForeground(Color.WHITE);
		username.setFont(new Font("Tahoma", Font.BOLD, 14));
		username.setBounds(59, 66, 100, 30);
		contentPane.add(username);
		
		
		
		JLabel password = new JLabel("PASSWORD");
		password.setForeground(Color.WHITE);
		password.setFont(new Font("Tahoma", Font.BOLD, 14));
		password.setBounds(59, 107, 100, 30);
		contentPane.add(password);
		
		
		JTextField F_user = new JTextField();
		F_user.setBackground(new Color(176, 224, 230));
		F_user.setBounds(175, 64, 200, 30);
		contentPane.add(F_user);
	         
	    JPasswordField F_pass=new JPasswordField();
	    F_pass.setBackground(new Color(176, 224, 230));
	    F_pass.setBounds(175, 105, 200, 30);
	    contentPane.add(F_pass);
	    
	    Button login_button = new Button("Login");
	    login_button.setBackground(new Color(188, 143, 143));
	    login_button.setForeground(new Color(0, 0, 0));
	    login_button.setBounds(198, 143, 116, 30);
	    contentPane.add(login_button);
	    
	    JLabel user_types = new JLabel("USER TYPE");
	    user_types.setFont(new Font("Tahoma", Font.BOLD, 14));
	    user_types.setForeground(Color.WHITE);
	    user_types.setBounds(61, 34, 98, 14);
	    contentPane.add(user_types);
	    
	    JComboBox userType = new JComboBox();
	    userType.setBounds(175, 32, 200, 22);
	    contentPane.add(userType);
	    userType.addItem("");
	    userType.addItem("Admin");
	    userType.addItem("Receptionist");
	    userType.addItem("Vet");
	    
	    JLabel lblNewLabel = new JLabel("");
	    lblNewLabel.setBackground(Color.GRAY);
	    Image img=new ImageIcon(this.getClass().getResource("/login.png")).getImage();
	    lblNewLabel.setIcon(new ImageIcon(img));
	    lblNewLabel.setBounds(0, 0, 434, 261);
	    contentPane.add(lblNewLabel);
	    
	    userType.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		
	    		
	    		login_button.addActionListener(new ActionListener() {  //Perform action
	    	    	
	    		    public void actionPerformed(ActionEvent e){ 
	    		    	 
	    		        String username = F_user.getText(); //Store username entered by the user in the variable "username"
	    		        String password = F_pass.getText(); //Store password entered by the user in the variable "password"
	    		        String user_type = (String) userType.getSelectedItem();
	    		        
	    		       while(true) {
	    		        if(username.equals("") && password.equals("") ) //If username and password is null
	    		        {
	    		            JOptionPane.showMessageDialog(null,"Please enter username and password"); //Display dialog box with the message
	    		        } 
	    		        else if(username.equals("")) //If username is null
	    		        {
	    		            JOptionPane.showMessageDialog(null,"Please enter username"); //Display dialog box with the message
	    		        }
	    		        else if(password.equals("")) //If password is null
	    		        {
	    		            JOptionPane.showMessageDialog(null,"Please enter password"); //Display dialog box with the message
	    		        }
	    		        else { 
	   
	    		        	if(user_type.equals("Admin")) {
	    		        			if(username.equals(loginP[0][1]) && password.equals(loginP[0][2]))
	    		        				setVisible(false);
	    		        				new AdminPage().setVisible(true);
	    		        				break;
	    		        				
	    		        			
	    		        	 }
	    		        	else if(user_type.equals("Receptionist")) {
    		        			if(username.equals(loginP[1][1]) && password.equals(loginP[1][2]))
    		        				setVisible(false);
    		        			new ReceptionistPage().setVisible(true);
    		        			break;
    		        				
    		        				
    		        			
    		        	 }
	    		        	else if(user_type.equals("Vet")) {
    		        			if(username.equals(loginP[2][1]) && password.equals(loginP[2][2]))
    		        				setVisible(false);
    		        				new VetPage().setVisible(true);
    		        				break;
    		        			
    		        	 }	
	    		        	
	    		        	
	    		        	
	    		        	
	    	            }
	    		    }
	    		    }
	    	});
	    		
	    		
	    	}
	    });
	   
	
	  
	    
	    
	    }
}