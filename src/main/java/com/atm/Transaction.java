package com.atm;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * it is the Transaction class
 * @author natalia
 */


public class Transaction {
	
	private int removedMoney;
	private int operationDay;
	private boolean isSuccessful;
	

	public Transaction(int aRemovedMoney) {
		removedMoney = aRemovedMoney;
		isSuccessful = false;
	}

	/**
	 * @return the removedMoney
	 */
	public int getRemovedMoney() {
		return removedMoney;
	}

	/**
	 * @param isSuccessful the isSuccessful to set
	 */
	public void setSuccessful(boolean successful) {
		isSuccessful = successful;
		Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
		operationDay = localCalendar.get(Calendar.DATE);
	}

	/**
	 * @return the isSuccessful
	 */
	public boolean isSuccessful() {
		return isSuccessful;
	}

	/**
	 * @return the date
	 */
	public int getOperationDay() {
		return operationDay;
	}
	
	

}
