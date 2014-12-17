package robotcontrollers;

/**
 * Grabs motor controller data from the joystick
 * @author Jun
 */
public class MotorControllers extends RobotControllers {

    String type = "Motor";
    int speed = 0;
    int degree;
    int maxSpeed = -200;

    public MotorControllers(int avoidIndex) {
        super(avoidIndex);
    }

    /**
     * Gets motor data from this class to send out for other 
     * classes to see
     * @return
     * @throws NullPointerException 
     */
    public String getMotorData() throws NullPointerException {
        super.getData();
        setSpeed();
        setRotation();
        return 0 + " " + speed + " " + degree;
    }

    /**
     * Gets the speed to send to robot
     */
    private void setSpeed() {
        speed = (int) (zAxis * maxSpeed);
    }

    /**
     * gets the rotation to send to robot
     */
    private void setRotation() {
        degree = (int) Math.toDegrees(Math.atan2(-yAxis, xAxis));
        if (degree < -90) {
            degree += 270;
        } else {
            degree -= 90;
        }
    }
}
