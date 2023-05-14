import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import adminPanel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.Font;
public class login extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 437);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(99, 106, 348, 184);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("password:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(62, 102, 74, 16);
		panel.add(lblNewLabel);
		
		JLabel lblKorisnickoIme = new JLabel("username:");
		lblKorisnickoIme.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKorisnickoIme.setBounds(62, 53, 74, 16);
		panel.add(lblKorisnickoIme);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setBounds(140, 136, 116, 25);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(140, 50, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(140, 99, 116, 22);
		panel.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("admin\r\n 123");
		lblNewLabel_2.setBounds(140, 11, 74, 28);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Student Management System");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(99, 35, 439, 36);
		contentPane.add(lblNewLabel_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminPanel admin_panel=new adminPanel();
				
				
				
					String nick=textField.getText();
					String password=String.valueOf(passwordField.getPassword());
					String value1="";
					String value2="";
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/_studentmanagement","root","");
						Statement st=con.createStatement();
			            ResultSet accInd=st.executeQuery("select * from admin where nickname ='"+nick + "'");
			            
			            while(accInd.next()) {
			            	value1=accInd.getString("nickname");
				            value2=accInd.getString("password");
			          
			            	if(nick.equals(value1) && password.equals(value2)) {
				            	dispose();
				            	admin_panel.setVisible(true);  	
				            }
				            else {
				            	JOptionPane.showMessageDialog(null,"Nisu tacni korisnicko ime ili sifra!");
				            }
			            }
			            con.close();
					}
					catch(Exception e1) {
						System.out.println(e1);
					}
				}

		});
	}
}
