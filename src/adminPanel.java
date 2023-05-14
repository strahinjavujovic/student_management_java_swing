import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;



import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel; 

public class adminPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	public JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 * @throws ClassNotFoundException 
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminPanel frame1 = new adminPanel();
					frame1.setVisible(true);
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
	
	
	
	
	
	public adminPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1255, 774);
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
		JLabel lblDobrodosliNazad = new JLabel("Welcome back "+userName+", date:  "+europeanDateFormatter.format(time));
		lblDobrodosliNazad.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblDobrodosliNazad.setBounds(47, 50, 315, 13);
		contentPane.add(lblDobrodosliNazad);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(20, 105, 334, 547);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 128, 128));
		panel_1.setBounds(371, 105, 858, 547);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 41, 809, 433);
		panel_1.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("Student Management System");
		lblNewLabel_1.setBackground(new Color(0, 128, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_1.setBounds(10, 11, 402, 31);
		contentPane.add(lblNewLabel_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("y-MM-dd");
		dateChooser.setBounds(118, 125, 176, 20);
		panel.add(dateChooser);
		
		JLabel lblNewLabel = new JLabel("Number of Index:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 39, 109, 13);
		panel.add(lblNewLabel);
		
		JLabel lblPrezime = new JLabel("Surname:");
		lblPrezime.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrezime.setBounds(21, 99, 73, 13);
		panel.add(lblPrezime);
		
		JLabel lblIme = new JLabel("Name:");
		lblIme.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIme.setBounds(21, 69, 45, 13);
		panel.add(lblIme);
		
		textField = new JTextField();
		textField.setBounds(118, 35, 176, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(118, 65, 176, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(118, 95, 176, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(118, 184, 176, 19);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(118, 214, 176, 19);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNickname = new JLabel("Email:");
		lblNickname.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNickname.setBounds(21, 187, 58, 13);
		panel.add(lblNickname);
		
		JLabel lblPassword = new JLabel("Phone Number:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(10, 217, 109, 13);
		panel.add(lblPassword);
		
		JLabel lblBirthDate = new JLabel("Birth date:");
		lblBirthDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBirthDate.setBounds(21, 132, 73, 13);
		panel.add(lblBirthDate);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setBounds(117, 156, 177, 22);
		panel.add(comboBox);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGender.setBounds(21, 156, 58, 13);
		panel.add(lblGender);
		
		
		
		textField_33 = new JTextField();
		textField_33.setBounds(154, 11, 45, 19);
		panel_1.add(textField_33);
		textField_33.setColumns(10);
		
		textField_34 = new JTextField();
		textField_34.setBounds(285, 11, 45, 19);
		panel_1.add(textField_34);
		textField_34.setColumns(10);
		
		JLabel lblBr = new JLabel("Student number from");
		lblBr.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBr.setBounds(10, 17, 134, 13);
		panel_1.add(lblBr);
		
		JLabel lblDo = new JLabel("To:");
		lblDo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDo.setBounds(229, 17, 30, 13);
		panel_1.add(lblDo);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(-12, 74, 1251, 2);
		contentPane.add(panel_2);
		
		
/////////////////buttons///////////////////////////////////////buttons/////////////////////////////////////////buttons//////////////////////////////
////////////////////////////////////////////////////////buttons/////////////////////////////buttons//////////////////////////////////////////
//////////////////////////////////////buttons//////////////////buttons///////////////////////buttons////////////////////////////////////////////////

		JTable table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow();
				textField.setText(table.getModel().getValueAt(row, 1).toString());
				textField_1.setText(table.getModel().getValueAt(row, 2).toString());
				textField_2.setText(table.getModel().getValueAt(row, 3).toString());
				String sDate=table.getModel().getValueAt(row, 4).toString();Date date=Date.valueOf(sDate);dateChooser.setDate(date);
				comboBox.setSelectedItem(table.getModel().getValueAt(row, 5).toString());
				textField_3.setText(table.getModel().getValueAt(row, 6).toString());
				textField_4.setText(table.getModel().getValueAt(row, 7).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","Number of Index", "Name", "Surname", "Birth Date", "Gender", "Email", "Phone number"
			}
		));

		
		JButton btnLoad = new JButton("LOAD TABLE");
		btnLoad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnLoad.setBackground(new Color(0, 255, 0));
		btnLoad.setBounds(22, 485, 113, 46);
		panel_1.add(btnLoad);
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {
				        Connection con=getKonekcija();
			            Statement st=con.createStatement();
			            ResultSet rs=st.executeQuery("select * from student where numberOfIndex between 1 and 9999");

			        	DefaultTableModel tb=(DefaultTableModel) table.getModel();
			        	
			        	int rowCount=tb.getRowCount();
				           for(int i=rowCount-1;0<=i;i--) {
				        	   tb.removeRow(i);
				           }				 
			            while(rs.next())
			            {   
			            	String pro_id=String.valueOf(rs.getInt(1));
			                String pro_br_indeksa=String.valueOf(rs.getInt(2));
			                String pro_ime=rs.getString(3);
			                String pro_prezime=rs.getString(4);    
			                String pro_birthdate=rs.getString(5);
			                String pro_gender=rs.getString(6);   
			                String pro_email=rs.getString(7); 
			                String pro_number=rs.getString(8); 
			           
			            String toData[]={pro_id,pro_br_indeksa,pro_ime,pro_prezime,pro_birthdate,pro_gender,pro_email,pro_number};
			            tb.addRow(toData);
			            }
			            con.close();
				          }
				          catch (Exception ex) {
								ex.printStackTrace();
							}
			}
		});
		JButton btnNewButton = new JButton("Filter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String min= textField_33.getText();
				String max= textField_34.getText();
				
				 try {
				        Connection con=getKonekcija();
			            Statement st=con.createStatement();
			            ResultSet rs=st.executeQuery("select * from student where numberOfIndex between "+min+" and "+max+"");

			        	DefaultTableModel tb=(DefaultTableModel) table.getModel();
			        	
			        	int rowCount=tb.getRowCount();
				           for(int i=rowCount-1;0<=i;i--) {
				        	   tb.removeRow(i);
				           }				 
			            while(rs.next())
			            {   
			            	String pro_id=String.valueOf(rs.getInt(1));
			                String pro_br_indeksa=String.valueOf(rs.getInt(2));
			                String pro_ime=rs.getString(3);
			                String pro_prezime=rs.getString(4);    
			                String pro_birthdate=rs.getString(5);
			                String pro_gender=rs.getString(6);   
			                String pro_email=rs.getString(7); 
			                String pro_number=rs.getString(8); 
			           
			            String toData[]={pro_id,pro_br_indeksa,pro_ime,pro_prezime,pro_birthdate,pro_gender,pro_email,pro_number};
			            tb.addRow(toData);
			            }
			            con.close();
				          }
				          catch (Exception ex) {
								ex.printStackTrace();
							}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.setBounds(377, 11, 89, 19);
		panel_1.add(btnNewButton);
		
		JButton btnPodesiProfil = new JButton("Profile Settings");
		btnPodesiProfil.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnPodesiProfil.setBackground(new Color(0, 255, 0));
		btnPodesiProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				profileSettings profSet=new profileSettings();
				profSet.setVisible(true);
				profileSettings.showData();
				
			}
		});
		btnPodesiProfil.setBounds(976, 16, 141, 31);
		contentPane.add(btnPodesiProfil);
		
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnLogout.setBackground(new Color(0, 255, 0));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login loginPage=new login();
				dispose();
				loginPage.setVisible(true);
				
			}
		});
		btnLogout.setBounds(1127, 16, 102, 31);
		contentPane.add(btnLogout);
		
		
		JButton btnObrisi = new JButton("Delete");
		btnObrisi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnObrisi.setBounds(440, 485, 102, 46);
		panel_1.add(btnObrisi);
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con=getKonekcija();
					
					int row = table.getSelectedRow();
					String value=table.getModel().getValueAt(row, 0).toString();
					String query= "DELETE FROM student WHERE id="+value;
					PreparedStatement st=con.prepareStatement(query);
					st.executeUpdate();
					
					
					JOptionPane.showMessageDialog(null,"Student deleted!");
					btnLoad.doClick();
					con.close();
					
					}
					catch(Exception ezz) {
						System.out.println(ezz);
					}
			}
		});
		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnUpdate.setBounds(303, 485, 105, 46);
		panel_1.add(btnUpdate);
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indexNumb=Integer.parseInt(textField.getText());
				String name=textField_1.getText();
				String surname=textField_2.getText();
				java.sql.Date sqldate = new java.sql.Date(dateChooser.getDate().getTime());
				String gender = comboBox.getSelectedItem().toString();
				String email=textField_3.getText();
				String number=textField_4.getText();
				try {
					Connection con=getKonekcija();
					
					int row = table.getSelectedRow();
					String value=table.getModel().getValueAt(row, 0).toString();
					
					String query= "UPDATE student SET name=?, surname=?, dateBirth=?, gender=?,email=?, number=?, numberOfIndex=? WHERE id="+value;
					PreparedStatement st=con.prepareStatement(query);
					st.setString(1,name);
					st.setString(2,surname);
					st.setDate(3, sqldate);
					st.setString(4, gender);
					st.setString(5,email);
					st.setString(6,number);
					st.setInt(7,indexNumb);
					
					st.executeUpdate();
					
					
					JOptionPane.showMessageDialog(null,"Data updated!");
					con.close();
					btnLoad.doClick();
					
					}
					catch(Exception ezz) {
						System.out.println(ezz);
					}
				
			}
		});
		JButton btnDodajStudenta = new JButton("Add Student");
		btnDodajStudenta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnDodajStudenta.setBounds(154, 485, 130, 46);
		panel_1.add(btnDodajStudenta);
		btnDodajStudenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int numb=Integer.parseInt(textField.getText());
				String name=textField_1.getText();
				String surname=textField_2.getText();
				java.sql.Date sqldate = new java.sql.Date(dateChooser.getDate().getTime());
				String gender = comboBox.getSelectedItem().toString();
				String email=textField_3.getText();
				String number=textField_4.getText();
						
				try {
				Connection con=getKonekcija();
				PreparedStatement st=con.prepareStatement("insert into student (numberOfIndex,name,surname,dateBirth,gender,email,number,numberSemestar) values('"+numb+"','"+name+"','"+surname+"','"+sqldate+"','"+gender+"','"+email+"','"+number+"','0')");
				
				
				st.executeUpdate();
				con.close();
				btnLoad.doClick();
				JOptionPane.showMessageDialog(null,"Student added!");
				}
				catch(Exception ezz) {
					System.out.println(ezz);
				}
			}
		});
		
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Date date = new Date();
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				String sDate=time.toString();Date date=Date.valueOf(sDate);dateChooser.setDate(date);
				comboBox.setSelectedIndex(0);
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnClear.setBounds(574, 485, 102, 46);
		panel_1.add(btnClear);
		
		 
		JButton btnNewButton_1 = new JButton("COURSE ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coursePanel courseP=new coursePanel();
				dispose();
				courseP.setVisible(true);
				 //System.out.println(date);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1.setBackground(new Color(0, 255, 64));
		btnNewButton_1.setBounds(583, 15, 122, 33);
		contentPane.add(btnNewButton_1);
		
		
		JButton btnNewButton_1_1 = new JButton("SCORE ");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scorePanel sPanel=new scorePanel();
				dispose();
				sPanel.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1_1.setBackground(new Color(0, 255, 64));
		btnNewButton_1_1.setBounds(715, 16, 113, 31);
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
		btnNewButton_1_2.setBounds(838, 16, 128, 31);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("STUDENT");
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1_3.setBackground(new Color(255, 0, 0));
		btnNewButton_1_3.setBounds(451, 15, 122, 33);
		contentPane.add(btnNewButton_1_3);
	}
	public void showTable() {
		 try {
		        Connection con=getKonekcija();
	            Statement st=con.createStatement();
	            ResultSet rs=st.executeQuery("select * from student where numberOfIndex between 1 and 9999");

	        	DefaultTableModel tb=(DefaultTableModel) table.getModel();
	        	
	        	int rowCount=tb.getRowCount();
		           for(int i=rowCount-1;0<=i;i--) {
		        	   tb.removeRow(i);
		           }				 
	            while(rs.next())
	            {   
	            	String pro_id=String.valueOf(rs.getInt(1));
	                String pro_br_indeksa=String.valueOf(rs.getInt(2));
	                String pro_ime=rs.getString(3);
	                String pro_prezime=rs.getString(4);    
	                String pro_birthdate=rs.getString(5);
	                String pro_gender=rs.getString(6);   
	                String pro_email=rs.getString(7); 
	                String pro_number=rs.getString(8);
	           
	            String toData[]={pro_id,pro_br_indeksa,pro_ime,pro_prezime,pro_birthdate,pro_gender,pro_email,pro_number};
	            tb.addRow(toData);
	            }
	            con.close();
		          }
		          catch (Exception ex) {
						ex.printStackTrace();
					}
	}
}

