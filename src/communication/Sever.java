/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import robotcontrollers.MotorControllers;

/**
 *
 * @author junxin
 */
public class Sever extends Thread {

    PrintWriter out = null;
    Socket socket = null;
    ServerSocket listener = null;

    public static void main(String[] args) {
        MotorControllers mc = new MotorControllers(-1);
        try {
            Sever s = new Sever();
            if (mc.searchForControllers()) {
                while (true) {
                    s.sendInfo(mc.getMotorData());
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Sever.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Sever() throws IOException {
        listener = new ServerSocket(9090);
        while (socket == null) {
            if (socket == null) {
                socket = listener.accept();
                out = new PrintWriter(socket.getOutputStream(), true);
            }
        }
    }

    public void sendInfo(String message) {
        out.println(message);
    }

    public void close() throws IOException {
        out.close();
        listener.close();
        socket.close();
    }
}
