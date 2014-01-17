package net.codehobby;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

public class InterestCalculatorGUI extends JFrame
{
	private static final long serialVersionUID = 2352202239702195655L;//Automatically generated ID for the class.

	//UI Objects
	JPanel panel;
	JLabel initialDepositLabel;
	SpinnerNumberModel initialDepositModel;
	JSpinner initialDepositSpinner;
	JLabel interestRateLabel;
	SpinnerNumberModel interestRateModel;
	JSpinner interestRateSpinner;
	JLabel timeLabel;
	SpinnerNumberModel timeModel;
	JSpinner timeSpinner;
	JButton calcButton;
	JLabel resultsTitleLabel;
	JTextArea resultsTextArea;
	JScrollPane resultsScrollPane;
	
	public InterestCalculatorGUI()
	{
		initUI();
	}
	
	private void initUI()
	{
		//Set up the main panel.
		panel = new JPanel();
		getContentPane().add( panel );
		panel.setLayout(null);
		
		//Set up the Initial Deposit label and spinner.
		//Initial Deposit rate label
		initialDepositLabel = new JLabel( "Initial Deposit ($)" );
		initialDepositLabel.setBounds( 50, 50, 120, 30 );
		panel.add( initialDepositLabel );
		//Initial Deposit rate spinner
		initialDepositModel = new SpinnerNumberModel( 0, 0, 1000000, 0.01 );
		initialDepositSpinner = new JSpinner( initialDepositModel );
		initialDepositSpinner.setBounds( 170, 50, 120, 30 );
		panel.add( initialDepositSpinner );
		
		//Set up the Interest rate label and spinner.
		//Interest rate label
		interestRateLabel = new JLabel( "Interest Rate (%)" );
		interestRateLabel.setBounds( 50, 100, 120, 30 );
		panel.add( interestRateLabel );
		//Interest rate spinner
		interestRateModel = new SpinnerNumberModel( 7, 1, 100, 1 );
		interestRateSpinner = new JSpinner( interestRateModel );
		interestRateSpinner.setBounds( 170, 100, 120, 30 );
		panel.add( interestRateSpinner );
		
		//Set up the Time label and spinner.
		//Time label
		timeLabel = new JLabel( "Time (years)" );
		timeLabel.setBounds( 50, 150, 120, 30 );
		panel.add( timeLabel );
		//Time spinner
		timeModel = new SpinnerNumberModel( 30, 1, 100, 1 );
		timeSpinner = new JSpinner( timeModel );
		timeSpinner.setBounds( 170, 150, 120, 30 );
		panel.add( timeSpinner );
		
		//Set up the calculate button.
		calcButton = new JButton("Calculate");
		calcButton.setBounds(50, 200, 120, 30);//Set the x,y coordinates and the width and height.
		calcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{//Just a placeholder function for now.
				calculateClicked();
				//System.out.println( "You clicked the calculate button! This is just a placeholder." );
			}
		});
		panel.add( calcButton );
		
		//Set up the results elements. These will hold the results of the interest calculations.
		//Title label of the Results label.
		resultsTitleLabel = new JLabel( "Results:" );
		resultsTitleLabel.setBounds( 50, 240, 120, 30 );
		panel.add( resultsTitleLabel );
		//JTextArea and the JScrollPane it'll use.
		resultsTextArea = new JTextArea( "Results go here." );
		//resultsTextArea.setBounds( 50, 270, 400, 200 );
		resultsTextArea.setEditable( false );
		resultsScrollPane = new JScrollPane( resultsTextArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		resultsScrollPane.setBounds(50,  270, 400, 200);
		panel.add( resultsScrollPane );
		
		//Set the main window parameters.
		setTitle( "Interest Calculator" );
		setSize( 600, 600 );
		setLocationRelativeTo( null );
		setDefaultCloseOperation( EXIT_ON_CLOSE );//Set it to shut down once the close button is pressed.
	}
	
	public void calculateClicked()
	{
		System.out.println( "The calculate button has been clicked! This is just a placeholder." );
		resultsTextArea.setText( "This is just placeholder text." );
		//Get the user-inputted values.
		BigDecimal initialDepositDecimal =  new BigDecimal( initialDepositModel.getNumber().toString() );
		initialDepositDecimal.setScale( 2, BigDecimal.ROUND_HALF_UP );
		BigDecimal interestRateDecimal =  new BigDecimal( interestRateModel.getNumber().toString() );
		interestRateDecimal.setScale( 2, BigDecimal.ROUND_HALF_UP );
		int timeYears =  timeModel.getNumber().intValue();

		InterestCalculator calc = new InterestCalculator( initialDepositDecimal, interestRateDecimal );
		
		for( int i = 0; i < timeYears; i++ )
		{
			BigDecimal newVal =  calc.calculateValue( i );
			newVal.setScale( 2, BigDecimal.ROUND_HALF_UP );
			resultsTextArea.setText( resultsTextArea.getText() + "\n" + newVal.toString() );
		}
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
