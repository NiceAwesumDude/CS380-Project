// Parking Lot GUI Class V1.0
// Contributors: Jacob Thornton, Liam Barr
// Last Modified: May 19, 2023

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

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
		setBounds(100, 100, 450, 540);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		// JLabels
		JLabel allSpotsLabel = new JLabel("All Parking Spots");
		JLabel openSpotsLabel = new JLabel("All Open Spots");
		JLabel occupiedSpotsLabel = new JLabel("All Occupied Spots");
		JLabel idLabel = new JLabel("Spot ID");
		JLabel tpLabel = new JLabel("Time Purchased");
		JLabel licenseLabel = new JLabel("License #");
		JLabel adjustLabel = new JLabel("Time to Adjust");
		
		// JTextFields
		addCarIDField = new JTextField();
		addCarIDField.setColumns(10);
		addCarTPField = new JTextField();
		addCarTPField.setColumns(10);
		addCarLicenseField = new JTextField();
		addCarLicenseField.setColumns(10);
		vacateIDField = new JTextField();
		vacateIDField.setColumns(10);
		adjustField = new JTextField();
		adjustField.setColumns(10);
		addTimeIDField = new JTextField();
		addTimeIDField.setColumns(10);
		addTimeTPField = new JTextField();
		addTimeTPField.setColumns(10);
		
		// JButtons
		addCarButton = new JButton("Add Car");
		addTimeButton = new JButton("Add Time");
		vacateButton = new JButton("Vacate");
		patrolButton = new JButton("Patrol Lot");
		adjustButton = new JButton("Adjust Clock");
		saveButton = new JButton("Save Lot Data");
		loadButton = new JButton("Load Lot Data");
		
		// JTextAreas
		JTextArea allSpotsTable = new JTextArea();
		JTextArea openSpotsTable = new JTextArea();
		JTextArea occupiedSpotsTable = new JTextArea();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(loadButton, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(adjustButton, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(adjustField, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(patrolButton, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(adjustLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(addCarButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(vacateButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(addTimeButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(idLabel)
								.addComponent(addTimeIDField, 0, 0, Short.MAX_VALUE)
								.addComponent(addCarIDField, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
								.addComponent(vacateIDField, 0, 0, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(addTimeTPField, 0, 0, Short.MAX_VALUE)
								.addComponent(addCarTPField, 0, 0, Short.MAX_VALUE)
								.addComponent(tpLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(licenseLabel)
								.addComponent(addCarLicenseField, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(allSpotsTable, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addComponent(allSpotsLabel))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(openSpotsTable, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
								.addComponent(openSpotsLabel))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(occupiedSpotsLabel)
								.addComponent(occupiedSpotsTable, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(allSpotsLabel)
						.addComponent(openSpotsLabel)
						.addComponent(occupiedSpotsLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(allSpotsTable, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
						.addComponent(openSpotsTable, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
						.addComponent(occupiedSpotsTable, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(idLabel)
						.addComponent(tpLabel)
						.addComponent(licenseLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(addCarButton)
						.addComponent(addCarIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(addCarTPField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(addCarLicenseField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(addTimeButton)
						.addComponent(addTimeIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(addTimeTPField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(vacateButton)
						.addComponent(vacateIDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(patrolButton)
						.addComponent(adjustLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(adjustButton)
						.addComponent(adjustField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(saveButton)
						.addComponent(loadButton))
					.addGap(106))
		);
		contentPane.setLayout(gl_contentPane);
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
				boolean idTest = id >= 0 && id <= LOT_SIZE;
				boolean timeTest = timePaid >= 0;
				boolean licTest = lic.length() > 0 && lic.length() <= 7;
				
				// Add vehicle to lot if valid
				if (idTest && timeTest && licTest) {
					lot.addVehicle(id, timePaid, lic);
				} else {
					// Print an error window stating "Invalid Input" <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
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
				boolean idTest = id > 0 && id <= LOT_SIZE;
				boolean timeTest = time > 0;
				
				// Add time if valid
				if (idTest && timeTest) {
					lot.addTime(id, time);
				} else {
					// Print an error window stating "Invalid Input" <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				}
			}
		});
		
		vacateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Gather string field
				String sID = vacateIDField.getText();
				int id = Integer.parseInt(sID);
				
				// Check that entry is valid
				boolean idTest = id > 0 && id <= LOT_SIZE;
				
				// Vacate spot if valid
				if (idTest) {
					lot.vacate(id);
				} else {
					// Print an error window stating "Invalid Input" <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				}
				
			}
		});
		
		patrolButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Patrol lot
				lot.patrol();
				
				// Update display tables
			}
		});
		
		adjustButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Gather string field
				String sTime = adjustField.getText();
				int time = Integer.parseInt(sTime);
				
				// Check that entry is valid
				boolean timeTest = time > 0;
				
				// Pass time if valid
				if (timeTest) {
					lot.passTime(time);
				} else {
					// Print an error window stating "Invalid Input" <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				}
			}
		});
		
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Save lot info
				lot.save();
				
				// Print save info
			}
		});
		
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Implement Later <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
				
			}
		});
		
	}
}
