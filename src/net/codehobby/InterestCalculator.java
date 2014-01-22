package net.codehobby;

import java.math.BigDecimal;

public class InterestCalculator
{
	private BigDecimal initialDeposit;//The deposit at the opening of the account.
	private BigDecimal percentInterest;//The percent interest gained on the account every cycle. The value is as a percent. The assumption is that the interest is the same every cycle to simplify the calculations.
	private BigDecimal recurringDeposit;//The deposit every cycle. It's assumed that the same amount is deposited every cycle to simplify the calculations and record-keeping.

	public InterestCalculator( BigDecimal newInitialDeposit, BigDecimal newPercentInterest )
	{//Constructor with only the initial deposit and the interest rate. Assumes there is no recurring deposit.
		initialDeposit = newInitialDeposit;
		percentInterest = newPercentInterest;
		recurringDeposit = new BigDecimal( "0" );
		initialDeposit.setScale( 2, BigDecimal.ROUND_HALF_UP );
		percentInterest.setScale( 2, BigDecimal.ROUND_HALF_UP );
		recurringDeposit.setScale( 2, BigDecimal.ROUND_HALF_UP );
	}

	public InterestCalculator( BigDecimal newInitialDeposit, BigDecimal newPercentInterest, BigDecimal newRecurringDeposit )
	{//Constructor with the initial deposit, the interest rate and the recurring deposit.
		initialDeposit = newInitialDeposit;
		percentInterest = newPercentInterest;
		recurringDeposit = newRecurringDeposit;
		initialDeposit.setScale( 2, BigDecimal.ROUND_HALF_UP );
		percentInterest.setScale( 2, BigDecimal.ROUND_HALF_UP );
		recurringDeposit.setScale( 2, BigDecimal.ROUND_HALF_UP );
	}
	
	public BigDecimal getInitialDeposit()
	{
		return initialDeposit;
	}
	
	public void setInitialDeposit( BigDecimal newInitialDeposit )
	{
		initialDeposit = newInitialDeposit;
	}
	
	public BigDecimal getPercentInterest()
	{
		return percentInterest;
	}
	
	public void setPercentInterest( BigDecimal newPercentInterest )
	{
		percentInterest = newPercentInterest;
	}
	
	public BigDecimal getRecurringDeposit()
	{
		return recurringDeposit;
	}
	
	public void setRecurringDeposit( BigDecimal newRecurringDeposit )
	{
		recurringDeposit = newRecurringDeposit;
	}
	
	public BigDecimal calculateValue( int cycle )
	{//Calculates the value after cycle cycles and returns that.
		BigDecimal value = new BigDecimal( "0" );//The accumulated value up to the accumulated cycle.
		BigDecimal interest = new BigDecimal( "0" );//The interest accumulated this cycle.
		value.setScale( 2, BigDecimal.ROUND_HALF_UP );
		interest.setScale( 2, BigDecimal.ROUND_HALF_UP );
		value = value.add( initialDeposit );

		for( int i = 0; i < cycle; i++ )
		{
			value = value.add( recurringDeposit );
			interest = value.multiply( percentInterest.divide( new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP ) );
			value = value.add( interest );
		}

		return value;
	}
}
