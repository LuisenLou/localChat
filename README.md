# Basic Java Chat Project

This project implements a simple chat application in Java using sockets. It includes two main programs: a **Client** and a **Server**. The client can send messages to the server, and the server displays these messages in a graphical interface.

## Features

- Basic client-server communication using sockets.
- Graphical user interface built with **JFrame**, **JTextArea**, and **JTextField**.
- The client can send messages to the server, and they are displayed in real-time in the server window.

## Technologies Used

- **Java**: for developing the client and server programs.
- **Swing**: for creating the graphical user interface (GUI).

## Project Structure

    ```plaintext
    ├── src
    │   └── apps
    │       ├── Client.java        # Client source code
    │       └── Server.java        # Server source code
    └── README.md                  # Project documentation


## Running the Project

### Prerequisites

- **Java**: Ensure Java is installed on your system to compile and run the project.
- **Git**: Optional, if you want to clone the project repository.

## Troubleshooting

If you encounter issues while running or compiling the project, here are some common problems and their solutions:

### 1. **Connection Issues**

- **Problem**: The client cannot connect to the server, or it throws an exception when trying to send a message.
- **Solution**: Ensure that the server is running before launching the client. The server must be listening on the correct port (default is port 3000).
  - Make sure both the server and client are using the same port number. You can change the port number in both `Server.java` and `Client.java` if needed.
  - If running on different machines, replace `"localhost"` with the IP address of the machine running the server in `Client.java`.

### 2. **Port Conflicts**

- **Problem**: The server throws an error saying the port is already in use.
- **Solution**: Another application may already be using port 3000. To fix this, you can change the port number in both `Server.java` and `Client.java`.
  - Open `Server.java`, find the line where the server socket is created, and change the port number (e.g., from 3000 to 8080 or 5000).
  - Update `Client.java` to use the new port number.

### 3. **Class Not Found or Compilation Errors**

- **Problem**: You see an error like `ClassNotFoundException` or compilation errors when trying to run the project.
- **Solution**: Ensure that you have compiled the `.java` files correctly before running the project.
  - Run the following command to compile the Java files:

    ```bash
    javac -d bin src/apps/*.java
    ```

  - Make sure the `bin` directory exists and contains the compiled `.class` files.
  - When running the project, make sure you are specifying the correct classpath, for example:

    ```bash
    java -cp bin apps.Server
    ```

### 4. **Empty Chat Window or No Messages Displayed**

- **Problem**: The chat window does not display any messages, even after sending them.
- **Solution**: Check the following:
  - Ensure that both the server and client are running and connected.
  - Confirm that the message is being sent from the client by checking the client-side console or log.
  - Check for any exceptions or errors in the terminal where the server is running. If there are issues with receiving data, the server might not be processing the message correctly.

### 5. **GUI Not Updating**

- **Problem**: The server's GUI (chat window) is not updating or displaying messages after the client sends them.
- **Solution**:
  - The GUI updates might not be occurring because the server is running on the same thread as the network communication.
  - To fix this, consider using a separate thread to handle the GUI updates. Ensure that the code handling the chat panel updates runs on the Event Dispatch Thread (EDT) by using `SwingUtilities.invokeLater` or similar methods to update the GUI components safely.

### 6. **Socket Timeout Errors**

- **Problem**: The client throws a timeout error when trying to connect to the server.
- **Solution**:
  - Ensure that the server is running and listening on the correct IP address and port.
  - If you're running the client and server on different machines, ensure that the client machine can reach the server machine over the network (check firewall settings, IP address, etc.).
  - Verify that no other applications are using the same port, as this may block the connection.

### 7. **Button or GUI Element Not Responding**

- **Problem**: The "SEND" button or other GUI elements in the client do not respond when clicked.
- **Solution**:
  - Ensure that the event listeners are correctly attached to the GUI elements. For example, in `Client.java`, verify that the `btnSendButton.addActionListener` method is correctly wired to trigger the `sendText` method.
  - Check for any exceptions or errors in the terminal or the IDE that might indicate a problem with the event handling.

If you are still facing issues, feel free to create an issue in the GitHub repository, and we will try to help resolve it.
