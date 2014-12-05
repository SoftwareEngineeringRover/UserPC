/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

/**
 *
 * @author junxin
 */
import java.net.*;
import java.io.*;

public class ChatServer implements Runnable {

    private Socket socket = null;
    private ServerSocket server = null;
    private Thread thread = null;
    private DataInputStream streamIn = null;
    PrintWriter out = null;

    public ChatServer(int port) {
        try {
            System.out.println("Binding to port " + port + ", please wait  ...");
            server = new ServerSocket(port);
            System.out.println("Server started: " + server);
            start();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public void run() {
        while (thread != null) {
            try {
                System.out.println("Waiting for a client ...");
                socket = server.accept();
                System.out.println("Client accepted: " + socket);
                open();
                boolean done = false;
                while (!done) {
                    out();
                    in();
                }
                close();
            } catch (IOException ie) {
                System.out.println("Acceptance Error: " + ie);
            }
        }
    }

    synchronized void out() {
        out.println("ln");
    }

    synchronized void in() throws IOException {
        String line = streamIn.readUTF();
        System.out.println(line);
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public void stop() {
        if (thread != null) {
            thread.stop();
            thread = null;
        }
    }

    public void open() throws IOException {
        streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void close() throws IOException {
        if (socket != null) {
            socket.close();
        }
        if (streamIn != null) {
            streamIn.close();
        }
    }

    public static void main(String args[]) {
        ChatServer server = null;
        server = new ChatServer(9090);
    }
}
