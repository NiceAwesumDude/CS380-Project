// Parking Lot GUI Class V1.3
// Contributors: Jacob Thornton, Liam Barr
// Last Modified: June 5, 2023

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ParkingLotGUI extends JFrame {

	private JPanel contentPane;
	private JTextField addCarIDField;
	private JTextField addCarTPField;
	private JTextField addCarLicenseField;
	private JTextField addTimeIDField;
	private JTextField addTimeTPField;
	private JTextField vacateIDField;
	private JTextField adjustField;
	
	private JButton addCarButton;
	private JButton addTimeButton;
	private JButton vacateButton;
	private JButton patrolButton;
	private JButton adjustButton;
	private JButton saveButton;
	private JButton loadButton;
	private JTextArea openSpotsTable;
	private JScrollPane openScroll;
	private JTextArea occupiedSpotsTable;
	private JScrollPane occupiedScroll;
	
	final int LOT_SIZE = 30;
	final ParkingLot lot = new ParkingLot();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkingLotGUI frame = new ParkingLotGUI();
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
	public ParkingLotGUI() {
		
		initComponents();
		createEvents();
		
	}
	
	/**
	 * Initializes GUI components.
	 */
	private void initComponents() {
		
		setTitle("Parking Lot Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 520);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		JLabel openSpotsLabel = new JLabel("Open Spots");
		openSpotsLabel.setBounds(179, 19, 70, 14);
		JLabel occupiedSpotsLabel = new JLabel("Occupied Spots");
		occupiedSpotsLabel.setBounds(25, 19, 110, 14);
		JLabel idLabel = new JLabel("Spot ID");
		idLabel.setBounds(111, 255, 40, 14);
		JLabel tpLabel = new JLabel("Time");
		tpLabel.setBounds(170, 255, 40, 14);
		JLabel licenseLabel = new JLabel("License #");
		licenseLabel.setBounds(230, 255, 70, 14);
		JLabel adjustLabel = new JLabel("Time to Adjust");
		adjustLabel.setBounds(150, 386, 100, 14);
		
		// JTextFields
		addCarIDField = new JTextField();
		addCarIDField.setBounds(111, 275, 45, 20);
		addCarIDField.setColumns(10);
		addCarTPField = new JTextField();
		addCarTPField.setBounds(164, 275, 45, 20);
		addCarTPField.setColumns(10);
		addCarLicenseField = new JTextField();
		addCarLicenseField.setBounds(221, 275, 85, 20);
		addCarLicenseField.setColumns(10);
		vacateIDField = new JTextField();
		vacateIDField.setBounds(111, 343, 45, 20);
		vacateIDField.setColumns(10);
		adjustField = new JTextField();
		adjustField.setBounds(141, 411, 100, 20);
		adjustField.setColumns(10);
		addTimeIDField = new JTextField();
		addTimeIDField.setBounds(111, 309, 45, 20);
		addTimeIDField.setColumns(10);
		addTimeTPField = new JTextField();
		addTimeTPField.setBounds(164, 309, 45, 20);
		addTimeTPField.setColumns(10);
		
		// JButtons
		addCarButton = new JButton("Add Car");
		addCarButton.setBounds(11, 274, 90, 23);
		addTimeButton = new JButton("Add Time");
		addTimeButton.setBounds(11, 308, 90, 23);
		vacateButton = new JButton("Vacate");
		vacateButton.setBounds(11, 342, 90, 23);
		patrolButton = new JButton("Patrol Lot");
		patrolButton.setBounds(11, 376, 120, 23);
		adjustButton = new JButton("Adjust Clock");
		adjustButton.setBounds(11, 410, 120, 23);
		saveButton = new JButton("Save Lot Data");
		saveButton.setBounds(11, 442, 140, 23);
		loadButton = new JButton("Load Lot Data");
		loadButton.setBounds(161, 442, 140, 23);
		openScroll = new JScrollPane(); 
		openScroll.setBounds(15, 39, 109, 205);
		occupiedScroll = new JScrollPane();
		occupiedScroll.setBounds(132, 39, 174, 205);
		contentPane.setLayout(null);
		contentPane.add(saveButton);
		contentPane.add(adjustField);
		contentPane.add(adjustButton);
		contentPane.add(adjustLabel);
		contentPane.add(patrolButton);
		contentPane.add(openScroll);
		openSpotsTable = new JTextArea();
		openScroll.setViewportView(openSpotsTable);
		openSpotsTable.setEditable(false);
		contentPane.add(occupiedScroll);
		occupiedSpotsTable = new JTextArea();
		occupiedScroll.setViewportView(occupiedSpotsTable);
		occupiedSpotsTable.setEditable(false);
		contentPane.add(vacateButton);
		contentPane.add(vacateIDField);
		contentPane.add(addTimeButton);
		contentPane.add(addCarButton);
		contentPane.add(addCarIDField);
		contentPane.add(addCarTPField);
		contentPane.add(idLabel);
		contentPane.add(tpLabel);
		contentPane.add(licenseLabel);
		contentPane.add(addCarLicenseField);
		contentPane.add(addTimeTPField);
		contentPane.add(addTimeIDField);
		contentPane.add(loadButton);
		contentPane.add(occupiedSpotsLabel);
		contentPane.add(openSpotsLabel);
	}
	
	/**
	 * Creates action listeners for the GUI.
	 */
	private void createEvents() {
		
		addCarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Gather string fields
				String sID = addCarIDField.getText();
				int id = Integer.parseInt(sID);
				String sTimePaid = addCarTPField.getText();
				int timePaid = Integer.parseInt(sTimePaid);
				String lic = addCarLicenseField.getText();
				
				// Check that entries are valid
				boolean idTest = (id >= 0) && (id < LOT_SIZE) && (sID.length() > 0);
				boolean timeTest = (timePaid >= 0) && (sTimePaid.length() > 0);
				boolean licTest = lic.length() > 0 && lic.length() <= 7;
            
				// Add vehicle to lot if valid
				if (idTest && timeTest && licTest) {
					boolean test = lot.addVehicle(id, timePaid, lic);
					if (!test) {
						JOptionPane.showMessageDialog(null, "Error: Spot Already Occupied");
					}
					display();
				} else {
					JOptionPane.showMessageDialog(null, "Error: Invalid Inputs");
				}
			}
		});
		
		addTimeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Gather string fields
				String sID = addTimeIDField.getText();
				int id = Integer.parseInt(sID);
				String sTime = addTimeTPField.getText();
				int time = Integer.parseInt(sTime);
				
				// Check that entries are valid
				boolean idTest = (id > 0) && (id < LOT_SIZE) && (sID.length() > 0);
				boolean timeTest = (time > 0) && (sTime.length() > 0);
				
				// Add time if valid
				if (idTest && timeTest) {
					boolean test = lot.addTime(id, time);
					if (!test) {
						JOptionPane.showMessageDialog(null, "Error: Spot not Occupied");
					}
					display();
				} else {
					JOptionPane.showMessageDialog(null, "Error: Invalid Inputs");
				}
			}
		});
		
		vacateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Gather string field
				String sID = vacateIDField.getText();
				int id = Integer.parseInt(sID);
				
				// Check that entry is valid
				boolean idTest = (id > 0) && (id < LOT_SIZE) && (sID.length() > 0);
				
				// Vacate spot if valid
				if (idTest) {
					boolean test = lot.vacate(id);
					if (!test) {
						JOptionPane.showMessageDialog(null, "Error: Spot already Vacant");
					}
					display();
				} else {
					JOptionPane.showMessageDialog(null, "Error: Invalid Spot Input");
				}
				
			}
		});
		
		patrolButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Patrol lot
				lot.patrol();
				display();
			}
		});
		
		adjustButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Gather string field
				String sTime = adjustField.getText();
				int time = 0;
				try {
					time = Integer.parseInt(sTime);
				} catch (Exception z) {
					time = -1;
				}
				
				// Check that entry is valid
				boolean timeTest = (time > 0) && (sTime.length() > 0);
				
				// Pass time if valid
				if (timeTest) {
					lot.passTime(time);
					display();
				} else {
					JOptionPane.showMessageDialog(null, "Error: Invalid Time Input");
				}
			}
		});
		
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Save lot info
				lot.save();
			}
		});
		
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Load lot info
				lot.load();
				display();
			}
		});
		
	}
	
	public void display() {
		openSpotsTable.replaceRange(lot.getEmpty(), 0, openSpotsTable.getText().length());
		occupiedSpotsTable.replaceRange(lot.getFull(), 0, occupiedSpotsTable.getText().length());
	}
}
