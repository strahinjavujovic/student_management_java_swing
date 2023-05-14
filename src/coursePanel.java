import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

//import adminPanel;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class coursePanel extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					coursePanel frame = new coursePanel();
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
	 int NUMBER_SEMESTAR=0;
	public coursePanel() {
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1289, 721);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Student Management System");
		lblNewLabel.setBackground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(10, 11, 402, 31);
		contentPane.add(lblNewLabel);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		profileSettings profSet=new profileSettings();
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
		JLabel lblDobrodosliNazad = new JLabel("Welcome back "+userName+", date:  "+europeanDateFormatter.format(time));
		lblDobrodosliNazad.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblDobrodosliNazad.setBounds(47, 50, 315, 13);
		contentPane.add(lblDobrodosliNazad);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(-12, 73, 1285, 2);//panel_2.setBounds(-12, 74, 1251, 2);
		contentPane.add(panel);
		
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
		btnPodesiProfil.setBounds(1010, 16, 141, 31);
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
		btnLogout.setBounds(1161, 16, 102, 31);
		contentPane.add(btnLogout);
		
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
		btnNewButton_1.setBounds(485, 15, 122, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("SCORE");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scorePanel sPanel=new scorePanel();
				dispose();
				sPanel.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1_1.setBackground(new Color(0, 255, 64));
		btnNewButton_1_1.setBounds(749, 16, 113, 31);
		contentPane.add(btnNewButton_1_1);
		
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
		btnNewButton_1_2.setBounds(872, 16, 128, 31);
		contentPane.add(btnNewButton_1_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(64, 128, 128));
		panel_1.setBounds(28, 99, 334, 547);
		contentPane.add(panel_1);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(22, 100, 85, 13);
		panel_1.add(lblId);
		
		JLabel lblSemestar = new JLabel("Semestar:");
		lblSemestar.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSemestar.setBounds(22, 160, 73, 13);
		panel_1.add(lblSemestar);
		
		JLabel lblStudentsId = new JLabel("Student's ID:");
		lblStudentsId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentsId.setBounds(22, 130, 98, 13);
		panel_1.add(lblStudentsId);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(136, 97, 176, 19);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(136, 127, 176, 19);
		panel_1.add(textField_1);
		
		JLabel lblCourse_2 = new JLabel("Course 3:");
		lblCourse_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCourse_2.setBounds(22, 262, 85, 13);
		panel_1.add(lblCourse_2);
		
		JLabel lblCourse_3 = new JLabel("Course 4:");
		lblCourse_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCourse_3.setBounds(22, 295, 109, 13);
		panel_1.add(lblCourse_3);
		
		JLabel lblCourse = new JLabel("Course 1");
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCourse.setBounds(22, 193, 73, 13);
		panel_1.add(lblCourse);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(136, 156, 177, 22);
		panel_1.add(comboBox);
		
		JLabel lblCourse_1 = new JLabel("Course 2:");
		lblCourse_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCourse_1.setBounds(22, 229, 62, 13);
		panel_1.add(lblCourse_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"C Programming", "C++ Programming", "Advanced Mathematics II", "Data Structures & Algorithms", "Python", "Java", "Comprehensive Practice U", "Engineering Mathematics"}));
		comboBox_1.setBounds(135, 189, 177, 22);
		panel_1.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Principle of computer component", "Report Writing", "Web Programming", "Java OOP", "Design User Interface", "JSP", "Software Testing and Inspections", "Mobile App Development"}));
		comboBox_2.setBounds(135, 225, 177, 22);
		panel_1.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Advanced Mathematics 1", "Database", "Software Testing", "Linux", "Data Science", "Big Data I", "Big Data II", "Comprehensive Practice II"}));
		comboBox_3.setBounds(136, 258, 177, 22);
		panel_1.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Chinese Traditional Culture", "Computer Network", "Overview of China", "Principle of Operating System", "Computer Science", "Artifical Inteligence 1", "HSK 3", "Digital Image Proces"}));
		comboBox_4.setBounds(135, 291, 177, 22);
		panel_1.add(comboBox_4);
		
		JLabel lblCourse_3_1 = new JLabel("Course 5:");
		lblCourse_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCourse_3_1.setBounds(22, 337, 109, 13);
		panel_1.add(lblCourse_3_1);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Cloud Computing", "Algorithm Analysis and Design", "Machine Learning", "Deep Learning", "HSK Test Tutoring", "IT Project Manager", "Artificial Inteligence II", "Graduation Thesis"}));
		comboBox_5.setBounds(135, 333, 177, 22);
		panel_1.add(comboBox_5);
		
		JLabel lblStudentsId_1 = new JLabel("Student's ID:");
		lblStudentsId_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentsId_1.setBounds(22, 11, 98, 13);
		panel_1.add(lblStudentsId_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 35, 176, 19);
		panel_1.add(textField_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 71, 334, 2);
		panel_1.add(panel_2);
		panel_2.setBackground(Color.BLACK);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(64, 128, 128));
		panel_1_1.setBounds(405, 99, 858, 547);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		
		textField_3 = new JTextField();
		textField_3.setBounds(151, 14, 244, 19);
		textField_3.setColumns(10);
		panel_1_1.add(textField_3);
		
		JLabel lblSearchStudentId = new JLabel("Search Student ID:");
		lblSearchStudentId.setBounds(10, 17, 134, 13);
		lblSearchStudentId.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1_1.add(lblSearchStudentId);
		
		
		
		
		
		
		
		/////////////////////////////buttons////////////////////////////////////////////
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 74, 783, 393);
		panel_1_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID","StudentID", "Semestar", "Course1", "Course2", "Course3", "Course4", "Course5"
				}
			));
		
		
		JButton btnClear_1 = new JButton("Clear");
		btnClear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				comboBox.removeAllItems();
				comboBox_1.setSelectedIndex(0);
				comboBox_2.setSelectedIndex(0);
				comboBox_3.setSelectedIndex(0);
				comboBox_4.setSelectedIndex(0);
				comboBox_5.setSelectedIndex(0);

				DefaultTableModel tb=(DefaultTableModel) table.getModel();
	        	int rowCount=tb.getRowCount();
		           for(int i=rowCount-1;0<=i;i--) {
		        	   tb.removeRow(i);
		           }	
			}
		});
		btnClear_1.setBounds(176, 490, 130, 46);
		btnClear_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel_1_1.add(btnClear_1);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String indNumb= textField_3.getText();
			        Connection con=getKonekcija();
		            Statement st=con.createStatement();
		            ResultSet rs=st.executeQuery("select * from semestar where studentID="+indNumb);

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
		           
		            String toData[]={semestar_id,semestar_studentID,semestar_number,semestar_course1,semestar_course2,semestar_course3,semestar_course4,semestar_course5};
		            tb.addRow(toData);
		            }
		            con.close();
			          }
			          catch (Exception ex) {
							ex.printStackTrace();
						}
			}
		});
		btnSearch.setBounds(489, 11, 89, 29);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel_1_1.add(btnSearch);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String studentID= textField_2.getText();
				STUDENT_ID=""+studentID;
				comboBox.removeAllItems();
				try {
					Connection con=getKonekcija();
					Statement st=con.createStatement();
					String query= "SELECT * from student WHERE numberOfIndex="+studentID;
					
					ResultSet rs=st.executeQuery(query);
					
					while(rs.next())
		            {   
		            	String pro_id=String.valueOf(rs.getInt(1));
		                String pro_num_of_index=String.valueOf(rs.getInt(2));
		                NUMBER_SEMESTAR=rs.getInt(9);
		                textField.setText(pro_id);
		                textField_1.setText(pro_num_of_index);
		                int j=1;
		                for(int i=0;i<=NUMBER_SEMESTAR;i++) {
		                	
		                	comboBox.addItem(""+j);
		                	j++;
		                }
		            }
					
					con.close();
					
					}
					catch(Exception ezz) {
						System.out.println(ezz);
					}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(223, 34, 89, 23);
		panel_1.add(btnNewButton);
		
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(44, 490, 113, 46);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String studentID=textField_1.getText();
				String numberOfSemestar=comboBox.getSelectedItem().toString();
				String course1=comboBox_1.getSelectedItem().toString();
				String course2=comboBox_2.getSelectedItem().toString();
				String course3=comboBox_3.getSelectedItem().toString();
				String course4=comboBox_4.getSelectedItem().toString();
				String course5=comboBox_5.getSelectedItem().toString();
				try {
				Connection conn=getKonekcija();
				PreparedStatement stat = conn.prepareStatement("select * from semestar where studentID = ? and numberOfSemestar = ?");  
				stat.setString(1, studentID);stat.setString(2, numberOfSemestar);ResultSet resultSet = stat.executeQuery();
				if(resultSet.next()) {
					JOptionPane.showMessageDialog(null,"Student already have semestar "+numberOfSemestar);
				}
				else {
					int j=0;
					try {
						Connection kon=getKonekcija();
						
						for(int i=1;i<6;i++) {
						PreparedStatement statement1 = kon.prepareStatement("select * from semestar where studentID = ? and Course1 = ?");    
						PreparedStatement statement2 = kon.prepareStatement("select * from semestar where studentID = ? and Course2 = ?");    
						PreparedStatement statement3 = kon.prepareStatement("select * from semestar where studentID = ? and Course3 = ?");    
						PreparedStatement statement4 = kon.prepareStatement("select * from semestar where studentID = ? and Course4 = ?");    
						PreparedStatement statement5 = kon.prepareStatement("select * from semestar where studentID = ? and Course5 = ?");    
						
						switch(i){
						case 1:statement1.setString(1, studentID);statement1.setString(2, course1);ResultSet resultSet1 = statement1.executeQuery();if(resultSet1.next()) {JOptionPane.showMessageDialog(null,"Student already have subject "+course1);break;}else  {j++; break;}                                                        
						case 2:statement2.setString(1, studentID); statement2.setString(2, course2);ResultSet resultSet2 = statement2.executeQuery();if(resultSet2.next()) {JOptionPane.showMessageDialog(null,"Student already have subject "+course2);break;}else  {j++; break;}       
						case 3:statement3.setString(1, studentID); statement3.setString(2, course3);ResultSet resultSet3 = statement3.executeQuery();if(resultSet3.next()) {JOptionPane.showMessageDialog(null,"Student already have subject "+course3);break;}else  {j++; break;}       
						case 4:statement4.setString(1, studentID); statement4.setString(2, course4);ResultSet resultSet4 = statement4.executeQuery();if(resultSet4.next()) {JOptionPane.showMessageDialog(null,"Student already have subject "+course4);break;}else  {j++; break;}       
						case 5:statement5.setString(1, studentID); statement5.setString(2, course5);ResultSet resultSet5 = statement5.executeQuery();if(resultSet5.next()) {JOptionPane.showMessageDialog(null,"Student already have subject "+course5);break;}else  {j++; break;}       
						default:break;
							}
						}
						kon.close();
						if(j==5) {
							try {
								Connection con=getKonekcija();
								PreparedStatement st=con.prepareStatement("insert into semestar (studentID,numberOfSemestar,Course1,Course2,Course3,Course4,Course5,Course1_score,Course2_score,Course3_score,Course4_score,Course5_score) values('"+studentID+"','"+numberOfSemestar+"','"+course1+"','"+course2+"','"+course3+"','"+course4+"','"+course5+"',0.0,0.0,0.0,0.0,0.0)");
								
								
								st.executeUpdate();
								String query= "UPDATE student SET numberSemestar=? WHERE numberOfIndex="+STUDENT_ID;
								PreparedStatement st1=con.prepareStatement(query);
								NUMBER_SEMESTAR++;
								st1.setInt(1,NUMBER_SEMESTAR);
								st1.executeUpdate();
								
								comboBox.addItem(""+(NUMBER_SEMESTAR+1));
								con.close();
								JOptionPane.showMessageDialog(null,"Semestar added!!!");
								}
								catch(Exception ezz) {
									System.out.println(ezz);
									}
						}
					}
					catch(Exception ezz) {
						System.out.println(ezz);
					}
				}
				}catch(Exception ezz) {
					System.out.println(ezz);
				}
				
			}
		});
		
		
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
		           
		            String toData[]={semestar_id,semestar_studentID,semestar_number,semestar_course1,semestar_course2,semestar_course3,semestar_course4,semestar_course5};
		            tb.addRow(toData);
		            }
		            con.close();
			          }
			          catch (Exception ex) {
							ex.printStackTrace();
						}
			}
		});
		btnRefresh.setBounds(600, 11, 187, 29);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel_1_1.add(btnRefresh);
		
		
		btnSave.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnSave.setBackground(Color.GREEN);
		panel_1_1.add(btnSave);
		
		JButton btnNewButton_1_3 = new JButton("COURSE");
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1_3.setBackground(new Color(255, 0, 0));
		btnNewButton_1_3.setBounds(617, 15, 122, 33);
		contentPane.add(btnNewButton_1_3);
		
		
	}
}
