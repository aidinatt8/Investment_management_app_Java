package financeApp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login_user {

	private JFrame frame;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_user window = new Login_user();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_user() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 620, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(6, 6, 608, 428);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		panel_1.setBounds(201, 0, 407, 428);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		user = new JTextField();
		user.setBounds(158, 122, 202, 26);
		panel_1.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(158, 171, 202, 26);
		panel_1.add(pass);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(30, 127, 89, 16);
		panel_1.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(30, 176, 89, 16);
		panel_1.add(lblPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String un = user.getText();
				String pas = pass.getText();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stocksDB","root","");
					//stocksDB is the name of the database 
					Statement stmt=con.createStatement();
					String sql="Select * from userdb where username='"+un+"' and password='"+pas.toString()+"'";
					//usersdb is the name of a table
					ResultSet rs=stmt.executeQuery(sql);

					if(rs.next()) {
						
						JOptionPane.showMessageDialog(null, "Login Sucessful!");
						int currentid = rs.getInt(1);
						String currentuser = rs.getString(2);
						Home_page home = new Home_page(currentid, currentuser);
						home.frame.setVisible(true);
					    frame.dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
						con.close();
					}
				}catch(Exception x) {
					//display the error message
					System.out.print(x);
					}
				
			}
		});
		btnNewButton.setBounds(202, 259, 117, 29);
		panel_1.add(btnNewButton);
	}

}
