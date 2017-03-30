import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Prototype2 {

	//attributes
	private JFrame root;
	private JTextField text_Lang;
	private JTable TopWords;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prototype2 window = new Prototype2();
					window.root.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Prototype2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//make a new frame
				root = new JFrame();
				//Specify the size of the root window (screenx, screeny, width, height)
				root.setBounds(380, 150, 550, 400);
				// if clicked on x at top exit on close
				root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				
				JMenuBar menuBar = new JMenuBar(); //Create component object
				root.setJMenuBar(menuBar); //add it to the screen
				
				JMenu menu_OpenFile = new JMenu("File");
				menuBar.add(menu_OpenFile); // add to menu bar
				
				JMenuItem item_OpenFile = new JMenuItem("Open File");
				menu_OpenFile.add(item_OpenFile);
				
				JMenuItem item_Reset = new JMenuItem("Reset");
				menu_OpenFile.add(item_Reset);
				
				JMenu menu_Functions = new JMenu("Functions");
				menuBar.add(menu_Functions);
				
				JMenuItem item_FindLanguage = new JMenuItem("Find Language");
				menu_Functions.add(item_FindLanguage);
				
				JMenuItem item_TopWords = new JMenuItem("Top 10 Words");
				menu_Functions.add(item_TopWords);
				
				JMenuItem item_FilterUnwanted = new JMenuItem("Filter Unwanted");
				menu_Functions.add(item_FilterUnwanted);
				
				JMenuItem item_DisplayWholeFile = new JMenuItem("Display Whole File");
				menu_Functions.add(item_DisplayWholeFile);
				
				/******************************************************************
				 * THIS IS THE NORTH PANEL
				 ******************************************************************/
				
				JPanel north = new JPanel(); // make a new panel
				root.getContentPane().add(north, BorderLayout.NORTH); // add panel to the root setting to border layout and picking which side
				
				north.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5)); // Set the layout for the north panel to a Flow Layout (side, padx, pady)
				
				JToolBar toolBar = new JToolBar(); // create a tool bar
				north.add(toolBar);// add the tool bar to the north panel
				
				JButton but_FindLang = new JButton("Find Lang");// Make an object of a button
				toolBar.add(but_FindLang);// add the button to the tool bar
				
				JButton but_TopWords = new JButton("Top 10 Words");
				toolBar.add(but_TopWords);
				
				JButton but_DisplayFile = new JButton("Display File");
				toolBar.add(but_DisplayFile);
				
				JButton but_FilterWords = new JButton("Filter Words");
				toolBar.add(but_FilterWords);
				
				JButton but_Exit = new JButton("Exit");
				toolBar.add(but_Exit);
				
				but_FindLang.addActionListener(new ActionListener() { // creates an action listener and adds it to the button
					public void actionPerformed(ActionEvent arg0) { // Receives an action event so it can carry out the stuff inside it
					}
				});
				
				but_TopWords.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				
				but_DisplayFile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				
				but_FilterWords.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				
				but_Exit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						System.exit(0); // exit
					}
				});
				
				/******************************************************************
				 * THIS IS THE EAST PANEL
				 ******************************************************************/
				
				JPanel east = new JPanel();
				root.getContentPane().add(east, BorderLayout.EAST);
				
				/******************************************************************
				 * THIS IS THE SOUTH PANEL
				 ******************************************************************/
				
				JPanel south = new JPanel();
				root.getContentPane().add(south, BorderLayout.SOUTH);
				
				/******************************************************************
				 * THIS IS THE WEST PANEL
				 ******************************************************************/
				
				JPanel west = new JPanel();
				root.getContentPane().add(west, BorderLayout.WEST);
				
				GridBagLayout westlayout = new GridBagLayout(); // create obj of grid bag layout
				westlayout.columnWidths = new int[]{46, 0, 86, 0}; // sets the columns widths to elements int array
				westlayout.rowHeights = new int[]{20, 0, 0, 0, 0}; // sets the row heights heights to elements int array
				westlayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE}; // sets the space distribution to the double array 
				westlayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE}; // sets the space distribution to the double array 
				west.setLayout(westlayout); // Sets the panels layout
				
				JLabel l_Lang = new JLabel("Language"); // Assigns a name to a label
				GridBagConstraints g_L_Lang = new GridBagConstraints(); // creating the object so we can add constraints to certain components
				g_L_Lang.insets = new Insets(5, 5, 5, 5); // the distance from the sides ie padding (top, left, bottom, right)
				g_L_Lang.gridx = 0; // gridx is row
				g_L_Lang.gridy = 0; // gridy is column
				west.add(l_Lang, g_L_Lang); // add label and grid bag contraints to the west panel
				
				text_Lang = new JTextField();
				GridBagConstraints g_Text_Lang = new GridBagConstraints();
				g_Text_Lang.insets = new Insets(5, 5, 5, 0); // the distance from the sides ie padding (top, left, bottom, right)
				g_Text_Lang.gridx = 2;
				g_Text_Lang.gridy = 0;
				west.add(text_Lang, g_Text_Lang);
				text_Lang.setColumns(10); // sets the columns to a certain length
				text_Lang.setEnabled(false);
				
				JLabel lblTopWords = new JLabel("Top 10 Words");
				GridBagConstraints gbc_lblTopWords = new GridBagConstraints();
				gbc_lblTopWords.insets = new Insets(0, 0, 5, 5);
				gbc_lblTopWords.gridx = 1;
				gbc_lblTopWords.gridy = 2;
				west.add(lblTopWords, gbc_lblTopWords);
				
				JScrollPane scrollPane_1 = new JScrollPane();
				GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
				gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
				gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
				gbc_scrollPane_1.gridx = 1;
				gbc_scrollPane_1.gridy = 3;
				gbc_scrollPane_1.gridwidth = 3;
				west.add(scrollPane_1, gbc_scrollPane_1);
				
				table = new JTable();
				table.setModel(new DefaultTableModel(
						new Object[][] {
							{1, null},
							{2, null},
							{3, null},
							{4, null},
							{5, null},
							{6, null},
							{7, null},
							{8, null},
							{9, null},
							{10, null},
						},
						new String[] {
							"Number", "Word"
						}
					));
				scrollPane_1.setViewportView(table);
	}

}
