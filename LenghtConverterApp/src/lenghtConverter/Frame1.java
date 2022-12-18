package lenghtConverter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Frame1 {

	private JFrame frmLenghtconverter;
	private JTextField Input1;
	private JTextField input2;
	private JTextField output;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frmLenghtconverter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLenghtconverter = new JFrame();
		frmLenghtconverter.setTitle("LenghtConverter");
		frmLenghtconverter.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 20));
		frmLenghtconverter.setBounds(100, 100, 945, 505);
		frmLenghtconverter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLenghtconverter.getContentPane().setLayout(null);
		
		JLabel lblExplain = new JLabel("This app converts feet and inches values into centimeters value.");
		lblExplain.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblExplain.setBounds(50, 45, 823, 51);
		frmLenghtconverter.getContentPane().add(lblExplain);
		
		JLabel lblInstruction1 = new JLabel("Enter Feet");
		lblInstruction1.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblInstruction1.setBounds(50, 153, 107, 38);
		frmLenghtconverter.getContentPane().add(lblInstruction1);
		
		Input1 = new JTextField();
		Input1.setFont(new Font("Verdana", Font.PLAIN, 20));
		Input1.setBounds(167, 153, 245, 38);
		frmLenghtconverter.getContentPane().add(Input1);
		Input1.setColumns(10);
		
		JLabel lblInstruction2 = new JLabel("Enter Inches");
		lblInstruction2.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblInstruction2.setBounds(466, 153, 141, 38);
		frmLenghtconverter.getContentPane().add(lblInstruction2);
		
		input2 = new JTextField();
		input2.setFont(new Font("Verdana", Font.PLAIN, 20));
		input2.setBounds(617, 153, 245, 38);
		frmLenghtconverter.getContentPane().add(input2);
		input2.setColumns(10);
		
		JButton btnConvert = new JButton("Convert To Centimeters");
		btnConvert.setForeground(new Color(255, 255, 255));
		btnConvert.setBackground(new Color(128, 128, 128));
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double feetValue=-2, inchesValue=-2;
				boolean wrong =false;
				if(Input1.getText().isEmpty() || Input1.getText().isBlank() || input2.getText().isEmpty() || input2.getText().isBlank()) {
					
					if(Input1.getText().isEmpty() || Input1.getText().isBlank()) feetValue=0;
					else {
						try {
							feetValue = Double.parseDouble(Input1.getText());
						}catch(Exception e5) {
							wrong = true;
						}
					}
					if(input2.getText().isEmpty() || input2.getText().isBlank()) inchesValue =0;
					else {
						try {
							inchesValue = Double.parseDouble(input2.getText());
						}catch(Exception e6) {
							wrong = true;
						}
					}
					if (wrong)
						output.setText("Please enter valid values!");
					else
						output.setText(LenghtConverter.printConversion(feetValue, inchesValue));
				}
				else {
					
					try {
						inchesValue = Double.parseDouble(input2.getText());
						feetValue = Double.parseDouble(Input1.getText());
						output.setText(LenghtConverter.printConversion(feetValue, inchesValue));
					}catch(Exception e7) {
						output.setText("Please enter valid values!");
					}
				}
					
			}
		});
		btnConvert.setFont(new Font("Verdana", Font.BOLD, 20));
		btnConvert.setBounds(263, 245, 332, 82);
		frmLenghtconverter.getContentPane().add(btnConvert);
		
		output = new JTextField();
		output.setFont(new Font("Verdana", Font.BOLD, 19));
		output.setBounds(50, 374, 585, 43);
		frmLenghtconverter.getContentPane().add(output);
		output.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBackground(new Color(128, 128, 128));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Input1.setText("");
				input2.setText("");
				output.setText("");
			}
		});
		btnReset.setFont(new Font("Verdana", Font.BOLD, 20));
		btnReset.setBounds(687, 374, 175, 43);
		frmLenghtconverter.getContentPane().add(btnReset);
	}
}
