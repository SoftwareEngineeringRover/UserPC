package robotcontrollers;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

/**
 * Gets all data from joystick
 * @author Jun
 */
public class RobotControllers {

    Controller joystick;
    Controller[] controllers;
    int joystickIndex = -1;
    int avoidIndex = -1;
    boolean[] buttons;  //0-11 buttons 12 hat switch 
    float xAxis;       //right stick x Axis
    float yAxis;       //right stick y Axis
    float slider;      //left handle front key left -1, normal approxial 0, right 1
    float zRotation;   //right stick rotate
    float zAxis;       //left handle front -1, normal approxial 0, back 1

    public RobotControllers(int avoidIndex) {
        this.avoidIndex = avoidIndex;
        buttons = new boolean[13];
    }

    /**
     * Searches for joystick(s) and connects to it/them
     * @return 
     */
    public boolean searchForControllers() {
        //collect ports infor
        controllers = null;
        controllers=ControllerEnvironment.getDefaultEnvironment().getControllers();
                
        for (int i = 0; i < controllers.length && joystickIndex == -1; i++) {
            //check any port has joystick
            if (controllers[i].getType() == Controller.Type.STICK && i != avoidIndex) {
                joystick = controllers[i];//assign joystick
                joystickIndex = i;//assign index
            }
        }
        return isEmpty();
    }
    
    /**
     * Sets the avoidance index
     * @param index 
     */
    public void setAvoidIndex(int index) {
        avoidIndex = index;
    }

    /**
     * Gets the port index
     * @return 
     */
    public int getIndex() {
        return joystickIndex;
    }

    /**
     * Checks if the joystick is empty
     * @return 
     */
    public boolean isEmpty() {
        return joystickIndex != -1;
    }

    /**
     * Gets input from joystick
     * @throws NullPointerException 
     */
    public void getData() throws NullPointerException{
        joystick.poll();
        Component[] components = joystick.getComponents();
        for (int i = 0; i < components.length; i++) {
            float data = components[i].getPollData();
            switch (components[i].getName()) {
                case "X Axis":
                    xAxis = data;
                    break;
                case "Y Axis":
                    yAxis = data;
                    break;
                case "Slider":
                    slider = data;
                    break;
                case "Z Rotation":
                    zRotation = data;
                    break;
                case "Z Axis":
                    zAxis = data;
                    break;
                default:
                    if (components[i].getPollData() == 1.0f) {
                        buttons[i] = true;
                    } else {
                        buttons[i] = false;
                    }
            }
        }
        //let system have a little, slow the busy processing
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
