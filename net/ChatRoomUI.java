package net;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.text.*;
import java.util.*;

public class ChatRoomUI {

	private String desIp;
	private int desPort;

	private Frame mainFrame = new Frame("ChatRoom");
	
	private MenuBar menu = new MenuBar();
	private Menu connection = new Menu("Connection");
	private MenuItem connect = new MenuItem("Connect");
	private MenuItem disconnect = new MenuItem("Disconnect");
	private MenuItem exit = new MenuItem("Exit");
	
	private TextArea chatArea = new TextArea(25, 80);
	private TextArea connectInfoArea = new TextArea(25, 40);
	private TextField inputField = new TextField(116);
	private Button enter = new Button("Enter");
	StringBuilder chatData =  new StringBuilder();

	
	private Dialog connectDialog = new Dialog(mainFrame, "Connect", true);
	private Dialog disconnectDialog = new Dialog(mainFrame, "Disconnect", true);
	private Dialog connectWarning = new Dialog(connectDialog, "Warning", true);
	private StringBuilder connectInfoLog = new StringBuilder();
	
	private Label srcPortLabel = new Label("My Port: ");
	private Label desIpLabel = new Label("Call IP address: ");
	private Label desPortLabel = new Label("Call Port: ");

	private TextField srcPortField = new TextField(40);
	private TextField desIpField = new TextField(40);
	private TextField desPortField = new TextField(40);

	private Button connectButton = new Button("Connect");
	private Button cancelButton = new Button("Cancel");
	
	private Button closeConnectWarningButton = new Button("Close");
	private Label connectWarningLabel = new Label(
			"Please enter the right destination IP address and Port");
	
	private String localName;
	private String localIp4Address;
	private int localPort;
	private String data;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	ChatRoomUI() {
		mainFrameInit();
		menuInit();
		chatAreaInit();
		connectInfoInit();
		inputFieldInit();
		enterButtonInit();
		connectDialogInit();
		connectButtonInit();
		cancelButtonInit();
		connectWarningInit();
		closeConnectWarningButtonInit();
		disconnecDialogInit();
	}

	private void mainFrameInit() {
		/*
		 * Main frame Settings
		 */
		mainFrame.setBounds(500, 250, 1000, 500);
		mainFrame.setLayout(new FlowLayout());
		mainFrame.setMenuBar(menu);
		
		mainFrame.add(chatArea);
		mainFrame.add(connectInfoArea);
		mainFrame.add(inputField);
		mainFrame.add(enter);
		
		try {
			localName = PersonnelInfo.getLocalName();
			localIp4Address = PersonnelInfo.getLocalIp4Address();
		} catch (UnknownHostException e1) {
			showThreadInfo(e1);
		}
		
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				inputField.requestFocus();
				connectInfoLog.append(sdf.format(new Date()) +
						"\nLocal host name is: "+ localName +
						"\nLocal host IP4 Address is: "+ localIp4Address +
						"\n");
				connectInfoArea.setText(connectInfoLog.toString());
			}
			
			public void windowActivated(WindowEvent e) {
				inputField.requestFocus();
			}
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		mainFrame.setVisible(true);
	}
	
	private void menuInit() {
		menu.add(connection);
		connection.add(connect);
		connection.add(disconnect);
		connection.add(exit);

		connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connectDialog.setVisible(true);
			}
		});

		disconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disconnectDialog.setVisible(true);
			}
		});
		
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void chatAreaInit() {
		chatArea.setEditable(false);
	}
	
	private void connectInfoInit() {
		connectInfoArea.setEditable(false);
	}
	
	private void inputFieldInit() {
	}
	
	private void enterButtonInit() {
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data = inputField.getText();
				if(!(data.equals(null) || data.isEmpty())) {
					chatData.append(sdf.format(new Date()) +
							"\nSend: "+ data +
							"\n\n");
					chatArea.setText(chatData.toString());
					inputField.setText("");
				}
			}
		});
	}
	
	
	
	private void connectDialogInit() {
		connectDialog.setBounds(825, 375, 350, 250);
		connectDialog.setLayout(new FlowLayout());
		
		connectDialog.add(srcPortLabel);
		connectDialog.add(srcPortField);		
		connectDialog.add(desIpLabel);
		connectDialog.add(desIpField);
		connectDialog.add(desPortLabel);
		connectDialog.add(desPortField);
		connectDialog.add(connectButton);
		connectDialog.add(cancelButton);

		connectDialog.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				connectDialog.setVisible(false);
			}
		});
	}
	
	private void cancelButtonInit() {
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desIpField.getText();
				desIpField.setText("");
				srcPortField.getText();
				srcPortField.setText("");
				desPortField.getText();
				desPortField.setText("");
				connectDialog.setVisible(false);
			}
		});
	}
	
	private void connectButtonInit() {
		connectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (srcPortField.getText().isEmpty() ||
						desIpField.getText().isEmpty() || 
						desPortField.getText().isEmpty()) {
					connectInfoLog.append("\n"+ sdf.format(new Date()) +
							"\nWrong destination IP address or Port"+
							"\n");
					connectInfoArea.setText(connectInfoLog.toString());
					connectWarning.setVisible(true);
				} else {
					localPort = Integer.parseInt(srcPortField.getText());
					desIp = desIpField.getText();
					desPort = Integer.parseInt(desPortField.getText());
					connectInfoLog.append("\n"+ sdf.format(new Date()) +
							"\nMy port is: "+ localPort +
							"\nDestination IP address: "+ desIp +
							"\nDestination Port: "+ desPort +
							"\nStatus: Connected" +
							"\n");
					connectInfoArea.setText(connectInfoLog.toString());
					connectDialog.setVisible(false);
				}
				srcPortField.setText("");
				desIpField.setText("");
				desPortField.setText("");
			}
		});
	}
	
	private void connectWarningInit() {
		connectWarning.setBounds(825, 450, 350, 120);
		connectWarning.setLayout(new FlowLayout());
		connectWarning.add(connectWarningLabel);
		connectWarning.add(closeConnectWarningButton);
		
		connectWarning.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				desIpField.setText("");
				desPortField.setText("");
				connectWarning.setVisible(false);
			}
		});
	}
	
	private void closeConnectWarningButtonInit() {
		closeConnectWarningButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connectWarning.setVisible(false);
			}
		});
	}
	
	private void disconnecDialogInit() {
		disconnectDialog.setBounds(825, 450, 250, 120);
		disconnectDialog.setLayout(new FlowLayout());
		
		Button disconnectDialogConfirm = new Button("Confirm");
		Button disconnectDialogCancel = new Button("Cancel");
		Label disconnectDialogLabel = new Label(
				"Do you want to interrupt connection?");
		
		disconnectDialog.add(disconnectDialogLabel);
		disconnectDialog.add(disconnectDialogConfirm);
		disconnectDialog.add(disconnectDialogCancel);

		disconnectDialog.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				disconnectDialog.setVisible(false);
			}
		});
		
		disconnectDialogConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connectInfoLog.append("\n"+ sdf.format(new Date()) +
						"\nDisconnected from "+ desIp +
						"\n");
				connectInfoArea.setText(connectInfoLog.toString());
				disconnectDialog.setVisible(false);
			}
		});
		disconnectDialogCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disconnectDialog.setVisible(false);
			}
		});
	}

	private void showThreadInfo(Exception e) {
		connectInfoLog.append(sdf.format(new Date()) +
				"\n"+ e.getMessage() +
				"\n");
		connectInfoArea.setText(connectInfoLog.toString());
	}
	
	public static void main(String[] args) {
		new ChatRoomUI();
	}
}
