package communication;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import robotcontrollers.ArmControllers;
import robotcontrollers.MotorControllers;
import userpc.RoverGUI;

/**
 * Creates a server to send camera and joystick data
 * to the Rover client
 * @author Jun,Ed,Matt,Dan,Dakota,Zhen
 */
public class UserServer implements Runnable {

    RoverGUI gui;
    MotorControllers mc;
    ArmControllers ac;
    Socket socket = null;
    ServerSocket listener = null;
    private PrintWriter out;

    public UserServer(RoverGUI gui, MotorControllers mc, ArmControllers ac) {
        this.gui = gui;
        this.mc = mc;
        this.ac = ac;
        try {
            listener = new ServerSocket(9090);
        } catch (IOException ex) {
            gui.display("Unable to start server!");
        }
    }

    /**
     * Starts the server and sends data constantly
     */
    @Override
    public void run() {
        try {
            socket = listener.accept();
            gui.display("Client accepted");
            out =new PrintWriter(socket.getOutputStream(), true);
            while(true){
                out.println(mc.getMotorData());
                out.println(ac.getArmData());
                out.println(gui.getcamData());
                Thread.sleep(100);
            }
        } catch (IOException ex) {
            gui.display("Unable to accept client!");
        } catch (InterruptedException ex) {
            Logger.getLogger(UserServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
