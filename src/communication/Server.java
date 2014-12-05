/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import robotcontrollers.ArmControllers;
import robotcontrollers.MotorControllers;
import userpc.RoverGUI;

/**
 *
 * @author junxin
 */
public class Server implements Runnable {

    RoverGUI gui;
    MotorControllers mc;
    ArmControllers ac;
    Socket socket1 = null;
    Socket socket2 = null;
    ServerSocket listener = null;
    private Thread thread = null;

    public Server(RoverGUI gui, MotorControllers mc, ArmControllers ac) {
        this.gui = gui;
        this.mc = mc;
        this.ac = ac;
        try {
            listener = new ServerSocket(9090);
        } catch (IOException ex) {
            gui.display("Unable to start server!");
        }
    }

    @Override
    public void run() {
        try {
            socket1 = listener.accept();
            gui.display("Client 1 accept");
            socket2 = listener.accept();
            gui.display("Client 2 accept");
        } catch (IOException ex) {
            gui.display("Unable to accept client!");
            return;
        }
    }

    class Client extends Thread {

        Socket socket;
        private ObjectInputStream in;
        private ObjectOutputStream out;

        public Client(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            while (thread != null) {
                //out.println(mc.getMotorData());
                //out.println(ac.getArmData());
                try {
                    in = new ObjectInputStream(socket.getInputStream());
                    out = new ObjectOutputStream(socket.getOutputStream());
                    gui.display(in.readObject().toString());
                    out.writeObject("hi");
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
