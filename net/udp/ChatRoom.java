package net.udp;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;
import java.text.*;
import java.util.*;

public class ChatRoom {
	private static final LayoutManager FLOWLAYOUT = new FlowLayout();

	private String localName;
	private String localIp;
	private int localPort;
	@SuppressWarnings("unused")
	private String desName;
	private String desIp;
	private int desPort;
	private String data;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private boolean connect = false;
	
	private Frame mainFrame = new Frame("ChatRoom");
	private MenuBar menu = new MenuBar();
	private TextArea chatArea = new TextArea(25, 80);
	private TextArea connectInfoArea = new TextArea(25, 40);
	private TextField inputField = new TextField(116);
	private Button inputButton = new Button("Enter");
	
	private Dialog connectDialog = new Dialog(mainFrame, "Connect", true);
	private Button closeWarningButton = new Button("Close");

	private Dialog disconnectDialog = new Dialog(mainFrame, "Disconnect", true);
	private Button disconnectDialogConfirm = new Button("Confirm");
	private Button disconnectDialogCancel = new Button("Cancel");
	
	private TextField srcPortField = new TextField(40);
	private TextField desIpField = new TextField(40);
	private TextField desPortField = new TextField(40);
	private Button connectButton = new Button("Connect");
	private Button cancelButton = new Button("Cancel");
	private Dialog wrongInputWarning = new Dialog(connectDialog, "Warning", true);
	
	private Send sendData = new Send();
	private ReceShowData receShowData = new ReceShowData();
	private Thread threadSend;
	private Thread threadRece;
	
	private void init() {
		mainFrame.setBounds(500, 250, 1000, 500);
		mainFrame.setLayout(FLOWLAYOUT);
		mainFrame.setMenuBar(menu);

		mainFrame.add(chatArea);
		mainFrame.add(connectInfoArea);
		mainFrame.add(inputField);
		mainFrame.add(inputButton);
		
		try {
			localName = PersonnelInfo.getLocalName();
			localIp = PersonnelInfo.getLocalIp();
		} catch (UnknownHostException e1) {
			showThreadInfo(e1);
		}
		
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				inputField.requestFocus();
				connectInfoArea.append("WELCOME TO CHATROOM"+
						"\n\n"+ sdf.format(new Date()) +
						"\nLocal host name is: "+ localName +
						"\nLocal host IP4 Address is: "+ localIp +
						"\nPlease connect!" +
						"\n");
			}
			
			public void windowActivated(WindowEvent e) {
				inputField.requestFocus();
			}
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		mainFrame.setVisible(true);
		
		menuInit();
		chatAreaInit();
		connectInfoInit();
		inputFieldInit();
		enterButtonInit();
	}


	private void menuInit() {
		Menu connection = new Menu("Connection");
		MenuItem connect = new MenuItem("Connect");
		MenuItem disconnect = new MenuItem("Disconnect");
		MenuItem exit = new MenuItem("Exit");
		
		
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
		
		connectDialogInit();
		disconnecDialogInit();
	}

	
	private void connectDialogInit() {
		Label srcPortLabel = new Label("My Port: ");
		Label desIpLabel = new Label("Call IP address: ");
		Label desPortLabel = new Label("Call Port: ");
		
		connectDialog.setBounds(825, 375, 350, 250);
		connectDialog.setLayout(FLOWLAYOUT);
		
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
		connectButtonInit();
		cancelButtonInit();
		wrongInputWarningInit();
	}

	private void connectButtonInit() {
		connectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!connect) {
					if (srcPortField.getText().isEmpty() ||
							desIpField.getText().isEmpty() || 
							desPortField.getText().isEmpty()) {
						connectInfoArea.append("\n"+ sdf.format(new Date()) +
								"\nWrong destination IP address or Port"+
								"\n");
						wrongInputWarning.setVisible(true);
					} else {
						localPort = Integer.parseInt(srcPortField.getText());
						desIp = desIpField.getText();
						desPort = Integer.parseInt(desPortField.getText());
						connectInfoArea.append("\n"+ sdf.format(new Date()) +
								"\nMy port is: "+ localPort +
								"\nDestination IP address: "+ desIp +
								"\nDestination Port: "+ desPort +
								"\nStatus: Connected" +
								"\n");
						connect = true;
						connectDialog.setVisible(false);
						threadRece = new Thread(receShowData);
						threadRece.start();
					}
					resetTextField(srcPortField);
					resetTextField(desIpField);
					resetTextField(desPortField);
				} else {
					connectInfoArea.append("\n"+ sdf.format(new Date()) +
							"\nYou have already connected with "+ desIp +
							"\n");
					connectDialog.setVisible(false);
					resetTextField(srcPortField);
					resetTextField(desIpField);
					resetTextField(desPortField);
				}
			}
		});
		
	}
	
	private void cancelButtonInit() {
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetTextField(srcPortField);
				resetTextField(desIpField);
				resetTextField(desPortField);
				connectDialog.setVisible(false);
			}
		});
	}
	
	private void wrongInputWarningInit() {
		Label wrongInputWarningLabel = new Label(
				"Please enter the right destination IP address and Port");
		
		wrongInputWarning.setBounds(825, 450, 350, 120);
		wrongInputWarning.setLayout(FLOWLAYOUT);
		wrongInputWarning.add(wrongInputWarningLabel);
		wrongInputWarning.add(closeWarningButton);
		
		wrongInputWarning.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				wrongInputWarning.setVisible(false);
			}
		});
		
		closeWarningButtonInit();
	}
	
	private void closeWarningButtonInit() {
		closeWarningButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wrongInputWarning.setVisible(false);
			}
		});
	}

	private void disconnecDialogInit() {
		disconnectDialog.setBounds(825, 450, 250, 120);
		disconnectDialog.setLayout(FLOWLAYOUT);

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
		disconnectDialogConfirmInit();
		disconnectDialogCancelInit();
		
	}
	
	private void disconnectDialogConfirmInit() {
		disconnectDialogConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(connect) {
					connectInfoArea.append("\n"+ sdf.format(new Date()) +
							"\nDisconnected from "+ desIp +
							"\n");
					desIp = "";
					desPort = 0;
					threadSend.interrupt();
					threadRece.interrupt();
					connect = false;
					disconnectDialog.setVisible(false);
				} else {
					connectInfoArea.append("\n"+ sdf.format(new Date()) +
							"\nYou have no connection " +
							"\n");
					disconnectDialog.setVisible(false);
				}
			}
		});
	}
	
	private void disconnectDialogCancelInit() {
		disconnectDialogCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disconnectDialog.setVisible(false);
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
		inputButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data = inputField.getText();
				if(!(data.equals(null) || data.isEmpty())) {
					chatArea.append("\n");
					chatArea.append(sdf.format(new Date()) +
							"\nSend: "+ data);
					chatArea.append("\n");
					sendData.setDesIp(desIp);
					sendData.setDesPort(desPort);
					sendData.setData(data.getBytes());
					threadSend = new Thread(sendData);
					threadSend.start();
					resetTextField(inputField);
				}
			}
		});
	}
	
	private void showThreadInfo(Exception e) {
		connectInfoArea.append("\n"+ sdf.format(new Date()) +
				"\n"+ e.getMessage() +
				"\n");
	}
	
	private void resetTextField(TextField tf) {
		tf.getText();
		tf.setText("");
	}
	
	class ReceShowData implements Runnable{
		private Receive receData;

		public void run() {
			while(true) {
				try {
					receData = new Receive(localPort);
					receData.rece();
				} catch (IOException e) {
					showThreadInfo(e);
				}
				chatArea.append("\n");
				chatArea.append(sdf.format(new Date()) +
						"\n"+ receData.getSrcName() +": "+ receData.getData());
				chatArea.append("\n");
			}
		}
	}
	
	ChatRoom() {
		init();
	}
	
	public static void main(String[] args) {
		new ChatRoom();
	}
}
