import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

public class ReceptionistPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceptionistPage frame = new ReceptionistPage();
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
	public ReceptionistPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("ADD ANIMAL");
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AddAnimal().setVisible(true);
			}
		});
		btnNewButton.setBounds(22, 58, 230, 59);
		contentPane.add(btnNewButton);
		
		JButton UpdateAnmal = new JButton("UPDATE/DELETE\r\n ANIMAL\r\n");
		UpdateAnmal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateDeleteAnimal().setVisible(true);
			}
		});
		UpdateAnmal.setFont(new Font("Tahoma", Font.BOLD, 14));
		UpdateAnmal.setBounds(22, 146, 230, 59);
		contentPane.add(UpdateAnmal);
		
		JButton backButton = new JButton("BACK");
		backButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddAnimal().setVisible(false);
				new animalInfo().setVisible(false);
				new UpdateDeleteAnimal().setVisible(false);
				
			}
		});
		backButton.setBounds(41, 422, 106, 39);
		contentPane.add(backButton);
		
		JButton btnNewButton_1 = new JButton("ANIMAL LIST");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new animalInfo().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(22, 236, 229, 59);
		contentPane.add(btnNewButton_1);
		
		JButton btnExt = new JButton("EXIT\r\n");
		btnExt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ReceptionistPage().setVisible(false);
				new EnterPage().setVisible(true);
			}
		});
		btnExt.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExt.setBounds(41, 664, 106, 39);
		contentPane.add(btnExt);
		
		  JButton btnNewButton_2 = new JButton("INTENSIVE CARE");
		  btnNewButton_2.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		
		  	 new IntensiveCareRoom().setVisible(true);
		  	}
		  });
		  btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		  btnNewButton_2.setBounds(22, 337, 220, 59);
		  contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		  lblNewLabel.setBounds(-10, 0, 1350, 756);
		  contentPane.add(lblNewLabel);
		  Image img2=new ImageIcon(this.getClass().getResource("/back.jpg")).getImage();
		  lblNewLabel.setIcon(new ImageIcon(img2));
		  
		
	}
}
