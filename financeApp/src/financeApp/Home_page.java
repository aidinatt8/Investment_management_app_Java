package financeApp;

import java.awt.EventQueue;

import java.awt.Font;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;



import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;


public class Home_page {

	
	JFrame frame;
	
	float cost = 0;
	String username;
	int userid;
	
	Object[] columns2 = {"Stock ID", "Ticker", "Purchased price", "Action"};  //action will be delete button
	DefaultTableModel model2 = new DefaultTableModel(columns2, 0);
	JTable portfolioTable = new JTable(model2);
	
	
	JTextField costField = new JTextField();
	JTextField profitField = new JTextField();
	JTextField revField = new JTextField();
	
	private String[] arraySP;
	private String[] arrayDow;
	private String[] arrayNs;
	private String[] arrayRuss;
	private String[] arrayOil;
	
	
	private JTextField searchField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	
	//global components and variables 
	
	Object[][] rowData = new Object[40][6];
	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	
	int[] rowArray = new int[250];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Home_page window = new Home_page(int id, String user);
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public Home_page(int id, String user) throws Exception {
		userid = id;
		username = user;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		//settings for web scraping for home page small boxes 
		final String url;
		
		url = "https://finance.yahoo.com";
		
		
		try {
			final Document document = Jsoup.connect(url).followRedirects(false).timeout(60000).get();
			
			String value;
			String value2;
			String value3;
			String value4;
			String value5;
			
			value = document.body().select("#marketsummary-itm-0").get(0).text();
			arraySP = value.split(" ");
			value2 = document.body().select("#marketsummary-itm-1").get(0).text();
			arrayDow = value2.split(" ");
			value3 = document.body().select("#marketsummary-itm-2").get(0).text();
			arrayNs = value3.split(" ");
			value4 = document.body().select("#marketsummary-itm-3").get(0).text();
			arrayRuss = value4.split(" ");
			value5 = document.body().select("#marketsummary-itm-4").get(0).text();
			arrayOil = value5.split(" ");
			
			//System.out.print(value);
			

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//GUI elements
		frame = new JFrame();
		frame.setBounds(100, 100, 645, 536);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.GRAY);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel homeTab = new JPanel();
		tabbedPane.addTab("Home", null, homeTab, null);
		homeTab.setBackground(new Color(153, 204, 255));
		homeTab.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 0, 125, 77);
		homeTab.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel name1 = new JLabel(arraySP[0]+" "+arraySP[1]);
		name1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		name1.setBounds(6, 6, 113, 16);
		name1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(name1);
		
		JLabel price1 = new JLabel(arraySP[2]);
		price1.setHorizontalAlignment(SwingConstants.LEFT);
		price1.setBounds(6, 34, 113, 16);
		panel_2.add(price1);
		
		JLabel change1 = new JLabel(arraySP[3]);
		change1.setHorizontalAlignment(SwingConstants.LEFT);
		change1.setBounds(6, 54, 113, 16);
		panel_2.add(change1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(126, 0, 125, 77);
		homeTab.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel change2 = new JLabel(arrayDow[3]);
		change2.setHorizontalAlignment(SwingConstants.LEFT);
		change2.setBounds(6, 54, 113, 16);
		panel_2_1.add(change2);
		
		JLabel price2 = new JLabel(arrayDow[2]);
		price2.setHorizontalAlignment(SwingConstants.LEFT);
		price2.setBounds(6, 34, 113, 16);
		panel_2_1.add(price2);
		
		JLabel name2 = new JLabel(arrayDow[0]+ " " + arrayDow[1]);
		name2.setHorizontalAlignment(SwingConstants.LEFT);
		name2.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		name2.setBounds(6, 6, 113, 16);
		panel_2_1.add(name2);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBackground(Color.WHITE);
		panel_2_2.setBounds(252, 0, 125, 77);
		homeTab.add(panel_2_2);
		panel_2_2.setLayout(null);
		
		JLabel change3 = new JLabel(arrayNs[2]);
		change3.setHorizontalAlignment(SwingConstants.LEFT);
		change3.setBounds(6, 54, 113, 16);
		panel_2_2.add(change3);
		
		JLabel price3 = new JLabel(arrayNs[1]);
		price3.setHorizontalAlignment(SwingConstants.LEFT);
		price3.setBounds(6, 34, 113, 16);
		panel_2_2.add(price3);
		
		JLabel name3 = new JLabel(arrayNs[0]);
		name3.setHorizontalAlignment(SwingConstants.LEFT);
		name3.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		name3.setBounds(6, 6, 113, 16);
		panel_2_2.add(name3);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setBackground(Color.WHITE);
		panel_2_3.setBounds(378, 0, 125, 77);
		homeTab.add(panel_2_3);
		panel_2_3.setLayout(null);
		
		JLabel change4 = new JLabel(arrayRuss[3]);
		change4.setHorizontalAlignment(SwingConstants.LEFT);
		change4.setBounds(6, 54, 113, 16);
		panel_2_3.add(change4);
		
		JLabel price4 = new JLabel(arrayRuss[3]);
		price4.setHorizontalAlignment(SwingConstants.LEFT);
		price4.setBounds(6, 34, 113, 16);
		panel_2_3.add(price4);
		
		JLabel name4 = new JLabel(arrayRuss[0]+ " " + arrayRuss[1]);
		name4.setHorizontalAlignment(SwingConstants.LEFT);
		name4.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		name4.setBounds(6, 6, 113, 16);
		panel_2_3.add(name4);
		
		JPanel panel_2_4 = new JPanel();
		panel_2_4.setBackground(Color.WHITE);
		panel_2_4.setBounds(504, 0, 125, 77);
		homeTab.add(panel_2_4);
		panel_2_4.setLayout(null);
		
		JLabel change5 = new JLabel(arrayOil[3]);
		change5.setHorizontalAlignment(SwingConstants.LEFT);
		change5.setBounds(6, 54, 113, 16);
		panel_2_4.add(change5);
		
		JLabel price5 = new JLabel(arrayOil[2]);
		price5.setHorizontalAlignment(SwingConstants.LEFT);
		price5.setBounds(6, 34, 113, 16);
		panel_2_4.add(price5);
		
		JLabel name5 = new JLabel(arrayOil[0] + " " + arrayOil[1]);
		name5.setHorizontalAlignment(SwingConstants.LEFT);
		name5.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		name5.setBounds(6, 6, 113, 16);
		panel_2_4.add(name5);
		
		JLabel lblNewLabel = new JLabel("My Portfolio");
		lblNewLabel.setBounds(235, 85, 195, 30);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		homeTab.add(lblNewLabel);
		

		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/stocksDB","root","");
			
			Statement st;
			ResultSet rs;
			st = conn.createStatement();
			rs = st.executeQuery("SELECT `stockID`, `ticker`, `purchased price` FROM `portfolios` WHERE userID=" + userid);
			
			while(rs.next()) {
				
				
				model2.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getFloat(3), "Remove"});
				cost = cost + rs.getFloat(3);
				
			}
			
			costField.setText(Float.toString(cost));
			
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//DefaultTableModel model2 = new DefaultTableModel(rowData2, columns2);
		//portfolioTable.setModel(model2);
		ButtonColumn buttonColumn2 = new ButtonColumn(portfolioTable, removeItem, 3); //3 is the column index

		
		portfolioTable.setBackground(Color.white);
		portfolioTable.setForeground(Color.black);
		portfolioTable.setSelectionBackground(Color.blue);
		portfolioTable.setGridColor(Color.gray);
		portfolioTable.setSelectionForeground(Color.white);
		portfolioTable.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		portfolioTable.setRowHeight(26);
		portfolioTable.setAutoCreateRowSorter(true); //enable sorting by clicking the table column
		
		JScrollPane scrollPane_1 = new JScrollPane(portfolioTable);
		scrollPane_1.setBounds(6, 127, 376, 313);
		homeTab.add(scrollPane_1);
		scrollPane_1.setBackground(Color.white);
		scrollPane_1.setForeground(Color.blue);
		
		JLabel usernameLabel = new JLabel(username);
		usernameLabel.setBounds(6, 90, 100, 16);
		homeTab.add(usernameLabel);
		
		JLabel lblcost = new JLabel("Total cost ($): ");
		lblcost.setBounds(394, 144, 80, 16);
		homeTab.add(lblcost);
	
		costField.setBounds(475, 139, 130, 26);
		homeTab.add(costField);
		costField.setColumns(10);
		
		JLabel lblRev = new JLabel("Total revenue ($): ");
		lblRev.setBounds(396, 186, 80, 16);
		homeTab.add(lblRev);
		
		revField.setBounds(475, 181, 130, 26);
		homeTab.add(revField);
		revField.setColumns(10);
		
		JLabel lblProfit = new JLabel("Profit (%): ");
		lblProfit.setBounds(396, 225, 80, 16);
		homeTab.add(lblProfit);
		
		profitField.setBounds(475, 220, 130, 26);
		homeTab.add(profitField);
		profitField.setColumns(10);
		
		JButton btnExport = new JButton("Export to Excel");
		btnExport.setBounds(480, 85, 130, 29);
		homeTab.add(btnExport);
		btnExport.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	String excelFilePath = "My-Stocks-Portfolio.xlsx";
            	
            }

        });

		
		//second tab
		JPanel stocksTab = new JPanel();
		tabbedPane.addTab("Stocks", null, stocksTab, null);
		stocksTab.setBackground(new Color(153, 204, 255));
		stocksTab.setLayout(null);
		
		
		final String urlAll = "https://finance.yahoo.com/most-active"; 
		
		try {
			//settings for web scraping: to display 250 Most Active stocks on table
			
			final Document document2 = Jsoup.connect(urlAll).get();
			//System.out.println(document.outerHtml()); - for debugging
			int i = 0;

			
				for (Element row: document2.select("table tr")) {
					
					//remove first empty row
					if (row.select("td:nth-of-type(1)").text().equals("")) {
						continue;
					}
					else {
						String ticker  = row.select("td:nth-of-type(1)").text();
						String name = row.select("td:nth-of-type(2)").text();
						String price = row.select("td:nth-of-type(3)").text();
						String change = row.select("td:nth-of-type(4)").text();
						String percChange = row.select("td:nth-of-type(5)").text();
						//System.out.println(ticker + "\t" + name + "\t" + price + "\t" + change + "\t" + percChange);
						
						rowArray[i] = i;
						
						rowData[i][0] = ticker;
						rowData[i][1] = name;
						rowData[i][2] = price;
						rowData[i][3] = change;
						rowData[i][4] = percChange;
						rowData[i][5] = "Add";
						
					}	
					i+=1;
					
				}
			
		}
		catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		Object columnNames[] = {"Ticker", "Name", "Price", "Change", "% Change", "Action"};
		
		DefaultTableModel model = new DefaultTableModel(rowData, columnNames);
		table.setModel(model);
		ButtonColumn buttonColumn = new ButtonColumn(table, insertItem, 5);
		
		revcalc();
		
		table.setBackground(Color.white);
		table.setForeground(Color.black);
		table.setSelectionBackground(Color.blue);
		table.setGridColor(Color.gray);
		table.setSelectionForeground(Color.white);
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		table.setRowHeight(26);
		table.setAutoCreateRowSorter(true); //enable sorting by clicking the table column
		
		JScrollPane scrollPane = new JScrollPane(table); //to be able to scroll if table gets out of bounds
		scrollPane.setBounds(6, 110, 612, 346);
		scrollPane.setBackground(Color.white);
		scrollPane.setForeground(Color.blue);
		
		
		scrollPane.setVisible(true);
		stocksTab.add(scrollPane);
		
		
		JLabel title = new JLabel("250 Most Active Stocks Today");
		title.setBounds(210, 21, 230, 26);
		title.setFont(new Font("Tahoma", Font.BOLD, 20));
		stocksTab.add(title);
		
		JLabel searchLabel = new JLabel("Enter Search string: ");
		searchLabel.setBounds(52, 63, 198, 30);
		title.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		stocksTab.add(searchLabel);
		
		searchField = new JTextField();
		searchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searchString = searchField.getText();
				//case-sensitive search
				search(searchString);
				
			}
		});
		searchField.setBounds(243, 64, 305, 30);
		stocksTab.add(searchField);
		searchField.setColumns(10);
		
		
	}
	
	//search function
	public void search(String str) {
		model = (DefaultTableModel)table.getModel();
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
		table.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(str));
		
	}
	//calculate total revenue
	public void revcalc() throws Exception {
		
		float revenue = 0;
		float profit_loss =0;
		
		for (int i = 0; i<40; i++) {
			for (int j = 0; j<portfolioTable.getRowCount(); j++) {
				String value = (String) portfolioTable.getModel().getValueAt(j,1);
				if (value.equals(rowData[i][0])) {
					String strcost = (String) rowData[i][2];
					//System.out.println(cost);
					float currentcost = Float.parseFloat(strcost);
					//System.out.println(currentcost);
					revenue = revenue + currentcost;
				}
			}
		}
		
		revField.setText(Float.toString(revenue));
		profit_loss = revenue-cost;
		float percent = profit_loss/cost * 100;
		profitField.setText(Float.toString(percent));
		
		if (profit_loss < 0) {
			SendEmail.sendMail("xxxxx@gmail.com"); //type recipient email address
		}
	}
	
	Action insertItem = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
       //JTable table = (JTable) e.getSource(); // If you have multiple component following the ActionEvent
        	int modelRow = Integer.valueOf(e.getActionCommand());
            if (rowData[modelRow][0] != null) {
                //place the values form rowData object to portfolioData object
            	
            	try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/stocksDB","root","");
        			
        			PreparedStatement ps;
    				ps = conn.prepareStatement("INSERT INTO `portfolios`(`ticker`, `purchased price`, `userID`) VALUES (?,?,?)");
    				ps.setString(1, (String) rowData[modelRow][0]);
    				float price = Float.parseFloat((String) rowData[modelRow][2]); 
    				ps.setFloat(2, price);
    				ps.setInt(3, userid);
    				
    				cost = cost + price;
    				costField.setText(Float.toString(cost));
    				
    				
    				
    				if (ps.executeUpdate() != 0) {
    					JOptionPane.showMessageDialog(null, "The stock has been added to your portfolio.");
    				}
    				else {
    					JOptionPane.showMessageDialog(null, "Something went wrong. Please, try again.");
    				}
    				
    				
    				Statement st;
    				ResultSet rs;
    				st = conn.createStatement();
    				
    				rs = st.executeQuery("SELECT `stockID`, `ticker`, `purchased price` FROM `portfolios` ORDER BY stockID DESC LIMIT 1" );
    			
    				if(rs.next()) {

    					model2.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getFloat(3), "Remove"});

    				}
    				
    				
		
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
        
            } else {
                JOptionPane.showMessageDialog(null, "There is an error. Please try again");
            }
          //put for loop again to calculate the revenue
			try {
				revcalc();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
	};
	
	Action removeItem = new AbstractAction() {
        public void actionPerformed(ActionEvent ex) {
       //JTable table = (JTable) e.getSource(); // If you have multiple component following the ActionEvent
        	int modelRow = Integer.valueOf(ex.getActionCommand());
        	
        	if (portfolioTable.getModel().getValueAt(modelRow,0) != null) {
            	try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/stocksDB","root","");
        			
        			PreparedStatement ps;
    				ps = conn.prepareStatement("DELETE FROM `portfolios` WHERE `stockID`=?");
    				ps.setInt(1, (int) portfolioTable.getModel().getValueAt(modelRow,0));
    				
    				if (ps.executeUpdate() != 0) {
    					JOptionPane.showMessageDialog(null, "The stock is removed");
    				}
    				else {
    					JOptionPane.showMessageDialog(null, "Something went wrong. Please, try again.");
    				}
    				float price = (float) portfolioTable.getModel().getValueAt(modelRow,2);
    				model2.removeRow(modelRow);

    				cost = cost-price;
    				costField.setText(Float.toString(cost));

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	} else {
                JOptionPane.showMessageDialog(null, "There is an error. Please try again");
            }
        	try {
				revcalc();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       
        }
	};


	
}



