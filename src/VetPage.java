import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VetPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VetPage frame = new VetPage();
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
	public VetPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ADD ANIMAL");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AddAnimal().setVisible(true);
			}
		});
		btnNewButton.setBounds(41, 63, 155, 39);
		contentPane.add(btnNewButton);
		
		JButton DeleteAnmal = new JButton("UPDATE/DELETE \r\nANIMAL\r\n");
		DeleteAnmal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new UpdateDeleteAnimal().setVisible(true);
			}
		});
		DeleteAnmal.setFont(new Font("Tahoma", Font.BOLD, 13));
		DeleteAnmal.setBounds(41, 126, 207, 39);
		contentPane.add(DeleteAnmal);
		
		JButton backButton = new JButton("BACK");
		backButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddAnimal().setVisible(false);
				new animalInfo().setVisible(false);
				new UpdateDeleteAnimal().setVisible(false);
				new Report().setVisible(false);
				
				
			}
		});
		backButton.setBounds(41, 596, 106, 39);
		contentPane.add(backButton);
		
		
		JButton btnExt = new JButton("EXIT\r\n");
		btnExt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new VetPage().setVisible(false);
				new EnterPage().setVisible(true);
			}
		});
		btnExt.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExt.setBounds(41, 664, 106, 39);
		contentPane.add(btnExt);
		
		JButton btnNewButton_1 = new JButton("ANIMAL LIST");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new animalInfo().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(41, 191, 155, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("PRESCRIPTION\r\n");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Report().setVisible(true);
			}
		});
		
		JButton btnNewButton_1_2 = new JButton("VACCINE");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Vaccine().setVisible(true);
			}
		});
		  btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		  btnNewButton_1_2.setBounds(41, 253, 155, 39);
		  contentPane.add(btnNewButton_1_2);
		  
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1.setBounds(41, 310, 155, 39);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		  lblNewLabel.setBounds(96, -27, 1350, 756);
		  contentPane.add(lblNewLabel);
		  Image img2=new ImageIcon(this.getClass().getResource("/back.jpg")).getImage();
		  lblNewLabel.setIcon(new ImageIcon(img2));
		  
		  
	}
}
