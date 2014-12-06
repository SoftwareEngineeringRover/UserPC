/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.JOptionPane;
import userpc.RoverGUI;

/**
 * A simple Swing-based client for the capitalization server. It has a main
 * frame window with a text field for entering strings and a textarea to see the
 * results of capitalizing them.
 */
public class UserClient extends Thread{

    //ObjectInputStream input;
    Socket s = null;
    boolean done = false;
    String serverAddress;
    RoverGUI gui;

    public static void main(String[] args){
        String serverAddress = JOptionPane.showInputDialog(
                "Enter IP Address of a machine that is\n"
                + "running the date service on port 9090:");
        try {
            UserClient c = new UserClient(null, serverAddress);
        } catch (IOException ex) {
            Logger.getLogger(UserClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public UserClient(RoverGUI gui, String serverAddress) throws UnknownHostException, IOException{
        this.gui=gui;
        this.serverAddress=serverAddress;
    }
    
    @Override
    public void run(){
        while (!done) {
            try {
                if (serverAddress.equals("")) {
                    throw new UnknownHostException();
                }
                s = new Socket(serverAddress, 9090);
                //input =new ObjectInputStream(s.getInputStream());
                done = true;
            } catch (ConnectException e) {
                gui.display("Wait for servor...");
            } catch (UnknownHostException ex) {
                gui.display("Un known Host Exception Occur...");
            } catch (IOException ex) {
                Logger.getLogger(UserClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        while(true){
            try {
                gui.setIcons(ImageIO.read(ImageIO.createImageInputStream(s.getInputStream())),null);
                //System.out.println(input.readLine());
            } catch (IOException ex) {
                Logger.getLogger(UserClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void close() throws IOException {
        //input.close();
        s.close();
    }
}
