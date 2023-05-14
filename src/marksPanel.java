import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import adminPanel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class marksPanel extends JFrame {

	private JPanel contentPane;
	private JTextField textField_13;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					marksPanel frame = new marksPanel();
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
	public static Connection getKonekcija() throws SQLException {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/_studentmanagement","root","");
			return con;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return con;
	}
	public marksPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1297, 771);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String userName="";
		LocalDate time= LocalDate.now();
		DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		try {
			Connection con=getKonekcija();
			String query= "select * from admin where id=1";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			userName=rs.getString("nickname");
			
			con.close();
			
			}
			catch(Exception ezz) {
				System.out.println(ezz);
			}
		
		JLabel lblDobrodosliNazad = new JLabel("Welcome back "+userName+", date: "+europeanDateFormatter.format(time));
		lblDobrodosliNazad.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblDobrodosliNazad.setBounds(59, 53, 315, 13);
		contentPane.add(lblDobrodosliNazad);
		
		JLabel lblNewLabel = new JLabel("Student Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBackground(new Color(0, 128, 0));
		lblNewLabel.setBounds(10, 11, 402, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnPodesiProfil = new JButton("Profile Settings");
		btnPodesiProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profileSettings profSet=new profileSettings();
				profSet.setVisible(true);
				profileSettings.showData();
			}
		});
		btnPodesiProfil.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnPodesiProfil.setBackground(Color.GREEN);
		btnPodesiProfil.setBounds(1009, 16, 141, 31);
		contentPane.add(btnPodesiProfil);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login loginPage=new login();
				dispose();
				loginPage.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnLogout.setBackground(Color.GREEN);
		btnLogout.setBounds(1160, 16, 102, 31);
		contentPane.add(btnLogout);
		
		JButton btnNewButton_1_2 = new JButton("MARKS");
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1_2.setBackground(new Color(255, 0, 0));
		btnNewButton_1_2.setBounds(871, 16, 128, 31);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1 = new JButton("STUDENT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminPanel adminP= new adminPanel();
				dispose();
				adminP.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1.setBackground(new Color(0, 255, 64));
		btnNewButton_1.setBounds(422, 15, 141, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("COURSE");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coursePanel cPanel=new coursePanel();
				dispose();
				cPanel.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1_1.setBackground(new Color(0, 255, 64));
		btnNewButton_1_1.setBounds(575, 16, 138, 31);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("SCORE");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scorePanel sPanel=new scorePanel();
				dispose();
				sPanel.setVisible(true);
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1_1_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1_1_1.setBounds(723, 16, 138, 31);
		contentPane.add(btnNewButton_1_1_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(-23, 75, 1285, 2);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(64, 128, 128));
		panel_1.setBounds(29, 116, 334, 547);
		contentPane.add(panel_1);
		
		JLabel lblStudentsId_1 = new JLabel("Student's ID:");
		lblStudentsId_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentsId_1.setBounds(22, 11, 98, 13);
		panel_1.add(lblStudentsId_1);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(22, 35, 165, 19);
		panel_1.add(textField_13);
		
		
		
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(64, 128, 128));
		panel_1_1.setBounds(394, 116, 858, 547);
		contentPane.add(panel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 33, 783, 423);
		panel_1_1.add(scrollPane);
		
		
		
		
		////////////////////buttons
		
		
		JLabel lblCGPA = new JLabel("CGPA: 0.0");
		lblCGPA.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCGPA.setBounds(22, 475, 209, 50);
		panel_1.add(lblCGPA);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID","StudentID", "Semestar", "Course1", "Score1", "Course2", "Score2", "Course3","Score3","Course4","Score4","Course5","Score5","Average"
				}
			));
		
		

		JButton btnClear_1_1 = new JButton("Clear");
		btnClear_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_13.setText("");
				lblCGPA.setText("CGPA: 0.0");
				
				DefaultTableModel tb=(DefaultTableModel) table.getModel();
	        	int rowCount=tb.getRowCount();
		           for(int i=rowCount-1;0<=i;i--) {
		        	   tb.removeRow(i);
		           }		
			}
		});
		btnClear_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnClear_1_1.setBounds(43, 478, 130, 46);
		panel_1_1.add(btnClear_1_1);
		

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField_13.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"You must enter Student ID!");
				}
				else {
					try {
						Float average;
						int j=0;
						float cgpa=0;
						String studentID= textField_13.getText();
				        Connection con=getKonekcija();
			            Statement st=con.createStatement();
			            ResultSet rs=st.executeQuery("select * from semestar where studentID="+studentID);
	
			        	DefaultTableModel tb=(DefaultTableModel) table.getModel();
			        	
			        	int rowCount=tb.getRowCount();
				           for(int i=rowCount-1;0<=i;i--) {
				        	   tb.removeRow(i);
				           }				 
			            while(rs.next())
			            {   
			            	String semestar_id=String.valueOf(rs.getInt(1));
			                String semestar_studentID=String.valueOf(rs.getInt(2));
			                String semestar_number=String.valueOf(rs.getInt(3));
			                String semestar_course1=rs.getString(4);    
			                String semestar_course2=rs.getString(5);
			                String semestar_course3=rs.getString(6);   
			                String semestar_course4=rs.getString(7); 
			                String semestar_course5=rs.getString(8); 
			                String semestar_score1=String.valueOf(rs.getFloat(9));
			                String semestar_score2=String.valueOf(rs.getFloat(10));
			                String semestar_score3=String.valueOf(rs.getFloat(11));
			                String semestar_score4=String.valueOf(rs.getFloat(12));
			                String semestar_score5=String.valueOf(rs.getFloat(13));
			                average=(rs.getFloat(9)+rs.getFloat(10)+rs.getFloat(11)+rs.getFloat(12)+rs.getFloat(13))/5;
			                cgpa+=average;
			                j++;
			                String toData[]={semestar_id,semestar_studentID,semestar_number,semestar_course1,semestar_score1,semestar_course2,semestar_score2,semestar_course3,semestar_score3,semestar_course4,semestar_score4,semestar_course5,semestar_score5,average.toString()};
			            tb.addRow(toData);
			            }
			            lblCGPA.setText("CGPA: "+cgpa/j);
			            con.close();
				          }
				          catch (Exception ex) {
								ex.printStackTrace();
							}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(223, 34, 89, 23);
		panel_1.add(btnNewButton);
	}
}
