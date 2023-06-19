import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Project.ConnectionProvider;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class animalInfo extends JFrame 
{

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					animalInfo frame = new animalInfo();
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
	public animalInfo() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(280, 150,900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		table = new JTable();
		
		table.addComponentListener(new ComponentAdapter()
		{
		
			public void componentShown(ComponentEvent evt) {
				
				try {
					Connection conn = ConnectionProvider.getConn();
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("select *from animal inner join report where animal.idAnimal=report.idAnimal");
					table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
					while(rs.next()) {
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null,"Connection Error");
				}
			}
		});
		table.setBounds(99, 56, 610, 361);
		contentPane.add(table);
	
		
		
		//////////////////////////////////////////////////////////////////////////
	
				JFrame frame2 = new JFrame("Database Results");
               frame2.setLayout(new FlowLayout());
               frame2.setSize(800, 600);
     
				//Setting the properties of JTable and DefaultTableModel
				DefaultTableModel defaultTableModel = new DefaultTableModel();
	            table = new JTable(defaultTableModel);
	            table.setPreferredScrollableViewportSize(new Dimension(600, 600));
	            table.setFillsViewportHeight(true);
	            frame2.add(new JScrollPane(table));
	            defaultTableModel.addColumn("idAnimal");
	            defaultTableModel.addColumn("name");
	            defaultTableModel.addColumn("gender");
	            defaultTableModel.addColumn("pet_age");
	            defaultTableModel.addColumn("owner_address");
	            defaultTableModel.addColumn("owner_phone");
	            defaultTableModel.addColumn("allergie");
	            defaultTableModel.addColumn("type");
	            
	            try
	            {
	                
	            	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_clinic", "root", "root");
	                Statement  statement = connection.createStatement();
	                String query = "select * from animal ";
	                ResultSet resultSet = statement.executeQuery(query);
	     
	     
	                while (resultSet.next())
	                {
	                    String ID = resultSet.getString("idAnimal");
	                    String name = resultSet.getString("name");
	                    String g = resultSet.getString("gender");
	                    String pa = resultSet.getString("pet_age");
	                    String od = resultSet.getString("owner_address");
	                    String op  = resultSet.getString("owner_phone");
	                    String aller = resultSet.getString("allergie");
	                    String ty = resultSet.getString("type");
	                    
	                     
	                       
	                        defaultTableModel.addRow(new Object[]{ID, name, g, pa,od,op,aller,ty});
	                        contentPane.setVisible(false);
	                        frame2.setVisible(true);
	                        frame2.validate();
	                       
	     
	                }
	     	             
	            }
	            catch (SQLException throwables) 
	            {
	                throwables.printStackTrace();
	            }
			
		
		////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(657, 444, 89, 23);
		contentPane.add(btnNewButton);
		JLabel lblNewLabel_1 = new JLabel("");
		  lblNewLabel_1.setBounds(0, 0, 934, 511);
		  contentPane.add(lblNewLabel_1);
//		  Image img2=new ImageIcon(this.getClass().getResource("/back2.jpg")).getImage();
//		  lblNewLabel_1.setIcon(new ImageIcon(img2));
	}
}


