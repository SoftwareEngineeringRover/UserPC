/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.util.Base64;

import javax.swing.JOptionPane;
import sun.misc.BASE64Decoder;
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
    BufferedReader input;
    String info = "";
    BASE64Decoder decoder = new BASE64Decoder();
    BufferedImage img;
    
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
                gui.display("Wait for server...");
            } catch (UnknownHostException ex) {
                gui.display("Un known Host Exception Occur...");
            } catch (IOException ex) {
                Logger.getLogger(UserClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        while(true){
            try {
                info="";
                //BufferedImage io = ImageIO.read(ImageIO.createImageInputStream(s.getInputStream()));
                input =new BufferedReader(new InputStreamReader(s.getInputStream()));
               DataInputStream inning = new DataInputStream(s.getInputStream());
               InputStream instuff = s.getInputStream();
               while(1==1)
               {
                   int available = instuff.available();
                   //System.out.println(available);
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
               
//                boolean done = false;
//                while (!done)
//                { String s = input.readLine();
//                
//                   //byte[] bytes = decoder.decode(s);
//                    info = info + s;
//                    //System.out.println(s);
//                    if(s.equals(""))
//                        done = true;
//                }
//   
//                if (info != null && !info.equals(""))
//                {
//                    byte[] b = decoder.decodeBuffer(info);
//                    BufferedImage bImage;
//                    ByteArrayInputStream in = new ByteArrayInputStream(b);
//                    bImage = ImageIO.read(in);
//                    if (bImage != null){
//                        gui.setIcons(bImage,bImage);
//                    }
//                info = "";
//                }
//                //System.out.println(input.readLine());
            } catch (IOException ex) {
                Logger.getLogger(UserClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
