package com.atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

/**
 * @author Oleh Kurpiak
 *
 */
public class BankService {
	
	private static Connection connection;
	private static int currentCardNumber = 0000;
	private static final String FIRPRTCARD = "1111 2222 3333 ";
	
		
	
	private static final int MAX_LIMIT = 150000;
	
	/**
	 * create sql table
	 */
	
	public static void createDatastore() {
		 try {
	            Class.forName("org.sqlite.JDBC");
	            connection = DriverManager.getConnection("jdbc:sqlite:Bank.db");
	            PreparedStatement st = connection.prepareStatement("create table if not exists 'Bank' "
	            		+ "('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'clientId' text,"
	            		+ "'password' text, 'money' INTEGER,'cardNumber' INTEGER, 'moneyLimit' INTEGER, 'date' text);");
	            int result = st.executeUpdate();
	            initilizeCardNumber();

	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            System.exit(0);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }    
	}
	
	/**
	 * add client to SQLite
	 * @param aClient
	 * @throws SQLException 
	 */
	public synchronized static String addClientToDatastore(Client aClient)  {
		if (aClient != null && findClient(aClient.getName())==-1) {
			try {
	        	String name = aClient.getName();
	        	String password = aClient.getPassword();
	        	String clientId = aClient.getId();
	        	int cardNumber =  currentCardNumber;
	        	String toReturn = currentCartNumber();
	        	getNextCard();
	        	int money = aClient.getMoneyOnBanlAccount();
	        	PreparedStatement statement = connection.prepareStatement("INSERT INTO Bank(name, password,"
	        			+ " clientId, money, cardNumber, moneyLimit, date) VALUES (?,?,?,?,?,?,?)");
	            statement.setString(1, name);
	            statement.setString(2, password);
	            statement.setString(3, clientId);
	            statement.setInt(4, money);
	            statement.setInt(5, cardNumber);
	            statement.setInt(6, MAX_LIMIT);
	            statement.setString(7, new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime()));
	            int result = statement.executeUpdate();
	            statement.close();
	            return toReturn;
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
		return null;
	}

	 /**
	  * 
	  * @param name
	  * @param password
	  * @param money
	  * @param currentSum
	  * @return
	  * @throws SQLException
	  */
	 
	 public synchronized static boolean withdrawByName(String name, String password, int money) throws SQLException {
		 if(money > MAX_LIMIT) return false;
		 Statement statement = connection.createStatement();
			try{
				ResultSet res = statement.executeQuery("SELECT * FROM Bank WHERE name=\""+name+"\" AND password =\""+password+"\";");
				if(res.next())
				{
					int currMoney = res.getInt("money");
					int limit = res.getInt("moneyLimit");
					if ((currMoney < money) ||(limit == 0) || limit < money) return false;
					currMoney-=money;
					limit-=money;
					PreparedStatement st = connection.prepareStatement("UPDATE Bank SET money = ?, moneyLimit = ? WHERE name = ?");
					st.setInt(1, currMoney);
					st.setInt(2, limit);
					st.setString(3, name);
					st.executeUpdate();
			 return true;
				}}
				catch(SQLException ex)
				{
				ex.printStackTrace();
				}
		 return false;
	 }
	 /**
	  * Withdraw by card number for ATM in future
	  * @param aCardNumber
	  * @param password
	  * @param money
	  * @return
	  * @throws SQLException
	  */
	 public synchronized static boolean withdrawByCard(int aCardNumber, String password, int money) throws SQLException {
		 if(money > MAX_LIMIT) return false;
		 Statement statement = connection.createStatement();
			try{
				ResultSet res = statement.executeQuery("SELECT * FROM Bank WHERE cardNumber=\""+aCardNumber+"\" AND password =\""+password+"\";");
				if(res.next())
				{
					int currMoney = res.getInt("money");
					int limit = res.getInt("moneyLimit");
					if ((currMoney < money) ||(limit == 0) || limit < money) return false;
					currMoney-=money;
					limit-=money;
					PreparedStatement st = connection.prepareStatement("UPDATE Bank SET money = ?, moneyLimit = ? WHERE cardNumber = ?");
					st.setInt(1, currMoney);
					st.setInt(2, limit);
					st.setInt(3, aCardNumber);
					st.executeUpdate();
			 return true;
				}}
				catch(SQLException ex)
				{
				ex.printStackTrace();
				}
		 return false;
	 }
	 
	
	 
	 /**
	  * 
	  * @param aName
	  * @param aPassword
	  * @param aMoney
	  * @return
	  * @throws SQLException
	  */
	 
	 public synchronized static boolean addMoneyByName(String aName, String aPassword, int aMoney) throws SQLException {
		 		Statement statement = connection.createStatement();
			try{
				ResultSet res = statement.executeQuery("SELECT * FROM Bank WHERE name=\""+aName+"\" AND password =\""+aPassword+"\";");
				if(res.next())
				{
				int currMoney = res.getInt("money") + aMoney;
				 PreparedStatement st = connection.prepareStatement("UPDATE Bank SET money"
					 		+ " = ? WHERE name = ?");
				 st.setInt(1, currMoney);
				 st.setString(2, aName);
				 st.executeUpdate();
			 return true;
				}}
				catch(SQLException ex)
				{
				ex.printStackTrace();
				}
			return false;
	 }  
	 /**
	  * 
	  * @param aCardNumber
	  * @param aPassword
	  * @param aMoney
	  * @return
	  * @throws SQLException
	  */
	 
	 public synchronized static boolean addMoneyByCardNumber(int aCardNumber, String aPassword, int aMoney) throws SQLException {
		 Statement statement = connection.createStatement();
			try{
				ResultSet res = statement.executeQuery("SELECT * FROM Bank WHERE cardNumber=\""+aCardNumber+"\" AND password =\""+aPassword+"\";");
				if(res.next())
				{
				int currMoney = res.getInt("money") + aMoney;
				 PreparedStatement st = connection.prepareStatement("UPDATE Bank SET money"
					 		+ " = ? WHERE cardNumber = ?");
				 st.setInt(1, currMoney);
				 st.setInt(2, aCardNumber);
				 st.executeUpdate();
			 return true;
				}}
				catch(SQLException ex)
				{
				ex.printStackTrace();
				}
			return false;
	    }
	 
	
	
	 /**
	  * close client deposit in a bank
	  * @param id
	  * @param aClient
	  * @throws SQLException
	  */
	 
	public synchronized static boolean removeFromDatastoreByName(String nameSearch , String password) throws SQLException {
		Statement statement = connection.createStatement();
		try{
			ResultSet res = statement.executeQuery("SELECT * FROM Bank WHERE name=\""+nameSearch+"\" AND password =\""+password+"\";");
			if(res.next())
			{
				int money = res.getInt("money");
				int limit = res.getInt("moneyLimit");
				if(money > MAX_LIMIT || limit < money) return false;
				PreparedStatement st = connection.prepareStatement("DELETE FROM Bank WHERE name = ?");
				st.setString(1, nameSearch);
				st.executeUpdate();
				return true;
				}
			}
		catch(SQLException e){
            e.printStackTrace();
        }
		return false;
    }
	
	/**
	  * close client deposit in a bank
	  * @param id
	  * @param aClient
	  * @throws SQLException
	  */
	 
	public synchronized static boolean removeFromDatastoreByCardNumber(int aClientCardNumber , Client aClient) throws SQLException {
		PreparedStatement statement = null;
		int clientMoney = aClient.getMoneyOnBanlAccount();
		if (clientMoney <= MAX_LIMIT) {
   		statement = connection.prepareStatement("DELETE FROM Bank WHERE cardNumber = ?");
   		statement.setInt(1, aClientCardNumber);
   		statement.executeUpdate();
   		clientMoney = 0;
   		statement.close();
   		return true;
   	} 
		return false;
   }
	
	/**
	 * 
	 */
	
	private static void showAllClients(){
        try{
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM Bank");
            while (res.next()) {
                String name = res.getString("name");
            }
            res.close();
            st.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
	/**

	* Info about client if it exists and password is correct

	* @param nameSearch

	* @param pass

	* @return

	* @throws SQLException

	*/
	public synchronized static String getInfo(String nameSearch, String pass) throws SQLException
	{
		Statement statement = connection.createStatement();
		try{
			ResultSet res = statement.executeQuery("SELECT * FROM Bank WHERE name=\""+nameSearch+"\" AND password =\""+pass+"\";");
			if(res.next())
			{

				String date = new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime());
				String dateIn = res.getString("date");
				if(!date.equals(dateIn)) setNewLimit(nameSearch);
				String result =  "OKBAL"+res.getInt("money")+"LIM"+res.getInt("moneyLimit");
				statement.close();
				return result;
			}}
			catch(SQLException ex)
			{
			ex.printStackTrace();
			}
		return "F";
		}
	public synchronized static String getInfoATM(int cardNumber, String pass) throws SQLException
	{
		Statement statement = connection.createStatement();
		try{
			ResultSet res = statement.executeQuery("SELECT * FROM Bank WHERE cardNumber=\""+cardNumber+"\" AND password =\""+pass+"\";");
			if(res.next())
			{
				String date = new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime());
				String dateIn = res.getString("date");
				if(!date.equals(dateIn)) setNewLimit(res.getString("name"));
				String result =  "OKNM"+res.getString("name")+"BAL"+res.getInt("money")+"LIM"+res.getInt("moneyLimit");
				statement.close();
				return result;
			}}
			catch(SQLException ex)
			{
			ex.printStackTrace();
			}
		return "F";
		}
	 private static void setNewLimit(String nameSearch) {
			try{
				Statement statement = connection.createStatement();
				ResultSet res = statement.executeQuery("SELECT * FROM Bank WHERE name=\""+nameSearch+"\";");
				if(res.next())
				{
				 PreparedStatement st = connection.prepareStatement("UPDATE Bank SET moneyLimit = ?, date = ? WHERE name = ?");
				 st.setInt(1, MAX_LIMIT);
				 st.setString(2, new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime()));
				 st.setString(3, nameSearch);
				 st.executeUpdate();
				 statement.close();
				 st.close();
				}}
				catch(SQLException ex)
				{
				ex.printStackTrace();
				}
	}

	/**
	  * 
	  * @param password
	  * @return id or -1 if client wasn`t find
	  */
	  	 public static int findClient(String name)
	  	 {
	  		try
			 {
				 Statement st = connection.createStatement();
	             ResultSet res = st.executeQuery("SELECT * FROM Bank WHERE name=\""+name+"\";");
	             if(res.next()){
	            return res.getInt("id");	
	             }
			 }
			 catch(SQLException ex)
			 {
				 ex.printStackTrace();
			 }
	  		 return -1;
	  	 }

	 	public static int getNextCard()
		{
			currentCardNumber++;
			return currentCardNumber;
		}
		public static String currentCartNumber()
		{
			String current = String.valueOf(currentCardNumber);
			if(current.length()!=4)
			{
				if(current.length() == 1) current = "000"+current;
				else if (current.length() == 2) current = "00"+ current;
				else current = "0"+current;
			}
			return FIRPRTCARD+current;
		}
		private static void initilizeCardNumber()
		{
			try
			{
			Statement st = connection.createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM Bank");
			int size = 0;
			while(res.next()){
				size = res.getInt("cardNumber");
			}
			size++;
			currentCardNumber = size;
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		}
	
}
