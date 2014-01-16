package net.codehobby;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class InterestCalculatorGUI extends JFrame
{
	private static final long serialVersionUID = 2352202239702195655L;//Automatically generated ID for the class.

	public InterestCalculatorGUI()
	{
		initUI();
	}
	
	private void initUI()
	{
		//Set up the main panel.
		JPanel panel = new JPanel();
		getContentPane().add( panel );
		panel.setLayout(null);
		
		//Set up the Initial Deposit label and spinner.
		//Initial Deposit rate label
		JLabel initialDepositLabel = new JLabel( "Initial Deposit ($)" );
		initialDepositLabel.setBounds( 50, 50, 120, 30 );
		panel.add( initialDepositLabel );
		//Initial Deposit rate spinner
		SpinnerNumberModel initialDepositModel = new SpinnerNumberModel( 0, 0, 1000000, 0.01 );
		JSpinner initialDepositModelSpinner = new JSpinner( initialDepositModel );
		initialDepositModelSpinner.setBounds( 170, 50, 120, 30 );
		panel.add( initialDepositModelSpinner );
		
		//Set up the Interest rate label and spinner.
		//Interest rate label
		JLabel interestRateLabel = new JLabel( "Interest Rate (%)" );
		interestRateLabel.setBounds( 50, 100, 120, 30 );
		panel.add( interestRateLabel );
		//Interest rate spinner
		SpinnerNumberModel interestRateModel = new SpinnerNumberModel( 7, 1, 100, 1 );
		JSpinner interestRateSpinner = new JSpinner( interestRateModel );
		interestRateSpinner.setBounds( 170, 100, 120, 30 );
		panel.add( interestRateSpinner );
		
		//Set up the Time label and spinner.
		//Time label
		JLabel timeLabel = new JLabel( "Time (years)" );
		timeLabel.setBounds( 50, 150, 120, 30 );
		panel.add( timeLabel );
		//Time spinner
		SpinnerNumberModel timeModel = new SpinnerNumberModel( 30, 1, 100, 1 );
		JSpinner timeSpinner = new JSpinner( timeModel );
		timeSpinner.setBounds( 170, 150, 120, 30 );
		panel.add( timeSpinner );
		
		//Set up the calculate button.
		JButton calcButton = new JButton("Calculate");
		calcButton.setBounds(50, 200, 120, 30);//Set the x,y coordinates and the width and height.
		calcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{//Just a placeholder function for now.
				System.out.println( "You clicked the calculate button! This is just a placeholder." );
			}
		});
		panel.add( calcButton );
		
		//Set up the results labels. These will hold the results of the interest calculations.
		//Title label of the Results label.
		JLabel resultsTitleLabel = new JLabel( "Results:" );
		resultsTitleLabel.setBounds( 50, 240, 120, 30 );
		panel.add( resultsTitleLabel );
		JLabel resultsLabel = new JLabel( "Results go here." );
		resultsLabel.setBounds( 50, 270, 400, 200 );
		resultsLabel.setVerticalAlignment( SwingConstants.TOP );
		panel.add( resultsLabel );
		
		//Set the main window parameters.
		setTitle( "Interest Calculator" );
		setSize( 600, 600 );
		setLocationRelativeTo( null );
		setDefaultCloseOperation( EXIT_ON_CLOSE );//Set it to shut down once the close button is pressed.
	}

	public static void main(String[] args)
	{
		//The invokeLater puts the application on the Swing Event Queue to make sure all UI updates are concurrency safe.
		SwingUtilities.invokeLater( new Runnable() {
			public void run() {
				InterestCalculatorGUI ic = new InterestCalculatorGUI();
				ic.setVisible( true );
			}
		});

	}

}
