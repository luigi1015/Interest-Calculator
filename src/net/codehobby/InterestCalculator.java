package net.codehobby;

public class InterestCalculator
{
	private int initialDeposit;//The deposit at the opening of the account.
	private int percentInterest;//The percent interest gained on the account every cycle. The value is as a percent. The assumption is that the interest is the same every cycle to simplify the calculations.
	private int recurringDeposit;//The deposit every cycle. It's assumed that the same amount is deposited every cycle to simplify the calculations and record-keeping.

	public InterestCalculator( int newInitialDeposit, int newPercentInterest )
	{//Constructor with only the initial deposit and the interest rate. Assumes there is no recurring deposit.
		initialDeposit = newInitialDeposit;
		percentInterest = newPercentInterest;
		recurringDeposit = 0;
	}

	public InterestCalculator( int newInitialDeposit, int newPercentInterest, int newRecurringDeposit )
	{//Constructor with the initial deposit, the interest rate and the recurring deposit.
		initialDeposit = newInitialDeposit;
		percentInterest = newPercentInterest;
		recurringDeposit = newRecurringDeposit;
	}
	
	public int calculateValue( int cycle )
	{//Calculates the value after cycle cycles and returns that.
		int value = 0;
		for( int i = 0; i < cycle; i++ )
		{
			//Finish this part later. Probably should rethink the variable type. Maybe change to BigDecimal.
		}
		return value;
	}
}
