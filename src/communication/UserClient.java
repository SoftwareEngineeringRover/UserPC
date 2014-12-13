package communication;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
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
    
    /**
     * Starts the client which constantly receives camera data from
     * the rover server.  Image accepted as bytes and displayed in GUI
     */
    @Override
    public void run(){
        while (!done) {
            try {
                if (serverAddress.equals("")) {
                    throw new UnknownHostException();
                }
                s = new Socket(serverAddress, 9090);
                done = true;
            } catch (ConnectException e) {
                gui.display("Waiting for server...");
            } catch (UnknownHostException ex) {
                gui.display("An Unknown Host Exception has occurred...");
            } catch (IOException ex) {
                Logger.getLogger(UserClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        while(true){
            try {
               DataInputStream inning = new DataInputStream(s.getInputStream());
               InputStream instuff = s.getInputStream();
               while(1==1)
               {
                   int available = instuff.available();
                   if(available>0)
                   {
                       short cameraNum = inning.readShort();
                       int len = inning.readInt();
                 
                       byte[] bytes = new byte[len];
                       for(int i=0;i<len;i++)
                       {
                          bytes[i] = inning.readByte();
                       }
                        BufferedImage bImage;
                    ByteArrayInputStream in = new ByteArrayInputStream(bytes);
                    bImage = ImageIO.read(in);
                    if(cameraNum==0)
                    {  gui.setIcons(bImage,null);}
                    else
                    { gui.setIcons(null,bImage);}
                    
                   }
               }
               
            } catch (IOException ex) {
                Logger.getLogger(UserClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
