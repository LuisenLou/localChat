package apps;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Server implements Runnable{

	private JFrame frame;
	private JTextField title;
	private JTextArea chatPanel ;

	
	
	public Server() {
        frame = new JFrame("Servidor");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame = new JFrame();
		frame.setBounds(100, 100, 300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		//Title
		title = new JTextField();
		title.setBounds(95, 11, 74, 20);
		title.setBackground(new Color(192, 192, 192));
		title.setFont(new Font("Arial", Font.BOLD, 14));
		title.setText("SERVER");
		frame.getContentPane().add(title);
		title.setColumns(10);
		
		//Allows scroll chat.
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		scrollPane.setBounds(21, 52, 242, 237);
		frame.getContentPane().add(scrollPane);
		
		
		//Chat panel.
		chatPanel = new JTextArea();
		chatPanel.setFont(new Font("Monospaced", Font.PLAIN, 12));
		chatPanel.setBackground(new Color(192, 192, 192));
		scrollPane.setViewportView(chatPanel);
		
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server window = new Server();
					window.frame.setVisible(true);
					
					Thread t = new Thread(window);
					
					t.start();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
		

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try (ServerSocket server = new ServerSocket(3000)) {
			
			while(true) {
				Socket mySocket = server.accept();
				
				DataInputStream data = new DataInputStream(mySocket.getInputStream());
				
				String text = data.readUTF();
				
				chatPanel.append("\n" + text);
				
				mySocket.close();
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
