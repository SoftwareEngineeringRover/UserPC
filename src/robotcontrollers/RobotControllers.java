/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotcontrollers;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

/**
 *
 * @author junxnhe
 */
public class RobotControllers {

    Controller joystick;
    int joystickIndex = -1;
    int avoidIndex = -1;
    boolean[] buttons;  //0-11 buttons 12 hat switch 
    float xAxis;       //right stick x Axis
    float yAxis;       //right stick y Axis
    float slider;      //left handle front key left -1, normal approxial 0, right 1
    float zRotation;   //right stick rotate
    float zAxis;       //left handle front -1, normal approxial 0, back 1

//    public static void main(String[] args) {
//        MotorControllers ms = new MotorControllers(-1);
//        //ArmControllers as = new ArmControllers(ms.getIndex());
//        //ArmControllers as = new ArmControllers(-1);
//        //while(!ms.isEmpty()&&!as.isEmpty()){
//        while (true) {
//            System.out.println(ms.getMotorData());
//        }
//    }

    public RobotControllers(int avoidIndex) {
        this.avoidIndex = avoidIndex;
        buttons = new boolean[13];
    }

    //search controller
    protected boolean searchForControllers() {
        //collect ports infor
        Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
        for (int i = 0; i < controllers.length && joystickIndex == -1; i++) {
            //check any port has joystick
            if (controllers[i].getType() == Controller.Type.STICK && i != avoidIndex) {
                joystick = controllers[i];//assign joystick
                joystickIndex = i;//assign index
            }
        }
        return isEmpty();
    }
    
    public void setAvoidIndex(int index) {
        avoidIndex = index;
    }

    //get port index
    public int getIndex() {
        return joystickIndex;
    }

    //check if joystick is empty
    public boolean isEmpty() {
        return joystickIndex != -1;
    }

    //get input from joystick
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
        
        //System.out.println(xAxis);
    }
}
