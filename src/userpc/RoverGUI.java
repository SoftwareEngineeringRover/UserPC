
package userpc;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Matt
 */
public class RoverGUI extends javax.swing.JFrame{

    private JFrame f; //The window
    private JPanel p; //Stuff inside the window(Its a div essentially)
    private JPanel pCameras;
    private JPanel pPanCamera;
    private JButton connect;
    private JButton disConnect;
    private JButton cameraR;
    private JButton cameraL;

    private JLabel lab;
    
    String connected = "Inactive";
    
    public RoverGUI() {
        gui();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new RoverGUI();
       /* String fn = JOptionPane.showInputDialog("Enter first number"); //Entered number is stored in string fn.
        
        JOptionPane.showMessageDialog(null, "The answer is " + fn, "The title",""); //p(position on screen, null = center, message, title bar)
        // TODO code application logic here*/
    }
    
    public void gui() {
        
        
        f = new JFrame("Rover");
        f.setVisible(true);
        f.setSize(600, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allows you to close the GUI.
        
        p = new JPanel(new GridBagLayout());
        pCameras = new JPanel(new GridBagLayout());
        pPanCamera = new JPanel(new GridBagLayout());
        pCameras = new JPanel(new GridBagLayout());
        pCameras.setBackground(Color.YELLOW);
        
        GridBagConstraints c = new GridBagConstraints();//GridBagConstraint is a specific way of arranging the objects in java.
        
        connect = new JButton("Connect");
        disConnect = new JButton("Disconnect");
        cameraR = new JButton(">>");
        cameraL = new JButton("<<");
        
        connect.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "connect");
                connected = "Active";
                lab.setText("Status: " + connected);
            }
        });
        
        disConnect.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "disConnect");
                connected = "Inactive";
                lab.setText("Status: " + connected);
     
            }
        });
        
        cameraR.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Right");
            }
        });
        
        cameraL.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Left");
            }
        });
        
       lab = new JLabel("Status: " + connected);
                
        //Add button & label to panel; add panel to frame.
        c.insets = new Insets(10,10,10,10);//makes buttons have margins(top, left, right, bottom)
        
        c.gridx = 0; //Set the x axis for the object
        c.gridy = 2; //Set the y axis for the object
        p.add(disConnect, c);
        
        c.gridx = 0; //Set the x axis for the object
        c.gridy = 1; //Set the y axis for the object
        p.add(connect, c);
        
        c.gridx = 0; //Set the x axis for the object
        c.gridy = 0; //Set the y axis for the object
        pPanCamera.add(cameraL, c);
        
        c.gridx = 10; //Set the x axis for the object
        c.gridy = 0; //Set the y axis for the object
        pPanCamera.add(cameraR, c);
        
        c.gridx = 0;
        c.gridy = 5;
        p.add(lab, c);
                        
        f.add(p,BorderLayout.WEST);
        f.add(pPanCamera, BorderLayout.SOUTH);
        f.add(pCameras, BorderLayout.CENTER);
    }
    
}
