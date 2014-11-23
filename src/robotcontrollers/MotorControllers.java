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
public class MotorControllers extends RobotControllers {

    String type = "Motor";
    int speed = 0;
    int degree;
    int maxSpeed = -200;

    public static void main(String[] args) {
        MotorControllers ms = new MotorControllers(-1);
        if (ms.searchForControllers()) {
            while (true) {
                System.out.println(ms.getMotorData());
            }
        }else{
            System.out.println("Unable to connect joystick, make sure there has joy stick available");
        }
    }

    public MotorControllers(int avoidIndex) {
        super(avoidIndex);
    }

    public String getMotorData() throws NullPointerException {
        super.getData();
        getSpeed();
        getRotation();
        return 0 + " " + speed + " " + degree;
    }

    private void getSpeed() {
        speed = (int) (zAxis * maxSpeed);
        //send to robot
    }

    private void getRotation() {
        degree = (int) Math.toDegrees(Math.atan2(-yAxis, xAxis));
        if (degree < -90) {
            degree += 270;
        } else {
            degree -= 90;
        }
        //send to robot
    }
}
