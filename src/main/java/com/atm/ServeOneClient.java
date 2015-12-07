package com.atm;

import java.io.*;
import java.net.*;
import java.sql.SQLException;
/**
 * 
 * @author Oleh Kurpiak
 *
 */
public class ServeOneClient extends Thread{

	public ServeOneClient(Socket s) throws IOException{
		try{
		socket = s;
		inRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		outStr = new PrintWriter(socket.getOutputStream());
		}
		catch (IOException ex)
		{
			socket.close();
			ex.printStackTrace();
		}
		start();
	}
	
	public void run(){
		try{
		while(true)
		{
			String currentLine = inRead.readLine();
			if(currentLine!=null){
			if(currentLine.equals("END_OF_SESSION")){ 
				break;}
			if(currentLine.startsWith("Addclient")) addClient(currentLine);
			else if(currentLine.startsWith("ATMGetinfo")) getInfoATM(currentLine);
			else if(currentLine.startsWith("ATMWithdraw")) withdrawActionATM(currentLine);
			else if(currentLine.startsWith("Withdraw")) withdrawAction(currentLine);
			else if(currentLine.startsWith("Addmoney")) addMoney(currentLine);
			else if(currentLine.startsWith("Getinfo")) getInfo(currentLine);
			else if(currentLine.startsWith("Removeclient")) removeClient(currentLine);
			}
		}
		}
		catch(IOException ex)
		{
			System.err.println("IO Exception");
		}
		finally{
			try{
				socket.close();
			}
			catch(IOException e){
				System.err.println("Socket wasn`t closed");
			}
		}
	}
	private void withdrawActionATM(String command) {
		String card = command.substring(command.indexOf("CD")+2, command.indexOf("PASS"));
		String password = command.substring(command.indexOf("PASS")+3,command.indexOf("MINUS"));
		try{
			int cardNumber = Integer.valueOf(card);
			int add = Integer.valueOf(command.substring(command.indexOf("MINUS")+5));
			//withdraw money here
			if(BankService.withdrawByCard(cardNumber,password,add))
			outStr.println("RESPWithdrawRESOK");
			else outStr.println("RESPWithdrawRESF");
			outStr.flush();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private void getInfoATM(String command) {
		String card = command.substring(command.indexOf("CD")+2, command.indexOf("PASS"));
		String password = command.substring(command.indexOf("PASS")+3);
		try {
			int cardNumber = Integer.valueOf(card);
			outStr.println("RESPGetinfoRES"+BankService.getInfoATM(cardNumber, password));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		outStr.flush();
	}

	/**
	 * Server accepts "remove client" call
	 * @param command
	 */
	private void removeClient(String command) {
		String name = command.substring(command.indexOf("NM")+2, command.indexOf("PASS"));
		String password = command.substring(command.indexOf("PASS")+3);
		try {
			if(BankService.removeFromDatastoreByName(name, password))
			{	outStr.println("RESPRemoveclientRESOK");
			}
			else outStr.println("RESPRemoveclientRESF");
			outStr.flush();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Server accepts "get Info" call
	 * @param currentLine
	 */
	private void getInfo(String command) {
		String name = command.substring(command.indexOf("NM")+2, command.indexOf("PASS"));
		String password = command.substring(command.indexOf("PASS")+3);
		try {
			outStr.println("RESPGetinfoRES"+BankService.getInfo(name, password));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		outStr.flush();
	}

	/**
	 * Server accepts "add money" call
	 * @param currentLine
	 */
	private void addMoney(String command) {
		String name = command.substring(command.indexOf("NM")+2, command.indexOf("PASS"));
		String password = command.substring(command.indexOf("PASS")+3,command.indexOf("ADD"));
		try{
			int add = Integer.valueOf(command.substring(command.indexOf("ADD")+3));
     	if(BankService.addMoneyByName(name, password, add))
			outStr.println("RESPAddmoneyRESOK");
			else outStr.println("RESPAddmoneyRESF");
			outStr.flush();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	/**
	 * Method to do withdraw action
	 * @param currentLine
	 */
	private void withdrawAction(String command) {
		String name = command.substring(command.indexOf("NM")+2, command.indexOf("PASS"));
		String password = command.substring(command.indexOf("PASS")+3,command.indexOf("MINUS"));
		try{
			int add = Integer.valueOf(command.substring(command.indexOf("MINUS")+5));
			//withdraw money here
			if(BankService.withdrawByName(name,password,add))
			outStr.println("RESPWithdrawRESOK");
			else outStr.println("RESPWithdrawRESF");
			outStr.flush();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * Server accepts "add client" call
	 * @param command
	 */
	private void addClient(String command) {
		String name = command.substring(command.indexOf("NM")+2, command.indexOf("ID"));
		String id = command.substring(command.indexOf("ID")+2, command.indexOf("PASS"));
		String password = command.substring(command.indexOf("PASS")+3);
		int money = 0;
		// info about successful action
		String res = BankService.addClientToDatastore(new Client(name,id,password,money));
		if(res!=null)
			outStr.println("RESPAddclientRESOKCARD"+res);
		else outStr.println("RESPAddclientRESF");
		outStr.flush();
		}

	private Socket socket;
	private PrintWriter outStr;
	private BufferedReader inRead;
}
