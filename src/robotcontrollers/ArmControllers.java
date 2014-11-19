/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotcontrollers;

/**
 *
 * @author junxnhe
 */
public class ArmControllers extends RobotControllers {

    String type = "Arm";
    String target="shoulder"; //set target between shoulder, elbow, wrist
                              //future: maybe 0, 1, 2
    boolean crow = false;
    boolean rotation = true;
    String Movement = "stop"; //future: 0 for stop 1 for forward 2 for backward
    String Rotation = "stop"; //future: 0 for stop 1 for left, 2 for right

    public ArmControllers(int avoidIndex) {
        super(avoidIndex);
    }
    
    public boolean setArmControllers(){
        return super.searchForControllers();
    }
    
    public String getArmData()throws NullPointerException{
        super.getData();
        jointSwitch();
        crow=buttons[0];
        getMovement();
        if (rotation) {
            getRotation();
        }
        return 1+" "+target+" "+Movement+" "+Rotation+" "+crow;
    }

    //shoulder, elbow, wrist
    //switch from shoulder, elbow, wrist
    private void jointSwitch() {
        if (buttons[4] || buttons[5] || buttons[6]) {
            if (buttons[4]) {
                target="shoulder";
                rotation = true;
            } else if (buttons[5]) {
                target="elbow";
                rotation = false;
            } else {
                target="wrist";
                rotation = true;
            }
            Movement = "stop";
            Rotation = "stop";
        }
    }

    private void getMovement() {
        int y = -(int) (yAxis * 1000);
        if (y == 0) {
            Movement = "stop";
        } else if (y > 0) {
            Movement = "forward";
        } else {
            Movement = "backward";
        }
    }

    private void getRotation() {
        int z = (int) (zRotation * 1000);
        if (z == 0) {
            Rotation = "stop";
        } else if (z > 0) {
            Rotation = "right";
        } else {
            Rotation = "left";
        }
    }
}
