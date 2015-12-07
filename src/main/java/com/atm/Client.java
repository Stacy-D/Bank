package com.atm;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;


/**
 * it is the Client class
 * @author Stacy
 */

public class Client {
	
	private String name;
	private String id;
	private String password;
	private int cardNumber;
	private int moneyOnBanlAccount;
	private int moneyLimit;
	
	private Connection connection;
	private ArrayList<Transaction> transactions;
	
	private static final int MAX_DAY_LIMIT = 150000;  // MAX_DAY_LIMIT, which you can withdraw
	
	public Client(String aName, String anId, String aPassword, int aMoneyOnBanlAccount) {
		name = aName;
		id = anId;
		password = aPassword;
		moneyOnBanlAccount = aMoneyOnBanlAccount;
	}

	/**
	 * @return the name
	 */
	
	public String getName() {
		return name;
	}

	/**
	 * @return the id
	 */
	
	public String getId() {
		return id;
	}

	/**
	 * @return the password
	 */
	
	public String getPassword() {
		return password;
	}
	
	/**
	 * @return the cardNumber
	 */
	public int getCardNumber() {
		return cardNumber;
	}
	
	/**
	 * @return the moneyOnBanlAccount
	 */
	public int getMoneyOnBanlAccount() {
		return moneyOnBanlAccount;
	}
	
	public void setMoneyOnBanlAccount(int aMoney) {
		moneyOnBanlAccount = aMoney;
	}

	/**
	 * set the cardNumber
	 */
	
	public void setCardNumber(int number) {
		this.cardNumber = number;
	}
	
	

	/**
	 * check if can do a transaction
	 */
	
	private boolean canWithdraw(int moneyToWithdraw) {
		if (moneyToWithdraw <= MAX_DAY_LIMIT) {
			double sum = 0;
			Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
		      
	        int currentDay = localCalendar.get(Calendar.DATE);

			for (int i = 0; i < transactions.size(); i++) {
				Transaction theTransaction = transactions.get(i);
				if (theTransaction.isSuccessful()) {
					int theDay = theTransaction.getOperationDay();
					if (theDay == currentDay) {
						sum += theTransaction.getRemovedMoney();
					} else {
						break;
					}
				}
			} 
			if (sum <= MAX_DAY_LIMIT) {
				moneyLimit = (int) (MAX_DAY_LIMIT - sum);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * calculate transactions
	 * @param aTransaction
	 * @return
	 */
	
	public boolean addTransaction(Transaction aTransaction) {
		for (int i = transactions.size()-2; i >= 0 ; i--) {
			transactions.set(i+1, transactions.get(i)); 
		}
		transactions.set(0, aTransaction);
		return true;
	}
	
	/**
	 * withdraw money
	 */
	
	public int withdrawMoney(int moneyToWithdraw) {
		if (canWithdraw(moneyToWithdraw) && moneyOnBanlAccount >= moneyToWithdraw) {
			boolean looked = true;
			Transaction theTransaction = new Transaction(moneyToWithdraw);
			moneyOnBanlAccount -= moneyToWithdraw;
			theTransaction.setSuccessful(true);
			addTransaction(theTransaction);
			looked = false;
		}
		return moneyOnBanlAccount;
	}
	
	/**
	 * withdraw money in Internet
	 */
	
	public int withdrawMoneyInInternet(int moneyToWithdraw) {
		if (moneyOnBanlAccount >= moneyToWithdraw) {
			boolean looked = true;
			Transaction theTransaction = new Transaction(moneyToWithdraw);
			moneyOnBanlAccount -= moneyToWithdraw;
			theTransaction.setSuccessful(true);
			addTransaction(theTransaction);
			looked = false;
		}
		return moneyOnBanlAccount;
		}
	
	/**
	 * you can add some money to your bank account
	 */

	public int addMoney(int moneyToAdd) {
		return (moneyToAdd+moneyOnBanlAccount);
	}

	/**
	 * return today limit
	 */
	
	public int todayLimit() {
		return moneyLimit;
	}
	
	@Override
	public String toString() {
		return "Client [name=" + name + ", id=" + id + ", password=" + password
				+ ", moneyOnBanlAccount=" + moneyOnBanlAccount + "]";
	}
}
