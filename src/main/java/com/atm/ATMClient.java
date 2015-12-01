package com.atm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;

import javax.swing.*;

/**
 * ATM client for BankManager
 * @author Stacy
 *
 */
public class ATMClient {
	
	static class BankAccess extends Observable
	{
		private static final Logger LOG = Logger.getLogger(BankAccess.class.getName());
		public BankAccess(InetAddress addr, int port)
		{
			try {
		         socket = new Socket(addr,port); 
		         os = new PrintStream(socket.getOutputStream());
		         in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		         
		         Thread receivingThread = new Thread(){
		        	 @Override
		        	 public void run()
		        	 {
		        		 try
		        		 {
		        			 String line;
		        			 while((line = in.readLine()) != null){
		        				 notifyObservers(line);
		        			 }

		        		 }
		        		 catch(IOException ex)
		        		 {
		        			 try {
			      		            socket.close();
			      		         }
			      		         catch (IOException e2) {
			      		            LOG.warning("Socket wasn`t closed");
			      		         }
		        		 }
		        	 }
		         };
		         receivingThread.start();
		         }
		      catch (IOException e) {
		         try {
		            socket.close();
		         }
		         catch (IOException e2) {
		            LOG.warning("Socket wasn`t closed");
		         }
		      }
		}
		
		@Override
		public void notifyObservers(Object arg)
		{
			super.setChanged();
			super.notifyObservers(arg);
		}
		public void getInfo(int cardNumber, String password)
		{
			String pass = EncryptPassword.encrypt(password);
			send("ATMGetinfo"+"CD"+cardNumber+ "PASS"+pass);
		}
		public void withdrawMoney(int cardNumber, String password,int withdraw)
		{
			String pass = EncryptPassword.encrypt(password);
			send("ATMWithdraw"+"CD"+cardNumber+ "PASS"+pass+"MINUS"+withdraw);
		}

		public void stopCommunication()
		{
			os.println("END_OF_SESSION");
			os.flush();
			try {
				socket.close();
			}
			catch (IOException e) {
				LOG.warning("Socket wasn`t closed");
			}
		}
		/**
		 * Send command to server and get it response
		 * @param command
		 */
		public void send(String command)
		{
			os.println(command);
			os.flush();
		}
		
		private BufferedReader in;
		private Socket socket;
		private PrintStream os;
	}

	static class ATM extends JFrame implements Observer {

	    /**
	     * Creates new form ATM
	     */
	    public ATM(BankAccess bank) {
	    	this.access = bank;
	    	this.access.addObserver(this);
	        initComponents();
	        jTabbedPane1.remove(Info);
	        
	    }

	    /**
	     * This method is called from within the constructor to initialize the form.
	     * WARNING: Do NOT modify this code. The content of this method is always
	     * regenerated by the Form Editor.
	     */
	    @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	    private void initComponents() {

	        jLabel1 = new JLabel();
	        jTabbedPane1 = new JTabbedPane();
	        Gate = new JPanel();
	        jLabel2 = new JLabel();
	        jLabel3 = new JLabel();
	        cardNumberField = new JTextField();
	        passwordField = new JPasswordField();
	        okButton = new JButton();
	        cancelButton = new JButton();
	        Info = new JPanel();
	        hiText = new JLabel();
	        jLabel5 = new JLabel();
	        jLabel6 = new JLabel();
	        balanceText = new JLabel();
	        limitText = new JLabel();
	        performButton = new JButton();
	        endButton = new JButton();
	        jLabel9 = new JLabel();
	        withdrawField = new JTextField();
	        jMenuBar1 = new JMenuBar();
	        jMenu1 = new JMenu();
	        jMenuItem1 = new JMenuItem();

	        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	        jLabel1.setFont(new java.awt.Font("Papyrus", 2, 18)); // NOI18N
	        jLabel1.setText("ATM");

	        Gate.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

	        jLabel2.setText("Card number");

	        jLabel3.setText("Password");

	        okButton.setText("OK");
	        okButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                okButtonActionPerformed(evt);
	            }
	        });

	        cancelButton.setText("Cancel");
	        cancelButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                cancelButtonActionPerformed(evt);
	            }
	        });

	        GroupLayout GateLayout = new GroupLayout(Gate);
	        Gate.setLayout(GateLayout);
	        GateLayout.setHorizontalGroup(
	            GateLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(GateLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(GateLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(GateLayout.createSequentialGroup()
	                        .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
	                        .addGap(42, 42, 42)
	                        .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
	                    .addGroup(GateLayout.createSequentialGroup()
	                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(cardNumberField))
	                    .addGroup(GroupLayout.Alignment.TRAILING, GateLayout.createSequentialGroup()
	                        .addGap(0, 0, Short.MAX_VALUE)
	                        .addGroup(GateLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
	                            .addComponent(cancelButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                            .addComponent(okButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
	                .addContainerGap())
	        );
	        GateLayout.setVerticalGroup(
	            GateLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(GateLayout.createSequentialGroup()
	                .addGap(45, 45, 45)
	                .addGroup(GateLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(cardNumberField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(GateLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
	                .addGap(27, 27, 27)
	                .addComponent(okButton)
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(cancelButton)
	                .addContainerGap(107, Short.MAX_VALUE))
	        );

	        jTabbedPane1.addTab("Bank name", Gate);

	        Info.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

	        hiText.setText("Hi, Your name !");

	        jLabel5.setText("Limit");

	        jLabel6.setText("Balance");

	        balanceText.setText("1,000,000");

	        limitText.setText("150,000");

	        performButton.setText("Perform");
	        performButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                performButtonActionPerformed(evt);
	            }
	        });

	        endButton.setText("End");
	        endButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                endButtonActionPerformed(evt);
	            }
	        });
	        

	        jLabel9.setText("Withdraw");

	        GroupLayout InfoLayout = new GroupLayout(Info);
	        Info.setLayout(InfoLayout);
	        InfoLayout.setHorizontalGroup(
	            InfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(GroupLayout.Alignment.TRAILING, InfoLayout.createSequentialGroup()
	                .addGap(0, 0, Short.MAX_VALUE)
	                .addComponent(performButton))
	            .addGroup(InfoLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(InfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(InfoLayout.createSequentialGroup()
	                        .addGap(9, 9, 9)
	                        .addGroup(InfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addGroup(InfoLayout.createSequentialGroup()
	                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(balanceText, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
	                                .addGap(0, 40, Short.MAX_VALUE))
	                            .addGroup(InfoLayout.createSequentialGroup()
	                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(limitText, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                            .addGroup(InfoLayout.createSequentialGroup()
	                                .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                                .addComponent(withdrawField))))
	                    .addGroup(InfoLayout.createSequentialGroup()
	                        .addGroup(InfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addComponent(hiText, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
	                            .addComponent(endButton))
	                        .addGap(0, 0, Short.MAX_VALUE)))
	                .addContainerGap())
	        );
	        InfoLayout.setVerticalGroup(
	            InfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(InfoLayout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(hiText, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
	                .addGap(24, 24, 24)
	                .addGroup(InfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(balanceText))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(InfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(limitText))
	                .addGap(44, 44, 44)
	                .addGroup(InfoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(withdrawField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addComponent(performButton)
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
	                .addComponent(endButton)
	                .addContainerGap())
	        );

	        jTabbedPane1.addTab("BankName", Info);

	        jMenu1.setText("Action");

	        jMenuItem1.setText("Exit");
	        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jMenuItem1ActionPerformed(evt);
	            }
	        });
	        jMenu1.add(jMenuItem1);

	        jMenuBar1.add(jMenu1);

	        setJMenuBar(jMenuBar1);

	        GroupLayout layout = new GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(20, 20, 20)
	                .addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
	                .addGap(55, 55, 55))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(jTabbedPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	        pack();
	    }// </editor-fold>                        

	    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
	       String card = cardNumberField.getText();
	       String pass = passwordField.getText();
	       cardNumberField.setText("");
	       passwordField.setText("");
	       if(card.equals("")||pass.equals("")) return;
	       try
	       {
	    	   int cardNumber = Integer.valueOf(card);
	    	   access.getInfo(cardNumber, pass);
	    	   this.card = cardNumber;
	    	   this.password = pass;
	       }
	       catch(Exception e)
	       {
	    	   JOptionPane.showMessageDialog(null, "Field card number must contain only numbers");
	       }
	     
	    }                                        

	    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
	       cardNumberField.setText("");
	       passwordField.setText("");
	    }                                            

	    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
	    	access.stopCommunication();
	    	dispose();
	    }                                          

	    private void performButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
	    	try
			{
				int moneySum = Integer.valueOf(withdrawField.getText());
				withdrawField.setText("");
				if(moneySum == 0) return;
				access.withdrawMoney(card, password, moneySum);
				access.getInfo(card, password);
			}
			catch(Exception ex)
			{
				 JOptionPane.showMessageDialog(null, "Field must contain only numbers");
			}	
			
	    }                                             

	    private void endButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
	    	password ="";
	    	card = -1;
	    	jTabbedPane1.remove(Info);
	    	jTabbedPane1.add("Bank name",Gate);
	    }                                         


	    // Variables declaration - do not modify   
	    private String password;
	    private int card;
	    private BankAccess access;
	    private JPanel Gate;
	    private JPanel Info;
	    private JLabel balanceText;
	    private JButton cancelButton;
	    private JTextField cardNumberField;
	    private JButton endButton;
	    private JLabel hiText;
	    private JLabel jLabel1;
	    private JLabel jLabel2;
	    private JLabel jLabel3;
	    private JLabel jLabel5;
	    private JLabel jLabel6;
	    private JLabel jLabel9;
	    private JMenu jMenu1;
	    private JMenuBar jMenuBar1;
	    private JMenuItem jMenuItem1;
	    private JTabbedPane jTabbedPane1;
	    private JLabel limitText;
	    private JButton okButton;
	    private JPasswordField passwordField;
	    private JButton performButton;
	    private JTextField withdrawField;
	    // End of variables declaration                   
		@Override
		public void update(Observable o, Object arg) {
			final String args = arg.toString();
			if(args.startsWith("RESPGetinfo"))
			{
				if(args.contains("OK"))
				{
					hiText.setText("Hi, "+args.substring(args.indexOf("NM")+2,args.indexOf("BAL"))+"!");
					balanceText.setText(args.substring(args.indexOf("BAL")+3, args.indexOf("LIM")));
					limitText.setText(args.substring(args.indexOf("LIM")+3));
					jTabbedPane1.add("Your account", Info);
					jTabbedPane1.remove(Gate);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Something went wrong\n"
							+ "Possible reasons:\n"
							+ "- No such a client into database\n"
							+ "- Wrong password");
				}
			}
			else if(args.startsWith("RESPWithdraw"))
			{
				if(args.contains("OK"))
				{
					JOptionPane.showMessageDialog(null, "Money was withdrawed from your account");
					
				}
				else if(args.contains("F"))
				{
					JOptionPane.showMessageDialog(null, "Problems occured while withdrawing money from client account \n"
							+ "Possible reasons:\n"
							+ "- Client is absent in database\n"
							+ "- Wrong password\n"
							+ "- You can`t exceed limit of 150,000");
				}
			}
			
		}
	}
	public static void startBankAccess(InetAddress addr, int port)
	{
		final int fport = port;
		final BankAccess  access = new BankAccess(addr, port);
		 java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
		JFrame frame = new ATM(access);
		frame.setTitle("Connected to BankManager at port: "+fport);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	            }
		 });
	}

}
