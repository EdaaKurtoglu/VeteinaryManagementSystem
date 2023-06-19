import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class AdminPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
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
	public AdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ADD RECEPTIONIST");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AddReceptionist().setVisible(true);
			}
		});
		btnNewButton.setBounds(41, 65, 214, 39);
		contentPane.add(btnNewButton);
		
		JButton DeleteRec = new JButton("DELETE/UPDATE RECEPTIONIST\r\n\r\n");
		DeleteRec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateDeleteRec().setVisible(true);
			}
		});
		DeleteRec.setFont(new Font("Tahoma", Font.BOLD, 13));
		DeleteRec.setBounds(41, 134, 214, 39);
		contentPane.add(DeleteRec);
		
		JButton backButton = new JButton("BACK");
		backButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddAnimal().setVisible(false);
				new animalInfo().setVisible(false);
				
			}
		});
		backButton.setBounds(41, 536, 106, 39);
		contentPane.add(backButton);
		
		JButton listRec = new JButton("RECEPTIONIST LIST");
		listRec.setFont(new Font("Tahoma", Font.BOLD, 14));
		listRec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new List_Rcp().setVisible(true);
			}
		});
		listRec.setBounds(41, 198, 214, 39);
		contentPane.add(listRec);
		
		JButton btnAddVet = new JButton("ADD VET\r\n");
		btnAddVet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddVet().setVisible(true);
			}
		});
		btnAddVet.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddVet.setBounds(41, 273, 214, 39);
		contentPane.add(btnAddVet);
		
		JButton btnUpdateVet = new JButton("UPDATE/DELETE VET\r\n\r\n\r\n");
		btnUpdateVet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateDeleteVet().setVisible(true);
			}
		});
		btnUpdateVet.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdateVet.setBounds(41, 345, 214, 39);
		contentPane.add(btnUpdateVet);
		
		JButton listVet = new JButton("VET LIST");
		listVet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new List_Vet().setVisible(true);
			}
		});
		listVet.setFont(new Font("Tahoma", Font.BOLD, 14));
		listVet.setBounds(41, 421, 214, 39);
		contentPane.add(listVet);
		
		JButton btnExt = new JButton("EXIT\r\n");
		btnExt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminPage().setVisible(false);
				new EnterPage().setVisible(true);
			}
		});
		btnExt.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExt.setBounds(41, 593, 106, 39);
		contentPane.add(btnExt);
		
		  
		  JLabel lblNewLabel = new JLabel("");
		  lblNewLabel.setBounds(96, -27, 1350, 756);
		  contentPane.add(lblNewLabel);
		  Image img2=new ImageIcon(this.getClass().getResource("/back.jpg")).getImage();
		  lblNewLabel.setIcon(new ImageIcon(img2));
		
	}

}
