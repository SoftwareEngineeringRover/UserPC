/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import java.io.IOException;
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
    Socket socket = null;
    ServerSocket listener = null;
    private PrintWriter out;

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
            socket = listener.accept();
            gui.display("Client accept");
            out =new PrintWriter(socket.getOutputStream(), true);
            while(true){
                out.println(mc.getMotorData());
                out.println(ac.getArmData());
                Thread.sleep(100);
            }
        } catch (IOException ex) {
            gui.display("Unable to accept client!");
        } catch (InterruptedException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
