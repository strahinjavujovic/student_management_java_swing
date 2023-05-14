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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class scorePanel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					scorePanel frame = new scorePanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
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
	/**
	 * Create the frame.
	 */
	String STUDENT_ID;
	 String NUMBER_SEMESTAR;
	public scorePanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1294, 756);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String userName="";
		
		
		LocalDate time= LocalDate.now();
		//String europeanDatePattern = "dd.MM.yyyy";
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(64, 128, 128));
		panel_1.setBounds(25, 117, 334, 547);
		contentPane.add(panel_1);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(22, 158, 85, 13);
		panel_1.add(lblId);
		
		JLabel lblSemestar = new JLabel("Semestar:");
		lblSemestar.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSemestar.setBounds(22, 218, 73, 13);
		panel_1.add(lblSemestar);
		
		JLabel lblStudentsId = new JLabel("Student's ID:");
		lblStudentsId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentsId.setBounds(22, 188, 98, 13);
		panel_1.add(lblStudentsId);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(136, 155, 176, 19);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(136, 185, 176, 19);
		panel_1.add(textField_1);
		
		JLabel lblCourse_2 = new JLabel("Course 3:");
		lblCourse_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCourse_2.setBounds(22, 320, 85, 13);
		panel_1.add(lblCourse_2);
		
		JLabel lblCourse_3 = new JLabel("Course 4:");
		lblCourse_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCourse_3.setBounds(22, 353, 109, 13);
		panel_1.add(lblCourse_3);
		
		JLabel lblCourse = new JLabel("Course 1");
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCourse.setBounds(22, 251, 73, 13);
		panel_1.add(lblCourse);
		
		JLabel lblCourse_1 = new JLabel("Course 2:");
		lblCourse_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCourse_1.setBounds(22, 287, 62, 13);
		panel_1.add(lblCourse_1);
		
		JLabel lblCourse_3_1 = new JLabel("Course 5:");
		lblCourse_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCourse_3_1.setBounds(22, 395, 109, 13);
		panel_1.add(lblCourse_3_1);
		
		JLabel lblStudentsId_1 = new JLabel("Student's ID:");
		lblStudentsId_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentsId_1.setBounds(22, 11, 98, 13);
		panel_1.add(lblStudentsId_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(136, 215, 176, 19);
		panel_1.add(textField_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(0, 126, 334, 2);
		panel_1.add(panel_2);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(136, 284, 109, 19);
		panel_1.add(textField_4);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(136, 248, 109, 19);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(136, 317, 109, 19);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(136, 350, 109, 19);
		panel_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(136, 392, 109, 19);
		panel_1.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(269, 248, 42, 19);
		panel_1.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(269, 278, 42, 19);
		panel_1.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(269, 314, 42, 19);
		panel_1.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(270, 350, 42, 19);
		panel_1.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(269, 392, 42, 19);
		panel_1.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(22, 35, 165, 19);
		panel_1.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(22, 84, 165, 19);
		panel_1.add(textField_14);
		
		JLabel lblStudentsId_1_1 = new JLabel("Semestar:");
		lblStudentsId_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentsId_1_1.setBounds(22, 62, 98, 13);
		panel_1.add(lblStudentsId_1_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(64, 128, 128));
		panel_1_1.setBounds(415, 117, 858, 547);
		contentPane.add(panel_1_1);
		
		JLabel lblSearchStudentId = new JLabel("Search Student ID:");
		lblSearchStudentId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSearchStudentId.setBounds(10, 17, 134, 13);
		panel_1_1.add(lblSearchStudentId);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 74, 783, 393);
		panel_1_1.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Student Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBackground(new Color(0, 128, 0));
		lblNewLabel.setBounds(21, 11, 402, 31);
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
		btnPodesiProfil.setBackground(new Color(0, 255, 0));
		btnPodesiProfil.setBounds(1020, 16, 141, 31);
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
		btnLogout.setBackground(new Color(0, 255, 0));
		btnLogout.setBounds(1171, 16, 102, 31);
		contentPane.add(btnLogout);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 77, 1285, 2);
		contentPane.add(panel);
		
		//////////////////////////////////////BUTTONS

		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID","StudentID", "Semestar", "Course1", "Score1", "Course2", "Score2", "Course3","Score3","Course4","Score4","Course5","Score5"
				}
			));
		

		JButton btnNewButton_1_2 = new JButton("MARKS");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marksPanel mPanel=new marksPanel();
				dispose();
				mPanel.setVisible(true);
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1_2.setBackground(new Color(0, 255, 64));
		btnNewButton_1_2.setBounds(882, 16, 128, 31);
		contentPane.add(btnNewButton_1_2);
		
		
		JButton btnNewButton_1 = new JButton("STUDENT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminPanel aPanel= new adminPanel();
				dispose();
				aPanel.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1.setBackground(new Color(0, 255, 64));
		btnNewButton_1.setBounds(433, 15, 141, 33);
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
		btnNewButton_1_1.setBounds(586, 16, 138, 31);
		contentPane.add(btnNewButton_1_1);
		
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentID= textField_13.getText();
				String semestarNumb= textField_14.getText();
				STUDENT_ID=studentID;
				NUMBER_SEMESTAR=semestarNumb;
				try {
					Connection con=getKonekcija();
					
					PreparedStatement statement=con.prepareStatement("SELECT * from semestar WHERE studentID= ? and numberOfSemestar=?");   
					statement.setString(1, studentID);
					statement.setString(2, semestarNumb);
					ResultSet rs=statement.executeQuery();
					
					if(rs.next()) {
		               
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
		            
		                textField.setText(semestar_id);
		                textField_1.setText(semestar_studentID);
		                textField_2.setText(semestar_number);
		                textField_3.setText(semestar_course1);
		                textField_4.setText(semestar_course2);
		                textField_5.setText(semestar_course3);
		                textField_6.setText(semestar_course4);
		                textField_7.setText(semestar_course5);
		                textField_8.setText(semestar_score1);
		                textField_9.setText(semestar_score2);
		                textField_10.setText(semestar_score3);
		                textField_11.setText(semestar_score4);
		                textField_12.setText(semestar_score5);
					}
					con.close();
					
					}
					catch(Exception ezz) {
						System.out.println(ezz);
					}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(223, 34, 89, 69);
		panel_1.add(btnNewButton);
		
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(145, 14, 293, 19);
		panel_1_1.add(textField_15);
		
		JButton btnClear_1_1 = new JButton("Clear");
		btnClear_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel tb=(DefaultTableModel) table.getModel();
	        	int rowCount=tb.getRowCount();
		           for(int i=rowCount-1;0<=i;i--) {
		        	   tb.removeRow(i);
		           }	
				textField.setText("");
				textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
                textField_4.setText("");
                textField_5.setText("");
                textField_6.setText("");
                textField_7.setText("");
                textField_8.setText("");
                textField_9.setText("");
                textField_10.setText("");
                textField_11.setText("");
                textField_12.setText("");
                textField_13.setText("");
                textField_14.setText("");
			}
		});
		btnClear_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnClear_1_1.setBounds(185, 490, 130, 46);
		panel_1_1.add(btnClear_1_1);
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_15.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"You must enter Student ID!");
				}
				else {
					try {
						
						String studentID= textField_15.getText();
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
			           
			                String toData[]={semestar_id,semestar_studentID,semestar_number,semestar_course1,semestar_score1,semestar_course2,semestar_score2,semestar_course3,semestar_score3,semestar_course4,semestar_score4,semestar_course5,semestar_score5};
			            tb.addRow(toData);
			            }
			            con.close();
				          }
				          catch (Exception ex) {
								ex.printStackTrace();
							}
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnSearch.setBounds(489, 11, 89, 29);
		panel_1_1.add(btnSearch);
		
		JButton btnRefresh = new JButton("Refresh / Load Table");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
			        Connection con=getKonekcija();
		            Statement st=con.createStatement();
		            ResultSet rs=st.executeQuery("select * from semestar");

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
		           
		            String toData[]={semestar_id,semestar_studentID,semestar_number,semestar_course1,semestar_score1,semestar_course2,semestar_score2,semestar_course3,semestar_score3,semestar_course4,semestar_score4,semestar_course5,semestar_score5};
		            tb.addRow(toData);
		            }
		            con.close();
			          }
			          catch (Exception ex) {
							ex.printStackTrace();
						}
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnRefresh.setBounds(600, 11, 187, 29);
		panel_1_1.add(btnRefresh);
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Float score1=Float.parseFloat(textField_8.getText());
				Float score2=Float.parseFloat(textField_9.getText());
				Float score3=Float.parseFloat(textField_10.getText());
				Float score4=Float.parseFloat(textField_11.getText());
				Float score5=Float.parseFloat(textField_12.getText());
				
				if(score1 <= 10.0 && score1 >= 5.0 && score2 <= 10.0 && score2 >= 5.0 && score3 <= 10.0 && score3 >= 5.0 && score4 <= 10.0 && score4 >= 5.0 && score5 <= 10.0 && score5 >= 5.0) {
						
					try {
						Connection con=getKonekcija();
						PreparedStatement statement=con.prepareStatement("UPDATE semestar SET Course1_score=?,Course2_score=?, Course3_score=?, Course4_score=?, Course5_score=? WHERE studentID= ? and numberOfSemestar=?");   
						statement.setString(6, STUDENT_ID);
						statement.setString(7, NUMBER_SEMESTAR);
						statement.setFloat(1,score1);
						statement.setFloat(2,score2);
						statement.setFloat(3,score3);
						statement.setFloat(4, score4);
						statement.setFloat(5, score5);
						statement.executeUpdate();
						
						
						JOptionPane.showMessageDialog(null,"Data updated!");
						con.close();
						//btnSearch.doClick();
						
						}
						catch(Exception ezz) {
							System.out.println(ezz);
						}
				}
				else {
					JOptionPane.showMessageDialog(null,"The score must be between 5.0 and 10.0!");
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnSave.setBackground(Color.GREEN);
		btnSave.setBounds(43, 490, 113, 46);
		panel_1_1.add(btnSave);
		
		JButton btnNewButton_1_1_1 = new JButton("SCORE");
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1_1_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1_1_1.setBounds(734, 16, 138, 31);
		contentPane.add(btnNewButton_1_1_1);
	}
}
