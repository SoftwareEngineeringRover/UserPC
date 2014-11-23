/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.BindException;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author junxin
 */
public class Sever {

    public static void main(String[] args) throws IOException {
        //MotorControllers ms = new MotorControllers(-1);
        int motorData = 1;
        Socket rover = null;
        Socket user = null;
        PrintWriter out = null;
        boolean done = false;
        ServerSocket listener = null;
        try {
            listener = new ServerSocket(9090);
            while (!done) {
                rover = listener.accept();
                if (rover.isConnected()) {
                    done = true;
                }
            }
            done = false;
            new localClient(listener.accept()).start();

        } catch (BindException e) {
        } catch (SocketException e) {
            rover.close();
        } finally {
            System.exit(0);
        }
    }

    //127.0.0.1
    private static class localClient extends Thread {

        private Socket socket;

        public localClient(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                out.println("Enter a line with only a period to quit\n");

                // Get messages from the client, line by line; return them
                // capitalized
                while (true) {
                    String input = in.readLine();
                    if (input == null || input.equals(".")) {
                        break;
                    }
                    out.println(input.toUpperCase());
                }
            } catch (IOException e) {
            } finally {
                try {
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(Sever.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
