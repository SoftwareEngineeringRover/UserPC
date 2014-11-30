
package rover.gui;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Matt
 */
public class RoverGUI {

    private JFrame f; //The window
    private JPanel p; //Stuff inside the window(Its a div essentially)
    private JPanel pCameras;
    private JPanel pPanCamera;
    private JPanel buttonsLeft;
    private JPanel buttonsRight;
    
    
    private JLabel camera1;
    private JLabel camera2;
    private JLabel systemData;
    
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
    }
    
    public void gui() {
        
        
        f = new JFrame("Rover");
        f.setVisible(true);
        f.setSize(1000, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allows you to close the GUI.
        
        p = new JPanel(new GridBagLayout());
        pCameras = new JPanel(new GridBagLayout());
        pPanCamera = new JPanel(new GridBagLayout());
        
        buttonsLeft = new JPanel();
        BoxLayout vertButtonsLeft = new BoxLayout(buttonsLeft,BoxLayout.Y_AXIS);
        buttonsLeft.setLayout(vertButtonsLeft);
        buttonsRight = new JPanel();
        BoxLayout vertButtonsRight = new BoxLayout(buttonsRight,BoxLayout.Y_AXIS);
        buttonsRight.setLayout(vertButtonsRight);
        
        GridBagConstraints c = new GridBagConstraints();//GridBagConstraint is a specific way of arranging the objects in java.
        c.fill = GridBagConstraints.HORIZONTAL;
        c.fill = GridBagConstraints.VERTICAL;
        
        connect = new JButton("Connect");
        disConnect = new JButton("Disconnect");
        cameraR = new JButton(">>");
        cameraL = new JButton("<<");
        lab = new JLabel("Status: " + connected);
        camera1 = new JLabel("Camera 1");
        camera1.setBackground(Color.red);
        camera1.setOpaque(true); //Make the background color show up.
        camera2= new JLabel("Camera 2");
        camera2.setBackground(Color.red);
        camera2.setOpaque(true);
        systemData = new JLabel("System Information..."); //Change the string here for system information.
        
        
        buttonsLeft.add(Box.createVerticalStrut(5));
        buttonsRight.add(Box.createVerticalStrut(5));
        int boxStrutSize = 35;
        for(int i=0;i<16;i++)
        {
        	String buttonString = "Camera "+ ((i % 8) + 1);
        	JButton aButton = new JButton(buttonString);
        	if(i<8)
        	{
        	 buttonsLeft.add(aButton);
        	 buttonsLeft.add(Box.createVerticalStrut(boxStrutSize));
        	}
        	else
        	{
        	 buttonsRight.add(aButton);
        	 buttonsRight.add(Box.createVerticalStrut(boxStrutSize));
        	}
        }
        
        
        
        connect.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
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
        
        
                
        //Add button & label to panel; add panel to frame.
        c.insets = new Insets(10,10,10,10);//makes buttons have margins(top, left, right, bottom)
        
        c.gridx = 0;
        c.gridy = 0;
        p.add(systemData, c);
        
        c.gridx = 1; //Set the x axis for the object
        c.gridy = 0; //Set the y axis for the object
        p.add(connect, c);
        
        c.gridx = 2; //Set the x axis for the object
        c.gridy = 0; //Set the y axis for the object
        p.add(disConnect, c);
        
        c.gridx = 0; //Set the x axis for the object
        c.gridy = 0; //Set the y axis for the object
        pPanCamera.add(cameraL, c);
        
        c.gridx = 1; //Set the x axis for the object
        c.gridy = 0; //Set the y axis for the object
        pPanCamera.add(cameraR, c);
        
        c.gridx = 3;
        c.gridy = 0;
        p.add(lab, c);
                        
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;

        pCameras.add(camera1, c);
                
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        
        pCameras.add(camera2, c);


        f.add(p,BorderLayout.NORTH);
        f.add(pPanCamera, BorderLayout.SOUTH);
        f.add(pCameras, BorderLayout.CENTER);


    }
    
}
