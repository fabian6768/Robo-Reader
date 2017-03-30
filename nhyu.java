import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;

public class nhyu {
	//attributes
	private JFrame root;
	private JTextField text_Lang;
	private JTable TopWords;
	private JTable table_1;
	private JTable table;
	private JTextField textField;
	private JTable table_2;
	ArrayList<String> punctMarks = new ArrayList<String>();
	ArrayList<String> words = new ArrayList<String>();
	ArrayList<String> fileRead = new ArrayList<String>();
	
	JButton findLang;
	JButton topWords;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// postpones the calculations until the GUI finishes updating by passing the calculation to another thread
		EventQueue.invokeLater(new Runnable() {
			//Creating the window in the run method 
			public void run() {
				try {
					//Creating an object of itself
					nhyu window = new nhyu();
					//make the frame visible
					window.root.setVisible(true);
					//Checking for errors
				} catch (Exception e) {
					//print the stack
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * This is the constructor for the GUI.
	 */
	public nhyu() {
		// Calls a method.
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//make a new frame
		root = new JFrame();
		//Specify the size of the root window (screenx, screeny, width, height)
		root.setBounds(380, 150, 632, 523);
		// if clicked on x at top exit on close
		root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// disable resizeable
		root.setResizable(false);
		
		/******************************************************************
		 * THIS IS THE NORTH PANEL
		 ******************************************************************/
		
		JPanel north = new JPanel();
		root.getContentPane().add(north, BorderLayout.NORTH);
		north.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JToolBar toolBar = new JToolBar();
		north.add(toolBar);
		
		findLang = new JButton("Find Lang");
		Icon findlangico = new ImageIcon(getClass().getResource("findlang.jpg"));
		findLang = new JButton(findlangico);
		
		toolBar.add(findLang);
		
		topWords = new JButton("Top 10 Words");
		Icon topwordsico = new ImageIcon(getClass().getResource("top10.jpg"));
		topWords = new JButton(topwordsico);
		toolBar.add(topWords);
		
		JButton displayFile = new JButton("Display File");
		Icon fileico = new ImageIcon(getClass().getResource("wholefile.jpg"));
		displayFile = new JButton(fileico);
		toolBar.add(displayFile);
		
		JButton filterWords = new JButton("Filter Words");
		Icon filterico = new ImageIcon(getClass().getResource("filter.jpg"));
		filterWords = new JButton(filterico);
		toolBar.add(filterWords);
		
		JButton exitGUI = new JButton("Exit");
		Icon exitico = new ImageIcon(getClass().getResource("exit.jpg"));
		exitGUI = new JButton(exitico);
		toolBar.add(exitGUI);
		
		/******************************************************************
		 * THIS IS THE EAST PANEL
		 ******************************************************************/
		
		JPanel east = new JPanel();
		root.getContentPane().add(east, BorderLayout.EAST);
		GridBagLayout gbl_east = new GridBagLayout();
		gbl_east.columnWidths = new int[]{0, 0, 66, 0, 58, 0};
		gbl_east.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_east.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_east.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		east.setLayout(gbl_east);
		
		JLabel lblFilterWords = new JLabel("Filter Words");
		GridBagConstraints gbc_lblFilterWords = new GridBagConstraints();
		gbc_lblFilterWords.insets = new Insets(40, 0, 5, 20);
		gbc_lblFilterWords.gridx = 3;
		gbc_lblFilterWords.gridy = 2;
		east.add(lblFilterWords, gbc_lblFilterWords);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 20);
		gbc_scrollPane_1.anchor = GridBagConstraints.NORTH;
		gbc_scrollPane_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 3;
		gbc_scrollPane_1.gridheight = 0;
		gbc_scrollPane_1.gridwidth = 5;
		gbc_scrollPane_1.ipady = 180;
		gbc_scrollPane_1.ipadx = 30;
		east.add(scrollPane_1, gbc_scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		scrollPane_1.setViewportView(textArea);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 3;
		gbc_separator_1.gridy = 7;
		east.add(separator_1, gbc_separator_1);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 3;
		gbc_separator.gridy = 8;
		east.add(separator, gbc_separator);
		
		/******************************************************************
		 * THIS IS THE SOUTH PANEL
		 ******************************************************************/
		
		JPanel south = new JPanel();
		root.getContentPane().add(south, BorderLayout.SOUTH);
		GridBagLayout gbl_south = new GridBagLayout();
		gbl_south.columnWidths = new int[]{337, 0};
		gbl_south.rowHeights = new int[]{0, 0, 14, 0};
		gbl_south.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_south.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		south.setLayout(gbl_south);
		
		JLabel lblDipslayText = new JLabel("Dipslay Text");
		GridBagConstraints gbc_lblDipslayText = new GridBagConstraints();
		gbc_lblDipslayText.insets = new Insets(0, 0, 5, 0);
		gbc_lblDipslayText.gridx = 0;
		gbc_lblDipslayText.gridy = 0;
		south.add(lblDipslayText, gbc_lblDipslayText);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 2;
		gbc_scrollPane_2.ipady = 70;
		gbc_scrollPane_2.ipadx = 0;
		south.add(scrollPane_2, gbc_scrollPane_2);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		scrollPane_2.setViewportView(textArea_1);
		
		displayFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileManager read_2 = new FileManager("Z:\\Java\\R\\src\\Example1.txt");
		 		read_2.connectToFile();
	 		 	ArrayList<String> readlines = read_2.readLines();
		 		read_2.closeReadFile();
	 		 	String str = "";
	 		 	for(String temp: readlines){
	 		 		str = str + temp + "\n";
	 		 	}
	 		 	textArea_1.setText(str);
			}
		});
		
		/******************************************************************
		 * THIS IS THE WEST PANEL
		 ******************************************************************/
		
		JPanel west = new JPanel();
		root.getContentPane().add(west, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("Language");
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Top 10 Words");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_west = new GroupLayout(west);
		gl_west.setHorizontalGroup(
			gl_west.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_west.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
				.addGroup(gl_west.createSequentialGroup()
					.addGap(92)
					.addComponent(lblNewLabel_1)
					.addContainerGap(96, Short.MAX_VALUE))
				.addGroup(gl_west.createSequentialGroup()
					.addGap(21)
					.addComponent(scrollPane, 0, 0, Short.MAX_VALUE)
					.addGap(20))
		);
		gl_west.setVerticalGroup(
			gl_west.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_west.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_west.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(97, Short.MAX_VALUE))
		);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
				new Object[][] {
					{"1.", null},
					{"2.", null},
					{"3.", null},
					{"4.", null},
					{"5.", null},
					{"6.", null},
					{"7.", null},
					{"8.", null},
					{"9.", null},
					{"10.", null},
				},
				new String[] {
					"Number", "Word"
				}
			));
		scrollPane.setViewportView(table_2);
		west.setLayout(gl_west);
		
		findLang.addActionListener(new ActionListener() { // creates an action listener and adds it to the button
			public void actionPerformed(ActionEvent arg0) { // Receives an action event so it can carry out the stuff inside it
				FindLan t3 = new FindLan(words);
	 		 	String lang = t3.cLang();
	 		 	textField.setText(lang);
			}
		});
		
		topWords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileManager read_1 = new FileManager("punctuation.txt");
		 		read_1.connectToFile();
		 		ArrayList<String> punctMarks = read_1.readFile();
		 		read_1.closeReadFile();
				RemovePunct t1 = new RemovePunct(punctMarks, words);
	 			//Calling the EndArray(Remove) method to clean an array of punctuation marks
	 		 	ArrayList<String> cleanWords = t1.EndArray();
	 			
	 		 	table_2.setModel(new DefaultTableModel(
	 					new Object[][] {
	 						{"1.", cleanWords.get(0)},
	 						{"2.", cleanWords.get(1)},
	 						{"3.", cleanWords.get(2)},
	 						{"4.", cleanWords.get(3)},
	 						{"5.", cleanWords.get(4)},
	 						{"6.", cleanWords.get(5)},
	 						{"7.", cleanWords.get(6)},
	 						{"8.", cleanWords.get(7)},
	 						{"9.", cleanWords.get(8)},
	 						{"10.", cleanWords.get(9)},
	 					},
	 					new String[] {
	 						"Number", "Word"
	 					}
	 				));
			}
		});
			
		/******************************************************************
		 * THIS IS THE MENU AT TOP
		 *****************************************************************/
		
		JMenuBar menuBar = new JMenuBar();
		root.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpenFile = new JMenuItem("Open File");
		mnFile.add(mntmOpenFile);
		
		JMenuItem mntmReset = new JMenuItem("Reset");
		mnFile.add(mntmReset);
		
		JMenu mnFunctions = new JMenu("Functions");
		menuBar.add(mnFunctions);
		
		JMenuItem mntmFindLanguage = new JMenuItem("Find Language");
		mnFunctions.add(mntmFindLanguage);
		
		JMenuItem mntmTopWords = new JMenuItem("Top 10 Words");
		mnFunctions.add(mntmTopWords);
		
		JMenuItem mntmDisplayFile = new JMenuItem("Display File");
		mnFunctions.add(mntmDisplayFile);
		
		JMenuItem mntmFilterWords = new JMenuItem("Filter Words");
		mnFunctions.add(mntmFilterWords);
		
		mntmOpenFile.addActionListener(new ActionListener() { // creates an action listener and adds it to the button
			public void actionPerformed(ActionEvent arg0) { // Receives an action event so it can carry out the stuff inside it
				filechoser e = new filechoser();
				
				try {
					words = e.PickMe();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		mntmReset.addActionListener(new ActionListener() { // creates an action listener and adds it to the button
			public void actionPerformed(ActionEvent arg0) { // Receives an action event so it can carry out the stuff inside it
				table_2.setModel(new DefaultTableModel(
						new Object[][] {
							{"1.", null},
							{"2.", null},
							{"3.", null},
							{"4.", null},
							{"5.", null},
							{"6.", null},
							{"7.", null},
							{"8.", null},
							{"9.", null},
							{"10.", null},
						},
						new String[] {
							"Number", "Word"
						}
					));
				
				textArea.setText("");
				textField.setText("");
				textArea_1.setText("");
			}
		});
		
		mntmFindLanguage.addActionListener(new ActionListener() { // creates an action listener and adds it to the button
			public void actionPerformed(ActionEvent arg0) { // Receives an action event so it can carry out the stuff inside it
				findLang.doClick();
			}
		});
		
		mntmTopWords.addActionListener(new ActionListener() { // creates an action listener and adds it to the button
			public void actionPerformed(ActionEvent arg0) { // Receives an action event so it can carry out the stuff inside it
				topWords.doClick();
			}
		});
		
		mntmDisplayFile.addActionListener(new ActionListener() { // creates an action listener and adds it to the button
			public void actionPerformed(ActionEvent arg0) { // Receives an action event so it can carry out the stuff inside it
				FileManager read_2 = new FileManager("Z:\\Java\\R\\src\\Example1.txt");
		 		read_2.connectToFile();
	 		 	ArrayList<String> readlines = read_2.readLines();
		 		read_2.closeReadFile();
	 		 	String str = "";
	 		 	for(String temp: readlines){
	 		 		str = str + temp + "\n";
	 		 	}
	 		 	textArea_1.setText(str);
			}
		});
		
		mntmFilterWords.addActionListener(new ActionListener() { // creates an action listener and adds it to the button
			public void actionPerformed(ActionEvent arg0) { // Receives an action event so it can carry out the stuff inside it
			}
		});
		
		/******************************************************************
		 * THIS IS THE ACTION LISTENERS FOR THE BUTTONS
		 *****************************************************************/
		
		exitGUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); // exit
			}
		});
	}
}