import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import static javax.swing.ScrollPaneConstants.*;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

public class Prototype {
	
	ArrayList<String> punctMarks = new ArrayList<String>();
	private JFrame frame;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prototype window = new Prototype();
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
	public Prototype() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnOpenFile = new JMenu("File");
		menuBar.add(mnOpenFile);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open File");
		mnOpenFile.add(mntmNewMenuItem);
		
		JMenuItem mntmReset = new JMenuItem("Reset");
		mnOpenFile.add(mntmReset);
		
		JMenu mnFunctions = new JMenu("Functions");
		menuBar.add(mnFunctions);
		
		JMenuItem mntmFindLanguage = new JMenuItem("Find Language");
		mnFunctions.add(mntmFindLanguage);
		
		JMenuItem mntmTopWords = new JMenuItem("Top 10 Words");
		mnFunctions.add(mntmTopWords);
		
		JMenuItem mntmFilterUnwanted = new JMenuItem("Filter Unwanted");
		mnFunctions.add(mntmFilterUnwanted);
		
		JMenuItem mntmDisplayWholeFile = new JMenuItem("Display Whole File");
		mnFunctions.add(mntmDisplayWholeFile);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JToolBar toolBar = new JToolBar();
		panel.add(toolBar);
		
		JButton btnNewButton = new JButton("Find Lang");
		Icon findlangico = new ImageIcon(getClass().getResource("findlang.jpg"));
		btnNewButton = new JButton(findlangico);
		
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Top 10 Words");
		Icon topwordsico = new ImageIcon(getClass().getResource("top10.jpg"));
		btnNewButton_1 = new JButton(topwordsico);
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Display File");
		Icon fileico = new ImageIcon(getClass().getResource("wholefile.jpg"));
		btnNewButton_2 = new JButton(fileico);
		toolBar.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Filter Words");
		Icon filterico = new ImageIcon(getClass().getResource("filter.jpg"));
		btnNewButton_3 = new JButton(filterico);
		toolBar.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Exit");
		Icon exitico = new ImageIcon(getClass().getResource("exit.jpg"));
		btnNewButton_4 = new JButton(exitico);
		toolBar.add(btnNewButton_4);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.EAST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 46, 0, 0, 89, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE, 0.0};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Display Text");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 5;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		gbc_scrollPane_1.gridwidth = 0;
		panel_1.add(scrollPane_1, gbc_scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane_1.setViewportView(textArea);

		JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 5;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.WEST);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{46, 0, 0, 0, 86, 0};
		gbl_panel_3.rowHeights = new int[]{20, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblLanguage = new JLabel("Language");
		GridBagConstraints gbc_lblLanguage = new GridBagConstraints();
		gbc_lblLanguage.insets = new Insets(5, 5, 5, 5); // the distance from the sides ie padding (top, left, bottom, right)
		gbc_lblLanguage.gridx = 0; // gridx is row
		gbc_lblLanguage.gridy = 0; // gridy is column
		panel_3.add(lblLanguage, gbc_lblLanguage);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(5, 5, 5, 0); // the distance from the sides ie padding (top, left, bottom, right)
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 0;
		gbc_textField.gridwidth = 2;
		panel_3.add(textField, gbc_textField);
		textField.setColumns(20);
		textField.setEnabled(false);
		
		JLabel lblTopWords = new JLabel("Top 10 Words");
		GridBagConstraints gbc_lblTopWords = new GridBagConstraints();
		gbc_lblTopWords.anchor = GridBagConstraints.NORTH;
		gbc_lblTopWords.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblTopWords.insets = new Insets(0, 0, 5, 5);
		gbc_lblTopWords.gridx = 2;
		gbc_lblTopWords.gridy = 2;
		panel_3.add(lblTopWords, gbc_lblTopWords);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.gridheight = 3;
		panel_3.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
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
		
		btnNewButton.addActionListener(new ActionListener() { // creates an action listener and adds it to the button
			public void actionPerformed(ActionEvent arg0) { // Receives an action event so it can carry out the stuff inside it
				FileManager read_2 = new FileManager("Z:\\Java\\R\\src\\Example1.txt");
		 		read_2.connectToFile();
		 		ArrayList<String> fileRead = read_2.readFile();
		 		read_2.closeReadFile();
				FindLan t3 = new FindLan(fileRead);
	 		 	String lang = t3.cLang();
	 		 	textField.setText(lang);
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileManager read_1 = new FileManager("Z:\\Java\\R\\src\\punctuation.txt");
		 		read_1.connectToFile();
		 		punctMarks = read_1.readFile();
		 		read_1.closeReadFile();
				FileManager read_2 = new FileManager("Z:\\Java\\R\\src\\Example1.txt");
		 		read_2.connectToFile();
		 		ArrayList<String> fileRead = read_2.readFile();
		 		read_2.closeReadFile();
				RemovePunct t1 = new RemovePunct(punctMarks, fileRead);
	 			//Calling the EndArray(Remove) method to clean an array of punctuation marks
	 		 	ArrayList<String> cleanWords = t1.EndArray();
	 			
	 		 	table.setModel(new DefaultTableModel(
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
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileManager read_2 = new FileManager("Z:\\Java\\R\\src\\Example1.txt");
		 		read_2.connectToFile();
	 		 	ArrayList<String> readlines = read_2.readLines();
		 		read_2.closeReadFile();
	 		 	String str = "";
	 		 	for(String temp: readlines){
	 		 		str = str + temp + "\n";
	 		 	}
	 		 	textArea.setText(str);
			}
		});
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); // exit
			}
		});
		scrollPane.setViewportView(table);
	}

}
