package com.atm;

import static com.atm.ATMState.*;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.atm.ATMClient.BankAccess;
/**
 *
 * @author Ivan Polomani
 */
public class ATMPanel extends JPanel implements Observer {

	public ATMPanel(BankAccess access) {
		this.access = access;
		initComponents();
		setState(EXPECTING_CARD);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		keyboard1 = new javax.swing.JButton();
		keyboard8 = new javax.swing.JButton();
		keyboard5 = new javax.swing.JButton();
		keyboard6 = new javax.swing.JButton();
		keyboard2 = new javax.swing.JButton();
		keyboard3 = new javax.swing.JButton();
		keyboard9 = new javax.swing.JButton();
		keyboard4 = new javax.swing.JButton();
		keyboard0 = new javax.swing.JButton();
		keyboardCancel = new javax.swing.JButton();
		keyboard7 = new javax.swing.JButton();
		keyboardEnter = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jLayeredPane1 = new javax.swing.JLayeredPane();
		labelUserInput = new javax.swing.JLabel();
		labelMessage = new javax.swing.JLabel();
		enter1 = new javax.swing.JButton();
		enter2 = new javax.swing.JButton();
		enter3 = new javax.swing.JButton();
		enter4 = new javax.swing.JButton();
		enter5 = new javax.swing.JButton();
		enter6 = new javax.swing.JButton();

		keyboard1.setFont(new java.awt.Font("Dialog", 1, 14));
		keyboard1.setText("1");
		keyboard1.setToolTipText("");
		keyboard1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				keyboard1ActionPerformed(evt);
			}
		});

		keyboard8.setFont(new java.awt.Font("Dialog", 1, 14));
		keyboard8.setText("8");
		keyboard8.setToolTipText("");
		keyboard8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				keyboard8ActionPerformed(evt);
			}
		});

		keyboard5.setFont(new java.awt.Font("Dialog", 1, 14));
		keyboard5.setText("5");
		keyboard5.setToolTipText("");
		keyboard5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				keyboard5ActionPerformed(evt);
			}
		});

		keyboard6.setFont(new java.awt.Font("Dialog", 1, 14));
		keyboard6.setText("6");
		keyboard6.setToolTipText("");
		keyboard6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				keyboard6ActionPerformed(evt);
			}
		});

		keyboard2.setFont(new java.awt.Font("Dialog", 1, 14));
		keyboard2.setText("2");
		keyboard2.setToolTipText("");
		keyboard2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				keyboard2ActionPerformed(evt);
			}
		});

		keyboard3.setFont(new java.awt.Font("Dialog", 1, 14));
		keyboard3.setText("3");
		keyboard3.setToolTipText("");
		keyboard3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				keyboard3ActionPerformed(evt);
			}
		});

		keyboard9.setFont(new java.awt.Font("Dialog", 1, 14));
		keyboard9.setText("9");
		keyboard9.setToolTipText("");
		keyboard9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				keyboard9ActionPerformed(evt);
			}
		});

		keyboard4.setFont(new java.awt.Font("Dialog", 1, 14));
		keyboard4.setText("4");
		keyboard4.setToolTipText("");
		keyboard4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				keyboard4ActionPerformed(evt);
			}
		});

		keyboard0.setFont(new java.awt.Font("Dialog", 1, 14));
		keyboard0.setText("0");
		keyboard0.setToolTipText("");
		keyboard0.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				keyboard0ActionPerformed(evt);
			}
		});

		keyboardCancel.setFont(new java.awt.Font("Dialog", 1, 12));
		keyboardCancel.setText("C");
		keyboardCancel.setToolTipText("");
		keyboardCancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				keyboardCancelActionPerformed(evt);
			}
		});

		keyboard7.setFont(new java.awt.Font("Dialog", 1, 14));
		keyboard7.setText("7");
		keyboard7.setToolTipText("");
		keyboard7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				keyboard7ActionPerformed(evt);
			}
		});

		keyboardEnter.setFont(new java.awt.Font("Dialog", 1, 14));
		keyboardEnter.setText(">");
		keyboardEnter.setToolTipText("");
		keyboardEnter.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				keyboardEnterActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																		.addGroup(
																				jPanel1Layout
																						.createSequentialGroup()
																						.addComponent(
																								keyboard4,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								40,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(
																								keyboard5,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								40,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(
																								keyboard6,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								40,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGroup(
																				jPanel1Layout
																						.createSequentialGroup()
																						.addComponent(
																								keyboard1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								40,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(
																								keyboard2,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								40,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(
																								keyboard3,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								40,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				keyboard7,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				40,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				keyboard8,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				40,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				keyboard9,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				40,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				keyboardEnter,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				40,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				keyboard0,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				40,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				keyboardCancel,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				40,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																keyboard1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																40,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																keyboard2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																40,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																keyboard3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																40,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																keyboard4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																40,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																keyboard5,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																40,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																keyboard6,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																40,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																keyboard7,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																40,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																keyboard8,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																40,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																keyboard9,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																40,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																keyboardEnter,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																40,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																keyboard0,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																40,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																keyboardCancel,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																40,
																javax.swing.GroupLayout.PREFERRED_SIZE))));

		jPanel2.setBackground(new java.awt.Color(-4929076, true));

		labelUserInput
				.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		labelUserInput.setText("0000");
		labelUserInput.setPreferredSize(null);
		labelUserInput.setBounds(0, 100, 180, 14);
		jLayeredPane1.add(labelUserInput,
				javax.swing.JLayeredPane.DEFAULT_LAYER);

		labelMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		labelMessage
				.setText("<html>Enter your card number<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>and press this button -></html>");
		labelMessage.setToolTipText("");
		labelMessage.setVerticalAlignment(javax.swing.SwingConstants.TOP);
		labelMessage.setBounds(6, 10, 180, 180);
		jLayeredPane1.add(labelMessage, javax.swing.JLayeredPane.DEFAULT_LAYER);
		labelMessage.getAccessibleContext().setAccessibleName("");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 186,
				Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 199,
				Short.MAX_VALUE));

		enter1.setFont(new java.awt.Font("Dialog", 1, 14));
		enter1.setText(">");
		enter1.setToolTipText("");
		enter1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				enter1ActionPerformed(evt);
			}
		});

		enter2.setFont(new java.awt.Font("Dialog", 1, 14));
		enter2.setText(">");
		enter2.setToolTipText("");
		enter2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				enter2ActionPerformed(evt);
			}
		});

		enter3.setFont(new java.awt.Font("Dialog", 1, 14));
		enter3.setText(">");
		enter3.setToolTipText("");
		enter3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				enter3ActionPerformed(evt);
			}
		});

		enter4.setFont(new java.awt.Font("Dialog", 1, 14));
		enter4.setText("<");
		enter4.setToolTipText("");
		enter4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				enter4ActionPerformed(evt);
			}
		});

		enter5.setFont(new java.awt.Font("Dialog", 1, 14));
		enter5.setText("<");
		enter5.setToolTipText("");
		enter5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				enter5ActionPerformed(evt);
			}
		});

		enter6.setFont(new java.awt.Font("Dialog", 1, 14));
		enter6.setText("<");
		enter6.setToolTipText("");
		enter6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				enter6ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						enter1,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						40,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						enter2,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						40,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						enter3,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						40,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jPanel2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(6, 6, 6)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						enter4,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						40,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						enter5,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						40,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(
																						enter6,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						40,
																						javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(83, 83,
																		83)
																.addComponent(
																		jPanel1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		133,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		enter4,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		40,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		enter5,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		40,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		enter6,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		40,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		enter1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		40,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		enter2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		40,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		enter3,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		40,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(
														jPanel2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)));
	}// </editor-fold>

	private void setState(ATMState state) {
		this.state = state;
		switch (state) {
		case EXPECTING_CARD:
			labelMessage.setText("<html>Enter your card number"
					+ "<br/><br/><br/><br/><br/>"
					+ "<br/><br/><br/><br/><br/>and press this button -></html>");
			labelUserInput.setText("");
			break;
		case EXPECTING_PASS:
			pass="";
			labelMessage.setText("<html>Please enter your pin-code"
					+ "<br/><br/><br/><br/><br/>"
					+ "<br/><br/><br/><br/><br/>and press this button -></html>");
			labelUserInput.setText("");
			break;
		case USER_MENU:
			labelMessage.setText("<html><center>Choose action</center><br/><br/><br/><br/><br/><br/> "
					+ "<font color='#B4C9CC'>......................</font> "
					+ "see balance<br/><br/><br/><font color='#B4C9CC'>"
					+ ".................</font>withdraw money</html>");
			labelUserInput.setText("");
			break;
		case USER_BALANCE:
			labelMessage.setText("");
			break;
		case AMOUNT_MONEY_WITHDRAW:
			labelMessage.setText("<html><br/>Please enter amount to withdraw<br/>"
					+ "(multiple of 50)<br/><br/><br/>"
					+ "<br/><br/><br/><br/><br/><font color='#B4C9CC'>...........</font>"
					+ "and press this button -></html>");
			labelUserInput.setText("");
			break;
		case SUCCESS:
			labelMessage.setText("<html><br/><br/><br/>Operation is successful<br/><br/><br/><br/><br/><br/><br/>back</html>");
			labelUserInput.setText("");
			break;
		case CREDITS_INCORRECT:
		case LOGIN_INCORRECT:
			labelMessage.setText("<html><br/><br/><br/>Something went wrong<br/><br/><br/><br/><br/><br/><br/>back</html>");
			labelUserInput.setText("");
			break;
		}
	}
	
	private void keyboard1ActionPerformed(java.awt.event.ActionEvent evt) {
		int key=1;
		pressNumKeyBoard(key);
	}
	
	private void pressNumKeyBoard(int key) {
		switch(state) {
		case EXPECTING_CARD:
			labelUserInput.setText(labelUserInput.getText()+key);
			break;
		case EXPECTING_PASS:
			labelUserInput.setText(labelUserInput.getText()+"*");
			pass+=key;
			break;
		case AMOUNT_MONEY_WITHDRAW:
			labelUserInput.setText(labelUserInput.getText()+key);
			break;
		}	
	}

	private void keyboard3ActionPerformed(java.awt.event.ActionEvent evt) {
		int key=3;
		pressNumKeyBoard(key);
	}

	private void keyboard2ActionPerformed(java.awt.event.ActionEvent evt) {
		int key=2;
		pressNumKeyBoard(key);
	}

	private void keyboard6ActionPerformed(java.awt.event.ActionEvent evt) {
		int key=6;
		pressNumKeyBoard(key);
	}

	private void keyboard5ActionPerformed(java.awt.event.ActionEvent evt) {
		int key=5;
		pressNumKeyBoard(key);
	}

	private void keyboard4ActionPerformed(java.awt.event.ActionEvent evt) {
		int key=4;
		pressNumKeyBoard(key);
	}

	private void keyboard9ActionPerformed(java.awt.event.ActionEvent evt) {
		int key=9;
		pressNumKeyBoard(key);
	}

	private void keyboard8ActionPerformed(java.awt.event.ActionEvent evt) {
		int key=8;
		pressNumKeyBoard(key);
	}

	private void keyboard7ActionPerformed(java.awt.event.ActionEvent evt) {
		int key=7;
		pressNumKeyBoard(key);
	}

	private void keyboardEnterActionPerformed(java.awt.event.ActionEvent evt) {
			
	}

	private void keyboard0ActionPerformed(java.awt.event.ActionEvent evt) {
		int key=0;
		pressNumKeyBoard(key);
	}

	private void keyboardCancelActionPerformed(java.awt.event.ActionEvent evt) {
		switch(state) {
		case EXPECTING_CARD:
		case AMOUNT_MONEY_WITHDRAW:
			labelUserInput.setText("");
			break;
		case EXPECTING_PASS:
			labelUserInput.setText("");
			pass="";
		}	
	}

	private void enter1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void enter2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void enter3ActionPerformed(java.awt.event.ActionEvent evt) {
		switch(state) {
		case USER_BALANCE:
			setState(USER_MENU);
			break;
		case SUCCESS:
		case LOGIN_INCORRECT:
			setState(EXPECTING_CARD);
			break;
		case CREDITS_INCORRECT:
			setState(USER_MENU);
			break;
		}
	}

	private void enter4ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void enter5ActionPerformed(java.awt.event.ActionEvent evt) {
		switch(state) {
		case USER_MENU:
			access.getInfo(cardN, pass);
			setState(USER_BALANCE);
			break;
		}
	}

	private void enter6ActionPerformed(java.awt.event.ActionEvent evt) {
		switch(state) {
		case EXPECTING_CARD:
			cardN = Integer.valueOf(labelUserInput.getText());
			setState(EXPECTING_PASS);
			break;
		case EXPECTING_PASS:
			access.getInfo(cardN, pass);
			break;
		case USER_MENU:
			setState(AMOUNT_MONEY_WITHDRAW);
			break;
		case AMOUNT_MONEY_WITHDRAW:
			int amount = Integer.valueOf(labelUserInput.getText());
			if(amount%50==0) {
				access.withdrawMoney(cardN, pass, amount);
			} else {
				setState(CREDITS_INCORRECT);
				labelMessage.setText("<html><br/><br/><br/>Incorrect amount<br/><br/><br/><br/><br/><br/><br/>back</html>");
				labelUserInput.setText("");
			}
		}
	}

	private BankAccess access;
	private int cardN;
	private String pass;
	private ATMState state;
	private javax.swing.JButton enter1;
	private javax.swing.JButton enter2;
	private javax.swing.JButton enter3;
	private javax.swing.JButton enter4;
	private javax.swing.JButton enter5;
	private javax.swing.JButton enter6;
	private javax.swing.JLayeredPane jLayeredPane1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JButton keyboard0;
	private javax.swing.JButton keyboard1;
	private javax.swing.JButton keyboard2;
	private javax.swing.JButton keyboard3;
	private javax.swing.JButton keyboard4;
	private javax.swing.JButton keyboard5;
	private javax.swing.JButton keyboard6;
	private javax.swing.JButton keyboard7;
	private javax.swing.JButton keyboard8;
	private javax.swing.JButton keyboard9;
	private javax.swing.JButton keyboardCancel;
	private javax.swing.JButton keyboardEnter;
	private javax.swing.JLabel labelMessage;
	private javax.swing.JLabel labelUserInput;
	// End of variables declaration
	@Override
	public void update(Observable o, Object arg) {
		final String args = arg.toString();
		if(args.startsWith("RESPGetinfo"))
		{
			if(args.contains("OK"))
			{
				switch(state) {
				case EXPECTING_PASS:
					setState(USER_MENU);
					break;
				case USER_BALANCE:
					labelMessage.setText("<html><br/><br/><br/><br/>"
							+ "You have "+args.substring(args.indexOf("BAL")+3, args.indexOf("LIM"))+"UAH"
							+ "<br/>Your daily limit is "+args.substring(args.indexOf("LIM")+3)+"UAH"
									+ "<br/><br/><br/><br/><br/>back</html>");
					break;
				}
			}
			else
			{
				switch(state) {
				case EXPECTING_PASS:
					setState(LOGIN_INCORRECT);
				}
			}
		}
		else if(args.startsWith("RESPWithdraw"))
		{
			if(args.contains("OK"))
			{
				setState(SUCCESS);
			}
			else if(args.contains("F"))
			{
				setState(CREDITS_INCORRECT);
			}
		}
		
	}
}
