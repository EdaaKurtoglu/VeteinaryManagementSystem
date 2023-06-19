import java.awt.BorderLayout;
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
public class List_Rcp extends JFrame 
{

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List_Rcp frame = new List_Rcp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public List_Rcp() 
	{
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
				
				try
				{
					Connection conn = ConnectionProvider.getConn();
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("select *from animal inner join report where animal.idAnimal=report.idAnimal");
					table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
					while(rs.next()) 
					{
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					
					
				}
				catch(Exception e) 
				{
					JOptionPane.showMessageDialog(null,"Connection Error");
				}
			}
		});
		table.setBounds(99, 56, 610, 361);
		contentPane.add(table);
	
	            
	    /////////////////////////////////////////////////////////////////////
	            JFrame frame3 = new JFrame();
	               frame3.setLayout(new FlowLayout());
	               frame3.setSize(800, 600);
	     
					//Setting the properties of JTable and DefaultTableModel
					DefaultTableModel TableModel = new DefaultTableModel();
		            table = new JTable(TableModel);
		            table.setPreferredScrollableViewportSize(new Dimension(600, 600));
		            table.setFillsViewportHeight(true);
		            frame3.add(new JScrollPane(table));
		            TableModel.addColumn("idreceptionist");
		            TableModel.addColumn("Name");
		            TableModel.addColumn("Surname");
		            TableModel.addColumn("Phone");
		            TableModel.addColumn("Address");
		            TableModel.addColumn("Salary");
		            
		            
		            try
		            {
		                
		            	Connection connectionn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pet_clinic", "root", "123456.Abc");
		                Statement  statementt = connectionn.createStatement();
		                String queryy = "select * from receptionist ";
		                ResultSet resultSett = statementt.executeQuery(queryy);
		     
		     
		                while (resultSett.next())
		                {
		                    String ID = resultSett.getString("idreceptionist");
		                    String name = resultSett.getString("Name");
		                    String sur = resultSett.getString("Surname");
		                    String pho  = resultSett.getString("Phone");
		                    String addr = resultSett.getString("Address");
		                    String slr = resultSett.getString("Salary");
		                    
		                     
		                       
		                        TableModel.addRow(new Object[]{ID, name, sur , pho,addr,slr});
		                    
		                        frame3.setVisible(true);
		                        frame3.validate();
		                      
		                }
		     	             
		            }
		            catch (SQLException throwables) 
		            {
		                throwables.printStackTrace();
		            }
				
			
	            
	     ///////////////////////////////////////////////////////////////////
		
		
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
	  Image img2=new ImageIcon(this.getClass().getResource("/back2.jpg")).getImage();
	  lblNewLabel_1.setIcon(new ImageIcon(img2));
	}
}


