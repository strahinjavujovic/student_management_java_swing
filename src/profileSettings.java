import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.mysql.cj.jdbc.Blob;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
public class profileSettings extends JFrame {

	private static JPanel contentPane;
	public static JTextField textField;
	private static JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					profileSettings frame = new profileSettings();
					frame.setVisible(true);
					frame.addWindowListener(new WindowAdapter() {
					      public void windowOpened(WindowEvent ev) {
					    	  showData();
					      }
					      
					    
					});
					 if(frame.isVisible()) {
						 showData();
				     }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the frame.
	 */
	String s="";
	public static void showData() {
		try {
			JLabel profilePicture=new JLabel();
			profilePicture.setBounds(394, 32, 274, 413);
			contentPane.add(profilePicture);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/_studentmanagement","root","");
			Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from admin where id=1");
			rs.next();
            String value1=rs.getString("nickname");
            String value2=rs.getString("password");
            
            textField_1.setText(value2);
            textField.setText(""+value1);
            con.close();
		}
		catch(Exception e1) {
			System.out.println(e1);
		}
	
}
	public profileSettings() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 517);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnNewButton.setBounds(33, 13, 80, 25);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(171, 80, 373, 229);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnSacuvajPodatke = new JButton("Change data");
		btnSacuvajPodatke.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnSacuvajPodatke.setBounds(118, 132, 149, 25);
		panel.add(btnSacuvajPodatke);
		
		textField = new JTextField("");
		textField.setBounds(150, 46, 188, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 78, 188, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNoviNickname = new JLabel("New nickname:");
		lblNoviNickname.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNoviNickname.setBounds(38, 48, 102, 16);
		panel.add(lblNoviNickname);
		
		JLabel lblNovaSifra = new JLabel("New Password:");
		lblNovaSifra.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNovaSifra.setBounds(38, 81, 102, 16);
		panel.add(lblNovaSifra);
		btnSacuvajPodatke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcfirst","root","");
					
					PreparedStatement st=con.prepareStatement("update admin set nickname=?, password=? where id=1");
					//InputStream is=new FileInputStream(s);
		            st.setString(1, textField.getText());
		            st.setString(2, textField_1.getText());
		            //st.setBlob(3,is);
		            st.executeUpdate();
		            JOptionPane.showMessageDialog(null,"Updated!");


		            //ImageIcon image = new ImageIcon( s);
		           
					//lbl_icon.setIcon(image);
					con.close();
		            
				}
				catch(Exception e1) {
					System.out.println(e1);
				}
				
			}
		});
		
		JLabel label=new JLabel();
		label.setBounds(382, 29, 274, 413);
	}
}

