
package rover.gui;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Matt Ng
 */
public class RoverGUI implements KeyListener{

    int selected = 1; //which camera is currently selected.
    
    private JFrame f; //The window
    private JPanel p; //Stuff inside the window(Its a div essentially)
    private JPanel pCameras;
    private JPanel pPanCamera;
    
    private JButton cameraLabel1;
    private JButton cameraLabel2;
    private JLabel systemData;
    
    private JButton connect;
    private JButton disConnect;
    private JButton cameraR;
    private JButton cameraL;
    private JButton camera1;
    private JButton camera2;
    private JButton camera3;
    private JButton camera4;
    private JButton camera5;
    private JButton camera6;
    private JButton camera7;
    private JButton camera8;

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
    
    public void keyReleased(KeyEvent e) {
        
            }

            public void keyTyped(KeyEvent e) {

            }

                    //Called whenever a keyboard button is pressed.
            public void keyPressed(KeyEvent e) { //e is the button pressed.
                int keyCode = e.getKeyCode(); //which key was pressed?
                    if(keyCode == KeyEvent.VK_1) //If 1 is pressed...
                        if(selected == 1)
                                cameraLabel1.setText("Camera 1");
                            else
                                cameraLabel2.setText("Camera 1");
                    if(keyCode == KeyEvent.VK_2) //If 1 is pressed...
                        if(selected == 1)
                                cameraLabel1.setText("Camera 2");
                            else
                                cameraLabel2.setText("Camera 2");
                    if(keyCode == KeyEvent.VK_3) //If 1 is pressed...
                        if(selected == 1)
                                cameraLabel1.setText("Camera 3");
                            else
                                cameraLabel2.setText("Camera 3");
                    if(keyCode == KeyEvent.VK_4) //If 1 is pressed...
                        if(selected == 1)
                                cameraLabel1.setText("Camera 4");
                            else
                                cameraLabel2.setText("Camera 4");
                    if(keyCode == KeyEvent.VK_5) //If 1 is pressed...
                        if(selected == 1)
                                cameraLabel1.setText("Camera 5");
                            else
                                cameraLabel2.setText("Camera 5");
                    if(keyCode == KeyEvent.VK_6) //If 1 is pressed...
                        if(selected == 1)
                                cameraLabel1.setText("Camera 6");
                            else
                                cameraLabel2.setText("Camera 6");
                    if(keyCode == KeyEvent.VK_7) //If 1 is pressed...
                        if(selected == 1)
                                cameraLabel1.setText("Camera 7");
                            else
                                cameraLabel2.setText("Camera 7");
                    if(keyCode == KeyEvent.VK_8) //If 1 is pressed...
                        if(selected == 1)
                                cameraLabel1.setText("Camera 8");
                            else
                                cameraLabel2.setText("Camera 8");
                
                e.consume(); //Does not wait for button combinations(shift, alt, cntrl, etc...)
            }
    
    public void gui() {
        
        f = new JFrame("Rover");
        f.setVisible(true);
        f.setSize(600, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allows you to close the GUI.
        f.setFocusable(true); //Allows it to listen to keyboard events
        f.addKeyListener(this);
        
        p = new JPanel(new GridBagLayout());
        pCameras = new JPanel(new GridBagLayout());
        pPanCamera = new JPanel(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();//GridBagConstraint is a specific way of arranging the objects in java.
        c.fill = GridBagConstraints.HORIZONTAL;
        c.fill = GridBagConstraints.VERTICAL;
        
        connect = new JButton("Connect");
        disConnect = new JButton("Disconnect");
        cameraR = new JButton(">>");
        cameraL = new JButton("<<");
        
        camera1 = new JButton("Camera 1");
        camera2 = new JButton("Camera 2");
        camera3 = new JButton("Camera 3");
        camera4 = new JButton("Camera 4");
        camera5 = new JButton("Camera 5");
        camera6 = new JButton("Camera 6");
        camera7 = new JButton("Camera 7");
        camera8 = new JButton("Camera 8");
        
        lab = new JLabel("Status: " + connected);
        lab.setForeground(Color.red);
        
        cameraLabel1 = new JButton("Camera 1");
        cameraLabel1.setBackground(Color.blue);
        cameraLabel1.setFocusable(true);
        //cameraLabel1.setOpaque(true); //Make the background color show up.
        
        cameraLabel2= new JButton("Camera 2");
        cameraLabel2.setBackground(Color.blue);
        cameraLabel2.setFocusable(true); //Allows it to listen to keyboard events
        //cameraLabel2.setOpaque(true);
        
        systemData = new JLabel("System Information..."); //Change the string here for system information.
        systemData.setBackground(Color.white);
        systemData.setOpaque(true);
        
        cameraLabel1.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                cameraLabel1.setBackground(Color.green);
                cameraLabel2.setBackground(Color.BLUE);
                selected = 1;
                f.requestFocusInWindow(); //Whenever a button is pressed we need to refocus on the frame
                                         //so that the frame can recieve key strokes.  Key binding would be the better approach.
            }
        });
        
        cameraLabel2.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                cameraLabel2.setBackground(Color.green);
                cameraLabel1.setBackground(Color.BLUE);
                selected = 2;
                f.requestFocusInWindow();
            }
        });
                
        connect.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                connected = "Active";
                lab.setText("Status: " + connected);
                lab.setForeground(Color.GREEN);
                f.requestFocusInWindow();
            }
        });
        
        disConnect.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "disConnect");
                connected = "Inactive";
                lab.setText("Status: " + connected);
                lab.setForeground(Color.red);
                f.requestFocusInWindow();
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
        
        camera1.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                f.requestFocusInWindow();
                if(selected == 1)
                    cameraLabel1.setText("Camera 1");
                else
                    cameraLabel2.setText("Camera 1");
            }
        });
                
        camera2.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                f.requestFocusInWindow();
                if(selected == 1)
                    cameraLabel1.setText("Camera 2");
                else
                    cameraLabel2.setText("Camera 2");
            }
        });
                        
        camera3.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                f.requestFocusInWindow();
                if(selected == 1)
                    cameraLabel1.setText("Camera 3");
                else
                    cameraLabel2.setText("Camera 3");
            }
        });
                                
        camera4.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                f.requestFocusInWindow();
                if(selected == 1)
                    cameraLabel1.setText("Camera 4");
                else
                    cameraLabel2.setText("Camera 4");
            }
        });
                                        
        camera5.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                f.requestFocusInWindow();
                if(selected == 1)
                    cameraLabel1.setText("Camera 5");
                else
                    cameraLabel2.setText("Camera 5");
            }
        });
                                                
        camera6.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                f.requestFocusInWindow();
                if(selected == 1)
                    cameraLabel1.setText("Camera 6");
                else
                    cameraLabel2.setText("Camera 6");
            }
        });
                                                        
        camera7.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                f.requestFocusInWindow();
                if(selected == 1)
                    cameraLabel1.setText("Camera 7");
                else
                    cameraLabel2.setText("Camera 7");
            }
        });
                                                                
        camera8.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                f.requestFocusInWindow();
                if(selected == 1)
                    cameraLabel1.setText("Camera 8");
                else
                    cameraLabel2.setText("Camera 8");
            }
        });
                                                                       
        //Add button & label to panel; add panel to frame.
        c.insets = new Insets(10,10,10,10);//makes buttons have margins(top, left, right, bottom)
        

        
        c.gridx = 1; //Set the x axis for the object
        c.gridy = 0; //Set the y axis for the object
        p.add(connect, c);
        
        c.gridx = 2; //Set the x axis for the object
        c.gridy = 0; //Set the y axis for the object
        p.add(disConnect, c);
        
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        //c.fill = GridBagConstraints.horizontal;
        p.add(systemData, c);
        
        c.gridy = 0;
        c.gridx = 0;
        pPanCamera.add(camera1, c);
        c.gridx = 1;
        pPanCamera.add(camera2, c);
        c.gridx = 2;
        pPanCamera.add(camera3, c);
        c.gridx = 3;
        pPanCamera.add(camera4, c);
        c.gridx = 4;
        pPanCamera.add(camera5, c);
        c.gridx = 5;
        pPanCamera.add(camera6, c);
        c.gridx = 6;
        pPanCamera.add(camera7, c);
        c.gridx = 7;
        pPanCamera.add(camera8, c);

        
        /*c.gridx = 0; //Set the x axis for the object
        c.gridy = 0; //Set the y axis for the object
        pPanCamera.add(cameraL, c);
        
        c.gridx = 1; //Set the x axis for the object
        c.gridy = 0; //Set the y axis for the object
        pPanCamera.add(cameraR, c);*/
        
        c.gridx = 3;
        c.gridy = 0;
        p.add(lab, c);
                        
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;

        pCameras.add(cameraLabel1, c);
                
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        
        pCameras.add(cameraLabel2, c);


        f.add(p,BorderLayout.NORTH);
        f.add(pPanCamera, BorderLayout.SOUTH);
        f.add(pCameras, BorderLayout.CENTER);


    }
    
}
