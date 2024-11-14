package apps;

import java.net.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.io.DataOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Client {

	private JFrame frame;
	private JTextField title;
	private JTextField chatMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client window = new Client();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Client() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Title
		title = new JTextField();
		title.setBackground(new Color(192, 192, 192));
		title.setFont(new Font("Arial", Font.BOLD, 14));
		title.setText("CLIENT");
		title.setBounds(108, 11, 61, 20);
		frame.getContentPane().add(title);
		title.setColumns(10);

		
		//Chat message 
		chatMessage = new JTextField();
		chatMessage.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		chatMessage.setBackground(new Color(192, 192, 192));
		chatMessage.setBounds(10, 50, 264, 20);
		frame.getContentPane().add(chatMessage);
		chatMessage.setColumns(10);
		
		JButton btnSendButton = new JButton("SEND");
		btnSendButton.setBackground(new Color(192, 192, 192));
		btnSendButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnSendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendText(chatMessage);
				chatMessage.setText("");
			}
		});
		btnSendButton.setBounds(95, 100, 89, 23);
		frame.getContentPane().add(btnSendButton);
	}
	
	
	
	public String sendText(JTextField chatMessage) {
		
		try (Socket mySocket = new Socket("localhost", 3000);
			DataOutputStream data = new DataOutputStream(mySocket.getOutputStream())) {
			
			data.writeUTF("Client: " + chatMessage.getText());
						
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error:" + e.getMessage());
		} finally {
		}
		
		return null;
		
	}
}
